<template>
  <div class="home">
    <div class="container">
      <Slider/>
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
import Slider from '../components/Slider.vue';


export default {
  components: { Products, About, Footer, Slider }
};
</script>

<style lang="scss">

</style>
