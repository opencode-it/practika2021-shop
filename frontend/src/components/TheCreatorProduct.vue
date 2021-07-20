<template>
  <div class="creator">
    <div class="creator-container">
      <div class="creator-content">
        <div class="creator-left">
          <div class="creator-left__shapesplace">
            <h4 class="creator-title">Фигуры</h4>
            <div class="creator-left__shapes">
              <img
                v-for="(form, index) in shapes"
                :key="index"
                :src="'/img/shapes/'+ form + '.png'"
                class="form"
                @click="addShape(form)"
              />
            </div>
          </div>
          <div class="creator-left__images">
            <h4 class="creator-title">Изображения</h4>
            <div class="creator-left__imgplace">
              <img
                :src="'/img/' + img"
                v-for="img in images"
                :key="img"
                class="creator-left__img"
              />
            </div>
            <div style="text-align: center;">
              <input type="file" hidden id="file-btn" @change="input"/>
              <button class="btn-upload" @click="upload">Загрузить</button>
            </div>
          </div>
        </div>

        <div class="creator-center">
          <input type="text" v-model="text" class="input" id="input">
          <div class="add-text" @click="addNewText">
            Добавить текст
          </div>
          <div>
            <canvas ref="can" id="canvas" width="450" height="500"></canvas>
          </div>
          <div class="colors">
            <div class="color-grid">
              <div
                v-for="color in colors"
                :key="color"
                :style="{'backgroundColor': color}"
                class="color"
                @click="selectProductColor(color)"
              ></div>
            </div>
          </div>
        </div>

        <div class="creator-right">
          <div class="creator-right__top">
            <div class="creator-right__img">
              <h4 class="creator-title">Размер картинки</h4>
              <div class="range-slider">
                <input
                  @input="zoom"
                  @change="slider"
                  v-model.number="imgSize"
                  min="0"
                  max="20"
                  step="0.01"
                  type="range"
                />
              </div>
            </div>
          </div>
          <div class="creator-right__center">
            <h3 class="creator-title">Размер</h3>
            <h4 class="creator-title" @change="slider">
              Высота от
              <input
                v-model.number="options.minHeight"
                type="number"
                class="min-price"
                min="0"
                max="150"
              />
              до
              <input
                v-model.number="options.maxHeight"
                type="number"
                class="max-price"
                min="0"
                max="150"
              />мм
            </h4>
            <div class="range-slider">
              <input
                @change="slider"
                v-model.number="options.minHeight"
                min="0"
                max="150"
                step="10"
                type="range"
              />
              <input
                @change="slider"
                v-model.number="options.maxHeight"
                min="0"
                max="150"
                step="10"
                type="range"
              />
            </div>
            <h4 class="creator-title">
              Диаметр от
              <input
                v-model.number="options.minDiameter"
                type="number"
                class="min-price"
                min="0"
                max="150"
              />
              до
              <input
                v-model.number="options.maxDiameter"
                type="number"
                class="max-price"
                min="0"
                max="150"
              />мм
            </h4>
            <div class="range-slider">
              <input
                @change="slider"
                v-model.number="options.minDiameter"
                min="0"
                max="150"
                step="10"
                type="range"
              />
              <input
                @change="slider"
                v-model.number="options.maxDiameter"
                min="0"
                max="150"
                step="10"
                type="range"
              />
            </div>
            <h3 class="creator-title">Материал</h3>
          </div>
          <h4 class="creator-title">Текст и фигуры</h4>
          <div class="creator-text" ref="textPlace">
            <div v-for="(text, index) in texts" :key="index" class="text-info">
              <div class="counter">{{index + 1}}</div>
              <h5 class="text-title" v-if="texts.length > 0">{{text.title}}</h5>
              <input
                type="color"
                class="color-item"
                @input="selectColor(index, $event)"
              >
              <div class='close' @click="deleteItem(index)">&#10006;</div>
            </div>
          </div>
          <div style="text-align: center;" class="creator-right__basketbtn">
            <button class="basket-btn btn-upload">В корзину</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { fabric } from "fabric"
