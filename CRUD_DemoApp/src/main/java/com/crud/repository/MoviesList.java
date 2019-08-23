package com.crud.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crud.entity.Movie;

@Component
public class MoviesList {

	private List<Movie> movies;

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
