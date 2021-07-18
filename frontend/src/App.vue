<template>
  <div class="app">
    <TheNavbar />
    <Router-View></Router-View>
    <The-Footer />
  </div>
</template>

<script>
import TheNavbar from "./components/TheNavbar.vue";
import TheFooter from "./components/TheFooter.vue";

export default {
  components: { TheNavbar, TheFooter },
  created() {
    try {
      JSON.parse(localStorage.getItem("basket")).basketProducts.length;
      JSON.parse(localStorage.getItem("basket-counter"));
    } catch (e) {
      localStorage.setItem("basket", JSON.stringify({ basketProducts: [] }));
      localStorage.setItem("basket-counter", JSON.stringify(0));
    }
  },
};
</script>

<style lang="scss">
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
body {
  font-family: "Ubuntu", sans-serif;
}
.container {
  max-width: 1070px;
  margin: 0 auto;
}

.app {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
</style>
