import io.damienevrard.tp4.MultiplayerBowling;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
/**
 *
 * @author damie
 */
public class MultyplayerTest {
    
    private static MultiplayerBowling game;
    private static String[] playersName; 
    
    @BeforeClass
    public static void setUp() {
		game = new MultiplayerBowling();
                playersName = new String[]{"Pierre","Paul","Jack"};
    }
    
    @Before
    public void setGame() {
		game.startNewGame(playersName);
    }
    
    @Test
    public void testCrea() {
		
		assertEquals("partie initialisé avec 3 joueurs", game.startNewGame(playersName)); 
    }
    
    @Test
    public void test1tour() {
		game.lancer(1);
                game.lancer(5);
		assertEquals(6, game.scoreFor(playersName[0]));
                game.lancer(2);
                game.lancer(3);
		assertEquals(5, game.scoreFor(playersName[1]));
                game.lancer(3);
                game.lancer(4);
		assertEquals(7, game.scoreFor(playersName[2])); 
    }
    
    @Test
    public void test1Strike() {
                game.lancer(10);
                game.lancer(10);
                game.lancer(10);
                for(String player :playersName){
                    assertEquals(10, game.scoreFor(player));
                }
    }
    
    
    @Test
    public void test1Spear() {
                game.lancer(5);
                assertEquals("joueur "+playersName[0]+" a fait un Spear \nprochain joueur "+playersName[(0+1) % playersName.length]+"\n",game.lancer(5));
		
                game.lancer(2);
                game.lancer(8);
                
                game.lancer(6);
                game.lancer(4); 
                for(String player :playersName){
                    assertEquals(10, game.scoreFor(player));
                }
    }
    
    @Test
    public void testAllStrike() {
                for(int i =0;i<36;i++){
                    game.lancer(10);
                }
                for(String player :playersName){
                    assertEquals(300, game.scoreFor(player));
                }
    }
    
    
}
