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

    @Override
    public SingerDTO get(int idSinger) {
        List<SingerDTO> singerDTOS = this.dao.get();
        for (SingerDTO singerDTO : singerDTOS) {
            if (idSinger == singerDTO.getIdSinger()) {
                return singerDTO;
            }
        }
        return null;
    }

    @Override
    public boolean exist(int idSinger) {
        List<SingerDTO> singerDTOS = this.dao.get();
        for (SingerDTO singerDTO : singerDTOS) {
            if (idSinger == singerDTO.getIdSinger()) {
                return true;
            }
        }
        return false;
    }
}

