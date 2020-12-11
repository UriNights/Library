package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Author;
import library.app.model.Person;

public interface AuthorRepository extends CrudRepository<Author, Long> {
	
	Iterable<Person> findBy();
}