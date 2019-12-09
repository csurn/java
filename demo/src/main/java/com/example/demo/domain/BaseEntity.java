package com.example.demo.domain;

import lombok.Data;
import org.hibernate.annotations.RowId;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    @GeneratedValue
    @Version
    private int rowVersion;

    public BaseEntity() {
        this.id = UUID.randomUUID().toString();
    }
}
