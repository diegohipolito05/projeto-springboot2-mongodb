package com.diegohipolito05.projetomongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegohipolito05.projetomongodb.domain.Post;
import com.diegohipolito05.projetomongodb.repository.PostRepository;
import com.diegohipolito05.projetomongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String title){
		List<Post> list = postRepository.findByTitle(title);
		return list;
	}
	
}
