const vm = Vue.createApp({
  data() {
    return {
      firstName: "Bhupend",
      lastName: "Patil",
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
