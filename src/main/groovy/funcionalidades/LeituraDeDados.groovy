package funcionalidades

import classes.Candidato
import classes.Empresa

class LeituraDeDados{
    Scanner scanner

    LeituraDeDados(){
        this.scanner = new Scanner(System.in)
    }

    <T> T lerDado(Class <T> tipoDado, String mensagem = "", String mensagemErro = "", Closure validador){
        println mensagem
        println tipoDado
        while(true){
            try{
                String entrada = scanner.nextLine()
                def conversor = CONVERSORES[tipoDado]
                if(conversor){
                    def val = conversor(entrada)
                    if(validador(val)){
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

    public static final Map<Class<?>, Closure<?>> CONVERSORES = [
            (String): {String entrada -> entrada},
            (Integer): {String entrada -> Integer.parseInt(entrada)},
            (Double): {String entrada -> Double.parseDouble(entrada)},
            (Boolean): {String entrada -> Boolean.parseBoolean(entrada)}
    ]

    Closure validar(String validacao = "default"){
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

        println "Digite o número do atributo que você deseja inserir:"

        int escolhaOpcao

        while(true) {
            println(
                    "0 - Nome\n" +
                            "1 - E-mail\n" +
                            "2 - Estado\n" +
                            "3 - Descrição\n" +
                            "4 - CEP" +
                            "5 - CPF\n" +
                            "6 - Idade\n" +
                            "7 - Estou satisfeito\n" +
                            "Insira opção: "
            )

            def validar = CONVERSORES["InRange"]
            escolhaOpcao = lerDado(Integer, "", "Insira um número entre 0 e 7", validar.curry(0, 7))

            switch (escolhaOpcao) {
                case 0..5: {
                    String valor = lerDado(String, "Insira o valor:", "", CONVERSORES["default"])
                    valores[escolhaOpcao] = valor
                }; break;
                case 6: {
                    def validar2 = CONVERSORES["InRange"]
                    idade = lerDado(Integer, "Insira idade", "Idade estranha, insira outra", validar2.curry(0, 130))
                }; break;
                case 7: {
                    return new Candidato(valores[0], valores[1], valores[2], valores[3], valores[4], valores[5], idade)
                }

            }

            println("\nDados Inseridos:\n")
            for(int c = 0; c < 7; c++){
                if(c < 6){
                    println("${informacoes[c]}: ${valores[c]}")
                }else{
                    println("Idade: ${idade}")
                }
            }

        }

        return null
    }

    static Empresa criarEmpresa(){
        String[] valores = new String[7]// nome, email, estado, descricao, CEP, identificador
        String[] informacoes = ["Nome", "E-mail", "Descrição", "CEP", "CNPJ", "País"]

        println "Digite o número do atributo que você deseja inserir:"

        int escolhaOpcao

        while(true){
            println(
                            "0 - Nome\n" +
                            "1 - E-mail\n" +
                            "2 - Estado\n" +
                            "3 - Descrição\n" +
                            "4 - CEP" +
                            "5 - CNPJ\n" +
                            "6 - País\n" +
                            "7 - Estou satisfeito\n" +
                            "Insira opção: "
            )

            def validar = CONVERSORES["InRange"]
            escolhaOpcao = lerDado(Integer, "", "Insira um número entre 0 e 7", validar.curry(0, 7))
            switch(escolhaOpcao){
                case 0..6: {
                    String valor = lerDado(String, "Insira o valor:", "", CONVERSORES["default"])
                    valores[escolhaOpcao] = valor
                }; break;
                case 7: {
                    return new Empresa(valores[0],valores[1], valores[2],valores[3],valores[4], valores[5], valores[6])
                }; break;
            }

            println("Valores inseridos até agora:\n")
            for(int c = 0; c < 7; c++){
                println("${informacoes[c]}: ${valores[c]}")
            }

        }
        return null
    }

}
