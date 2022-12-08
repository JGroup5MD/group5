package dao.api;

import dto.VoteDTO;

public interface IVotingDao {
    void save(VoteDTO vote);
}