export default {
  data() {
    return {
      text: '',
      imgSize: "0",
      options: {
        minHeight: "20",
        maxHeight: "150",
        minDiameter: "20",
        maxDiameter: "150",
      },
      selectedColor: '',
      colors: [
        "#6dd5fa", "#d7e6fd", "#5a98fb", "#4032e7",
        "#8e38ef", "#c73e86", "#dc5758", "#eb9f49",
        "#efae2c", "#fee856", "#363333",
        "#bcbcbc"
      ],
      texts: [],
      textColor: '',
      images: [],
      shapes: [
        "rect",
        "circle",
        "triangle",
        "star",
        "parallelogram",
        "rect",
      ]
    };
  },
  methods: {
    selectColor(index, event) {
      console.log(index)
      console.log(event.target.value);
    },
    zoom() {
      let zoom = global.canvas.getZoom()
      zoom = this.imgSize;
      global.canvas.setZoom(zoom);
    },
    slider() {
      if (this.options.minPrice > this.options.maxPrice) {
        let tmp = this.options.maxPrice;
        this.options.maxPrice = this.options.minPrice;
        this.options.minPrice = tmp;
      }
    },
    selectProductColor(color) {
      this.selectedColor = color;
      global.canvas.backgroundColor = this.selectedColor;
      global.canvas.renderAll()
    },
    input() {
      const btn = document.getElementById('file-btn')
      this.images.push(btn.files[0].name)
      fabric.Image.fromURL(`/img/${btn.files[0].name}`, function(img) {
        img.scaleToWidth(100);
        img.scaleToHeight(100);
        global.canvas.add(img);
      });
    },
    upload() {
      const btn = document.getElementById('file-btn')
      btn.click()
    },
    addShape(form) {

      switch (form) {
        case "rect":
          this.newShape = new fabric.Rect({
            background: 'transparent',
            width: 80,
            height: 80,
            zIndex: 5
          })
          global.canvas.add(this.newShape)
          this.newShape.center()

          break;
        case "circle":

          break;
        case "triangle":
          this.triangle = new fabric.Triangle({
            width: 80,
            height: 80,
            zIndex: 5
          })
          global.canvas.add(this.triangle)
          this.triangle.center()
          break;
        case "star":

          break;
        case "parallelogram":

          break;
      }
    },
    addNewText() {
      const text = new fabric.Text(this.text, {})
      console.log(fabric)
      this.texts.push({
        title: this.text,
        fill: ''
      })
      global.canvas.add(text)
      this.text = ''
    }
  },
  mounted() {
    const canvas = new fabric.Canvas(this.$refs.can);
    window.canvas = canvas;
    fabric.Image.fromURL(`/img/${this.$store.state.constructorProduct}.png`,
      (img) => {
      img.set({
        zIndex: 1
      })
      canvas.backgroundImage = img;
      canvas.backgroundColor = this.selectedColor;
      canvas.renderAll()
    })
  }
};
</script>

<style lang="scss" scoped>
.creator-right {
  padding: 0 13px;
  border-left: 3px solid #b8b3ad;
}
.close {
  font-size: 17px;
  color: #450c0c;
  &:hover {
    color: #d51b1b;
  }
}
.color-item {
  width: 20px;
}
.text-info {
  display: flex;
  justify-content: space-between;
  align-items: center;
  user-select: none;
  margin-bottom: 5px;
}
.text-title {
  font-size: 17px;
}
.counter {
  color: black;
  font-weight: bold;
}
.input {
  position: absolute;
  top: 0;
  left: 0;
  font-size: 20px;
  height: 35px;
  text-align: center;
}


.add-text {
  user-select: none;
  position: absolute;
  cursor: pointer;
  top: 0;
  right: 20px;
  padding: 10px;
  background-color: aqua;
  opacity: 0.4;
  border-bottom-right-radius: 7px;
  border-bottom-left-radius: 7px;
  &:hover {
    opacity: 1;
  }
}

.creator-text {
  overflow: auto;
  margin: 10px;
  padding: 8px;
  max-height: 280px;
  min-height: 200px;
  border-radius: 10px;
  border: 1px solid #b8b3ad;
}

.range-slider svg,
.range-slider input[type="range"] {
  position: absolute;
  left: 0px;
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
.range-slider {
  width: 300px;
  text-align: center;
  position: relative;
  height: 10px;
  margin-bottom: 15px;
}

.creator-left__img {
  width: 230px;
  height: auto;
  margin-bottom: 10px;
}

.creator-left__imgplace {
  display: flex;
  flex-direction: column-reverse;
  overflow: auto;
  margin: 10px;
  padding: 8px;
  max-height: 280px;
  min-height: 280px;
  border-radius: 10px;
  border: 1px solid #b8b3ad;
}

.color-grid {
  display: grid;
  grid-template-rows: 1fr 1fr 1fr 1fr;
  grid-template-columns: 1fr 1fr 1fr;
}

.color {
  cursor: crosshair;
  height: 40px;
  width: 90px;
}

.colors {
  margin-bottom: 40px;
  margin-top: 40px;
  display: flex;
  justify-content: center;
}

.form {
  width: 80px;
  margin-bottom: 10px;
  border-radius: 8px;
  padding: 6px;
  &:hover {
    box-shadow: -1px 1px 14px 19px rgba(34, 60, 80, 0.2);  }
}

.btn-upload {
  margin-top: 35px;
  padding: 15px;
  background: #e8770e;
  color: black;
  border-radius: 8px;
  font-size: 23px;
  border: 5px solid #e8770e;

  &:hover {
    background-color: #e78028;
    color: #363535;
  }

  &:focus {
    border: 5px solid #e8a35c;
    color: black;
  }
}

.creator-content { position: relative}
.creator-center {
  padding-top: 45px;
  position: relative;
}
.creator-container {
  max-width: 1200px;
  margin: 0 auto;
}
.creator-content {
  display: flex;
  justify-content: space-between;
  border: 3px solid #b8b3ad;
  border-radius: 4px;
}
.creator-title {
  padding-top: 20px;
  padding-bottom: 20px;
  text-align: center;
}
.creator-left {
  border-right: 3px solid #b8b3ad;
}
.creator-content {
  border-right: 3px solid #b8b3ad;
}

.creator-left__shapesplace {
  padding: 10px;
}

.creator-left__shapes {
  padding: 8px;
  position: relative;
  display: grid;
  justify-items: center;
  grid-template-rows: 1fr 1fr;
  grid-template-columns: 1fr 1fr 1fr;
  border: 1px solid #b8b3ad;
  border-radius: 4px;
}
</style>
