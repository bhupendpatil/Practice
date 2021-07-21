<template>
<button type="button" @click="flag = !flag">Toggle</button>

<transition name="fade" mode="out-in">
    <h2 v-if="flag" key="main">Hello World!</h2>
    <h2 v-else key="secondary">Another hello!</h2>
</transition>
</template>

<script>
export default {
    name: "App",
    data() {
        return {
            flag: false,
        };
    },
};
</script>

<style>
.fade-enter-from {
    opacity: 0;
}

.fade-enter-active {
    transition: all 0.25s linear;
}

.fade-leave-to {
    transition: all 3s linear;
    opacity: 0;
}
</style>
