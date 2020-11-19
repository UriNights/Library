package library.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "LENDING")
@Getter @Setter public class Lending {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long _id;
	
    @Column(name = "LENDING_DATE", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate lendingDate;
    
    @Column(name = "PERIOD", updatable = false, nullable = false)
    private int period;
    
    @Column(name = "RETURNED_DATE", updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate returnedDate;
    
    @ManyToOne
    @JoinColumn(name = "USER_FK")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "BOOK_FK")
    private Book book;
    
    protected Lending() {
    }

	public Lending(long _id, LocalDate lendingDate, int period, LocalDate returnedDate, User user, Book book) {

		this.lendingDate = lendingDate;
		this.period = period;
		this.returnedDate = returnedDate;
		this.user = user;
		this.book = book;
	}
}
