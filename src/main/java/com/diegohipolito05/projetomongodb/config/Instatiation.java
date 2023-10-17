package com.diegohipolito05.projetomongodb.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.diegohipolito05.projetomongodb.domain.Post;
import com.diegohipolito05.projetomongodb.domain.User;
import com.diegohipolito05.projetomongodb.dto.AuthorDTO;
import com.diegohipolito05.projetomongodb.dto.CommentDTO;
import com.diegohipolito05.projetomongodb.repository.PostRepository;
import com.diegohipolito05.projetomongodb.repository.UserRepository;

@Configuration
public class Instatiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, LocalDate.parse("2018-03-21"), "Partiu viagem", "Vou viajar para São Paulo. Abraços", new AuthorDTO(maria));
		Post p2 = new Post(null, LocalDate.parse("2018-03-23"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO("Boa viagem mano!", LocalDate.parse("2018-03-21"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", LocalDate.parse("2018-03-22"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", LocalDate.parse("2018-03-23"), new AuthorDTO(alex));
		
		p1.getComments().addAll(Arrays.asList(c1, c2));
		p2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		maria.getPosts().addAll(Arrays.asList(p1, p2));
		

		userRepository.save(maria);
		
	}

}
