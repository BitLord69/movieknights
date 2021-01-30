package com.movieknights.server.repos;

import com.movieknights.server.entities.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepo extends Neo4jRepository<Movie, Long> {
    Optional<Movie> findMovieByMovieId(long id);

    @Query ("MATCH (m:mkmovie) RETURN count(m)")
    int getCount();

    @Query ("MATCH (m:mkmovie) WHERE m.movieId < 5 OPTIONAL MATCH (m)-[r]->(p) WITH m{.*,r} AS movies return COLLECT(DISTINCT movies)")
    List<Movie> getAllMoviesInDb();
}
