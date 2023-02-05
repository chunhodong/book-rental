package com.chunhodong.chbook.domain;

import com.chunhodong.chbook.Rental;
import com.chunhodong.chbook.RentalStatus;
import com.chunhodong.chbook.RentalUnavailableException;
import com.chunhodong.chbook.RentedItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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

    @Test
    @DisplayName("대출이 연체상태인경우 예외발생")
    void checkRentalAvailableAtAvialable(){
        Rental rental = Rental.builder()
                .rentalStatus(RentalStatus.RENTAL_UNAVILABLE)
                .build();

        assertThatThrownBy(() -> rental.checkRentalAvailable())
                .isInstanceOf(RentalUnavailableException.class)
                .hasMessageContaining("연체 상태입니다. 연체료를 정산 후, 도서를 대출하실 수 있습니다.");

    }

    @Test
    @DisplayName("대출목록이 5개 이상이면 예외발생")
    void checkRentalAvailableAtGreaterThanItems(){
        HashSet rentedItems = new HashSet();
        rentedItems.add(new RentedItem());
        rentedItems.add(new RentedItem());
        rentedItems.add(new RentedItem());
        rentedItems.add(new RentedItem());
        rentedItems.add(new RentedItem());
        Rental rental = Rental.builder()
                .rentalStatus(RentalStatus.RENTAL_AVAILABLE)
                .rentedItems(rentedItems)
                .build();

        assertThatThrownBy(() -> rental.checkRentalAvailable())
                .isInstanceOf(RentalUnavailableException.class)
                .hasMessageContaining("대출 가능한 도서의 수는 5권까지입니다.");

    }
}
