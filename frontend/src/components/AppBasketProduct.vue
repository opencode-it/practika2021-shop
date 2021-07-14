<template>
  <div class="basket-product">
    <div class="basket-card">
      <App-product-card :item="basket" :index="index"/>
    </div>
    <div class="card-info">
      <div class="delete" @click="deleteProduct(index)">&#10006;</div>
      <div class="left-side">
        <h4>Тематика</h4>
        <h4>Тип</h4>
        <h4>Материал</h4>
        <h4>Размер</h4>
        <h4>Цена</h4>
      </div>
      <div class="right-side">
        <h4>{{ basket.topic }}</h4>
        <h4>{{ basket.type }}</h4>
        <h4>{{ basket.material }}</h4>
        <h4>{{ basket.size }}</h4>
        <h4>{{ basket.price }}руб/шт.</h4>
      </div>
    </div>
  </div>
</template>

<script>
import AppProductCard from "./AppProductCard.vue";
export default {
  props: {
    basket: {
      type: Object,
      default: () => {},
    },
    index: {
      type: Number
    }
  },
  methods: {
    deleteProduct(index) {
      console.log(index);
    },
  },
  components: { AppProductCard },
};
</script>

<style lang="scss" scoped>
h4.left-side {
  display: block;
}
.card-info {
  position: relative;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border: 4px solid #b8b3ad;
  font-size: 25px;
  padding: 40px;
  border-radius: 10px;
  min-width: 821px;
  margin-left: 4px;
}

.delete {
  font-weight: bold;
  user-select: none;
  font-size: 29px;
  color: black;
  background-color: #d02e2e;
  border-radius: 10px;
  position: absolute;
  top: 0;
  right: 0;
  width: 40px;
  display: flex;
  justify-content: center;
  align-items: center;
  &:hover {
    color: orange;
  }
  &:active {
    background-color: rgb(211, 67, 67);
  }
}

.basket-product {
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
