package dao;

public class GenereDaoSingleton {
    private volatile static GenereDao instance;

    public static GenereDao getInstance(){
        if(instance == null){
            synchronized (GenereDaoSingleton.class){
                if(instance == null){
                    instance = new GenereDao();
                }
            }
        }
        return instance;
    }

}
