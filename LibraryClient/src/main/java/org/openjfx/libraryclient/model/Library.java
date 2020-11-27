package org.openjfx.libraryclient.model;

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
@Table(name = "LIBRARIES")
@Getter @Setter public class Library {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long _id;
	
	@Basic(optional = false)
	@Column(name = "NAME", nullable = false, length = 40)
	private String name;
	
	@Basic(optional = false)
	@Column(name = "LOCATION", nullable = false, length = 40)
	private String location;
	
	@OneToMany(cascade = CascadeType.DETACH, mappedBy = "library")
	private List<Book> books;
	
	protected Library() {
	}

	public Library(String name, String location) {

		this.name = name;
		this.location = location;
	}
}
