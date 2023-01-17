package service.api;

import dto.SingerDTO;

import java.util.List;

public interface ISingerService {
     List<SingerDTO> get();
     SingerDTO get (int idSinger);
     boolean exist(int idSinger);
}
