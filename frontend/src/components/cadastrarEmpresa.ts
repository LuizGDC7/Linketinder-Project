import { spawn } from "child_process";
class CadastrarEmpresa extends HTMLElement {

    constructor() {
        super();

        const shadow = this.attachShadow({ mode: 'open' });

        const template = document.createElement('template');

        const link = document.createElement('link');

        link.rel = 'stylesheet';
        link.href = '../../css/cadastrarEmpresa.css';

        template.innerHTML = `
        
        <div id="cadastroEmpresa">

      <div class="campo">
        <label for="nomeEmpresa">Insira o nome da empresa</label>
        <input type="text" id="nomeEmpresa" placeholder="Nome">
      </div>

      <div class="campo">
        <label for="emailEmpresa">Insira o e-mail da empresa</label>
        <input type="text" id="emailEmpresa" placeholder="E-mail">
      </div>

      <div class="campo">
        <label for="cnpjEmpresa">Insira o CNPJ da empresa</label>
        <input type="text" id="cnpjEmpresa" placeholder="CNPJ">
      </div>

      <div class="campo">
        <label for="paisEmpresa">Insira o país da empresa</label>
        <input type="text" id="paisEmpresa" placeholder="País">
      </div>

      <div class="campo">
        <label for="estadoEmpresa">Insira o Estado da empresa</label>
        <input type="text" id="estadoEmpresa" placeholder="Estado da Empresa">
      </div>

      <div class="campo">
        <label for="cepEmpresa">Insira o CEP da empresa</label>
        <input type="text" id="cepEmpresa" placeholder="CEP">
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

customElements.define("cadastrar-empresa", CadastrarEmpresa);