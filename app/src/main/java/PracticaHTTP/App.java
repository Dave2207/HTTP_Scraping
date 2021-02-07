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

    public static void main(String[] args) {
        Document doc;
        try {
            doc = Jsoup.connect("https://en.wikipedia.org/").get();

            //Titulo de la pagina
            String title = doc.title();
            System.out.println("Titulo: "+ title);

            //Links en la pagina
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                System.out.println("\nLink: " + link.attr("href"));
                System.out.println("Text: " + link.text());
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
