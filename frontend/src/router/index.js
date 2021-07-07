import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import Constructor from "../views/Constructor.vue"
import Catalog from "../views/Сatalog.vue"
import Registration from "../views/Registration.vue"
import Basket from "../views/Basket.vue" 

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/constructor",
    name: "Constructor",
    component: Constructor
  },
  {
    path: "/catalog",
    name: "Catalog",
    component: Catalog
  },
  {
    path: "/registration",
    name: "Registration",
    component: Registration
  },
  {
    path: "/basket",
    name: "Basket",
    component: Basket
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: 'active',
  linkExactActiveClass: 'active'
})

export default router;
