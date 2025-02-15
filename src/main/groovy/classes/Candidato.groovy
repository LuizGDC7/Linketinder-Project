package classes

class Candidato extends PessoaGenerica{
    int idade
    Candidato(String nome, String email, String estado, String descricao, String CEP, String identificador, int idade){
        super(nome, email, estado, descricao, CEP, identificador)
        this.idade = idade
    }

    Candidato(){

    }

    static void mostrarCandidatos(List<Candidato> lista){
        for(Candidato candidato in lista){
            println candidato
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "Idade: " + idade + "\n" +
                "CPF " + super.getIdentificador() + '\n';
    }

    void alterarParametros(String nome, String email, String estado, String descricao, String CEP, String identificador, int idade){
            super.setNome(nome)
            super.setEmail(email)
            super.setEstado(estado)
            super.setDescricao(descricao)
            super.setCEP(CEP)
            super.setIdentificador(identificador)
            setIdade(idade)
    }


}
