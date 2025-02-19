package classes


import spock.lang.Specification

class CandidatoTest extends Specification{

    def "testeListagemCandidatos" () {

        given: "Uma lista de candidatos"

        ArrayList<Candidato> lista = new ArrayList<>()
        lista.addAll([
                new Candidato("Luiz", "luiz@gmail.com", "Goiânia/GO", "Desenvolvedor Full Stack com 5 anos de experiência", "01010-000", "123.456.789-01", 29, new ArrayList<String>(["Python", "Java", "C++"])),
                new Candidato("Mariana Oliveira", "mariana.oliveira@email.com","Rio de Janeiro", "Designer UX/UI apaixonada por criar experiências únicas","22040-001","234.567.890-12",26, new ArrayList<String>(["Python", "Groovy", "Deployment"]))
        ])

        ArrayList<String> resultadoEsperado = [
                        "Nome: Luiz" + '\n' +
                        "E-mail: luiz@gmail.com" + '\n' +
                        "Estado: Goiânia/GO" + '\n' +
                        "Descrição: Desenvolvedor Full Stack com 5 anos de experiência" + '\n' +
                        "CEP: 01010-000" + '\n'+
                        "Idade: 29" + "\n" +
                        "CPF: 123.456.789-01" + '\n' +
                        "Competências: Python, Java, C++\n",

                        "Nome: Mariana Oliveira" + '\n' +
                        "E-mail: mariana.oliveira@email.com" + '\n' +
                        "Estado: Rio de Janeiro" + '\n' +
                        "Descrição: Designer UX/UI apaixonada por criar experiências únicas" + '\n' +
                        "CEP: 22040-001" + '\n'+
                        "Idade: 26" + "\n" +
                        "CPF: 234.567.890-12" + '\n' +
                        "Competências: Python, Groovy, Deployment\n"
        ]

        when: "Listo os candidatos"

        ArrayList<String> resultado = Candidato.mostrarCandidatos(lista)

        then: "Listagem correta deve ser:"

        resultadoEsperado == resultado

    }

}
