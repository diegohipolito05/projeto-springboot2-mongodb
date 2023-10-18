package com.diegohipolito05.projetomongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diegohipolito05.projetomongodb.domain.Post;
import com.diegohipolito05.projetomongodb.resources.util.URL;
import com.diegohipolito05.projetomongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTittle(@RequestParam(value = "title", defaultValue = "") String title){
		String decodeTitle = URL.decodParam(title);
		List<Post> list = service.findByTitle(decodeTitle);
		return ResponseEntity.ok(list);
	}
	
}
