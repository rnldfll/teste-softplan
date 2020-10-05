package com.ronaldo.softplan.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ronaldo.softplan.api.ApiResponseMessages;
import com.ronaldo.softplan.api.RestPath;
import com.ronaldo.softplan.api.v1.dto.people.PeopleCreateDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleCreateResponseDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleListResponseDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleUpdateDto;
import com.ronaldo.softplan.mapper.PeopleMapper;
import com.ronaldo.softplan.service.people.PeopleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController("PeopleController")
@RequestMapping(RestPath.BASE_PATH_V1 + "/people")
@Api(tags = "People")
public class PeopleController {

    @Autowired
    PeopleService peopleService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.people.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = ApiResponseMessages.MESSAGE_201, response = PeopleCreateResponseDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public PeopleCreateResponseDto create(
            @ApiParam(value = "${v1.people}", required = true) @RequestBody @Valid PeopleCreateDto peopleCreateDto) {
        return peopleService.create(peopleCreateDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.people.list}")
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_201, response = PeopleListResponseDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public PeopleListResponseDto list() {
        return PeopleMapper.toPeopleListResponseDto(peopleService.list());
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping()
    @ApiOperation(value = "${v1.people.delete}")
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_201),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)
    })
    public void delete(
            @ApiParam(value = "${v1.people.id}", required = true) @RequestParam @Param("id") String id) {
        peopleService.deleteUser(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.people.update}")
    @ApiResponses({
            @ApiResponse(code = 201, message = ApiResponseMessages.MESSAGE_201),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public void update(
            @ApiParam(value = "${v1.people}", required = true)  @RequestBody @Valid PeopleUpdateDto peopleUpdateDto) {
        peopleService.update(peopleUpdateDto);
    }


}
