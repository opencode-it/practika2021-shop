<template>
  <div class="home">
    <div class="container">
      <TheSlider />
      <TheProducts v-for="title in titles" :key="title" :title="title" />
      <TheAbout />
    </div>
  </div>
</template>

<script>
import TheAbout from "../components/TheAbout.vue";
import TheProducts from "../components/TheProducts.vue";
import TheSlider from "../components/TheSlider.vue";

export default {
  data() {
    return {
      titles: ["Кружки", "Майки", "Тарелки"],
    };
  },
  components: { TheProducts, TheAbout, TheSlider },
};
</script>

<style lang="scss" scoped></style>
