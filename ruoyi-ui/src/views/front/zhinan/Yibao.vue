<template>
  <div style="margin-top: 30px">
    <el-tabs  style="height: 800px;width: 1200px" :stretch="true">
      <el-tab-pane label="市医保患者就诊">
        <img width="800px" style="margin-left: 200px" src="http://puduhealth-image.keyi.world/zhinan/sybhzjz.png"/>
      </el-tab-pane>
      <el-tab-pane label="新农合直补患者就诊">
        <img width="800px" style="margin-left: 200px" src="http://puduhealth-image.keyi.world/zhinan/xnhzbhzjz.png"/>
      </el-tab-pane>
      <el-tab-pane label="新农合非直补患者就诊">
        <img width="800px" style="margin-left: 200px" src="http://puduhealth-image.keyi.world/zhinan/xnhfzbhzjz.png"/>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "Yibao"
}
</script>

<style scoped>

</style>
