import { spawn } from "child_process";
class footerNeutro extends HTMLElement{

    constructor(){
        super();

        const shadow = this.attachShadow({mode: 'open'});

        const template = document.createElement('template');
       
        const link = document.createElement('link');
        
        link.rel = 'stylesheet';
        link.href = '../../css/global.css';

        template.innerHTML = `
        
        <footer> 
        
            <p>&c Luiz Guilherme Dias Catulio<p>
         
        </footer>`;

        shadow.appendChild(link);
        shadow.appendChild(template.content.cloneNode(true));
    }

}

customElements.define("footer-neutro", footerNeutro);