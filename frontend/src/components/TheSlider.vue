<template>
  <div class="slider">
    <button type="button" v-if="right!=0" class="slider-control-left" @click="arrowLeft">
      <span class="slider-arrow">&lsaquo;</span>
    </button>
    <button type="button" v-if="right!=-2140" class="slider-control-right" @click="arrowRight">
      <span class="slider-arrow">&rsaquo;</span>
    </button>

    <div class="slider-place">
      <div class="slider-item" v-for="item in 3" :key="item">
        <img src="../../public/img/slider-img.png" />
        <h1 class="slider-text">
          Cоздай свой дизайн в<br />
          удобном конструкторе
        </h1>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      counter: 0,
      right: 0,
    };
  },
  methods: {
    arrowLeft() {
      const slider = document.querySelector(".slider-place");
      this.right = this.right + 1070;
      slider.style.right = -this.right + "px";
    },
    arrowRight() {
      const slider = document.querySelector(".slider-place");
      this.right = this.right - 1070;
      slider.style.right = -this.right + "px";
    }
  },
};
</script>

<style lang="scss" scoped>
.slider {
  position: relative;
  display: flex;
  height: 100%;
  width: 100%;
  overflow: hidden;
}


.slider-place {
  position: relative;
  display: flex;
  transition-property: right;
  right: 0;
  transition: all ease 1s;
}

img {
  max-width: 1070px;
  min-height: 400px;
}

.slider-item {
  position: relative;
}

.slider-text {
  position: absolute;
  z-index: 5;
  bottom: 143px;
  left: 120px;
  color: white;
  font-size: 38px;
  user-select: none;
}

.slider-control-right {
  position: absolute;
  top: 0;
  bottom: 0;
  z-index: 20;
  right: 0;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 15%;
  padding: 0;
  text-align: center;
  border: none;
  background: none;
}

.slider-control-left {
  position: absolute;
  top: 0;
  bottom: 0;
  z-index: 20;
  display: flex;
  align-items: center;
  justify-content: center;
  width: 15%;
  padding: 0;
  text-align: center;
  border: none;
  background: none;
}

.slider-arrow {
  user-select: none;
  color: #ed7102;
  font-size: 180px;
  font-weight: bold;
  &:hover {
    color: rgb(233, 174, 86);
  }
  &:active {
    color: white;
  }
}
</style>
