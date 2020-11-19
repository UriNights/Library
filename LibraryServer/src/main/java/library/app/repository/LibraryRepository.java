package library.app.repository;

import org.springframework.data.repository.CrudRepository;

import library.app.model.Library;

public interface LibraryRepository extends CrudRepository<Library, Long> {
}
