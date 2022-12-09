package service.fabrics;

import service.VoteService;
import service.api.IVoteService;

public class VoteServiceFactory {

    private static volatile VoteServiceFactory instance = null;

    private VoteServiceFactory(){
    }

    public static VoteServiceFactory getInstance(){
        if(instance == null){
            synchronized (VoteServiceFactory.class){
                if(instance == null){
                    instance = new VoteServiceFactory();
                }
            }
        }
        return instance;
    }

    public IVoteService createService(){
        return VoteServiceDBSingleton.getInstance();
    }
}
