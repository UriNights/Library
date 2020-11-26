package library.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.app.model.Library;
import library.app.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	LibraryRepository repository;

	public Iterable<Library> findAll() {
		return repository.findAll();
	}
	
	public void addLibrary(Library library) {
		repository.save(library);
	}

	public void deleteLibrary(Library library) {
		repository.delete(library);
	}
}
