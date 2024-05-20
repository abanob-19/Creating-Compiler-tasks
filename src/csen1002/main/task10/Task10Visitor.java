// Generated from C:/Users/Dell/IdeaProjects/Task/grammars/Task10.g4 by ANTLR 4.13.1
package csen1002.main.task10;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Task10Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Task10Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Task10Parser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(Task10Parser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link Task10Parser#f}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitF(Task10Parser.FContext ctx);
	/**
	 * Visit a parse tree produced by {@link Task10Parser#a}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitA(Task10Parser.AContext ctx);
}