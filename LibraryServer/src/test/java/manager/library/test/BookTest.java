package manager.library.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import library.app.model.Author;
import library.app.model.Book;
import library.app.model.Genre;
import library.app.model.Library;
import library.app.repository.BookRepository;

@SpringBootTest
public class BookTest {

    @Autowired
    BookRepository repository;

    @Test
    public void saveBook() throws Exception {
    	
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("George", "Orwell", "Carrigan"));
        authors.add(new Author("Jose", "Luis", "Carapan"));
        
        Book book = new Book("1984", authors, "ISBNsdsaas", 145, Genre.ADVENTURE, new Library("Biblioteca de les Corts", "Barcelona"));
        
    	assertEquals(book, repository.save(book));
    }
}