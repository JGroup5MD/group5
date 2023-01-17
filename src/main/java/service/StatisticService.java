package service;

import dto.*;
import service.api.IJenreService;
import service.api.ISingerService;
import service.api.IStatisticService;
import service.api.IVoteService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticService implements IStatisticService {
    private IVoteService voteService;
    private IJenreService jenreService;
    private ISingerService singerService;

    public StatisticService(IVoteService voteService, IJenreService jenreService, ISingerService singerService) {
        this.voteService = voteService;
        this.jenreService = jenreService;
        this.singerService = singerService;
    }

    @Override
    public TopDTO getResult() {
        return new TopDTO(getTopSinger(), getTopJenre(), getInformationTop());
    }

    @Override
    public Map<SingerDTO, Long> getTopSinger() {
        return voteService.get().stream()
                .map(i -> this.singerService.get(i.getVote().getSingers()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public List<ResultTopJenres<JenreDTO>> getTopJenre() {
        List<ResultTopJenres<JenreDTO>> top = this.jenreService.get().stream()
                .map(ResultTopJenres::new)
                .collect(Collectors.toList());
        for (SaveInformationDTO saveInformationDTO : voteService.get()) {
            int[] jenres = saveInformationDTO.getVote().getJenres();

            for (ResultTopJenres<JenreDTO> jenreDTOResultTopJenres : top) {
                for (int jenre : jenres) {
                    if (jenreDTOResultTopJenres.getKey().getIdJenre() == jenre) {
                        jenreDTOResultTopJenres.inc();
                        break;
                    }
                }
            }
        }
        Comparator<ResultTopJenres<JenreDTO>> cmp = Comparator.comparing(ResultTopJenres::getCount);
        top.sort(cmp.reversed());
        return top;
    }

    @Override
    public List<InformationTop> getInformationTop() {
        return this.voteService.get().stream()
                .map(i -> new InformationTop(i.getLdtInit(), i.getVote().getInformation()))
                .sorted(Comparator.comparing(InformationTop::getLdInit).reversed())
                .collect(Collectors.toList());
    }
}
