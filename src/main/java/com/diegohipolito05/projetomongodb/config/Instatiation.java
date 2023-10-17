package com.diegohipolito05.projetomongodb.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.diegohipolito05.projetomongodb.domain.Post;
import com.diegohipolito05.projetomongodb.domain.User;
import com.diegohipolito05.projetomongodb.dto.AuthorDTO;
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

		postRepository.saveAll(Arrays.asList(p1, p2));
		
	}

}
