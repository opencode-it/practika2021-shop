<template>
  <div class="navbar">
    <div class="container navbar-main">
      <ul class="navbar-menu">
        <li
          class="navbar-menu__item"
          :style="flags[index] ? isActive : isDisabled"
          v-for="(title, index) in titles"
          :key="title"
          @click="takeTitle(index)"
        >
          {{ title }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      flags: [true, false, false],
      titles: ["Майка", "Тарелка", "Кружка"],
      isActive: {
        color: "#e8770e",
      },
      isDisabled: {
        color: "black",
      },
    };
  },
  methods: {
    takeTitle(index) {
      for (let i = 0; i < this.flags.length; i++) {
        this.flags[i] = false;
      }
      this.flags[index] = true;
    },
  },
};
</script>

<style lang="scss" scoped>
.navbar {
  padding: 20px 0;
}
.navbar-menu {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 28px;
}
.navbar-main {
  border-bottom: 1px solid #b8b3ad;
  padding-bottom: 20px;
}
.navbar-menu__item {
  list-style: none;
  user-select: none;
  margin-left: 80px;
  &:hover {
    color: #e8770e;
  }
  &:first-child {
    margin-left: 0;
  }
}
</style>
