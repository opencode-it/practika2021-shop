<template>
  <div class="search">
    <div class="burger">
      <ul @click="burgerActive" id="burger">
        <li></li>
        <li></li>
        <li></li>
      </ul>
    </div>
    <div class="search-place">
      <input type="search" placeholder="search" class="search-input" />
      <button type="submit" class="search-btn">
        <img src="../../public/img/search.svg" />
      </button>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    burgerActive() {
      const burger = document.getElementById("burger");
      burger.classList.toggle("active");
    },
  },
};
</script>

<style lang="scss" scoped>
ul {
  left: 0;
  top: 0;
  position: absolute;
  width: 42px;
  height: 42px;
  background: #fff;
  border-radius: 20px;
  overflow: hidden;
  cursor: pointer;
}
ul li {
  list-style: none;
  position: absolute;
  transform: translateY(-50%);
  width: 70%;
  height: 5px;
  background: grey;
  transition: 1s;
}
ul li:nth-of-type(1) {
  top: 30%;
  left: 15%;
  transition-delay: 1s;
  opacity: 1;
}
ul li:nth-of-type(2) {
  top: 50%;
  left: 15%;
  transition-delay: 0s;
  background: grey;
}
ul li:nth-of-type(3) {
  top: 70%;
  right: 15%;
  transition-delay: 1s;
  opacity: 1;
}
ul.active li:nth-of-type(1) {
  left: 100%;
  transition-delay: 0s;
  opacity: 0;
}
ul.active li:nth-of-type(2) {
  transform: translateY(-50%) rotate(405deg);
  transition-delay: 0.5s;
  background: #ed7102;
}
ul.active li:nth-of-type(3) {
  right: 100%;
  transition-delay: 0s;
  opacity: 0;
}

ul li:nth-of-type(2)::before {
  content: "";
  position: absolute;
  top: -150px;
  left: 0;
  width: 100%;
  height: 100%;
  background: grey;
  transform: rotate(90deg);
  transition: 1s;
  transition-delay: 0.5s;
}
ul.active li:nth-of-type(2)::before {
  top: 0;
  transition-delay: 1s;
  background: #ed7102;
}

.search {
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}

.search-place {
  background-color: #b8b3ad;
  padding: 2px;
  display: flex;
  border-radius: 5px;
  display: flex;
  align-items: center;
}
.search-input {
  display: block;
  width: 652px;
  height: 41px;
  border: none;
  border-radius: 10px;
  font-size: 23px;
  padding: 3px 5px;
  &:focus {
    outline: none;
    border-radius: 10px;
    border: 3px solid chocolate;
  }
}

.search-btn {
  width: 81px;
  height: 45px;
  border-radius: 10px;
  margin-left: 6px;
  display: flex;
  justify-content: center;
  align-items: center;
  border: none;
  background-color: #ed7102;
  svg:hover {
    color: black;
  }
}
</style>
