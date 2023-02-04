package com.chunhodong.chbook;

import javax.persistence.*;

@Entity
@Table
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus;
    @Column(name = "late_fee")
    private Long lateFee;
}
