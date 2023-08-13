package com.iamfaizankhalid.livetv;

import android.os.Parcel;
import android.os.Parcelable;

public class Video implements Parcelable {
    public static final Parcelable.Creator<Video> CREATOR = new Creator<Video>() {
        @Override
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        @Override
        public Video[] newArray(int size) {
            return new Video[size];
        }
    };
    private final String title;
    private final String description;

    public Video(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Parcelable implementation
    protected Video(Parcel in) {
        title = in.readString();
        description = in.readString();
        // Read other fields here if you have more properties
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        // Write other fields here if you have more properties
    }
}
