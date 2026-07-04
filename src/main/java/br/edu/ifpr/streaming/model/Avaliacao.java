package br.edu.ifpr.streaming.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nota;
    private String comentario;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;
}
