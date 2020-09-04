/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eci.arep.parcial;

/**
 *
 * @author Jairo Gomez
 */
import co.edu.eci.arep.parcial.Lista.Sort;
import co.edu.eci.arep.parcial.calculator.Calculator;
import co.edu.eci.arep.parcial.calculator.ListOp;
import co.edu.eci.arep.parcial.calculator.Resultado;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;
import spark.Request;
import spark.Response; 
import static spark.Spark.*;

public class App {
    
        static String resultJson = "";
                
        public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultsPage(req, res));
        get("/resultJson", (req, res) -> resultsPageJson(req, res));
        
       
    }

    private static String inputDataPage(Request req, Response res) {
        
        String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                +"<script>"
                +"var numbers=[];"
                +"function myFunction() {"
                +"var n = document.getElementById(\"numero\").value;"
                +"numbers.push(n);"
                +"console.log(numbers);"
                +"document.getElementById(\"numero\").value=\"\";"
                + "document.getElementById(\"lista\").value = numbers.toString()};"
                +"</script>"
                +"<center>"
                + "<h1>Parcial corte 1</h1>"
                + "<h3> Parcial de servidores y clientes  Con sparkweb </h3>"
                + "<hr/>"
                + "<form action=\"/results\">"
                +"<label>"
                + "  ingrese los numeros a evaluar UNO POR UNO :<br>"
                + "  <input id=\"numero\" type=\"text\" name=\"numero\" placeholder=\"ingrese un numero\">"
                +"   <button type=\"button\" onclick=\"myFunction()\">agregar valor</button>"
                +" <br/>"
                +"<p> digita un numero y presiona el boton para agregar a la lista"
                +" <br/>"
                +"</label>"
                +" <br/>"
                +"<label> "
                + " la lista a evaluar es: <br>"
                + " <input id=\"lista\" type=\"text\" name=\"lista\">"
                +"</label>"
               
                + "  <br>"
                + "  <br><br>"
                + "  <input type=\"submit\" value=\"Submit\">"
                + "</form>"
                + "<p>If you click the \"Submit\" button, the form-data will be sent to a page called \"/results\".</p>"
                +"<center>"                
                + "</body>"
                + "</html>";
        return pageContent;
    }

    
    private static String resultsPage(Request req, Response res) {
        Calculator calculator = new Calculator();
        
        System.out.println("entra al response");
        List datos = getList(req.queryParams("lista"));
        // asignacion de funcion flecha interface funcional
        ListOp promedio = (x) -> calculator.promedio(x);
        ListOp sumatoria = (x) -> calculator.sumatoria(x);
        
        // resutlado de consultas
        
        Double prom = calculator.StatOperation(datos, promedio);
        Double sum = calculator.StatOperation(datos, sumatoria);
        String sprom = "la media de los datos es : " + prom;
        String ssum ="la desviacion estandar de los datos es :" + sum;
        String sdatos = "la lista ordenada queda asi :" + datos.toString() ; 
        Gson g = new Gson();
        Resultado r = new Resultado(prom,sum,datos);
        resultJson = g.toJson(r);
        
         String pageContent
                = "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                +"<center>"
                + "<h1>Parcial corte 1</h1>"
                + "<h3> Parcial de servidores y clientes  Con sparkweb </h3>"
                + "<hr/>"
                + "  promedio:<br>"
                + "<p>" + sprom  +"</p>"
                + "  <br>"
                + "  Sumatoria:<br>"
                + "<p>"+  ssum + "</p>"
                + "  <br><br>"
                + "  datos ingresados :<br>"
                + "<p>"+  sdatos + "</p>"
                + "  <br><br>"
                  
                 + "Objeto resultado JSON :<br>"
                + "<p>"+  resultJson + "</p>"
                + "  <br><br>"
           
                + "<p>los resultados dependen de los datos ingresado, verificar que sean correctos.</p>"
                + "</center>"
                + "</body>"
                + "</html>";
        return pageContent;
    }

    private static JSONObject resultsPageJson(Request req, Response res) {
          Calculator calculator = new Calculator();
        
        System.out.println("entra al response");
        List datos = getList(req.queryParams("lista"));
        // asignacion de funcion flecha interface funcional
        ListOp promedio = (x) -> calculator.promedio(x);
        ListOp sumatoria = (x) -> calculator.sumatoria(x);
        
        // resutlado de consultas
        
        Double prom = calculator.StatOperation(datos, promedio);
        Double sum = calculator.StatOperation(datos, sumatoria);
        String sprom = "la media de los datos es : " + prom;
        String ssum ="la desviacion estandar de los datos es :" + sum;
        String sdatos = "la lista ordenada queda asi :" + datos.toString() ; 
        Gson g = new Gson();
        Resultado r = new Resultado(prom,sum,datos);
        resultJson = g.toJson(r);
        
         JSONObject jsonObject = new JSONObject(resultJson);
        return jsonObject;
        
    }
    
    private static List getList (String toArr){
        
        String[] parts = toArr.split(",");  
        List sortedList =Sort.bubbleSort(parts);
        return sortedList;
    }
    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     *
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
