package demo.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@MappedSuperclass
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
