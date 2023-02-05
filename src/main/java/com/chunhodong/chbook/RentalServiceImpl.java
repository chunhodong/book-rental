package com.chunhodong.chbook;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RentalServiceImpl implements RentalService{
    @Override
    public Rental rentBook(Long userId, Long bookId, String bookTitle) {
        return null;
    }
}
