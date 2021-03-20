package com.cesmac.sterfanno.produtora.nolapi.repository;
import com.cesmac.sterfanno.produtora.nolapi.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
