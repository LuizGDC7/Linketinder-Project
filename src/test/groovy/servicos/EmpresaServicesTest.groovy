package servicos

import classes.Candidato
import classes.Empresa
import funcionalidades.Leitura.LeituraDeDadosInterface
import funcionalidades.Validacao.ValidarLeituraDeDadosInterface
import spock.lang.Specification

class EmpresaServicesTest extends Specification{
    def leitor = Mock(LeituraDeDadosInterface)
    def validador = Mock(ValidarLeituraDeDadosInterface)
    EmpresaServices empresaServices = new EmpresaServices()

    def "criarEmpresa() | Testando a criação de candidatos"(){
        given: "valores retornados pelo leitor e validador:"

        ArrayList<Empresa> empresasEsperadas = new ArrayList<>(
                [
                        new Empresa("Nestle", "Nestle@gmail.com", "Goiânia","Procuramos profissionais apaixonados por doces", "70000521", "12.345.678/0001-95", "Brasil", new ArrayList<String>(["Python", "Rust", "Java", "C++"].asList())),
                        new Empresa(
                                "Ford", "Ford@gmail.com", "Goiânia","Os melhores carros do mercado!", "74801-010", "22.355.878/0001-95", "Estados Unidos", new ArrayList<String>(["Python", "Java", "C++", "Groovy"].asList())
                        ),
                        new Empresa("BYD", "BYD@gmail.com", "Minas Gerais", "Preços imbatíveis em veículos elétricos", "78555-60", "33.355.698/0005-23", "China", ["C", "C++", "Rust"])
                ]
        )

        leitor.lerString() >>> [
                "Nestle", "Nestle@gmail.com", "Goiânia","Procuramos profissionais apaixonados por doces", "70000521", "12.345.678/0001-95", "Brasil", "Python, Rust, Java, C++",
                "Ford", "Ford@gmail.com", "Goiânia", "Os melhores carros do mercado!", "74801-010", "22.355.878/0001-95", "Estados Unidos", "Python, Java, C++, Groovy", "BYD", "BYD@gmail.com", "Minas Gerais", "Preços imbatíveis em veículos elétricos", "78555-60", "33.355.698/0005-23", "China", "C, C++, Rust"
        ]

        leitor.obterCompetencias(_) >>> [["Python", "Rust", "Java", "C++"], ["Python", "Java", "C++", "Groovy"], ["C", "C++", "Rust"]]

        when: "Cria os candidatos"

        ArrayList<Candidato> resultado = [
                empresaServices.criarEmpresa(leitor, validador),
                empresaServices.criarEmpresa(leitor, validador),
                empresaServices.criarEmpresa(leitor, validador)

        ]

        then: "Verifica se correspondem ao resultado esperado"
        resultado == empresasEsperadas

    }
}
