import request from '@/utils/request'

// 新增挂号信息
export function addBooking(data) {
  return request({
    url: '/system/registration',
    method: 'post',
    data:data
  })
}

export function listRegistration(query) {
  return request({
    url: '/system/registration/list',
    method: 'get',
    params: query
  })
}

export function openInvoice(id) {
  return request({
    url: '/system/registration/' + id,
    method: 'put'
  })
}

export function getInfoById(id) {
  return request({
    url: '/system/registration/' + id,
    method: 'get'
  })
}

// 采纳
export function accept(id) {
  return request({
    url: '/system/registration/accept/' + id,
    method: 'get'
  })
}

// 不采纳
export function notAccept(id) {
  return request({
    url: '/system/registration/notAccept/' + id,
    method: 'get'
  })
}

// 评价
export function evaluate(id, evaluate) {
  const data = {
    id,
    evaluate
  }
  return request({
    url: '/system/registration/evaluate/',
    method: 'put',
    data: data
  })
}
