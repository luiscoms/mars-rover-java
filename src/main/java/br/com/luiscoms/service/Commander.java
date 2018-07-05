package br.com.luiscoms.service;

import br.com.luiscoms.domain.Coordinates;
import br.com.luiscoms.constant.Direction;
import br.com.luiscoms.domain.Planet;
import br.com.luiscoms.domain.Rover;
import br.com.luiscoms.exception.InvalidCoordinates;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
public class Commander {
    private final Rover send;
    private final Planet to;
    private final Coordinates on;

    public void moveForward() {
        // get rover coordinates
        // update coordinates
        Coordinates destination = null;
        if (send.getDirection() == Direction.EAST) {
            destination = new Coordinates(on.x+(on.x+1 > getPlanet().getXBound() ? -on.x : 1), on.y);
        }
        if (send.getDirection() == Direction.WEST) {
            destination = new Coordinates(on.x-(on.x-1 < 0 ? -getPlanet().getXBound() : 1), on.y);
        }
        if (send.getDirection() == Direction.NORTH) {
            destination = new Coordinates(on.x, on.y-(on.y-1 < 0 ? -getPlanet().getYBound() : 1));
        }
        if (send.getDirection() == Direction.SOUTH) {
            destination = new Coordinates(on.x, on.y+(on.y+1 > getPlanet().getYBound() ? -on.y : 1));
        }
        try {
            // set new coordinates
            getPlanet().setObstacle(send, destination);
            // remove rover from old coordinates
            getPlanet().unsetObstacle(on);
        } catch (InvalidCoordinates invalidCoordinates) {
            invalidCoordinates.printStackTrace();
        }
    }

    public Planet getPlanet() {
        return to;
    }

    public Rover getHover() {
        return send;
    }

    @Builder(builderMethodName = "builder")
    public static Commander newCommander(Rover send, Planet to, Coordinates on) throws InvalidCoordinates {
        to.setObstacle(send, on);
        return new Commander(send, to, on);
    }

}
