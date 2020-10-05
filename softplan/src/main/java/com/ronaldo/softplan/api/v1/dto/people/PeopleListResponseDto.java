package com.ronaldo.softplan.api.v1.dto.people;

import java.util.List;

public class PeopleListResponseDto {

    List<PeopleCreateResponseDto> peoples;

    public List<PeopleCreateResponseDto> getPeoples() {
        return peoples;
    }

    public PeopleListResponseDto setPeoples(List<PeopleCreateResponseDto> peoples) {
        this.peoples = peoples;
        return this;
    }
}
