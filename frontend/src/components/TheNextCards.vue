<template>
  <div class="next-cards" @click="getOtherCards">
    <div class="next-top">&rsaquo;</div>
    <div class="next-bottom">Больше</div>
  </div>
</template>

<script>
export default {
  methods: {
    getOtherCards() {
      this.$store.state.watch += 14
    },
  },
};
</script>

<style lang="scss" scoped>
.next-cards {
  user-select: none;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  text-align: center;
  min-width: 186px;
  min-height: 253px;
  background-color: #b8b3ad;
  border-radius: 10px;
  &:hover {
    background-color: #e79247;
    box-shadow: -1px 1px 14px 19px rgba(34, 60, 80, 0.2);
  }
}

.next-top {
  font-size: 180px;
  color: #ed7102;
}
.next-bottom {
  margin-bottom: 20px;
}
</style>
