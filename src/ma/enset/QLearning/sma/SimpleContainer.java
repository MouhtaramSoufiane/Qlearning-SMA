package ma.enset.QLearning.sma;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;


public class SimpleContainer {
    public static void main(String[] args) throws StaleProxyException {
        Runtime runtime=Runtime.instance();
        ProfileImpl profile=new ProfileImpl();
        profile.setParameter(Profile.MAIN_HOST,"localhost");
        AgentContainer agentContainer = runtime.createAgentContainer(profile);
        AgentController mainAgent=null;

        mainAgent = agentContainer.createNewAgent("ql1", qlearningAgent.class.getName(), new Object[]{});
        mainAgent.start();



//         mainAgent = agentContainer.createNewAgent("superagent", SuperAgent.class.getName(), new Object[]{});
//        mainAgent.start();


    }
}
