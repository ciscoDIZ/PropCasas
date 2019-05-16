/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciscodiz.propietarios_maven.modelo;

import javax.management.InvalidAttributeValueException;

/**
 *
 * @author noseq
 */
public class DNI {
    private char letra;
    private int numero;

    public DNI(char letra, int numero) throws InvalidAttributeValueException{
        letra = String.valueOf(letra).toUpperCase().charAt(0);
        if(validarDNI(letra, numero)){
            this.letra = letra;
            this.numero = numero;
        }else{
            throw new InvalidAttributeValueException("DNI no válido.");
        }
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    private boolean validarDNI(char letra, int numero){
        char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J'
                ,'Z','S','Q','V','H','L','C','K','E'};
        return letras[numero % 23] == letra;
    }

    @Override
    public String toString() {
        return  numero + String.valueOf(letra);
    }
    
}
