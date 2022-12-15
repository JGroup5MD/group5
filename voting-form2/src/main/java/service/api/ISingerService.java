package service.api;

import dto.SingerDTO;

import java.util.List;

public interface ISingerService {
     List<SingerDTO> get(int IdSinger);
     boolean exist(int Idsinger);
}
