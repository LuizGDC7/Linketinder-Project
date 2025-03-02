import {VagaEmprego} from "./vagaEmprego"

export class Empresa{
    constructor(public nome:string, public email:string, private _cnpj:string, public pais:string, public estado:string, public cep:string, private _vagasEmprego?: VagaEmprego[]){

    }

    get cnpj():string{return this.cnpj};
    set cnpj(valor:string){this.cnpj = valor};
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