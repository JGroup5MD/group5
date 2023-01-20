package dao.fabric;

import service.StartDAtaBase;

public class StartDBSingleton {


        private volatile static StartDAtaBase instance;
        public static StartDAtaBase getInstance(){
            if(instance == null){
                synchronized (StartDBSingleton.class){
                    if(instance == null){
                        instance = new StartDAtaBase();
                    }
                }
            }
            return instance;
        }
    }

