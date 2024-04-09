<template>
  <v-app>
    <v-main>

      <v-app-bar app>
        <v-app-bar-nav-icon @click="opener = !opener"></v-app-bar-nav-icon>
        <h1 v-if="opener">Abrir menu</h1>

        <v-toolbar-title>Libreria Espiral</v-toolbar-title>

        <v-spacer></v-spacer>

        <v-btn icon>
          <v-icon>mdi-export</v-icon>
        </v-btn>
      </v-app-bar>
      
      <Home />
      <v-footer border> tucun tucun</v-footer>
    </v-main>
  </v-app>
</template>

<script>
import Home from './components/Home.vue';

export default {
  name: 'App',

  components: {
    Home,
  },

  data: () => ({
    opener: false
    //
  }),
}
</script>
