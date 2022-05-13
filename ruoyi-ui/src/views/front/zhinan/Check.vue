<template>
  <div style="margin-top: 30px">
    <el-tabs  style="height: 800px;width: 1200px" :stretch="true">
      <el-tab-pane label="PET/CT检查">
        <img width="800px" style="margin-left: 200px" src="http://puduhealth-image.keyi.world/zhinan/pet.png"/>
      </el-tab-pane>
      <el-tab-pane label="B超检查">
        <img width="800px" style="margin-left: 200px" src="http://puduhealth-image.keyi.world/zhinan/bchao.png"/>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "Check"
}
</script>

<style scoped>

</style>
