package classes

class Empresa extends PessoaGenerica{
    String pais
    ArrayList<String> competencias


    Empresa() {
    }

    Empresa(String nome, String email, String estado, String descricao, String CEP, String identificador, String pais, ArrayList<String> competencias) {
        super(nome, email, estado, descricao, CEP, identificador)
        this.pais = pais
        this.competencias = competencias
    }

    static void mostrarEmpresas(List<Empresa> lista){
        for(Empresa empresa in lista){
            println empresa
        }
    }


    @Override
    public String toString() {
        String retorno = super.toString() +
                "País: " + this.pais + '\n' +
                "CNPJ: " + super.getIdentificador() + "\n";
                retorno += "Compências: "
                if(competencias != null){
                    for(int c = 0; c < competencias.size(); c++){
                        retorno += (c == 0 ? competencias.get(c) : ", ${competencias.get(c)}")
                    }
                }
                retorno += "\n"
        return retorno
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
