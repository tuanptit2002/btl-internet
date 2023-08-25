package com.example.BTL_INTERNET_GT.Repo;

import com.example.BTL_INTERNET_GT.Entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {
}
