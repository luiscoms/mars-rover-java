package br.com.luiscoms.domain;

import br.com.luiscoms.constant.Direction;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Rover implements Obstacle {
    @NonNull
    private Direction direction;

    public Rover() {
        this(Direction.NORTH);
    }
}
