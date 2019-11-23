package com.bangkandar.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {

    private String judul;
    private int gambar;
    private String deskripsi;
    private String durasi;
    private String genre;
    private String rilis;
    private String rating;
    private String episode;

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public TvShow() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.durasi);
        dest.writeString(this.deskripsi);
        dest.writeString(this.genre);
        dest.writeString(this.rating);
        dest.writeString(this.rilis);
        dest.writeString(this.episode);
        dest.writeInt(this.gambar);
    }

    protected TvShow(Parcel in) {
        this.judul = in.readString();
        this.durasi = in.readString();
        this.deskripsi = in.readString();
        this.genre = in.readString();
        this.rating = in.readString();
        this.rilis = in.readString();
        this.episode = in.readString();
        this.gambar = in.readInt();
    }

    public static final Creator<TvShow> CREATOR = new Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}