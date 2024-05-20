package csen1002.main.task2;

import java.util.*;

/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

public class NfaToDfa {

	/**
	 * Constructs a DFA corresponding to an NFA
	 *
	 * @param input A formatted string representation of the NFA for which an
	 *              equivalent DFA is to be constructed. The string representation
	 *              follows the one in the task description
	 */
	String alphabetSemiColon;
	String alphabet [];
	String states [];
	String transitions [];
	String initialState;
	String acceptState;
	HashMap <Integer,List<Integer>> e_closure = new HashMap<Integer,List<Integer>>();
	HashMap<Integer,HashMap<String,List<Integer>>> singleTransition = new HashMap<Integer,HashMap<String,List<Integer>>> ();
	List<List<Integer>> dfaStates = new ArrayList<>();
	List<List<Integer>> dfaStatesNotSorted = new ArrayList<>();
	HashMap<List<Integer>,HashMap<String,List<Integer>>> dfaTransitions = new HashMap<>();
	public NfaToDfa(String input) {
		// TODO Auto-generated constructor stub
		String[] split = input.split("#");
		alphabetSemiColon = split[1];
		alphabet = split[1].split(";");
		states = split[0].split(";");
		transitions = split[2].split(";");
		initialState = split[3];
		acceptState = split[4];
		makeE_closure();
		makeSingleTransitionTable();
	}
	private void makeE_closure() {
		for (int i = 0; i < states.length; i++){
			List<Integer> initial = new ArrayList<>();
			initial.add(Integer.parseInt(states[i]));
			e_closure.put(i,initial);
		}
		for(String transition : transitions) {
			String[] split = transition.split(",");
			if(split[1].equals("e")) {
				List<Integer> old_e_closure= e_closure.get(Integer.parseInt(split[0]));
				if(!old_e_closure.contains(Integer.parseInt(split[2]))) {

					old_e_closure.add(Integer.parseInt(split[2]));
//				Collections.sort(old_e_closure);
					e_closure.put(Integer.parseInt(split[0]), old_e_closure);
				}
			}
		}
		boolean changed=true;
		while (changed) {
			changed=false;
			for (int i = 0; i < states.length; i++) {
				List<Integer> old_e_closure = e_closure.get(Integer.parseInt(states[i]));
				for (int j = 0; j < old_e_closure.size(); j++) {
					List<Integer> temp = e_closure.get(old_e_closure.get(j));
					for (int k = 0; k < temp.size(); k++) {
						if (!old_e_closure.contains(temp.get(k))) {
							old_e_closure.add(temp.get(k));
							changed = true;
						}
					}
				}
				Collections.sort(old_e_closure);
				e_closure.put(Integer.parseInt(states[i]), old_e_closure);
			}
		}
	}
	private void makeSingleTransitionTable() {
		for(String transition : transitions){
			String[] split = transition.split(",");
			if(!split[1].equals("e")) {
				if(singleTransition.containsKey(Integer.parseInt(split[0]))) {
					HashMap<String,List<Integer>> oldTransitions = singleTransition.get(Integer.parseInt(split[0]));
					if(oldTransitions.containsKey(split[1])) {
						List<Integer> resultedStates = oldTransitions.get(split[1]);
						resultedStates.add(Integer.parseInt(split[2]));
						oldTransitions.put(split[1], resultedStates);
					}
					else {
						List<Integer> resultedStates = new ArrayList<>();
						resultedStates.add(Integer.parseInt(split[2]));
						oldTransitions.put(split[1], resultedStates);
					}
					singleTransition.put(Integer.parseInt(split[0]), oldTransitions);
				}
				else {
					HashMap<String,List<Integer>> newTransitionTable = new HashMap<>();
					List<Integer> resultedStates = new ArrayList<>();
					resultedStates.add(Integer.parseInt(split[2]));
					newTransitionTable.put(split[1], resultedStates);
					singleTransition.put(Integer.parseInt(split[0]), newTransitionTable);
				}
			}
		}
	}
	/**
	 * @return Returns a formatted string representation of the DFA. The string
	 *         representation follows the one in the task description
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String startState = createStartState();
		createDfaTransitions();
//		System.out.println(dfaStates);

		String states="";
		for (int i = 0; i < dfaStates.size(); i++) {
			states += stateToString(dfaStates.get(i)) + ";";
		}
		states = states.substring(0, states.length() - 1);

		String transitions="";
		for (int i = 0; i < dfaStates.size(); i++) {
			HashMap<String, List<Integer>> transition = dfaTransitions.get(dfaStates.get(i));
			for (String character : alphabet) {

				if (transition.containsKey(character)) {
					transitions += stateToString(dfaStates.get(i)) + "," + character + "," + stateToString(transition.get(character)) + ";";
				}
			}
		}
		transitions = transitions.substring(0, transitions.length() - 1);
		String acceptStates="";
		String acceptStatesArray[] = acceptState.split(";");

		for (int i = 0; i < dfaStates.size(); i++) {

			for (int j = 0; j < acceptStatesArray.length; j++)
			{
				;
				if (dfaStates.get(i).contains(Integer.parseInt(acceptStatesArray[j]))) {
					acceptStates += stateToString(dfaStates.get(i)) + ";";
					break;
				}
			}

		}

		acceptStates = acceptStates.substring(0, acceptStates.length() - 1);
		return states + "#" + alphabetSemiColon + "#" + transitions + "#" + startState + "#" + acceptStates;


	}
	private String stateToString(List<Integer> state) {
		if(state.size()==0) {
			return "-1";
		}
		String stateString = "";
		for (int i = 0; i < state.size(); i++) {
			stateString += state.get(i) + "/";
		}
		stateString = stateString.substring(0, stateString.length() - 1);
		return stateString;
	}
	private void createDfaTransitions(){
		int i=0;
		while(i<dfaStatesNotSorted.size()) {
			List<Integer> currentState = dfaStatesNotSorted.get(i);
			HashMap<String,List<Integer>> transition = new HashMap<>();
			for(String character:alphabet) {

				List<Integer> resultedState = getResultedState(currentState,character);
				addDfaState(resultedState);


				transition.put(character, resultedState);
				dfaTransitions.put(currentState, transition);
			}
			i++;

		}

	}
	private List<Integer> getResultedState (List<Integer> currentState, String character){
		List<Integer> resultedState = new ArrayList<>();
		for (int i = 0; i < currentState.size(); i++) {
			if(singleTransition.containsKey(currentState.get(i))) {
				HashMap<String,List<Integer>> transitions = singleTransition.get(currentState.get(i));
				if(transitions.containsKey(character)) {
					List<Integer> charTransition = transitions.get(character);
					for (int j = 0; j < charTransition.size(); j++) {
						List<Integer> e_closureStates = e_closure.get(charTransition.get(j));
						for (int k = 0; k < e_closureStates.size(); k++) {
							if(!resultedState.contains(e_closureStates.get(k))) {
								resultedState.add(e_closureStates.get(k));
							}
						}
						if(!resultedState.contains(charTransition.get(j))) {
							resultedState.add(charTransition.get(j));
						}
					}
					Collections.sort(resultedState);
				}
			}
		}
		return resultedState;
	}


	private String createStartState() {
		String startState = "";
		for (int i = 0; i < e_closure.get(Integer.parseInt(initialState)).size(); i++) {
			startState += e_closure.get(Integer.parseInt(initialState)).get(i) + "/";
		}
		startState = startState.substring(0, startState.length() - 1);
		dfaStates.add(e_closure.get(Integer.parseInt(initialState)));
		dfaStatesNotSorted.add(e_closure.get(Integer.parseInt(initialState)));
		return startState;
	}
	private void addDfaState(List<Integer> newState) {
		if(!checkStateExists(newState)) {
			if(newState.size()==0) {
				dfaStates.add(0,newState);
				dfaStatesNotSorted.add(newState);
				return;
			}
			int i;
			for ( i= 0; i < dfaStates.size(); i++) {
				if (checkSmaller(newState, dfaStates.get(i))) {
					dfaStates.add(i, newState);
					break;
				}
			}
			if(i==dfaStates.size()) {
				dfaStates.add(newState);
			}
			dfaStatesNotSorted.add(newState);
		}
	}
	private boolean checkEqualStates(List<Integer> state1, List<Integer> state2) {
		if (state1.size() != state2.size()) {
			return false;
		}
		for (int i = 0; i < state1.size(); i++) {
			if (state1.get(i) != state2.get(i)) {
				return false;
			}
		}
		return true;
	}
	private boolean checkStateExists(List<Integer> state) {
		for (int i = 0; i < dfaStates.size(); i++) {
			if (checkEqualStates(state, dfaStates.get(i))) {
				return true;
			}
		}
		return false;
	}
	private boolean checkSmaller(List<Integer> state1, List<Integer> state2) {
		int i=0;
		while(i<state1.size() && i<state2.size()) {
			if(state1.get(i)<state2.get(i)) {
				return true;
			}
			else if(state1.get(i)>state2.get(i)) {
				return false;
			}
			i++;
		}
		if(i==state1.size()) {
			return true;
		}
		return false;
	}
}