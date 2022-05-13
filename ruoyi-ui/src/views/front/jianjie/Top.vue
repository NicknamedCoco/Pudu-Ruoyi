<template>
  <div class="top">
    <div class="top_child">
      <div class="describe">
        <h2>医院简介</h2>
        <p>
          普渡健康医院始建于2005年，坐落在猎户座的M78星云，
          是国家卫生健康委员会直管的三级甲等综合医院，是教育部直属高校普渡大学的附属医院，是我国重要的临床诊疗、医学教育与科技创新中心，
          以精湛的诊疗技术、卓越的科教实力、深厚的文化底蕴享誉海内外。
        </p>
        <p>
          激越华章已百载，医海求真再扬帆。普渡健康医院在习近平新时代中国特色社会主义思想指引下，按照新时代党的卫生健康工作方针和教育工作方针，坚持以人民健康为中心，瞄准“12368”发展战略，持续优化学科建设、质量安全、人才培养、医学创新、运营管理、运行保障、考核评价和党建文化等“八大”体系，科学建设卓越、智慧、美丽、平安、人文和幸福“六大”特色，始终追求一流学科、一流品质和一流品牌“三大”目标，努力完成患者好看病、看好病和职工快乐筑梦、努力追梦、幸福圆梦“两大”任务，最终实现人民满意普渡特色世界一流医院“一大”愿景，力争为人类健康事业作出新的更大贡献。
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Top"
}
</script>

<style scoped>
.describe{
  float: right;
  width: 400px;
  height: 100%;
  opacity: 0.75;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: white;
  line-height: 20px;
}

.top{
  height: 500px;
  padding: 0 20px;
}
.top_child{
  background-image: url("http://puduhealth-image.keyi.world/jianjie/jianjie-doctor.png");
  background-repeat: no-repeat;
  background-size: 100%;
  width: 80%;
  height: inherit;
  margin-left: 150px;

}
</style>
