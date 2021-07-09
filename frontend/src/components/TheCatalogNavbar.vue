<template>
  <div>
    <ul class="catalog-menu">
      <router-link to="/catalog" class="catalog-menu__item">Все</router-link>
      <router-link to="/catalog/cups" class="catalog-menu__item">Кружки</router-link>
      <router-link to="/catalog/tshirts" class="catalog-menu__item">Майки</router-link>
      <router-link to="/catalog/plates" class="catalog-menu__item">Тарелки</router-link>
    </ul>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="scss" scoped>

.catalog-menu__item.active {
  color: #ED7102;
}
.catalog-menu {
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  padding: 30px 0;
  border-bottom: 1px solid #B8B3AD;
  margin-bottom: 35px;
  &__item {
    display: block;
    color: black;
    font-size: 21px;
    text-decoration: none;
    user-select: none;
    &:hover {
      color: #ED7102;
    }
    
  }
}

.catalog-menu__item:active {
  color: #ED7102;
}
</style>