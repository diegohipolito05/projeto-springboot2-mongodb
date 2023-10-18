package com.diegohipolito05.projetomongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.diegohipolito05.projetomongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{'title': {$regex: ?0i } }")
	List<Post> findByTitle(String title);
	
	List<Post> findByTitleContainingIgnoreCase(String title);

}
