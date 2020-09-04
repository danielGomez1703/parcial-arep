/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.parcial.calculator;

import java.util.List;

/**
 *
 * @author Jairo Gomez
 */
public class Resultado {
    
    private Double promedio;
    private Double sumatoria;
    private List<Double> lista;

    public Resultado(Double promedio, Double sumatoria, List<Double> lista) {
        this.promedio = promedio;
        this.sumatoria = sumatoria;
        this.lista = lista;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Double getSumatoria() {
        return sumatoria;
    }

    public void setSumatoria(Double sumatoria) {
        this.sumatoria = sumatoria;
    }

    public List<Double> getLista() {
        return lista;
    }

    public void setLista(List<Double> lista) {
        this.lista = lista;
    }
    
    
    
}
