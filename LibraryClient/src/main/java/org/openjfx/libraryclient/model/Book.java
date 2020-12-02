package org.openjfx.libraryclient.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter public class Book implements IsModel {

	private long _id;
	private String title;
	private List<Author> authors;
	private String isbn;	// ISBN example 978-3-16-148410-0
	private int pages;
	private Genre genre;
	private Library library;
	private List<Lending> lendings;
	
	protected Book() {
	}

	public Book(String title, List<Author> authors, String isbn, int pages, Genre genre, Library library) {

		this.title = title;
		this.authors = authors;
		this.isbn = isbn;
		this.pages = pages;
		this.genre = genre;
		this.library = library;
	}
}
