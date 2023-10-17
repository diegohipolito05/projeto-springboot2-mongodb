package com.diegohipolito05.projetomongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegohipolito05.projetomongodb.domain.User;
import com.diegohipolito05.projetomongodb.repository.UserRepository;
import com.diegohipolito05.projetomongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
	Optional<User> obj = repository.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}
