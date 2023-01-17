package dto;

import java.util.Arrays;
import java.util.Objects;

public class VoteDTO {
    private int singers;
    private int[] jenres;
    private String information;

    public VoteDTO(int idSingers, int[] idJenres, String Information) {
        this.singers = idSingers;
        this.jenres = idJenres;
        this.information = Information;
    }

    public int getSingers() {
        return singers;
    }

    public int[] getJenres() {
        return jenres;
    }

    public String getInformation() {
        return information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteDTO voteDTO = (VoteDTO) o;
        return singers == voteDTO.singers && Arrays.equals(jenres, voteDTO.jenres) && Objects.equals(information, voteDTO.information);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(singers, information);
        result = 31 * result + Arrays.hashCode(jenres);
        return result;
    }

    @Override
    public String toString() {
        return "VoteDTO{" +
                "Singers: " + singers +
                ", Jenres: " + Arrays.toString(jenres) +
                ", Information: ='" + information + '\'' +
                '}';
    }

    public static class VoteDTOBuilder {
        private int singers;
        private int[] jenres = new int[0];
        private String information;

        private VoteDTOBuilder() {
        }

        public static VoteDTOBuilder create() {
            return new VoteDTOBuilder();
        }

        public static VoteDTOBuilder init() {
            return new VoteDTOBuilder();
        }

        public VoteDTOBuilder setSingers(int singers) {
            this.singers = singers;
            return this;
        }

        public VoteDTOBuilder setJenres(int[] jenres) {
            this.jenres = jenres;
            return this;
        }

        public VoteDTOBuilder addJenres(int jenres) {
            this.jenres = Arrays.copyOf(this.jenres, this.jenres.length + 1);
            this.jenres[this.jenres.length - 1] = jenres;
            return this;
        }

        public VoteDTOBuilder addJenres(String jenres) {
            return addJenres(Integer.parseInt(jenres));
        }

        public VoteDTOBuilder setInformation(String Information) {
            this.information = Information;
            return this;
        }

        public VoteDTO build() {
            return new VoteDTO(singers, jenres, information);
        }
    }

}
