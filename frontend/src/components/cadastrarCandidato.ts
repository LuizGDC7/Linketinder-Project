import { spawn } from "child_process";
class CadastrarCandidato extends HTMLElement {

    constructor() {
        super();

        const shadow = this.attachShadow({ mode: 'open' });

        const template = document.createElement('template');

        const link = document.createElement('link');

        link.rel = 'stylesheet';
        link.href = '../../css/cadastrarCandidato.css';

        template.innerHTML = `
        
        <div id="cadastroEmpresa">

      <div class="campo">
        <label for="nomeCandidato">Insira seu nome</label>
        <input type="text" id="nomeCandidato" placeholder="Nome">
      </div>

      <div class="campo">
        <label for="emailCanddiato">Insira o seu e-mail</label>
        <input type="text" id="emailCanddiato" placeholder="E-mail">
      </div>

      <div class="campo">
        <label for="cpfCandidato">Insira o seu CPF</label>
        <input type="text" id="cpfCandidato" placeholder="CPF">
      </div>

      <div class="campo">
        <label for="idadeCandidato">Insira sua idade</label>
        <input type="number" id="idadeCandidato" placeholder="Idade">
      </div>

      <div class="campo">
        <label for="estadoCandidato">Insira o Estado da empresa</label>
        <input type="text" id="estadoCandidato" placeholder="Seu estado">
      </div>

      <div class="campo">
        <label for="cepCandidato">Insira o seu CEP</label>
        <input type="text" id="cepCandidato" placeholder="CEP">
      </div>

      <div class="campo">
        <label for="senha1">Insira senha</label>
        <input type="text" id="senha1" placeholder="Senha">
      </div>


      <div class="campo">
        <label for="senha2">Confirme a senha</label>
        <input type="text" placeholder="Confirme">
      </div>

      <button type="submit">Cadastrar!</button>
    </div>`;

        shadow.appendChild(link);
        shadow.appendChild(template.content.cloneNode(true));
    }

}

customElements.define("cadastrar-candidato", CadastrarCandidato);