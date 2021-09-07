<template>
  <div>
    <slot :user="user" :favorites="favorites"></slot>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data() {
    return {
      user: {
        name: "Bhupend Patil",
        age: 25,
      },
      favorites: ["Pizza", "Codes", "Machines"],
    };
  },
};
</script>
