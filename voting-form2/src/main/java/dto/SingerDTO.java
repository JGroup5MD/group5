package dto;

import java.util.Objects;

public class SingerDTO {
    private String SingerName;
    private int IdSinger;

    public SingerDTO(String singerName, int IdSinger) {
        SingerName = singerName;
        this.IdSinger = IdSinger;
    }

    public String getSingerName() {
        return SingerName;
    }

    public int getID() {
        return IdSinger;
    }

    public void setSingerName(String singerName) {
        SingerName = singerName;
    }

    public void setID(int IdSinger) {
        this.IdSinger = IdSinger;
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
        return Objects.hash(SingerName, IdSinger);
    }

    @Override
    public String toString() {
        return "Singers{" + IdSinger + " : " + SingerName + "}";
    }
}
