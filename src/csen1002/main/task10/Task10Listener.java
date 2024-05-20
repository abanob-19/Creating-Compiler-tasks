// Generated from C:/Users/Dell/IdeaProjects/Task/grammars/Task10.g4 by ANTLR 4.13.1
package csen1002.main.task10;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Task10Parser}.
 */
public interface Task10Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Task10Parser#s}.
	 * @param ctx the parse tree
	 */
	void enterS(Task10Parser.SContext ctx);
	/**
	 * Exit a parse tree produced by {@link Task10Parser#s}.
	 * @param ctx the parse tree
	 */
	void exitS(Task10Parser.SContext ctx);
	/**
	 * Enter a parse tree produced by {@link Task10Parser#f}.
	 * @param ctx the parse tree
	 */
	void enterF(Task10Parser.FContext ctx);
	/**
	 * Exit a parse tree produced by {@link Task10Parser#f}.
	 * @param ctx the parse tree
	 */
	void exitF(Task10Parser.FContext ctx);
	/**
	 * Enter a parse tree produced by {@link Task10Parser#a}.
	 * @param ctx the parse tree
	 */
	void enterA(Task10Parser.AContext ctx);
	/**
	 * Exit a parse tree produced by {@link Task10Parser#a}.
	 * @param ctx the parse tree
	 */
	void exitA(Task10Parser.AContext ctx);
}