package org.openjfx.libraryclient.model;

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
}