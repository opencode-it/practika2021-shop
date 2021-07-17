<template>
  <div class="basket-product" id="basket-product">
    <div class="basket-card">
      <App-product-card
        :item="basket"
        :quantity="basket.quantity"
        :index="index"
      />
    </div>
    <div class="card-info">
      <div class="delete" @click="deleteProduct(index)">&#10006;</div>
      <div class="left-side">
        <h4 v-for="(title, idx) in titles" :key="idx">{{title}}</h4>
      </div>
      <div class="right-side">
        <h4>{{basket.topic}}</h4>
        <h4>{{basket.type}}</h4>
        <h4>{{basket.material}}</h4>
        <h4>{{basket.size}}</h4>
        <h4>{{basket.price}}руб/шт.</h4>
      </div>
    </div>
  </div>
</template>

<script>
import AppProductCard from "./AppProductCard.vue";
export default {
  data() {
    return {
      titles: ["Тематика", "Тип", "Материал", "Размер", "Цена"]
    };
  },
  components: { AppProductCard },
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
      let nodes = document.querySelector('.basket-items')
      nodes.children[index].remove()
      this.$store.state.basketCounter--
      let storage = JSON.parse(localStorage.getItem('basket'))
      localStorage.clear()
      storage.basketProducts.splice(index, 1)
      localStorage.setItem('basket', JSON.stringify(storage))
    },
  },
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
  top: 6px;
  right: 6px;
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
