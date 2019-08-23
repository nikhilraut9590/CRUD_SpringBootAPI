package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Movie;
import com.crud.exception.EmptyMovieListException;
import com.crud.exception.MovieAlreadyExist;
import com.crud.exception.MovieNotFoundException;
import com.crud.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovies() throws EmptyMovieListException {
		List<Movie> movieList = movieRepository.getAllMovies();
		return movieList;
	}

	@Override
	public Movie getMovieById(Integer movieId) throws MovieNotFoundException {
		Movie movie = movieRepository.getAllMovies().stream().filter(x -> x.getMovieId() == movieId).findAny()
				.orElseThrow(() -> new MovieNotFoundException("Movie Not Found on movie Id: " + movieId));
		System.out.println(movie.getMovieName());
		return movie;
	}

	@Override
	public List<Movie> updateMovie(Movie movie) {
		return movieRepository.getAllMovies();
	}

	@Override
	public String deleteMovieById(Integer movieId) throws MovieNotFoundException {
		Movie deletedMovie = movieRepository.deleteMoviebyId(movieId);
		if (deletedMovie.equals(null)) {
			throw new MovieNotFoundException("Movie Not available");
		}
		return "Movie Deleted Successfully";
	}

	@Override
	public  List<Movie> addMovie(Movie movie) throws MovieAlreadyExist, EmptyMovieListException {
		Movie newMovie=getAllMovies().stream().filter(x->x.getMovieId().equals(movie.getMovieId())).findAny().orElse(null);
		if(newMovie==null) {
		return movieRepository.addMovie(movie);
		}		
		throw new MovieAlreadyExist("Movie Already Exist!");
		
	}

}
