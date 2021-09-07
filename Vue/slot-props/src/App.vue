<template>
  <div id="app">
    <hello-world #default="{ user, favorites }">
      <p>Name: {{ user.name }}</p>
      <p>Age: {{ user.age }}</p>
      <p>Favorites:</p>
      <ul>
        <li v-for="fav in favorites" :key="fav">
          {{ fav }}
        </li>
      </ul>
    </hello-world>
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";

export default {
  name: "App",
  components: {
    HelloWorld,
  },
};
</script>
