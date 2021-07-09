<template>
  <div class="modal" @click.prevent="$store.state.modalLoginActive = false">
    <div class="modal-login">
      <h2>вход</h2>
      <!-- <router-link to="/registration">Регистрация</router-link> -->
      <div class="modal-close" @click="$store.state.modalLoginActive = false">
        &#10006;
      </div>
    </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style scoped>

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
  z-index: 5;
}
.modal-login {
  position: relative;
  background-color: white;
  width: 400px;
  height: 400px;
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
}

</style>