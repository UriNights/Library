package library.app.model;

import java.util.List;

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
@Table(name = "AUTHORS")
@Getter @Setter public class Author extends Person {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long _id;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Book> books;

	public Author(String name, String midName, String lastName) {
		super(name, midName, lastName);
	}
}
