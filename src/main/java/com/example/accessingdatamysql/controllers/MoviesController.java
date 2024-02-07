package com.example.accessingdatamysql.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.accessingdatamysql.entity.Movie;
import com.example.accessingdatamysql.repository.MovieRepository;


@Controller
@RequestMapping(path = "/movies")
public class MoviesController {

	@Autowired
	private MovieRepository moviesRepository;

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Movie> getAllMovies() {
		// This returns a JSON or XML with the users
		return moviesRepository.findAll();
	}
	
	@PostMapping(path = "/add")
	public @ResponseBody String addNewMovie (@RequestParam String name,@RequestParam String url) {
		Movie m = new Movie();
		m.setName(name);
		m.setUrl(url);
		moviesRepository.save(m);
		return "Saved";
	}
	
	@DeleteMapping(path = "/delete")
	public @ResponseBody String deleteMovie(@RequestParam Integer id) {
		moviesRepository.deleteById(id);
		return "Deleted";
	}
	
}
