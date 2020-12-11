package org.openjfx.libraryclient.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter public class Author implements IsModel {

	private long _id;
	private String name;
	private String midName;
	private String lastName;
	private List<Book> books;
	
	public Author() {
	}
	
	public Author(String name, String midName, String lastName, List<Book> books) {
		this.name = name;
		this.midName = midName;
		this.lastName = lastName;
		this.books = books;
	}
}
