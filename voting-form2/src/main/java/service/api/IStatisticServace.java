package service.api;

import dto.*;

import java.util.List;
import java.util.Map;

public interface IStatisticServace {
    public Map<List<SingerDTO>, Long> getTopGinger();
    public  List<ResultTopJenres<JenreDTO>> getTopJAnre();
    public List<InformationTop> getInformationTop();

}
