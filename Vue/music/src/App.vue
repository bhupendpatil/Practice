<template>
<!-- eslint-disable max-len -->
<app-header />

<router-view></router-view>

<!-- Player -->
<div class="fixed bottom-0 left-0 bg-white p-5 pb-4 text-left align-top w-full h-16">
    <div class="relative">
        <!-- Play/Pause Button -->
        <div class="float-left w-7 h-7 leading-3">
            <button type="button">
                <i class="fa fa-play text-gray-500 text-xl"></i>
            </button>
        </div>
        <!-- Current Position -->
        <div class="float-left w-7 h-7 leading-3 text-gray-400 mt-0 text-lg w-14 ml-5 mt-1">
            <span class="player-currenttime">00:00</span>
        </div>
        <!-- Scrub -->
        <div class="float-left w-7 h-7 leading-3 ml-7 mt-2 player-scrub">
            <div class="absolute left-0 right-0 text-lg text-center mx-auto player-song-info">
                <span class="song-title">Song Title</span> by
                <span class="song-artist">Artist</span>
            </div>
            <!-- Scrub Container  -->
            <span class="block w-full h-2 rounded m-1 mt-2 bg-gray-200 relative cursor-pointer">
                <!-- Player Ball -->
                <span class="absolute top-neg-8 text-gray-800 text-lg" style="left: 50%;">
                    <i class="fas fa-circle"></i>
                </span>
                <!-- Player Progress Bar-->
                <span class="block h-2 rounded bg-gradient-to-r from-green-500 to-green-400" style="width: 50%;"></span>
            </span>
        </div>
        <!-- Duration -->
        <div class="float-left w-7 h-7 leading-3 text-gray-400 mt-0 text-lg w-14 ml-8 mt-1">
            <span class="player-duration">03:06</span>
        </div>
    </div>
</div>

<auth-modal/>
</template>

<script>
import AppHeader from './components/Header.vue';
import AuthModal from './components/Auth.vue';

export default {
  name: 'App',
  components: {
    AppHeader,
    AuthModal,
  },
  created() {
    this.$store.dispatch('init_login');
  },
};
</script>
