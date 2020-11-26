package library.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import library.app.model.Author;
import library.app.model.Book;
import library.app.service.BookService;

@RestController
@RequestMapping("/webapi")
public class BooksRest {

	@Autowired
	BookService service;

	@GetMapping("/books")
	public Iterable<Book> findAll() {
		return service.findAll();
	}
	
	@PostMapping(path="/book/byauthor", consumes="application/json")
	public Iterable<Book> findByAuthor(@RequestBody Author author) {
		return service.findByAuthor(author);
	}
	
	@PostMapping(path="/book/bytitle", consumes="application/json")
	public Iterable<Book> findByTitle(@RequestBody Book book) {
		return service.findByTitle(book);
	}
	
	@PostMapping(path="/new_book", consumes="application/json")
	public void addBook(@RequestBody Book book) {
		service.addBook(book);
	}
	
	@PostMapping(path="/delete_book", consumes="application/json")
	public void deleteBook(@RequestBody Book book) {
		service.deleteBook(book);
	}
}
