import {Candidato} from "../classes/candidato";
import {Empresa} from "../classes/empresa";
import { VagaEmprego } from "../classes/vagaEmprego";

export function setLocalStorageItem<T>(key:string, valor: T):void{
    localStorage.setItem(key, JSON.stringify(valor));
    
}

export function getLocalStorageItem<T>(key:string): T | null{

    const item = localStorage.getItem(key);
    if(item != null){
        console.log("Resgatei não nulo");
    }
    return item ? JSON.parse(item) as T : null; 

}

export function criarCandidato(valor: Candidato){
    const nome:string = valor.nome;
    const item = getLocalStorageItem(nome);

    if(item == null){
        setLocalStorageItem(nome, valor);
        console.log("criei candidato");

    }
}

export function alterarCandidato(valor: Candidato){
    if(valor != null){
        var candidatoExiste = getLocalStorageItem(valor.nome);

        if(candidatoExiste != null){
            setLocalStorageItem(valor.nome, valor);
        }
    }
}