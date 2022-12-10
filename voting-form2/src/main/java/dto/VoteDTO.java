package dto;

import java.util.Arrays;
import java.util.Objects;

public class VoteDTO {
    private int IdSingers;
    private int[] IdJenres;
    private  String information;
    private int IdInformation;
    public  VoteDTO(int IdSingers, int[] IdJenres, String information,int IdInformation){
        this.IdSingers=IdSingers;
        this.IdJenres=IdJenres;
        this.information=information;
        this.IdInformation=IdInformation;
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

    public int getIdInformation() {
        return IdInformation;
    }

    public void setIdInformation(int idInformation) {
        IdInformation = idInformation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteDTO voteDTO = (VoteDTO) o;
        return IdSingers == voteDTO.IdSingers && IdInformation == voteDTO.IdInformation && Arrays.equals(IdJenres, voteDTO.IdJenres) && Objects.equals(information, voteDTO.information);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(IdSingers, information, IdInformation);
        result = 31 * result + Arrays.hashCode(IdJenres);
        return result;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "IdSingers:" + IdSingers +
                ", IdJenres:" + Arrays.toString(IdJenres) +
                ", information:'" + information + '\'' +
                ", IdInformation:" + IdInformation +
                '}';
    }
}
