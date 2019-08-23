package com.crud.service;

import java.util.List;

import com.crud.entity.Movie;
import com.crud.exception.EmptyMovieListException;
import com.crud.exception.MovieNotFoundException;

public interface MovieService {
	List<Movie> getAllMovies() throws EmptyMovieListException;

	Movie getMovieById(Integer movieId) throws MovieNotFoundException;

	List<Movie> updateMovie(Movie movie);

	String deleteMovieById(Integer movieId) throws MovieNotFoundException;
	
	List<Movie> addMovie(Movie movie) throws Exception;
}
