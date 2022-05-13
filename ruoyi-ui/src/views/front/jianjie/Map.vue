<template>
  <div class="all">
    <H2>当前位置</H2>
    <div class="card">
      <el-input
        placeholder="请输入地址"
        v-model="input3"
        class="input-with-select"
      >
        <el-button type="primary" plain slot="append" icon="el-icon-search" @click="inputfz"
        >搜索</el-button
        >
      </el-input>
      <!--
        scroll-wheel-zoom是是否可以缩放
        @ready是图加载完后触发事件
        center是位置定位
        zoom是缩放大小限制
        inertial-dragging是允许惯性拖拽
       -->
      <baidu-map
        class="bm-view"
        :zoom="15"
        :center="center"
        inertial-dragging
        @ready="mapReady"
        :scroll-wheel-zoom="true"
      >
        <bm-view style="height: 400px;width: 1000px"></bm-view>
        <!-- 定位控件   anchor="BMAP_ANCHOR_BOTTOM_RIGHT"代表放在右下角 -->
        <bm-geolocation
          anchor="BMAP_ANCHOR_BOTTOM_RIGHT"
          :showAddressBar="true"
          :autoLocation="true"
        ></bm-geolocation>
        <!-- 地区检索  keyword：关键字搜索   @searchcomplete：检索完成后的回调函数   auto-viewport：检索结束后是否自动调整地图视野  -->
        <bm-local-search
          :keyword="keyword"
          @searchcomplete="search"
          :auto-viewport="true"
          class="search"
        ></bm-local-search>
        <!-- 缩放控件   anchor代表控件停靠位置   anchor="BMAP_ANCHOR_TOP_RIGHT"代表放在右上角-->
        <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
      </baidu-map>
    </div>

  </div>
</template>

<script>

//引入组件
import {
  BaiduMap,
  BmControl,
  BmView,
  BmAutoComplete,
  BmLocalSearch,
  BmMarker,
  BmGeolocation,
} from "vue-baidu-map";

export default {
  name: "Map",
  data() {
    return {
      //定位位置信息
      center: {lat:116.55,lng:29.89},
      //检索关键字
      keyword: "",
      //输入框input值
      input3: "",
    };
  },
  //需要引入的组件
  components: {
    BaiduMap,
    BmControl,
    BmView,
    BmAutoComplete,
    BmLocalSearch,
    BmMarker,
    BmGeolocation,
  },
  methods: {
    //输入框
    inputfz() {
      this.keyword = this.input3;
    },
    //地图加载后的回调
    mapReady({ BMap, map }) {
      //保存this指向，因为在百度的回调中this不指向vue
      const _this = this;

      // 获取自动定位方法
      var geolocation = new BMap.Geolocation();
      // 获取自动定位获取的坐标信息
      geolocation.getCurrentPosition(
        function (r) {
          //可以conso.log看一下这个r，他里面包含了检索到的位置信息。下面就把两个维度信息赋值给center来定位
          _this.center = {
            lng: r.point.lng,
            // lng: 116.55,
            lat: r.point.lat,
            // lat: 29.89,
          };
        },
        ()=>{},{enableHighAccuracy: true}
        //启用高精度
        // { enableHighAccuracy: true }
      );
    },

    search(){

    }
  },
}
</script>

<style scoped>
/* 给个宽高 */
.bm-view {
  /*height: 400px;*/
  /*width: 1000px;*/
}
.input-with-select {
  width: 400px;
  margin-bottom: 5px;
  margin-left: 320px;
}
.search {
  max-height: 260px;
  overflow: auto;
}
.all{
  display: flex;
  flex-direction: column;
  align-items: center;
  /*height: 769px;*/
  height: 900px;
}
.card{
  width: 1000px;
  height: auto;
  min-height: 720px;
}

.search::-webkit-scrollbar {
  width: 10px;
}
.search::-webkit-scrollbar-thumb {
  border-radius: 10px;
  -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
  background: #17e3ea;
}
</style>
