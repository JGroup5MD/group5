package dao.api;

import dto.JenreDTO;

import java.util.List;
import java.util.Map;

public interface IJenreDao {
    List<JenreDTO> get();

    JenreDTO get(int idJanre);
    boolean exist (int idJanre);

    boolean add(String newJenre);

    void update(long idJanre, String name);

    boolean delete(long idJanre);

}
