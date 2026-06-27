package com.cartorioapi.mapper;

import com.cartorioapi.dto.CertidaoRequestDTO;
import com.cartorioapi.dto.CertidaoResponseDTO;
import com.cartorioapi.model.Certidao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CertidaoMapper {

    @Mapping(target = "registro", ignore = true)
    Certidao toEntity(CertidaoRequestDTO dto);

    @Mapping(target = "registroId", source = "registro.id")
    CertidaoResponseDTO toResponseDTO(Certidao entity);
}
