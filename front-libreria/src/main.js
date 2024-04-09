import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import vuetify from './plugins/vuetify'
import { loadFonts } from './plugins/webfontloader'


loadFonts()

const app = createApp(App)

app.config.globalProperties.$filters = {
  capitalize(value) {
    value = value.toString();
    return value.charAt(0).toUpperCase() + value.slice(1);
  }
}

  app.use(VueAxios, axios)
  app.use(vuetify)
  app.mount('#app')
