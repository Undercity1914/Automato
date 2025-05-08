/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhodoze.model.entities;

/**
 *
 * @author marco
 */
public class Transicao {
    private int estadoOrigem;
    private char simbolo;
    private int estadoDestino;

    public Transicao(int origem, char simbolo, int destino) {
        this.estadoOrigem = origem;
        this.simbolo = simbolo;
        this.estadoDestino = destino;
    }

    public int getEstadoOrigem() {
        return estadoOrigem;
    }

    public void setEstadoOrigem(int estadoOrigem) {
        this.estadoOrigem = estadoOrigem;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public int getEstadoDestino() {
        return estadoDestino;
    }

    public void setEstadoDestino(int estadoDestino) {
        this.estadoDestino = estadoDestino;
    }
}
