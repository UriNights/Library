package library.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.app.model.Library;
import library.app.repository.LibraryRepository;
import library.app.repository.interfaces.LibraryNoBooks;

@Service
public class LibraryService {

	@Autowired
	LibraryRepository repository;
	
	public void addLibrary(Library library) {
		repository.save(library);
	}

	public void deleteLibrary(Library library) {
		repository.delete(library);
	}

	public Iterable<LibraryNoBooks> findAllLibraries() {
		return repository.findBy();
	}
}