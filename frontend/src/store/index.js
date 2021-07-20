import { createStore } from "vuex";

export default createStore({
  state: {
    cardFlag: false,
    sumOrder: 0,
    catalogType: "All",
    catalogTopic: "All",
    basketCounter: JSON.parse(localStorage.getItem("basket-counter")),
    basketActive: false,
    constructorProduct: "tshirt",
    modalActive: false,
    modalLoginActive: true,
    modalRegisterActive: false,
    modalFollowActive: false,
    catalogMenu: false,
    isAdmin: false,
    isAuth: false,
  },
  mutations: {},
  actions: {},
  modules: {},
});
