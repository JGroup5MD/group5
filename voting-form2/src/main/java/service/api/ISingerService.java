package service.api;

import dto.SingerDTO;

import java.util.List;

public interface ISingerService {
     List<SingerDTO> get();
     boolean exist(String singerName);
}
