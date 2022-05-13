<template>
  <div style="margin-top: 30px">
    <el-tabs  style="height: 800px;width: 1200px" :stretch="true">
      <el-tab-pane label="门诊须知">
        <pre style="font-size: 18px;line-height: 20px">
          各位患者：
          感谢您选择来我院就诊或进行健康检查，请您注意以下事项：
          1、首诊病人需要先到导医台分诊，填写相关资料后到挂号处挂号。复诊患者请直接到挂号处挂号，如就诊前有电话预约或网络预约的，
             请向工作人员说明，享受挂号和就诊的相关优惠。如果是参加医保人员，请直接用医保卡挂号。专家门诊时间，
             请见门诊大厅处的专家门诊一览表及挂号处窗口前的专家显示屏介绍，或咨询导医人员。危重病员可到急诊科优先就诊再挂号。

          2、挂号票当日有效，过期作废，退号仅限当日。患者根据分诊情况，到相关诊室就诊，如需排队，可到候诊大厅休息，就诊时请出示挂号票、
             门诊病历、就诊卡或医保卡。行动不便的患者可到导医台处凭借身份证及三百元押金免费使用轮椅。

          3、根据医生问诊和初步检查开具的相关检查项目，请到收费处交费后进行检查，待检查结果出来后，返回就诊室，
             请首诊医生根据检查结果综合分析后做出初步诊断，并进行相应的治疗。为保护就诊者隐私，诊室内保持一医一患的就诊环境，
             根据患者疗情需要可允许一名家属陪伴。

          4、取药程序：请持处方到收费处交款后到相应的中、西药房取药。

          5、留诊观察和治疗时，请办理留诊手续；需住院治疗的病人可到内科住院部一楼办理住院手续。

          6、如患者疗情突然加重，如出现心慌、胸闷、意识障碍等症状，请及时与医务人员取得联系，以便采取相应措施施救。

          7、请您在就诊过程中保管好本人的财务，防止丢失，交款时现金当面点清。您在就诊中若有问题和意见，
             可向当事科室负责人或门诊办公室反映情况，有专业人员会及时为您提供帮助。

          8、我院实行无节假日门诊，全年365天都为您提供优质、便捷的医疗保健服务。
        </pre>
      </el-tab-pane>
      <el-tab-pane label="门诊流程">
        <img width="600px" style="margin-left: 300px" src="http://puduhealth-image.keyi.world/zhinan/menzhen.jpg"/>
      </el-tab-pane>
      <el-tab-pane label="门诊自助机流程">
        <img width="800px" style="margin-left: 200px" src="http://puduhealth-image.keyi.world/zhinan/mzzzjz.jpg"/>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  name: "Menzhen",
  data() {
    return {
      activeName: 'first'
    };
  },
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
}
</script>

<style scoped>

</style>
