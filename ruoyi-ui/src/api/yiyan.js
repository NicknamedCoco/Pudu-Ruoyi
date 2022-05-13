import request from '@/utils/request'

export function yiyan(params) {
  return request({
    baseURL:"/yiyan",
    url:"",
    method: 'get',
    params
  })
}
