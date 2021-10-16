package com.revise.springboot.repositories;

import com.revise.springboot.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    @Query(value = "select count(bc.id) from card as c join book_card_join as bc on c.id = bc.card_id " +
            "where c.id = :cid and bc.active = true",
            nativeQuery = true)
    Integer numberOfBooksIssuedByCard(Integer cid);

    @Query(value = "update card set cost = :cost where id = :cid returning *", nativeQuery = true)
    Card updateCost(Integer cid, Integer cost);

    @Query(value = "select count(id) from book_card_join where bid = :bid and card_id = cid: and active = true")
    int numOfBookInstanceAlreadyBorrowedWithCard(Integer bid, Integer cid);

}
