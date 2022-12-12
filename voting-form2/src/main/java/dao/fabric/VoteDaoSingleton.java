package dao.fabric;

import dao.VoteDao;
import dao.api.IVoteDao;
import service.fabric.VoteServiceSingleton;

public class VoteDaoSingleton {
    private volatile  static VoteDao instance;

    private VoteDaoSingleton() {
    }
    public static IVoteDao getInstance() {
        if(instance==null){
            synchronized (VoteServiceSingleton.class){
                if(instance==null){
                    instance=new VoteDao();
                }
            }
        }
        return instance;
    }
}
