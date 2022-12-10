package dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class StatisticDTO {
    private LocalDateTime initForInformation;
    private VoteDTO vote;

    public StatisticDTO(LocalDateTime initForInformation, VoteDTO vote) {
        this.initForInformation = initForInformation;
        this.vote = vote;
    }
    public StatisticDTO(VoteDTO vote) {
        this.initForInformation = LocalDateTime.now();
        this.vote = vote;
    }

    public LocalDateTime getInitForInformation() {
        return initForInformation;
    }

    public void setInitForInformation(LocalDateTime initForInformation) {
        this.initForInformation = initForInformation;
    }

    public VoteDTO getVote() {
        return vote;
    }

    public void setVote(VoteDTO vote) {
        this.vote = vote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatisticDTO that = (StatisticDTO) o;
        return Objects.equals(initForInformation, that.initForInformation) && Objects.equals(vote, that.vote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initForInformation, vote);
    }

    @Override
    public String toString() {
        return "StatisticDTO{" +
                "initForInformation: " + initForInformation +
                ", vote: " + vote +
                '}';
    }
}
