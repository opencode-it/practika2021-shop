<template>
  <router-link to="/" class="flex-item">
    <img :src="item.link" class="item" />
    <span class="product-name">{{ item.name.substring(0, 12) }}</span>
  </router-link>
</template>

<script>
export default {
  props: {
    item: {
      type: Object,
      default: () => {},
    },
  },
};
</script>

<style lang="scss" scoped>

.product-name{
  display: block;
  font-style: 18px;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 22px 24px;
  color: black;
}


.item {
  position: relative;
  top: -2px;
  width: 100%;
  height: auto;
}

.flex-item {
  position: relative;
  background-color: #e0dad2;
  border-radius: 12px;
  margin-left: 20px;
  text-decoration: none;
}

.flex-item:hover {
  background-color: #e79247;
  box-shadow: -1px 1px 14px 19px rgba(34, 60, 80, 0.2);
}
</style>
