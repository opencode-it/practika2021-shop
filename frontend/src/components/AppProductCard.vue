<template>
  <router-link
    to=""
    @click.prevent="checkClass"
    class="flex-item"
    v-if="filterProducts"
  >
    <div class="router-item">
      <img :src="item.link" class="item" alt="item" />
      <span
        v-if="!$store.state.basketActive"
        class="product-name">{{
        item.name.substring(0, 12)
      }}</span>
      <div v-if="$store.state.basketActive" class="flex-basket">
        <div class="left-arrow arrow" @click="remove(index)">&lt;</div>
        <input type="number" :value="count" class="input-count" id="input-count" />
        <div class="right-arrow arrow" @click="add(index)">&gt;</div>
      </div>
    </div>
  </router-link>
</template>

<script>
import { basket } from "../mocks/data";

export default {
  data() {
    return {
      basket,
      count: this.quantity,
      id: this.item.id
    };
  },
  props: {
    item: {
      type: Object,
      default: () => {},
    },
    index: {
      type: Number,
      default: () => 0
    },
    title: {
      type: String,
      default: () => "",
    },
    typeMain: {
      type: String,
      default: () => "",
    },
    quantity: {
      type: Number,
      default: () => 1,
    },
  },
  methods: {
    checkClass(event) {
      if (event.target.className == "item") {
        this.$store.state.cardFlag = false;
        this.$router.push("/product/" + this.id);
      }
    },
    add(index) {
      this.count++
      let storage = JSON.parse(localStorage.getItem('basket'))
      localStorage.removeItem("basket")
      storage.basketProducts[index].quantity++
      localStorage.setItem('basket', JSON.stringify(storage))
    },
    remove(index) {
      if (this.count !== 1) {
        this.count--
        let storage = JSON.parse(localStorage.getItem('basket'))
        localStorage.removeItem("basket")
        storage.basketProducts[index].quantity--
        localStorage.setItem('basket', JSON.stringify(storage))
      }
    },
  },
  computed: {
    filterProducts() {
      if (
        this.item.type == this.title ||
        (this.typeMain == this.item.type || this.typeMain == `All`)
      ) {
        if (
          this.item.topic == this.$store.state.catalogTopic ||
          this.$store.state.catalogTopic == `All`
        ) {
          return true;
        }
      }
      if (this.$store.state.basketActive) {
        return true;
      }
      return false;
    }
  },
};
</script>

<style lang="scss" scoped>
input[type='number'] {
  -moz-appearance:textfield;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}
.product-name {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 22px 24px;
  color: black;
}

.arrow {
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

.flex-basket {
  display: flex;
  justify-content: center;
  align-items: center;
  align-content: center;
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

.item {
  position: relative;
  top: -2px;
  min-width: 186px;
  height: auto;
}

.router-item {
  text-decoration: none;
  position: relative;
  border-radius: 12px;
  background-color: #e0dad2;
}

.flex-item {
  text-decoration: none;
  background-color: #e0dad2;
  border-radius: 12px;
  margin-left: 20px;
}

.router-item:hover {
  background-color: #e79247;
  box-shadow: -1px 1px 14px 19px rgba(34, 60, 80, 0.2);
}
</style>
