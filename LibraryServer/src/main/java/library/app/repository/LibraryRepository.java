package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Author;
import library.app.model.Lending;
import library.app.model.Library;

public interface LibraryRepository extends CrudRepository<Library, Long> {

	Iterable<Lending> findByAuthor(Author author);
}
