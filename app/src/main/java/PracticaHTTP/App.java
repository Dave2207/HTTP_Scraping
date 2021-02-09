package PracticaHTTP;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException{
        Document doc;
        String direccionPagina = "";
        System.out.println("Escriba una URL válida: ");
        Scanner scan = new Scanner(System.in);
        direccionPagina = scan.nextLine();
        scan.close();
        //Estableciendo conexion usando Jsoup
        doc = Jsoup.connect(direccionPagina).get();

        //Cantidad de lineas
        String[] lineas;
        String texto = Jsoup.connect(direccionPagina).execute().body();
        lineas = texto.split("\n");
        System.out.println("La cantidad de líneas en la página es: " + lineas.length);
        
        //Busco parrafos y demás componentes
        Elements parrafos = doc.select("p");
        Elements imagenes = doc.select("p > img");
        Elements formulariosGET = doc.select("form[method=GET]");
        Elements formulariosPOST = doc.select("form[method=POST]");
        Elements inputFormularios = doc.select("input");

        //Imprimo salidas correspondientes
        System.out.println("La cantidad de párrafos en esta página es: " + parrafos.size());
        System.out.println("La cantidad de imagenes dentro de párrafos es: " + imagenes.size());
        System.out.println("La cantidad de formularios con el método GET es:" + formulariosGET.size());
        System.out.println("La cantidad de formularios con el método POST es:" + formulariosPOST.size());
        
        System.out.println("\nLos input de los formularios de este enlace son:\n");
        for (Element inputs : inputFormularios) {
            System.out.println("Name: " + inputs.attr("name") + "\tType: " + inputs.attr("type"));
        }

        for (Element formulario : formulariosPOST) {
            String actionPagina = formulario.attr("action");
            Document peticionServidor = Jsoup.connect(actionPagina).data("asignatura", "practica1").header("Matricula", "20170019").post();
            System.out.println(peticionServidor.body().toString());
        }
        
    }

}
