<template>
  <div class="home">
    <div class="container">
      <TheSlider />
      <TheProducts
        v-for="item in products"
        :key="item.id"
        :products="item.content"
        :title="item.title"
      />
      <TheAbout />
    </div>
  </div>
</template>

<script>
import TheAbout from "../components/TheAbout.vue";
import TheProducts from "../components/TheProducts.vue";
import TheSlider from "../components/TheSlider.vue";
import { products } from "../mocks/data";

export default {
  data() {
    return {
      products,
    };
  },
  components: { TheProducts, TheAbout, TheSlider },
};
</script>

<style lang="scss" scoped></style>
