import { Candidato } from "./candidato";

export class VagaEmprego{
    constructor(private _empresaDetentora:string, private _id:Number, public descricao?:string, public competencias?: string[]){

    }

    private match = new Map<Candidato, boolean>();

    set id(valor:Number){
        this.id = valor;
    }

    get id():Number{
        return this._id;
    }

    set empresaDetentora(empresa:string){
        this._empresaDetentora = empresa;
    }

    get empresaDetentora():string{
        return this._empresaDetentora;
    }

    adicionarCandidato(candidato: Candidato){
        this.match.set(candidato, false);
    }

    matchCandidato(candidato:Candidato){
        this.match.set(candidato, true);
    }

    unmatchCandidato(candidato:Candidato){
        this.match.set(candidato, false);
    }

    getEstadoMatchCandidato(candidato: Candidato):boolean | undefined{

        if(this.match.has(candidato)){
            return this.match.get(candidato);
        }

        return false;
    }

    deletarCandidato(candidato:Candidato){
        this.match.delete(candidato);
    }

}