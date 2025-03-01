import { hello } from './components/HelloWorld';

const app = document.getElementById('app');
if (app) {
  app.innerHTML = hello();
}