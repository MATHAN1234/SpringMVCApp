package com.pro.scrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class ExpansysScrapper implements ScrapperInterface {
    public List<Item> parse(String searchString) throws IOException {
        String theUrl="https://www.expansys.my/search/?q="+searchString; 		//URL of the iprice website
        Connection.Response response=null;
        response=Jsoup.
                connect(theUrl).
                followRedirects(true).
                userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36").execute();
        Document doc = null;
        doc =  response.parse();
        Elements itemS = doc.getElementById("products").children(); 			//getting the element which contain all the product
        ArrayList<Item> result=new ArrayList<Item>(itemS.size());
        // System.out.println(itemS.size());
        for (int i = 0; i < itemS.size(); i++) {
            try {
                Element img = itemS.get(i).child(0).child(0).child(0).child(0);
                Element lin = itemS.get(i).child(0);
                Element tit = itemS.get(i).child(0).child(0).child(1).child(0);
                Element linkofPri = itemS.get(i);
                Elements pri=linkofPri.select("a > ul > li.listing__item-price");
                String title=tit.text().toString();
                String Price=pri.text().substring(2).replaceAll(",", "");
                double priceInDouble=Double.parseDouble(Price);
                String halflink=lin.attr("href").toString();
                String url=("https://www.expansys.my"+halflink);
                String image=(img.attr("src"));
                result.add(new Item("Expansys", title, priceInDouble, image, url));
                System.out.println("Expansys"+":"+title+":"+priceInDouble+":"+image+":"+url);
            } catch (IndexOutOfBoundsException e) {
            }
            catch (NullPointerException ex){

            }
        }
        return result;
    }

}

