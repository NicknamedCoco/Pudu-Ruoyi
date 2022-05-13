<template>
  <el-carousel :interval="4000" type="card" height="300px">
    <el-carousel-item v-for="(item,index) in dataList" :key="item.url" style="display: flex;justify-content: center">
      <b>{{item.title}}</b>
<!--      <H3>{{item.title}}</H3>-->
      <a @click="toRouter(index)" href="javascript:void(0)" style="z-index: -10">
        <img style="width: 760px;height: 300px" :src="'http://puduhealth-image.keyi.world/kepu/'+item.url"/>
      </a>
    </el-carousel-item>
  </el-carousel>
</template>

<script>

import {getNoticeList} from '@/api/front'

import {mapMutations} from 'vuex'

export default {
  name: "Carousel",
  data(){
    return {
      dataList:[],
      queryParams: {
        pageNum: 1,
        pageSize: 6,
        type: 1,   //2表示查询公告数据，1表示查询科普数据
      },
    }
  },
  methods: {
    toRouter(val){
      // this.setNoticeData(this.dataList[val])
      this.$router.push({name:"Essay",params:this.dataList[val]})
      // this.$router.push({name:"Essay"})
    },
    getList() {
      getNoticeList(this.queryParams).then(response => {
        this.dataList = response.data;
      });
    },
    ...mapMutations(['setNoticeData'])
  },
  created(){
      this.getList();
  }
}
</script>

<style scoped>
.el-carousel__item b {
  font-size: 20px;
  text-align: center;
  margin: 20px 0 0 0;
  position: absolute;

}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>
