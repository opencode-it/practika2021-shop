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
          <h6 class="panel-text" @change="slider">
            Высота от
            <input
              v-model.number="options.minHeightCup"
              type="number"
              class="min-price"
              min="0"
              max="150"
            />
            до
            <input
              v-model.number="options.maxHeightCup"
              type="number"
              class="max-price"
              min="0"
              max="150"
            />мм
          </h6>
          <div class="range-slider">
            <input
              @change="slider"
              v-model.number="options.minHeightCup"
              min="0"
              max="150"
              step="10"
              type="range"
            />
            <input
              @change="slider"
              v-model.number="options.maxHeightCup"
              min="0"
              max="150"
              step="10"
              type="range"
            />
          </div>
          <h6 class="panel-text">
            Диаметр от
            <input
              v-model.number="options.minDiameterCup"
              type="number"
              class="min-price"
              min="0"
              max="150"
            />
            до
            <input
              v-model.number="options.maxDiameterCup"
              type="number"
              class="max-price"
              min="0"
              max="150"
            />мм
          </h6>
          <div class="range-slider">
            <input
              @change="slider"
              v-model.number="options.minDiameterCup"
              min="0"
              max="150"
              step="10"
              type="range"
            />
            <input
              @change="slider"
              v-model.number="options.maxDiameterCup"
              min="0"
              max="150"
              step="10"
              type="range"
            />
          </div>
          <h4 class="panel-text">Майки</h4>
          <h6 class="panel-text">
            <input
              v-model.number="options.minTshirt"
              type="number"
              class="min-price"
              min="44"
              max="54"
            />
            <input
              v-model.number="options.maxTshirt"
              type="number"
              class="max-price"
              min="44"
              max="54"
            />
          </h6>
          <div class="range-slider">
            <input
              @change="slider"
              v-model.number="options.minTshirt"
              min="44"
              max="54"
              step="2"
              type="range"
            />
            <input
              @change="slider"
              v-model.number="options.maxTshirt"
              min="44"
              max="54"
              step="2"
              type="range"
            />
          </div>
          <h4 class="panel-text">Тарелки</h4>
          <h6 class="panel-text">
            Высота от
            <input
              v-model.number="options.minHeightPlate"
              type="number"
              class="min-price"
              min="0"
              max="10"
            />
            до
            <input
              v-model.number="options.maxHeightPlate"
              type="number"
              class="max-price"
              min="0"
              max="10"
            />мм
          </h6>
          <div class="range-slider">
            <input
              @change="slider"
              v-model.number="options.minHeightPlate"
              min="0"
              max="10"
              step="1"
              type="range"
            />
            <input
              @change="slider"
              v-model.number="options.maxHeightPlate"
              min="0"
              max="10"
              step="1"
              type="range"
            />
          </div>
        </div>
        <button class="accordion" @click="move(1)">
          Основной цвет<span class="accordion-arrow">&lsaquo;</span>
        </button>
        <div class="panel"></div>
        <div class="panel"></div>
        <button class="accordion" @click="move(2)">
          Материал<span class="accordion-arrow">&lsaquo;</span>
        </button>
        <div class="panel"></div>
        <button class="accordion" @click="move(3)">
          Тематика<span class="accordion-arrow">&lsaquo;</span>
        </button>
        <div class="panel">
          <h4
            :style="topicFlags[index] ? isActive : isDisabled"
            class="topics"
            v-for="(item, index) in topics"
            :key="item"
            @click="topicEvent(index)"
          >
            {{ item }}
          </h4>
        </div>
      </div>
    </div>
    <div class="content-products">
      <App-add-card />
      <App-product-card
        v-for="(item, index) in products"
        :key="index"
        :item="item"
        :index="index"
        :typeMain="$store.state.catalogType"
        :productID="$route.params.id"
      />
      <The-next-cards />
    </div>
  </div>
</template>

<script>
import AppProductCard from "./AppProductCard.vue";
import { products } from "../mocks/data";
import AppAddCard from "./AppAddCard.vue";
import TheNextCards from "./TheNextCards";

