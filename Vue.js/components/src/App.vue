<template>
<p>Hey!</p>
<greeting />
</template>

<script>
import Greeting from "./components/Greeting.vue";

export default {
    name: "App",
    components: {
        Greeting,
    }
}
</script>
