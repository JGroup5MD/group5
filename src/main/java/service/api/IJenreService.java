package service.api;

import dto.JenreDTO;

import java.util.List;

public interface IJenreService {
    List<JenreDTO> get();

    JenreDTO get(int idJenre);
    boolean exist(int idJenre);
}

