package com.jpalearning.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Lecture extends BaseEntity{
   /* @Id
    @GeneratedValue
    private Integer id;*/
    private String name;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
    @OneToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
