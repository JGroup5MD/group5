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
    public List<SingerDTO> get(int IdSinger) {
        List <SingerDTO> singerDTOS=this.dao.get();
        for (SingerDTO singerDTO : singerDTOS) {
            if(IdSinger==singerDTO.getIdSinger()){
                return singerDTOS;
            }
        }
        return null;
    }

    @Override
    public boolean exist(int Idsinger) {
       List <SingerDTO> singerDTOS=this.dao.get();
       for (SingerDTO singerDTO : singerDTOS) {
           if(Idsinger==singerDTO.getIdSinger()){
               return true;
           }
           if(Character.isDigit(Idsinger)){
               return true;
           }
       }
            return false;
    }
}

