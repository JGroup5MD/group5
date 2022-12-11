package dao;

import dao.api.IJenreDao;
import dto.JenreDTO;


import java.util.ArrayList;
import java.util.List;

public class JenreDao implements IJenreDao {
    private List <JenreDTO> jenres=new ArrayList<>();
    private JenreDao(List <JenreDTO> jenres) {
        this.jenres=jenres;
    }

    public JenreDao() {
        this.jenres.add(new JenreDTO(1, "Rock"));
        this.jenres.add(new JenreDTO(2, "Jazz"));
        this.jenres.add(new JenreDTO(3, "Pop"));
        this.jenres.add(new JenreDTO(4, "Classic"));
        this.jenres.add(new JenreDTO(5, "Alternative"));
        this.jenres.add(new JenreDTO(6, "Country"));
        this.jenres.add(new JenreDTO(7, "Lullaby"));
        this.jenres.add(new JenreDTO(8, "J-Rock"));
        this.jenres.add(new JenreDTO(9, "K-POP"));
        this.jenres.add(new JenreDTO(10, "Drumm'n'bass"));
    }

    @Override
    public List<JenreDTO> get() {
        return jenres;
    }

    @Override
    public boolean exist(String jenreName) {
        List <JenreDTO> jenreDTOS=get();
        for (JenreDTO jenreDTO:jenreDTOS){
            if (jenreName.equals(jenreDTO.getJenreName())){
                return true;
            }
        }
        return false;
    }
}
