package org.openjfx.libraryclient.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOOKS")
@Getter @Setter public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long _id;
	
	@Basic(optional = false)
	@Column(name = "TITLE", nullable = false, length = 40)
	private String title;
	
	@ManyToMany(mappedBy = "books")
	private List<Author> authors;
	
	@Basic(optional = false)
	@Column(name = "ISBN", nullable = false, length = 17, unique = true)
	private String isbn;	// ISBN example 978-3-16-148410-0
	
	@Basic(optional = false)
	@Column(name = "PAGES", nullable = false)
	private int pages;
	
	@Basic(optional = false)
	@Column(name = "GENRE", nullable = false)
	private Genre genre;
	
	@Basic(optional = false)
	@ManyToOne
	@JoinColumn(name = "LIBRARY_FK", nullable = false)
	private Library library;
	
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "book")
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
