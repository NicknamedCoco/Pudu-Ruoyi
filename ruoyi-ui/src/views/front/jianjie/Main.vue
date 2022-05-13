<template>
  <div class="main">
    <h2>领导团队</h2>
    <!--<div class="all">
      <div v-for="(value,index) in persons">
        <div class="boss_child">
          <H3>{{value.name}}</H3>
          <div @mouseleave="change({index,brief:value.id})"  @mouseenter="change({index,note:value.id})">
            <img :id="index" :src="'http://puduhealth-image.keyi.world/jianjie/'+value.avatar"/>
            <div v-show="false" :id="value.id" class="transition-box">{{value.brief}}</div>
          </div>
        </div>
      </div>
    </div>-->
    <div class="all">
      <div v-for="(value,index) in persons">
        <div class="boss_child">
          <b style="font-size: 25px;margin: 20px 0">{{value.nickName}}</b>
          <div @mouseleave="change({index,brief:value.userId})"  @mouseenter="change({index,brief:value.userId})">
            <img :id="index" :src="value.avatar"/>
            <div style="font-size: 20px;line-height: 25px;" v-show="false" :id="value.userId" class="transition-box">{{value.brief}}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {getUserInfo} from "@/api/front";

export default {
  name: "Main",
  data(){
    return {
      persons:[],
      ids:[130,131,132],
    }
  },
  methods:{
    change(data){
      let img = document.getElementById(data.index);
      let note = document.getElementById(data.brief);
      if (img.style.display==="none"){
        img.style.display="";
        note.style.display="none"
      }else {
        img.style.display="none";
        note.style.display=""
      }
    },
  },
  created() {
    getUserInfo(this.ids).then((res=>{
      this.persons=res;
    }))
  }
}
</script>

<style scoped>
.main{
  margin-top: 30px;
  padding: 0 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  /*height: 2000px;*/
}
img{
  height: 400px;
  width: 300px;
}
.all{
  width: 1300px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.boss_child{
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 462px;
}
.transition-box{
  background-color: #d2f5f6;
  opacity: 0.8;
  height: 400px;
  width: 300px;
}
</style>
