package com.crud.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crud.entity.Address;
import com.crud.entity.Movie;
import com.crud.entity.Phone;

@Repository
public class MovieRepository {

	@Autowired
	private MoviesList movies;

	public List<Movie> movieList() {
		return movies.getMovies();
	}

	public List<Movie> addMovie() {

		/*
		 * movieList.add(new Movie(101, "Black Panther", "9 PM", 2, new
		 * Address("shivaji nagar", "surat", "GJ", "454895"), new Phone[] { new
		 * Phone("Home", "27657"), new Phone("fax", "27657") })); movieList.add(new
		 * Movie(102, "FNF2", "6 PM", 3, new Address("Khradi", "pune", "MH", "454895"),
		 * new Phone[] { new Phone("Home", "27657"), new Phone("fax", "27657") }));
		 * movieList.add(new Movie(103, "Mission Impossible", "9 PM", 1, new
		 * Address("Solapur road", "Chhapra", "Bihar", "454895"), new Phone[] { new
		 * Phone("Home", "27657"), new Phone("fax", "27657") })); movieList.add(new
		 * Movie(105, "Transformer", "12 PM", 4, new Address("pimpri-chinchwad",
		 * "indore", "MP", "454895"), new Phone[] { new Phone("Home", "27657"), new
		 * Phone("fax", "27657") }));
		 */

		// return movieList;

		return movieList();
	}

	/*
	 * public List<Movie> getAllEmployee() { if (!movieList.isEmpty()) return
	 * movieList; return addEmployee(); }
	 */

	public List<Movie> getAllMovies() {
		if (!(movieList() == null))
			return movieList();
		else
			movies.setMovies(new ArrayList<>());

		return addMovie();
	}

	public Movie getMovieById(Integer id) {
		return getAllMovies().stream().filter(x -> x.getMovieId() == id).findFirst().orElse(null);

	}

	public List<Movie> updateMovie(Integer movieId, Movie movie) {
		Movie updatedMovie = getMovieById(movie.getMovieId());
		int index = movieList().indexOf(updatedMovie);
		movieList().set(index, movie);
		return movieList();
	}

	public Movie deleteMoviebyId(Integer movieId) {
		Movie movie = getMovieById(movieId);
		if (movie != null) {
			movieList().removeIf(x -> x.getMovieId().equals(movieId));
			return movie;
		}
		return null;
	}

	/*
	 * public static List<Movie> addMovie(Movie movie) { movieList.add(movie);
	 * return movieList; }
	 */

	public List<Movie> addMovie(Movie movie) {
		if (movies.getMovies() == null)
			movies.setMovies(new ArrayList<>());
		movies.getMovies().add(movie);
		return movies.getMovies();
	}

}
