package funcionalidades.Validacao

class ValidarLeituraDados implements ValidarLeituraDeDadosInterface{

    ValidarLeituraDados(){

    }

    @Override
    boolean Inteiro_EntreIntervalo(int limiteInferior, int limiteSuperior, int valor){
        return limiteInferior <= valor && valor <= limiteSuperior
    }

}

interface ValidarLeituraDeDadosInterface{
    boolean Inteiro_EntreIntervalo(int limiteInferior, int limiteSuperior, int valor);
}