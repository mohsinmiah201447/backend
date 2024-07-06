package com.isdbbros.realestate.dao.data;

import com.isdbbros.realestate.model.config.Plot;
import com.isdbbros.realestate.model.data.CarRentPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CarRentPaymentRepository extends JpaRepository<CarRentPayment, Long> {

    @Modifying
    @Query(value = "UPDATE Role e " +
            "SET e.active = false, e.modifiedBy = :modifiedBy, e.modifiedDate = :modifiedDate " +
            "where e.id = :id")
    int softDeleteById(@Param("id") Long id, @Param("modifiedBy") String modifiedBy, @Param("modifiedDate") LocalDateTime modifiedDate);

}