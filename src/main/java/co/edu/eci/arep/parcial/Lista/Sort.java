/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.parcial.Lista;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Jairo Gomez
 */
public class Sort {

    public static List bubbleSort(String[] lista) {
        
        Double[] listnums = new Double[lista.length];
        for (int j = 0; j < lista.length; j++) {
            System.out.println(lista[j]);
            listnums[j] = Double.parseDouble(lista[j]);
        }
       
        for (int i = 0; i < listnums.length; i++) {
            for (int j = 0; j < listnums.length-1; j++) {
                if (listnums[j] > listnums[j+1]) {    
                    Double temp = listnums[j];
                    listnums[j] =listnums[j+1];
                    listnums[j+1]=temp;
                }
            }
        }
        List<Double>  dat = (List<Double>) Arrays.asList(listnums);
        return dat;

    }

}
