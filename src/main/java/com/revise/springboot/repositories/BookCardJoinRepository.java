package com.revise.springboot.repositories;

import com.revise.springboot.models.BookCardJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCardJoinRepository extends JpaRepository<BookCardJoin, Integer> {

    @Query(value = "update book_card_join set active = false " +
            "where book_id = :bid and card_id = :cid and active = true returning *",
            nativeQuery = true)
    BookCardJoin returnBook(int bid, int cid);

    @Query(value = "select count(id) from book_card_join where book_id = :bid and card_id = :cid and active = true",
            nativeQuery = true)
    Integer numOfBookInstanceAlreadyBorrowedWithCard(Integer bid, Integer cid);

}
