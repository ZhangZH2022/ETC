
<script setup>
  import {ref, onMounted, reactive} from 'vue'
  import {getData1} from '../api/index.js'
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
        const data = reactive({
            cx:null
        })
        const getDataList = async (cx) => {
          const res = await getData1(cx)
          dataSource.value = res
        }       
        onMounted( async () => {
          await getDataList()
          
        })
        const search = async function(){
            const res = await getData1(data.cx,data.sfzrkmc,data.sfzckmc)
            dataSource.value = res
        }
</script>

<template>
<a-row type="flex">
  <a-col :span="6" :order="1">
  <a-button @click='search' style="margin-left:0px">查询</a-button>
  </a-col>
  <a-col :span="6" :order="1"><a-select v-model:value="data.cx" placeholder="请选择车型" 
  :options="options" style="margin-left:-260px">
      <a-select-option value="">全部</a-select-option>
      <a-select-option value="一型车(客)">一型车(客)</a-select-option>
      <a-select-option value="二型车(客)">二型车(客)</a-select-option>
      <a-select-option value="三型车(客)">三型车(客)</a-select-option>
      <a-select-option value="四型车(客)">四型车(客)</a-select-option>
      <a-select-option value="一型车(货)">一型车(货)</a-select-option>
      <a-select-option value="二型车(货)">二型车(货)</a-select-option>
      <a-select-option value="三型车(货)">三型车(货)</a-select-option>
      <a-select-option value="四型车(货)">四型车(货)</a-select-option>
      <a-select-option value="五型车(货)">五型车(货)</a-select-option>
      <a-select-option value="六型车(货)">六型车(货)</a-select-option>
  </a-select> 
  </a-col>
  
    <a-col :span="6" :order="3"><a-input v-model:value="data.sfzrkmc" placeholder="入口筛选"  class="a"/></a-col>
    <a-col :span="6" :order="3"><a-input v-model:value="data.sfzckmc" placeholder="出口筛选"  class="b"/></a-col>
 </a-row>
    
  <a-table :dataSource="dataSource" :columns="columns" />
 
</template>

<style scoped>
  .a {
    width: 120px;
    margin-left:200px;
  }
   .b {
    width: 120px;
    margin-left:30px;
  }
</style>
