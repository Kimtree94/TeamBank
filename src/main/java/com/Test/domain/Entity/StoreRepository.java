package com.Test.domain.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface StoreRepository extends JpaRepository<StoreEntity, Integer  > {
}
