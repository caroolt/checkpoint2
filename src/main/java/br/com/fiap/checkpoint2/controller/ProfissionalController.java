package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.dto.profissional.ProfissionalCreateDTO;
import br.com.fiap.checkpoint2.dto.profissional.ProfissionalResponseDTO;
import br.com.fiap.checkpoint2.dto.profissional.ProfissionalUpdateDTO;
import br.com.fiap.checkpoint2.service.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profissionais")
public class ProfissionalController {

    @Autowired
    private ProfissionalService profissionalService;

    @PostMapping
    public ResponseEntity<ProfissionalResponseDTO> create(@RequestBody ProfissionalCreateDTO dto) {
       return ResponseEntity.status(201).body(
               new ProfissionalResponseDTO().toDto(
                       profissionalService.create(dto)
               )
       );
    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponseDTO>> findAll() {
        List<ProfissionalResponseDTO> response = profissionalService.findAll().stream()
                .map(p -> new ProfissionalResponseDTO().toDto(p))
                .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfissionalResponseDTO> findById(@PathVariable Long id) {
        return profissionalService.findById(id)
                .map(p -> new ProfissionalResponseDTO().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfissionalResponseDTO> update(@PathVariable Long id, @RequestBody ProfissionalUpdateDTO dto) {
        return profissionalService.update(id, dto)
                .map(p -> new ProfissionalResponseDTO().toDto(p))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
       boolean result = profissionalService.delete(id);

       if(result) {
           return ResponseEntity.noContent().build();
       } else {
           return ResponseEntity.notFound().build();
       }
    }
}