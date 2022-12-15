package dto;

import java.util.List;
import java.util.Map;

public class TopDTO {
    private Map<SingerDTO,Long> TopSinger;
    private List<ResultTopJenres> TopJenre;
    private List<InformationTop> TopInformation;

    public TopDTO(Map<SingerDTO, Long> topSinger, List<ResultTopJenres> topJenre, List<InformationTop> topInformation) {
        this.TopSinger = topSinger;
        this.TopJenre = topJenre;
        this.TopInformation = topInformation;
    }

    public Map<SingerDTO, Long> getTopSinger() {
        return TopSinger;
    }

    public List<ResultTopJenres> getTopJenre() {
        return TopJenre;
    }

    public List<InformationTop> getTopInformation() {
        return TopInformation;
    }
}
