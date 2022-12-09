package web;

import web.api.ISinger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Singer implements ISinger {

    ArrayList<String> singerList = new ArrayList<>(
            Arrays.asList("Жанна Агузарова", "Земляне", "BTC", "Сосед с пианино сверху"));


    public ArrayList<String> getSinger() {
        return singerList;
    }

    @Override
    public List checkSinger() {
        return null;
    }


}
