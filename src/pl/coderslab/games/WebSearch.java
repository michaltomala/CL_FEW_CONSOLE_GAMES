package pl.coderslab.games;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class WebSearch {

    public static void webSearch(){

        Connection connect = Jsoup.connect("https://komorkomania.pl/");
        try {
            Document document = connect.get();
            Elements links = document.select("div.grid-item__content");
            for (Element elem : links) {
                System.out.println(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
