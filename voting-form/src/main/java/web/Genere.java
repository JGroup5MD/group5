package web;

import web.api.IGenere;

import java.util.ArrayList;
import java.util.Arrays;


public class Genere implements IGenere {

    ArrayList<String> genereList = new ArrayList<>(
            Arrays.asList(
                    "Rock", "Jazz",
            "Pop", "Classic", "Alternative",
            "Country", "Lullaby", "J-Rock", "K-POP", "Drumm'n'bass"
            ));

    public ArrayList<String> getGenere() {
        return genereList;
    }


}
