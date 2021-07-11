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
            placeholder="Введите login"
          />
          <input
            v-model="entranceForm.password"
            type="password"
            class="auth-pass"
            placeholder="Введите пароль"
          />
          <div class="btn-center">
            <button type="submit" class="btn-send">Войти</button>
          </div>
          <div class="btn-center">
            <button type="button" class="google-auth">
              <img
                src="../../public/img/google.png"
                alt="google"
                class="google"
              />
              <h2 class="google-text">Войти с помощью Google</h2>
            </button>
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
            placeholder="Введите почту"
            v-model="register.email"
          />
          <input
            type="number"
            placeholder="Ваш номер телефона"
            v-model="register.phone"
          />
          <input
            type="text"
            placeholder="Придумайте логин"
            v-model="register.login"
          />
          <div class="input-pass">
            <input
              type="password"
              placeholder="Введите пароль"
              v-model="register.theFirstPass"
              class="password-input"
            />
            <a href="#" class="password-control" @click="lookAtMyPass"></a>
          </div>
          <div class="input-pass">
            <input
              type="password"
              placeholder="Повторите пароль"
              v-model="register.theSecondPass"
              class="password-input"
            />
            <a href="#" class="password-control" @click="lookAtMyPass"></a>
          </div>
          <div class="btn-center">
            <button type="submit" class="btn-send">Создать аккаунт</button>
          </div>

          <div class="btn-center">
            <button type="button" class="google-auth">
              <img
                src="../../public/img/google.png"
                alt="google"
                class="google"
              />
              <h2 class="google-text">Войти с помощью Google</h2>
            </button>
          </div>
        </form>
      </div>
      <div class="modal-close" @click="closeModalButton">&#10006;</div>
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
    lookAtMyPass() {
      const eye = document.querySelectorAll(".password-control");
      const input = document.querySelectorAll(".password-input");
      eye.forEach((item, index) => {
        if (input[index].getAttribute("type") == "password") {
          item.classList.add("view");
          input[index].setAttribute("type", "text");
        } else {
          item.classList.remove("view");
          input[index].setAttribute("type", "password");
        }
      });
    },
    closeModalWindow(event) {
      if (event.target.className === "modal") {
        this.$store.state.modalActive = false;
        document.querySelector("body").style.overflow = "visible";
      }
    },
    closeModalButton() {
      this.$store.state.modalActive = false;
      document.querySelector("body").style.overflow = "visible";
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

.input-pass {
  position: relative;
}
.password-control {
  position: absolute;
  right: 110px;
  top: 20px;
  display: inline-block;
  width: 20px;
  height: 20px;
  background: url("../../public/img/view.svg") 0 0 no-repeat;
}

.password-control.view {
  background: url("../../public/img/no-view.svg") 0 0 no-repeat;
}

.form-auth {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 60px;
}

.google {
  width: 60px;
  height: 60px;
}

.google-auth {
  padding: 4px;
  position: relative;
  left: 0;
  right: 0;
  margin-left: auto;
  margin-right: auto;
  border: 2px solid #b8b3ad;
  border-radius: 7px;
  font-size: 14px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: none;
  &:focus {
    color: #ed7102;
  }
}

.btn-send {
  background-color: #ed7102;
  color: white;
  font-size: 22px;
  padding: 10px 15px;
  border: none;
  border-radius: 5px;
  margin-bottom: 10px;
  border: 3px solid white;
  transition: color 0.1s ease-in-out, background-color 0.1s ease-in-out,
    border-color 0.1s ease-in-out, box-shadow 0.1s ease-in-out;
  &:focus {
    color: #b8b3ad;
    border: 3px solid rgb(229, 196, 134);
  }
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
  min-height: 450px;
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
}

.registration-form {
  display: flex;
  flex-direction: column;
}
</style>
