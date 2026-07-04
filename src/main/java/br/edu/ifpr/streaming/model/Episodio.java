package br.edu.ifpr.streaming.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "serie_id")
    private Serie serie;
}
