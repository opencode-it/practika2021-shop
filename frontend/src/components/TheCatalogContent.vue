<template>
  <div class="content">
    <div class="accordions">
      <button class="accordion" @click="move(0)">
        Размер<span class="accordion-arrow">&lsaquo;</span>
      </button>
      <div class="panel">
        <p>Lorem ipsum...</p>
      </div>

      <button class="accordion" @click="move(1)">
        Основной цвет<span class="accordion-arrow">&lsaquo;</span>
      </button>
      <div class="panel">
        <p>Lorem ipsum...</p>
      </div>

      <button class="accordion" @click="move(2)">
        Форма<span class="accordion-arrow">&lsaquo;</span>
      </button>
      <div class="panel">
        <p>Lorem ipsum...</p>
      </div>

      <button class="accordion" @click="move(3)">
        Материал<span class="accordion-arrow">&lsaquo;</span>
      </button>
      <div class="panel">
        <p>Lorem ipsum...</p>
      </div>

      <button class="accordion" @click="move(4)">
        Тематика<span class="accordion-arrow">&lsaquo;</span>
      </button>
      <div class="panel">
        <p>Lorem ipsum...</p>
      </div>
    </div>

    <div class="content-products">
      sdfsdfsdfs
    </div> 

    <!-- <div class="content-menu" id="catalog-menu">
      <div class="arrow">&lsaquo;</div>
      <div class="content-accordion">

        <div class="accordion-item">
          <h3 class="accordion-title">Размер<span class="accordion-arrow">&lsaquo;</span></h3>
          <div class="accordion-content">

          </div>
        </div>
        
         <div class="accordion-item">
          <h3 class="accordion-title">Основной цвет<span class="accordion-arrow">&lsaquo;</span></h3>
          <div class="accordion-content">
            
          </div>
        </div>
        
         <div class="accordion-item">
          <h3 class="accordion-title">Форма<span class="accordion-arrow">&lsaquo;</span></h3>
          <div class="accordion-content">
            
          </div>
        </div>

         <div class="accordion-item">
          <h3 class="accordion-title">Материал<span class="accordion-arrow">&lsaquo;</span></h3>
          <div class="accordion-content">
            
          </div>
        </div>

         <div class="accordion-item">
          <h3 class="accordion-title">Тематика<span class="accordion-arrow">&lsaquo;</span></h3>
          <div class="accordion-content">
            
          </div>
        </div>
      </div>
    </div> -->
    
  </div>
</template>

<script>
export default {
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
  },
};
</script>

<style lang="scss" scoped>
.accordion {
  border: none;
  position: relative;
  color: black;
  cursor: pointer;
  padding: 18px;
  width: 100%;
  text-align: left;
  background-color: white;
  outline: none;
  transition: 0.4s;
  display: flex;
  user-select: none;
  font-size: 27px;
  &:active {
    .accordion-arrow {
      color: #ed7102;
    }
  }
}


.panel {
  padding: 0 18px;
  background-color: white;
  display: none;
  overflow: hidden;
}

.content {
  border-top: 1px solid #b8b3ad;
  margin-top: 34px;
  display: flex;
}

// .content-menu {
//   border-right: 1px solid #b8b3ad;
//   position: relative;
// }

.content-products {
  border-left: 1px solid #b8b3ad;
}

.arrow {
  position: absolute;
  top: -10px;
  right: 5px;
  color: #ed7102;
  font-weight: bold;
  font-size: 38px;
}

// .accordion-title {
//   user-select: none;
//   display: flex;
//   font-size: 27px;
//   &:active {
//     .accordion-arrow {
//       color: #ed7102;
//     }
//   }
// }

// .accordion-title .active {
//   color: #b8b3ad;
//   transform: rotate(180deg);
// }

.accordion-arrow {
  display: block;
  margin-left: 20px;
  color: #ed7102;
  transform: rotate(90deg);
}

// .accordion-item {
//   cursor: pointer;
//   padding-right: 20px;
//   padding-top: 20px;
// }
</style>
