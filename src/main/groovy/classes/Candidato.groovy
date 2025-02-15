package classes

class Candidato extends PessoaGenerica{
    int idade
    ArrayList<String> competencias

    Candidato(String nome, String email, String estado, String descricao, String CEP, String identificador, int idade, ArrayList<String> competencias){
        super(nome, email, estado, descricao, CEP, identificador)
        this.idade = idade
        this.competencias = competencias
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
        String retorno = super.toString() +
                "Idade: " + idade + "\n" +
                "CPF: " + super.getIdentificador() + '\n';
                retorno += "Compências: "
                if(competencias != null){
                    for(int c = 0; c < competencias.size(); c++){
                        retorno += (c == 0 ? competencias.get(c) : ", ${competencias.get(c)}")
                    }
                }
                retorno += "\n"
        return retorno
    }

    void alterarParametros(String nome, String email, String estado, String descricao, String CEP, String identificador, int idade, ArrayList<String> novasCompetencias){
            super.setNome(nome)
            super.setEmail(email)
            super.setEstado(estado)
            super.setDescricao(descricao)
            super.setCEP(CEP)
            super.setIdentificador(identificador)
            setIdade(idade)
            setCompetencias(novasCompetencias)
    }


}
