package android.myapp.moviesapp.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    private  long movieId;
    @SerializedName("title")
    private  String movieTitle;
    @SerializedName("overview")
    private  String movieOverView;
    @SerializedName("vote_average")
    private  double movieUserRating;
    @SerializedName("release_date")
    private  String movieReleaseDate;
    @SerializedName("poster_path")
    private  String moviePosterPath;

    public Movie(long movieId,String movieTitle,String movieOverView,double movieUserRating,String movieReleaseDate,String moviePosterPath)
    {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieOverView = movieOverView;
        this.movieUserRating = movieUserRating;
        this.movieReleaseDate = movieReleaseDate;
        this.moviePosterPath = moviePosterPath;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieOverView() {
        return movieOverView;
    }

    public void setMovieOverView(String movieOverView) {
        this.movieOverView = movieOverView;
    }

    public double getMovieUserRating() {
        return movieUserRating;
    }

    public void setMovieUserRating(double movieUserRating) {
        this.movieUserRating = movieUserRating;
    }
    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String getMoviePosterPath() {
        return moviePosterPath;
    }

    public void setMoviePosterPath(String moviePosterPath) {
        this.moviePosterPath = moviePosterPath;
    }
}
