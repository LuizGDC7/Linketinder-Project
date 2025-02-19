package funcionalidades.Leitura
import funcionalidades.Validacao.ValidarLeituraDeDadosInterface

class LeituraDeDados implements LeituraDeDadosInterface{
    static Scanner scanner

    LeituraDeDados(){
        scanner = new Scanner(System.in)
    }

    @Override
    String lerString(){
        return scanner.nextLine()
    }

    @Override
    Integer lerInteger(String valor) throws NumberFormatException{
        return Integer.parseInt(valor)
    }

    @Override
    Integer lerAteConseguirInteiro(String string) throws IllegalArgumentException{

        ArrayList<String> valores = string.split(" ")

        for (String valor in valores){
            try{
                int valorCandidato = lerInteger(valor)
                return valorCandidato
            }catch(NumberFormatException){

            }
        }

        throw new IllegalArgumentException("Not found any suitable value")

    }

    @Override
    Integer lerNumeroEntreIntervalo(String string, ValidarLeituraDeDadosInterface validador, int limiteInferior, int limiteSuperior) throws IllegalArgumentException{

        int valor
        try{
            valor = lerAteConseguirInteiro(string)
        }catch(IllegalArgumentException e){
            throw e
        }

        if(validador.Inteiro_EntreIntervalo(limiteInferior, limiteSuperior, valor)){
            return valor
        }else{
            throw new IllegalArgumentException("Value not in range")
        }

    }

    @Override
    ArrayList<String> obterCompetencias(String leitura){
        ArrayList<String> competencias = new ArrayList<>()
        String regex = "[,]"
        competencias.addAll(leitura.split(regex))
        competencias = competencias.collect{string -> string.strip()}
        return competencias
    }

}

interface LeituraDeDadosInterface {
    String lerString();

    Integer lerInteger(String valor) throws NumberFormatException;

    Integer lerAteConseguirInteiro(String string) throws IllegalArgumentException;

    Integer lerNumeroEntreIntervalo(String string, ValidarLeituraDeDadosInterface validador, int limiteInferior, int limiteSuperior) throws IllegalArgumentException;

    ArrayList<String> obterCompetencias(String leitura);
}