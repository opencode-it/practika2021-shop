<template>
  <router-link to="/constructor" class="add-card" id="add-card">
    <div class="add-top">
      <div class="add-circle">
        <span class="add-plus"> + </span>
      </div>
    </div>
    <div class="add-bottom">Сделай сам!</div>
  </router-link>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
.add-card {
  color: black;
  text-decoration: none;
  background-color: #e0dad2;
  border-radius: 12px;
  width: 186px;
  height: 252px;
}

.add-card.full {
  width: 186px;
  height: 252px;
}

.add-bottom {
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 14px;
}

.add-card:hover {
  background-color: #e79247;
  box-shadow: -1px 1px 14px 19px rgba(34, 60, 80, 0.2);
}

.add-top {
  user-select: none;
  position: relative;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 25px;
}

.add-plus {
  font-size: 120px;
  margin-bottom: 15px;
}

.add-circle {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 141px;
  height: 141px;
  border: 2px solid black;
  border-radius: 50%;
}
</style>
