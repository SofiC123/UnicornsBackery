package org.generation.UnicornsBackery.repositories;

import org.springframework.data.repository.CrudRepository;

import org.generation.UnicornsBackery.model.Users;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<Users, Integer> {
}