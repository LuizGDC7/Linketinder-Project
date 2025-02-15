package funcionalidades

import classes.PessoaGenerica
import classes.Candidato
import classes.Empresa

class Menu {

    Menu(){

    }

    void opcoes(){
        println(
"""
Insira uma opção:

0 - Sair
1 - Mostrar Candidatos
2 - Mostrar Empresas
3 - Cadastrar Candidato
4 - Cadastrar Empresa
"""
        )
    }

    int obterOpcao(){
        opcoes()
        Closure validacao = LeituraDeDados.validador("InRange")
        int opcaoSelecionada = LeituraDeDados.lerDado(Integer, "", "Insira um valor numérico", validacao.curry(0, 4))
        return opcaoSelecionada
    }

    void executarOpcao(int escolha, List<Candidato> candidatos, List<Empresa> empresas){
        switch(escolha){
            case 1: Candidato.mostrarCandidatos(candidatos); break;
            case 2: Empresa.mostrarEmpresas(empresas); break;
            case 3: {
                Candidato novoCandidato = LeituraDeDados.criarCandidato()
                candidatos.add(novoCandidato)
            }; break;
            case 4: {
                Empresa novaEmpresa = LeituraDeDados.criarEmpresa()
                empresas.add(novaEmpresa)
            }
        }
    }




}
