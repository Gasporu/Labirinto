package labirinto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrincipalLabirinto {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo do labirinto (com .txt):");
        String fileName = scanner.nextLine();
        scanner.close();

        Labirinto labirinto = new Labirinto();
        char[][] labirintoArray = labirinto.carregaLabirinto(fileName);
        boolean existeCaminho = labirinto.labirinto();

        BufferedWriter bw = new BufferedWriter(new FileWriter("saidaLabirinto.txt"));
        System.out.println("O arquivo foi criado com a resposta :) ");
        if (existeCaminho) 
            bw.write("Existe um caminho para o labirinto");        
        else
            bw.write("Não existe um caminho para o labirinto");
        bw.close();
    }
}