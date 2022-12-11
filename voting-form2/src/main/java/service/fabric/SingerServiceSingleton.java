package service.fabric;

import dao.fabric.SingerDaoSingleton;
import service.SingerService;
import service.api.ISingerService;


public class SingerServiceSingleton {
    private volatile static SingerService instance;

    public SingerServiceSingleton() {
    }
    public  static ISingerService getInstance(){
        if(instance==null){
            synchronized (VoteServiceSingleton.class){
                if(instance==null){
                    instance=new SingerService(SingerDaoSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
