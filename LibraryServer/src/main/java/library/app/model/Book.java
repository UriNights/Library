package library.app.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOOKS")
@Getter @Setter public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int _id;
	
	@Basic(optional = false)
	@Column(name = "TITLE", nullable = false, length = 40)
	private String title;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "books")
	private List<Author> authors;
	
	@Basic(optional = false)
	@Column(name = "ISBN", nullable = false, length = 17)
	private String isbn;
	
	@Basic(optional = false)
	@Column(name = "ISBN", nullable = false)
	private int pages;
	
	@Basic(optional = false)
	@Column(name = "GENRE", nullable = false)
	private Genre genre;

	public Book(int _id, String title, List<Author> authors, String isbn, int pages, Genre genre) {

		this._id = _id;
		this.title = title;
		this.authors = authors;
		this.isbn = isbn;
		this.pages = pages;
		this.genre = genre;
	}
	
	// ISBN example 978-3-16-148410-0
}
