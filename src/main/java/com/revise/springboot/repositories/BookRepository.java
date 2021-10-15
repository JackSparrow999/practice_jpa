package com.revise.springboot.repositories;

import com.revise.springboot.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book where genre = :genre", nativeQuery = true)
    List<Book> getBooksByGenres(String genre);

    @Query(value = "update book set summary_id = :sid where id = :bid returning *", nativeQuery = true)
    Book mapSummaryToBook(Integer bid, Integer sid);

}
