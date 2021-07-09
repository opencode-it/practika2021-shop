<template>
  <div>
    <TheNavbar/>
    <router-view></router-view>
    <The-footer/>
  </div>
</template>

<script>
import TheNavbar from './components/TheNavbar.vue'
import TheFooter from './components/TheFooter.vue'

export default {
  components: { TheNavbar, TheFooter },
  
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
