package org.openjfx.libraryclient.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter public class Lending implements IsModel {

	private long _id;
    private LocalDate lendingDate;
    private int period;
    private LocalDate returnedDate;
    private boolean active;
    private User user;
    private Book book;
    
    protected Lending() {
    }

	public Lending(long _id, LocalDate lendingDate, int period, LocalDate returnedDate, User user, Book book) {

		this.lendingDate = lendingDate;
		this.period = period;
		this.returnedDate = returnedDate;
		this.active = true;
		this.user = user;
		this.book = book;
	}
}
