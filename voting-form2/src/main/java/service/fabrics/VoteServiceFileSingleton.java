package service.fabrics;

import dao.api.IVotingDao;
import dto.VoteDTO;
import service.VoteService;

public class VoteServiceFileSingleton {
    private volatile static VoteService instance;

    public static VoteService getInstance() {
        if (instance == null) {
            synchronized (VoteServiceFileSingleton.class) {
                if (instance == null) {
                    instance = new VoteService(new IVotingDao() {
                        @Override
                        public void save(VoteDTO vote) {

                        }
                    });
                }
            }
        }
        return instance;
    }
}
