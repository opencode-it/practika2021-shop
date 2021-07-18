<template>
  <div class="creator">
    <div class="creator-container">
      <div class="creator-content">
        <div class="creator-left">
          <div class="creator-left__shapesplace">
            <h4 class="creator-title">Фигуры</h4>
            <div class="creator-left__shapes">
              <div
                v-for="(form, index) in shapes"
                :key="index"
                :class="form"
              ></div>
            </div>
          </div>
          <div class="creator-left__images"></div>
        </div>
        <div class="creator-center">center</div>
        <div class="creator-right">right</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      shapes: [
        "rect",
        "circle",
        "triangle",
        "star",
        "parallelogram",
        "rhombus",
      ],
    };
  },
};
</script>

<style lang="scss" scoped>
.rect {
  width: 100px;
  height: 100px;
  background: none;
  border: 1px solid #b8b3ad;
  margin: 10px;
}
.circle {
  margin: 10px;
  width: 100px;
  height: 100px;
  background: none;
  -moz-border-radius: 50px;
  -webkit-border-radius: 50px;
  border: 1px solid #b8b3ad;
  border-radius: 50px;
}
.triangle {
  margin: 10px;
  width: 0;
  height: 0;
  border-left: 50px solid transparent;
  border-right: 50px solid transparent;
  border-bottom: 100px solid #b8b3ad;
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

.creator-left__shapes {
  display: grid;
  justify-items: center;
  grid-template-rows: 1fr 1fr;
  grid-template-columns: 1fr 1fr 1fr;
  border: 1px solid #b8b3ad;
  border-radius: 4px;
}
</style>
