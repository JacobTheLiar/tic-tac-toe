package pl.jacob_the_liar.tic_tac_toe.windowed;


import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.jacob_the_liar.tic_tac_toe.core.TicTacToe;

// https://code.i-harness.com/en/q/a07fba
// https://stackoverflow.com/questions/18717038/adding-resources-in-intellij-for-maven-project

public class TicTacToeButton extends Button {


    public TicTacToeButton(int index, TicTacToe game, Refresh refresh) {
        super();
        this.buttonTag = index;
        this.game = game;
        this.refresh = refresh;

        this.setGraphic(NONE_IMG);

        this.setOnAction(event -> {
            game.setMove(buttonTag);
            refresh.refreshControls();});
    }




    private final TicTacToe game;
    private final Refresh refresh;
    private final ImageView NONE_IMG = new ImageView(new Image("none.png"));
    private final ImageView CIRCLE_IMG = new ImageView(new Image("circle.png"));
    private final ImageView CROSS_IMG = new ImageView(new Image("cross.png"));
    private int buttonTag;



    public void tryExecute(int index){
        if (index == buttonTag){
            this.fire();
        }
    }

    public void setState(){
        if (!this.getGraphic().equals(getStateImage()))
            this.setGraphic(getStateImage());
    }




    private Node getStateImage() {
        switch (game.getFieldStatus(buttonTag)){
            case NONE: return NONE_IMG;
            case CIRCLE: return CIRCLE_IMG;
            case CROSS: return CROSS_IMG;
        }
        return NONE_IMG;
    }
    
}
