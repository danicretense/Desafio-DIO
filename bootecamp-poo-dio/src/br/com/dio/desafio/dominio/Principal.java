package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
         // Criando os conteúdos
        Curso cursoJava = new Curso("Curso Java", "Descrição curso Java", 8);
        Curso cursoJs = new Curso("Curso JavaScript", "Descrição curso JavaScript", 4);
        Mentoria mentoriaPOO = new Mentoria("Mentoria de POO", "Mentoria sobre POO", LocalDate.now());

        // Criando o Bootcamp e adicionando os conteúdos
        BootCamp bootcamp = new BootCamp("Bootcamp Java Developer", "Bootcamp completo para se tornar um desenvolvedor Java");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoJs);
        bootcamp.getConteudos().add(mentoriaPOO);

        // Criando os desenvolvedores
        Dev devJoao = new Dev("João");
        Dev devMaria = new Dev("Maria");
        Dev devPedro = new Dev("Pedro");

        // Inscrevendo os desenvolvedores no bootcamp
        devJoao.inscreverBootcamp(bootcamp);
        devMaria.inscreverBootcamp(bootcamp);
        devPedro.inscreverBootcamp(bootcamp);
        
        System.out.println(bootcamp);
        System.out.println("----------------------------------------\n");

        // Simulando a progressão
        devJoao.progredir();
        devJoao.progredir();
        System.out.println("João progrediu 2x.");
        
        devMaria.progredir();
        devMaria.progredir();
        devMaria.progredir();
        System.out.println("Maria progrediu 3x.");
        
        devPedro.progredir();
        System.out.println("Pedro progrediu 1x.");
        
        System.out.println("----------------------------------------");
        System.out.println("Status de João -> Concluiu o Bootcamp: " + devJoao.verificarConclusao(bootcamp));
        System.out.println("Status de Maria -> Concluiu o Bootcamp: " + devMaria.verificarConclusao(bootcamp));
        System.out.println("Status de Pedro -> Concluiu o Bootcamp: " + devPedro.verificarConclusao(bootcamp));
        System.out.println("----------------------------------------\n");

        // NOVIDADE: Ordenando os devs por XP
        List<Dev> devsOrdenados = new ArrayList<>(bootcamp.getDevsInscritos());
        
        // Usando uma classe anônima para implementar o Comparator
        devsOrdenados.sort(new Comparator<Dev>() {
            @Override
            public int compare(Dev d1, Dev d2) {
                return Double.compare(d2.calcularTotalXp(), d1.calcularTotalXp()); // Ordem decrescente
            }
        });
        
        System.out.println("--- Ranking de Desenvolvedores por XP ---");
        for (int i = 0; i < devsOrdenados.size(); i++) {
            System.out.println((i + 1) + ". " + devsOrdenados.get(i));
        }
        System.out.println("----------------------------------------");
    }

}
