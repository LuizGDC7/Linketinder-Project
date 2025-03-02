import { defineConfig } from 'vite';
import path from 'path';

export default defineConfig({
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './'), // Alias para importações
      '@css': path.resolve(__dirname, './src/css')
    },
  },
  build: {
    outDir: 'dist', // Pasta de saída para produção
  },
  base: './' 
});