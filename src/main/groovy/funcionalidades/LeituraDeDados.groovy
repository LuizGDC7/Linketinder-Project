package funcionalidades

import classes.Candidato
import classes.Empresa

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
                            "7 - Estou satisfeito\n" +
                            "Insira opção: "
            )

            def validar = validador("InRange")
            escolhaOpcao = lerDado(Integer, "", "Insira um número entre 0 e 7", validar.curry(0, 7))

            switch (escolhaOpcao) {
                case 0..5: {
                    String valor = lerDado(String, "Insira o valor:", "", validador())
                    valores[escolhaOpcao] = valor
                }; break;
                case 6: {
                    def validar2 = validador("InRange")
                    idade = lerDado(Integer, "Insira idade", "Idade estranha, insira outra", validar2.curry(0, 130))
                }; break;
                case 7: {
                    return new Candidato(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5], idade)
                }

            }

            println("\nDados Inseridos:\n")
            for(int c = 0; c < 7; c++){
                if(c < 6){
                    println("${informacoes[c]}: ${valores[c] == null ? "" : valores[c]}")
                }else{
                    println("Idade: ${idade == -1 ? "" : idade}")
                }
            }

        }

        return null
    }

    static Empresa criarEmpresa(){
        String[] valores = new String[7]// nome, email, estado, descricao, CEP, identificador, País
        String[] informacoes = ["Nome", "E-mail", "Estado", "Descrição", "CEP", "CNPJ", "País"]


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
                            "7 - Estou satisfeito\n" +
                            "Insira opção: "
            )

            def validar = validador("InRange")
            escolhaOpcao = lerDado(Integer, "", "Insira um número entre 0 e 7", validar.curry(0, 7))
            switch(escolhaOpcao){
                case 0..6: {
                    String valor = lerDado(String, "Insira o valor:", "", validador())
                    valores[escolhaOpcao] = valor
                }; break;
                case 7: {
                    return new Empresa(valores[0],valores[1], valores[2],valores[3],valores[4], valores[5], valores[6])
                }; break;
            }

            println("Valores inseridos até agora:\n")
            for(int c = 0; c < 7; c++){
                println("${informacoes[c]}: ${valores[c] == null ? "" : valores[c]}")
            }

            println("\n")

        }
        return null
    }

}
