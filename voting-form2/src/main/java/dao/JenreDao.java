package dao;

import dao.api.IJenreDao;

import java.util.ArrayList;
import java.util.List;

public class JenreDao implements IJenreDao {

    private List<String> generes = new ArrayList<>();

    public void GenereDao() {

    }
    @Override
    public List<String> getGenereList() {
        return generes;
    }

}

