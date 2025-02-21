package View

import classes.Candidato
import classes.Empresa
import funcionalidades.Leitura.LeituraDeDados
import funcionalidades.Leitura.LeituraDeDadosInterface
import funcionalidades.Menu.Menu
import funcionalidades.Validacao.ValidarLeituraDados
import funcionalidades.Validacao.ValidarLeituraDeDadosInterface

class MenuView {

    Menu menu
    LeituraDeDadosInterface leitor
    ValidarLeituraDeDadosInterface validador
    int quantidadeOpcoes
    ArrayList<Candidato> candidatos
    ArrayList<Empresa> empresas

    MenuView(Menu menu, LeituraDeDados leitor, ValidarLeituraDados validador, int quantidadeOpcoes, ArrayList<Candidato> candidatos, ArrayList<Empresa> empresas){
        this.menu = menu
        this.leitor = leitor
        this.validador = validador
        this.quantidadeOpcoes = quantidadeOpcoes
        this.candidatos = candidatos
        this.empresas = empresas
    }

    ArrayList<String> opcoesMenu(){
        ArrayList<String> opcoes = [
                "0 - Sair", "1 - Mostrar Candidatos", "2 - Mostrar Empresa", "3 - Cadastrar candidato", "4 - Cadastrar Empresa"
        ]
        return opcoes
    }

    void mostrarOpcoesMenu(){
        opcoesMenu().forEach {
            it -> println(it)
        }
    }

    int obterOpcaoMenu(){
        while(true){
            mostrarOpcoesMenu()
            int escolha
            String leitura = leitor.lerString()
            try{
                escolha = leitor.lerNumeroEntreIntervalo(leitura, validador, 0, quantidadeOpcoes)
                return escolha
            }catch (IllegalArgumentException e){
                println "Insira um número entre 0 e ${quantidadeOpcoes}"
            }
        }
    }

    void interagirComOUsuario(){
        while(true){
            int escolha = obterOpcaoMenu()
            if(escolha == 0){
                break;
            }
            menu.executarOpcao(escolha, candidatos, empresas)
        }
    }
}
