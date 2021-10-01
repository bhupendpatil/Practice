<template>
<!-- eslint-disable max-len -->
<!-- Header -->
<header id="header" class="bg-gray-700">
    <nav class="container mx-auto flex justify-start items-center py-5 px-4">
        <!-- App Name -->
        <router-link class="text-white font-bold uppercase text-2xl mr-4" to="/">Music</router-link>

        <div class="flex flex-grow items-center">
            <!-- Primary Navigation -->
            <ul class="flex flex-row mt-1">
                <!-- Navigation Links -->
                <li>
                    <router-link class="px-2 text-white" to="/about">About</router-link>
                </li>
                <li v-if="!userLoggedIn">
                    <a class="px-2 text-white" href="#" @click.prevent="toggleAuthModal">Login / Register</a>
                </li>
                <template v-else>
                <li>
                    <router-link class="px-2 text-white" to="/manage">Manage</router-link>
                </li>
                <li>
                    <a class="px-2 text-white" href="#" @click.prevent="signout">Logout</a>
                </li>
                </template>
            </ul>
        </div>
    </nav>
</header>
</template>

<script>
import { mapMutations, mapState, mapActions } from 'vuex';

export default {
  name: 'Header',
  computed: {
    ...mapState(['userLoggedIn']),
  },
  methods: {
    ...mapMutations(['toggleAuthModal']),
    ...mapActions(['signout']),
    // toggleAuthModal() {
    //   this.$store.commit('toggleAuthModal');
    // },
  },
};
</script>
