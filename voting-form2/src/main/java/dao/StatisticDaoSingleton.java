package dao;

public class StatisticDaoSingleton {
    private volatile static JenreDao instance;

    public static JenreDao getInstance(){
        if(instance == null){
            synchronized (StatisticDaoSingleton.class){
                if(instance == null){
                    instance = new JenreDao();
                }
            }
        }
        return instance;
    }

}
