package ua.galkin.converters;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.galkin.dto.UserDto;
import ua.galkin.entities.User;

@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class );

    User convertToEntity(UserDto userDto);
}
