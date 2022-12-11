package service.fabric;

import service.VoteService;

public class VoteServiceSingleton {
    private volatile static VoteService instance;

    public VoteServiceSingleton() {
    }

    public static VoteService getInstance() {
        if(instance=null){
            synchronized (VoteServiceSingleton.class){
                if(instance==null){
                    instance=new VoteService();
                }
            }
        }
        return instance;
    }
}
