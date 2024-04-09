<template>

  <v-container class="d-flex flex-wrap container-border" v-for="(topic, index) in this.trendingtopics" :key="index">
    <v-sheet class="text-h4 font-weight-bold pa-4"> {{ $filters.capitalize(topic)  }}</v-sheet>
    <v-row class="horizontal-scroll border d-flex" justify="start" style="flex-wrap: nowrap;">
      <v-col cols="auto" class="d-flex item" v-for="(libro, index) in this.libros[index]" :key="index">
        <v-list class="d-flex">
          <v-list-item class="d-flex">
            <v-card class="d-flex flex-column" style="padding: 3px;">
              <v-card-item>
                <v-img :src="getCoverLibro(libro.cover_id)" align-center style="padding-top: 3px;"></v-img>

                <v-card-title>{{ libro.title }}</v-card-title>
                <v-card-subtitle>{{ libro.authors[0].name }}</v-card-subtitle>
              </v-card-item>

            </v-card>
          </v-list-item>
        </v-list>

      </v-col>

    </v-row>

  </v-container>

</template>

<script>
const backendUrl = 'http://localhost:3030'

export default {
  name: 'src-components-home',
  props: {
  },
  async mounted() {
    for (let index = 0; index < this.trendingtopics.length; index++) {
      const element = this.trendingtopics[index];
      this.libros[index] = await this.getTTLibros(element)

    }
    console.log("Esto es en mounted", this.libros)

  },
  data() {
    return {
      usuario: {},
      libros: [],
      trendingtopics: ["love", "action", "programming", "suspense"],
    }
  },
  methods: {
    async getUsuario(id) {

      try {
        this.usuario = (await this.axios.get(`${backendUrl}/usuario/${id}`)).data
        console.log(this.usuario)
      }
      catch (err) {
        console.log("Error en getUsuario()", err)
      }
    },

    async getLibroSubject(subject) {
      try {
        this.libros = (await this.axios.get(`${backendUrl}/books/${subject}`)).data[0].works
        console.log(this.libros)
      } catch (error) {
        console.log("Error en getLibroSubject()", error)
      }
    },

    async getTTLibros(subject) {
      try {

        return (await this.axios.get(`${backendUrl}/books/${subject}`)).data[0].works

      } catch (error) {
        console.log("Error en getLibroSubject()", error)
      }
    },
    getCoverLibro(cover_id) {
      return `https://covers.openlibrary.org/b/ID/${cover_id}-M.jpg`
    },
  },
  computed: {
    
  },
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.horizontal-scroll {
  overflow-x: auto;
  white-space: nowrap;
}

.container-border {
  border: 3px;
  border-color: black;
}

.item {
  display: inline-block;
  width: 200px;
  margin-right: 10px;
}
</style>
