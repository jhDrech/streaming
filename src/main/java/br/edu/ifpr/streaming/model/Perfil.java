package br.edu.ifpr.streaming.model;

import java.util.ArrayList;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String apelido;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(mappedBy = "perfil")
    private ArrayList<Avaliacao> avaliacoes;
}
