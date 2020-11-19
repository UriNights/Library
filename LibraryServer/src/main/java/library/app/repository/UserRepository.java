package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}