<template>
  <router-link
    to=""
    @click.prevent="checkClass"
    class="flex-item"
    v-if="typeMain == item.type || typeMain == `All`"
  >
    <div class="router-item">
      <img :src="item.link" class="item" alt="item" />
      <span v-if="item.name" class="product-name">{{
        item.name.substring(0, 12)
      }}</span>
      <div v-if="!item.name" class="flex-basket">
        <div class="left-arrow arrow" @click="add">&lt;</div>
        <input type="number" class="input-count" id="input-count" />
        <div class="right-arrow arrow">&gt;</div>
      </div>
    </div>
  </router-link>
</template>

<script>
export default {
  props: {
    item: {
      type: Object,
      default: () => {},
    },
    typeMain: {
      type: String,
    },
  },
  methods: {
    checkClass(event) {
      if (event.target.className == "item") {
        this.$router.push("/catalog");
      }
    },
    add() {},
    remove() {},
  },
};
</script>

<style lang="scss" scoped>
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
  display: flex;
  justify-content: center;
  align-items: center;
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
  display: block;
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
