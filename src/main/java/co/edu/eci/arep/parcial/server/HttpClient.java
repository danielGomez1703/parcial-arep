/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.parcial.server;

import java.io.*;
import java.net.*;

/**
 *
 * @author Jairo Gomez
 */
public class HttpClient {

    public static void main(String[] args) throws IOException {
        URL pagina = new URL("https://parcial-arep.herokuapp.com/resultsJson?numero=&lista=9%2C8%2C7%2C6%2C5%2C4");
        URLConnection connection = pagina.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Recibí: " + inputLine +"\n");
            if (!in.ready()) {
                break;
            }
        }
        in.close();

    }
}
