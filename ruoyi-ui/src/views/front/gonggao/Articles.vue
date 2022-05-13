<template>
  <div>
    <H1 style="text-align: center">医院公告</H1>
    <ul style="min-height: 500px">
      <li v-for="(item,index) in articles" :key="item.noticeId">
        <div class="item" @click="toArticle(index)">
          <span style="margin-right: 10px;float: left">{{index+1}}.</span>
          <span style="float: left">{{item.title}}</span>
          <span style="float: right">{{item.time}}</span>
        </div>
      </li>
    </ul>
    <!--分页-->
    <div class="page" style="text-align: center;margin-top: 30px;margin-bottom: 30px;">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 15, 20]"
        :page-size="this.queryParams.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>
import Article from "@/views/front/gonggao/Article";
import {getNoticeList} from "@/api/front";

export default {
  name: "Articles",
  methods: {
    handleSizeChange(val) {
      this.queryParams.pageSize=val
      this.getList();
    },
    handleCurrentChange(val) {
      this.queryParams.pageNum=val;
      this.getList();
    },
    toArticle(index){
      this.$router.push({name:'Article',params:this.articles[index]})
    },
    /** 查询文章列表 */
    getList() {
      // this.loading = true;
      getNoticeList(this.queryParams).then(response => {
        this.articles = response.data;
        this.total = response.total;
        // this.loading = false;
      });
    },
  },
  data(){
    return {
      articles: [],
      // 总条数
      total: 0,
      currentPage: 1,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: 2,   //2表示查询公告数据，1表示查询科普数据
        // noticeTitle: undefined,   //下面三个属性用不要，是若依用来查询数据的参数
        // createBy: undefined,
        // status: undefined,
      },
      // 遮罩层
      loading: true,
    }
  },
  created() {
    this.getList();
  }
}
</script>

<style scoped>
ul{
  width: 80%;
  padding: 0 0 0 0;
  margin: 0 0 0 152px;
}

li{
  list-style-type: none;
  height: 50px;
  width: inherit;
  background-color: #ffffff;
  margin-left: 121px;
  border-bottom: 2px solid #e8e8e8;
  border-left: 2px solid #e8e8e8;
  border-right: 2px solid #e8e8e8;
  display: flex;
  flex-direction: row;
  align-items: center;
  border-radius: 1.1em;
}
li:hover{
  border: 2px solid #000000;
}
.item{
  width: 100%;
  text-align: center;
  text-decoration: none;
  color: #333;
}
</style>
