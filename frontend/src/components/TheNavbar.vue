<template>
  <div class="navbar">
    <div class="container navbar-line">
      <div class="navbar-content">
        <router-link to="/" class="navbar-logo">
          <img src="/img/LOGO_2_0_1.svg" alt="" />
        </router-link>
        <ul class="navbar-menu">
          <router-link to="/catalog" class="navbar-menu__item"
            >Каталог</router-link
          >
          <router-link to="/" class="navbar-menu__item">Домашняя</router-link>
          <router-link to="/constructor" class="navbar-menu__item"
            >Конструктор</router-link
          >
          <button
            v-if="!$store.state.isAuth"
            class="navbar-menu__item login-btn"
            @click="checkModal"
          >
            Вход
          </button>
          <button
            v-if="$store.state.isAuth"
            class="navbar-menu__item login-btn"
          >
            <img src="/img/out.svg" alt="out" />
          </button>
        </ul>
        <router-link to="/basket" class="basket">
          <div class="counter" v-if="$store.state.basketCounter > 0">
            {{ $store.state.basketCounter }}
          </div>
          <img src="/img/basket.png" alt="basket" id="basket-img" />
        </router-link>
      </div>
    </div>
    <div v-if="$store.state.modalActive">
      <App-modal />
    </div>
    {{ checkPath() }}
  </div>
</template>

<script>
import AppModal from "./AppModal.vue";
export default {
  components: { AppModal },
  methods: {
    checkModal() {
      if (!this.$store.state.modalActive) {
        this.$store.state.modalActive = true;
        document.querySelector("body").style.overflow = "hidden";
      }
    },
    checkPath() {
      if (this.$route.path == "/basket") {
        this.$store.state.basketActive = true;
      } else {
        this.$store.state.basketActive = false;
      }
    },
  },
};
</script>

<style lang="scss" scoped>
@import url("https://fonts.googleapis.com/css2?family=Ubuntu&display=swap");

.navbar-logo.active {
  border-bottom: none;
}

.login-btn {
  background: none;
  border: none;
  cursor: pointer;
}

.basket {
  position: relative;
  margin-right: 10px;
  margin-bottom: 9px;
  // &:hover {
  //   // добавить эффекты
  // }
}

.counter {
  position: absolute;
  width: 25px;
  height: 20px;
  border-radius: 10px;
  background-color: #fc7500;
  display: flex;
  justify-content: center;
  align-items: center;
  color: white;
  top: -5px;
  right: -10px;
}

.active {
  border-bottom: 2px solid #ed7102;
}

.navbar-content {
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.navbar-logo {
  width: 308px;
  height: 89px;
}
.navbar-line {
  padding: 27px 0;
  border-bottom: 1px solid #b8b3ad;
}
.navbar-menu {
  display: flex;
  align-items: center;
  &__item {
    text-decoration: none;
    color: black;
    margin-left: 118px;
    padding-bottom: 8px;
    &:hover {
      color: #ed7102;
    }
    &:first-child {
      margin-left: 0;
    }
  }
}
</style>
