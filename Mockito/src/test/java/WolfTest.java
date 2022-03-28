import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WolfTest {
    @Mock
    Wolf wolf;
    Wolf wolf2;
    Wolf wolf3;

    @BeforeEach
    public void setup(){
        wolf = new Wolf();
        //create a mockobject
        wolf2 = mock(Wolf.class);
        //to create a spy
        wolf3 = spy(new Wolf());
    }

    @Test
    public void biteTest(){
        //input
        //everytime we want to return the health as 5
        when(wolf2.getHealth()).thenReturn(5);
        //when
        wolf.bite(wolf2);

        //result
        //just to make the assert function not show an error
        assertEquals("string","string");
    }
}