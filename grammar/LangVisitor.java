// Generated from Lang.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(LangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessorDirective(LangParser.PreprocessorDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#globalVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVariable(LangParser.GlobalVariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(LangParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#fnBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnBlock(LangParser.FnBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#fnBodyList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnBodyList(LangParser.FnBodyListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#fnBodyItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFnBodyItem(LangParser.FnBodyItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(LangParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(LangParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(LangParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#atrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtrib(LangParser.AtribContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#arraydecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraydecl(LangParser.ArraydeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#arrayelems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayelems(LangParser.ArrayelemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#pointerdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerdecl(LangParser.PointerdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#pointerassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerassign(LangParser.PointerassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#pointerdereference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointerdereference(LangParser.PointerdereferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#structdeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructdeclaration(LangParser.StructdeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#structaccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructaccess(LangParser.StructaccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#uniondeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniondeclaration(LangParser.UniondeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#unionaccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionaccess(LangParser.UnionaccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(LangParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#output}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutput(LangParser.OutputContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#ifstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstmt(LangParser.IfstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#dowhilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDowhilestmt(LangParser.DowhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#whilestmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(LangParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#forstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstmt(LangParser.ForstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#switchstmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchstmt(LangParser.SwitchstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#caseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClause(LangParser.CaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(LangParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#cond}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond(LangParser.CondContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#termTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermTail(LangParser.TermTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(LangParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#factorTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorTail(LangParser.FactorTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(LangParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#structdecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructdecl(LangParser.StructdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#structfieldList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructfieldList(LangParser.StructfieldListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#structfields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructfields(LangParser.StructfieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#uniondecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniondecl(LangParser.UniondeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#unionfieldList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionfieldList(LangParser.UnionfieldListContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#unionfields}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionfields(LangParser.UnionfieldsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#typeSpec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpec(LangParser.TypeSpecContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#funcinvoc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncinvoc(LangParser.FuncinvocContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(LangParser.ArgumentosContext ctx);
}