package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
