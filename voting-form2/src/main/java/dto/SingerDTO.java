package dto;

import java.util.Objects;

public class SingerDTO {
    private String SingerName;
    private int ID;

    public SingerDTO(String singerName, int ID) {
        SingerName = singerName;
        this.ID = ID;
    }

    public String getSingerName() {
        return SingerName;
    }

    public int getID() {
        return ID;
    }

    public void setSingerName(String singerName) {
        SingerName = singerName;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SingerDTO singerDTO = (SingerDTO) o;
        return ID == singerDTO.ID && Objects.equals(SingerName, singerDTO.SingerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(SingerName, ID);
    }

    @Override
    public String toString() {
        return "Singers{" + ID + " : " + SingerName + "}";
    }
}
