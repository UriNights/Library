package org.openjfx.libraryclient.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter @Setter public class User extends Person {


	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long _id;
	
	public enum Rol { Admin, Standard }
	
	@Basic(optional = false)
	@Column(name = "PASSWORD", nullable = false, length = 10)
	private String password;

	@Basic(optional = false)
	@Column(name = "DNI", nullable = false, length = 9, unique = true)
	private String dni;
	
	@Basic(optional = false)
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "user")
	private List<Lending> lendings;
	
	public User(String name, String midName, String lastName) {
		super(name, midName, lastName);
	}

	public User(String name, String midName, String lastName, String password, String dni, int age, List<Lending> lendings) {
		super(name, midName, lastName);
		this.password = password;
		this.dni = dni;
		this.age = age;
		this.lendings = lendings;
	}
}
