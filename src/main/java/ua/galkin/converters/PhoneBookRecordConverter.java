package ua.galkin.converters;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ua.galkin.dto.PhoneBookRecordDto;
import ua.galkin.entities.PhoneBookRecord;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface PhoneBookRecordConverter {


    PhoneBookRecordConverter INSTANCE = Mappers.getMapper(PhoneBookRecordConverter.class );

    PhoneBookRecord convertToEntity(PhoneBookRecordDto userDto);

    PhoneBookRecordDto converToDto(PhoneBookRecord phoneBookRecord);

    default List<PhoneBookRecordDto> convertToListDto(List<PhoneBookRecord> phoneBookRecordList){
        return phoneBookRecordList.stream().map(entity -> INSTANCE.converToDto(entity)).collect(Collectors.toList());
    }
}
