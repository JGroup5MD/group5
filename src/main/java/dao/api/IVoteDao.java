package dao.api;

import dto.SaveInformationDTO;

import java.util.List;

public interface IVoteDao {
    void save(SaveInformationDTO vote);

    List<SaveInformationDTO> get();
}
