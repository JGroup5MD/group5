package service.fabric;

import dao.fabric.VoteDaoSingleton;
import service.VoteService;
import service.api.IStatisticServace;

public class StatisticServiceSingleton {

        private volatile static StatisticService instance;

        private IStatisticServace getInstance() {
            if(instance==null){
                synchronized (StatisticServiceSingleton.class){
                    if(instance==null){
                        instance=new StatisticService(
                                SingerServiceSingleton.getInstance(),
                                JenreServiceSingleton.getInstance(),
                                VoteServiceSingleton.getInstance());

                    }
                }
            }
            return instance;
        }
    }

