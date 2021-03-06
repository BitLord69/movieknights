package com.movieknights.server.setup;

import com.movieknights.server.entities.Movie;
import com.movieknights.server.services.MovieService;

  public class DownloadMovieTask implements Runnable {
  private long movieId;

  private MovieService movieService;

  public DownloadMovieTask(long id, MovieService ms) {
    movieId = id;
    movieService = ms;
  }

  @Override
    public void run() {
    Movie m = movieService.getMovieById(movieId);
  }
}
