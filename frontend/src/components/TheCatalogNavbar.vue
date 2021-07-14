<template>
  <div>
    <ul class="catalog-menu">
      <li
        :style="flags[index] ? isActive : isDisabled"
        class="catalog-menu__item"
        v-for="(item, index) in titles"
        :key="item"
        @click="navbarEvent(index)"
      >{{item}}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      isActive: {
        color: "#ed7102"
      },
      isDisabled: {
        color: "black"
      },
      flags: [true, false, false, false],
      titles: ["Все", "Кружки", "Майки", "Тарелки"]
    };
  },
  methods: {
    navbarEvent(index) {
      for (let i = 0; i < this.flags.length; i++) {
        this.flags[i] = false;
      }
      this.flags[index] = true;

      if (this.titles[index] == "Все") {
        this.$store.state.catalogType = "All"
      }
      if (this.titles[index] == "Кружки") {
        this.$store.state.catalogType = "Кружка"
      }
      if (this.titles[index] == "Майки") {
        this.$store.state.catalogType = "Майка"
      }
      if (this.titles[index] == "Тарелки") {
        this.$store.state.catalogType = "Тарелка"
      }
    },
  },
  props: {
    index: {
      type: Number,
    },
  }
};
</script>

<style lang="scss" scoped>
.catalog-menu__item.active {
  color: #ed7102;
}
.catalog-menu {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  padding: 30px 0;
  border-bottom: 1px solid #b8b3ad;
  margin-bottom: 35px;
  &__item {
    display: block;
    color: black;
    font-size: 21px;
    text-decoration: none;
    user-select: none;
    &:hover {
      color: #ed7102;
    }
  }
}

.catalog-menu__item:active {
  color: #ed7102;
}
</style>
