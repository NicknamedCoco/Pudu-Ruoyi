<template>
  <div>
    <!--
      医院简介，领导团队，历史沿革
    -->
    <Top/>
    <Main/>
    <Down/>
    <Map/>
  </div>
</template>

<script>

import Top from '@/views/front/jianjie/Top'
import Main from '@/views/front/jianjie/Main'
import Down from "@/views/front/jianjie/Down";
import Map from "@/views/front/jianjie/Map";
export default {
  name: "index",
  data(){
    return {
    }
  },
  components:{
    Top,
    Main,
    Down,
    Map
  }
}
</script>

<style scoped>


</style>
