let vm = Vue.createApp({
  data() {
    return {
      isPurple: false,
      selectedColor: "",
    };
  },
  computed: {
    circle_classes() {
      return { purple: this.isPurple };
    },
  },
}).mount("#app");
