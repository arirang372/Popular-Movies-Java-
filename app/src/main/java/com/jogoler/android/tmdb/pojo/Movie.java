package com.jogoler.android.tmdb.pojo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.jogoler.android.tmdb.R;

/**
 * Created by Gilbert on 8/20/2017.
 */

public class Movie implements Parcelable {

	public static final Creator<Movie> CREATOR = new Creator<Movie>() {
		@Override
		public Movie createFromParcel(Parcel in) {
			return new Movie(in);
		}

		@Override
		public Movie[] newArray(int size) {
			return new Movie[size];
		}
	};
	public static final String TAG = Movie.class.getName();
	private String backdrop_path;
	private long id;
	private String overview;
	private String poster_path;
	private String release_date;
	private String title;
	private String vote_average;

	protected Movie(Parcel in) {
		id = in.readLong();
		vote_average = in.readString();
		title = in.readString();
		poster_path = in.readString();
		overview = in.readString();
		release_date = in.readString();
		backdrop_path = in.readString();
	}

	public Movie(long id, String vote_average, String title, String poster_path, String overview, String release_date, String backdrop_path) {
		this.id = id;
		this.vote_average = vote_average;
		this.title = title;
		this.poster_path = poster_path;
		this.overview = overview;
		this.release_date = release_date;
		this.backdrop_path = backdrop_path;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public String getBackdrop_path(Context context) {
		if (backdrop_path != null && !backdrop_path.isEmpty()) {
			return context.getResources().getString(R.string.url_for_downloading_backdrop) +
					backdrop_path;
		}
		return null;
	}

	public String getBackdrop_path() {
		return backdrop_path;
	}

	public long getId() {
		return id;
	}

	public String getOverview() {
		return overview;
	}

	public String getPoster_path(Context context) {
		if (poster_path != null && !poster_path.isEmpty()) {
			return context.getResources().getString(R.string.url_for_downloading_poster) + poster_path;
		}
		return null;
	}

	public String getPosterpath() {
		return poster_path;
	}

	public String getRelease_date(Context context) {
		String inputPatter = "yyyy-dd-MM";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(inputPatter, Locale.US);
		if (release_date != null && !release_date.isEmpty()) {
			try {
				Date date = simpleDateFormat.parse(release_date);
				return DateFormat.getDateInstance().format(date);
			} catch (ParseException e) {
				Log.e(TAG, "error to parse: " + release_date);
			}
		} else {
			release_date = "Release date is null";
		}
		return release_date;
	}

	public String getRelease_date() {
		return release_date;
	}

	public String getTitle() {
		return title;
	}

	public String getVote_average() {
		return vote_average;
	}

	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeLong(id);
		parcel.writeString(vote_average);
		parcel.writeString(title);
		parcel.writeString(poster_path);
		parcel.writeString(overview);
		parcel.writeString(release_date);
		parcel.writeString(backdrop_path);
	}
}
