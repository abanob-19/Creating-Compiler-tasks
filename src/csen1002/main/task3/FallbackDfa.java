package csen1002.main.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

public class FallbackDfa {

	/**
	 * Constructs a Fallback DFA
	 *
	 * @param fdfa A formatted string representation of the Fallback DFA. The string
	 * representation follows the one in the task description
	 */


	String transitions[];
	String initialState;
	String acceptStatesArray[];
	int left = 0;
	int right = 0;
	int possibleEndState;
	HashMap<Integer, HashMap<String, Integer>> singleTransition = new HashMap<Integer, HashMap<String, Integer>>();
	Stack<Integer> controllingStack = new Stack<Integer>();

	public FallbackDfa(String fdfa) {
		// TODO Auto-generated constructor stub
		String[] split = fdfa.split("#");
		transitions = split[2].split(";");
		initialState = split[3];
		acceptStatesArray = split[4].split(";");
		makeSingleTransitionTable();
	}

	private void makeSingleTransitionTable() {
		for (String transition : transitions) {
			String[] split = transition.split(",");
			if (singleTransition.containsKey(Integer.parseInt(split[0]))) {
				HashMap<String, Integer> oldTransitions = singleTransition.get(Integer.parseInt(split[0]));
				oldTransitions.put(split[1], Integer.parseInt(split[2]));
				singleTransition.put(Integer.parseInt(split[0]), oldTransitions);
			} else {
				HashMap<String, Integer> newTransitionTable = new HashMap<>();
				newTransitionTable.put(split[1], Integer.parseInt(split[2]));
				singleTransition.put(Integer.parseInt(split[0]), newTransitionTable);
			}
		}
	}

	/**
	 * @param input The string to simulate by the FDFA.
	 * @return Returns a formatted string representation of the list of tokens. The
	 * string representation follows the one in the task description
	 */
	public String run(String input) {
		// TODO Auto-generated method stub
		String output="";
		while(left<input.length()){
			controllingStack.push(Integer.parseInt(initialState));
			while (left < input.length()) {
				controllingStack.push(singleTransition.get(controllingStack.peek()).get(input.charAt(left) + ""));
				left++;
			}
			if (checkstateExistInAcceptStates(controllingStack.peek())) {
				output += input.substring(right, left) + "," + controllingStack.peek() + ";";
			} else {
				possibleEndState = controllingStack.peek();
				while (!controllingStack.isEmpty() && !checkstateExistInAcceptStates(controllingStack.peek())) {
					controllingStack.pop();
					left--;
				}
				if (controllingStack.isEmpty()) {
					output += input.substring(right) + "," + possibleEndState + ";";
					break;
				} else if (checkstateExistInAcceptStates(controllingStack.peek())) {
					left--;
					output += input.substring(right, left + 1) + "," + controllingStack.pop() + ";";
					controllingStack = new Stack<Integer>();
					left++;
					right = left;
				}
			}
		}
		left=0;
		right=0;
		controllingStack = new Stack<Integer>();
		return output.substring(0, output.length() - 1);
	}
	private boolean checkstateExistInAcceptStates(int state){
		for (int i = 0; i < acceptStatesArray.length; i++) {
			if (state == Integer.parseInt(acceptStatesArray[i])) {
				return true;
			}
		}
		return false;
	}
}