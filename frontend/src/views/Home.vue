<template>
  <div class="home">
    <div class="container">
      <!-- slider place -->

      <Products/>
      <About/>
      <Footer/>
    </div>
  </div>
</template>

<script>
import About from '../components/About.vue';
import Footer from '../components/Footer.vue';
import Products from '../components/Products.vue';


export default {
  components: { Products, About, Footer }
};
</script>

<style lang="scss">

</style>
