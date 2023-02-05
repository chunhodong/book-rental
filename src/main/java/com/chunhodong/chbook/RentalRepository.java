package com.chunhodong.chbook;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    Optional<Rental> findByUserId(Long userId);
}
