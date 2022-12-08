package dao;

import dao.api.IGenereDao;

import java.util.ArrayList;
import java.util.List;

public class GenereDao implements IGenereDao {

    private List<String> generes = new ArrayList<>();

    public void GenereDao() {

    }
    @Override
    public List<String> getGenereList() {
        return generes;
    }

}

