package funcionalidades.Leitura

import funcionalidades.Validacao.ValidarLeituraDeDadosInterface
import spock.lang.Specification

class LeituraDeDadosTest extends Specification{

    LeituraDeDados leitor

    def setup(){
        leitor = new LeituraDeDados()
    }

    def "lerInteger | Testando leitura de inteiros"(){

        given: "Instância da classe"

        expect: "Lê e verifica os valores"
        leitor.lerInteger(x) == valorEsperado

        where: "Executo para várias Strings"
        x      | valorEsperado
        "0"    | 0
        "155"  | 155
        "-5"   | -5
        "-100" | -100
        "0125" | 125

    }

    def "lerInteger | Testando erros"(){
        given: "Uma instância da classe"

        when: "Tento ler um inteiro"
            leitor.lerInteger(x)

        then: "Verifica se a exceção correta é lançada"
        thrown(resultadoEsperado)

        where: "Executo para várias Strings"
        x | resultadoEsperado
        "5.0"        | NumberFormatException
        "Valor"      | NumberFormatException
        "*5 mais"    | NumberFormatException
        "mais cinco" | NumberFormatException
        " \10 "      | NumberFormatException
        "\n5"        | NumberFormatException
    }

    def "lerAteConseguirInteiro | Testando leitura de candidatos"(){
        given: "Instancia da classe"

        expect: "Tento ler um inteiro numa string"
        leitor.lerAteConseguirInteiro(x) == valorEsperado

        where:
        x                              | valorEsperado
        "10"                           | 10
        "5*12 = 60"                    | 60
        "-25AlfaCentauri 950B 10 Beta" | 10
        "-125"                         | -125
    }

    def "lerAteConseguirInteiro | Testando erros"(){
        given: "Instancia da classe"

        when: "Tento ler um inteiro"
        leitor.lerAteConseguirInteiro(x)

        then: "Tento ler um inteiro numa string"
        thrown(valorEsperado)

        where:
        x                                | valorEsperado
        "-\10"                           | IllegalArgumentException
        "5*12 = 60i"                     | IllegalArgumentException
        "-25AlfaCentauri 950B 10f Beta"  | IllegalArgumentException
        "-f125"                          | IllegalArgumentException
    }

    def "lerNumeroEntreIntervalo | Testando valores"(){
        given: "Instância da classe"
        def validadorMock = Mock(ValidarLeituraDeDadosInterface)
        validadorMock.Inteiro_EntreIntervalo(1, 3, 1) >> true
        validadorMock.Inteiro_EntreIntervalo(2, 2, 2) >> true
        validadorMock.Inteiro_EntreIntervalo(5, 10, 5) >> true

        expect: "Leio e comparo valores"
        leitor.lerNumeroEntreIntervalo(x, validadorMock, limiteInferior, limiteSuperior) == valorEsperado

        where: "Lista de valores"
        x | limiteInferior | limiteSuperior || valorEsperado
        "1"   | 1  | 3 || 1
        "2"   | 2  | 2 || 2
        "5"   | 5 | 10 || 5
    }

    def "lerNumeroEntreIntervalo | Testando erros"(){
        given: "Instância da classe"
        def validadorMock = Mock(ValidarLeituraDeDadosInterface)
        validadorMock.Inteiro_EntreIntervalo(1, 3, 0) >> false
        validadorMock.Inteiro_EntreIntervalo(2, 2, 2) >> true
        validadorMock.Inteiro_EntreIntervalo(5, 10, 5) >> true

        when: "Leio os valores"
        leitor.lerNumeroEntreIntervalo(x, validadorMock, limiteInferior, limiteSuperior)

        then: "Comparo os valores"

        thrown(valorEsperado)

        where: "Lista de valores"
        x                   | limiteInferior | limiteSuperior   || valorEsperado
        "0"                 | 1              | 3                || IllegalArgumentException
        "Palavra cruzada"   | 2              | 2                || IllegalArgumentException
        "a b c 0"           | 5              | 10               || IllegalArgumentException
    }

    def "obterCompetencias | teste da leitura de competências"(){

        given: "Instância da classe"

        expect: "Leio e comparo valores"
        leitor.obterCompetencias(x) == valorEsperado

        where: "Lista de valores"

        x                                         | valorEsperado
        "Python, Java, C++"                       | ["Python", "Java", "C++"]
        "Programação Competitiva, MySQL, , Scrum" | ["Programação Competitiva", "MySQL", "", "Scrum"]

    }

}
