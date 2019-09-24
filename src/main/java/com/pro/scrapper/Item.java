package com.pro.scrapper;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="Item")
public class Item {
    private String title;
    private double price;
    private String image;
    private String url;
    private String source;


    public Item(String source,String title, double price, String image, String url) {
        this.source=source;
        this.title = title;
        this.price = price;
        this.image = image;
        this.url = url;
    }

    @XmlElement(name="source")
    public String getSource() {
        return source;
    }

    @XmlElement(name="title")
    public String getTitle() {
        return title;
    }

    @XmlElement(name="price")
    public double getPrice() {
        return price;
    }

    @XmlElement(name="image")
    public String getImage() {
        return image;
    }

    @XmlElement(name="url")
    public String getUrl() {
        return url;
    }

}
