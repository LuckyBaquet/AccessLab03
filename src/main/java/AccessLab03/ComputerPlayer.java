package AccessLab03;

/**
 * Created by lucky on 1/25/16.
 */
public class ComputerPlayer {

    Choice choice;

    public Choice makeChoice(Choice choice){

        if(choice == Choice.ROCK) {
            this.choice = Choice.PAPER;
        }
        else{
         int i = (int)(Math.random()*3);
            if(i == 0)
                this.choice = Choice.ROCK;
             else if(i==1)
                this.choice = Choice.SCISSOR;
            else if (i==2)
                this.choice = Choice.PAPER;
        }

        return this.choice;
    }

    public Choice getChoice(){
        return this.choice;
    }


}
