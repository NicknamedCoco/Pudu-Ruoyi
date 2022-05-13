<template>
  <!--<el-row :gutter="20" type="flex" justify="enter">
    <el-col :span="6" v-for="(item) in arr">
      <div class="grid-content bg-purple">
        <div style="width: 70px;margin-left: 65px">
          <a :href="item.routePath">
            &lt;!&ndash;图标&ndash;&gt;
            <div style="height: 40px">
              <svg-icon :icon-class="item.svgName" style="height: 40px;width: 40px"/>
            </div>
            <div style="height: 30px;text-align: center;line-height: 30px">
              <span>{{item.name}}</span>
            </div>
          </a>
        </div>
      </div>
    </el-col>
  </el-row>-->



 <el-menu class="menu" mode="horizontal">
    <div class="menu-item"  v-for="(item,index) in arr" style="width: 100px;height: 100px">
      <el-menu-item style="height:100px;padding: 20px 0 0 0"  v-if="!item.hasOwnProperty('subMenuPath')" :index="index+''">
        <a :href="item.routePath">
          <!--图标-->
          <div style="height: 40px">
            <svg-icon :icon-class="item.svgName" style="height: 40px;width: 40px"/>
          </div>
          <div style="height: 30px;text-align: center;line-height: 30px">
            <span>{{item.name}}</span>
          </div>
        </a>
      </el-menu-item>
      <el-submenu style="height:100px;padding:20px 0 0 0;"   v-else  :index="index+''">
        <template slot="title">
          <a :href="item.routePath">
            <!--图标-->
            <div style="height: 40px;padding-top: 20px">
              <svg-icon :icon-class="item.svgName" style="height: 40px;width: 40px;"/>
            </div>
            <div style="height: 30px;text-align: center;line-height: 30px;padding-top: 20px">
              <span>{{item.name}}</span>
            </div>
          </a>
        </template>
        <el-menu-item  v-for="i in item.subMenuPath">
          <a :href="i.path">{{i.name}}</a>
        </el-menu-item>
      </el-submenu>
    </div>
  </el-menu>

</template>

<script>
export default {
  name: "Header",
  data(){
    return {
      arr:[
        {
          routePath:"/front",
          svgName:"shouye",
          name:"首页"
        },
        {
          routePath:"/front/jianjie",
          svgName:"jianjie",
          name:"医院简介"
        },
        {
          routePath:"/front/zhinan",
          svgName:"zhinan",
          subMenuPath:[
            {
              name:"门诊流程",
              path:"/front/zhinan"
            },
            {
              name:"住院出院流程",
              path:"/front/zhinan/zhuchuyuan"
            },
            {
              name:"检查流程",
              path:"/front/zhinan/check"
            },
            {
              name:"医保信息",
              path:"/front/zhinan/yibao"
            }
          ],
          name:"就诊指南"
        },
        {
          routePath:"/front/keshi",
          svgName:"yisheng",
          name:"科室介绍"
        },
        {
          routePath:"/front/gonggao",
          svgName:"gonggao",
          name:"医院公告"
        },
        {
          routePath:"/front/kepu",
          svgName:"kepu",
          name:"健康科普"
        },
        {
          routePath:"/front/drugSearch",
          svgName:"drug",
          name:"药品查询"
        },
        {
          routePath:"/front/login",
          svgName:"login",
          name:"登录"
        }
      ]
    }
  },
  methods: {
  }
}
</script>

<style scoped lang="scss">

::v-deep.menu{
  display: flex;
  width: 100%;
  height: 100px;
  justify-content: space-between;
  background-color: inherit;

  .el-menu-item:hover{
    border-radius: 4em;
  }

  .el-submenu{
    .el-submenu__title {
      height: 100px;
      padding: 0 !important;
      margin-top: -20px;
      &:hover {
        border-radius: 4em;
      }
      i{
        display: none;
      }
    }
    .el-menu-item {
      min-width: 180px;
      //    padding-left: 20px !important;
    }
  }

}


.el-row {
  margin-top: 15px;
  margin-bottom: 15px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  //background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  height: 70px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}

.bg-purple > div:hover{
    background-color: #e6ebf5;
    border-radius: 1.3em;
}
</style>
