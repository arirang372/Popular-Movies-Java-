package com.jogoler.android.tmdb.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gilbert on 8/20/2017.
 */

public class Movies {

	@SerializedName("results")
	private List<Movie> movies = new ArrayList<>();

	public List<Movie> getMovies() {
		return movies;
	}
}
