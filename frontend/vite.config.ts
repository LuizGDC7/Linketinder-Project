import { defineConfig } from 'vite';
import path from 'path';

export default defineConfig({
  resolve: {
    alias: {
      '@': path.resolve(__dirname, './src'), // Alias para importações
    },
  },
  build: {
    outDir: 'dist', // Pasta de saída para produção
  },
});