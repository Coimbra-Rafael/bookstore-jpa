package com.bookstrore.jpa.models;

import com.bookstrore.jpa.models.base.EntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_review")
public class ReviewModel extends EntityBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String comment;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "book_id")
    private BookModel book;
}
