package AccessLab03;

/**
 * Created by lucky on 1/25/16.
 */
public class Player {

    Choice choice;

    public Choice makeChoice(Choice choice){

        this.choice = choice;

        return choice;
    }


    public Choice getChoice(){
        return this.choice;
    }


}

