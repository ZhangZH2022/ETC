import { createRouter, createWebHashHistory } from 'vue-router'

const routes = [
  {
    name: 'home',
    path: '/',
    meta: {
      title: '首页',
    },
    component: () => import('../views/Home.vue'),
  },
  {
    name: 'search',
    path: '/search',
    meta: {
      title: '首页',
    },
    component: () => import('../views/Search.vue'),
  },

]
const router = createRouter({
  history: createWebHashHistory(),
  routes,
})
export default router