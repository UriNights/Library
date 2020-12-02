package org.openjfx.libraryclient.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter public class User extends Person implements IsModel {

	private long _id;
	
	private enum Rol { ADMIN, STANDARD };
	private Rol rol;
	
	private String password;
	private String nick;
	private String dni;
	private int age;
	private List<Lending> lendings;
	
	public User() {
		
	}
	
	public User(String name, String midName, String lastName) {
		super(name, midName, lastName);
	}

	public User(String name, String midName, String lastName, String nick, String password, String dni, int age, List<Lending> lendings) {
		super(name, midName, lastName);
		this.rol = Rol.ADMIN;
		this.nick = nick;
		this.password = password;
		this.dni = dni;
		this.age = age;
		this.lendings = lendings;
	}
}
