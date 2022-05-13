<template>
  <div>
    <H1 style="text-align: center">健康科普</H1>
    <div class="essays">
      <div class="essay"   v-for="(item,index) in essays" :key="item.noticeId">
        <a style="display: flex;" @click="toEssay(index)" href="javascript:void(0)">
          <div style="width: 50%;height: 173px;background-color: #bfcbd9">
            <img style="width: 295px;height: 173px" :src="'http://puduhealth-image.keyi.world/kepu/'+item.url" alt="图片神秘失踪了"/>
          </div>
          <div style="width: 50%;padding: 25px">
            <div style="text-align: left;line-height: 25px;font-size: 1.2em">{{item.title}}</div>
            <div style="margin-top: 20px">{{item.time}}</div>
          </div>
        </a>
      </div>
    </div>
    <!--分页-->
    <div class="page" style="text-align: center;margin-top: 30px;margin-bottom: 30px">
      <el-pagination
        background
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[4, 6, 8, 12]"
        :page-size="this.queryParams.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>

import {getNoticeList} from "@/api/front";

export default {
  name: "Essays",
  created() {
    this.getList();
  },
  data(){
    return{
      essays:[],
      currentPage: 1,
      // 总条数
      total: 0,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 6,
        type: 1,   //2表示查询公告数据，1表示查询科普数据
        // noticeTitle: undefined,   //下面三个属性用不要，是若依用来查询数据的参数
        // createBy: undefined,
        // status: undefined,
      },
      // 遮罩层
      loading: true,
    }
  },
  methods: {
    toEssay(index){
      this.$router.push({name:"Essay",params:this.essays[index]})
    },
    handleSizeChange(val) {
      this.queryParams.pageSize=val
      this.getList();
    },
    handleCurrentChange(val) {
      this.queryParams.pageNum=val;
      this.getList();
    },
    /** 查询文章列表 */
    getList() {
      this.loading = true;
      getNoticeList(this.queryParams).then(response => {
        this.essays = response.data;
        this.total = response.total;
        this.loading = false;
      });
    },
  },
}
</script>

<style scoped>
.essays{
  width: 80%;
  min-height: 580px;
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  align-content: start;
  justify-content: start;
  margin-left: 152px;
}

.essay{
  width: 48%;
  height: 173px;
  margin-top: 20px;
  margin-left: 20px;
  /*background-color: #8acfee;*/
  background-image: linear-gradient(to top,#edf1f1, #10f3f3);
  border-radius: 1.3em;
}


</style>
