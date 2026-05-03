package com.joao.apifilmes.controllers;

import com.joao.apifilmes.model.Filme;
import com.joao.apifilmes.repository.FilmeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeRepository repository;

    public FilmeController(FilmeRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return repository.findAll();
    }

    @PostMapping
    public Filme salvarFilme(@RequestBody Filme filme) {
        return repository.save(filme);
    }

    @GetMapping("/{id}")
    public Filme buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public  Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme dadosAtualizados){
        Filme filme = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));

        filme.setTitulo(dadosAtualizados.getTitulo());
        filme.setGenero(dadosAtualizados.getGenero());
        filme.setNota(dadosAtualizados.getNota());

        return repository.save(filme);
    }
}