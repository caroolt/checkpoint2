package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.consulta.ConsultaCreateDTO;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaResponseDTO;
import br.com.fiap.checkpoint2.dto.consulta.ConsultaUpdateDTO;
import br.com.fiap.checkpoint2.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<ConsultaResponseDTO> create(@RequestBody ConsultaCreateDTO dto) {
        return ResponseEntity.status(201).body(
                new ConsultaResponseDTO().toDto(
                        consultaService.create(dto)
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> findAll() {
        List<ConsultaResponseDTO> response = consultaService.findAll().stream()
                .map(c->new ConsultaResponseDTO().toDto(c))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> findById(@PathVariable Long id) {
        return consultaService.findById(id)
                .map(c -> new ConsultaResponseDTO().toDto(c))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> update(@PathVariable Long id, @RequestBody ConsultaUpdateDTO dto) {
       return consultaService.update(id, dto)
               .map(c -> new ConsultaResponseDTO().toDto(c))
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
       boolean result = consultaService.delete(id);

       if(result) {
           return ResponseEntity.noContent().build();
       } else {
           return ResponseEntity.notFound().build();
       }
    }
}