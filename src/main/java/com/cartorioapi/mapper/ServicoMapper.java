package com.cartorioapi.mapper;

import com.cartorioapi.dto.ServicoRequestDTO;
import com.cartorioapi.dto.ServicoResponseDTO;
import com.cartorioapi.model.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    Servico toEntity(ServicoRequestDTO dto);

    ServicoResponseDTO toResponseDTO(Servico entity);
}
