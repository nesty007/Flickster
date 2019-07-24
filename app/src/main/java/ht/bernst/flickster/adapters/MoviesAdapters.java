package ht.bernst.flickster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ht.bernst.flickster.R;
import ht.bernst.flickster.models.Movie;

public class MoviesAdapters extends RecyclerView.Adapter<MoviesAdapters.viewHolder> {

    Context context;
    List<Movie> movies;

    public MoviesAdapters(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("smile", "onCreateViewHolder");
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Log.d("smile", "onCreateViewHolder" + position);
        Movie movie = movies.get(position);
        //Bing the movie data into the view holder
        holder.bind(movie);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvOverview;
        ImageView ivBackDrop;
        ImageView ivPoster;

        public viewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(final Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverview());
            String imageUrl = movie.getPosterPath();
            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                imageUrl= movie.getBackdropPath(); }
            Glide.with(context).load(imageUrl).into(ivPoster);
            tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, movie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
