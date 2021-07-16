package org.generation.UnicornsBackery.repositories;

import org.generation.UnicornsBackery.model.Users;
import org.springframework.data.repository.CrudRepository;

import org.generation.UnicornsBackery.model.Products;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ProductsRepository extends CrudRepository<Products, Integer>{
}
