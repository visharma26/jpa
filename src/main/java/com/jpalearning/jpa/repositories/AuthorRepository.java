package com.jpalearning.jpa.repositories;

import com.jpalearning.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> , JpaSpecificationExecutor<Author> {

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age, @Param("id") int id);
    List<Author> findByNamedQuery(@Param("age") int age);

    //update Author a set a.age = 22 where a.id = 1
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);


    //select * from author where first_name = 'vineet'
    List<Author> findAllByFirstName(String fn);
    //select * from author where first_name = 'vineet'
    List<Author> findAllByFirstNameIgnoreCase(String fn);
    //select * from author where first_name like '%vineet%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);
    //select * from author where first_name like 'vineet%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    //select * from author where first_name like '%vineet'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    //select * from author where first_name in ('vineet', 'ashu')
    List<Author> findAllByFirstNameInIgnoreCase(List<String> fn);

}
