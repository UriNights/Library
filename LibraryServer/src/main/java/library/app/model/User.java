package library.app.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter @Setter public class User extends Person {

	public enum Rol { Admin, Standard }

	@Basic(optional = false)
	@Column(name = "DNI", nullable = false, length = 9, unique = true)
	private String dni;
	
	@Basic(optional = false)
	@Column(name = "AGE", nullable = false)
	private int age;

	public User(String name, String midName, String lastName, String dni, int age) {
		super(name, midName, lastName);
		this.dni = dni;
		this.age = age;
	}
}
