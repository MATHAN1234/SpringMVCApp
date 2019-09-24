package com.pro.scrapper;
import java.io.IOException;
import java.util.List;

public interface ScrapperInterface {
    public List<Item> parse(String searchString) throws IOException;

}

