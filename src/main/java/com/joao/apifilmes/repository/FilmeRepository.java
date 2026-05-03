package com.joao.apifilmes.repository;

import com.joao.apifilmes.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
}
