package ua.galkin.converters;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.factory.Mappers;
import ua.galkin.dto.PhoneBookRecordDto;
import ua.galkin.entities.PhoneBookRecord;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION)
public interface PhoneBookRecordConverter {


    PhoneBookRecordConverter INSTANCE = Mappers.getMapper(PhoneBookRecordConverter.class );

    PhoneBookRecord convertToEntity(PhoneBookRecordDto userDto);

    PhoneBookRecordDto convertToDto(PhoneBookRecord phoneBookRecord);

    default List<PhoneBookRecordDto> convertToListDto(List<PhoneBookRecord> phoneBookRecordList){
        return phoneBookRecordList.stream().map(entity -> INSTANCE.convertToDto(entity)).collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void merge(PhoneBookRecord source, @MappingTarget PhoneBookRecord target);
}
