package dev.jtm.ranking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = @Index(name = "idx_",columnList = "note"))
public class Rank {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY )
    private Long id;
    private Double note;
    private String firstname;
    private String lastname;
}
