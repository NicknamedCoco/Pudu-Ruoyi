<template>
  <div class="main">
    <div class="top">
      <div class="top-child">
        <span style="display: block">Personal Info:</span>
        <ul>
          <li><el-link href="https://keyi.world" type="primary" target="_blank">Blog</el-link></li>
          <li><el-link href="https://keyi.world" type="primary" target="_blank">Github</el-link></li>
          <li><el-link href="https://keyi.world" type="primary" target="_blank">WeChat</el-link></li>
          <li><el-link href="https://keyi.world" type="primary" target="_blank">QQ</el-link></li>
        </ul>
        <div class="copyright">
          <span>©2022 WanYi. All Rights Reserved.</span>
        </div>
      </div>
    </div>
    <div class="down">
      <span>但愿世间人无病，何惜架上药生尘</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "Footer",
  data(){
    return {
    }
  }
}
</script>

<style scoped>

.copyright{
  padding-left: 58%;
}

.top-child{
  height: 100%;
  display: flex;
  flex-direction: row;
  justify-content: left;
  align-items: center;

}
ul{
  list-style-type: none;
  width: auto;
  margin: 0;
  padding: 0;
}
li{
  padding-left: 30px;
  float: left;
}
.main{
  height: 100%;
}
.top,.down{
  width: 100%;
}

.top{
  height: 40%;
}
.down{
  font-size: 20px;
  height: 60%;
  display: flex;
  flex-direction: column-reverse;
  align-items: center;
}
</style>
