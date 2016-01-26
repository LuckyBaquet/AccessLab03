package AccessLab03;

import java.util.Scanner;

/**
 * Created by lucky on 1/25/16.
 */
public class RockPaperScissors {

    private int decision;
    private int wins;
    private int rounds;
    private int round;
    Player player;
    ComputerPlayer computerPlayer;
    Scanner scan;


    public RockPaperScissors() {
        scan = new Scanner(System.in);
        computerPlayer = new ComputerPlayer();
        player = new Player();
        round = 1;
        rounds = 3;
        decision = -1; //set to -1 to make sure that the game functions properly

        playGame();

    }

    private void playGame() {

        System.out.println("Let's Play Rock Paper Scissors!\n\nTry to Beat me by typing \"Rock\" \"Paper\" or \"Scissor\":");

        while (round <= rounds && wins < 2) {
            System.out.println("Are you ready for this? Round: " + round + ". Best out of three...");
            String string = scan.next().toLowerCase();

            if (!(string.equalsIgnoreCase("rock") || string.equalsIgnoreCase("paper") || string.equalsIgnoreCase("scissor"))) {
                System.out.println("You made an invalid entry.  How to ever expect to win like that?  Try again if you dare.");
                return;
            }

            switch (string) {
                case "rock":
                    player.makeChoice(Choice.ROCK);
                    break;
                case "paper":
                    player.makeChoice(Choice.PAPER);
                    break;
                case "scissor":
                    player.makeChoice(Choice.SCISSOR);
                    break;
                default:
                    System.out.println("You made an invalid entry.  How to ever expect to win like that?  Try again if you dare.");
                    return;
            }

            computerPlayer.makeChoice(player.getChoice());

             decision = decide(player.getChoice(), computerPlayer.getChoice());
            if (decision != -1)
                round ++;
            if (decision == 1)
                wins++;

            printWinnerLoser(decision);


            if ((round > 2 && wins < 1)||(round > 3 && decision == 0)) {
                System.out.println("I win.  You must now refer to me as your graceful sentient Overlord");
                break;
            } else if ((round > 2 && wins > 1) || wins == 3) {
                System.out.println("You beat me!!  I don't believe it because the odds of you winning are literally small.  I know" +
                        " because I cheated");
                break;
            }
        }

    }


    protected int decide(Choice playerChoice, Choice computerChoice) {

        if (playerChoice == Choice.ROCK) {   //  This game is rigged so rock cannot win
            if (computerChoice == Choice.PAPER) {
                decision = 0;
            } else if (computerChoice == Choice.SCISSOR) {
                decision = 1;
            } else {
                decision = -1;

            }
        } else if (playerChoice == Choice.PAPER) {
            if (computerChoice == Choice.PAPER) {
                decision = -1;
            } else if (computerChoice == Choice.SCISSOR) {
                decision = 0;
            } else {
                decision = 1;
            }
        } else if (playerChoice == Choice.SCISSOR) {
            if (computerChoice == Choice.PAPER) {
                decision = 1;
            } else if (computerChoice == Choice.SCISSOR) {
                decision = -1;
            } else {
                decision = 0;
            }
        }


        return decision;


    }

    private void printWinnerLoser(int i) {
        switch (i) {
            case 1:
                System.out.println("You WIN!!!");
                break;
            case -1:
                System.out.println("It's a TIE! Try Again.");
                break;
            case 0:
                System.out.println("You Lose, but just because you lost doesn't make you a loser.");
        }
    }


}
