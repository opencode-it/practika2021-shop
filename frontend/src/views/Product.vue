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
            <h5 class="item_left" v-for="(title, index) in titles" :key="index">
              {{ title }}
            </h5>
          </div>
          <div>
            <h5
              class="item_right"
              v-for="(param, index) in filterObject"
              :key="index"
            >
              {{ param }}
            </h5>
          </div>
        </div>
        <div class="btn-center">
          <div class="quantity">
            <div
              class="left-arrow arrow"
              @click="tmpQuantity > 1 ? tmpQuantity-- : null"
            >
              &lt;
            </div>
            <input type="number" :value="tmpQuantity" class="input-count" />
            <div class="right-arrow arrow" @click="tmpQuantity++">&gt;</div>
          </div>
          <button class="btn" v-if="checkAdd" @click="addToBasket">
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
      tmpQuantity: 1,
      products: { ...products },
      id: this.$route.params["id"],
      titles: ["Тематика", "Тип", "Материал", "Размер", "Цена"],
    };
  },
  methods: {
    addToBasket() {
      let basket = JSON.parse(localStorage.getItem("basket"));
      basket.basketProducts.push({
        ...products[this.id],
        quantity: this.tmpQuantity,
      });
      localStorage.removeItem("basket");
      localStorage.setItem("basket", JSON.stringify(basket));
      this.$store.state.cardFlag = true;
      this.$store.state.basketCounter++;
      localStorage.removeItem("basket-counter");
      localStorage.setItem(
        "basket-counter",
        JSON.stringify(this.$store.state.basketCounter)
      );
    },
  },
  computed: {
    checkAdd() {
      if (!this.$store.state.cardFlag) {
        return true;
      }
      return false;
    },
    checkAdded() {
      if (this.$store.state.cardFlag) {
        return true;
      }
      return false;
    },
    filterObject() {
      const list = ["topic", "type", "material", "size", "price"];
      const proxy = this.products[this.id];
      return Object.values(proxy).filter((item, index) => {
        return list.includes(Object.keys(proxy)[index]) ? item : null;
      });
    },
  },
};
</script>

<style lang="scss" scoped>
h5 {
  display: block;
}
img {
  width: 450px;
  height: 450px;
  object-fit: cover;
}

input[type="number"] {
  -moz-appearance: textfield;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}

.product-title {
  text-align: center;
}

.input-count {
  display: flex;
  text-align: center;
  font-size: 20px;
  width: 60px;
  border: none;
  height: 34px;
  margin-top: 14px;
  margin-bottom: 15px;
}

.quantity {
  display: flex;
  justify-content: center;
  align-items: center;
  align-content: center;
}

.arrow {
  user-select: none;
  width: 35px;
  height: 35px;
  font-size: 30px;
  color: #ed7102;
  background-color: #b8b3ad;
  border: 2px solid #b8b3ad;
  display: flex;
  justify-content: center;
  align-items: center;
  &:active {
    border: 2px solid #ed7102;
    color: #b8b3ad;
  }
}

.right-arrow {
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
}

.left-arrow {
  border-top-left-radius: 10px;
  border-bottom-left-radius: 10px;
}

.title {
  margin-right: 130px;
}

.btn {
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

.item_left {
  margin-bottom: 5px;
}

.item_right {
  margin-bottom: 6px;
}

.btn-center {
  text-align: center;
  margin-top: 30px;
  display: flex;
  justify-content: space-between;
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
