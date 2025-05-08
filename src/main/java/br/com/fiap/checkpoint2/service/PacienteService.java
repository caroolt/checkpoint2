package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.paciente.PacienteCreateDTO;
import br.com.fiap.checkpoint2.dto.paciente.PacienteResponseDTO;
import br.com.fiap.checkpoint2.dto.paciente.PacienteUpdateDTO;
import br.com.fiap.checkpoint2.model.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    
    private final List<Paciente> pacientes = new ArrayList<>();
    private Long nextId = 1L;
    
    public Paciente create(PacienteCreateDTO dto) {
        Paciente paciente = new Paciente();
        paciente.setId(nextId++);
        paciente.setNome(dto.getNome());
        paciente.setEndereco(dto.getEndereco());
        paciente.setBairro(dto.getBairro());
        paciente.setEmail(dto.getEmail());
        paciente.setTelefoneCompleto(dto.getTelefoneCompleto());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setCreatedAt(LocalDateTime.now());
        paciente.setUpdatedAt(LocalDateTime.now());
        pacientes.add(paciente);
        
        return paciente;
    }
    
    public List<Paciente> findAll() {
        return pacientes;
    }
    
    public Optional<Paciente> findById(Long id) {
        return pacientes.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    
    public Optional<Paciente> update(Long id, PacienteUpdateDTO dto) {
        return pacientes.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(p -> {
                    p.setNome(dto.getNome());
                    p.setEndereco(dto.getEndereco());
                    p.setBairro(dto.getBairro());
                    p.setEmail(dto.getEmail());
                    p.setTelefoneCompleto(dto.getTelefoneCompleto());
                    p.setDataNascimento(dto.getDataNascimento());
                    p.setUpdatedAt(LocalDateTime.now());
                    return p;
                });
    }
    
    public boolean delete(Long id) {
        return pacientes.removeIf(p -> p.getId().equals(id));
    }
}