package classes

import org.apache.tools.ant.taskdefs.condition.Equals

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

    static ArrayList<String> mostrarEmpresas(List<Empresa> lista){

        ArrayList<String> listaEmpresas = new ArrayList<>()

        for(Empresa empresa in lista){
            listaEmpresas.add(empresa.toString())
        }

        return listaEmpresas
    }


    @Override
    public String toString() {
        String retorno = super.toString() +
                "País: " + this.pais + '\n' +
                "CNPJ: " + super.getIdentificador() + "\n";
                retorno += "Competências: "
                if(competencias != null){
                    for(int c = 0; c < competencias.size(); c++){
                        retorno += (c == 0 ? competencias.get(c) : ", ${competencias.get(c)}")
                    }
                }
                retorno += "\n"
        return retorno
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (o == null || getClass() != o.class) return false

        Empresa empresa = (Empresa) o

        return  this.nome == empresa.nome &&
                this.identificador == empresa.identificador &&
                this.competencias == empresa.competencias &&
                this.pais == empresa.pais &&
                this.CEP == empresa.CEP &&
                this.descricao == empresa.descricao &&
                this.email == empresa.email &&
                this.estado == empresa.estado
    }

    int hashCode() {
        int result
        result = (pais != null ? pais.hashCode() : 0)
        result = 31 * result + (competencias != null ? competencias.hashCode() : 0)
        return result
    }

}
