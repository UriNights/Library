package library.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.app.model.Author;
import library.app.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository repository;

	public Iterable<Author> findAll() {
		return repository.findAll();
	}

	public void addAuthor(Author author) {
		repository.save(author);
	}

	public void deleteAuthor(Author author) {
		repository.delete(author);
	}
}