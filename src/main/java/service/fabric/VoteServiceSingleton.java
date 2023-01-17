package service.fabric;

import dao.fabric.VoteDaoSingleton;
import service.VoteService;

public class VoteServiceSingleton {
    private volatile static VoteService instance;

    private VoteServiceSingleton() {
    }
    public static VoteService getInstance() {
        if(instance==null){
            synchronized (VoteServiceSingleton.class){
                if(instance==null){
                    instance=new VoteService(VoteDaoSingleton.getInstance(),
                            SingerServiceSingleton.getInstance(),
                            JenreServiceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
