package library.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AUTHORS")
@Getter @Setter public class Author {

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Book> books;
}
