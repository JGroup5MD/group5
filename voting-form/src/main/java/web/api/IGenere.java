package web.api;

import java.util.ArrayList;
import java.util.List;

//проверка на существовани
public interface IGenere {

    ArrayList<String> getGenere();

    default List checkGenere() {
        return null;
    }
}
