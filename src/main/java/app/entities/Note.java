package app.entities;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(nullable = false)
    String text;
    @Column(nullable = false)
    LocalDate creationDate;
    @Column(nullable = false)
    String createdBy;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter
    private Person person;


    public Note(int id, String text, LocalDate creationDate, String createdBy, Person person) {
        Id = id;
        this.text = text;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.person = person;
    }

    @PrePersist
    void createDate (){
        this.creationDate = LocalDate.now();
    }
}
