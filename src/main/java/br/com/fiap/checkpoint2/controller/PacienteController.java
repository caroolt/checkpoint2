package br.com.fiap.checkpoint2.controller;

import java.util.stream.Collectors;
import br.com.fiap.checkpoint2.dto.paciente.PacienteCreateDTO;
import br.com.fiap.checkpoint2.dto.paciente.PacienteResponseDTO;
import br.com.fiap.checkpoint2.dto.paciente.PacienteUpdateDTO;
import br.com.fiap.checkpoint2.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> create(@RequestBody PacienteCreateDTO dto) {
        return ResponseEntity.status(201).body(
                new PacienteResponseDTO().toDto(
                        pacienteService.create(dto)
                )
        );
    }
    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> findAll() {
        List<PacienteResponseDTO> response = pacienteService.findAll().stream()
                .map(p -> new PacienteResponseDTO().toDto(p))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> findById(@PathVariable Long id) {
        return pacienteService.findById(id)
                .map(p -> new PacienteResponseDTO().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> update(@PathVariable Long id, @RequestBody PacienteUpdateDTO dto) {
        return pacienteService.update(id, dto)
                .map(p -> new PacienteResponseDTO().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean result = pacienteService.delete(id);

        if(result) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}