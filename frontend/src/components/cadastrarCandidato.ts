import { spawn } from "child_process";
import { Candidato } from "../classes/candidato";
import {criarCandidato} from "../public/crud";


class CadastrarCandidato extends HTMLElement {

    constructor() {
        super();

        const shadow = this.attachShadow({ mode: 'open' });

        const template = document.createElement('template');

        const link = document.createElement('link');

        link.rel = 'stylesheet';
        link.href = '../../css/cadastrarCandidato.css';

        template.innerHTML = `
        
        <form id="cadastroEmpresa">

      <div class="campo">
        <label for="nomeCandidato">Insira seu nome</label>
        <input type="text" id="nomeCandidato" placeholder="Nome" required>
      </div>

      <div class="campo">
        <label for="emailCandidato">Insira o seu e-mail</label>
        <input type="text" id="emailCandidato" placeholder="E-mail" required>
      </div>

      <div class="campo">
        <label for="cpfCandidato">Insira o seu CPF</label>
        <input type="text" id="cpfCandidato" placeholder="CPF" required>
      </div>

      <div class="campo">
        <label for="idadeCandidato">Insira sua idade</label>
        <input type="number" id="idadeCandidato" placeholder="Idade">
      </div>

      <div class="campo">
        <label for="estadoCandidato">Insira o Estado da empresa</label>
        <input type="text" id="estadoCandidato" placeholder="Seu estado" required>
      </div>

      <div class="campo">
        <label for="cepCandidato">Insira o seu CEP</label>
        <input type="text" id="cepCandidato" placeholder="CEP" required>
      </div>

      <div class="campo">
        <label for="senha1">Insira senha</label>
        <input type="password" id="senha1" placeholder="Senha" required>
      </div>

      <div class="campo">
        <label for="senha2">Confirme a senha</label>
        <input id="senha2" type="password" placeholder="Confirme" required>
      </div>

      <button type="submit" id="submitCadastrarCandidato">Cadastrar!</button>
    </form>`;

    shadow.appendChild(link);
    shadow.appendChild(template.content.cloneNode(true));

    const form = shadow.getElementById("cadastroEmpresa") as HTMLFormElement; 
      
       form.addEventListener('submit', (event) => {

          event.preventDefault();

          const nome:string   = (shadow.getElementById('nomeCandidato') as HTMLInputElement).value;
          const email:string  = (shadow.getElementById('emailCandidato') as HTMLInputElement).value;
          const cpf:string    = (shadow.getElementById('cpfCandidato') as HTMLInputElement).value;
          const idade:number  = parseInt((shadow.getElementById('idadeCandidato') as HTMLInputElement).value);
          const estado:string = (shadow.getElementById('estadoCandidato') as HTMLInputElement).value;
          const cep:string    = (shadow.getElementById('cepCandidato') as HTMLInputElement).value;
          const senha1:string = (shadow.getElementById('senha1') as HTMLInputElement).value;
          const senha2:string = (shadow.getElementById('senha2') as HTMLInputElement).value;

          if(senha1 == senha2){
              let novoCandidato:Candidato = new Candidato(nome, email, cpf, idade, estado, cep);
              criarCandidato(novoCandidato);
          }else{
            alert("Senhas não possuem mesmo valor");
          }

       });
       

        
    }

}

customElements.define("cadastrar-candidato", CadastrarCandidato);