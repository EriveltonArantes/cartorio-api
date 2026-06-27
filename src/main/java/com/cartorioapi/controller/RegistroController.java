package com.cartorioapi.controller;

import com.cartorioapi.dto.RegistroRequestDTO;
import com.cartorioapi.dto.RegistroResponseDTO;
import com.cartorioapi.service.RegistroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Registro", description = "Gerenciamento de registros")
@RestController
@RequestMapping("/api/registros")
public class RegistroController {

    @Autowired
    private RegistroService service;

    @Operation(summary = "Listar todos os Registro")
    @GetMapping
    public List<RegistroResponseDTO> listar(@RequestParam(required = false) String descricao) {
        List<RegistroResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Registro por ID")
    @GetMapping("/{id}")
    public RegistroResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Registro")
    @PostMapping
    public ResponseEntity<RegistroResponseDTO> criar(@Valid @RequestBody RegistroRequestDTO registro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(registro));
    }

    @Operation(summary = "Atualizar Registro")
    @PutMapping("/{id}")
    public RegistroResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody RegistroRequestDTO registro) {
        return service.atualizar(id, registro);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Registro")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
