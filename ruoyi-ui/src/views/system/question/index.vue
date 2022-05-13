<template>
  <div>
    <h1 style="text-align:center">患者提问</h1>
    <el-form ref="elForm" :model="formData" :rules="rules" size="medium" label-width="100px" style="margin-left:20px;margin-right:70px;margin-top:80px">
      <el-form-item label="提问内容" prop="title">
        <el-input v-model="formData.title" type="textarea" placeholder="请输入需要咨询的内容" show-word-limit
                  :autosize="{minRows: 4, maxRows: 4}" :style="{width: '100%'}"></el-input>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import { ask } from "@/api/system/questions"

export default {
  name: "index",
  data() {
    return {
      formData: {
        title: undefined,
      },
      rules: {
        title: [{
          required: true,
          message: '请输入需要咨询的内容',
          trigger: 'blur'
        }],
      },
    }
  },
  methods: {
    submitForm() {
      this.$refs['elForm'].validate(valid => {
        if (!valid) return
        // TODO 提交表单
        if (valid){
          ask(this.formData).then(res => {
            if (res.code === 200) {
              this.$modal.msgSuccess("提问成功")
              this.resetForm()
            } else {
              this.msgError("提问失败");
            }
          })
        }
      })
    },
    resetForm() {
      this.$refs['elForm'].resetFields()
    },
  }
}
</script>

<style scoped>

</style>
