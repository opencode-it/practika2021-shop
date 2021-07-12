import { createStore } from "vuex";

export default createStore({
  state: {
    basketCounter: 0,
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
