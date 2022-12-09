package dao;

public class JenreDaoSingleton {
    private volatile static JenreDao instance;

    public static JenreDao getInstance(){
        if(instance == null){
            synchronized (JenreDaoSingleton.class){
                if(instance == null){
                    instance = new JenreDao();
                }
            }
        }
        return instance;
    }

}
