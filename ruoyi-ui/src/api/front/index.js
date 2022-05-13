import request from '@/utils/request'

// 首页查询天气信息
export function weatherInfo() {
  return request({
    url: '/front/index/weatherInfo',
    method: 'get'
  })
}

//首页获取标签列表
export function getTags() {
  return request({
    url: '/front/index/tags',
    method: 'get'
  })
}
//首页增加标签
export function addTag(data) {
  return request({
    url: '/front/index/addTag',
    method: 'post',
    data:data
  })
}

//科室介绍获取科室信息
export function getDeptInfo(id) {
  return request({
    url: '/front/dept/'+id,
    method: 'get'
  })
}

//获取医院公告,健康科普,医院公告的数据
export function getNoticeList(query) {
  return request({
    url: '/front/notice',
    method: 'get',
    params: query
  })
}

//获取领导信息
export function getUserInfo(query) {
  return request({
    url: '/front/user/'+query,
    method: 'get',
  })
}

export function drugSearch(query) {
  return request({
    url: '/front/index/drugSearch',
    method: 'get',
    params:query
  })
}

export function getMenu() {
  return request({
    url: '/front/index/menu',
    method: 'get',
  })
}

export function drugQuery(query) {
  return request({
    url: '/front/index/drugQuery',
    method: 'get',
    params:query
  })
}

export function getNews(query) {
  return request({
    url: '/front/index/news',
    method: 'get',
    params:query
  })
}




