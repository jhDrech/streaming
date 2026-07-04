package br.edu.ifpr.streaming;

import br.edu.ifpr.streaming.model.*;
import br.edu.ifpr.streaming.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Teste implements CommandLineRunner {

    private final UsuarioRepository usuarioRepo;
    private final AssinaturaRepository assinaturaRepo;
    private final PerfilRepository perfilRepo;
    private final AvaliacaoRepository avaliacaoRepo;
    private final FilmeRepository filmeRepo;
    private final SerieRepository serieRepo;
    private final EpisodioRepository episodioRepo;
    private final CategoriaRepository categoriaRepo;

    public Teste(UsuarioRepository usuarioRepo, AssinaturaRepository assinaturaRepo,
                      PerfilRepository perfilRepo, AvaliacaoRepository avaliacaoRepo,
                      FilmeRepository filmeRepo, SerieRepository serieRepo,
                      EpisodioRepository episodioRepo, CategoriaRepository categoriaRepo) {
        this.usuarioRepo = usuarioRepo;
        this.assinaturaRepo = assinaturaRepo;
        this.perfilRepo = perfilRepo;
        this.avaliacaoRepo = avaliacaoRepo;
        this.filmeRepo = filmeRepo;
        this.serieRepo = serieRepo;
        this.episodioRepo = episodioRepo;
        this.categoriaRepo = categoriaRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Assinatura assinatura = new Assinatura();
        assinatura.setPlano("basico");
        assinaturaRepo.save(assinatura);

        Usuario joao = new Usuario();
        joao.setNome("Joao");
        joao.setEmail("jdrechmer@gmail.com");
        joao.setAssinatura(assinatura);
        usuarioRepo.save(joao);

        Usuario pedro = new Usuario();
        pedro.setNome("Pedro");
        pedro.setEmail("pedroLunkes@gmail.com");
        usuarioRepo.save(pedro);

        Perfil perfil1 = new Perfil();
        perfil1.setApelido("joao_principal");
        perfil1.setUsuario(joao);
        perfilRepo.save(perfil1);

        Perfil perfil2 = new Perfil();
        perfil2.setApelido("pedro_principal");
        perfil2.setUsuario(pedro);
        perfilRepo.save(perfil2);

        Categoria acao = new Categoria();
        acao.setNome("Acao");
        categoriaRepo.save(acao);

        Categoria comedia = new Categoria();
        comedia.setNome("Comedia");
        categoriaRepo.save(comedia);

        Filme filme = new Filme();
        filme.setTitulo("Missao Impossivel");
        filme.setCategorias(List.of(acao));
        filmeRepo.save(filme);

        Serie serie = new Serie();
        serie.setTitulo("The Office");
        serie.setCategorias(List.of(comedia));
        serieRepo.save(serie);

        Episodio ep1 = new Episodio();
        ep1.setTitulo("Episodio 1");
        ep1.setSerie(serie);
        episodioRepo.save(ep1);

        Episodio ep2 = new Episodio();
        ep2.setTitulo("Episodio 2");
        ep2.setSerie(serie);
        episodioRepo.save(ep2);

        Avaliacao av1 = new Avaliacao();
        av1.setNota(10);
        av1.setComentario("muito bom");
        av1.setPerfil(perfil1);
        avaliacaoRepo.save(av1);

        Avaliacao av2 = new Avaliacao();
        av2.setNota(8);
        av2.setComentario("gostei bastante");
        av2.setPerfil(perfil2);
        avaliacaoRepo.save(av2);

        System.out.println("dados inseridos");
    }
}