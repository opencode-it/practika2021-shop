import { createStore } from "vuex";

export default createStore({
  state: {
    modalActive: false,
    modalLoginActive: false,
    modalFollowActive: false,
    catalogMenu: false,
    products: {
      cups: {
        title: 'Кружки',
        content: [
          {link: require('../assets/cups/cup1.svg'), id:0, name: 'BA-BUM-TSS!'},
          {link: require('../assets/cups/cup2.svg'), id:1, name: 'NEO-BUM'},
          {link: require('../assets/cups/cup3.svg'), id:2, name: 'Я работаю в эт..'},
          {link: require('../assets/cups/cup4.svg'), id:3, name: 'Админ шокол...'},
          {link: require('../assets/cups/cup5.svg'), id:4, name: 'JoJo Coffe'},
          {link: require('../assets/cups/cup6.svg'), id:5, name: 'Juventus'},
        ]
      },
      tshirts: {
        title: 'Майки',
        content: [
          {link: require('../assets/t-shirts/tshirt1.svg'), id:0, name: 'Science'},
          {link: require('../assets/t-shirts/tshirt2.svg'), id:1, name: 'Я в своем позн..'},
          {link: require('../assets/t-shirts/tshirt3.svg'), id:2, name: 'CatMem'},
          {link: require('../assets/t-shirts/tshirt4.svg'), id:3, name: 'Tech'},
          {link: require('../assets/t-shirts/tshirt5.svg'), id:4, name: 'Directed by ...'},
          {link: require('../assets/t-shirts/tshirt6.svg'), id:5, name: 'Free Rick'},
        ]
      },
      plates: {
        title: 'Тарелки', 
        content: [
          {link: require('../assets/plates/plate1.svg'), id:0, name: 'Dog'},
          {link: require('../assets/plates/plate2.svg'), id:1, name: 'Мой день'},
          {link: require('../assets/plates/plate3.svg'), id:2, name: 'Photographer'},
          {link: require('../assets/plates/plate4.svg'), id:3, name: 'Garfield'},
          {link: require('../assets/plates/plate5.svg'), id:4, name: 'Mario'},
          {link: require('../assets/plates/plate6.svg'), id:5, name: 'Nirvana'},
        ]
      }
    }
  },
  mutations: {},
  actions: {},
  modules: {},
});
