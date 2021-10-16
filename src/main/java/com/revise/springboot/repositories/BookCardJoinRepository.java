package com.revise.springboot.repositories;

import com.revise.springboot.models.BookCardJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCardJoinRepository extends JpaRepository<BookCardJoin, Integer> {
}
