<template>
  <div class="container d-flex justify-content-center mt-5">
    <form class="card registration-form" @submit.prevent="sendRegistrationInfo">
      
      <h2 class="mb-2 text-center">Регистрация</h2>

      <div class="mb-2 d-flex flex-column">
        <label for="name">Имя</label>
        <input type="text" v-model="name">
      </div>

      <div class="mb-2 d-flex flex-column">
        <label for="surename">Фамилия</label>
        <input type="text" v-model="surename">
      </div>

      <div class="mb-2 d-flex flex-column">
        <label for="surename">Отчество</label>
        <input type="text" v-model="patronymic">
      </div>

      <div class="mb-2 d-flex flex-column">
        <label for="email">Почта</label>
        <input type="email" v-model="email">
      </div>


      <div class="mb-2 d-flex flex-column">
        <label for="name">Создайте Пароль</label>
        <input type="password" v-model="theFirstPass">
      </div>

      <div class="mb-2 d-flex flex-column">
        <label for="name">Повторите пароль</label>
        <input type="password" v-model="theSecondPass">
      </div>

      <div class="buttons text-center mt-3">
        <button class="btn btn-success">Создать аккаунт</button>
        <span class="m-2">или</span>
        <router-link to="/entrance">Войти</router-link>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      name: '',
      surename: '',
      patronymic: '',
      email: '',
      theFirstPass: '',
      theSecondPass: ''
    }
  },
  methods: {
    // в дальнейшем будет отправлять данные на сервер
    sendRegistrationInfo() {
      console.log(this.name);
      console.log(this.surename);
      console.log(this.patronymic);
      console.log(this.email);
      console.log(this.theFirstPass);
    }
  }
}
</script>

<style>
input {
  width: 400px;
}
.registration-form{
  padding: 10px 70px;
  box-shadow: -1px 4px 11px 6px rgba(34, 60, 80, 0.2);
}
</style>