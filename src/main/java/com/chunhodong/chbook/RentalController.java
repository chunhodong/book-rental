package com.chunhodong.chbook;

import com.chunhodong.chbook.adapter.BookClient;
import com.chunhodong.chbook.dto.BookResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RentalController {

    private final RentalService rentalService;
    private final BookClient bookClient;

    @PostMapping("/rentals/{userid}/renteditem/{bookid}")
    public ResponseEntity<RentalResponse> rentBook(@PathVariable("userid") Long userId, @PathVariable("bookid") Long bookId) {
        ResponseEntity<BookResponse> bookResponse = bookClient.findBookInfo(bookId);
        BookResponse book = bookResponse.getBody();
        Rental rental = rentalService.rentBook(userId, book.getId(), book.getTitle());
        return ResponseEntity.ok().build();
    }
}
