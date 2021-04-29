const app = Vue.createApp({
  data() {
    return {
      counter: 0,
      name: "",
      lastName: "",
      fullName: "",
    };
  },
  computed: {
    // fullName() {
    //   if (this.name === "") {
    //     return "";
    //   } else {
    //     return this.name + " " + "Patil";
    //   }
    // },
  },
  watch: {
    counter(value) {
      if (value > 50) {
        const that = this;
        setTimeout(function () {
          that.counter = 0;
        }, 2000);
      }
    },
    name(value) {
      if (value === "") {
        this.fullName = "";
      } else {
        this.fullName = value + " " + "Patil";
      }
    },
    lastName(value) {
      if (value === "") {
        this.fullName = "";
      } else {
        this.fullName = "Bhupend" + " " + value;
      }
    },
  },
  methods: {
    outputFullname() {
      if (this.name === "") {
        return "";
      } else {
        return this.name + " " + "Patil";
      }
    },
    setName(event) {
      this.name = event.target.value;
    },
    add(num) {
      this.counter = this.counter + num;
    },
    reduce(num) {
      this.counter = this.counter - num;
      // this.counter--;
    },
    resetInput() {
      this.name = "";
      this.lastName = "";
    },
  },
});

app.mount("#events");
