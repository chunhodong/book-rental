package com.chunhodong.chbook;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Entity
@Table(name = "rented_item")
public class RentedItem {
    private static final int DEFAULT_RENTED_DUEWEEK = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "rented_date")
    private LocalDate rentedDate;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Column(name = "book_title")
    private String bookTitle;
    @ManyToOne
    private Rental rental;

    public static RentedItem createRentedItem(Long bookId,String bookTitle,LocalDate rentedDate) {
        return RentedItem.builder()
                .bookId(bookId)
                .bookTitle(bookTitle)
                .rentedDate(rentedDate)
                .dueDate(rentedDate.plusWeeks(DEFAULT_RENTED_DUEWEEK))
                .build();
    }
}
