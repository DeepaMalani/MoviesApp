package android.myapp.moviesapp.activity;

import android.myapp.moviesapp.R;
import android.myapp.moviesapp.adapter.MovieAdapter;
import android.myapp.moviesapp.model.Movie;
import android.myapp.moviesapp.model.MovieResponse;
import android.myapp.moviesapp.rest.ApiClient;
import android.myapp.moviesapp.rest.ApiInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String API_KEY = "";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Show the message if API_KEY is empty
        if(API_KEY == "")
        {
            Toast.makeText(MainActivity.this,R.string.api_key_message,Toast.LENGTH_LONG).show();
        }
        //Get movie data using retrofit library
        else {
            getData();
            mRecyclerView = findViewById(R.id.recycler_view_movie);
            mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

            mMovieAdapter = new MovieAdapter(this, null);
            mRecyclerView.setAdapter(mMovieAdapter);
        }

    }

    /**
     * Use retrofit to get movies
     */
    public void getData()
    {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<MovieResponse> movieResponseCall = apiService.getTopRatedMovies(API_KEY);
        movieResponseCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {

                List<Movie> movieList = response.body().getResults();
                Log.d(LOG_TAG,"List Size " + String.valueOf(movieList.size()));
                //display return data
                mMovieAdapter.setMovies(movieList);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });

    }

}
