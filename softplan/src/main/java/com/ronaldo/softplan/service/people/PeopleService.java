package com.ronaldo.softplan.service.people;

import com.ronaldo.softplan.api.v1.dto.people.PeopleCreateDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleCreateResponseDto;
import com.ronaldo.softplan.api.v1.dto.people.PeopleUpdateDto;
import com.ronaldo.softplan.configuration.Translator;
import com.ronaldo.softplan.entity.people.People;
import com.ronaldo.softplan.exceptions.BadRequestException;
import com.ronaldo.softplan.exceptions.BaseException;
import com.ronaldo.softplan.exceptions.NotFoundException;
import com.ronaldo.softplan.helper.CpfHelper;
import com.ronaldo.softplan.mapper.PeopleMapper;
import com.ronaldo.softplan.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public PeopleCreateResponseDto create(PeopleCreateDto peopleCreateDTO) throws BaseException {

        validateEmail(peopleCreateDTO.getEmail(), null);
        validateFederalIdentification(peopleCreateDTO.getFederalIdentification(), null);
        peopleCreateDTO.setFederalIdentification(CpfHelper.removeInvalidCharacters(peopleCreateDTO.getFederalIdentification()));

        People people = peopleRepository.save(PeopleMapper.toEntity(peopleCreateDTO)
                .setCreateDate(LocalDateTime.now())
                .setLastUpdate(LocalDateTime.now()));

        return PeopleMapper.toResponseDto(people);
    }

    private void validateEmail(String email, String id) {

        List<People> peoples = peopleRepository.findByEmail(email);
        if(!peoples.isEmpty()) {
            for(People people : peoples) {
                if(id == null || !people.getId().equals(id)) {
                    throw new BadRequestException(Translator.toLocale(
                            "people.emailAlreadyUsed.exception", new String[]{email}));
                }
            }
        }
    }

    private void validateFederalIdentification(String federalIdentification, String id) {
        boolean isValidCpf = CpfHelper.isValid(federalIdentification);

        if (!isValidCpf) {
            throw new BadRequestException(Translator.toLocale(
                    "people.invalidFederalIdentification.exception", new String[]{federalIdentification}));
        }

        List<People> peoples = peopleRepository.findByFederalIdentification(federalIdentification);
        if(!peoples.isEmpty()) {
            for(People people : peoples) {
                if(id == null || !people.getId().equals(id)) {
                    throw new BadRequestException(Translator.toLocale(
                            "people.federalIdentificationAlreadyUsed.exception", new String[]{federalIdentification}));
                }
            }
        }
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<People> list() {
        return peopleRepository.findAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public People findUserById(String id) throws BaseException {
        return peopleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Translator.toLocale("people.notfound.exception", new String[]{id})));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteUser(String id) {
        peopleRepository.delete(findUserById(id));
    }

    public void update(PeopleUpdateDto peopleUpdateDto) {

        validateEmail(peopleUpdateDto.getEmail(), peopleUpdateDto.getId());
        validateFederalIdentification(peopleUpdateDto.getFederalIdentification(), peopleUpdateDto.getId());
        peopleUpdateDto.setFederalIdentification(CpfHelper.removeInvalidCharacters(peopleUpdateDto.getFederalIdentification()));

        People people = findUserById(peopleUpdateDto.getId());

        peopleRepository.save(PeopleMapper.toEntity(peopleUpdateDto)
                .setLastUpdate(LocalDateTime.now())
                .setCreateDate(people.getCreateDate()));

    }
}
