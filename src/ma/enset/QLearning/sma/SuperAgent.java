package ma.enset.QLearning.sma;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.util.*;


public class SuperAgent extends Agent {
    HashMap<Integer,List<Integer>> map=new HashMap<>();




    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour() {
            List<Integer> list=new ArrayList<>();
            int i=0;

            @Override
            public void action() {
                ACLMessage receivedMSG = receive();
                if (receivedMSG!=null){

                    String content = receivedMSG.getContent();
                    // Remove square brackets and whitespace
                    String[] elements = content.replace("[", "").replace("]", "").split(",");

                    List<Integer> listArray = new ArrayList<>();
                    for (String element : elements) {
                        int value = Integer.parseInt(element.trim());
                        listArray.add(value);
                    }


                    map.put(listArray.size(),listArray);
                    i++;
                    list.add(listArray.size());
                    Collections.sort(list);
                    if(i==2){
                        System.out.println(list);
                        System.out.println("Size :"+list.get(0));
                        System.out.print("Best Path : ");
                        for (int i=0;i<listArray.size()-1;i++){
                            System.out.print(listArray.get(i)+" --> ");
                        }
                        System.out.println(listArray.get(listArray.size()-1));
                    }

                }

                else {
                    block();

                }

            }


        });

    }
}
