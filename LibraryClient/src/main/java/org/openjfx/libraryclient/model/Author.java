package org.openjfx.libraryclient.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter public class Author extends Person implements IsModel {

	private long _id;
	private List<Book> books;
	
	public Author(String name, String midName, String lastName) {
		super(name, midName, lastName);
	}
}
