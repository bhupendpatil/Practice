<template>
<button type="button" @click="onClickAge">Age++</button>
<button type="button" @click="ageChangeFn(3)">Age++ CB</button>
<p>The user is {{ age }} years old</p>
<p>{{ageDoubled}}</p>
</template>

<script>
export default {
    name: "User",
    props: {
        age: {
            type: Number,
            //required: true,
            //default:20,
            validator(value) {
                //this.onClickAge()
                return value < 130
            },
        },
        ageChangeFn: Function
    },
    emits: ["age-change"],
    computed: {
        ageDoubled() {
            return this.age * 2
        }
    },
    methods: {
        onClickAge() {
            this.$emit("age-change", 3)
        }
    }
}
</script>

<style>

</style>
