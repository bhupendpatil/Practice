const app = Vue.createApp({
  data() {
    return {
      courseGoal: "Finish the course and learn Vue!",
      vueLink: "https://bhupend.com",
    };
  },
});

app.mount("#user-goal");
