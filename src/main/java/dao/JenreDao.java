package dao;

import dao.api.IJenreDao;
import dto.JenreDTO;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JenreDao implements IJenreDao {
    private Map<Integer, JenreDTO> jenres = new HashMap<>();

    public JenreDao(Map<Integer, JenreDTO> jenres) {
        this.jenres = jenres;
    }

    public JenreDao() {
        JenreDTO jenreDTO = new JenreDTO(1, "Rock");
        this.jenres.put(jenreDTO.getIdJenre(), jenreDTO);
        this.jenres.put(2, new JenreDTO(2,"Jazz"));
        this.jenres.put(3, new JenreDTO(3, "Pop"));
        this.jenres.put(4, new JenreDTO(4, "Classic"));
        this.jenres.put(5, new JenreDTO(5, "Alternative"));
        this.jenres.put(6, new JenreDTO(6, "Country"));
        this.jenres.put(7, new JenreDTO(7, "Lullaby"));
        this.jenres.put(8, new JenreDTO(8,"J-Rock"));
        this.jenres.put(9, new JenreDTO(9, "K-POP"));
        this.jenres.put(10, new JenreDTO(10, "Drumm'n'bass"));
    }

    public JenreDTO get(int Idjenre){
        return this.jenres.get(Idjenre);
    }



    @Override
    public List<JenreDTO> get() {
        return new ArrayList<>(jenres.values());
    }

    @Override
    public boolean exist(int idJanre) {
        return this.jenres.get(idJanre) != null;
    }

}
