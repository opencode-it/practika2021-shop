<template>
  <div class="products">
    <div class="products-place">
      <router-link to="/catalog/cups" class="products-sector">
        <h2 class="products-title">{{title}}</h2>
        <img src="../../public/img/title-element.svg" class="products-title__element">
      </router-link>
      <div class="products-flex">
        <router-link to="/" class="flex-item" v-for="product in products" :key="product.id">
          <img :src='product.link' class="item">
          <span class="product-name">{{product.name.substring(0, 12)}}</span>
        </router-link>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  props: ['title', 'products']
}
</script>

<style lang="scss" scoped>

.products{
  padding-top: 20px;
  margin-bottom: 100px;
}

.products-place {
  padding-top: 40px;
}

.product-name{
  display: block;
  font-style: 18px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 22px 24px;
  color: black;
}

.products-sector{
  display: flex;
  text-decoration: none;
  margin-bottom: 39px;
}

.flex-item{
  position: relative;
  background-color: #e0dad2;
  border-radius: 12px;
  margin-left: 20px;
  text-decoration: none;
  &:first-child {
    margin-left: 0;
  }
}

.flex-item:hover {
  background-color: #e79247;
  box-shadow: -1px 1px 14px 19px rgba(34, 60, 80, 0.2);
}

.item{
  position: relative;
  top: -2px;
  width: 100%;
  height: auto;
}

.products-title{
  color: black;
  margin-right: 38px;
  &:hover {
    color: #ED7102;
  }
}

.products-flex{
  display: flex;
  justify-content: space-between;
}

.products-title__element {
  display: block;
}

@media (max-width: 1117px) {
  .products-flex{

  }
}

</style>