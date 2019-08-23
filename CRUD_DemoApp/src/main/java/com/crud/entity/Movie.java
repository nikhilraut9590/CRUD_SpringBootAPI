package com.crud.entity;

public class Movie {
	private Integer movieId;
	private String movieName;
	private String movieTime;
	private Integer movieScreen;
	private Address address;
	private Phone phoneNumber[];

	public Movie(Integer movieId, String movieName, String movieTime, Integer movieScreen, Address address,
			Phone phoneNumber[]) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieTime = movieTime;
		this.movieScreen = movieScreen;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}

	public Integer getMovieScreen() {
		return movieScreen;
	}

	public void setMovieScreen(Integer movieScreen) {
		this.movieScreen = movieScreen;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Phone[] getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Phone phoneNumber[]) {
		this.phoneNumber = phoneNumber;
	}
}
