import { createStore } from 'vuex';

export default createStore({
  state: {
    authModalShow: false,
  },
  mutations: {
    toggleAuthModal: (state) => {
      state.authModalShow = !state.authModalShow;
    },
  },
});
