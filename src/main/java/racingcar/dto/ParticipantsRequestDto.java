package racingcar.dto;

import racingcar.domain.car.Participants;

public class ParticipantsRequestDto {

    private final String[] names;

    public ParticipantsRequestDto(final String[] names) {
        this.names = names;
    }

    public Participants toEntity() {
        return Participants.createCars(this.names);
    }
}
