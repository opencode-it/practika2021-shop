<template>
  <div class="products">
    <div class="products-place">
      <router-link to="/catalog/cups" class="products-sector">
        <h2 class="products-title">{{ title }}</h2>
        <img
          src="/img/title-element.svg"
          class="products-title__element"
        />
      </router-link>
    </div>
    <div class="products-flex">
      <App-product-card
        v-for="(product, index) in products"
        :item="product"
        :title="title.slice(0, -1) + 'а'"
        :index="index"
        :key="index"
      />
    </div>
  </div>
</template>

<script>
import AppProductCard from "./AppProductCard.vue";
import { products } from "../mocks/data";

export default {
  data() {
    return {
      products
    };
  },
  components: { AppProductCard },
  props: {
    title: {
      type: String,
      default: () => "",
    }
  },
};
</script>

<style lang="scss" scoped>
.products-flex {
  display: flex;
  justify-content: center;
}

.products {
  padding-top: 20px;
  margin-bottom: 100px;
}

.products-place {
  padding-top: 40px;
}

.products-sector {
  display: flex;
  text-decoration: none;
  margin-bottom: 39px;
}

.products-title {
  color: black;
  margin-right: 38px;
  &:hover {
    color: #ed7102;
  }
}

.products-title__element {
  display: block;
}
</style>
