
<script setup>
  import {ref, onMounted} from 'vue'
  import {getData} from '../api/index.js'
  const dataSource= ref ([])

         const columns=ref ([
          {
            title: '序号',
            dataIndex: 'xh',
            key: 'xh',
          },
          {
            title: '车型',
            dataIndex: 'cx',
            key: 'cx',
          },
          {
            title: '车牌',
            dataIndex: 'cp',
            key: 'cp',
          },
          {
            title: '进入时间',
            dataIndex: 'rksj',
            key: 'rksj',
          },
          {
            title: '离开时间',
            dataIndex: 'cksj',
            key: 'cksj',
          },
          
          {
            title: '收费站入口',
            dataIndex: 'sfzrkmc',
            key: 'sfzrkmc',
          },
          {
            title: '收费站出口',
            dataIndex: 'sfzckmc',
            key: 'sfzckmc',
          },
          {
            title: '备注',
            dataIndex: 'bz',
            key: 'bz',
          },
        ])
        const getDataList = async (current) => {
          const res = await getData(current)
          dataSource.value = res
          
        }
        const getDataList1 = async () => {
          const res = await getData(1)
          dataSource.value = res
        }
        let i = 2
        
        onMounted( async () => {
          await getDataList1()
          setInterval( async () => {
          await getDataList(i)
          i++
        },5000)
        })
        
</script>

<template>
  <a-table :dataSource="dataSource" :columns="columns" />
</template>

<style scoped>

</style>
