package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.dto.consulta.ConsultaCreateDTO;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaUpdateDTO;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaResponseDTO;
import br.com.fiap.checkpoint2.model.Consulta;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    
    private final List<Consulta> consultas = new ArrayList<>();
    private Long nextId = 1L;
    
    public Consulta create(ConsultaCreateDTO dto) {
        Consulta consulta = new Consulta();
        consulta.setId(nextId++);
        consulta.setProfissionalId(dto.getProfissionalId());
        consulta.setPacienteId(dto.getPacienteId());
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setStatusConsulta(dto.getStatusConsulta());
        consulta.setQuantidadeHoras(dto.getQuantidadeHoras());
        consulta.setValorConsulta(dto.getValorConsulta());
        consulta.setCreatedAt(LocalDateTime.now());
        consulta.setUpdatedAt(LocalDateTime.now());
        consultas.add(consulta);
        
        return consulta;
    }
    
    public List<Consulta> findAll() {
        return consultas;
    }
    
    public Optional<Consulta> findById(Long id) {
        return consultas.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
    
    public Optional<Consulta> update(Long id, ConsultaUpdateDTO dto) {
      return consultas.stream().filter(c->c.getId().equals(id)).findFirst().map(c -> {
                  c.setProfissionalId(dto.getProfissionalId());
                  c.setPacienteId(dto.getPacienteId());
                  c.setDataConsulta(dto.getDataConsulta());
                  c.setStatusConsulta(dto.getStatusConsulta());
                  c.setQuantidadeHoras(dto.getQuantidadeHoras());
                  c.setValorConsulta(dto.getValorConsulta());
                  c.setUpdatedAt(LocalDateTime.now());
                  return c;
              });
    }
    
    public boolean delete(Long id) {
        return consultas.removeIf(c -> c.getId().equals(id));
    }
}