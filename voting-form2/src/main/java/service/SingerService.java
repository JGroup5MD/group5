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
    public List<SingerDTO> get() { return dao.get();
    }

    @Override
    public boolean exist(String singerName) {
        if(singerName==null||singerName.isBlank()){
            throw new IllegalArgumentException("вы не выбрали артиста");
        }
        if (singerName.equals(1-9)){
            throw  new IllegalArgumentException("вы ввели имя артиста которого нет в списке");
        }
        return this.exist(singerName);
    }
}
