package com.revise.springboot.repositories;

import com.revise.springboot.models.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {

    //my first custom query(native query)
    @Query(value = "select * from summary", nativeQuery = true)
    List<Summary> getAllSummaries();

}
