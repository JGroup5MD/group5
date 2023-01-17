package dto;

import java.util.Objects;

public class JenreDTO {
    private int idJenre;
    private String jenreName;


    public JenreDTO(int IdJenre,String jenreName) {
        this.idJenre =IdJenre;
        this.jenreName = jenreName;
    }

    public String getJenreName() {
        return jenreName;
    }

    public void setIdJenre(int idJenre) {
        this.idJenre = idJenre;
    }

    public void setJenreName(String jenreName) {
        this.jenreName = jenreName;
    }

    public int getIdJenre() {
        return idJenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JenreDTO jenreDTO = (JenreDTO) o;
        return idJenre == jenreDTO.idJenre && Objects.equals(jenreName, jenreDTO.jenreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jenreName, idJenre);
    }

    @Override
    public String toString() {
        return "Jenres{" + idJenre + " : " + jenreName +"}";
    }
}
