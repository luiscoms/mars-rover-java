package br.com.luiscoms.domain;

import br.com.luiscoms.exception.InvalidCoordinates;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlanetTest {

    private Planet planet;

    @Before
    public void beforeTest() {
        planet = new Planet("Mars", 10, 10);
    }

    @Test
    public void shouldGetValidCoordinates() throws InvalidCoordinates {
        // given a planet with size 10x10
        // when I get a valid coordinates
        // and it does not have obstacle
        Obstacle position = planet.getCoordinates(new Coordinates(0, 0));
        // then I expect null
        assertThat(position).isNull();
    }

    @Test(expected = InvalidCoordinates.class)
    public void shouldGetInvalidXPositionNegative() throws InvalidCoordinates {
        // given a planet with size 10x10
        // when I get an invalid x position
        planet.getCoordinates(new Coordinates(-1, 0));
        // then I expect an exception
    }

    @Test(expected = InvalidCoordinates.class)
    public void shouldGetInvalidXPositionPositive() throws InvalidCoordinates {
        // given a planet with size 10x10
        // when I get an invalid x position
        planet.getCoordinates(new Coordinates(10, 0));
        // then I expect an exception
    }

    @Test(expected = InvalidCoordinates.class)
    public void shouldGetInvalidYPositionNegative() throws InvalidCoordinates {
        // given a planet with size 10x10
        // when I get an invalid x position
        planet.getCoordinates(new Coordinates(0, -1));
        // then I expect an exception
    }

    @Test(expected = InvalidCoordinates.class)
    public void shouldGetInvalidYPositionPositive() throws InvalidCoordinates {
        // given a planet with size 10x10
        // when I get an invalid x position
        planet.getCoordinates(new Coordinates(0, 10));
        // then I expect an exception
    }

    @Test(expected = InvalidCoordinates.class)
    public void shouldGetInvalidXAndYPosition() throws InvalidCoordinates {
        // given a planet with size 10x10
        // when I get an invalid x position
        planet.getCoordinates(new Coordinates(10, 10));
        // then I expect an exception
    }

    @Test
    public void shouldSetObstacleOnEmptyPosition() throws InvalidCoordinates {
        // given a planet with size 10x10
        // when I set an obstacle on an empty position
        Coordinates coordinates = new Coordinates(6, 6);
        Rover rover = new Rover();
        planet.setObstacle(rover, coordinates);
        // then I expect that position have that obstacle
        assertThat(planet.getCoordinates(coordinates)).isEqualTo(rover);
    }

    @Test(expected = InvalidCoordinates.class)
    public void shouldNotSetObstacleOnAnInvalidPosition() throws InvalidCoordinates {
        // given a planet with size 10x10
        // when I set an obstacle on an invalid position
        Coordinates coordinates = new Coordinates(10, 6);
        Rover rover = new Rover();
        planet.setObstacle(rover, coordinates);
        // then I expect that an exception
    }

    @Test(expected = InvalidCoordinates.class)
    public void shouldNotSetObstacleOnAnNonEmptyPosition() throws InvalidCoordinates {
        // given a planet with size 10x10
        // and I set an obstacle on an empty position
        Coordinates coordinates = new Coordinates(6, 6);
        Rover rover = new Rover();
        planet.setObstacle(rover, coordinates);
        // when I land an obstacle on an non empty position
        planet.setObstacle(rover, coordinates);
        // then I expect that an exception
    }

    @Test
    public void shouldUnsetObstacleOnAnEmptyPosition() throws InvalidCoordinates {
        // given a planet with size 10x10
        Coordinates coordinates = new Coordinates(6, 6);
        // when I unset an obstacle on an an empty position
        planet.unsetObstacle(coordinates);
        // then I expect that position is null
        Obstacle position = planet.getCoordinates(coordinates);
        assertThat(position).isNull();
    }

    @Test
    public void shouldUnsetObstacleOnAnNonEmptyPosition() throws InvalidCoordinates {
        // given a planet with size 10x10
        // and I set an obstacle on an empty position
        Coordinates coordinates = new Coordinates(6, 6);
        Rover rover = new Rover();
        planet.setObstacle(rover, coordinates);
        // when I unset an obstacle on an that position
        planet.unsetObstacle(coordinates);
        // then I expect that position is null
        Obstacle position = planet.getCoordinates(coordinates);
        assertThat(position).isNull();
    }

    @Test(expected = InvalidCoordinates.class)
    public void shouldNotUnsetObstacleOnAnInvalidPosition() throws InvalidCoordinates {
        // given a planet with size 10x10
        // and I set an obstacle on an empty position
        Coordinates coordinates = new Coordinates(10, 6);
        // when I unset an obstacle on an that position
        planet.unsetObstacle(coordinates);
        // then I expect an exception
    }
}
