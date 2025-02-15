package funcionalidades

import classes.Candidato
import classes.Empresa

import java.lang.reflect.Array

class LeituraDeDados{
    static Scanner scanner = new Scanner(System.in)

    static <T> T lerDado(Class <T> tipoDado, String mensagem = "", String mensagemErro = "", Closure validadorDados){
        println mensagem
        while(true){
            try{
                String entrada = scanner.nextLine()
                def conversor = CAST_UNIVERSAL[tipoDado]
                if(conversor){
                    def val = conversor(entrada)
                    if(validadorDados(val)){
                        return val
                    }
                }else{
                    throw new IllegalArgumentException("Tipo não suportado ${tipoDado}")
                }
            }catch(NumberFormatException | IllegalArgumentException e) {
                println mensagemErro
            }
        }
    }

    static final Map<Class<?>, Closure<?>> CAST_UNIVERSAL = [
            (String): {String entrada -> entrada},
            (Integer): {String entrada -> Integer.parseInt(entrada)},
            (Double): {String entrada -> Double.parseDouble(entrada)},
            (Boolean): {String entrada -> Boolean.parseBoolean(entrada)}
    ]

    static Closure validador(String validacao = "default"){
        def mapa = [
                "InRange": {
                    x, y, valor -> return x <= valor && valor <= y
                },
                "default": {
                    x -> return true
                }
        ]

        return mapa[validacao]
    }

    static Candidato criarCandidato(){
        String[] valores = new String[6]// nome, email, estado, descricao, CEP, identificador
        String[] informacoes = ["Nome", "E-mail", "Descrição", "CEP", "CPF", "Idade"]
        int idade = -1
        ArrayList<String> novasCompetencias = null

        int escolhaOpcao

        while(true) {
            println "\nDigite o número do atributo que você deseja inserir:\n"
            println(
                            "0 - Nome\n" +
                            "1 - E-mail\n" +
                            "2 - Estado\n" +
                            "3 - Descrição\n" +
                            "4 - CEP\n" +
                            "5 - CPF\n" +
                            "6 - Idade\n" +
                            "7 - Criar competências\n" +
                            "8 - Estou satisfeito\n" +
                            "Insira opção: "
            )

            def validar = validador("InRange")
            escolhaOpcao = lerDado(Integer, "", "Insira um número entre 0 e 7", validar.curry(0, 8))

            switch (escolhaOpcao) {
                case 0..5: {
                    String valor = lerDado(String, "Insira o valor:", "", validador())
                    valores[escolhaOpcao] = valor
                }; break;
                case 6: {
                    def validar2 = validador("InRange")
                    idade = lerDado(Integer, "Insira idade", "Idade estranha, insira outra", validar2.curry(0, 130))
                }; break;
                case 7: novasCompetencias = obterCompetencias(); break;
                case 8: return new Candidato(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5], idade, novasCompetencias); break;

            }

            println("\nDados Inseridos:\n")
            for(int c = 0; c < 7; c++){
                if(c < 6){
                    println("${informacoes[c]}: ${valores[c] == null ? "" : valores[c]}")
                }else{
                    if(novasCompetencias != null){
                        String compet = ""
                        for(int d = 0; d < novasCompetencias.size(); d++){
                            compet += (d == 0 ? novasCompetencias.get(d) : ", ${novasCompetencias.get(d)}")
                        }
                        println("Competências: ${compet}")
                    }else{
                        println("Competências:")

                    }
                    println("Idade: ${idade == -1 ? "" : idade}")
                }
            }

        }

        return null
    }

    static Empresa criarEmpresa(){
        String[] valores = new String[7]// nome, email, estado, descricao, CEP, identificador, País
        String[] informacoes = ["Nome", "E-mail", "Estado", "Descrição", "CEP", "CNPJ", "País"]
        ArrayList<String> novasCompetencias = null

        int escolhaOpcao

        while(true){
            println "\nDigite o número do atributo que você deseja inserir:\n"
            println(
                            "0 - Nome\n" +
                            "1 - E-mail\n" +
                            "2 - Estado\n" +
                            "3 - Descrição\n" +
                            "4 - CEP\n" +
                            "5 - CNPJ\n" +
                            "6 - País\n" +
                            "7 - Criar novas competências\n" +
                            "8 - Estou satisfeito\n" +
                            "Insira opção: "
            )

            def validar = validador("InRange")
            escolhaOpcao = lerDado(Integer, "", "Insira um número entre 0 e 7", validar.curry(0, 8))
            switch(escolhaOpcao){
                case 0..6: {
                    String valor = lerDado(String, "Insira o valor:", "", validador())
                    valores[escolhaOpcao] = valor
                }; break;
                case 7: novasCompetencias = obterCompetencias(); break;
                case 8: {
                    return new Empresa(valores[0],valores[1], valores[2],valores[3],valores[4], valores[5], valores[6], novasCompetencias)
                }; break;

            }

            println("Valores inseridos até agora:\n")
            for(int c = 0; c < 7; c++){
                println("${informacoes[c]}: ${valores[c] == null ? "" : valores[c]}")
            }
            if(novasCompetencias != null){
                String compet = ""
                for(int d = 0; d < novasCompetencias.size(); d++){
                    compet += (d == 0 ? novasCompetencias.get(d) : ", ${novasCompetencias.get(d)}")
                }
                println("Competências: ${compet}")
            }else{
                println("Competências:")
            }

            println("\n")

        }
        return null
    }

    static ArrayList<String> obterCompetencias(){
        ArrayList<String> competencias = new ArrayList<>()
        int escolha = 2
        def validar = validador("InRange")
        while(escolha != 0){
            println(
                    "\n0 - Finalizar\n" +
                    "1 - Adicionar nova competência\n"
            )
            escolha = lerDado(Integer, "", "Insira 0 ou 1", validar.curry(0, 1))
            if(escolha == 1){
                println("Insira nova competência")
                String novaCompetencia = scanner.nextLine()
                competencias.add(novaCompetencia)
            }
        }
    return competencias
    }

}
