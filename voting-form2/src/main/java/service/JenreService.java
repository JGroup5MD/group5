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
    public boolean  exist(int Idjenre) {
        List <JenreDTO> jenreDTOS=this.dao.get();
        for (JenreDTO jenreDTO : jenreDTOS) {
            if(Idjenre==jenreDTO.getIdJenre()){
                return true;
            }
            if(Character.isDigit(Idjenre)){
                return true;
            }
        }
        return false;
    }
}
