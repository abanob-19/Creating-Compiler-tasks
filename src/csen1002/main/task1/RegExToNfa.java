package csen1002.main.task1;
import java.util.*;

/**
 * Write your info here
 *
 * @name Abanob Kamal
 * @id 49-9287
 * @labNumber 20
 */

public class RegExToNfa {

	/**
	 * Constructs an NFA corresponding to a regular expression based on Thompson's
	 * construction
	 *
	 * @param input The alphabet and the regular expression in postfix notation for
	 * which the NFA is to be constructed
	 */
	String[] alphabet;
	String alphabetSemiColon;
	String regEx;
	Stack<String> controllingStack;
	int stateCount = 0;

	public RegExToNfa(String input) {
		// TODO Auto-generated constructor stub
		String[] split = input.split("#");
		alphabetSemiColon = split[0];
		alphabet = split[0].split(";");
		regEx = split[1];
		controllingStack = new Stack<String>();
	}

	/**
	 * @return Returns a formatted string representation of the NFA. The string
	 * representation follows the one in the task description
	 */
	@Override
	public String toString() {
		String output = "";
		// TODO Auto-generated method stub
		for (char regExItem : regEx.toCharArray()) {
			if (regExItem == '.') {
				controllingStack.push(convertConcatenation());

			} else if (regExItem == '|') {

				controllingStack.push(convertUnion());

			} else if (regExItem == '*') {
				controllingStack.push(convertStar());
			} else {
				controllingStack.push(convertSymbol(regExItem));

			}

		}
		return controllingStack.pop();
	}

	private String convertSymbol(char x) {
		int state1 = stateCount++;
		int state2 = stateCount++;
		String states = state1 + ";" + state2;
		String transitions = state1 + "," + x + "," + state2;
		String initialState = state1 + "";
		String acceptState = state2 + "";
		String converted = states + "#" + alphabetSemiColon + "#" + transitions + "#" + initialState + "#" + acceptState;
		return converted;
	}
	private String convertConcatenation() {
		String second = controllingStack.pop();
		String first = controllingStack.pop();
		String[] firstSplit = first.split("#");
		String[] secondSplit = second.split("#");
		String newStatesForSecond= secondSplit[0].replaceFirst(secondSplit[3]+";","");
		String states = firstSplit[0] + ";" + newStatesForSecond;
		String [] transitionsArray = secondSplit[2].split(";");
		String newTransitionsForFirst="";
		String newTransitionsForSecond="";
		for(String transition:transitionsArray){
			String [] transitionSplit = transition.split(",");
			if(transitionSplit[0].equals(secondSplit[3]))
				newTransitionsForFirst+=";"+firstSplit[4]+","+transitionSplit[1]+","+transitionSplit[2];
			else
				newTransitionsForSecond+=";"+transition;
		}
		String transitions = firstSplit[2] + newTransitionsForFirst + newTransitionsForSecond;
		String initialState = firstSplit[3];
		String acceptState = secondSplit[4];
		String converted = states + "#" + alphabetSemiColon + "#" + transitions + "#" + initialState + "#" + acceptState;
		return converted;
	}
	private String convertUnion() {
		String second = controllingStack.pop();
		String first = controllingStack.pop();
		String[] firstSplit = first.split("#");
		String[] secondSplit = second.split("#");
		int newStart = stateCount++;
		int newAccept = stateCount++;
		String states = firstSplit[0] + ";" + secondSplit[0] + ";" + newStart + ";" + newAccept;
		String newTransitions =   secondSplit[4] + ",e," + newAccept+";"+newStart + ",e," + firstSplit[3]+ ";"+newStart + ",e," + secondSplit[3]  ;
		String transitions= firstSplit[2] + ";"+ firstSplit[4] + ",e," + newAccept + ";"  + secondSplit[2] + ";" + newTransitions;
		String initialState = newStart + "";
		String acceptState = newAccept + "";
		String converted = states + "#" + alphabetSemiColon + "#" + transitions + "#" + initialState + "#" + acceptState;
		return converted;
	}
	private String convertStar(){
		String poppedItem = controllingStack.pop();
		String[] splitted = poppedItem.split("#");
		int newStart = stateCount++;
		int newAccept = stateCount++;
		String states = splitted[0] + ";" +  newStart + ";" + newAccept;
		String newTransitions =  splitted[4] + ",e," + splitted[3] + ";" + splitted[4] + ",e," + newAccept+";"+newStart + ",e," + splitted[3]+ ";"+newStart + ",e," + newAccept  ;
		String transitions= splitted[2] + ";" +  newTransitions;
		String initialState = newStart + "";
		String acceptState = newAccept + "";
		String converted = states + "#" + alphabetSemiColon + "#" + transitions + "#" + initialState + "#" + acceptState;
		return converted;

	}

}
