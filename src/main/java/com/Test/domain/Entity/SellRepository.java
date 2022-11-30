package com.Test.domain.Entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellRepository extends JpaRepository<SellEntity, Integer  > {

    @Query( value = "select * from sell_list  where storeno = :storeno" , nativeQuery = true)
    Page<SellEntity> findByStoreno( int storeno , Pageable pageable);

}
