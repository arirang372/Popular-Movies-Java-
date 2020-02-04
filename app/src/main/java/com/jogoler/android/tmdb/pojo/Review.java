package com.jogoler.android.tmdb.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Gilbert on 8/20/2017.
 */

public class Review implements Parcelable, Comparable<Review> {

	public static final Creator<Review> CREATOR = new Creator<Review>() {
		@Override
		public Review createFromParcel(Parcel in) {
			return new Review(in);
		}

		@Override
		public Review[] newArray(int size) {
			return new Review[size];
		}
	};
	private String author;
	private String content;
	private String id;
	private String url;

	protected Review(Parcel in) {
		id = in.readString();
		author = in.readString();
		content = in.readString();
		url = in.readString();
	}

	@Override
	public int compareTo(@NonNull Review review) {
		return 0;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public String getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public String getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(id);
		parcel.writeString(author);
		parcel.writeString(content);
		parcel.writeString(url);
	}
}
