package org.openjfx.libraryclient.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter public abstract class Person {
	
	private String name;
	private String midName;
	private String lastName;
	
	public Person() {
	}
	
	public Person(String name, String midName, String lastName) {

		this.name = name;
		this.midName = midName;
		this.lastName = lastName;
	}
}
