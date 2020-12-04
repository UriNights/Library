package org.openjfx.libraryclient.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter public class User extends Person implements IsModel {

	private long _id;
	
	public enum Rol { ADMIN, STANDARD;
		public static List<Rol> list() {
			
			List<Rol> rols = new ArrayList<>();
			
			for (User.Rol rol : User.Rol.values()) {
				rols.add(rol);
			}
			
			return rols;
		}
	};
	
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
		this.nick = nick;
		this.password = password;
		this.dni = dni;
		this.age = age;
		this.lendings = lendings;
	}
}
