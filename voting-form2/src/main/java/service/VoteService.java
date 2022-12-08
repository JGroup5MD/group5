package service;

import dao.api.IVotingDao;
import dto.VoteDTO;
import service.api.IVoteService;

public class VoteService implements IVoteService {
    private final IVotingDao dao;

    public VoteService(IVotingDao dao) {
        this.dao = dao;
    }

    @Override
    public void save(VoteDTO vote) {

    }


}
