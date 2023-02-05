package com.chunhodong.chbook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    @OneToMany(mappedBy = "rental",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RentedItem> rentedItems = new HashSet();

    public static Rental createRental(Long userId) {
        return Rental.builder()
                .rentalStatus(RentalStatus.RENTAL_AVAILABLE)
                .userId(userId)
                .lateFee(DEFAULT_RENTAL_FEE)
                .build();
    }

    public void checkRentalAvailable() {
        if(rentalStatus == RentalStatus.RENTAL_UNAVILABLE){
            throw new RentalUnavailableException("연체 상태입니다. 연체료를 정산 후, 도서를 대출하실 수 있습니다.");
        }

        if(rentedItems.size() >= 5){
            throw new RentalUnavailableException("대출 가능한 도서의 수는 5권까지입니다.");
        }
    }
}
