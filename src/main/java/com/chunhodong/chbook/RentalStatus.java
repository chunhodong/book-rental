package com.chunhodong.chbook;

public enum RentalStatus {
    RENTAL_AVAILABLE(0,"대출가능","대출가능상태"),
    RENTAL_UNAVILABLE(1,"대출불가","대출불가능상태");
    RentalStatus(int flag,String status,String message){

    }
}
