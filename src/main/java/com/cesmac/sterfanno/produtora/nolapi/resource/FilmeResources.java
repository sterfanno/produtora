package com.cesmac.sterfanno.produtora.nolapi.resource;

import com.cesmac.sterfanno.produtora.nolapi.domain.Filme;
import com.cesmac.sterfanno.produtora.nolapi.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("filmes")
public class FilmeResources {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public List<Filme> showAll(){
        return filmeRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable("id") Long idFilme){
        return filmeRepository.findById(idFilme).map(filme ->
                ResponseEntity.ok(filme)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody Filme filme){
        filmeRepository.save(filme);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(filme.getIdFilme()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public  void atualizar(@RequestBody Filme filme){
        filmeRepository.save(filme);
    }

    @DeleteMapping
    public  void deletar(@RequestBody Filme filme){
        filmeRepository.delete(filme);
    }
}
