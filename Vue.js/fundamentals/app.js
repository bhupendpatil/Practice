const vm = Vue.createApp({
  data() {
    return {
      firstName: "Bhupend",
      lastName: "Patil",
      url: "https://bhupend.com",
      raw_url: '<a href="https://bhupend.com" target="_blank">Bhupend</a>',
    };
  },
  methods: {
    fullName() {
      return `${this.firstName} ${this.lastName.toUpperCase()}`;
    },
  },
}).mount("#app");

// setTimeout(() => {
//   vm.firstName = "Harshad";
// }, 2000);

// Vue.createApp({
//   data() {
//     return {
//       firstName: "Bhupend",
//       lastName: "Patil",
//     };
//   },
// }).mount("#app1");
