<template>
  <div class="a">
    <Carousel/>
    <div class="WAndV">
      <WeatherEcharts/>
      <VirusEcharts/>
    </div>
    <Cards/>
    <News/>
    <Tags/>
  </div>
</template>

<script>
import Carousel from "@/views/front/shouye/Carousel";
import Cards from "@/views/front/shouye/Cards";
import WeatherEcharts from "@/views/front/shouye/WeatherEcharts";
import VirusEcharts from "@/views/front/shouye/VirusEcharts"
import News from "@/views/front/shouye/News";
import Tags from "@/views/front/shouye/Tags";
export default {
  name: "index",
  components: {
    Carousel,
    WeatherEcharts,
    VirusEcharts,
    Cards,
    News,
    Tags,
  }
}
</script>

<style scoped>
.WAndV{
  margin-top: 30px;
  display: flex;
  justify-content: space-between;
  align-content: center;
}

/*.a{*/
/*  height: 2500px;*/
/*}*/
</style>
