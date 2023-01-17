package dao.fabric;

import dao.SingerDao;
import dao.api.ISingerDao;
import service.fabric.VoteServiceSingleton;

public class SingerDaoSingleton {
    private volatile static SingerDao instance;

    public SingerDaoSingleton() {
    }
    public static ISingerDao getInstance() {
        if(instance == null){
            synchronized (VoteServiceSingleton.class){
                if(instance == null){
                    instance=new SingerDao();
                }
            }
        }
        return instance;
    }
}
