package ma.enset.QLearning.sma;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.util.leap.ArrayList;
import jade.util.leap.List;

import java.util.Random;

public class qlearningAgent extends Agent {
    private final double ALPHA=0.1;
    private final double GAMMA=0.9;
    private final int MAX_EPOCH=200;
    private final int GRID_SIZE=4;
    private final int ACTION_SIZE=4;
    private int state_I;
    private int state_J;

    private int [][]grid=new int[GRID_SIZE][GRID_SIZE];
    private double [][]qtable=new double[GRID_SIZE*GRID_SIZE][ACTION_SIZE];
    private int [][]actions;
    private     List tab=new ArrayList();

    public void setup(){
        actions=new int[][]{
                {0,-1},//left
                {0,1},//right
                {1,0},//bottom
                {-1,0}//top
        };
        grid=new int[][]{
                {1,0,0,1},
                {-1,0,0,-1},
                {0,0,0,0},
                {0,0,0,0}
        };


        addBehaviour(new Behaviour() {
            @Override
            public void action() {


                    int iter=0;
                    int currentState;
                    int nextState;
                    while(iter<MAX_EPOCH){
                        resetState();
                        while(!finished()){

                            currentState=state_I*GRID_SIZE+state_J;
                            int act = choiceAction(0.4);
                            nextState = executeAction(act);
                            int act1=choiceAction(0);
                            qtable[currentState][act]=qtable[currentState][act]+ALPHA*(grid[state_I][state_J]+GAMMA*qtable[nextState][act1]-qtable[currentState][act]);

                        }
                        iter++;
                    }
                    showResult();

               ACLMessage aclMessage=new ACLMessage();
               aclMessage.addReceiver(new AID("superagent",AID.ISLOCALNAME));
               aclMessage.setContent(tab.toString());
               send(aclMessage);

                }


            @Override
            public boolean done() {
                return true;
            }
        });
    }

    private void resetState(){
        state_I=3;
        state_J=3;

    }
    private int choiceAction(double eps){
        //Exploration
        Random rnd=new Random();
        double bestQvalue=0;
        int act = 0;
        if(rnd.nextDouble()<eps){
            return rnd.nextInt(ACTION_SIZE);

        }
        else{
            //Exploitation
            int bestAction = 0;
            for (int action = 1; action < ACTION_SIZE; action++) {
                if (qtable[state_I*GRID_SIZE+state_J][action] > qtable[state_I*GRID_SIZE+state_J][bestAction]) {
                    bestAction = action;
                }
            }
            return bestAction;
        }


    }
    private void showResult(){
        // Affichage de la table de Q-valeurs
        for (int i = 0; i < GRID_SIZE*GRID_SIZE; i++) {
            for (int j = 0; j < ACTION_SIZE; j++) {
                System.out.printf("Q(%d, %d) = %.2f%n", i, j, qtable[i][j]);
            }
        }
        System.out.println("");
        resetState();
        System.out.print("Path :");


        while (!finished()){
            int action = choiceAction(0);
            System.out.print((state_I*GRID_SIZE+state_J)+" --> ");
            tab.add(state_I*GRID_SIZE+state_J);
            executeAction(action);


        }
        System.out.println(state_I*GRID_SIZE+state_J);
        tab.add(state_I*GRID_SIZE+state_J);
    }
    public boolean finished(){
        return grid[state_I][state_J]==1;
    }
    public int executeAction(int act ){
        state_I=Math.max(0,Math.min(actions[act][0]+state_I,3));
        state_J=Math.max(0,Math.min(actions[act][1]+state_J,3));
        return state_I*GRID_SIZE+state_J;
    }


}
