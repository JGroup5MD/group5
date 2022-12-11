package dao.fabric;

import dao.JenreDao;
import dao.api.IJenreDao;
import service.fabric.VoteServiceSingleton;

public class JenreDaoSingleton {
    private volatile static JenreDao instance;

    private JenreDaoSingleton() {
    }
    public static IJenreDao getInstance(){
        if(instance == null){
            synchronized (VoteServiceSingleton.class){
                if(instance == null){
                    instance = new JenreDao();
                }
            }
        }
        return instance;
    }
}
