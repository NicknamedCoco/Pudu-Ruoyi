<template>
  <div style="margin-top: 30px">
   <div class="title">
     <H2>明星医师</H2>
   </div>
    <el-row>
      <el-col :span="8" v-for="(o, index) in usersData" :key="o.userId" :offset="index > 0 ? 2 : 0">
        <el-card :body-style="{ padding: '0px',height: '400px'}" >
          <img :src="o.avatar" class="image">
          <div style="padding: 14px;height: 100px;background-color: #f8f8f9">
            <span style="font-size: 20px;">{{ o.nickName }}</span>
            <div class="bottom clearfix">
              <span style="font-size: 18px">普渡健康医院{{o.userDept}}</span>
              <el-button  @click="toUser(index)" type="text" class="button">了解更多</el-button>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import {getUserInfo} from "@/api/front";

export default {
  name: "Cards",
  data() {
    return {
      currentDate: new Date(),
      userIds:[112,107,102],
      usersData:[]
    };
  },
  methods:{
    toUser(index){
      this.$router.push({name: 'Member',params:this.usersData[index]})
    }
  },
  created() {
    getUserInfo(this.userIds).then(res=>{
        this.usersData=res;
    })
  }
}
</script>

<style scoped>

.title{
  display: flex;
  justify-content: center;
  margin-bottom: 30px;
}

.el-row{
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-content: center;
}
.el-col{
  width: 350px;
  height: 500px;
}
.image{
  height: 400px;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
  margin-top: 13px;
  font-size: 17px;
  color: #17e3ea;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>

