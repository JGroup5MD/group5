package dao;

import dao.api.IJenreDao;
import dto.JenreDTO;

import java.util.List;

public class JenreDaoSQL implements IJenreDao {

    @Override
    public List<JenreDTO> get() {
        return null;
    }

    @Override
    public JenreDTO get(int idJanre) {
        return null;
    }

    @Override
    public boolean exist(int idJanre) {
        return false;
    }

    @Override
    public boolean add(String newJenre) {
        return false;
    }

    @Override
    public void update(long idJanre, String name) {

    }

    @Override
    public boolean delete(long idJanre) {
        return false;
    }
}
