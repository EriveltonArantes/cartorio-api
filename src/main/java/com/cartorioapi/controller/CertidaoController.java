package com.cartorioapi.controller;

import com.cartorioapi.dto.CertidaoRequestDTO;
import com.cartorioapi.dto.CertidaoResponseDTO;
import com.cartorioapi.service.CertidaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Certidao", description = "Gerenciamento de certidaos")
@RestController
@RequestMapping("/api/certidaos")
public class CertidaoController {

    @Autowired
    private CertidaoService service;

    @Operation(summary = "Listar todos os Certidao")
    @GetMapping
    public List<CertidaoResponseDTO> listar(@RequestParam(required = false) String tipoCertidao, @RequestParam(required = false) Long registroId) {
        List<CertidaoResponseDTO> resultado = service.listar();
        if (tipoCertidao != null && !tipoCertidao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getTipoCertidao() != null &&
                item.getTipoCertidao().toLowerCase().contains(tipoCertidao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (registroId != null) {
            resultado = resultado.stream().filter(item -> registroId.equals(item.getRegistroId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Certidao por ID")
    @GetMapping("/{id}")
    public CertidaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Certidao")
    @PostMapping
    public ResponseEntity<CertidaoResponseDTO> criar(@Valid @RequestBody CertidaoRequestDTO certidao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(certidao));
    }

    @Operation(summary = "Atualizar Certidao")
    @PutMapping("/{id}")
    public CertidaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody CertidaoRequestDTO certidao) {
        return service.atualizar(id, certidao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Certidao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
