import { createRouter, createWebHistory } from 'vue-router';
import Home from './components/Home.vue';


const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', redirect: '/inicio' },
        { path: '/inicio', component: Home },
    ],
});

export { router };