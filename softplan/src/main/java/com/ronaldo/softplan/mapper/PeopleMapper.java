package com.ronaldo.softplan.mapper;

import com.ronaldo.softplan.api.v1.dto.people.PeopleCreateDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleCreateResponseDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleListResponseDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleUpdateDto;
import com.ronaldo.softplan.configuration.CustomModelMapper;
import com.ronaldo.softplan.entity.people.People;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PeopleMapper {

    private static final ModelMapper modelMapper = new CustomModelMapper();

    public static People toEntity(PeopleCreateDto peopleCreateDto) {
        return modelMapper.map(peopleCreateDto, People.class);
    }

    public static People toEntity(PeopleUpdateDto peopleUpdateDto) {
        return modelMapper.map(peopleUpdateDto, People.class);
    }

    public static PeopleCreateResponseDto toResponseDto(People people) {
        return modelMapper.map(people, PeopleCreateResponseDto.class)
                ;
    }

    public static PeopleListResponseDto toPeopleListResponseDto(List<People> listPeople) {
        return new PeopleListResponseDto()
                .setPeoples(listPeople.stream()
                        .map(PeopleMapper::toResponseDto)
                        .collect(Collectors.toList()));
    }
}
