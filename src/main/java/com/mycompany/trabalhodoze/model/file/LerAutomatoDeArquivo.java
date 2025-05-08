/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhodoze.model.file;

import com.mycompany.trabalhodoze.model.entities.Aut;
import com.mycompany.trabalhodoze.model.entities.Transicao;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author marco
 */
public class LerAutomatoDeArquivo {
    private static InputStream input;

    public static InputStream getInput() {
        return input;
    }

    public static void setInput(InputStream input) {
        LerAutomatoDeArquivo.input = input;
    }

    public LerAutomatoDeArquivo() {
        this.input = LerAutomatoDeArquivo.class.getResourceAsStream("/com/mycompany/automato/automato.csv");
    }
    
    public Aut fromCsv() throws IOException {
        if (input == null) {
            throw new FileNotFoundException("Arquivo automato.csv nao encontrado.");
        }

        BufferedReader leitor = new BufferedReader(new InputStreamReader(input));

        String primeiraLinha = leitor.readLine();
        String[] finaisStr = primeiraLinha.split(";")[1].trim().split(",");
        Set<Integer> estadosFinais = new HashSet<>();
        for (String f : finaisStr) {
            estadosFinais.add(Integer.parseInt(f.trim()));
        }

        List<Transicao> transicoes = new ArrayList<>();
        String linha;
        while ((linha = leitor.readLine()) != null) {
            if (linha.trim().isEmpty() || linha.startsWith("#")) continue;

            String[] partes = linha.trim().split(";");
            if (partes.length == 3) {
                int origem = Integer.parseInt(partes[0]);
                char simbolo = partes[1].charAt(0);
                int destino = Integer.parseInt(partes[2]);

                transicoes.add(new Transicao(origem, simbolo, destino));
            }
        }

        return new Aut(transicoes, estadosFinais);
    }
}
