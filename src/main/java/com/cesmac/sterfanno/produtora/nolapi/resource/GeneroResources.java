package com.cesmac.sterfanno.produtora.nolapi.resource;

import com.cesmac.sterfanno.produtora.nolapi.domain.Genero;
import com.cesmac.sterfanno.produtora.nolapi.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroResources {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public List<Genero> showAll(){
        return generoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Genero> buscarPorId(@PathVariable("id") Long idGenero){
        return generoRepository.findById(idGenero).map(genero ->
                ResponseEntity.ok(genero)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody Genero genero){
        generoRepository.save(genero);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(genero.getIdGenero()).toUri();
        return ResponseEntity.created(uri).build();    }

    @PutMapping
    public  void atualizar(@RequestBody Genero genero){
        generoRepository.save(genero);
    }

    @DeleteMapping
    public  void deletar(@RequestBody Genero genero){
        generoRepository.delete(genero);
    }
}
