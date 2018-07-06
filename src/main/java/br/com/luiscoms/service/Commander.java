package br.com.luiscoms.service;

import br.com.luiscoms.domain.Coordinates;
import br.com.luiscoms.constant.Direction;
import br.com.luiscoms.domain.Planet;
import br.com.luiscoms.domain.Rover;
import br.com.luiscoms.exception.InvalidCoordinates;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Commander {
    private final Rover rover;
    private final Planet planet;
    private Coordinates coordinates;

    public void moveForward() throws InvalidCoordinates {
        // get rover coordinates
        // update coordinates
        Coordinates destination = getForwardCoordinates();
        if (getPlanet().isEmpty(destination)) {
            // set new coordinates
            getPlanet().setObstacle(rover, destination);
            // remove rover from old coordinates
            getPlanet().unsetObstacle(coordinates);
            coordinates = destination;
        }
    }

    public void moveBackward() throws InvalidCoordinates {
        // get rover coordinates
        // update coordinates
        Coordinates destination = getBackwardCoordinates();
        if (getPlanet().isEmpty(destination)) {
            // set new coordinates
            getPlanet().setObstacle(rover, destination);
            // remove rover from old coordinates
            getPlanet().unsetObstacle(coordinates);
            coordinates = destination;
        }
    }

    private Coordinates getForwardCoordinates() {
        if (rover.getDirection() == Direction.EAST) {
            return new Coordinates(coordinates.x + (coordinates.x + 1 > getPlanet().getXBound() ? -coordinates.x : 1), coordinates.y);
        }
        if (rover.getDirection() == Direction.WEST) {
            return new Coordinates(coordinates.x - (coordinates.x - 1 < 0 ? -getPlanet().getXBound() : 1), coordinates.y);
        }
        if (rover.getDirection() == Direction.NORTH) {
            return new Coordinates(coordinates.x, coordinates.y - (coordinates.y - 1 < 0 ? -getPlanet().getYBound() : 1));
        }
        if (rover.getDirection() == Direction.SOUTH) {
            return new Coordinates(coordinates.x, coordinates.y + (coordinates.y + 1 > getPlanet().getYBound() ? -coordinates.y : 1));
        }
        return null;
    }

    private Coordinates getBackwardCoordinates() {
        if (rover.getDirection() == Direction.EAST) {
            return new Coordinates(coordinates.x - (coordinates.x - 1 > -1 ? 1 : -getPlanet().getXBound()), coordinates.y);
        }
        if (rover.getDirection() == Direction.WEST) {
            return new Coordinates(coordinates.x + (coordinates.x + 1 > getPlanet().getXBound() ? -coordinates.x : 1), coordinates.y);
        }
        if (rover.getDirection() == Direction.NORTH) {
            return new Coordinates(coordinates.x, coordinates.y + (coordinates.y + 1 > getPlanet().getYBound() ? -coordinates.y : 1));
        }
        if (rover.getDirection() == Direction.SOUTH) {
            return new Coordinates(coordinates.x, coordinates.y - (coordinates.y - 1 > -1 ? 1 : -getPlanet().getYBound()));
        }
        return null;
    }

    @Builder(builderMethodName = "builder")
    public static Commander newCommander(Rover send, Planet to, Coordinates on) throws InvalidCoordinates {
        to.setObstacle(send, on);
        return new Commander(send, to, on);
    }
}
