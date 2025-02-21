package funcionalidades.Menu


import classes.Candidato
import classes.Empresa
import funcionalidades.Leitura.LeituraDeDados
import funcionalidades.Leitura.LeituraDeDadosInterface
import funcionalidades.Validacao.ValidarLeituraDados
import funcionalidades.Validacao.ValidarLeituraDeDadosInterface
import servicos.CandidatoServices
import servicos.EmpresaServices

class Menu {

    LeituraDeDadosInterface leitor
    ValidarLeituraDeDadosInterface validador
    CandidatoServices candidatoServices
    EmpresaServices empresaServices

    Menu(){
        leitor = new LeituraDeDados()
        validador = new ValidarLeituraDados()
        candidatoServices = new CandidatoServices()
        empresaServices = new EmpresaServices()
    }

    int obterOpcao(LeituraDeDadosInterface leitor, ValidarLeituraDeDadosInterface validador) throws IllegalArgumentException{
        try{
            String leitura = leitor.lerString()
            int opcaoSelecionada = leitor.lerNumeroEntreIntervalo(leitura, validador, 0, 4)
            return opcaoSelecionada
        }catch(IllegalArgumentException e){
            throw e
        }
    }

    void executarOpcao(int escolha, List<Candidato> candidatos, List<Empresa> empresas) throws IllegalArgumentException{
        switch(escolha){
            case 1: Candidato.mostrarCandidatos(candidatos).forEach {it -> println(it)}; break;
            case 2: Empresa.mostrarEmpresas(empresas).forEach {it -> println(it)}; break;
            case 3: {
                try{
                    Candidato novoCandidato
                    novoCandidato = candidatoServices.criarCandidato(leitor, validador)
                    candidatos.add(novoCandidato)
                }catch (IllegalArgumentException e){
                    println("Insira as informações corretamente!")
                }
            }; break;
            case 4: {
                try{
                    Empresa novaEmpresa
                    novaEmpresa = empresaServices.criarEmpresa(leitor, validador)
                    empresas.add(novaEmpresa)
                }catch (IllegalArgumentException e){
                    println("Insira as informações corretamente")
                }
            }
        }
    }

}
