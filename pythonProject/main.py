import pymysql,xlrd
import time

# 1、读取本地 Excel 数据集
book = xlrd.open_workbook("D:\Program Files (x86)\Tencent\QQfiles\ETC.xlsx")
sheet = book.sheet_by_name('数据集1')

# 2、连接数据库，创建游标，创建插入语句
db = pymysql.connect(host='localhost', user='root', password='123456', port=8066, db='sz')
cursor = db.cursor()
sql = "INSERT INTO table_m (XH,CKSJ,CX,SFZRKMC,SFZCKMC,RKSJ,BZ,CP) VALUES (%s,%s,%s,%s,%s,%s,%s,%s);"

def insert_info():
    # 3、 for 循环迭代读取xls文件每行数据，跳过标题，从第二行开始
    for r in range(2, 10001):
        temp = sheet.row_values(r)
        CP = temp[0]      # CP
        XH = temp[1]   # XH
        CX = temp[2]     # CX
        SFZCKMC =temp[3] # SFZCKMC
        CKSJ = temp[4]   # CKSJ
        SFZRKMC = temp[5]  # SFZRKMC
        RKSJ = temp[6]  # RKSJ
        BZ = temp[7]  # BZ

        # 4、组装数据（元组格式），执行sql
        data = (XH,CKSJ,CX,SFZRKMC,SFZCKMC,RKSJ,BZ,CP)
        cursor.execute(sql,data)
        db.commit()
        print(temp)
        if (r%50==0):
            time.sleep(1)
    return None

insert_info()