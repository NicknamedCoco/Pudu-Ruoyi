import request from '@/utils/request'

// 新增
export function ask(data) {
  return request({
    url: '/system/questions/ask',
    method: 'post',
    data: data
  })
}

// 查询问答列表
export function listQuestions(query) {
  return request({
    url: '/system/questions/list',
    method: 'get',
    params: query
  })
}

// 删除问答
export function delQuestions(id) {
  return request({
    url: '/system/questions/' + id,
    method: 'delete'
  })
}

// 回答问题
export function reply(data) {
  return request({
    url: '/system/questions/reply',
    method: 'put',
    data: data
  })
}
