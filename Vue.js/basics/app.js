const app = Vue.createApp({
  data() {
    return {
      counter: 0,
      name: "",
      lastName: "",
      //fullName: "",
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
    },
  },
});

app.mount("#events");
