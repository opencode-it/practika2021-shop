<template>
  <div class="catalog">
    <div class="container">
      <Catalog-navbar/>
      <Search/>
    </div>
  </div>
</template>

<script>
import CatalogNavbar from '../components/CatalogNavbar.vue'
import Search from '../components/Search.vue'
export default {
  components: { CatalogNavbar, Search },

}
</script>

<style>

</style>