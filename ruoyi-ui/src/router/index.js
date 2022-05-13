import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'
import Front from '@/views/front'

/**
 * Note: 路由配置项
 *
 * hidden: true                     // 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1
 * alwaysShow: true                 // 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
 *                                  // 只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
 *                                  // 若你想不管路由下面的 children 声明的个数都显示你的根路由
 *                                  // 你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，一直显示根路由
 * redirect: noRedirect             // 当设置 noRedirect 的时候该路由在面包屑导航中不可被点击
 * name:'router-name'               // 设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
 * query: '{"id": 1, "name": "ry"}' // 访问路由的默认传递参数
 * meta : {
    noCache: true                   // 如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
    title: 'title'                  // 设置该路由在侧边栏和面包屑中展示的名字
    icon: 'svg-name'                // 设置该路由的图标，对应路径src/assets/icons/svg
    breadcrumb: false               // 如果设置为false，则不会在breadcrumb面包屑中显示
    activeMenu: '/system/user'      // 当路由设置了该属性，则会高亮相对应的侧边栏。
  }
 */

// 公共路由
export const constantRoutes = [
  {
    path: "/front",
    component: (resolve) => require(['@/views/front'], resolve),
    hidden: true,
    children: [
      {
        path: '',
        component: (resolve) => require(['@/views/front/shouye'], resolve),
        name: '首页',
        meta: {title: '首页'}
      },
      {
        path: 'login',
        component: (resolve) => require(['@/views/login'], resolve),
        name: '后台登录',
        meta: {title: '后台登录'}
      },
      {
        path: '/register',
        component: (resolve) => require(['@/views/register'], resolve),
        name: '后台注册',
        meta: {title: '后台注册'},
      },
      {
        path: 'jianjie',
        component: (resolve) => require(['@/views/front/jianjie'], resolve),
        name: '医院简介',
        meta: {title: '医院简介'}
      },
      {
        path: 'zhinan',
        component: (resolve) => require(['@/views/front/zhinan'], resolve),
        children: [
          {
            path: '',
            component: (resolve) => require(['@/views/front/zhinan/Menzhen'], resolve),
            name: 'Menzhen',
            meta: {
              title: '门诊流程'
            }
          },
          {
            path: 'zhuchuyuan',
            component: (resolve) => require(['@/views/front/zhinan/Zhuchuyuan'], resolve),
            name: 'Zhuchuyuan',
            meta: {
              title: '住出院流程'
            }
          },
          {
            path: 'check',
            component: (resolve) => require(['@/views/front/zhinan/Check'], resolve),
            name: 'Check',
            meta: {
              title: '检查流程'
            }
          },
          {
            path: 'yibao',
            component: (resolve) => require(['@/views/front/zhinan/Yibao'], resolve),
            name: 'Yibao',
            meta: {
              title: '医保流程'
            }
          }
        ],
        meta: {title: '就诊指南'}
      },
      {
        path: 'kepu',
        component: (resolve) => require(['@/views/front/kepu'], resolve),
        children: [
          {
            path: '',
            component: (resolve) => require(['@/views/front/kepu/Essays'], resolve),
            name: 'Essays',
            meta: {
              title: '健康科普'
            }
          },
          {
            path: 'essay',
            component: (resolve) => require(['@/views/front/kepu/Essay'], resolve),
            name: 'Essay',
            meta: {
              title: '科普文章'
            }
          }
        ],
        meta: {title: '健康科普'}
      },
      {
        path: 'keshi',
        component: (resolve) => require(['@/views/front/keshi'], resolve),
        children: [
          {
            path: '',
            component: (resolve) => require(['@/views/front/keshi/KeShi'], resolve),
            name: 'KeShi',
            meta: {
              title: '科室信息'
            }
          },
          {
            path: 'member',
            component: (resolve) => require(['@/views/front/keshi/Member'], resolve),
            name: 'Member',
            meta: {
              title: '个人简介'
            }
          }
        ],
        meta: {title: '科室介绍'}
      },
      {
        path: 'gonggao',
        component: (resolve) => require(['@/views/front/gonggao'], resolve),
        children: [
          {
            path: '',
            component: (resolve) => require(['@/views/front/gonggao/Articles'], resolve),
            name: 'Articles',
            meta: {title: '医院公告'}
          },
          {
            path: 'article',
            component: (resolve) => require(['@/views/front/gonggao/Article'], resolve),
            name: 'Article',
            meta: {title: '公告文章'}
          }
        ],
        meta: {title: '医院公告'}
      },
      {
        path: 'drugSearch',
        component: (resolve) => require(['@/views/front/drugSearch'], resolve),
        name: '药品查询',
        meta: {title: '药品查询'}
      }
    ]
  },
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: (resolve) => require(['@/views/redirect'], resolve)
      }
    ]
  },
  {
    path: '/login',
    component: (resolve) => require(['@/views/login'], resolve),
    hidden: true
  },
  {
    path: '/register',
    component: (resolve) => require(['@/views/register'], resolve),
    hidden: true
  },
  {
    path: '/404',
    component: (resolve) => require(['@/views/error/404'], resolve),
    hidden: true
  },
  {
    path: '/401',
    component: (resolve) => require(['@/views/error/401'], resolve),
    hidden: true
  },
  {
    path: '/system/invoice',
    component: (resolve) => require(['@/views/system/list/invoice'], resolve),
    hidden: true
  },
  {
    path: '',
    component: Layout,
    redirect: 'index',
    children: [
      {
        path: 'index',
        component: (resolve) => require(['@/views/index'], resolve),
        name: 'Index',
        meta: { title: '首页', icon: 'dashboard', affix: true }
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    hidden: true,
    redirect: 'noredirect',
    children: [
      {
        path: 'profile',
        component: (resolve) => require(['@/views/system/user/profile/index'], resolve),
        name: 'Profile',
        meta: { title: '个人中心', icon: 'user' }
      }
    ]
  },
  {
    path: '/system/user-auth',
    component: Layout,
    hidden: true,
    children: [
      {
        path: 'role/:userId(\\d+)',
        component: (resolve) => require(['@/views/system/user/authRole'], resolve),
        name: 'AuthRole',
        meta: { title: '分配角色', activeMenu: '/system/user' }
      }
    ]
  },
  {
    path: '/system/role-auth',
    component: Layout,
    hidden: true,
    children: [
      {
        path: 'user/:roleId(\\d+)',
        component: (resolve) => require(['@/views/system/role/authUser'], resolve),
        name: 'AuthUser',
        meta: { title: '分配用户', activeMenu: '/system/role' }
      }
    ]
  },
  {
    path: '/system/dict-data',
    component: Layout,
    hidden: true,
    children: [
      {
        path: 'index/:dictId(\\d+)',
        component: (resolve) => require(['@/views/system/dict/data'], resolve),
        name: 'Data',
        meta: { title: '字典数据', activeMenu: '/system/dict' }
      }
    ]
  },
  {
    path: '/monitor/job-log',
    component: Layout,
    hidden: true,
    children: [
      {
        path: 'index',
        component: (resolve) => require(['@/views/monitor/job/log'], resolve),
        name: 'JobLog',
        meta: { title: '调度日志', activeMenu: '/monitor/job' }
      }
    ]
  },
  {
    path: '/tool/gen-edit',
    component: Layout,
    hidden: true,
    children: [
      {
        path: 'index',
        component: (resolve) => require(['@/views/tool/gen/editTable'], resolve),
        name: 'GenEdit',
        meta: { title: '修改生成配置', activeMenu: '/tool/gen' }
      }
    ]
  }
]

export default new Router({
  mode: 'history', // 去掉url中的#
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})
