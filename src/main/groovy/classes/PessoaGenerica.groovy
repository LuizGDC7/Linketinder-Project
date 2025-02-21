package classes


// Classe anoréxica
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
        return  "Nome: " + nome + '\n' +
                "E-mail: " + email + '\n' +
                "Estado: " + estado + '\n' +
                "Descrição: " + descricao + '\n' +
                "CEP: " + CEP + '\n'
        ;
    }
}