export default {
  data() {
    return {
      options: {
        minHeightCup: "0",
        maxHeightCup: "150",
        minDiameterCup: "0",
        maxDiameterCup: "150",
        minTshirt: "44",
        maxTshirt: "54",
        minHeightPlate: "0",
        maxHeightPlate: "10",
        minDiameterPlate: "0",
        maxDiameterPlate: "200",
      },
      topics: [
        "Все",
        "Игры",
        "Кино",
        "Приколы",
        "Животные",
        "Спорт",
        "Музыка",
        "Работа",
        "Хобби",
      ],
      isActive: {
        color: "#ed7102",
      },
      isDisabled: {
        color: "black",
      },
      topicFlags: [true, false, false, false, false, false, false, false],
      products,
    };
  },
  components: { AppProductCard, AppAddCard, TheNextCards },
  methods: {
    slider() {
      if (this.options.minPrice > this.options.maxPrice) {
        let tmp = this.options.maxPrice;
        this.options.maxPrice = this.options.minPrice;
        this.options.minPrice = tmp;
      }
    },
    topicEvent(index) {
      for (let i = 0; i < this.topicFlags.length; i++) {
        this.topicFlags[i] = false;
      }
      this.topicFlags[index] = true;

      switch (this.topics[index]) {
        case "Все":
          this.$store.state.catalogTopic = "All";
          break;
        case "Игры":
          this.$store.state.catalogTopic = "Игры";
          break;
        case "Кино":
          this.$store.state.catalogTopic = "Кино";
          break;
        case "Приколы":
          this.$store.state.catalogTopic = "Приколы";
          break;
        case "Животные":
          this.$store.state.catalogTopic = "Животные";
          break;
        case "Спорт":
          this.$store.state.catalogTopic = "Спорт";
          break;
        case "Музыка":
          this.$store.state.catalogTopic = "Музыка";
          break;
        case "Работа":
          this.$store.state.catalogTopic = "Работа";
          break;
        case "Хобби":
          this.$store.state.catalogTopic = "Хобби";
          break;
      }
    },
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
  },
};
</script>

<style lang="scss" scoped>
.content-products {
  padding: 40px 40px;
  display: grid;
  grid-template-rows: 1fr 1fr 1fr;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 2vw;
  justify-items: end;
}

.topics {
  font-size: 21px;
  margin-bottom: 4px;
  user-select: none;
  &:hover {
    color: #e79247;
  }
}

.min-price {
  min-width: 30px;
}
.max-price {
  min-width: 35px;
}

.panel-height {
  width: 100%;
}

.range-slider {
  width: 300px;
  text-align: center;
  position: relative;
  height: 10px;
  margin-bottom: 15px;
}

.range-slider svg,
.range-slider input[type="range"] {
  position: absolute;
  left: 0;
  bottom: 0;
}

input[type="number"] {
  text-align: center;
  -moz-appearance: textfield;
}

input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
  -webkit-appearance: none;
}

input[type="number"]:invalid,
input[type="number"]:out-of-range {
  border: 2px solid #ff6347;
}

input[type="range"] {
  -webkit-appearance: none;
  width: 100%;
}

input[type="range"]:focus {
  outline: none;
}

input[type="range"]:focus::-webkit-slider-runnable-track {
  background: #b8b3ad;
}

input[type="range"]:focus::-ms-fill-lower {
  background: #b8b3ad;
}

input[type="range"]:focus::-ms-fill-upper {
  background: #b8b3ad;
}

input[type="range"]::-webkit-slider-runnable-track {
  width: 100%;
  height: 5px;
  cursor: pointer;
  animate: 0.2s;
  background: #b8b3ad;
  border-radius: 1px;
  box-shadow: none;
  border: 0;
}

input[type="range"]::-webkit-slider-thumb {
  z-index: 2;
  position: relative;
  box-shadow: 0px 0px 0px #000;
  border: 1px solid #ed7102;
  height: 18px;
  width: 18px;
  border-radius: 25px;
  background: #ed7102;
  cursor: pointer;
  -webkit-appearance: none;
  margin-top: -7px;
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

.accordions {
  min-width: 337px;
  border-right: 1px solid #b8b3ad;
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
  position: relative;
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
