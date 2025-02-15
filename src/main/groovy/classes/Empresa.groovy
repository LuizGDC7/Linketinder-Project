package classes

class Empresa extends PessoaGenerica{
    String pais

    Empresa() {
    }

    Empresa(String nome, String email, String estado, String descricao, String CEP, String identificador, String pais) {
        super(nome, email, estado, descricao, CEP, identificador)
        this.pais = pais
    }

    static void mostrarEmpresas(List<Empresa> lista){
        for(Empresa empresa in lista){
            println empresa
        }
    }


    @Override
    public String toString() {
        return super.toString() +
                "País: " + this.pais + '\n' +
                "CNPJ: " + super.getIdentificador() + "\n";
    }

    void alterarParametros(String nome, String email, String estado, String descricao, String CEP, String identificador, String pais){
        super.setNome(nome)
        super.setEmail(email)
        super.setEstado(estado)
        super.setDescricao(descricao)
        super.setCEP(CEP)
        super.setIdentificador(identificador)
        setPais(pais)
    }
}
