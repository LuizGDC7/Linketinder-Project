package servicos

import classes.Candidato
import funcionalidades.Leitura.LeituraDeDados
import funcionalidades.Leitura.LeituraDeDadosInterface
import funcionalidades.Validacao.ValidarLeituraDados
import funcionalidades.Validacao.ValidarLeituraDeDadosInterface

class CandidatoServices {

    CandidatoServices(){

    }

    Candidato criarCandidato(LeituraDeDadosInterface leitor, ValidarLeituraDeDadosInterface validador) throws IllegalArgumentException{
        String[] valores = new String[6]// nome, email, estado, descricao, CEP, identificador
        String[] informacoes = ["Nome", "E-mail", "Estado", "Descrição", "CEP", "CPF", "Idade", "Competências"]
        int idade = -1
        ArrayList<String> novasCompetencias = null

        for(int c = 0; c < informacoes.size(); c++){
            println("Insira ${informacoes[c]}:")
            if(c < 6){
                valores[c] = leitor.lerString()
            }
            if(c == 6){
                try{
                    idade = leitor.lerNumeroEntreIntervalo(leitor.lerString(), validador, 0, 130)
                }catch(IllegalArgumentException e){
                    throw  e
                }
            }
            if(c == 7){
                novasCompetencias = leitor.obterCompetencias(leitor.lerString())
            }
        }

        return new Candidato(valores[0],valores[1],valores[2],valores[3],valores[4],valores[5],idade, novasCompetencias)

    }

}
