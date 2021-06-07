const vm = Vue.createApp({
  data() {
    return {
      firstName: "Bhupend",
      middleName: "",
      lastName: "Patil",
      url: "https://bhupend.com",
      raw_url: '<a href="https://bhupend.com" target="_blank">Bhupend</a>',
      age: 26,
    };
  },
  methods: {
    increment() {
      return this.age++;
    },
    updateLastName(msg, event) {
      console.log(msg);
      this.lastName = event.target.value;
    },
    updateMiddleName(event) {
      this.middleName = event.target.value;
    },
  },
  computed: {
    fullName() {
      console.log("Full name computed method was called!");

      return `${this.firstName} ${
        this.middleName
      } ${this.lastName.toUpperCase()}`;
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
