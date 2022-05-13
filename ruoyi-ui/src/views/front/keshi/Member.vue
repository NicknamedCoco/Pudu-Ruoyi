<template>
  <div>
    <el-card shadow="always" style="width: 80%;margin: 50px 152px;padding: 20px 100px">
      <H2 style="text-align: center">{{$route.params.nickName}}</H2>
      <img style="width: 200px;height: 200px;margin-left: 400px" :src="$route.params.avatar"/>
      <div style="font-size: 16px;margin-top: 50px;line-height: 20px" v-html="$route.params.brief">

      </div>
    </el-card>
  </div>
</template>

<script>
export default {
  name: "Member"
}
</script>

<style scoped>

</style>
