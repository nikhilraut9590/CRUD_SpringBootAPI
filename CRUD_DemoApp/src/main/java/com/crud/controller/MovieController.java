package com.crud.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Movie;
import com.crud.exception.EmptyMovieListException;
import com.crud.exception.MovieAlreadyExist;
import com.crud.exception.MovieNotFoundException;
import com.crud.service.MovieService;

@RestController
@RequestMapping("movie")
public class MovieController {
	@Autowired
	MovieService movieService;

	/* get all movies */
	@GetMapping("/getAllMovies")
	public ResponseEntity<List<Movie>> getAllMovies() throws EmptyMovieListException {
		List<Movie> listOfMovies = movieService.getAllMovies();
		if (listOfMovies.isEmpty()) {
			throw new EmptyMovieListException("Sorry! Movie List is empty");
		}
		return new ResponseEntity<List<Movie>>(listOfMovies, HttpStatus.OK);
	}

	/* get movie by movieId */
	@GetMapping("/getByMovieId/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") Integer movieId)
			throws MovieNotFoundException, Exception {
		Movie movie = movieService.getMovieById(movieId);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);

	}

	/* delete movie by movieId */
	@DeleteMapping("/deleteByMovieId/{movieId}")
	public ResponseEntity<String> deleteMovieById(@PathVariable("movieId") Integer movieId)
			throws MovieNotFoundException {
		String responseMessage = movieService.deleteMovieById(movieId);
		return new ResponseEntity<String>(responseMessage, HttpStatus.OK);
	}

	@PutMapping("/updateMovie/{id}")
	public ResponseEntity<List<Movie>> updateMovieById(@PathVariable("id") Integer movieId, @RequestBody Movie movie)
			throws Exception {
		movieService.deleteMovieById(movieId);
		movie.setMovieId(movieId);
		movieService.addMovie(movie);
		List<Movie> updatedMovieList = movieService.getAllMovies();
		return new ResponseEntity<List<Movie>>(updatedMovieList, HttpStatus.OK);
	}

	/* get Movie by Id or Movie name */
	@GetMapping("/getByIdOrName/{id}/{name}")
	public ResponseEntity<Movie> getMovieByIdOrByName(@PathVariable("id") Integer movieId,
			@PathVariable("name") String movieName) throws MovieNotFoundException, EmptyMovieListException {
		Movie movie = movieService.getAllMovies().stream().filter(x -> x.getMovieId() == movieId)
				.filter(x -> x.getMovieName().equals(movieName)).findFirst()
				.orElseThrow(() -> new MovieNotFoundException("No Movie Available"));
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}

	@PostMapping("/addMovie")
	public ResponseEntity<List<Movie>> addMovie(@RequestBody Movie movie) throws Exception {
		List<Movie> newMovieList = movieService.addMovie(movie);
		return new ResponseEntity<List<Movie>>(newMovieList, HttpStatus.CREATED);
	}

	/* get Movie by Movie city */
	@GetMapping("/getByMovieCity/{city}")
	public ResponseEntity<List<Movie>> getMovieByCity(@PathVariable("city") String movieName)
			throws MovieNotFoundException, EmptyMovieListException {
		List<Movie> movies = movieService.getAllMovies().stream()
				.filter(x -> x.getAddress().getCity().equalsIgnoreCase(movieName)).collect(Collectors.toList());
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	/* get Movie by Pincode */
	@GetMapping("/getByMoviePincode/{pincode}")
	public ResponseEntity<List<Movie>> getMovieByPincode(@PathVariable("pincode") String pincode)
			throws MovieNotFoundException, EmptyMovieListException {
		List<Movie> movies = movieService.getAllMovies().stream()
				.filter(x -> x.getAddress().getPostalCode().equalsIgnoreCase(pincode)).collect(Collectors.toList());
		if (movies.isEmpty()) {
			throw new EmptyMovieListException("No Movies Found with Pincode :" + pincode);
		}
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	/* get Movie by Street */
	@GetMapping("/getByMovieStreet/{street}")
	public ResponseEntity<List<Movie>> getMovieByStreet(@PathVariable("street") String street)
			throws MovieNotFoundException, EmptyMovieListException {
		List<Movie> movies = movieService.getAllMovies().stream()
				.filter(x -> x.getAddress().getStreet().equalsIgnoreCase(street)).collect(Collectors.toList());
		if (movies.isEmpty()) {
			throw new EmptyMovieListException("No Movies Found with Street Name :" + street);
		}
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	/* get Movie by State */
	@GetMapping("/getByMovieState/{state}")
	public ResponseEntity<List<Movie>> getMovieByState(@PathVariable("state") String state)
			throws MovieNotFoundException, EmptyMovieListException {
		List<Movie> movies = movieService.getAllMovies().stream()
				.filter(x -> x.getAddress().getState().equalsIgnoreCase(state)).collect(Collectors.toList());
		if (movies.isEmpty()) {
			throw new EmptyMovieListException("No Movies Found with State Name :" + state);
		}
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

	/* get Movie by Movie Time */
	@GetMapping("/getMovieByTime/{time}")
	public ResponseEntity<List<Movie>> getMovieByTime(@PathVariable("time") String time)
			throws MovieNotFoundException, EmptyMovieListException {
		List<Movie> movies = movieService.getAllMovies().stream().filter(x -> x.getMovieTime().equalsIgnoreCase(time))
				.collect(Collectors.toList());
		if (movies.isEmpty()) {
			throw new EmptyMovieListException("No Movies Found with Show Time :" + time);
		}
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}

}
