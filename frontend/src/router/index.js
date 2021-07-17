import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import Constructor from "../views/Constructor.vue";
import Catalog from "../views/Сatalog.vue";
import Basket from "../views/Basket.vue";
import Incorrect from "../views/Incorrect.vue";
import Product from "../views/Product.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/constructor",
    name: "Constructor",
    component: Constructor,
  },
  {
    path: "/catalog",
    name: "Catalog",
    component: Catalog,
  },
  {
    path: "/basket",
    name: "Basket",
    component: Basket,
  },
  {
    path: "/:notFound(.*)",
    name: "Incorrect",
    component: Incorrect,
  },
  {
    path: "/product/:id",
    name: "Product",
    component: Product
  }
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
  linkActiveClass: "active",
  linkExactActiveClass: "active",
});

export default router;
