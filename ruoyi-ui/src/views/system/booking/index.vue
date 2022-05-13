<template>
  <div>
    <h1 style="text-align:center;margin-top: 80px;font-size: 30px">预约挂号</h1>
    <el-row :gutter="15" style="margin:50px 50px 50px 50px;height: 550px">
      <el-form ref="elForm" style="width: 50%;margin-left: 305px" :model="formData" :rules="rules" size="medium" label-width="100px">
        <el-row :span="12">
          <el-form-item label="科室" prop="depId">
            <el-select v-model="formData.depId" placeholder="请选择科室" clearable :style="{width: '100%'}" @change="getDoctorById(formData.depId)">
              <el-option v-for="item in depts" :key="item.deptId" :label="item.deptName"
                         :value="item.deptId"></el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row :span="12">
          <el-form-item label="医生" prop="doctorId">
            <el-select v-model="formData.doctorId" placeholder="请选择医生" clearable :style="{width: '100%'}">
              <el-option v-for="item in doctorOptions" :key="item.userId" :label="item.nickName"
                         :value="item.userId"></el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row :span="12">
          <el-form-item label="预约时间" prop="time">
            <el-date-picker type="datetime" v-model="formData.time" format="yyyy-MM-dd HH:mm:ss" :default-value="new Date()"
                            value-format="yyyy-MM-dd HH:mm:ss" :style="{width: '100%'}" placeholder="请选择预约时间" clearable>
            </el-date-picker>
          </el-form-item>
        </el-row>
        <el-row :span="12">
          <el-form-item label="挂号级别" prop="level">
            <el-select v-model="formData.level" placeholder="请选择挂号级别" clearable :style="{width: '100%'}">
              <el-option v-for="item in levels" :key="item.value" :label="item.label"
                         :value="item.value"></el-option>
            </el-select>
          </el-form-item>
        </el-row>
        <el-row :span="24">
          <el-form-item size="large">
            <el-button type="primary" @click="handlePay">支付</el-button>
            <el-button @click="resetForm">重置</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </el-row>

    <el-dialog title="扫码支付" :visible.sync="qrcode" width="300px">
      <el-row>
        <el-col :span="8">
          <img src="@/assets/images/qrcode.png" style="text-align:center;"/>
        </el-col>
      </el-row>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">已完成支付</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

import {getDeptInfo} from '@/api/front'

import {addBooking} from "@/api/system/booking";

export default {
  name: "index",
  data(){
    return {
      qrcode: false,
      departmentOptions: undefined,
      doctorOptions: undefined,
      depts:[],
      formData: {
        depId:undefined,
        doctorId: undefined,
        time: undefined,
        level: undefined
      },
      rules: {
        depId: [{
          required: true,
          message: '请选择科室',
          trigger: 'change'
        }],
        userId: [{
          required: true,
          message: '请选择医生',
          trigger: 'change'
        }],
        time: [{
          required: true,
          message: '请选择预约时间',
          trigger: 'change'
        }],
        lever: [{
          required: true,
          message: '请选择挂号级别',
          trigger: 'change'
        }]
      },
      levels: [
        {
          "label": "门诊号",
          "value": "门诊号"
        }, {
          "label": "特需号",
          "value": "特需号"
        },
        {
          "label": "会诊号",
          "value": "会诊号"
        }
      ],
    }
  },
  created(){
    this.getDepts();
  },
  methods: {
    getDepts(){
      //217表示获取临床部门下所有科室信息
      getDeptInfo("217").then(data => {
        this.depts=data
      })
    },
    cancel() {
      this.qrcode = false
    },
    handlePay() {
      if (this.formData.depId === undefined) {
        this.$modal.alertError("请选择科室")
      } else if (this.formData.doctorId === undefined) {
        this.$modal.alertError("请选择医生")
      } else if (this.formData.time === undefined) {
        this.$modal.alertError("请选择预约时间");
      } else if (this.formData.level === undefined) {
        this.$modal.alertError("请选择挂号级别")
      } else {
        console.log(this.formData)
        this.qrcode = true
      }
    },
    onOpenDialog() {
      this.updateOpen = true
    },
    getDoctorById(id) {
      this.formData.doctorId = undefined
      for (let item of this.depts){
        if (item.deptId===id){
          this.doctorOptions=item.members
        }
      }
    },
    submitForm(data) {
      console.log(data)
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
        if (valid) {
          addBooking(this.formData).then(res=>{
            console.log(res)
            this.$modal.alertSuccess("挂号成功！"+res)
          })
          this.resetForm();
          this.cancel();
        }
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    }
  }
}
</script>

<style scoped>

</style>
