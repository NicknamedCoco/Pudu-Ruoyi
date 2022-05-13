<template>
  <div>
    <el-container>
      <el-header>
        <Header/>
      </el-header>
      <!--<el-divider><i class="el-icon-s-home"></i></el-divider>-->
      <el-main>
        <router-view/>
      </el-main>
      <!--<el-divider content-position="center">没有啦~</el-divider>-->
      <el-footer>
        <Footer/>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
  import Header from "@/views/front/components/Header";
  import Footer from "@/views/front/components/Footer";
export default {
  name: "Front",
  components: {
    Header,
    Footer
  }
}
</script>

<style>

.el-header, .el-footer {
  /*background-color: #ffffff;*/
  background-image: linear-gradient(to bottom right, white, deepskyblue);
  color: #333;
  text-align: center;
  /*line-height: 60px;*/
  height: 100px !important;
}

.el-footer{
  bottom: 0;
  width: 100%;
  padding: 0;
}

.el-main {
  padding: 0;
  background-color: #ffffff;
  color: #333;
  line-height: 100%;
}

body > .el-container {
  margin-bottom: 40px;
}
body::-webkit-scrollbar {
  width: 10px;
}
body::-webkit-scrollbar-thumb {
  border-radius: 10px;
  -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
  background: #17e3ea;
}

</style>
