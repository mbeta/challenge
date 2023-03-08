package ar.com.challenge.mapper;


import ar.com.challenge.dto.PrecioDto;
import ar.com.challenge.model.Precio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrecioMapper {


    PrecioDto toDto(Precio precio);


}
