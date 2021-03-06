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
	
	private enum Rol { ADMIN, STANDARD };
	@Basic(optional = false)
	@Column(name = "ROL", nullable = false)
	private Rol rol;
	
	@Basic(optional = false)
	@Column(name = "NICK", nullable = false, length = 15)
	private String nick;
	
	@Basic(optional = false)
	@Column(name = "PASSWORD", nullable = false, length = 10)
	private String password;

	@Basic(optional = false)
	@Column(name = "DNI", nullable = false, length = 9, unique = true)
	private String dni;
	
	@Basic(optional = false)
	@Column(name = "AGE", nullable = false)
	private int age;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
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
