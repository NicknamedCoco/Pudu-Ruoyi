<template>
  <div class="all">
    <H1 style="margin-bottom: 0;margin-top: 30px;text-align: center">科室介绍</H1>
    <div class="departments">
      <div class="dept" @click="showView(index)" v-for="(dept,index) in depts" :key="dept.userId">
        <div>
          <H2  style="text-align: center">{{dept.deptName}}</H2>
          <div :id="index" style="display: none;height: 400px;background-color: #ffffff;border-radius: 1.1em">
            <div style="height: 150px;line-height: 20px;padding: 30px;font-size: 17px">{{dept.describe}}</div>
            <el-divider><h3 style="text-align: center;font-size: 17px">科室成员</h3></el-divider>
            <div class="avatars" style="height: 100px;">
              <div v-for="(member,mIndex) in dept.members" @click="getBrief(index,mIndex)">
                <el-avatar  style="width: 100px;height: 150px" :src="member.avatar"></el-avatar>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import {getDeptInfo} from '@/api/front'

export default {
  name: "KeShi",
  methods:{
    getBrief(index,mIndex){
      this.$router.push({name: 'Member',params:this.depts[index].members[mIndex]})
    },
    showView(val){
      for (let i = 0; i < 6; i++) {
        if (val===i){
          continue
        }
        document.getElementById(i).style.display="none";
      }

      let element = document.getElementById(val);
      if (element.style.display==="none"){
        element.style.display="block";
      }else{
        element.style.display="none"
      }

    }
  },
  created() {
    //217表示获取临床部门下所有科室信息
    getDeptInfo("217").then(data => {
      this.depts=data;
      console.log(this.depts)
    })
  },
  data(){
    return {
      depts:[],
      activeName:1
    }
  }
}
</script>

<style scoped>
.all{
  min-height: 800px;
}
.departments{
  width: 80%;
  margin-left: 150px;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 30px;

}
.dept{
  width: inherit;
  background-color: #14ecf3;

  /*border-bottom: 2px solid #e8e8e8;*/
  border-bottom: 2px solid #e8e8e8;
  border-left: 2px solid #e8e8e8;
  border-right: 2px solid #e8e8e8;
  border-radius: 1.1em;
}

.dept:hover{
  /*border: 2px solid #1dc4a3;*/
  border: 2px solid #000000;
}

.avatars{
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

</style>
