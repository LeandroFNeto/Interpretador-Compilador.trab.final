// Generated from Lang.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangParser}.
 */
public interface LangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessorDirective(LangParser.PreprocessorDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#preprocessorDirective}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessorDirective(LangParser.PreprocessorDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#globalVariable}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVariable(LangParser.GlobalVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#globalVariable}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVariable(LangParser.GlobalVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(LangParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(LangParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#fnBlock}.
	 * @param ctx the parse tree
	 */
	void enterFnBlock(LangParser.FnBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#fnBlock}.
	 * @param ctx the parse tree
	 */
	void exitFnBlock(LangParser.FnBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#fnBodyList}.
	 * @param ctx the parse tree
	 */
	void enterFnBodyList(LangParser.FnBodyListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#fnBodyList}.
	 * @param ctx the parse tree
	 */
	void exitFnBodyList(LangParser.FnBodyListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#fnBodyItem}.
	 * @param ctx the parse tree
	 */
	void enterFnBodyItem(LangParser.FnBodyItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#fnBodyItem}.
	 * @param ctx the parse tree
	 */
	void exitFnBodyItem(LangParser.FnBodyItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(LangParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(LangParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(LangParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(LangParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LangParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LangParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#atrib}.
	 * @param ctx the parse tree
	 */
	void enterAtrib(LangParser.AtribContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#atrib}.
	 * @param ctx the parse tree
	 */
	void exitAtrib(LangParser.AtribContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#arraydecl}.
	 * @param ctx the parse tree
	 */
	void enterArraydecl(LangParser.ArraydeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#arraydecl}.
	 * @param ctx the parse tree
	 */
	void exitArraydecl(LangParser.ArraydeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#arrayelems}.
	 * @param ctx the parse tree
	 */
	void enterArrayelems(LangParser.ArrayelemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#arrayelems}.
	 * @param ctx the parse tree
	 */
	void exitArrayelems(LangParser.ArrayelemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#pointerdecl}.
	 * @param ctx the parse tree
	 */
	void enterPointerdecl(LangParser.PointerdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#pointerdecl}.
	 * @param ctx the parse tree
	 */
	void exitPointerdecl(LangParser.PointerdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#pointerassign}.
	 * @param ctx the parse tree
	 */
	void enterPointerassign(LangParser.PointerassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#pointerassign}.
	 * @param ctx the parse tree
	 */
	void exitPointerassign(LangParser.PointerassignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#pointerdereference}.
	 * @param ctx the parse tree
	 */
	void enterPointerdereference(LangParser.PointerdereferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#pointerdereference}.
	 * @param ctx the parse tree
	 */
	void exitPointerdereference(LangParser.PointerdereferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#structdeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructdeclaration(LangParser.StructdeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#structdeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructdeclaration(LangParser.StructdeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#structaccess}.
	 * @param ctx the parse tree
	 */
	void enterStructaccess(LangParser.StructaccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#structaccess}.
	 * @param ctx the parse tree
	 */
	void exitStructaccess(LangParser.StructaccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#uniondeclaration}.
	 * @param ctx the parse tree
	 */
	void enterUniondeclaration(LangParser.UniondeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#uniondeclaration}.
	 * @param ctx the parse tree
	 */
	void exitUniondeclaration(LangParser.UniondeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#unionaccess}.
	 * @param ctx the parse tree
	 */
	void enterUnionaccess(LangParser.UnionaccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#unionaccess}.
	 * @param ctx the parse tree
	 */
	void exitUnionaccess(LangParser.UnionaccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(LangParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(LangParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#output}.
	 * @param ctx the parse tree
	 */
	void enterOutput(LangParser.OutputContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#output}.
	 * @param ctx the parse tree
	 */
	void exitOutput(LangParser.OutputContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void enterIfstmt(LangParser.IfstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#ifstmt}.
	 * @param ctx the parse tree
	 */
	void exitIfstmt(LangParser.IfstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#dowhilestmt}.
	 * @param ctx the parse tree
	 */
	void enterDowhilestmt(LangParser.DowhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#dowhilestmt}.
	 * @param ctx the parse tree
	 */
	void exitDowhilestmt(LangParser.DowhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(LangParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#whilestmt}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(LangParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#forstmt}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(LangParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#forstmt}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(LangParser.ForstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#switchstmt}.
	 * @param ctx the parse tree
	 */
	void enterSwitchstmt(LangParser.SwitchstmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#switchstmt}.
	 * @param ctx the parse tree
	 */
	void exitSwitchstmt(LangParser.SwitchstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseClause(LangParser.CaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#caseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseClause(LangParser.CaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void enterDefaultClause(LangParser.DefaultClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void exitDefaultClause(LangParser.DefaultClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(LangParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(LangParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#termTail}.
	 * @param ctx the parse tree
	 */
	void enterTermTail(LangParser.TermTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#termTail}.
	 * @param ctx the parse tree
	 */
	void exitTermTail(LangParser.TermTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LangParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LangParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#factorTail}.
	 * @param ctx the parse tree
	 */
	void enterFactorTail(LangParser.FactorTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#factorTail}.
	 * @param ctx the parse tree
	 */
	void exitFactorTail(LangParser.FactorTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LangParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LangParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#structdecl}.
	 * @param ctx the parse tree
	 */
	void enterStructdecl(LangParser.StructdeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#structdecl}.
	 * @param ctx the parse tree
	 */
	void exitStructdecl(LangParser.StructdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#structfieldList}.
	 * @param ctx the parse tree
	 */
	void enterStructfieldList(LangParser.StructfieldListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#structfieldList}.
	 * @param ctx the parse tree
	 */
	void exitStructfieldList(LangParser.StructfieldListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#structfields}.
	 * @param ctx the parse tree
	 */
	void enterStructfields(LangParser.StructfieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#structfields}.
	 * @param ctx the parse tree
	 */
	void exitStructfields(LangParser.StructfieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#uniondecl}.
	 * @param ctx the parse tree
	 */
	void enterUniondecl(LangParser.UniondeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#uniondecl}.
	 * @param ctx the parse tree
	 */
	void exitUniondecl(LangParser.UniondeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#unionfieldList}.
	 * @param ctx the parse tree
	 */
	void enterUnionfieldList(LangParser.UnionfieldListContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#unionfieldList}.
	 * @param ctx the parse tree
	 */
	void exitUnionfieldList(LangParser.UnionfieldListContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#unionfields}.
	 * @param ctx the parse tree
	 */
	void enterUnionfields(LangParser.UnionfieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#unionfields}.
	 * @param ctx the parse tree
	 */
	void exitUnionfields(LangParser.UnionfieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpec(LangParser.TypeSpecContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#typeSpec}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpec(LangParser.TypeSpecContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#funcinvoc}.
	 * @param ctx the parse tree
	 */
	void enterFuncinvoc(LangParser.FuncinvocContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#funcinvoc}.
	 * @param ctx the parse tree
	 */
	void exitFuncinvoc(LangParser.FuncinvocContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(LangParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(LangParser.ArgumentosContext ctx);
}