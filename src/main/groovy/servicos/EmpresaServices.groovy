package servicos

import classes.Candidato
import classes.Empresa
import funcionalidades.Leitura.LeituraDeDados
import funcionalidades.Leitura.LeituraDeDadosInterface
import funcionalidades.Validacao.ValidarLeituraDados
import funcionalidades.Validacao.ValidarLeituraDeDadosInterface

class EmpresaServices {

    Empresa criarEmpresa(LeituraDeDadosInterface leitor, ValidarLeituraDeDadosInterface validador) throws IllegalArgumentException{
        String[] valores = new String[7]// nome, email, estado, descricao, CEP, identificador
        String[] informacoes = ["Nome", "E-mail", "Estado","Descrição", "CEP", "CNPJ", "País", "Competências"]
        ArrayList<String> novasCompetencias = null

        for(int c = 0; c < informacoes.size(); c++){
            println("Insira ${informacoes[c]}:")
            if(c < 7){
                valores[c] = leitor.lerString()
            }
            if(c == 7){
                novasCompetencias = leitor.obterCompetencias(leitor.lerString())
            }
        }

        return new Empresa(valores[0],valores[1],valores[2],valores[3],valores[4],valores[5], valores[6], novasCompetencias)

    }

}
