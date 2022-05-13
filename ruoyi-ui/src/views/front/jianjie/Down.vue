<template>
  <div class="all">
    <H2>医院历史</H2>
    <div class="block" style="width: 400px;margin-top: 10px">
      <el-timeline>
        <el-timeline-item v-show="!(articles==null)" :key="item.id" v-for="(item,index) in articles" :timestamp="item.time" placement="top">
          <el-card>
            <h4 style="font-size: 18px;margin: 0">{{ item.title }}</h4><br>
            <p >{{item.time}}</p>
          </el-card>
        </el-timeline-item>
      </el-timeline>
    </div>
  </div>

</template>

<script>

import {getNoticeList} from "@/api/front";

export default {
  name: "Down",
  data(){
    return {
      articles:[]
    }
  },
  watch: {
    articles(){
      this.$nextTick(()=>{

      })
    }
  },
  created() {
    getNoticeList({type: "3"}).then(res=>{
      this.articles=res.data
      console.log(res)
    })
  }
}
</script>

<style scoped>
.all{
  margin-top: 30px;
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
