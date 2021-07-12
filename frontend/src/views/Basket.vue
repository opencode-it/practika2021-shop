<template>
  <div class="container">
    <div class="basket-page">
      <h2 class="basket-title">Корзина товаров</h2>
      <div class="basket-items">
        <App-basket-product
          :basket="info"
          v-for="info in basket.basketProducts"
          :key="info"
        />
      </div>
    </div>
  </div>
</template>

<script>
import AppBasketProduct from "../components/AppBasketProduct.vue";
import { basket } from "../mocks/data";
export default {
  data() {
    return {
      basket,
    };
  },
  components: { AppBasketProduct },
};
</script>

<style scoped lang="scss">
.container {
  border: 5px solid #b8b3ad;
  border-top: 10px solid#b8b3ad;
  border-radius: 10px;
  min-width: 1070px; /* Удалить */
  width: 100%;
  margin: 0 auto;
  margin-top: 30px;
}
.basket-title {
  text-align: center;
  border-bottom: 1px solid #b8b3ad;
  margin-bottom: 30px;
}
.basket-title {
  padding: 32px 0;
}
</style>
