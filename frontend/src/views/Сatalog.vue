<template>
  <div class="catalog">
    <div class="container">
      <TheCatalog-navbar/>
      <TheSearch/>
      <TheCatalog-content/>
    </div>
  </div>
</template>

<script>
import TheCatalogContent from '../components/TheCatalogContent.vue'
import TheCatalogNavbar from '../components/TheCatalogNavbar.vue'
import TheSearch from '../components/TheSearch.vue'

export default {
  components: { TheCatalogNavbar, TheSearch, TheCatalogContent },

}
</script>

<style scoped>

</style>