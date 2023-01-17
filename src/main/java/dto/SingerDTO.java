package dto;

import java.util.Objects;

public class SingerDTO {
    private int idSinger;
    private String singerName;

    public SingerDTO(int idSinger, String singerName) {
        this.idSinger = idSinger;
        this.singerName = singerName;
    }

    public int getIdSinger() {
        return idSinger;
    }

    public void setIdSinger(int idSinger) {
        this.idSinger = idSinger;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerDTO singerDTO = (SingerDTO) o;
        return idSinger == singerDTO.idSinger && Objects.equals(singerName, singerDTO.singerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSinger, singerName);
    }

    @Override
    public String toString() {
        return "SingerDTO{" +
                "idSinger=" + idSinger +
                ", singerName='" + singerName + '\'' +
                '}';
    }
}
