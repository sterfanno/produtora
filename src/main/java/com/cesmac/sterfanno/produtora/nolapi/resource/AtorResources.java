package com.cesmac.sterfanno.produtora.nolapi.resource;

import com.cesmac.sterfanno.produtora.nolapi.domain.Ator;
import com.cesmac.sterfanno.produtora.nolapi.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("atores")
public class AtorResources {

    @Autowired
    private AtorRepository atorRepository;

    @GetMapping
    public List<Ator> showAll(){
        return atorRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ator> buscarPorId(@PathVariable("id") Long idAtor){
        return atorRepository.findById(idAtor).map(ator ->
                ResponseEntity.ok(ator)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Object> gravar(@RequestBody Ator ator){
        atorRepository.save(ator);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ator.getIdAtor()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public  void atualizar(@RequestBody Ator ator){
        atorRepository.save(ator);
    }

    @DeleteMapping
    public  void deletar(@RequestBody Ator ator){
        atorRepository.delete(ator);
    }
}
