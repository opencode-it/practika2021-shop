<template>
  <div class="content">
    <div class="accordions" id="catalog-menu">
      <div class="content-accordion">
        <div class="arrow">&lsaquo;</div>
        <button class="accordion" @click="move(0)">
          Размер<span class="accordion-arrow">&lsaquo;</span>
        </button>
        <div class="panel active">
          <h4 class="panel-text">Кружки</h4>
          <h4 class="panel-text">Высота от {} до {} мм</h4>
          <input
            type="range"
            class="panel-height"
            step="1"
            min="0"
            max="130"
            @change.prevent="getValue"
          />
        </div>
        <button class="accordion" @click="move(1)">
          Основной цвет<span class="accordion-arrow">&lsaquo;</span>
        </button>
        <div class="panel"></div>
        <button class="accordion" @click="move(2)">
          Форма<span class="accordion-arrow">&lsaquo;</span>
        </button>
        <div class="panel"></div>
        <button class="accordion" @click="move(3)">
          Материал<span class="accordion-arrow">&lsaquo;</span>
        </button>
        <div class="panel"></div>
        <button class="accordion" @click="move(4)">
          Тематика<span class="accordion-arrow">&lsaquo;</span>
        </button>
        <div class="panel"></div>
      </div>
    </div>
    <div class="content-products">
      <App-add-card />
      <App-product-card
        v-for="(item, index) in mainCatalog"
        :item="item"
        :key="item"
        :index="index"
        :typeMain="$store.state.catalogType"
      />
      <The-next-cards />
    </div>
  </div>
</template>

<script>
import AppProductCard from "./AppProductCard.vue";
import { mainCatalog } from "../mocks/data";
import AppAddCard from "./AppAddCard.vue";
import TheNextCards from "./TheNextCards";

export default {
  data() {
    return {
      mainCatalog,
    };
  },
  components: { AppProductCard, AppAddCard, TheNextCards },
  methods: {
    move(id) {
      let acc = document.getElementsByClassName("accordion");
      acc[id].classList.toggle("active");
      let panel = acc[id].nextElementSibling;
      if (panel.style.display === "block") {
        panel.style.display = "none";
      } else {
        panel.style.display = "block";
      }
    },
    getValue(event) {
      console.log(event.target.value);
    },
  },
};
</script>

<style lang="scss" scoped>
.content-products {
  padding: 40px 40px;
  display: grid;
  grid-template-rows: 1fr 1fr 1fr 1fr;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-gap: 2vw;
  justify-items: end;
}

.panel-height {
  width: 100%;
}

.panel-text {
  margin-top: 12px;
  margin-bottom: 12px;
  font-size: 20px;
}

.accordion {
  border: none;
  position: relative;
  color: black;
  cursor: pointer;
  padding: 18px;
  margin-right: 40px;
  width: 100%;
  text-align: left;
  background-color: white;
  justify-content: space-between;
  outline: none;
  transition: 0.4s;
  display: flex;
  user-select: none;
  font-size: 27px;
  margin-top: 10px;
}

.accordion.active {
  .accordion-arrow {
    color: #b8b3ad;
    transform: rotate(270deg);
    transition-property: transform;
    transition-duration: 0.8s;
  }
}

.accordions.active {
  display: none;
  .arrow {
    color: #b8b3ad;
    transform: rotate(270deg);
    transition-property: transform;
    transition-duration: 0.8s;
  }
}

.panel {
  text-align: center;
  padding: 0 18px;
  background-color: white;
  display: none;
  overflow: hidden;
}

.content {
  border-top: 1px solid #b8b3ad;
  margin-top: 34px;
  display: flex;
  justify-content: center;
}

.arrow {
  user-select: none;
  position: absolute;
  top: -18px;
  right: 5px;
  color: #ed7102;
  font-weight: bold;
  font-size: 38px;
  z-index: 10;
}

.accordion-arrow {
  display: inline;
  margin-left: 10px;
  color: #ed7102;
  transform: rotate(90deg);
}

.content-accordion {
  position: relative;
  border-right: 1px solid #b8b3ad;
}

@media (max-width: 1065px) {
  .content-products {
    padding: 40px 40px;
    display: grid;
    grid-template-rows: 1fr 1fr 1fr 1fr;
    grid-template-columns: 1fr 1fr 1fr;
    grid-gap: 2vw;
    justify-items: end;
  }
}

@media (max-width: 871px) {
  .content-products {
    padding: 40px 40px;
    display: grid;
    grid-template-rows: 1fr 1fr 1fr 1fr;
    grid-template-columns: 1fr 1fr;
    grid-gap: 2vw;
    justify-items: end;
  }
}
</style>
