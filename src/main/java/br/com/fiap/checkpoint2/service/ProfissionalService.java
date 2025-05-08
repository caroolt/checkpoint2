package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.profissional.ProfissionalCreateDTO;
import br.com.fiap.checkpoint2.dto.profissional.ProfissionalResponseDTO;
import br.com.fiap.checkpoint2.dto.profissional.ProfissionalUpdateDTO;
import br.com.fiap.checkpoint2.model.Profissional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {
    
    private final List<Profissional> profissionais = new ArrayList<>();
    private Long nextId = 1L;
    
    public Profissional create(ProfissionalCreateDTO dto) {
        Profissional profissional = new Profissional();
        profissional.setId(nextId++);
        profissional.setNome(dto.getNome());
        profissional.setEspecialidade(dto.getEspecialidade());
        profissional.setValorHora(dto.getValorHora());
        profissional.setCreatedAt(LocalDateTime.now());
        profissional.setUpdatedAt(LocalDateTime.now());

        profissionais.add(profissional);
        
        return profissional;
    }
    
    public List<Profissional> findAll() {
        return profissionais;
    }
    
    public Optional<Profissional> findById(Long id) {
        return profissionais.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    
    public Optional<Profissional> update(Long id, ProfissionalUpdateDTO dto) {
        return profissionais.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(p -> {
                    p.setNome(dto.getNome());
                    p.setEspecialidade(dto.getEspecialidade());
                    p.setValorHora(dto.getValorHora());
                    p.setUpdatedAt(LocalDateTime.now());

                    return p;
                });
    }
    
    public boolean delete(Long id) {
        return profissionais.removeIf(p -> p.getId().equals(id));
    }
}