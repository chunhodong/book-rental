package com.chunhodong.chbook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    private static final Long DEFAULT_RENTAL_FEE = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;
    @Column(name = "late_fee")
    private Long lateFee;

    public static Rental createRental(Long userId) {
        return Rental.builder()
                .rentalStatus(RentalStatus.RENTAL_AVAILABLE)
                .userId(userId)
                .lateFee(DEFAULT_RENTAL_FEE)
                .build();
    }
}
