package br.com.seguros.application.mapper;

import br.com.seguros.domain.model.Seguro;
import br.com.seguros.application.dto.SeguroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeguroMapper {

    SeguroMapper INSTANCE = Mappers.getMapper(SeguroMapper.class);

    SeguroDTO toDTO(Seguro seguro);

}
