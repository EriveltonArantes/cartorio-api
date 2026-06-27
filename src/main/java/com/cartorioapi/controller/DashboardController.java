package com.cartorioapi.controller;

import com.cartorioapi.model.Registro;
import com.cartorioapi.model.Certidao;
import com.cartorioapi.model.Servico;
import com.cartorioapi.model.SolicitacaoServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.cartorioapi.repository.RegistroRepository registroRepository;

    @Autowired
    private com.cartorioapi.repository.CertidaoRepository certidaoRepository;

    @Autowired
    private com.cartorioapi.repository.ServicoRepository servicoRepository;

    @Autowired
    private com.cartorioapi.repository.SolicitacaoServicoRepository solicitacaoServicoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalRegistro", registroRepository.count());
        resumo.put("somaPartesRegistro", registroRepository.findAll().stream().filter(e -> e.getPartes() != null).mapToInt(e -> e.getPartes()).sum());
        resumo.put("graficoRegistro", registroRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalCertidao", certidaoRepository.count());
        resumo.put("somaValorCertidao", certidaoRepository.findAll().stream().map(e -> e.getValor()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoCertidao", certidaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalServico", servicoRepository.count());
        resumo.put("somaPrecoServico", servicoRepository.findAll().stream().map(e -> e.getPreco()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("totalSolicitacaoServico", solicitacaoServicoRepository.count());
        resumo.put("somaValorSolicitacaoServico", solicitacaoServicoRepository.findAll().stream().map(e -> e.getValor()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoSolicitacaoServico", solicitacaoServicoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
