package com.example.tienda.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "[a-zA-Z\\s]*", message = "Name cannot contain numbers or characters other than letters")
    @Column(name = "name", unique = true)
    private String name;

    private String description;

    private String imageUrl;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime creationDateTime;

    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    private boolean deleted = Boolean.FALSE;
}
