package com.revise.springboot.repositories;

import com.revise.springboot.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "select * from author where id = :id", nativeQuery = true)
    Author getAuthor(Integer id);

}
