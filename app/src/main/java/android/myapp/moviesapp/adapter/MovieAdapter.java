package android.myapp.moviesapp.adapter;

import android.content.Context;
import android.myapp.moviesapp.R;
import android.myapp.moviesapp.model.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>{

   private Context mContext;
   private List<Movie> mListMovie;
    final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/";
    final String SIZE = "w185";

   public MovieAdapter(Context context,List<Movie> movies)
   {
       mContext = context;
       mListMovie = movies;
   }
    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

    String posterPath = mListMovie.get(position).getMoviePosterPath();
      //Loading image from url into imageView
        Log.d("Adapter","movies " + String.valueOf(posterPath));
        Glide.with(mContext)
                .load(IMAGE_BASE_URL+SIZE+posterPath)
                .into(holder.imageViewPoster);

    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(mContext).inflate(R.layout.movie_list_item,parent,false);
       return new MovieViewHolder(view);
    }

    @Override
    public int getItemCount() {
       if(mListMovie == null)
        return 0;
       else
           return mListMovie.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageViewPoster;
        public MovieViewHolder(View itemView) {
            super(itemView);
            imageViewPoster = itemView.findViewById(R.id.image_movie_poster);
        }
    }
    public void setMovies(List<Movie> movies)
    {
        if(movies != null)
        {
            mListMovie = movies;
            Log.d("Adapter","movies " + String.valueOf(mListMovie.size()));
            notifyDataSetChanged();
        }
    }
}
