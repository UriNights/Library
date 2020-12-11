package library.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.app.model.Author;
import library.app.model.Person;
import library.app.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repository;

	public void addAuthor(Author author) {
		repository.save(author);
	}

	public void deleteAuthor(Author author) {
		repository.delete(author);
	}

	public Iterable<Person> findAllAuthors() {
		return repository.findBy();
	}
}