package dto;

import java.util.Objects;

public class JenreDTO {
    private int IdJenre;
    private String JenreName;


    public JenreDTO(int IdJenre,String jenreName) {
        this.IdJenre =IdJenre;
        this.JenreName = jenreName;
    }

    public String getJenreName() {
        return JenreName;
    }

    public int getIdJenre() {
        return IdJenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JenreDTO jenreDTO = (JenreDTO) o;
        return IdJenre == jenreDTO.IdJenre && Objects.equals(JenreName, jenreDTO.JenreName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(JenreName, IdJenre);
    }

    @Override
    public String toString() {
        return "Jenres{" + IdJenre + " : " + JenreName +"}";
    }
}
