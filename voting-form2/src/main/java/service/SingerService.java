package service;

import dao.api.ISingerDao;
import dto.SingerDTO;
import service.api.ISingerService;

import java.util.List;

public class SingerService implements ISingerService {
    private final ISingerDao dao;

    public SingerService(ISingerDao dao) {
        this.dao = dao;
    }

    @Override
    public List<SingerDTO> get() {

        return dao.get();
    }
}
