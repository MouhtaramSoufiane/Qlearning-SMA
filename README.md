# Qlearning-SMA

Q-learning is a reinforcement learning algorithm that can be applied in a multi-agent system (MAS) to enable agents to learn optimal policies through interactions with the environment. In a multi-agent setting, Q-learning can be used to train individual agents to make decisions based on their observations and rewards, considering the actions and policies of other agents in the environment.
## Steps
1-State and Action Spaces: Define the state space and action space for each agent. The state space represents the observable aspects of the environment, and the action space includes the possible actions that an agent can take.

2-Q-Table: Initialize a Q-table for each agent, which is a data structure that maps states and actions to their corresponding Q-values. Initially, the Q-table is typically populated with random or zero values.

3-Interaction with the Environment: Agents take turns interacting with the environment, where they observe the current state, select an action based on an exploration-exploitation trade-off strategy (e.g., epsilon-greedy), and execute the action.

4-Reward and State Transition: After executing an action, the agent receives a reward from the environment and transitions to the next state. The reward reflects the desirability or success of the agent's action.

5-Update Q-Table: The agent updates its Q-table based on the observed reward and the transition from the current state to the next state. The Q-value of the selected action is updated using the Q-learning update rule, which incorporates the reward, the maximum Q-value of the next state, and a learning rate.

6-Repeat Steps 3-5: The interaction with the environment, observation of rewards, and Q-table updates continue for a number of episodes or until convergence.
## Our Grid
![sma](https://github.com/MouhtaramSoufiane/Qlearning-SMA/assets/104082651/cbbf6a48-7034-4c09-ad90-50a042898159)

### The first Agent generate this Path like you see in the screenshot 
![image](https://github.com/MouhtaramSoufiane/Qlearning-SMA/assets/104082651/84f92f5f-2270-4e6c-b250-3a690d8b6ad8)
### The second Agent generate this Path like you see in the screenshot 
![image](https://github.com/MouhtaramSoufiane/Qlearning-SMA/assets/104082651/b25d4626-1fd9-46a1-ae0c-d755bfab505b)
### The Main Agent (Super Agent ) choice the small path between the two paths
![image](https://github.com/MouhtaramSoufiane/Qlearning-SMA/assets/104082651/bb583225-5210-4fe4-aec1-598a74ad3d28)
