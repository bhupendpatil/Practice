const app = Vue.createApp({
  data() {
    return {
      counter: 0,
      name: "",
    };
  },
  computed: {
    fullName() {
      if (this.name === "") {
        return "";
      } else {
        return this.name + " " + "Patil";
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
