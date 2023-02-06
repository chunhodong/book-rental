package com.chunhodong.chbook.adapter;

import com.chunhodong.chbook.dto.BookResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book")
public interface BookClient {
    @GetMapping("/api/books/bookInfo/{bookId}")
    ResponseEntity<BookResponse> findBookInfo(@PathVariable("bookId") Long bookId);
}
