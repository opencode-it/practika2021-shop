<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Магазин</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse d-flex justify-content-between" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <router-link class="nav-link" aria-current="page" to="/">Главная</router-link>
        <router-link class="nav-link" to="/constructor">Конструктор</router-link>
        <router-link class="nav-link" to="/catalog">Каталог</router-link>
      </div>
      <div class="right-side d-flex">
        <router-link to="/basket">
          <div class="basket-high">
            <div class="counter"></div>
            <img src="../assets/basket.svg" class="basket"/>
          </div>
        </router-link>
        <router-link to="/registration">
          <button class="btn btn-danger registration">Регистрация</button>
        </router-link>
        <router-link to="/entrance">
          <button class="btn btn-info ms-2 entrance">Вход</button>
        </router-link>
      </div>
    </div>
  </div>
</nav>
</template>

<script>
export default {
  
}
</script>

<style lang="scss">
.basket{
  margin-right: 20px;
  width: 40px;
  height: 40px;
  color: white;
}
.basket-high{
  position: relative;
}

.counter{
  width: 20px;
  height: 20px;
  border-radius: 50%;
  background-color: rgb(241, 48, 48);
  position: absolute;
  font-weight: bold;
  color: black;
  top: -7px;
  left: -5px;
  display: none;
  justify-content: center;
  align-items: center;
}

</style>