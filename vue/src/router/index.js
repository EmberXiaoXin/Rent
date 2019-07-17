import Vue from 'vue'
import Router from 'vue-router'
// in development env not use Lazy Loading,because Lazy Loading too many pages will cause webpack hot update too slow.so only in production use Lazy Loading
/* layout */
import Layout from '../views/layout/Layout'

const _import = require('./_import_' + process.env.NODE_ENV)
Vue.use(Router)
export const constantRouterMap = [
  {path: '/login', component: _import('login/index'), hidden: true},
  {path: '/404', component: _import('404'), hidden: true},
  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: '首页',
    hidden: true,
    children: [{
      path: 'dashboard', component: _import('dashboard/index')
    }]
  }
]
export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})
export const asyncRouterMap = [
  {
    path: '/system',
    component: Layout,
    redirect: '/system/article',
    name: '功能模块',
    meta: {title: '功能模块', icon: 'tree'},
    children: [
      {
        path: 'article',
        name: '文章',
        component: _import('article/article'),
        meta: {title: '文章', icon: 'example'},
        menu: 'article'
      },
    ]
  },
  //用户管理
  {
    path: '/wxUser',
    component: Layout,
    redirect: '/wxUser/',
    name: '',
    meta: {title: '微信管理', icon: 'wx'},
    children: [
      {
        path: 'wxUser',
        name: '用户管理',
        component: _import('wxUser/wxUser'),
        meta: {title: '用户管理', icon: 'user1'},
        menu: 'user1'
      },
      {
        path: 'wxLogin',
        name: '登录管理',
        component: _import('wxUser/wxLogin'),
        meta: {title: '登录管理', icon: 'user1'},
        menu: 'wxLogin'
      },
    ]
  },
  //帖子管理
  {
    path: '/Post',
    component: Layout,
    redirect: '/Post/',
    name: '',
    meta: {title: '帖子管理', icon: 'Post'},
    children: [
      {
        path: 'Post',
        name: '帖子管理',
        component: _import('Post/Post'),
        meta: {title: '帖子管理', icon: 'Post'},
        menu: 'user1'
      },
      {
        path: '',
        name: '标签管理',
        component: _import('Post/Post'),
        meta: {title: '标签管理', icon: 'Post'},
        menu: 'user1'
      }
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: '',
    meta: {title: '用户权限', icon: 'table'},
    children: [
      {
        path: '', name: '用户列表', component: _import('user/user'), meta: {title: '用户列表', icon: 'user'}, menu: 'user'
      },
      {
        path: 'role',
        name: '权限管理',
        component: _import('user/role'),
        meta: {title: '权限管理', icon: 'password'},
        menu: 'role'
      },
    ]
  },


  {
    path: '/platformManage',
    component: Layout,
    redirect: '/platformManage/',
    name: '',
    meta: {title: '平台管理', icon: 'table'},
    children: [
      {
        path: 'postLabel',
        name: '帖子标签',
        component: _import('platformManage/postLabel'),
        meta: {title: '帖子标签', icon: 'mng'},
        menu: 'platform'
      },
      {
        path: 'postType',
        name: '帖子类别',
        component: _import('platformManage/postType'),
        meta: {title: '帖子类别', icon: 'list'},
        menu: 'platform'
      },
    ]
  },
  {path: '*', redirect: '/404', hidden: true}
]
