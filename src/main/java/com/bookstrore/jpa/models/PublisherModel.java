package com.bookstrore.jpa.models;

import com.bookstrore.jpa.models.base.EntityBase;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_publisher")
public class PublisherModel extends EntityBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private Set<BookModel> books = new HashSet<>();

}
