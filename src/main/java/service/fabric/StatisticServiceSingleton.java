package service.fabric;

import service.StatisticService;
import service.api.IStatisticService;

public class StatisticServiceSingleton {
    private volatile static StatisticService instance;

    private StatisticServiceSingleton() {
    }
    public  static IStatisticService getInstance(){
        if(instance==null){
            synchronized (StatisticServiceSingleton.class){
                if(instance==null){
                    instance = new StatisticService(
                            VoteServiceSingleton.getInstance(),
                            JenreServiceSingleton.getInstance(),
                            SingerServiceSingleton.getInstance()
                                                );
                }
            }
        }
        return instance;
    }
}
