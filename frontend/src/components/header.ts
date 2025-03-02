import { spawn } from "child_process";
class headerNeutro extends HTMLElement{

    constructor(){
        super();

        const shadow = this.attachShadow({mode: 'open'});

        const template = document.createElement('template');
       
        const link = document.createElement('link');
        
        link.rel = 'stylesheet';
        link.href = '../../css/header.css';

        template.innerHTML = `
        
        <nav> 
        
            <span>Linketinder</span>

            <ul> 
                <li><a href="">Login</a></li>
                <li><a href="">Cadastrar-se</a>
                </li>
            <ul>
        
        </nav>`;

        shadow.appendChild(link);
        shadow.appendChild(template.content.cloneNode(true));
    }

}

customElements.define("header-neutro", headerNeutro);