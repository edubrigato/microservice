package br.com.seguros.mapper;

import br.com.seguros.domain.entity.Seguro;
import br.com.seguros.domain.entity.dto.SeguroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeguroMapper {

    SeguroMapper INSTANCE = Mappers.getMapper(SeguroMapper.class);

    SeguroDTO toDTO(Seguro seguro);

}
