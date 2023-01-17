package dao;

import dao.api.IVoteDao;
import dto.SaveInformationDTO;

import java.util.ArrayList;
import java.util.List;

public class VoteDaoSQL implements IVoteDao {
    private List<SaveInformationDTO>  svDTO = new ArrayList<>();

    @Override
    public void save(SaveInformationDTO vote) {
        this.svDTO.add(vote);
    }
}