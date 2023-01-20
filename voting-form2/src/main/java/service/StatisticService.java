package service;

import dto.*;
import service.api.IJenreService;
import service.api.ISingerService;
import service.api.IStatisticServace;
import service.api.IVoteService;
import service.fabric.JenreServiceSingleton;
import service.fabric.SingerServiceSingleton;
import service.fabric.VoteServiceSingleton;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StatisticService  implements IStatisticServace {
    private final ISingerService iss;
    private final IJenreService ijs;
    private final IVoteService ivs;

    public StatisticService(ISingerService iss, IJenreService ijs, IVoteService ivs) {
        this.iss = SingerServiceSingleton.getInstance();
        this.ijs = JenreServiceSingleton.getInstance();
        this.ivs = VoteServiceSingleton.getInstance();
    }

    public Map<List<SingerDTO>, Long> getTopGinger(){
        return ivs.get().stream()
                .map(i->this.iss.get(i.getVote().getSingers()))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    public  List<ResultTopJenres<JenreDTO>> getTopJAnre(){
        List<ResultTopJenres<JenreDTO>> list=this.ijs.get().stream()
                .map(ResultTopJenres::new).collect(Collectors.toUnmodifiableList());
        for (SaveInformationDTO item: ivs.get()){
            int[] jenres=item.getVote().getJenres();
            for(ResultTopJenres <JenreDTO> rtj:list){
                for(int jenre:jenres){
                    if(rtj.getKey().getIdJenre()==jenre){
                        rtj.inc();
                        break;
                    }
                }
            }
        }
        Comparator <ResultTopJenres<JenreDTO>> comparator=Comparator.comparing(ResultTopJenres::getCount);
        return list;
    }
    public List<InformationTop> getInformationTop(){
        return this.ivs.get().stream()
                .map(i-> new InformationTop(i.getLdtInit(),i.getVote().getInformation()))
                .sorted(Comparator.comparing(InformationTop::getLdInit).reversed()).collect(Collectors.toList());

    }
}
