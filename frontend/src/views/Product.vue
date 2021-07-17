<template>
  <div class="product">
    <div class="container product-flex">
      <div class="left-side">
        <img :src="products[id].link" alt="" />
      </div>
      <div class="right-side">
        <h2 class="product-title">{{ products[id].name }}</h2>
        <div class="product-info">
          <div class="title">
            <h5 v-for="(title, index) in titles" :key="index">
              {{ title }}
            </h5>
          </div>
          <div>
            <h5
              v-for="(param, index) in products[id]"
              :key="index"
            >
              {{ param }}
            </h5>
          </div>
        </div>
        <div class="btn-center">
          <button
            class="btn"
            v-if="checkAdd"
            @click="addToBasket"
          >
            В корзину
          </button>
          <button disabled class="btn" v-if="checkAdded">Добавлено</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { products } from "../mocks/data";

export default {
  data() {
    return {
      products,
      id: this.$route.params["id"],
      titles: ["Тематика", "Тип", "Материал", "Размер", "Цена"],
    };
  },
  methods: {
    addToBasket() {
      let basket = JSON.parse(localStorage.getItem("basket"))
      basket.basketProducts.push({ ...products[this.id], quantity: 1 })
      localStorage.removeItem("basket")
      localStorage.setItem('basket', JSON.stringify(basket))
      this.$store.state.cardFlag = true;
    }
  },
  computed: {
    checkAdd() {
      if (!this.$store.state.cardFlag) {
        return true;
      }
      return false
    },
    checkAdded() {
      if (this.$store.state.cardFlag) {
        return true;
      }
      return false
    }
  }
};
</script>

<style lang="scss" scoped>
h5 {
  display: block;
}
img {
  min-width: 450px;
  min-height: 450px;
  width: 100%;
  height: auto;
}
.product-title {
  text-align: center;
}

.title{
  margin-right: 40px;
}

.btn{
  color: black;
  padding: 10px;
  border-radius: 7px;
  font-size: 23px;
  background-color: #e8770e;
  border: 2px solid #e8770e;
  &:hover {
    background-color: #ffaa60;
  }
}

.btn-center{
  text-align: center;
  margin-top: 30px;
}
.product-flex {
  display: flex;
  justify-content: space-around;
  padding: 30px;
}
.right-side {
  font-size: 28px;
}
.product-info {
  display: flex;
  margin-top: 25px;
  justify-content: center;
}
</style>
