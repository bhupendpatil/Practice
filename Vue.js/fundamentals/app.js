const vm = Vue.createApp({
  data() {
    return {
      firstName: "Bhupend",
      lastName: "Patil",
      url: "https://bhupend.com",
      raw_url: '<a href="https://bhupend.com" target="_blank">Bhupend</a>',
      age: 26,
    };
  },
  methods: {
    fullName() {
      return `${this.firstName} ${this.lastName.toUpperCase()}`;
    },
    increment() {
      return this.age++;
    },
    updateLastName(msg, event) {
      event.preventDefault();
      console.log(msg);
      this.lastName = event.target.value;
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
