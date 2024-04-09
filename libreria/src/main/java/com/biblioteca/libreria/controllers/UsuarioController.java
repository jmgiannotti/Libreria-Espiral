package com.biblioteca.libreria.controllers;

import com.biblioteca.libreria.api.OpenLibraryApi;
import com.biblioteca.libreria.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin
public class UsuarioController {

    private final OpenLibraryApi apiBooks;

    @Autowired
    public UsuarioController(OpenLibraryApi openLibraryApi) {
        this.apiBooks = openLibraryApi;
    }

    @GetMapping("/books/{subject}")
    public Flux<Object> getBooksBySubject(@PathVariable String subject) {

        return apiBooks.getBooksBySubject(subject);
    }

    @GetMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNombre("Juan");
        usuario.setApellido("Mermute");
        usuario.setEmail("juan@gmail.com");
        usuario.setTelefono("1128383838");
        return usuario;
    }

    @RequestMapping(value = "usuari")
    public Usuario editUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Mermute");
        usuario.setEmail("juan@gmail.com");
        usuario.setTelefono("1128383838");
        return usuario;
    }

    @RequestMapping(value = "usuaro")
    public Usuario deleteUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Mermute");
        usuario.setEmail("juan@gmail.com");
        usuario.setTelefono("1128383838");
        return usuario;
    }

    @RequestMapping(value = "usuaio")
    public Usuario searchUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Mermute");
        usuario.setEmail("juan@gmail.com");
        usuario.setTelefono("1128383838");
        return usuario;
    }
}
