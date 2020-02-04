package com.jogoler.android.tmdb.pojo;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gilbert on 8/20/2017.
 */

public class Trailers {

	@SerializedName("results")
	private List<Trailer> trailers;

	public Trailers(List<Trailer> trailers) {
		this.trailers = trailers;
	}

	public List<Trailer> getTrailers() {
		return trailers;
	}
}
