package com.cartorioapi.mapper;

import com.cartorioapi.dto.SolicitacaoServicoRequestDTO;
import com.cartorioapi.dto.SolicitacaoServicoResponseDTO;
import com.cartorioapi.model.SolicitacaoServico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SolicitacaoServicoMapper {

    @Mapping(target = "servico", ignore = true)
    SolicitacaoServico toEntity(SolicitacaoServicoRequestDTO dto);

    @Mapping(target = "servicoId", source = "servico.id")
    SolicitacaoServicoResponseDTO toResponseDTO(SolicitacaoServico entity);
}
