package library.app.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@Column(name = "DNI", nullable = false, length = 9, unique = true)
	private String dni;
	
	@Basic(optional = false)
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "user")
	private List<Lending> lendings;

	public User(String name, String midName, String lastName, String dni, int age, List<Lending> lendings) {
		super(name, midName, lastName);
		this.dni = dni;
		this.age = age;
		this.lendings = lendings;
	}
}
