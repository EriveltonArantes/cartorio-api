package com.cartorioapi.service;

import com.cartorioapi.dto.SolicitacaoServicoRequestDTO;
import com.cartorioapi.dto.SolicitacaoServicoResponseDTO;
import com.cartorioapi.exception.ResourceNotFoundException;
import com.cartorioapi.mapper.SolicitacaoServicoMapper;
import com.cartorioapi.model.SolicitacaoServico;
import com.cartorioapi.repository.SolicitacaoServicoRepository;
import com.cartorioapi.repository.ServicoRepository;
import com.cartorioapi.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SolicitacaoServicoService {

    @Autowired
    private SolicitacaoServicoRepository repository;

    @Autowired
    private SolicitacaoServicoMapper mapper;

    @Autowired
    private ServicoRepository servicoRepository;

    @Transactional(readOnly = true)
    public List<SolicitacaoServicoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SolicitacaoServicoResponseDTO buscar(Long id) {
        SolicitacaoServico entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("SolicitacaoServico não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public SolicitacaoServicoResponseDTO criar(SolicitacaoServicoRequestDTO dto) {
        SolicitacaoServico entity = mapper.toEntity(dto);
        Servico servico = servicoRepository.findById(dto.getServicoId())
            .orElseThrow(() -> new ResourceNotFoundException("Servico não encontrado com id: " + dto.getServicoId()));
        entity.setServico(servico);
        SolicitacaoServico salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public SolicitacaoServicoResponseDTO atualizar(Long id, SolicitacaoServicoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("SolicitacaoServico não encontrado com id: " + id);
        }
        SolicitacaoServico entity = mapper.toEntity(dto);
        entity.setId(id);
        Servico servico = servicoRepository.findById(dto.getServicoId())
            .orElseThrow(() -> new ResourceNotFoundException("Servico não encontrado com id: " + dto.getServicoId()));
        entity.setServico(servico);
        SolicitacaoServico salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("SolicitacaoServico não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
