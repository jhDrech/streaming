package br.edu.ifpr.streaming.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    @OneToOne
    @JoinColumn(name = "assinatura_id")
    private Assinatura assinatura;

    @OneToMany(mappedBy = "usuario")
    private List<Perfil> perfis;
}
