<template>
  <div id="weatherChart" :style="{width: '600px', height: '500px'}"></div>
</template>

<script>

import {weatherInfo} from '@/api/front'

export default {
  name: "Weather",
  data() {
    return {
      dates:[],
      highs:[],
      lows:[],
      cityName:""
    }
  },
  created() {
    weatherInfo().then(res=>{
      this.cityName=res[0];
      console.log(this.cityName)
      let arr = res[1];
      for (let index in arr){
        this.highs.push(arr[index].highest)
        this.dates.push(arr[index].date.substring(6))
        this.lows.push(arr[index].lowest)
      }
      this.draw();
    });
  },
  //钩子函数
  mounted(){
    // this.format(this.rawData)

  },
  methods: {
    format(){

    },
    draw(){
      // 初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById('weatherChart'))
      // 绘制图表
      var option = {
        title: {
          text: this.cityName+'未来两周的温度变化~'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {},
        toolbox: {
          show: false,
          feature: {
            dataZoom: {
              yAxisIndex: 'none'
            },
            dataView: { readOnly: false },
            magicType: { type: ['line', 'bar'] },
            restore: {},
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
          data: this.dates
        },
        yAxis: {
          type: 'value',
          axisLabel: {
            formatter: '{value} °C'
          }
        },
        series: [
          {
            name: 'Highest',
            type: 'line',
            smooth: true, //让线条变成光滑
            // data: [10, 11, 13, 11, 12, 12, 9],
            data: this.highs,
            markPoint: {
              data: [
                { type: 'max', name: 'Max' },
                { type: 'min', name: 'Min' }
              ]
            },
            markLine: {
              data: [{ type: 'average', name: 'Avg' }]
            }
          },
          {
            name: 'Lowest',
            type: 'line',
            smooth: true,
            // data: [1, -2, 2, 5, 3, 2, 0],
            data: this.lows,
            markPoint: {
              data: [{ name: '周最低', value: -2, xAxis: 1, yAxis: -1.5 }]
            },
            markLine: {
              data: [
                { type: 'average', name: 'Avg' },
                /*[
                  {
                    symbol: 'none',
                    x: '90%',
                    yAxis: 'max'
                  },
                  {
                    symbol: 'circle',
                    label: {
                      position: 'start',
                      formatter: 'Max'
                    },
                    type: 'max',
                    name: '最高点'
                  }
                ]*/
              ]
            }
          }
        ]
      };

      //防止越界，重绘canvas
      window.onresize = myChart.resize;
      myChart.setOption(option);//设置option
    }
  }
}
</script>

<style scoped>

</style>
