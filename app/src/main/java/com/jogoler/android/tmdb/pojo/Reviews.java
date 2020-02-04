package com.jogoler.android.tmdb.pojo;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Gilbert on 8/20/2017.
 */

public class Reviews {

	@SerializedName("results")
	private List<Review> reviews = new ArrayList<>();

	public List<Review> getReviews() {
		return reviews;
	}
}
