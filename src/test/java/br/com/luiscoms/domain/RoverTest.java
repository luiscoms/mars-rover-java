package br.com.luiscoms.domain;

import br.com.luiscoms.constant.Direction;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RoverTest {
    @Test
    public void shouldGetNorthDirectionWhenInstantiateDefaultRover() throws Exception {
        // given a rover
        Rover rover = new Rover();
        // when I get its direction
        Direction direction = rover.getDirection();
        // than I expect that it is NORTH
        assertThat(direction).isEqualTo(Direction.NORTH);
    }
}
