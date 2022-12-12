package dto;

import java.util.Arrays;
import java.util.Objects;

public class VoteDTO {
    private int IdSingers;
    private int[] IdJenres;
    private  String information;

    public VoteDTO(int idSingers, int[] idJenres, String information) {
        this.IdSingers = idSingers;
        this.IdJenres = idJenres;
        this.information = information;
    }

    public int getIdSingers() {
        return IdSingers;
    }

    public void setIdSingers(int idSingers) {
        IdSingers = idSingers;
    }

    public int[] getIdJenres() {
        return IdJenres;
    }

    public void setIdJenres(int[] idJenres) {
        IdJenres = idJenres;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteDTO voteDTO = (VoteDTO) o;
        return IdSingers == voteDTO.IdSingers && Arrays.equals(IdJenres, voteDTO.IdJenres) && Objects.equals(information, voteDTO.information);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(IdSingers, information);
        result = 31 * result + Arrays.hashCode(IdJenres);
        return result;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "IdSingers: " + IdSingers +
                ", IdJenres: " + Arrays.toString(IdJenres) +
                ", information: " + information + '\'' +
                '}';
    }
}
