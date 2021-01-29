package com.movieknights.server.repos;

import com.movieknights.server.entities.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepo extends Neo4jRepository<Movie, Long> {
    Optional<Movie> findMovieById(long id);

    @Query ("MATCH (m:mkmovie) RETURN count(m)")
    int getCount();
}
