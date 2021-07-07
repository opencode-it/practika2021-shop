<template>
  <div class="navbar">
    <div class="container navbar-line">
      <div class="navbar-content">
        <router-link to="/" class="navbar-logo">
          <img src="../assets/LOGO_2_0_1.svg" alt="">
        </router-link>  
        <ul class="navbar-menu">
          <router-link to="/catalog" class="navbar-menu__item">Каталог</router-link>
          <router-link to="/" class="navbar-menu__item">Домашняя</router-link>
          <router-link to="/constructor" class="navbar-menu__item">Конструктор</router-link>
          <button class="navbar-menu__item login-btn" @click="$store.state.modalActive = true">
            Вход
          </button>
        </ul>
        <router-link to="/basket" class="basket">
          <img src="../assets/basket.png" alt="basket">
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');

.navbar {
  
}

.navbar-logo.active {
  border-bottom: none;
}

.login-btn {
  background: none;
  border: none;
  cursor: pointer;
}

.basket{
  &:hover {
    // добавить эффекты
  }
}

.active {
  border-bottom: 2px solid #ED7102;
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
.navbar-line{
  padding: 27px 0;
  border-bottom: 1px solid #B8B3AD;
}
.navbar-menu {

  &__item {
    text-decoration: none;
    color: black;
    margin-left: 118px;
    padding-bottom: 8px;
    &:hover {
      color: #ED7102;
    }
    &:first-child {
      margin-left: 0;
    }
  }
}

</style>