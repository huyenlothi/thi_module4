package com.example.demo.repository;

import com.example.demo.model.City;
import org.springframework.data.repository.CrudRepository;

public interface ICityRepository extends CrudRepository<City, Long> {
}
