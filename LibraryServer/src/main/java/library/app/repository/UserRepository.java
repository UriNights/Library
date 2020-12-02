package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Person;
import library.app.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	Iterable<Person> findByName(String name);
	
	User findByNick(String nick);
}