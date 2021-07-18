<template>
  <form
    @submit.prevent="sendOrder"
    class="register-order"
    v-if="$store.state.basketCounter != 0"
  >
    <div class="sum-block">
      <div class="sum-text">Итого</div>
      <div class="sum">{{ $store.state.sumOrder }}р</div>
    </div>
    <div class="inputs-place">
      <input
        type="text"
        class="order-input"
        placeholder="Введите имя"
        v-model="order.user.name"
      />
      <input
        type="text"
        class="order-input"
        placeholder="Введите фамилию"
        v-model="order.user.surename"
      />
      <input
        type="text"
        class="order-input"
        placeholder="Введите отчество"
        v-model="order.user.patronymic"
      />
      <input
        type="number"
        class="order-input"
        placeholder="Введите телефон"
        v-model="order.user.phone"
      />
      <input
        type="number"
        class="order-input"
        placeholder="Введите индекс"
        v-model="order.user.postIndex"
      />
      <input
        type="number"
        class="order-input"
        placeholder="Введите адрес"
        v-model="order.user.address"
      />
    </div>

    <div class="btn-center">
      <button class="sendOrder">
        Оплатить и<br />
        отправить
      </button>
    </div>
    {{ orderSum() }}
  </form>
</template>

<script>
export default {
  data() {
    return {
      order: {
        user: {
          name: "".trim(),
          surename: "".trim(),
          patronymic: "".trim(),
          phone: "".trim(),
          postIndex: "".trim(),
          address: "".trim(),
        },
        sum: this.$store.state.sumOrder,
        ...JSON.parse(localStorage.getItem("basket")).basketProducts,
      },
    };
  },
  methods: {
    sendOrder() {},
    orderSum() {
      let storage = JSON.parse(localStorage.getItem("basket"));
      let sum = 0;
      let count = 0;
      storage.basketProducts.forEach((item) => {
        count = item.quantity;
        sum += parseInt(item.price) * count;
      });
      this.$store.state.sumOrder = sum;
    },
  },
};
</script>

<style lang="scss" scoped>
input[type="number"] {
  -moz-appearance: textfield;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
}

.sendOrder {
  border: 4px solid #ed7102;
  background-color: #ed7102;
  color: #ffffff;
  border-radius: 10px;
  padding: 7px;
  font-size: 30px;
  &:focus {
    border: 4px solid #e2aa75;
    color: #e2aa75;
  }
}
.register-order {
  padding: 30px;
}

.sum-block {
  display: flex;
  justify-content: space-around;
  font-size: 24px;
  font-weight: bold;
}
.inputs-place {
  margin-top: 25px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.order-input {
  border: 2px solid #b8b3ad;
  outline: none;
  text-align: center;
  font-size: 25px;
  margin-bottom: 25px;
  padding: 9px 100px;
  background: #ffffff;
  border-radius: 26px;
  &:focus {
    border-color: #e79247;
  }
}
.btn-center {
  text-align: center;
}
.sendOrder {
}
</style>
