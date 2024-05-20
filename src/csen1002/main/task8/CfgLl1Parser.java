package csen1002.main.task8;

import java.util.*;

/**
 * Write your info here
 *
 * @name Abanob Kamal Naeim
 * @id 49-9287
 * @labNumber 20
 */

public class CfgLl1Parser {

	/**
	 * Constructs a Context Free Grammar
	 *
	 * //@param cfg A formatted string representation of the CFG, the First sets of
	 *            each right-hand side, and the Follow sets of each variable. The
	 *            string representation follows the one in the task description
	 */
	String variablesSemiColon;
	String Variables[];
	String terminalsSemiColon;
	String terminals [];
	String rules[];
	String firstSets[];
	String followSets[];
	HashMap<String, List<String>> rulesMap = new HashMap<String, List<String>>();
	HashMap<String, List<String>> firstMap = new HashMap<String, List<String>>();
	HashMap<String, List<Character>> followMap = new HashMap<String, List<Character>>();
	HashMap<String, HashMap<Character, String>> parsingTable = new HashMap<String, HashMap<Character, String>>();
	public CfgLl1Parser(String input) {
		// TODO Auto-generated constructor stub
		String[] split = input.split("#");
		variablesSemiColon = split[0];
		Variables = split[0].split(";");
		terminalsSemiColon = split[1];
		terminals = split[1].split(";");
		rules = split[2].split(";");
		populateRulesMap();
		firstSets = split[3].split(";");
		followSets = split[4].split(";");
		populateFirstMap();
		populateFollowMap();
		createParsingTable();
	}
	private void populateRulesMap() {
		for (String rule : rules) {
			String[] split = rule.split("/");
			if (rulesMap.containsKey(split[0])) {
				List<String> oldRules = rulesMap.get(split[0]);
				String[] splitRules = split[1].split(",");
				oldRules.addAll(Arrays.asList(splitRules));
				rulesMap.put(split[0], oldRules);
			} else {
				List<String> newRules = new ArrayList<>();
				String[] splitRules = split[1].split(",");
				newRules.addAll(Arrays.asList(splitRules));
				rulesMap.put(split[0], newRules);
			}
		}
	}
	private void populateFirstMap() {
		for (String set : firstSets) {
			String[] split = set.split("/");
			List<String> firstList = new ArrayList<>();
			for (String first : split[1].split(",")) {
				firstList.add(first);
			}
			firstMap.put(split[0], firstList);
		}
	}
	private void populateFollowMap() {
		for (String set : followSets) {
			String[] split = set.split("/");
			List<Character> followList = new ArrayList<>();
			for (char follow : split[1].toCharArray()) {
				followList.add(follow);
			}
			followMap.put(split[0], followList);
		}
	}
	private void createParsingTable() {
		for (String variable : Variables) {
			HashMap<Character, String> row = new HashMap<>();

			for (int i = 0; i < rulesMap.get(variable).size(); i++) {
				String rule = rulesMap.get(variable).get(i);
				String first = firstMap.get(variable).get(i);
				for (char terminal : first.toCharArray()) {
					if (terminal != 'e')
						row.put(terminal, rule);
					else {
						for (char follow : followMap.get(variable)) {
							if (!row.containsKey(follow))
								row.put(follow, rule);
						}

					}
				}

			}
			parsingTable.put(variable, row);
		}
	}
	/**
	 * @param input The string to be parsed by the LL(1) CFG.
	 *
	 * @return A string encoding a left-most derivation.
	 */
	public String parse(String input) {
		// TODO Auto-generated method stub
		input += "$";
		Stack<Character> stack = new Stack<>();
		stack.push('$');
		stack.push('S');
		String derivation = "S;";
		String currentStep= "S";
		while (!stack.isEmpty()) {
			char top = stack.pop();
			if (top!='e' && (Arrays.toString(terminals).contains(top + "")) && input.length()==0) {
				derivation+="ERROR";
				break;
			}
			else if (input.length()!=0 && top == input.charAt(0)) {
				input = input.substring(1);
				if(top=='$') {
					derivation=derivation.substring(0, derivation.length()-1);
					break;
				}
			} else if (Arrays.toString(Variables).contains(top + "") && input.length()!=0 && ((Arrays.toString(terminals).contains(input.charAt(0) + ""))||input.charAt(0)=='$')){
				String rule = parsingTable.get(top + "").get(input.charAt(0));
				if (rule == null) {
					derivation += "ERROR";
					break;
				}
				else {
					for (int i = rule.length() - 1; i >= 0; i--) {
						stack.push(rule.charAt(i));
					}
					if(!rule.equals("e"))
						currentStep = currentStep.replaceFirst(top + "", rule);
					else
						currentStep = currentStep.replaceFirst(top + "", "");
					derivation +=  currentStep+ ";";
				}
			}
			else {
				if(top!='e') {
					derivation += "ERROR";
					break;
				}
			}
		}
		return derivation;
	}
}
