<template>
<p>{{ msg }}</p>
</template>

<script>
export default {
    name: "Greeting",
    data() {
        return {
            msg: "Hello World!",
        };
    },
};
</script>

<style scoped>
p {
    color: red;
}
</style>
