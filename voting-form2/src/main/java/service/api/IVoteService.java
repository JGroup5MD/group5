package service.api;

import dto.SaveInformationDTO;
import dto.VoteDTO;

import java.util.List;

public interface IVoteService {
    void save(VoteDTO vote);
    public List<SaveInformationDTO> get();
}
