package service.api;

import dto.*;

import java.util.List;
import java.util.Map;

public interface IStatisticService {
    TopDTO getResult();

    Map<SingerDTO, Long> getTopSinger();
    List<ResultTopJenres<JenreDTO>> getTopJenre();
    List<InformationTop> getInformationTop();


}
