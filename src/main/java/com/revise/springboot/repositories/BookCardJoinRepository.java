package com.revise.springboot.repositories;

import com.revise.springboot.models.BookCardJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCardJoinRepository extends JpaRepository<BookCardJoin, Integer> {

    @Query(value = "update book_card_join set active = false where book_id = :bid and card_id = :cid returning *",
            nativeQuery = true)
    public BookCardJoin returnBook(int bid, int cid);

}
