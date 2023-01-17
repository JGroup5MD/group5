package service.fabric;

import dao.fabric.JenreDaoSingleton;
import service.JenreService;
import service.api.IJenreService;

public class JenreServiceSingleton {
    private volatile static JenreService instance;

    private JenreServiceSingleton() {
    }
    public  static IJenreService getInstance(){
        if(instance==null){
            synchronized (VoteServiceSingleton.class){
                if(instance==null){
                    instance=new JenreService(JenreDaoSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
