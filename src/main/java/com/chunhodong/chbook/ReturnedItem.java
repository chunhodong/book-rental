package com.chunhodong.chbook;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@Getter
@Entity
@Table(name = "rented_item")
public class ReturnedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "returned_date")
    private LocalDate returnedDate;
    @Column(name = "book_title")
    private String bookTitle;

    public static ReturnedItem createReturnedItem(Long bookId,String bookTitle,LocalDate now){
        return ReturnedItem.builder()
                .bookId(bookId)
                .bookTitle(bookTitle)
                .returnedDate(now)
                .build();
    }
}
