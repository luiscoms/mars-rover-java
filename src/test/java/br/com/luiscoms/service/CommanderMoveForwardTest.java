package br.com.luiscoms.service;

import br.com.luiscoms.domain.Coordinates;
import br.com.luiscoms.constant.Direction;
import br.com.luiscoms.domain.Planet;
import br.com.luiscoms.domain.Rover;
import br.com.luiscoms.exception.InvalidCoordinates;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CommanderMoveForwardTest {

    private Planet planet;

    @Before
    public void beforeTest() {
        planet = new Planet("Mars", 10, 10);
    }

    @Test(expected = InvalidCoordinates.class)
    public void commandShouldThrowWhenInvalidPosition() throws InvalidCoordinates {
        // given a Commander
        // in an invalid position
        Commander.builder()
            .to(planet)
            .on(new Coordinates(10, 10))
            // when I build
            .build();
        // than I expect an exception
    }

    @Test
    public void shouldCommandRoverToMoveForwardEast() throws InvalidCoordinates {
        // given a Commander
        // and hover explore a planet
        // in a valid position
        Commander commander = Commander.builder()
            .send(new Rover(Direction.EAST))
            .to(planet)
            .on(new Coordinates(0, 0))
            .build();
        // when I command hover to move forward
        commander.moveForward();
        // than I expect that hover is on new position
        Coordinates newCoordinates = new Coordinates(1, 0);
        assertThat(commander.getPlanet().getCoordinates(newCoordinates)).isEqualTo(commander.getRover());
        // and update rover coordinates
        assertThat(commander.getCoordinates()).isEqualToComparingFieldByField(newCoordinates);
    }

    @Test
    public void shouldCommandRoverToMoveForwardWest() throws InvalidCoordinates {
        // given a Commander
        // and hover explore a planet
        // in a valid position
        Commander commander = Commander.builder()
            .send(new Rover(Direction.WEST))
            .to(planet)
            .on(new Coordinates(1, 0))
            .build();
        // when I command hover to move forward
        commander.moveForward();
        // than I expect that hover is on new position
        Coordinates newCoordinates = new Coordinates(0, 0);
        assertThat(commander.getPlanet().getCoordinates(newCoordinates)).isEqualTo(commander.getRover());
        // and update rover coordinates
        assertThat(commander.getCoordinates()).isEqualToComparingFieldByField(newCoordinates);
    }

    @Test
    public void shouldCommandRoverToMoveForwardNorth() throws InvalidCoordinates {
        // given a Commander
        // and hover explore a planet
        // in a valid position
        Commander commander = Commander.builder()
            .send(new Rover(Direction.NORTH))
            .to(planet)
            .on(new Coordinates(0, 1))
            .build();
        // when I command hover to move forward
        commander.moveForward();
        // than I expect that hover is on new position
        Coordinates newCoordinates = new Coordinates(0, 0);
        assertThat(commander.getPlanet().getCoordinates(newCoordinates)).isEqualTo(commander.getRover());
        // and update rover coordinates
        assertThat(commander.getCoordinates()).isEqualToComparingFieldByField(newCoordinates);
    }

    @Test
    public void shouldCommandRoverToMoveForwardSouth() throws InvalidCoordinates {
        // given a Commander
        // and hover explore a planet
        // in a valid position
        Commander commander = Commander.builder()
            .send(new Rover(Direction.SOUTH))
            .to(planet)
            .on(new Coordinates(0, 0))
            .build();
        // when I command hover to move forward
        commander.moveForward();
        // than I expect that hover is on new position
        Coordinates newCoordinates = new Coordinates(0, 1);
        assertThat(commander.getPlanet().getCoordinates(newCoordinates)).isEqualTo(commander.getRover());
        // and update rover coordinates
        assertThat(commander.getCoordinates()).isEqualToComparingFieldByField(newCoordinates);
    }

    @Test
    public void shouldCommandRoverToMoveForwardEastAroundThePlanet() throws InvalidCoordinates {
        // given a Commander
        // and hover explore a planet
        // in a valid position
        Commander commander = Commander.builder()
            .send(new Rover(Direction.EAST))
            .to(planet)
            .on(new Coordinates(9, 0))
            .build();
        // when I command hover to move forward
        commander.moveForward();
        // than I expect that hover is on new position
        Coordinates newCoordinates = new Coordinates(0, 0);
        assertThat(commander.getPlanet().getCoordinates(newCoordinates)).isEqualTo(commander.getRover());
        // and update rover coordinates
        assertThat(commander.getCoordinates()).isEqualToComparingFieldByField(newCoordinates);
    }

    @Test
    public void shouldCommandRoverToMoveForwardWestAroundThePlanet() throws InvalidCoordinates {
        // given a Commander
        // and hover explore a planet
        // in a valid position
        Commander commander = Commander.builder()
            .send(new Rover(Direction.WEST))
            .to(planet)
            .on(new Coordinates(0, 0))
            .build();
        // when I command hover to move forward
        commander.moveForward();
        // than I expect that hover is on new position
        Coordinates newCoordinates = new Coordinates(9, 0);
        assertThat(commander.getPlanet().getCoordinates(newCoordinates)).isEqualTo(commander.getRover());
        // and update rover coordinates
        assertThat(commander.getCoordinates()).isEqualToComparingFieldByField(newCoordinates);
    }

    @Test
    public void shouldCommandRoverToMoveForwardNorthAroundThePlanet() throws InvalidCoordinates {
        // given a Commander
        // and hover explore a planet
        // in a valid position
        Commander commander = Commander.builder()
            .send(new Rover(Direction.NORTH))
            .to(planet)
            .on(new Coordinates(0, 0))
            .build();
        // when I command hover to move forward
        commander.moveForward();
        // than I expect that hover is on new position
        Coordinates newCoordinates = new Coordinates(0, 9);
        assertThat(commander.getPlanet().getCoordinates(newCoordinates)).isEqualTo(commander.getRover());
        // and update rover coordinates
        assertThat(commander.getCoordinates()).isEqualToComparingFieldByField(newCoordinates);
    }

    @Test
    public void shouldCommandRoverToMoveForwardSouthAroundThePlanet() throws InvalidCoordinates {
        // given a Commander
        // and hover explore a planet
        // in a valid position
        Commander commander = Commander.builder()
            .send(new Rover(Direction.SOUTH))
            .to(planet)
            .on(new Coordinates(0, 9))
            .build();
        // when I command hover to move forward
        commander.moveForward();
        // than I expect that hover is on new position
        Coordinates newCoordinates = new Coordinates(0, 0);
        assertThat(commander.getPlanet().getCoordinates(newCoordinates)).isEqualTo(commander.getRover());
        // and update rover coordinates
        assertThat(commander.getCoordinates()).isEqualToComparingFieldByField(newCoordinates);
    }
}
