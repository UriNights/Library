package org.openjfx.libraryclient.model;

import java.util.ArrayList;
import java.util.List;

import org.openjfx.libraryclient.model.User.Rol;

import lombok.Getter;

@Getter public enum Genre {

	ADVENTURE("adventure"),
	BLACK("black"),
	CHILDISH("childish"),
	COMEDY("comedy"),
	DETECTIVE("detective"),
	DYSTOPIAN("dystopian"),
	FANTASY("fantasy"),
	ROMANCE("romance"),
	SCIFI("science fiction"),
	TERROR("terror");

	private String genre;
	
	private Genre(String genre) {
		this.genre = genre;
	}
	
	public static List<Genre> list() {
		
		List<Genre> genres = new ArrayList<>();
		
		for (Genre genre : Genre.values()) {
			genres.add(genre);
		}
		
		return genres;
	}
}