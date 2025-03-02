import { VagaEmprego } from "./vagaEmprego"; 

export class Candidato{

    constructor(public nome:string, public email:string, private _cpf:string, public idade:Number, public estado:string, public cep:string, private _vagasEmprego?: VagaEmprego[]){

    }

    get cpf():string{return this.cpf};
    set cpf(valor:string){this.cpf = valor};
    get vagasEmprego(): VagaEmprego[]{
        return this.vagasEmprego;
    }
    set vagasEmprego(valor: VagaEmprego[]){
        this._vagasEmprego = valor;
    }
    adicionarVagaEmprego(vaga: VagaEmprego){
        this._vagasEmprego?.push(vaga);
    }

}