package com.example.accessingdatamysql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.accessingdatamysql.entity.Movie;
import com.example.accessingdatamysql.repository.MovieRepository;


@RestController
@RequestMapping(path = "/movies")
public class MoviesController {

	@Autowired
	private MovieRepository moviesRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Movie> getAllMovies() {
		// This returns a JSON or XML with the users
		return moviesRepository.findAll();
	}
	@PostMapping(path = "/add",consumes = "application/json", produces = "text/plain")
	public @ResponseBody String addNewMovie (@RequestBody Movie newMovie) {
		Movie m = new Movie();
		m.setName(newMovie.getName());
		m.setUrl(newMovie.getUrl());
		moviesRepository.save(m);
		return "Saved";
	}

	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteMovie(@RequestParam Integer id) {
		moviesRepository.deleteById(id);
		return "Deleted";
	}
	
}
