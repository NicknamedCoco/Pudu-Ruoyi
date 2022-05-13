<template>
  <div>
    <el-card shadow="always" style="width: 80%;margin: 50px 152px;padding: 20px 100px">
      <H2 style="text-align: center">{{$route.params.title}}</H2>
      <img style="width: 400px;height: 200px;margin-left: 280px" :src="'http://puduhealth-image.keyi.world/kepu/'+$route.params.url"/>
      <div style="font-size: 16px;margin-top: 50px;line-height: 20px" v-html="$route.params.text">

      </div>
      <h3 style="float: right">发布时间：{{this.$route.params.time}}</h3>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "Essay",
}
</script>

<style scoped>

</style>
