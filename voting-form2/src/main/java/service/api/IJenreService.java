package service.api;

import dto.JenreDTO;

import java.util.List;

public interface IJenreService {
    List<JenreDTO>  get();
    boolean exist(int Idjenre);
}

