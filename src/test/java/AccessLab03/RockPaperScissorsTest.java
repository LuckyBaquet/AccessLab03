package AccessLab03;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by lucky on 1/25/16.
 */
public class RockPaperScissorsTest {


    @Test
    public void rockPaperScissorsTest(){

        ComputerPlayer cp = new ComputerPlayer();
        cp.makeChoice(Choice.ROCK);

        Player p = new Player();
        p.makeChoice(Choice.ROCK);

        RockPaperScissors rps = new RockPaperScissors();
        int decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == -1);

        cp.makeChoice(Choice.ROCK);
        p.makeChoice(Choice.PAPER);
        decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == 1);

        cp.makeChoice(Choice.PAPER);
        p.makeChoice(Choice.SCISSOR);
        decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == 1);

        cp.makeChoice(Choice.ROCK);
        p.makeChoice(Choice.PAPER);
        decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == 1);

        cp.makeChoice(Choice.SCISSOR);
        p.makeChoice(Choice.PAPER);
        decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == 0);

        cp.makeChoice(Choice.SCISSOR);
        p.makeChoice(Choice.SCISSOR);
        decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == -1);

        cp.makeChoice(Choice.PAPER);
        p.makeChoice(Choice.PAPER);
        decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == -1);

        cp.makeChoice(Choice.PAPER);
        p.makeChoice(Choice.ROCK);
        decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == 0);

        cp.makeChoice(Choice.SCISSOR);
        p.makeChoice(Choice.ROCK);
        decision = rps.decide(p.getChoice(),cp.getChoice());

        assertTrue(decision == 1);



    }


}
