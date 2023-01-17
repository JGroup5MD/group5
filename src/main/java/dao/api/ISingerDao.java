package dao.api;

import dto.SingerDTO;

import java.util.List;

public interface ISingerDao {
    List<SingerDTO> get();
}
