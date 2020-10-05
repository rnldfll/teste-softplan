package com.ronaldo.softplan.repository;

import com.ronaldo.softplan.entity.people.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<People, String> {

    List<People> findByFederalIdentification(String federalIdentification);
    List<People> findByEmail(String email);
}
