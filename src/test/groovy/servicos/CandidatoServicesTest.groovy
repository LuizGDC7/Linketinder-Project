package servicos

import classes.Candidato
import funcionalidades.Leitura.LeituraDeDados
import funcionalidades.Leitura.LeituraDeDadosInterface
import funcionalidades.Validacao.ValidarLeituraDados
import funcionalidades.Validacao.ValidarLeituraDeDadosInterface
import spock.lang.Specification

class CandidatoServicesTest extends Specification {

    def leitor = Mock(LeituraDeDadosInterface)
    def validador = Mock(ValidarLeituraDeDadosInterface)
    CandidatoServices candidatoServices = new CandidatoServices()

    def "criarCandidato | Testando a criação de candidatos"(){
        given: "valores retornados pelo leitor e validador:"

        ArrayList<Candidato> candidatosEsperados = new ArrayList<>(
                [
                        new Candidato("Matheus", "Matheus@gmail.com", "Goiânia","Apaixonado por Programação Competitiva", "70000521", "999.888.666-55", 23, new ArrayList<String>(["Python", "Rust", "Java", "C++"].asList())),
                        new Candidato(
                                "Luiz", "Luiz@gmail.com", "Goiânia","Amo o universo web backend", "74801-010", "111.222.333-44", 21, new ArrayList<String>(["Python", "Java", "C++", "Groovy"].asList())
                        ),
                        new Candidato("Mariana", "Mariana@gmail.com", "São Paulo", "Trabalho com Sistemas embarcados", "78555-60", "000.999.555-45", 30, ["C", "C++", "Rust"])
                ]
        )

        leitor.lerString() >>> [
                "Matheus", "Matheus@gmail.com", "Goiânia","Apaixonado por Programação Competitiva", "70000521", "999.888.666-55", "23", "Python, Rust, Java, C++",
                "Luiz", "Luiz@gmail.com", "Goiânia", "Amo o universo web backend", "74801-010", "111.222.333-44", "21", "Python, Java, C++, Groovy", "Mariana", "Mariana@gmail.com", "São Paulo", "Trabalho com Sistemas embarcados", "78555-60", "000.999.555-45", "30", "C, C++, Rust"
        ]
        validador.Inteiro_EntreIntervalo(0, 130, 23) >> true
        validador.Inteiro_EntreIntervalo(0, 130, 21) >> true
        validador.Inteiro_EntreIntervalo(0, 130, 30) >> true

        leitor.obterCompetencias(_) >>> [["Python", "Rust", "Java", "C++"], ["Python", "Java", "C++", "Groovy"], ["C", "C++", "Rust"]]
        leitor.lerAteConseguirInteiro(_) >> [23, 21, 30]

        leitor.lerNumeroEntreIntervalo("23", validador, 0, 130) >> 23
        leitor.lerNumeroEntreIntervalo("21", validador, 0, 130) >> 21
        leitor.lerNumeroEntreIntervalo("30", validador, 0, 130) >> 30


        when: "Cria os candidatos"

        ArrayList<Candidato> resultado = [
            candidatoServices.criarCandidato(leitor, validador),
            candidatoServices.criarCandidato(leitor, validador),
            candidatoServices.criarCandidato(leitor, validador)

        ]

        then: "Verifica se correspondem ao resultado esperado"
            resultado == candidatosEsperados

    }
}
