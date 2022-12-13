package dto;

import java.util.Objects;

public class SingerDTO {
    private int IdSinger;
    private String SingerName;

    public SingerDTO(int idSinger, String singerName) {
        IdSinger = idSinger;
        SingerName = singerName;
    }

    public int getIdSinger() {
        return IdSinger;
    }

    public void setIdSinger(int idSinger) {
        IdSinger = idSinger;
    }

    public  String getSingerName() {
        return SingerName;
    }

    public void setSingerName(String singerName) {
        SingerName = singerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerDTO singerDTO = (SingerDTO) o;
        return IdSinger == singerDTO.IdSinger && Objects.equals(SingerName, singerDTO.SingerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdSinger, SingerName);
    }

}
