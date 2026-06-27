package com.cartorioapi.service;

import com.cartorioapi.dto.CertidaoRequestDTO;
import com.cartorioapi.dto.CertidaoResponseDTO;
import com.cartorioapi.exception.ResourceNotFoundException;
import com.cartorioapi.mapper.CertidaoMapper;
import com.cartorioapi.model.Certidao;
import com.cartorioapi.repository.CertidaoRepository;
import com.cartorioapi.repository.RegistroRepository;
import com.cartorioapi.model.Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CertidaoService {

    @Autowired
    private CertidaoRepository repository;

    @Autowired
    private CertidaoMapper mapper;

    @Autowired
    private RegistroRepository registroRepository;

    @Transactional(readOnly = true)
    public List<CertidaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CertidaoResponseDTO buscar(Long id) {
        Certidao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Certidao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public CertidaoResponseDTO criar(CertidaoRequestDTO dto) {
        Certidao entity = mapper.toEntity(dto);
        Registro registro = registroRepository.findById(dto.getRegistroId())
            .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado com id: " + dto.getRegistroId()));
        entity.setRegistro(registro);
        Certidao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public CertidaoResponseDTO atualizar(Long id, CertidaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Certidao não encontrado com id: " + id);
        }
        Certidao entity = mapper.toEntity(dto);
        entity.setId(id);
        Registro registro = registroRepository.findById(dto.getRegistroId())
            .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado com id: " + dto.getRegistroId()));
        entity.setRegistro(registro);
        Certidao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Certidao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
