/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhodoze.model.entities;

import com.mycompany.trabalhodoze.model.entities.Transicao;
import java.util.List;
import java.util.Set;


/**
 *
 * @author marco
 */
public class Aut {
    private final List<Transicao> transicoes;
    private final Set<Integer> estadosFinais;
    private final String alfabeto = "abc";

    public Aut(List<Transicao> transicoes, Set<Integer> estadosFinais) {
        this.transicoes = transicoes;
        this.estadosFinais = estadosFinais;
    }

    public boolean reconhecer(String palavra) {
        int estadoAtual = 0;

        //int tam = palavra.length();

        for (char c : palavra.toCharArray()) {
            if (alfabeto.indexOf(c) == -1) {
                return false;
            }

            boolean transicaoEncontrada = false;

            for (Transicao t : transicoes) {
                if (t.getEstadoOrigem() == estadoAtual && t.getSimbolo() == c) {
                    estadoAtual = t.getEstadoDestino();
                    transicaoEncontrada = true;
                    break;
                }
            }

            if (!transicaoEncontrada) {
                return false;
            }
        }

        return estadosFinais.contains(estadoAtual);
    }
}
