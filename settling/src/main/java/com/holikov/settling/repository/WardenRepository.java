package com.holikov.settling.repository;

import com.holikov.settling.model.dormitory.Warden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardenRepository extends JpaRepository<Warden, Long> {
}
