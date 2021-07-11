<template>
  <div class="footer">
    <div class="container footer-line">
      <div class="footer-flex">
        <router-link to="/" class="footer-logo">
          <img src="../../public/img/LOGO_2_0_1.svg" />
        </router-link>
        <div class="footer-social">
          <a href="http://www.facebook.com" class="social-link">
            <img src="../../public/img/social/facebook.svg" />
          </a>
          <a href="http://www.vk.com" class="social-link">
            <img src="../../public/img/social/vk.svg" />
          </a>
          <a href="http://www.instagram.com" class="social-link">
            <img src="../../public/img/social/instagram.svg" />
          </a>
        </div>
        <div class="footer-phone">+7(977)777-77-77</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
.footer {
  padding-top: 60px;
}

.footer-social {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.footer-flex {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 40px 0;
}
.footer-phone {
  font-size: 36px;
  color: #b8b3ad;
}

.footer-line {
  border-top: 1px solid #b8b3ad;
}

@media (max-width: 930px) {
  .footer-logo {
    display: none;
  }
  .footer {
    padding-left: 30px;
    padding-right: 30px;
  }

  .footer-phone {
    font-size: 20px;
  }

  .footer-social {
    width: 200px;
    height: 50px;
  }
}
</style>
