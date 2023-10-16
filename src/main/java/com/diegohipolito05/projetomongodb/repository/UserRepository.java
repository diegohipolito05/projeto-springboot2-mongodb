package com.diegohipolito05.projetomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diegohipolito05.projetomongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
