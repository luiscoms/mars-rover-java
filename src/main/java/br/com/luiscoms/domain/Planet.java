package br.com.luiscoms.domain;

import br.com.luiscoms.exception.InvalidCoordinates;

public class Planet {
    private String name;
    private Obstacle[][] land;

    public Planet(String name, Integer sizeX, Integer sizeY) {
        land = new Obstacle[sizeX][sizeY];
        this.name = name;
    }

    private Boolean isValidCoordinates(Coordinates coordinates) {
        return coordinates.x >= 0 &&
            coordinates.y >= 0 &&
            land.length > coordinates.x && land[coordinates.x].length > coordinates.y;
    }

    public boolean isEmpty(Coordinates coordinates) throws InvalidCoordinates {
        return getCoordinates(coordinates) == null;
    }

    public int getXBound() {
        return land.length - 1;
    }

    public int getYBound() {
        return land[0].length - 1;
    }

    public Obstacle getCoordinates(Coordinates coordinates) throws InvalidCoordinates {
        if (isValidCoordinates(coordinates)) {
            return land[coordinates.x][coordinates.y];
        }
        throw new InvalidCoordinates("Invalid coordinates");
    }

    public void setObstacle(Obstacle obstacle, Coordinates coordinates) throws InvalidCoordinates {
        if (isEmpty(coordinates)) {
            land[coordinates.x][coordinates.y] = obstacle;
            return;
        }
        throw new InvalidCoordinates("Invalid coordinates");
    }

    public void unsetObstacle(Coordinates coordinates) throws InvalidCoordinates {
        if (isValidCoordinates(coordinates)) {
            land[coordinates.x][coordinates.y] = null;
            return;
        }
        throw new InvalidCoordinates("Invalid coordinates");
    }
}
