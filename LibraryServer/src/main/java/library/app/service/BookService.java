package library.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import library.app.model.Author;
import library.app.model.Book;
import library.app.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;

	public Iterable<Book> findAll() {
		return repository.findAll();
	}
	
	public Iterable<Book> findByTitle(Book book) {
		return repository.findByTitle(book.getTitle());
	}
	

	public Iterable<Book> findByAuthor(Author author) {
		return repository.findByAuthor(author);
	}

	public void addBook(Book book) {
		repository.save(book);
	}

	public void deleteBook(Book book) {
		repository.delete(book);
	}
}