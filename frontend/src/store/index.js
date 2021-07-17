import { createStore } from "vuex";

export default createStore({
  state: {
    cardFlag: false,
    sumOrder: 0,
    catalogType: "All",
    catalogTopic: "All",
    basketCounter: 0,
    basketActive: false,
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
