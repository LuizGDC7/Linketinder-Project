import { spawn } from "child_process";
class FormularioEntrar extends HTMLElement{

    constructor(){
        super();

        const shadow = this.attachShadow({mode: 'open'});

        const template = document.createElement('template');
       
        const link = document.createElement('link');
        
        link.rel = 'stylesheet';
        link.href = '../../css/formularioEntrar.css';

        template.innerHTML = `
            <div>
                <label for="campoNome">Insira nome</label>
                <input type="text" name="campoNome" id="">
                <label for="campoSenha">Insira senha</label>
                <input type="password" name="campoSenha">
                <button type="submit">Entrar</button>
            </div>
        `;

        shadow.appendChild(link);
        shadow.appendChild(template.content.cloneNode(true));
    }

}

customElements.define("formulario-entrar", FormularioEntrar);