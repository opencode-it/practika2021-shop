<template>
  <div class="container registration">
    <form class="registration-form" @submit.prevent="sendRegistrationInfo">
      
      <h2 class="registration-title">Регистрация</h2>

      <div class="form-column">
        <label for="name">Имя</label>
        <input type="text" v-model="name">
      </div>

      <div class="form-column">
        <label for="surename">Фамилия</label>
        <input type="text" v-model="surename">
      </div>

      <div class="form-column">
        <label for="surename">Отчество</label>
        <input type="text" v-model="patronymic">
      </div>

      <div class="form-column">
        <label for="email">Почта</label>
        <input type="email" v-model="email">
      </div>


      <div class="form-column">
        <label for="name">Создайте Пароль</label>
        <input type="password" v-model="theFirstPass">
      </div>

      <div class="form-column">
        <label for="name">Повторите пароль</label>
        <input type="password" v-model="theSecondPass">
      </div>

      <div class="form-column">
        <button type="submit" class="btn-create">Создать аккаунт</button>
        <span class="m-2">или</span>
        <button class="form-login" @click="$store.state.modalActive = true">Войти</button>
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

</style>