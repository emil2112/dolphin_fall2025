package app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String note;
    private LocalDateTime created;
    private String createdBy;

    @PrePersist
    private void onCreate(){
        created = LocalDateTime.now();
    }

    @ManyToOne
    @ToString.Exclude
    private Person person;

}

