package library.app.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter public abstract class Person {
	
	@Basic(optional = false)
	@Column(name = "NAME", nullable = false, length = 15)
	private String name;
	
	@Basic(optional = false)
	@Column(name = "MID_NAME", nullable = false, length = 20)
	private String midName;
	
	@Basic(optional = false)
	@Column(name = "LAST_NAME", nullable = false, length = 20)
	private String lastName;
	
	public Person() {
	}
	
	public Person(String name, String midName, String lastName) {

		this.name = name;
		this.midName = midName;
		this.lastName = lastName;
	}
}
