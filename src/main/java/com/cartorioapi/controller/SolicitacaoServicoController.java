package com.cartorioapi.controller;

import com.cartorioapi.dto.SolicitacaoServicoRequestDTO;
import com.cartorioapi.dto.SolicitacaoServicoResponseDTO;
import com.cartorioapi.service.SolicitacaoServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "SolicitacaoServico", description = "Gerenciamento de solicitacaoservicos")
@RestController
@RequestMapping("/api/solicitacaoservicos")
public class SolicitacaoServicoController {

    @Autowired
    private SolicitacaoServicoService service;

    @Operation(summary = "Listar todos os SolicitacaoServico")
    @GetMapping
    public List<SolicitacaoServicoResponseDTO> listar(@RequestParam(required = false) String requerente, @RequestParam(required = false) Long servicoId) {
        List<SolicitacaoServicoResponseDTO> resultado = service.listar();
        if (requerente != null && !requerente.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getRequerente() != null &&
                item.getRequerente().toLowerCase().contains(requerente.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (servicoId != null) {
            resultado = resultado.stream().filter(item -> servicoId.equals(item.getServicoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar SolicitacaoServico por ID")
    @GetMapping("/{id}")
    public SolicitacaoServicoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar SolicitacaoServico")
    @PostMapping
    public ResponseEntity<SolicitacaoServicoResponseDTO> criar(@Valid @RequestBody SolicitacaoServicoRequestDTO solicitacaoServico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(solicitacaoServico));
    }

    @Operation(summary = "Atualizar SolicitacaoServico")
    @PutMapping("/{id}")
    public SolicitacaoServicoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody SolicitacaoServicoRequestDTO solicitacaoServico) {
        return service.atualizar(id, solicitacaoServico);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir SolicitacaoServico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
