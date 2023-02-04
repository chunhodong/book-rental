package com.chunhodong.chbook.domain;

import com.chunhodong.chbook.Rental;
import com.chunhodong.chbook.RentalStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RentalTest {

    @Test
    @DisplayName("대출을 생성한다")
    void createRental() {
        Rental rental = Rental.createRental(10l);

        assertAll(
                () -> assertThat(rental.getRentalStatus() == RentalStatus.RENTAL_AVAILABLE),
                () -> assertThat(rental.getUserId() == 10),
                () -> assertThat(rental.getLateFee() == 0l)
        );
    }
}
