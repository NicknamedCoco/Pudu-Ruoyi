<template>
  <div class="all" style="display: flex;flex-direction:column;align-items: center">

    <!--搜索-->
    <H2 style="text-align: center">药品查询</H2>
    <div class="demo-input-suffix" style="width: 450px;margin-left: 80px;margin-bottom: 40px">
      <div style="display: flex;margin-top: 20px;justify-content: center;">
        <el-select v-model="value" placeholder="查询类型" @change="change">
          <el-option
            v-for="item in options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
          </el-option>
        </el-select>
        <el-input
          v-if="value"
          placeholder="请输入药品名称"
          prefix-icon="el-icon-search"
          v-model="queryParams.keyword">
        </el-input>
        <el-button v-if="value" type="primary" @click="getList(1)" style="margin-left: 10px" round>搜索</el-button>
        <el-cascader style="width: 80%" v-if="!value" @change="change2" :options="options2" :show-all-levels="false"></el-cascader>
      </div>
    </div>

    <!--药品信息展示-->
    <el-table
      :data="dataList"
      highlight-current-row
      @current-change="handleCurrentChange"
      border
      :header-cell-style="{'text-align':'center'}"
      style="width: 80%;">
      <el-table-column
        v-if="value===1"
        label="图片"
        width="150">
        <template slot-scope="scope">
          <img v-if="!(scope.row.imgUrl=='')" :src="scope.row.imgUrl" width="80"/>
          <H4 v-else>暂无图片</H4>
        </template>
      </el-table-column>
      <el-table-column
        prop="drugName"
        label="药品名称"
        width="150" >
      </el-table-column>
      <el-table-column
        prop="syz"
        label="适应症"
        width="150">
      </el-table-column>
      <el-table-column
        prop="yxq"
        label="有效期"
        width="150">
      </el-table-column>
      <el-table-column
        :prop="guige"
        label="规格型号"
        width="150">
      </el-table-column>
      <el-table-column
        prop="price"
        label="参考价格"
        width="150">
      </el-table-column>
      <el-table-column
        prop="yfyl"
        label="用法用量"
        width="150">
      </el-table-column>
      <el-table-column
        prop="manu"
        label="生产厂家">
      </el-table-column>
    </el-table>

    <!--分页-->
    <div class="page" style="text-align: center;margin-top: 30px;margin-bottom: 30px">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="pageChange"
        :current-page="this.queryParams.pageNum"
        :page-sizes="[5, 10]"
        :page-size="this.queryParams.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>

  </div>
</template>

<script>
import {drugSearch,drugQuery,getMenu} from "@/api/front";

export default {
  name: "index",
  methods:{
    /*第一个选择框的回调函数*/
    change(val){
      if (this.value===0){
        getMenu().then(res=>{
            this.options2=res;
        })
        this.dataList=[]
        this.total=0
      }
      if (this.value===1){
        this.dataList=[]
        this.total=0
        this.queryParams.keyword=""
      }
    },
    change2(val){
      this.queryParams.classifyId=val[1];
      this.getList()
    },
    //table组件方法
    handleCurrentChange(val){
      //组件跳转，并携带数据给组件
    },
    handleSizeChange(val) {
      this.queryParams.pageSize=val
      if (this.dataList!=""){
        this.getList(this.queryParams.pageNum);
      }
    },
    //分页组件方法
    pageChange(val) {
      this.getList(val);
    },
    /** 查询文章列表 */
    getList(pageNum) {
      this.loading = true;
      this.queryParams.pageNum=pageNum;
      if (this.queryParams.keyword===""&&this.value===1){
        this.dataList=[]
      }else {
        if (this.value===1){
          drugSearch(this.queryParams).then(response => {
            this.dataList = response.drugList;
            console.log(this.dataList)
            this.total = response.allResults;
            this.loading = false;
          });
        }else if (this.value===0){
          drugQuery(this.queryParams).then(response => {
            this.dataList = response.drugList;
            this.total = response.allResults;
            this.loading = false;
          });
        }
      }
    },
  },
  data(){
    return {
      dataList:[],
      // 总条数
      total: 0,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 5,
        keyword: ""
      },
      // 遮罩层
      loading: true,
      options: [{
        value: 1,
        label: '按名称查询',
      }, {
        value: 0,
        label: '按症状查询'
      }],
      value: 1,
      options2: [],
      //规格型号，因为两种查询方式使用不同的接口，其属性命名也不一样
    }
  },
  computed:{
    guige(){
      if (this.value==1){
        return "ggxh"
      }else if(this.value==0){
        return "gg"
      }
    }
  }
}
</script>

<style scoped>
.all{
  min-height: 745px;
}
</style>
