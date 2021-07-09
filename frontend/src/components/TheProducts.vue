<template>
  <div class="products">
    <div class="products-place">
      <router-link to="/catalog/cups" class="products-sector">
        <h2 class="products-title">{{title}}</h2>
        <img src="../../public/img/title-element.svg" class="products-title__element">
      </router-link>
    </div>
      <div class="products-flex">
        <App-product-card v-for="product in products" :item="product" :key="product"/>
      </div>
  </div>
</template>

<script>
import AppProductCard from './AppProductCard.vue'
export default {
  components: { AppProductCard },
  props: {
    title: {
      type: String,
      default: () => ''
    },
    products: {
      type: Array,
      default: () => []
    }
  }
}
</script>

<style lang="scss" scoped>

.products-flex {
  display: flex;
  justify-content: space-between;
}

.products{
  padding-top: 20px;
  margin-bottom: 100px;
}

.products-place {
  padding-top: 40px;
}


.products-sector{
  display: flex;
  text-decoration: none;
  margin-bottom: 39px;
}


.products-title{
  color: black;
  margin-right: 38px;
  &:hover {
    color: #ED7102;
  }
}

.products-title__element {
  display: block;
}


</style>