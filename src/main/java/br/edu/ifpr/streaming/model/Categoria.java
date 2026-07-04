package br.edu.ifpr.streaming.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
}
