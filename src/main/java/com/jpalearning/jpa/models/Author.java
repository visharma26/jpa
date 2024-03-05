package com.jpalearning.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Entity
//@Table(name = "AUTHOR_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NamedQuery(
        name = "Author.findByNamedQuery",
        query = "select a from Author a where a.age >= :age"
)
@NamedQuery(
        name = "Author.updateByNamedQuery",
        query = "update Author a set a.age = :age where a.id = : id"
)
public class Author extends BaseEntity{
   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    /*@GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "author_id_gen"
    )
    @TableGenerator(
            name = "author_id_gen",
            table = "id_generator",
            pkColumnName = "id_name",
            pkColumnValue = "id_value",
            allocationSize = 1
    )*/
   /* @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_sequence"
    )*/
    /*@SequenceGenerator(
            name = "author_sequence",
            allocationSize = 1
    )*/
//    private Integer id;
    @Column(
            name = "f_name",
            length = 35
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    private String email;
    private int age;
    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;
    /*@Column(
            updatable = false,
            nullable = false
    )
    private LocalDateTime createdAt;
    @Column(
            insertable = false
    )
    private LocalDateTime lastModified;*/
}
