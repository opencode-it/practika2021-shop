<template>
  <div class="footer">
    <div class="container footer-line">
      <div class="footer-flex">
        <router-link to="/" class="footer-logo">
          <img src="../assets/LOGO_2_0_1.svg">
        </router-link>
        <div class="footer-social">
          <a href="http://www.facebook.com" class="social-link">
            <img src="../assets/social/facebook.svg">
          </a>
          <a href="http://www.vk.com" class="social-link">
            <img src="../assets/social/vk.svg">
          </a>
          <a href="http://www.instagram.com" class="social-link">
            <img src="../assets/social/instagram.svg">
          </a>
        </div>
        <div class="footer-phone">+7(977)777-77-77</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style lang="scss">
.footer{
  padding-top: 60px;
}

.footer-social{
  display: flex;
  justify-content: space-between;
  align-items: center;
}


.footer-flex{
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 40px 0;
}
.footer-phone {
  font-size: 36px;
  color: #B8B3AD;
}

.footer-line{
  border-top: 1px solid #B8B3AD;
}
</style>