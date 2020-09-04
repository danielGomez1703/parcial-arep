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
public class Calculator {
    /**
     * Calcula el promedio de los datos.
     * @param list Datos ingresados
     * @return  promedio de los datos
     */
    
    public Double promedio(List<Double> list){
        Double med = 0.0;
        for (int i=0 ; i<list.size(); i++){
            med+=list.get(i);
        }
   
        return (med/list.size());
    }
    
    /**
     * Sumatoria de los datos de la lista
     * @param list  lista de datos recibidos.
     * @return  la sumatoria de los datos;
     */
    public Double sumatoria (List<Double> list){
        Double sum = 0d;
        for (int i=0 ; i<list.size(); i++){
            sum+=list.get(i);
        }
        return sum;
    }
    
    static public Double StatOperation(List list, ListOp op ){
        return op.operation(list);
    }
    
    
}
