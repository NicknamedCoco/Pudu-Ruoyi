<template>
  <div class="app-container home">
    <el-row :gutter="20">
      <el-col :sm="24" :lg="24">
        <blockquote>
          {{this.preface.hitokoto}}<br>
          <span style="font-size: 15px;">{{this.preface.from}}  </span>
          <span style="font-size: 15px;">{{preface.from_who}}</span>
        </blockquote>
        <hr />
      </el-col>
    </el-row>
    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>普渡健康后台管理系统</h2>
      </el-col>

      <el-col :sm="24" :lg="12" style="padding-left: 50px">
        <el-row>
          <el-col :span="24">
            <h2 style="text-align: center">系统实现</h2>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <h3>后端技术</h3>
            <el-row>
              <el-col :span="4">
                <ul>
                  <li>SpringBoot</li>
                  <li>SpringCloud</li>
                  <li>SpringCloud Alibaba</li>
                  <li>Nacos</li>
                  <li>Sentinel</li>
                  <li>Swagger</li>
                </ul>
              </el-col>
              <el-col :span="4"  style="padding-left: 60px">
                <ul>
                  <li>Mybatis</li>
                  <li>Druid</li>
                  <li>Hutool</li>
                  <li>Jackson</li>
                </ul>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="8" style="padding-left: 20px">
            <h3>前端技术</h3>
            <el-row>
              <el-col :span="8">
                <ul>
                  <li>Vue</li>
                  <li>Vuex</li>
                  <li>ElementUI</li>
                  <li>Axios</li>
                  <li>Echarts</li>
                  <li>VueRouter</li>
                </ul>
              </el-col>
            </el-row>
          </el-col>
          <el-col :span="8">
            <h3>第三方平台</h3>
            <el-row>
              <el-col :span="8">
                <ul>
                  <li>七牛云</li>
                  <li>万维易源</li>
                  <li>一言</li>
                  <li>百度地图</li>
                  <li>Iconfont</li>
                </ul>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
<!--    <el-divider />-->
    <el-row :gutter="20">
      <!--<el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>联系信息</span>
          </div>
          <div class="body">
            <p>
              <i class="el-icon-s-promotion"></i> 个人博客：
              <el-link
                href="https://keyi.world"
                target="_blank"
                >
                https://keyi.world
              </el-link>
            </p>

          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>更新日志</span>
          </div>
          <el-collapse accordion>
            <el-collapse-item title="v3.2.0 - 2021-10-12">
              <ol>
                <li>菜单管理支持配置路由参数</li>
                <li>定时任务支持在线生成cron表达式</li>
                <li>自定义弹层溢出滚动样式</li>
                <li>自定义可拖动弹窗宽度指令</li>
                <li>自定义可拖动弹窗高度指令</li>
                <li>修改时检查用户数据权限范围</li>
                <li>修复保存配置主题颜色失效问题</li>
                <li>新增暗色菜单风格主题</li>
                <li>菜单&部门新增展开/折叠功能</li>
                <li>页签新增关闭左侧&添加图标</li>
                <li>代码生成主子表多选行数据</li>
                <li>日期范围支持添加多组</li>
                <li>Excel导入支持@Excels注解</li>
                <li>Excel注解支持导入导出标题信息</li>
                <li>Excel注解支持自定义数据处理器</li>
                <li>日志注解新增是否保存响应参数</li>
                <li>定时任务对检查异常进行事务回滚</li>
                <li>补充定时任务表字段注释</li>
                <li>定时任务屏蔽ldap远程调用</li>
                <li>新增通用方法简化下载使用</li>
                <li>新增通用方法简化模态/缓存使用</li>
                <li>新增data-dict组件简化数据字典使用</li>
                <li>禁用dict-tag组件的渐变动画</li>
                <li>默认首页使用keep-alive缓存</li>
                <li>升级springcloud到最新版2020.0.4</li>
                <li>升级spring-boot到最新版本2.5.5</li>
                <li>升级spring-boot-admin到最新版2.5.2</li>
                <li>升级pagehelper到最新版1.4.0</li>
                <li>升级fastjson到最新版1.2.78</li>
                <li>升级druid到最新版1.2.8</li>
                <li>升级element-ui到最新版本2.15.6</li>
                <li>升级sass-loader到最新版本10.1.1</li>
                <li>升级dart-sass到版本1.32.13</li>
                <li>升级file-saver到最新版本2.0.5</li>
                <li>优化异常处理信息</li>
                <li>验证码默认20s超时</li>
                <li>优化代码生成导入表按创建时间排序</li>
                <li>优化代码生成点击预览重置激活tab</li>
                <li>修复主子表代码模板方法名错误问题</li>
                <li>修复xss过滤后格式出现的异常</li>
                <li>修复多图组件验证失败被删除问题</li>
                <li>请求参数新增reasonable分页合理化属性</li>
                <li>修复代码生成页面数据编辑保存之后总是跳转第一页的问题</li>
                <li>修复带safari浏览器无法格式化utc日期格式yyyy-MM-dd'T'HH:mm:ss.SSS问题</li>
                <li>其他细节优化</li>
              </ol>
            </el-collapse-item>

          </el-collapse>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div slot="header" class="clearfix">
            <span>捐赠支持</span>
          </div>

        </el-card>
      </el-col>-->
    </el-row>
  </div>
</template>

<script>
import {yiyan} from '@/api/yiyan'
import axios from "axios";

export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.2.0",
      preface: {}
    };
  },
  watch:{
    preface(){

    }
  },
  mounted() {
    this.getYiYan()
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
    getYiYan(){
      axios.get("/yiyan?c=k&encode=json").then(res=>{
        this.preface=res.data;
        console.log(res)
      })
      // yiyan({c:"k",encode:"json"}).then(res =>{
      //     this.preface=res;
      //     console.log(this.preface)
      // })
    }
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 18px;
    border-left: 5px solid #eee;

    color: #abeaf7;
    background-image: -webkit-linear-gradient(90deg, #abeaf7, #f41392);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    -webkit-animation: change 5s infinite linear;
  }
  @-webkit-keyframes change {
    from {
      -webkit-filter: hue-rotate(0deg);
    }
    to {
      -webkit-filter: hue-rotate(-360deg);
    }
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

