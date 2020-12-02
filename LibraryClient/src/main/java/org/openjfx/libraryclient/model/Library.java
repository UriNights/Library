package org.openjfx.libraryclient.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter public class Library implements IsModel {

	private long _id;
	private String name;
	private String location;
	private List<Book> books;
	
	protected Library() {
	}

	public Library(String name, String location) {

		this.name = name;
		this.location = location;
	}
}
