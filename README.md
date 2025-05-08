# Checkpoint 2 - Sistema de Agenda de Consultas

## Visão Geral
Este projeto implementa um sistema de agendamento básico de consultas médicas como parte do segundo checkpoint da disciplina de Microsserviços da FIAP. O sistema permite o gerenciamento de pacientes, profissionais de saúde e consultas.

## Stack Tecnológica
- Java 17/18
- Spring Boot 3.4.x
- Maven
- Swagger (SpringDoc)

## Iniciando o Projeto
### Clonando o Repositório
```bash
git clone https://github.com/caroolt/checkpoint2
cd checkpoint2
```

### Executando o Projeto
```bash
mvn spring-boot:run
```

## Estrutura do Projeto
```
src/main/java/br/com/fiap/checkpoint2/
├── controller/       # Controladores REST
├── dto/              # Objetos de Transferência de Dados
├── model/            # Entidades do domínio
├── service/          # Camada de serviço
└── Checkpoint2Application.java  # Classe principal
```

## Endpoints da API
### Pacientes
- `POST /pacientes` - Criar um novo paciente
- `GET /pacientes` - Listar todos os pacientes
- `GET /pacientes/{id}` - Buscar paciente por ID
- `PUT /pacientes/{id}` - Atualizar paciente
- `DELETE /pacientes/{id}` - Remover paciente

### Profissionais
- `POST /profissionais` - Criar um novo profissional
- `GET /profissionais` - Listar todos os profissionais
- `GET /profissionais/{id}` - Buscar profissional por ID
- `PUT /profissionais/{id}` - Atualizar profissional
- `DELETE /profissionais/{id}` - Remover profissional

### Consultas
- `POST /consultas` - Criar uma nova consulta
- `GET /consultas` - Listar todas as consultas
- `GET /consultas/{id}` - Buscar consulta por ID
- `PUT /consultas/{id}` - Atualizar consulta
- `DELETE /consultas/{id}` - Remover consulta

## Documentação da API
A documentação da API está disponível através do Swagger UI:
```
http://localhost:8080/
```

## Modelo de Dados
### Paciente
- id: Identificador único
- nome: Nome do paciente
- endereco: Endereço do paciente
- bairro: Bairro do paciente
- email: Email do paciente
- telefoneCompleto: Telefone do paciente
- dataNascimento: Data de nascimento
- createdAt: Data de criação
- updatedAt: Data de atualização

### Profissional
- id: Identificador único
- nome: Nome do profissional
- especialidade: Especialidade do profissional
- valorHora: Valor cobrado por hora
- createdAt: Data de criação
- updatedAt: Data de atualização

### Consulta
- id: Identificador único
- profissionalId: ID do profissional
- pacienteId: ID do paciente
- dataConsulta: Data e hora da consulta
- statusConsulta: Status da consulta
- quantidadeHoras: Duração da consulta em horas
- valorConsulta: Valor total da consulta
- createdAt: Data de criação
- updatedAt: Data de atualização
