package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}