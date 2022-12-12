package dao.api;

import dto.SaveInformationDTO;

public interface IVoteDao {
    void save(SaveInformationDTO vote);
}
