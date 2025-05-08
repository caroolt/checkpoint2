package br.com.fiap.checkpoint2.dto.consulta;

import java.time.LocalDateTime;
import br.com.fiap.checkpoint2.model.Consulta;
public class ConsultaResponseDTO {
    private Long id;
    private Long profissionalId;
    private Long pacienteId;
    private LocalDateTime dataConsulta;
    private String statusConsulta;
    private Integer quantidadeHoras;
    private Double valorConsulta;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ConsultaResponseDTO toDto(Consulta consulta) {
       this.setId(consulta.getId());
       this.setProfissionalId(consulta.getProfissionalId());
       this.setPacienteId(consulta.getPacienteId());
       this.setDataConsulta(consulta.getDataConsulta());
       this.setStatusConsulta(consulta.getStatusConsulta());
       this.setQuantidadeHoras(consulta.getQuantidadeHoras());
       this.setValorConsulta(consulta.getValorConsulta());
       this.setCreatedAt(consulta.getCreatedAt());
       this.setUpdatedAt(consulta.getUpdatedAt());
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(String statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public Integer getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Integer quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    public Double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(Double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}