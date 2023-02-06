package com.chunhodong.chbook.adapter;

public interface RentalProducer {

    void updateBookStatus(Long bookId, String bookStatus);

    void savePoints(Long userId, int pointPerBooks);

    void updateBookCatalogStatus(Long bookId, String eventType);
}
