package com.cartorioapi.service;

import com.cartorioapi.dto.RegistroRequestDTO;
import com.cartorioapi.dto.RegistroResponseDTO;
import com.cartorioapi.exception.ResourceNotFoundException;
import com.cartorioapi.mapper.RegistroMapper;
import com.cartorioapi.model.Registro;
import com.cartorioapi.repository.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistroService {

    @Autowired
    private RegistroRepository repository;

    @Autowired
    private RegistroMapper mapper;

    @Transactional(readOnly = true)
    public List<RegistroResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public RegistroResponseDTO buscar(Long id) {
        Registro entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public RegistroResponseDTO criar(RegistroRequestDTO dto) {
        Registro entity = mapper.toEntity(dto);
        Registro salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public RegistroResponseDTO atualizar(Long id, RegistroRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Registro não encontrado com id: " + id);
        }
        Registro entity = mapper.toEntity(dto);
        entity.setId(id);
        Registro salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Registro não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
