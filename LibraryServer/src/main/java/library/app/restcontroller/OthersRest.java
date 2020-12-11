package library.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.app.model.Author;
import library.app.model.Library;
import library.app.model.Person;
import library.app.repository.interfaces.LibraryNoBooks;
import library.app.service.AuthorService;
import library.app.service.LibraryService;

@RestController
@RequestMapping("/webapi")
public class OthersRest {

	@Autowired LibraryService libraryService;
	@Autowired AuthorService authorService;
	
	
	// Add delete library
	@GetMapping("/library")
	public Iterable<LibraryNoBooks> findAllLibraries() {
		return libraryService.findAllLibraries();
	}
	
	@PostMapping(path="/new_library", consumes="application/json")
	public void addLibrary(@RequestBody Library library) {
		libraryService.addLibrary(library);
	}
	
	@PostMapping(path="/delete_library", consumes="application/json")
	public void deleteLibrary(@RequestBody Library library) {
		libraryService.deleteLibrary(library);
	}
	
	
	// Add delete author
	@GetMapping("/author")
	public Iterable<Person> findAllAuthors() {
		return authorService.findAllAuthors();
	}
	
	@PostMapping(path="/new_author", consumes="application/json")
	public void addAuthor(@RequestBody Author author) {
		authorService.addAuthor(author);
	}
	
	@PostMapping(path="/delete_author", consumes="application/json")
	public void deleteAuthor(@RequestBody Author author) {
		authorService.deleteAuthor(author);
	}
}
