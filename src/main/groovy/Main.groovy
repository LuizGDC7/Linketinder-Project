// Feito por Luiz Guilherme Dias Catulio

import classes.Candidato
import classes.Empresa
import funcionalidades.Menu

import java.lang.reflect.Array

static void main(String[] args) {
  ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
  ArrayList<Empresa> empresas = new ArrayList<>()
  Menu menu = new Menu();

  candidatos.addAll([
          new Candidato("Luiz", "luiz@gmail.com", "Goiânia/GO", "Desenvolvedor Full Stack com 5 anos de experiência", "01010-000", "123.456.789-01", 29, new ArrayList<String>(["Python", "Java", "C++"])),
          new Candidato("Mariana Oliveira", "mariana.oliveira@email.com","Rio de Janeiro", "Designer UX/UI apaixonada por criar experiências únicas","22040-001","234.567.890-12",26, new ArrayList<String>(["Python", "Groovy", "Deployment"])),
          new Candidato("Carlos Mendes","carlos.mendes@email.com","Minas Gerais","Engenheiro de Software especializado em IA e Machine Learning","30130-000","345.678.901-23",34, new ArrayList<String>(["Python", "Ruby", "Angular"])),
          new Candidato("Fernanda Costa","fernanda.costa@email.com","Paraná","Analista de Dados com experiência em Big Data e BI","80050-530","456.789.012-34",31, new ArrayList<String>(["Lua", "Java", "Ruby"])),
          new Candidato("Rafael Souza","rafael.souza@email.com","Bahia","Gerente de Projetos com certificação PMP e SCRUM Master","40020-300","567.890.123-45",38, new ArrayList<String>(["C", "Java", "Power BI"]))
  ])

  empresas.addAll([
          new Empresa("Tech Solutions Ltda","contato@techsolutions.com" ,"São Paulo","Empresa líder em desenvolvimento de software corporativo"," 01153-000 ","12.345.678/0001-90","Brasil", new ArrayList<String>(["Lua", "Java", "C++"])),
          new Empresa("Design Innovators","contato@designinnovators.com","Rio de Janeiro","Agência especializada em design gráfico e branding digital","22290-040","23.456.789/0001-01","Brasil", new ArrayList<String>(["C#", "Angular", "C++"])),

          new Empresa("AI Revolution","contato@airevolution.com","Minas Gerais","Startup focada em inteligência artificial e automação","30140-000","34.567.890/0001-12","Brasil", new ArrayList<String>(["Python", "Rust", "Scratch"])),
          new Empresa("Data Insights","contato@datainsights.com","Paraná","Consultoria de análise de dados e inteligência de mercado","80060-530","45.678.901/0001-23","Brasil", new ArrayList<String>(["Python", "Rust", "C++"])),
          new Empresa("Agile Projects","contato@agileprojects.com","Bahia","Empresa especializada em gerenciamento ágil de projetos","40030-300","56.789.012/0001-34","Brasil", new ArrayList<String>(["Python", "Power BI", "C++"]))
  ])

  while(true){
    int escolha = menu.obterOpcao()
    if(escolha == 0) break;
    menu.executarOpcao(escolha, candidatos, empresas)
  }
}