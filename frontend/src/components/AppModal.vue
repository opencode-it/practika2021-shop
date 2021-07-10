<template>
  <div class="modal" @click.stop="closeModalWindow">
    <div class="modal-content">
      <div class="modal-navigation">
        <div
          :style="$store.state.modalLoginActive ? activeStyle : disabledStyle"
          class="modal-entrance"
          @click="entrance"
        >
          Вход
        </div>
        <span class="modal-line">\</span>
        <div
          :style="
            $store.state.modalRegisterActive ? activeStyle : disabledStyle
          "
          class="modal-register"
          @click="register"
        >
          Регистрация
        </div>
      </div>
      <div class="modal-auth" v-if="$store.state.modalLoginActive">
        <form class="form-auth" @submit.prevent="sendAuthInfo">
          <input
            type="text"
            v-model="entranceForm.login"
            class="auth-login"
            placeholder="Введие login"
          />
          <input
            v-model="entranceForm.password"
            type="password"
            class="auth-pass"
            placeholder="Введие пароль"
          />
          <div class="btn-center">
            <button type="submit" class="btn-send">Войти</button>
            <h5>Место для гугл входа</h5>
          </div>
        </form>
      </div>

      <div class="modal-register" v-if="$store.state.modalRegisterActive">
        <form class="registration-form" @submit.prevent="sendRegistrationInfo">
          <input
            type="text"
            placeholder="Введите имя"
            v-model="register.myName"
          />
          <input
            type="text"
            placeholder="Введите фамилию"
            v-model="register.surename"
          />
          <input
            type="email"
            placeholder="Введие почту"
            v-model="register.email"
          />
          <input
            type="number"
            placeholder="Ваш номер телефона"
            v-model="register.phone"
          />
          <input
            type="password"
            placeholder="Введите пароль"
            v-model="register.theFirstPass"
          />
          <input
            type="text"
            placeholder="Придумайте логин"
            v-model="register.login"
          />
          <input
            type="password"
            placeholder="Повторите пароль"
            v-model="register.theSecondPass"
          />
          <div class="btn-center">
            <button type="submit" class="btn-send">Создать аккаунт</button>
            <h5>Место для гугл регистрации</h5>
          </div>
        </form>
      </div>
      <div class="modal-close" @click="$store.state.modalActive = false">
        &#10006;
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      activeStyle: {
        color: "#fc7500",
      },
      disabledStyle: {
        color: "#b8b3ad",
      },
      registerForm: {
        myName: "",
        login: "",
        surename: "",
        phone: "",
        email: "",
        theFirstPass: "",
        theSecondPass: "",
      },
      entranceForm: {
        login: "",
        password: "",
      },
    };
  },
  methods: {
    closeModalWindow(event) {
      if (event.target.className === "modal") {
        this.$store.state.modalActive = false;
        document.querySelector("body").style.overflow = "visible";
      }
    },
    entrance() {
      this.$store.state.modalLoginActive = true;
      this.$store.state.modalRegisterActive = false;
    },
    register() {
      this.$store.state.modalLoginActive = false;
      this.$store.state.modalRegisterActive = true;
    },
    sendAuthInfo() {},
    sendRegistrationInfo() {
      console.log(this.name);
      console.log(this.surename);
      console.log(this.phone);
      console.log(this.email);
      console.log(this.theFirstPass);
    },
  },
};
</script>

<style scoped lang="scss">
input {
  text-align: center;
  margin: 10px 100px;
  padding: 10px 90px;
  border-radius: 7px;
  border: 2px solid #b8b3ad;
  font-size: 15px;
}

.form-auth {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 60px;
}

.btn-send {
  background-color: #ed7102;
  color: white;
  font-size: 25px;
  padding: 10px 15px;
  border: none;
  border-radius: 5px;
  margin-bottom: 10px;
}

.modal {
  position: absolute;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.4);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 30;
}
.modal-content {
  border-color: #b8b3ad;
  position: relative;
  background-color: white;
  min-width: 600px;
  min-height: 500px;
  width: auto;
  border-radius: 10px;
  padding: 15px;
  z-index: 10;
}

.modal-close {
  position: absolute;
  top: 0;
  right: 3px;
  font-size: 20px;
  user-select: none;
  color: red;
  background: none;
  border: none;
}
.modal-navigation {
  display: flex;
  justify-content: center;
  font-size: 30px;
  margin-bottom: 10px;
}

.modal-entrance {
  user-select: none;
  color: #b8b3ad;
  &:hover {
    color: #fc7500;
  }
}
.modal-line {
  margin: 0 30px;
  color: #b8b3ad;
}
.modal-register {
  user-select: none;
  color: #b8b3ad;
  &:hover {
    color: #fc7500;
  }
}

.btn-center {
  text-align: center;
  padding-top: 15px;
  padding-bottom: 15px;
}

.registration-form {
  display: flex;
  flex-direction: column;
}
</style>
