package service;

import dao.api.IJenreDao;
import dto.JenreDTO;
import service.api.IJenreService;

import java.util.List;

public class JenreService implements IJenreService {
    private final IJenreDao dao;

    public JenreService(IJenreDao dao) {
        this.dao = dao;
    }

    @Override
    public List<JenreDTO> get() {
        return dao.get();
    }

    @Override
    public boolean exist(String jenreName) {
        if(jenreName == null||jenreName.isBlank()){
            throw new IllegalArgumentException("Вы не выбрали жанр");
        }
        return this.dao.exist(jenreName);
    }
}
