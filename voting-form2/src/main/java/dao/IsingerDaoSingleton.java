package dao;

public class IsingerDaoSingleton {
    private volatile static JenreDao instance;

    public static JenreDao getInstance(){
        if(instance == null){
            synchronized (IsingerDaoSingleton.class){
                if(instance == null){
                    instance = new JenreDao();
                }
            }
        }
        return instance;
    }

}
