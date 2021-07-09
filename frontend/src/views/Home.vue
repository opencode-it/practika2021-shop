<template>
  <div class="home">
    <div class="container">
      <TheSlider/>
      <TheProducts  
        v-for="item in $store.state.products"
        :products="item.content"
        :title="item.title"
        :key="item"
      />
      <TheAbout/>
    </div>
  </div>
</template>

<script>
import TheAbout from '../components/TheAbout.vue';
import TheProducts from '../components/TheProducts.vue';
import TheSlider from '../components/TheSlider.vue';


export default {
  components: { TheProducts, TheAbout, TheSlider }
};
</script>

<style lang="scss" scoped>

</style>
