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

    static ArrayList<String> mostrarCandidatos(List<Candidato> lista){

        ArrayList<String> saida = new ArrayList<>()

        for(Candidato candidato in lista){
            saida.add(candidato.toString())
        }

        return saida
    }

    @Override
    public String toString() {
        String retorno = super.toString() +
                "Idade: " + idade + "\n" +
                "CPF: " + super.getIdentificador() + '\n';
                retorno += "Competências: "
                if(competencias != null){
                    for(int c = 0; c < competencias.size(); c++){
                        retorno += (c == 0 ? competencias.get(c) : ", ${competencias.get(c)}")
                    }
                }
                retorno += "\n"
        return retorno
    }

    boolean equals(Object outro) {
        if (outro == null || !(outro instanceof Candidato)) {
            return false
        }
        Candidato outroCandidato = (Candidato) outro
        return this.nome == outroCandidato.nome &&
                this.email == outroCandidato.email &&
                this.estado == outroCandidato.estado &&
                this.descricao == outroCandidato.descricao &&
                this.CEP == outroCandidato.CEP &&
                this.identificador == outroCandidato.identificador &&
                this.idade == outroCandidato.idade &&
                this.competencias == outroCandidato.competencias
    }

}
