package dao.api;

import dto.JenreDTO;

import java.util.List;
import java.util.Map;

public interface IJenreDao {
    List<JenreDTO> get();
    boolean exist (String jenreName);
}
