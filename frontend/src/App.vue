<template>
  <div>
    <Navbar/>
    <div v-if="$store.state.modalActive">
      <Modal/>
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
import Modal from './components/Modal.vue'
import Navbar from './components/Navbar.vue'

export default {
  components: { Navbar, Modal },
  
}
</script>

<style lang="scss">
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
body {
  font-family: 'Ubuntu', sans-serif;
}
.container{
  max-width: 1070px;
  margin: 0 auto;
}
</style>
