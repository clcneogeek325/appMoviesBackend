package com.example.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.accessingdatamysql.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
