package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Library;
import library.app.repository.interfaces.LibraryNoBooks;

public interface LibraryRepository extends CrudRepository<Library, Long> {

	Iterable<LibraryNoBooks> findBy();
}