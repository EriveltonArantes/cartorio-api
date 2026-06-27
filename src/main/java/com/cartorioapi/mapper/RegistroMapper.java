package com.cartorioapi.mapper;

import com.cartorioapi.dto.RegistroRequestDTO;
import com.cartorioapi.dto.RegistroResponseDTO;
import com.cartorioapi.model.Registro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegistroMapper {

    Registro toEntity(RegistroRequestDTO dto);

    RegistroResponseDTO toResponseDTO(Registro entity);
}
