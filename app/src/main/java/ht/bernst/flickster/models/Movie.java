package ht.bernst.flickster.models;

import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {


    double voteAverage;
    String posterPath;
    String title;
    String overview;
    String backdropPath;
    int movieId;

    //Empty constructor needed by the parceler library
    public Movie() {
    }

    public Movie(JSONObject jsonObject)throws JSONException {
    posterPath = jsonObject.getString("poster_path");
    title = jsonObject.getString("title");
    overview = jsonObject.getString("overview");
    voteAverage = jsonObject.getDouble("vote_average");
    backdropPath = jsonObject.getString("backdrop_path");
    movieId = jsonObject.getInt("id");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++){
         movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }
    public String getPosterPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);}

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getVoteAverage() { return voteAverage; }

    public int getMovieId() { return movieId; }
}
