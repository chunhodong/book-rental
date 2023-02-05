package com.chunhodong.chbook;

public interface RentalService {
    Rental rentBook(Long userId,Long bookId,String bookTitle);
}
