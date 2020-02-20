package com.jogoler.android.tmdb.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by Gilbert on 8/20/2017.
 */

public class Trailer implements Parcelable, Comparable<Trailer> {

	public static final Creator<Trailer> CREATOR = new Creator<Trailer>() {
		@Override
		public Trailer createFromParcel(Parcel in) {
			return new Trailer(in);
		}

		@Override
		public Trailer[] newArray(int size) {
			return new Trailer[size];
		}
	};
	private String id;
	private String key;
	private String name;
	private String site;
	private int size;
	private String type;

	protected Trailer(Parcel in) {
		id = in.readString();
		key = in.readString();
		name = in.readString();
		site = in.readString();
		size = in.readInt();
		type = in.readString();
	}

	@Override
	public int compareTo(@NonNull Trailer trailer) {
		return 0;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public String getId() {
		return id;
	}

	public String getKey() {
		return key;
	}

	public String getKeyyy() {
		if (key != null && !key.isEmpty()) {
			return "http://www.youtube.com/watch?v=" + key;
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public String getSite() {
		return site;
	}

	public int getSize() {
		return size;
	}

	public String getType() {
		return type;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(id);
		parcel.writeString(key);
		parcel.writeString(name);
		parcel.writeString(site);
		parcel.writeInt(size);
		parcel.writeString(type);
	}
}
