package classes

class PessoaGenerica {
    String nome, email, estado, descricao, identificador, CEP

    PessoaGenerica(){

    }

    PessoaGenerica(String nome, String email, String estado, String descricao, String CEP, String identificador){
        this.nome = nome
        this.email = email
        this.estado = estado
        this.descricao = descricao
        this.identificador = identificador
        this.CEP = CEP
    }


    @Override
    public String toString() {
        return  "nome: " + nome + '\n' +
                "email: " + email + '\n' +
                "estado: " + estado + '\n' +
                "descricao :" + descricao + '\n' +
                "CEP: " + CEP + '\n'
        ;
    }
}
