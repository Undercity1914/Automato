/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.trabalhodoze;

import com.mycompany.trabalhodoze.model.entities.Aut;
import com.mycompany.trabalhodoze.model.file.LerAutomatoDeArquivo;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class TrabalhoDoZe {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            LerAutomatoDeArquivo achiveRead = new LerAutomatoDeArquivo();
            Aut automato = achiveRead.fromCsv();
            System.out.println("\nDigite palavras para testar (ou 'sair' para encerrar):");
            
            boolean p = true;
            
            while (p) {
                String palavra = scanner.nextLine();
                if (palavra.equalsIgnoreCase("sair")) {
                   p = false;
                }
                else{
                    boolean resultado = automato.reconhecer(palavra);
                    System.out.println("Palavra \"" + palavra + "\" eh " + (resultado ? "ACEITA!!" : "REJEITADA ❌"));
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o autômato: " + e.getMessage());
        }
    }
}
