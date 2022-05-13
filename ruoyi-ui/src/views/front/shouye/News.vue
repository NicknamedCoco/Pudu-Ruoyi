<template>
  <div class="all">
    <H2 style="margin: 100px 0 50px 0;">新闻浏览</H2>
    <div>
      <div style="display: flex;margin-left: 50px">
        <el-input
          placeholder="请输入新闻关键字"
          prefix-icon="el-icon-search"
          v-model="keyword">
        </el-input>
        <el-button type="primary" @click="getNews" style="margin-left: 10px;" round>搜索</el-button>
      </div>
    </div>
    <div style="width: 50%;margin-top: 20px" >
      <ul>
        <li v-for="i in dataList">
          <a :href="i.link" style="">{{i.title}}</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>

import {getNews} from '@/api/front'
export default {
  name: "News",
  data(){
    return {
      keyword: '',
      count:10,
      dataList: [],
    }
  },
  created() {
    this.getNews()
  },
  methods:{
    getNews(){
      this.countAdd=0
      getNews({keyword:this.keyword,maxResult:this.count}).then((res)=>{
        this.dataList=res;
      })

    },
  }
}
</script>

<style scoped>
.all{
  display: flex;
  flex-direction: column;
  align-items: center;
}
ul{
  list-style-type: none;
  overflow: auto;
  padding: 0;
  border: 5px solid #ffffff;
  border-radius: 10px;
  margin: 0 0;
}
li{
  background-color: #7af6f6;
  height: 50px;
  border-bottom: 3px solid #e1f3fb;
  text-align: center;
  padding-top: 15px;
}
li:hover{
  border-bottom: 3px solid #0b96f3;
}




</style>
