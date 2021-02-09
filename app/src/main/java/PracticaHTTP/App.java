/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package PracticaHTTP;

//import javax.swing.text.Document;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class App {

    public static void main(String[] args) throws IOException{
        String direccionPagina = "https://www.google.com.do";
        Document doc;

        //Estableciendo conexion usando Jsoup
        doc = Jsoup.connect(direccionPagina).get();
        System.out.println(doc.html());

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

        // for (Element formulario : formulariosPOST) {
        //     formulario;
        // }

        //Titulo de la pagina
        // String title = doc.title();
        // System.out.println("Titulo: "+ title);

        //Links en la pagina
        // Elements links = doc.select("a[href]");
        // for (Element link : links) {
        //     System.out.println("\nLink: " + link.attr("href"));
        //     System.out.println("Text: " + link.text());
        // }

    }

}
