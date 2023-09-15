package labirinto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labirinto {

    private char[][] labirinto;
    private int numLinhas;
    private int numColunas;

    public char[][] carregaLabirinto(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        numLinhas = Integer.parseInt(br.readLine().trim());
        numColunas = Integer.parseInt(br.readLine().trim());
        labirinto = new char[numLinhas][numColunas];
        String linha;
        int i = 0;
        while ((linha = br.readLine()) != null) {
            for (int j = 0; j < numColunas; j++) {
                labirinto[i][j] = linha.charAt(j);
            }
            i++;
        }
        br.close();
        return labirinto;
    }
    // jeito mais simples de se fazer
    public boolean labirinto() {
        return labirinto(0, 0);
    }
    private boolean labirinto(int linha, int coluna) {
    	
        if (linha < 0 || linha >= numLinhas || coluna < 0 || coluna >= numColunas)
            return false;
        if (labirinto[linha][coluna] == 'D')
            return true;        
        if (labirinto[linha][coluna] == 'X') 
            return false;     
        labirinto[linha][coluna] = 'X';
        boolean caminhos = labirinto(linha - 1, coluna) || labirinto(linha, coluna + 1)
        || labirinto(linha + 1, coluna) || labirinto(linha, coluna - 1);
        labirinto[linha][coluna] = ' ';
        return caminhos;
    }
    
    
    
    
    
    
}