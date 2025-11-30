// Generated from Lang.g4 by ANTLR 4.13.2
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, DEFINE=13, EOL=14, COMMENTLINE=15, COMMENTBLOCK=16, 
		INT=17, FLOAT=18, CHAR=19, DOUBLE=20, VOID=21, MAIN=22, RETURN=23, SCAN=24, 
		PRINT=25, GETS=26, PUTS=27, STRUCT=28, UNION=29, IF=30, ELSE=31, SWITCH=32, 
		CASE=33, BREAK=34, DEFAULT=35, WHILE=36, FOR=37, DO=38, VAR=39, NUM=40, 
		DECIM=41, PLUS=42, MINUS=43, MULT=44, DIV=45, MOD=46, AND=47, OR=48, NOT=49, 
		RELOP=50, AT=51, SEP=52, DOT=53, FORMATSTRING=54, WS=55;
	public static final int
		RULE_prog = 0, RULE_declaration = 1, RULE_globalVariable = 2, RULE_function = 3, 
		RULE_fnBlock = 4, RULE_fnBodyList = 5, RULE_fnBodyItem = 6, RULE_params = 7, 
		RULE_line = 8, RULE_stmt = 9, RULE_atrib = 10, RULE_arraydecl = 11, RULE_arrayelems = 12, 
		RULE_pointerdecl = 13, RULE_pointerassign = 14, RULE_pointerdereference = 15, 
		RULE_structdeclaration = 16, RULE_structaccess = 17, RULE_uniondeclaration = 18, 
		RULE_unionaccess = 19, RULE_input = 20, RULE_output = 21, RULE_ifstmt = 22, 
		RULE_dowhilestmt = 23, RULE_whilestmt = 24, RULE_forstmt = 25, RULE_switchstmt = 26, 
		RULE_caseClause = 27, RULE_defaultClause = 28, RULE_cond = 29, RULE_expression = 30, 
		RULE_termTail = 31, RULE_term = 32, RULE_factorTail = 33, RULE_factor = 34, 
		RULE_structdecl = 35, RULE_structfieldList = 36, RULE_structfields = 37, 
		RULE_uniondecl = 38, RULE_unionfieldList = 39, RULE_unionfields = 40, 
		RULE_typeSpec = 41, RULE_funcinvoc = 42, RULE_argumentos = 43;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declaration", "globalVariable", "function", "fnBlock", "fnBodyList", 
			"fnBodyItem", "params", "line", "stmt", "atrib", "arraydecl", "arrayelems", 
			"pointerdecl", "pointerassign", "pointerdereference", "structdeclaration", 
			"structaccess", "uniondeclaration", "unionaccess", "input", "output", 
			"ifstmt", "dowhilestmt", "whilestmt", "forstmt", "switchstmt", "caseClause", 
			"defaultClause", "cond", "expression", "termTail", "term", "factorTail", 
			"factor", "structdecl", "structfieldList", "structfields", "uniondecl", 
			"unionfieldList", "unionfields", "typeSpec", "funcinvoc", "argumentos"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "'('", "')'", "'{'", "'}'", "'++'", "'--'", "'+='", 
			"'-='", "'&'", "':'", "'#define'", "';'", null, null, "'int'", "'float'", 
			"'char'", "'double'", "'void'", "'main'", "'return'", "'scanf'", "'printf'", 
			"'gets'", "'puts'", "'struct'", "'union'", "'if'", "'else'", "'switch'", 
			"'case'", "'break'", "'default'", "'while'", "'for'", "'do'", null, null, 
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'&&'", "'||'", "'!'", null, 
			"'='", "','", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "DEFINE", "EOL", "COMMENTLINE", "COMMENTBLOCK", "INT", "FLOAT", 
			"CHAR", "DOUBLE", "VOID", "MAIN", "RETURN", "SCAN", "PRINT", "GETS", 
			"PUTS", "STRUCT", "UNION", "IF", "ELSE", "SWITCH", "CASE", "BREAK", "DEFAULT", 
			"WHILE", "FOR", "DO", "VAR", "NUM", "DECIM", "PLUS", "MINUS", "MULT", 
			"DIV", "MOD", "AND", "OR", "NOT", "RELOP", "AT", "SEP", "DOT", "FORMATSTRING", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 809377792L) != 0)) {
				{
				{
				setState(88);
				declaration();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public StructdeclContext structdecl() {
			return getRuleContext(StructdeclContext.class,0);
		}
		public UniondeclContext uniondecl() {
			return getRuleContext(UniondeclContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public GlobalVariableContext globalVariable() {
			return getRuleContext(GlobalVariableContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRUCT:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				structdecl();
				}
				break;
			case UNION:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				uniondecl();
				}
				break;
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				function();
				}
				break;
			case DEFINE:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				globalVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalVariableContext extends ParserRuleContext {
		public TerminalNode DEFINE() { return getToken(LangParser.DEFINE, 0); }
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public TerminalNode NUM() { return getToken(LangParser.NUM, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AT() { return getToken(LangParser.AT, 0); }
		public GlobalVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVariable; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitGlobalVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalVariableContext globalVariable() throws RecognitionException {
		GlobalVariableContext _localctx = new GlobalVariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_globalVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(DEFINE);
			setState(101);
			match(VAR);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(102);
				match(T__0);
				setState(103);
				match(NUM);
				setState(104);
				match(T__1);
				}
			}

			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20287638799910920L) != 0)) {
				{
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(107);
					match(AT);
					}
				}

				setState(110);
				expression();
				}
			}

			setState(113);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(LangParser.MAIN, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_function);
		int _la;
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				typeSpec();
				setState(116);
				match(VAR);
				setState(117);
				match(T__2);
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) {
					{
					setState(118);
					params();
					}
				}

				setState(121);
				match(T__3);
				setState(122);
				fnBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				typeSpec();
				setState(125);
				match(MAIN);
				setState(126);
				match(T__2);
				setState(127);
				match(T__3);
				setState(128);
				fnBlock();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FnBlockContext extends ParserRuleContext {
		public FnBodyListContext fnBodyList() {
			return getRuleContext(FnBodyListContext.class,0);
		}
		public FnBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFnBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnBlockContext fnBlock() throws RecognitionException {
		FnBlockContext _localctx = new FnBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fnBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__4);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18629416337440L) != 0)) {
				{
				setState(133);
				fnBodyList();
				}
			}

			setState(136);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FnBodyListContext extends ParserRuleContext {
		public List<FnBodyItemContext> fnBodyItem() {
			return getRuleContexts(FnBodyItemContext.class);
		}
		public FnBodyItemContext fnBodyItem(int i) {
			return getRuleContext(FnBodyItemContext.class,i);
		}
		public FnBodyListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnBodyList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFnBodyList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnBodyListContext fnBodyList() throws RecognitionException {
		FnBodyListContext _localctx = new FnBodyListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_fnBodyList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(138);
				fnBodyItem();
				}
				}
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 18629416337440L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FnBodyItemContext extends ParserRuleContext {
		public LineContext line() {
			return getRuleContext(LineContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(LangParser.RETURN, 0); }
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FnBodyItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnBodyItem; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFnBodyItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnBodyItemContext fnBodyItem() throws RecognitionException {
		FnBodyItemContext _localctx = new FnBodyItemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_fnBodyItem);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case EOL:
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case VOID:
			case SCAN:
			case PRINT:
			case GETS:
			case PUTS:
			case STRUCT:
			case UNION:
			case IF:
			case SWITCH:
			case WHILE:
			case FOR:
			case DO:
			case VAR:
			case MULT:
				enterOuterAlt(_localctx, 1);
				{
				setState(143);
				line();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(RETURN);
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18035838986225672L) != 0)) {
					{
					setState(145);
					expression();
					}
				}

				setState(148);
				match(EOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamsContext extends ParserRuleContext {
		public List<TypeSpecContext> typeSpec() {
			return getRuleContexts(TypeSpecContext.class);
		}
		public TypeSpecContext typeSpec(int i) {
			return getRuleContext(TypeSpecContext.class,i);
		}
		public List<TerminalNode> VAR() { return getTokens(LangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangParser.VAR, i);
		}
		public List<TerminalNode> MULT() { return getTokens(LangParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(LangParser.MULT, i);
		}
		public List<TerminalNode> SEP() { return getTokens(LangParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LangParser.SEP, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			typeSpec();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MULT) {
				{
				setState(152);
				match(MULT);
				}
			}

			setState(155);
			match(VAR);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(156);
				match(SEP);
				setState(157);
				typeSpec();
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MULT) {
					{
					setState(158);
					match(MULT);
					}
				}

				setState(161);
				match(VAR);
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public DowhilestmtContext dowhilestmt() {
			return getRuleContext(DowhilestmtContext.class,0);
		}
		public WhilestmtContext whilestmt() {
			return getRuleContext(WhilestmtContext.class,0);
		}
		public ForstmtContext forstmt() {
			return getRuleContext(ForstmtContext.class,0);
		}
		public SwitchstmtContext switchstmt() {
			return getRuleContext(SwitchstmtContext.class,0);
		}
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_line);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case FLOAT:
			case CHAR:
			case DOUBLE:
			case VOID:
			case SCAN:
			case PRINT:
			case GETS:
			case PUTS:
			case STRUCT:
			case UNION:
			case VAR:
			case MULT:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				stmt();
				setState(170);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(169);
					match(EOL);
					}
					break;
				}
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				ifstmt();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 3);
				{
				setState(173);
				dowhilestmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(174);
				whilestmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(175);
				forstmt();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				switchstmt();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 7);
				{
				setState(177);
				fnBlock();
				}
				break;
			case EOL:
				enterOuterAlt(_localctx, 8);
				{
				setState(178);
				match(EOL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public AtribContext atrib() {
			return getRuleContext(AtribContext.class,0);
		}
		public ArraydeclContext arraydecl() {
			return getRuleContext(ArraydeclContext.class,0);
		}
		public PointerdeclContext pointerdecl() {
			return getRuleContext(PointerdeclContext.class,0);
		}
		public PointerassignContext pointerassign() {
			return getRuleContext(PointerassignContext.class,0);
		}
		public PointerdereferenceContext pointerdereference() {
			return getRuleContext(PointerdereferenceContext.class,0);
		}
		public StructdeclarationContext structdeclaration() {
			return getRuleContext(StructdeclarationContext.class,0);
		}
		public StructaccessContext structaccess() {
			return getRuleContext(StructaccessContext.class,0);
		}
		public UniondeclarationContext uniondeclaration() {
			return getRuleContext(UniondeclarationContext.class,0);
		}
		public UnionaccessContext unionaccess() {
			return getRuleContext(UnionaccessContext.class,0);
		}
		public InputContext input() {
			return getRuleContext(InputContext.class,0);
		}
		public OutputContext output() {
			return getRuleContext(OutputContext.class,0);
		}
		public FuncinvocContext funcinvoc() {
			return getRuleContext(FuncinvocContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_stmt);
		try {
			setState(193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				atrib();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				arraydecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				pointerdecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(184);
				pointerassign();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				pointerdereference();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(186);
				structdeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				structaccess();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(188);
				uniondeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(189);
				unionaccess();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(190);
				input();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(191);
				output();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(192);
				funcinvoc();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtribContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode AT() { return getToken(LangParser.AT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FuncinvocContext funcinvoc() {
			return getRuleContext(FuncinvocContext.class,0);
		}
		public TerminalNode MULT() { return getToken(LangParser.MULT, 0); }
		public AtribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atrib; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitAtrib(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtribContext atrib() throws RecognitionException {
		AtribContext _localctx = new AtribContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atrib);
		int _la;
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				typeSpec();
				setState(196);
				match(VAR);
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AT) {
					{
					setState(197);
					match(AT);
					setState(198);
					expression();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				typeSpec();
				setState(202);
				match(VAR);
				setState(203);
				match(AT);
				setState(204);
				funcinvoc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				match(VAR);
				setState(207);
				match(AT);
				setState(208);
				expression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				match(VAR);
				setState(210);
				match(T__0);
				setState(211);
				expression();
				setState(212);
				match(T__1);
				setState(213);
				match(AT);
				setState(214);
				expression();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(216);
				match(VAR);
				setState(217);
				match(T__6);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(218);
				match(VAR);
				setState(219);
				match(T__7);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(220);
				match(VAR);
				setState(221);
				match(T__8);
				setState(222);
				expression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(223);
				match(VAR);
				setState(224);
				match(T__9);
				setState(225);
				expression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(226);
				match(MULT);
				setState(227);
				match(VAR);
				setState(228);
				match(AT);
				setState(229);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArraydeclContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode NUM() { return getToken(LangParser.NUM, 0); }
		public TerminalNode AT() { return getToken(LangParser.AT, 0); }
		public ArrayelemsContext arrayelems() {
			return getRuleContext(ArrayelemsContext.class,0);
		}
		public ArraydeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraydecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitArraydecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraydeclContext arraydecl() throws RecognitionException {
		ArraydeclContext _localctx = new ArraydeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arraydecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			typeSpec();
			setState(233);
			match(VAR);
			setState(234);
			match(T__0);
			setState(235);
			match(NUM);
			setState(236);
			match(T__1);
			setState(242);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT) {
				{
				setState(237);
				match(AT);
				setState(238);
				match(T__4);
				setState(239);
				arrayelems();
				setState(240);
				match(T__5);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayelemsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(LangParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LangParser.SEP, i);
		}
		public ArrayelemsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayelems; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitArrayelems(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayelemsContext arrayelems() throws RecognitionException {
		ArrayelemsContext _localctx = new ArrayelemsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arrayelems);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			expression();
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(245);
				match(SEP);
				setState(246);
				expression();
				}
				}
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerdeclContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode MULT() { return getToken(LangParser.MULT, 0); }
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public PointerdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerdecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPointerdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerdeclContext pointerdecl() throws RecognitionException {
		PointerdeclContext _localctx = new PointerdeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pointerdecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			typeSpec();
			setState(253);
			match(MULT);
			setState(254);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerassignContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangParser.VAR, i);
		}
		public TerminalNode AT() { return getToken(LangParser.AT, 0); }
		public PointerassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerassign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPointerassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerassignContext pointerassign() throws RecognitionException {
		PointerassignContext _localctx = new PointerassignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pointerassign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(VAR);
			setState(257);
			match(AT);
			setState(258);
			match(T__10);
			setState(259);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointerdereferenceContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(LangParser.MULT, 0); }
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode AT() { return getToken(LangParser.AT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PointerdereferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pointerdereference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitPointerdereference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PointerdereferenceContext pointerdereference() throws RecognitionException {
		PointerdereferenceContext _localctx = new PointerdereferenceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pointerdereference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(MULT);
			setState(262);
			match(VAR);
			setState(263);
			match(AT);
			setState(264);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructdeclarationContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(LangParser.STRUCT, 0); }
		public List<TerminalNode> VAR() { return getTokens(LangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangParser.VAR, i);
		}
		public StructdeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structdeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitStructdeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructdeclarationContext structdeclaration() throws RecognitionException {
		StructdeclarationContext _localctx = new StructdeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_structdeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(STRUCT);
			setState(267);
			match(VAR);
			setState(268);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructaccessContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangParser.VAR, i);
		}
		public TerminalNode DOT() { return getToken(LangParser.DOT, 0); }
		public TerminalNode AT() { return getToken(LangParser.AT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StructaccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structaccess; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitStructaccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructaccessContext structaccess() throws RecognitionException {
		StructaccessContext _localctx = new StructaccessContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_structaccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(VAR);
			setState(271);
			match(DOT);
			setState(272);
			match(VAR);
			setState(275);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(273);
				match(AT);
				setState(274);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UniondeclarationContext extends ParserRuleContext {
		public TerminalNode UNION() { return getToken(LangParser.UNION, 0); }
		public List<TerminalNode> VAR() { return getTokens(LangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangParser.VAR, i);
		}
		public UniondeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniondeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitUniondeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UniondeclarationContext uniondeclaration() throws RecognitionException {
		UniondeclarationContext _localctx = new UniondeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_uniondeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(UNION);
			setState(278);
			match(VAR);
			setState(279);
			match(VAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnionaccessContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(LangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangParser.VAR, i);
		}
		public TerminalNode DOT() { return getToken(LangParser.DOT, 0); }
		public TerminalNode AT() { return getToken(LangParser.AT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnionaccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionaccess; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitUnionaccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionaccessContext unionaccess() throws RecognitionException {
		UnionaccessContext _localctx = new UnionaccessContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unionaccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(VAR);
			setState(282);
			match(DOT);
			setState(283);
			match(VAR);
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(284);
				match(AT);
				setState(285);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputContext extends ParserRuleContext {
		public TerminalNode SCAN() { return getToken(LangParser.SCAN, 0); }
		public TerminalNode FORMATSTRING() { return getToken(LangParser.FORMATSTRING, 0); }
		public List<TerminalNode> SEP() { return getTokens(LangParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LangParser.SEP, i);
		}
		public List<TerminalNode> VAR() { return getTokens(LangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(LangParser.VAR, i);
		}
		public TerminalNode GETS() { return getToken(LangParser.GETS, 0); }
		public InputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_input; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputContext input() throws RecognitionException {
		InputContext _localctx = new InputContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_input);
		int _la;
		try {
			setState(303);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SCAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				match(SCAN);
				setState(289);
				match(T__2);
				setState(290);
				match(FORMATSTRING);
				setState(294); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(291);
					match(SEP);
					setState(292);
					match(T__10);
					setState(293);
					match(VAR);
					}
					}
					setState(296); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SEP );
				setState(298);
				match(T__3);
				}
				break;
			case GETS:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(GETS);
				setState(300);
				match(T__2);
				setState(301);
				match(VAR);
				setState(302);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OutputContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(LangParser.PRINT, 0); }
		public TerminalNode FORMATSTRING() { return getToken(LangParser.FORMATSTRING, 0); }
		public List<TerminalNode> SEP() { return getTokens(LangParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LangParser.SEP, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PUTS() { return getToken(LangParser.PUTS, 0); }
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public OutputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitOutput(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutputContext output() throws RecognitionException {
		OutputContext _localctx = new OutputContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_output);
		int _la;
		try {
			setState(320);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRINT:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				match(PRINT);
				setState(306);
				match(T__2);
				setState(307);
				match(FORMATSTRING);
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEP) {
					{
					{
					setState(308);
					match(SEP);
					setState(309);
					expression();
					}
					}
					setState(314);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(315);
				match(T__3);
				}
				break;
			case PUTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				match(PUTS);
				setState(317);
				match(T__2);
				setState(318);
				match(VAR);
				setState(319);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfstmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(LangParser.IF, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public List<FnBlockContext> fnBlock() {
			return getRuleContexts(FnBlockContext.class);
		}
		public FnBlockContext fnBlock(int i) {
			return getRuleContext(FnBlockContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(LangParser.ELSE, 0); }
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitIfstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ifstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			match(IF);
			setState(323);
			match(T__2);
			setState(324);
			cond(0);
			setState(325);
			match(T__3);
			setState(326);
			fnBlock();
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(327);
				match(ELSE);
				setState(328);
				fnBlock();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DowhilestmtContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(LangParser.DO, 0); }
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(LangParser.WHILE, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public DowhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dowhilestmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDowhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DowhilestmtContext dowhilestmt() throws RecognitionException {
		DowhilestmtContext _localctx = new DowhilestmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_dowhilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(DO);
			setState(332);
			fnBlock();
			setState(333);
			match(WHILE);
			setState(334);
			match(T__2);
			setState(335);
			cond(0);
			setState(336);
			match(T__3);
			setState(337);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhilestmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(LangParser.WHILE, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public WhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			match(WHILE);
			setState(340);
			match(T__2);
			setState(341);
			cond(0);
			setState(342);
			match(T__3);
			setState(343);
			fnBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForstmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(LangParser.FOR, 0); }
		public List<AtribContext> atrib() {
			return getRuleContexts(AtribContext.class);
		}
		public AtribContext atrib(int i) {
			return getRuleContext(AtribContext.class,i);
		}
		public List<TerminalNode> EOL() { return getTokens(LangParser.EOL); }
		public TerminalNode EOL(int i) {
			return getToken(LangParser.EOL, i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public FnBlockContext fnBlock() {
			return getRuleContext(FnBlockContext.class,0);
		}
		public ForstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitForstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForstmtContext forstmt() throws RecognitionException {
		ForstmtContext _localctx = new ForstmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_forstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(FOR);
			setState(346);
			match(T__2);
			setState(347);
			atrib();
			setState(348);
			match(EOL);
			setState(349);
			cond(0);
			setState(350);
			match(EOL);
			setState(351);
			atrib();
			setState(352);
			match(T__3);
			setState(353);
			fnBlock();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchstmtContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(LangParser.SWITCH, 0); }
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public List<CaseClauseContext> caseClause() {
			return getRuleContexts(CaseClauseContext.class);
		}
		public CaseClauseContext caseClause(int i) {
			return getRuleContext(CaseClauseContext.class,i);
		}
		public DefaultClauseContext defaultClause() {
			return getRuleContext(DefaultClauseContext.class,0);
		}
		public SwitchstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchstmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitSwitchstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SwitchstmtContext switchstmt() throws RecognitionException {
		SwitchstmtContext _localctx = new SwitchstmtContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_switchstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(SWITCH);
			setState(356);
			match(T__2);
			setState(357);
			match(VAR);
			setState(358);
			match(T__3);
			setState(359);
			match(T__4);
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(360);
				caseClause();
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(366);
				defaultClause();
				}
			}

			setState(369);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CaseClauseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(LangParser.CASE, 0); }
		public TerminalNode NUM() { return getToken(LangParser.NUM, 0); }
		public TerminalNode BREAK() { return getToken(LangParser.BREAK, 0); }
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public CaseClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCaseClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CaseClauseContext caseClause() throws RecognitionException {
		CaseClauseContext _localctx = new CaseClauseContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_caseClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(CASE);
			setState(372);
			match(NUM);
			setState(373);
			match(T__11);
			setState(375); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(374);
				line();
				}
				}
				setState(377); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 18629407948832L) != 0) );
			setState(379);
			match(BREAK);
			setState(380);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultClauseContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(LangParser.DEFAULT, 0); }
		public TerminalNode BREAK() { return getToken(LangParser.BREAK, 0); }
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public DefaultClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultClause; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultClauseContext defaultClause() throws RecognitionException {
		DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_defaultClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			match(DEFAULT);
			setState(383);
			match(T__11);
			setState(385); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(384);
				line();
				}
				}
				setState(387); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 18629407948832L) != 0) );
			setState(389);
			match(BREAK);
			setState(390);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CondContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(LangParser.NOT, 0); }
		public List<CondContext> cond() {
			return getRuleContexts(CondContext.class);
		}
		public CondContext cond(int i) {
			return getRuleContext(CondContext.class,i);
		}
		public TerminalNode RELOP() { return getToken(LangParser.RELOP, 0); }
		public TerminalNode AND() { return getToken(LangParser.AND, 0); }
		public TerminalNode OR() { return getToken(LangParser.OR, 0); }
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__10:
			case VAR:
			case NUM:
			case DECIM:
			case MULT:
			case FORMATSTRING:
				{
				setState(393);
				expression();
				}
				break;
			case NOT:
				{
				setState(394);
				match(NOT);
				setState(395);
				cond(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(409);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(407);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(398);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(399);
						match(RELOP);
						setState(400);
						cond(6);
						}
						break;
					case 2:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(401);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(402);
						match(AND);
						setState(403);
						cond(4);
						}
						break;
					case 3:
						{
						_localctx = new CondContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_cond);
						setState(404);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(405);
						match(OR);
						setState(406);
						cond(3);
						}
						break;
					}
					} 
				}
				setState(411);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<TermTailContext> termTail() {
			return getRuleContexts(TermTailContext.class);
		}
		public TermTailContext termTail(int i) {
			return getRuleContext(TermTailContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			term();
			setState(416);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(413);
					termTail();
					}
					} 
				}
				setState(418);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermTailContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<TerminalNode> PLUS() { return getTokens(LangParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(LangParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(LangParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(LangParser.MINUS, i);
		}
		public TermTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termTail; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTermTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermTailContext termTail() throws RecognitionException {
		TermTailContext _localctx = new TermTailContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_termTail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(419);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(424);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(425);
			term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public List<FactorTailContext> factorTail() {
			return getRuleContexts(FactorTailContext.class);
		}
		public FactorTailContext factorTail(int i) {
			return getRuleContext(FactorTailContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_term);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			factor();
			setState(431);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(428);
					factorTail();
					}
					} 
				}
				setState(433);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorTailContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public List<TerminalNode> MULT() { return getTokens(LangParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(LangParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(LangParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(LangParser.DIV, i);
		}
		public List<TerminalNode> MOD() { return getTokens(LangParser.MOD); }
		public TerminalNode MOD(int i) {
			return getToken(LangParser.MOD, i);
		}
		public FactorTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorTail; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFactorTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorTailContext factorTail() throws RecognitionException {
		FactorTailContext _localctx = new FactorTailContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_factorTail);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(434);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 123145302310912L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					} 
				}
				setState(439);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			setState(440);
			factor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FuncinvocContext funcinvoc() {
			return getRuleContext(FuncinvocContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode MULT() { return getToken(LangParser.MULT, 0); }
		public TerminalNode FORMATSTRING() { return getToken(LangParser.FORMATSTRING, 0); }
		public StructaccessContext structaccess() {
			return getRuleContext(StructaccessContext.class,0);
		}
		public UnionaccessContext unionaccess() {
			return getRuleContext(UnionaccessContext.class,0);
		}
		public TerminalNode NUM() { return getToken(LangParser.NUM, 0); }
		public TerminalNode DECIM() { return getToken(LangParser.DECIM, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_factor);
		try {
			setState(462);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(442);
				match(T__2);
				setState(443);
				expression();
				setState(444);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(446);
				funcinvoc();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(447);
				match(VAR);
				setState(448);
				match(T__0);
				setState(449);
				expression();
				setState(450);
				match(T__1);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(452);
				match(T__10);
				setState(453);
				match(VAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(454);
				match(MULT);
				setState(455);
				match(VAR);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(456);
				match(FORMATSTRING);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(457);
				match(VAR);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(458);
				structaccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(459);
				unionaccess();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(460);
				match(NUM);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(461);
				match(DECIM);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructdeclContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(LangParser.STRUCT, 0); }
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public StructfieldListContext structfieldList() {
			return getRuleContext(StructfieldListContext.class,0);
		}
		public StructdeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structdecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitStructdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructdeclContext structdecl() throws RecognitionException {
		StructdeclContext _localctx = new StructdeclContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_structdecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(STRUCT);
			setState(465);
			match(VAR);
			setState(466);
			match(T__4);
			setState(468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) {
				{
				setState(467);
				structfieldList();
				}
			}

			setState(470);
			match(T__5);
			setState(471);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructfieldListContext extends ParserRuleContext {
		public List<StructfieldsContext> structfields() {
			return getRuleContexts(StructfieldsContext.class);
		}
		public StructfieldsContext structfields(int i) {
			return getRuleContext(StructfieldsContext.class,i);
		}
		public StructfieldListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structfieldList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitStructfieldList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructfieldListContext structfieldList() throws RecognitionException {
		StructfieldListContext _localctx = new StructfieldListContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_structfieldList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(473);
				structfields();
				}
				}
				setState(476); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructfieldsContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public StructfieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structfields; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitStructfields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructfieldsContext structfields() throws RecognitionException {
		StructfieldsContext _localctx = new StructfieldsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_structfields);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			typeSpec();
			setState(479);
			match(VAR);
			setState(480);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UniondeclContext extends ParserRuleContext {
		public TerminalNode UNION() { return getToken(LangParser.UNION, 0); }
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public UnionfieldListContext unionfieldList() {
			return getRuleContext(UnionfieldListContext.class,0);
		}
		public UniondeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uniondecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitUniondecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UniondeclContext uniondecl() throws RecognitionException {
		UniondeclContext _localctx = new UniondeclContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_uniondecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(UNION);
			setState(483);
			match(VAR);
			setState(484);
			match(T__4);
			setState(486);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) {
				{
				setState(485);
				unionfieldList();
				}
			}

			setState(488);
			match(T__5);
			setState(489);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnionfieldListContext extends ParserRuleContext {
		public List<UnionfieldsContext> unionfields() {
			return getRuleContexts(UnionfieldsContext.class);
		}
		public UnionfieldsContext unionfields(int i) {
			return getRuleContext(UnionfieldsContext.class,i);
		}
		public UnionfieldListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionfieldList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitUnionfieldList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionfieldListContext unionfieldList() throws RecognitionException {
		UnionfieldListContext _localctx = new UnionfieldListContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_unionfieldList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(491);
				unionfields();
				}
				}
				setState(494); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnionfieldsContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public TerminalNode EOL() { return getToken(LangParser.EOL, 0); }
		public UnionfieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionfields; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitUnionfields(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionfieldsContext unionfields() throws RecognitionException {
		UnionfieldsContext _localctx = new UnionfieldsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_unionfields);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			typeSpec();
			setState(497);
			match(VAR);
			setState(498);
			match(EOL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeSpecContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(LangParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(LangParser.FLOAT, 0); }
		public TerminalNode CHAR() { return getToken(LangParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(LangParser.DOUBLE, 0); }
		public TerminalNode VOID() { return getToken(LangParser.VOID, 0); }
		public TypeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitTypeSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecContext typeSpec() throws RecognitionException {
		TypeSpecContext _localctx = new TypeSpecContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_typeSpec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4063232L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncinvocContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(LangParser.VAR, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public FuncinvocContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcinvoc; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitFuncinvoc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncinvocContext funcinvoc() throws RecognitionException {
		FuncinvocContext _localctx = new FuncinvocContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_funcinvoc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			match(VAR);
			setState(503);
			match(T__2);
			setState(505);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18035838986225672L) != 0)) {
				{
				setState(504);
				argumentos();
				}
			}

			setState(507);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SEP() { return getTokens(LangParser.SEP); }
		public TerminalNode SEP(int i) {
			return getToken(LangParser.SEP, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LangVisitor ) return ((LangVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			expression();
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEP) {
				{
				{
				setState(510);
				match(SEP);
				setState(511);
				expression();
				}
				}
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 29:
			return cond_sempred((CondContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00017\u0206\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0001\u0000\u0005\u0000"+
		"Z\b\u0000\n\u0000\f\u0000]\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001c\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002j\b\u0002\u0001\u0002\u0003\u0002"+
		"m\b\u0002\u0001\u0002\u0003\u0002p\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003x\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0083\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004\u0087\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004"+
		"\u0005\u008c\b\u0005\u000b\u0005\f\u0005\u008d\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u0093\b\u0006\u0001\u0006\u0003\u0006\u0096\b"+
		"\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u009a\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a0\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007\u00a4\b\u0007\n\u0007\f\u0007\u00a7\t\u0007\u0001\b"+
		"\u0001\b\u0003\b\u00ab\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u00b4\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00c2\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u00c8\b\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00e7"+
		"\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00f3"+
		"\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u00f8\b\f\n\f\f\f\u00fb\t\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u0114\b\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u011f\b\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0004\u0014\u0127\b\u0014"+
		"\u000b\u0014\f\u0014\u0128\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u0130\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u0137\b\u0015\n\u0015\f\u0015\u013a"+
		"\t\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u0141\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u014a\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u016a"+
		"\b\u001a\n\u001a\f\u001a\u016d\t\u001a\u0001\u001a\u0003\u001a\u0170\b"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0004\u001b\u0178\b\u001b\u000b\u001b\f\u001b\u0179\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0004\u001c"+
		"\u0182\b\u001c\u000b\u001c\f\u001c\u0183\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u018d"+
		"\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0198\b\u001d\n"+
		"\u001d\f\u001d\u019b\t\u001d\u0001\u001e\u0001\u001e\u0005\u001e\u019f"+
		"\b\u001e\n\u001e\f\u001e\u01a2\t\u001e\u0001\u001f\u0005\u001f\u01a5\b"+
		"\u001f\n\u001f\f\u001f\u01a8\t\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0005 \u01ae\b \n \f \u01b1\t \u0001!\u0005!\u01b4\b!\n!\f!\u01b7\t"+
		"!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01cf\b\"\u0001#\u0001#\u0001"+
		"#\u0001#\u0003#\u01d5\b#\u0001#\u0001#\u0001#\u0001$\u0004$\u01db\b$\u000b"+
		"$\f$\u01dc\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0003"+
		"&\u01e7\b&\u0001&\u0001&\u0001&\u0001\'\u0004\'\u01ed\b\'\u000b\'\f\'"+
		"\u01ee\u0001(\u0001(\u0001(\u0001(\u0001)\u0001)\u0001*\u0001*\u0001*"+
		"\u0003*\u01fa\b*\u0001*\u0001*\u0001+\u0001+\u0001+\u0005+\u0201\b+\n"+
		"+\f+\u0204\t+\u0001+\u0000\u0001:,\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDF"+
		"HJLNPRTV\u0000\u0003\u0001\u0000*+\u0001\u0000,.\u0001\u0000\u0011\u0015"+
		"\u022a\u0000[\u0001\u0000\u0000\u0000\u0002b\u0001\u0000\u0000\u0000\u0004"+
		"d\u0001\u0000\u0000\u0000\u0006\u0082\u0001\u0000\u0000\u0000\b\u0084"+
		"\u0001\u0000\u0000\u0000\n\u008b\u0001\u0000\u0000\u0000\f\u0095\u0001"+
		"\u0000\u0000\u0000\u000e\u0097\u0001\u0000\u0000\u0000\u0010\u00b3\u0001"+
		"\u0000\u0000\u0000\u0012\u00c1\u0001\u0000\u0000\u0000\u0014\u00e6\u0001"+
		"\u0000\u0000\u0000\u0016\u00e8\u0001\u0000\u0000\u0000\u0018\u00f4\u0001"+
		"\u0000\u0000\u0000\u001a\u00fc\u0001\u0000\u0000\u0000\u001c\u0100\u0001"+
		"\u0000\u0000\u0000\u001e\u0105\u0001\u0000\u0000\u0000 \u010a\u0001\u0000"+
		"\u0000\u0000\"\u010e\u0001\u0000\u0000\u0000$\u0115\u0001\u0000\u0000"+
		"\u0000&\u0119\u0001\u0000\u0000\u0000(\u012f\u0001\u0000\u0000\u0000*"+
		"\u0140\u0001\u0000\u0000\u0000,\u0142\u0001\u0000\u0000\u0000.\u014b\u0001"+
		"\u0000\u0000\u00000\u0153\u0001\u0000\u0000\u00002\u0159\u0001\u0000\u0000"+
		"\u00004\u0163\u0001\u0000\u0000\u00006\u0173\u0001\u0000\u0000\u00008"+
		"\u017e\u0001\u0000\u0000\u0000:\u018c\u0001\u0000\u0000\u0000<\u019c\u0001"+
		"\u0000\u0000\u0000>\u01a6\u0001\u0000\u0000\u0000@\u01ab\u0001\u0000\u0000"+
		"\u0000B\u01b5\u0001\u0000\u0000\u0000D\u01ce\u0001\u0000\u0000\u0000F"+
		"\u01d0\u0001\u0000\u0000\u0000H\u01da\u0001\u0000\u0000\u0000J\u01de\u0001"+
		"\u0000\u0000\u0000L\u01e2\u0001\u0000\u0000\u0000N\u01ec\u0001\u0000\u0000"+
		"\u0000P\u01f0\u0001\u0000\u0000\u0000R\u01f4\u0001\u0000\u0000\u0000T"+
		"\u01f6\u0001\u0000\u0000\u0000V\u01fd\u0001\u0000\u0000\u0000XZ\u0003"+
		"\u0002\u0001\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000"+
		"[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0001\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000^c\u0003F#\u0000_c\u0003L&\u0000"+
		"`c\u0003\u0006\u0003\u0000ac\u0003\u0004\u0002\u0000b^\u0001\u0000\u0000"+
		"\u0000b_\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000ba\u0001\u0000"+
		"\u0000\u0000c\u0003\u0001\u0000\u0000\u0000de\u0005\r\u0000\u0000ei\u0005"+
		"\'\u0000\u0000fg\u0005\u0001\u0000\u0000gh\u0005(\u0000\u0000hj\u0005"+
		"\u0002\u0000\u0000if\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000"+
		"jo\u0001\u0000\u0000\u0000km\u00053\u0000\u0000lk\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000np\u0003<\u001e\u0000"+
		"ol\u0001\u0000\u0000\u0000op\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qr\u0005\u000e\u0000\u0000r\u0005\u0001\u0000\u0000\u0000st\u0003"+
		"R)\u0000tu\u0005\'\u0000\u0000uw\u0005\u0003\u0000\u0000vx\u0003\u000e"+
		"\u0007\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xy\u0001"+
		"\u0000\u0000\u0000yz\u0005\u0004\u0000\u0000z{\u0003\b\u0004\u0000{\u0083"+
		"\u0001\u0000\u0000\u0000|}\u0003R)\u0000}~\u0005\u0016\u0000\u0000~\u007f"+
		"\u0005\u0003\u0000\u0000\u007f\u0080\u0005\u0004\u0000\u0000\u0080\u0081"+
		"\u0003\b\u0004\u0000\u0081\u0083\u0001\u0000\u0000\u0000\u0082s\u0001"+
		"\u0000\u0000\u0000\u0082|\u0001\u0000\u0000\u0000\u0083\u0007\u0001\u0000"+
		"\u0000\u0000\u0084\u0086\u0005\u0005\u0000\u0000\u0085\u0087\u0003\n\u0005"+
		"\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0005\u0006\u0000"+
		"\u0000\u0089\t\u0001\u0000\u0000\u0000\u008a\u008c\u0003\f\u0006\u0000"+
		"\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u000b\u0001\u0000\u0000\u0000\u008f\u0096\u0003\u0010\b\u0000\u0090"+
		"\u0092\u0005\u0017\u0000\u0000\u0091\u0093\u0003<\u001e\u0000\u0092\u0091"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\u0096\u0005\u000e\u0000\u0000\u0095\u008f"+
		"\u0001\u0000\u0000\u0000\u0095\u0090\u0001\u0000\u0000\u0000\u0096\r\u0001"+
		"\u0000\u0000\u0000\u0097\u0099\u0003R)\u0000\u0098\u009a\u0005,\u0000"+
		"\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u00a5\u0005\'\u0000\u0000"+
		"\u009c\u009d\u00054\u0000\u0000\u009d\u009f\u0003R)\u0000\u009e\u00a0"+
		"\u0005,\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u009f\u00a0\u0001"+
		"\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005"+
		"\'\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000\u00a3\u009c\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u000f\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00aa\u0003\u0012"+
		"\t\u0000\u00a9\u00ab\u0005\u000e\u0000\u0000\u00aa\u00a9\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00b4\u0001\u0000\u0000"+
		"\u0000\u00ac\u00b4\u0003,\u0016\u0000\u00ad\u00b4\u0003.\u0017\u0000\u00ae"+
		"\u00b4\u00030\u0018\u0000\u00af\u00b4\u00032\u0019\u0000\u00b0\u00b4\u0003"+
		"4\u001a\u0000\u00b1\u00b4\u0003\b\u0004\u0000\u00b2\u00b4\u0005\u000e"+
		"\u0000\u0000\u00b3\u00a8\u0001\u0000\u0000\u0000\u00b3\u00ac\u0001\u0000"+
		"\u0000\u0000\u00b3\u00ad\u0001\u0000\u0000\u0000\u00b3\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b3\u00af\u0001\u0000\u0000\u0000\u00b3\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u0011\u0001\u0000\u0000\u0000\u00b5\u00c2\u0003\u0014"+
		"\n\u0000\u00b6\u00c2\u0003\u0016\u000b\u0000\u00b7\u00c2\u0003\u001a\r"+
		"\u0000\u00b8\u00c2\u0003\u001c\u000e\u0000\u00b9\u00c2\u0003\u001e\u000f"+
		"\u0000\u00ba\u00c2\u0003 \u0010\u0000\u00bb\u00c2\u0003\"\u0011\u0000"+
		"\u00bc\u00c2\u0003$\u0012\u0000\u00bd\u00c2\u0003&\u0013\u0000\u00be\u00c2"+
		"\u0003(\u0014\u0000\u00bf\u00c2\u0003*\u0015\u0000\u00c0\u00c2\u0003T"+
		"*\u0000\u00c1\u00b5\u0001\u0000\u0000\u0000\u00c1\u00b6\u0001\u0000\u0000"+
		"\u0000\u00c1\u00b7\u0001\u0000\u0000\u0000\u00c1\u00b8\u0001\u0000\u0000"+
		"\u0000\u00c1\u00b9\u0001\u0000\u0000\u0000\u00c1\u00ba\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bb\u0001\u0000\u0000\u0000\u00c1\u00bc\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bd\u0001\u0000\u0000\u0000\u00c1\u00be\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000"+
		"\u0000\u00c2\u0013\u0001\u0000\u0000\u0000\u00c3\u00c4\u0003R)\u0000\u00c4"+
		"\u00c7\u0005\'\u0000\u0000\u00c5\u00c6\u00053\u0000\u0000\u00c6\u00c8"+
		"\u0003<\u001e\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001"+
		"\u0000\u0000\u0000\u00c8\u00e7\u0001\u0000\u0000\u0000\u00c9\u00ca\u0003"+
		"R)\u0000\u00ca\u00cb\u0005\'\u0000\u0000\u00cb\u00cc\u00053\u0000\u0000"+
		"\u00cc\u00cd\u0003T*\u0000\u00cd\u00e7\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0005\'\u0000\u0000\u00cf\u00d0\u00053\u0000\u0000\u00d0\u00e7\u0003"+
		"<\u001e\u0000\u00d1\u00d2\u0005\'\u0000\u0000\u00d2\u00d3\u0005\u0001"+
		"\u0000\u0000\u00d3\u00d4\u0003<\u001e\u0000\u00d4\u00d5\u0005\u0002\u0000"+
		"\u0000\u00d5\u00d6\u00053\u0000\u0000\u00d6\u00d7\u0003<\u001e\u0000\u00d7"+
		"\u00e7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\'\u0000\u0000\u00d9\u00e7"+
		"\u0005\u0007\u0000\u0000\u00da\u00db\u0005\'\u0000\u0000\u00db\u00e7\u0005"+
		"\b\u0000\u0000\u00dc\u00dd\u0005\'\u0000\u0000\u00dd\u00de\u0005\t\u0000"+
		"\u0000\u00de\u00e7\u0003<\u001e\u0000\u00df\u00e0\u0005\'\u0000\u0000"+
		"\u00e0\u00e1\u0005\n\u0000\u0000\u00e1\u00e7\u0003<\u001e\u0000\u00e2"+
		"\u00e3\u0005,\u0000\u0000\u00e3\u00e4\u0005\'\u0000\u0000\u00e4\u00e5"+
		"\u00053\u0000\u0000\u00e5\u00e7\u0003<\u001e\u0000\u00e6\u00c3\u0001\u0000"+
		"\u0000\u0000\u00e6\u00c9\u0001\u0000\u0000\u0000\u00e6\u00ce\u0001\u0000"+
		"\u0000\u0000\u00e6\u00d1\u0001\u0000\u0000\u0000\u00e6\u00d8\u0001\u0000"+
		"\u0000\u0000\u00e6\u00da\u0001\u0000\u0000\u0000\u00e6\u00dc\u0001\u0000"+
		"\u0000\u0000\u00e6\u00df\u0001\u0000\u0000\u0000\u00e6\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e7\u0015\u0001\u0000\u0000\u0000\u00e8\u00e9\u0003R)\u0000"+
		"\u00e9\u00ea\u0005\'\u0000\u0000\u00ea\u00eb\u0005\u0001\u0000\u0000\u00eb"+
		"\u00ec\u0005(\u0000\u0000\u00ec\u00f2\u0005\u0002\u0000\u0000\u00ed\u00ee"+
		"\u00053\u0000\u0000\u00ee\u00ef\u0005\u0005\u0000\u0000\u00ef\u00f0\u0003"+
		"\u0018\f\u0000\u00f0\u00f1\u0005\u0006\u0000\u0000\u00f1\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f2\u00ed\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f3\u0017\u0001\u0000\u0000\u0000\u00f4\u00f9\u0003<\u001e"+
		"\u0000\u00f5\u00f6\u00054\u0000\u0000\u00f6\u00f8\u0003<\u001e\u0000\u00f7"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa"+
		"\u0019\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc"+
		"\u00fd\u0003R)\u0000\u00fd\u00fe\u0005,\u0000\u0000\u00fe\u00ff\u0005"+
		"\'\u0000\u0000\u00ff\u001b\u0001\u0000\u0000\u0000\u0100\u0101\u0005\'"+
		"\u0000\u0000\u0101\u0102\u00053\u0000\u0000\u0102\u0103\u0005\u000b\u0000"+
		"\u0000\u0103\u0104\u0005\'\u0000\u0000\u0104\u001d\u0001\u0000\u0000\u0000"+
		"\u0105\u0106\u0005,\u0000\u0000\u0106\u0107\u0005\'\u0000\u0000\u0107"+
		"\u0108\u00053\u0000\u0000\u0108\u0109\u0003<\u001e\u0000\u0109\u001f\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0005\u001c\u0000\u0000\u010b\u010c\u0005"+
		"\'\u0000\u0000\u010c\u010d\u0005\'\u0000\u0000\u010d!\u0001\u0000\u0000"+
		"\u0000\u010e\u010f\u0005\'\u0000\u0000\u010f\u0110\u00055\u0000\u0000"+
		"\u0110\u0113\u0005\'\u0000\u0000\u0111\u0112\u00053\u0000\u0000\u0112"+
		"\u0114\u0003<\u001e\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114"+
		"\u0001\u0000\u0000\u0000\u0114#\u0001\u0000\u0000\u0000\u0115\u0116\u0005"+
		"\u001d\u0000\u0000\u0116\u0117\u0005\'\u0000\u0000\u0117\u0118\u0005\'"+
		"\u0000\u0000\u0118%\u0001\u0000\u0000\u0000\u0119\u011a\u0005\'\u0000"+
		"\u0000\u011a\u011b\u00055\u0000\u0000\u011b\u011e\u0005\'\u0000\u0000"+
		"\u011c\u011d\u00053\u0000\u0000\u011d\u011f\u0003<\u001e\u0000\u011e\u011c"+
		"\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\'\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0005\u0018\u0000\u0000\u0121\u0122\u0005"+
		"\u0003\u0000\u0000\u0122\u0126\u00056\u0000\u0000\u0123\u0124\u00054\u0000"+
		"\u0000\u0124\u0125\u0005\u000b\u0000\u0000\u0125\u0127\u0005\'\u0000\u0000"+
		"\u0126\u0123\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000"+
		"\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000"+
		"\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u0130\u0005\u0004\u0000\u0000"+
		"\u012b\u012c\u0005\u001a\u0000\u0000\u012c\u012d\u0005\u0003\u0000\u0000"+
		"\u012d\u012e\u0005\'\u0000\u0000\u012e\u0130\u0005\u0004\u0000\u0000\u012f"+
		"\u0120\u0001\u0000\u0000\u0000\u012f\u012b\u0001\u0000\u0000\u0000\u0130"+
		")\u0001\u0000\u0000\u0000\u0131\u0132\u0005\u0019\u0000\u0000\u0132\u0133"+
		"\u0005\u0003\u0000\u0000\u0133\u0138\u00056\u0000\u0000\u0134\u0135\u0005"+
		"4\u0000\u0000\u0135\u0137\u0003<\u001e\u0000\u0136\u0134\u0001\u0000\u0000"+
		"\u0000\u0137\u013a\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000"+
		"\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u013b\u0001\u0000\u0000"+
		"\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013b\u0141\u0005\u0004\u0000"+
		"\u0000\u013c\u013d\u0005\u001b\u0000\u0000\u013d\u013e\u0005\u0003\u0000"+
		"\u0000\u013e\u013f\u0005\'\u0000\u0000\u013f\u0141\u0005\u0004\u0000\u0000"+
		"\u0140\u0131\u0001\u0000\u0000\u0000\u0140\u013c\u0001\u0000\u0000\u0000"+
		"\u0141+\u0001\u0000\u0000\u0000\u0142\u0143\u0005\u001e\u0000\u0000\u0143"+
		"\u0144\u0005\u0003\u0000\u0000\u0144\u0145\u0003:\u001d\u0000\u0145\u0146"+
		"\u0005\u0004\u0000\u0000\u0146\u0149\u0003\b\u0004\u0000\u0147\u0148\u0005"+
		"\u001f\u0000\u0000\u0148\u014a\u0003\b\u0004\u0000\u0149\u0147\u0001\u0000"+
		"\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a-\u0001\u0000\u0000"+
		"\u0000\u014b\u014c\u0005&\u0000\u0000\u014c\u014d\u0003\b\u0004\u0000"+
		"\u014d\u014e\u0005$\u0000\u0000\u014e\u014f\u0005\u0003\u0000\u0000\u014f"+
		"\u0150\u0003:\u001d\u0000\u0150\u0151\u0005\u0004\u0000\u0000\u0151\u0152"+
		"\u0005\u000e\u0000\u0000\u0152/\u0001\u0000\u0000\u0000\u0153\u0154\u0005"+
		"$\u0000\u0000\u0154\u0155\u0005\u0003\u0000\u0000\u0155\u0156\u0003:\u001d"+
		"\u0000\u0156\u0157\u0005\u0004\u0000\u0000\u0157\u0158\u0003\b\u0004\u0000"+
		"\u01581\u0001\u0000\u0000\u0000\u0159\u015a\u0005%\u0000\u0000\u015a\u015b"+
		"\u0005\u0003\u0000\u0000\u015b\u015c\u0003\u0014\n\u0000\u015c\u015d\u0005"+
		"\u000e\u0000\u0000\u015d\u015e\u0003:\u001d\u0000\u015e\u015f\u0005\u000e"+
		"\u0000\u0000\u015f\u0160\u0003\u0014\n\u0000\u0160\u0161\u0005\u0004\u0000"+
		"\u0000\u0161\u0162\u0003\b\u0004\u0000\u01623\u0001\u0000\u0000\u0000"+
		"\u0163\u0164\u0005 \u0000\u0000\u0164\u0165\u0005\u0003\u0000\u0000\u0165"+
		"\u0166\u0005\'\u0000\u0000\u0166\u0167\u0005\u0004\u0000\u0000\u0167\u016b"+
		"\u0005\u0005\u0000\u0000\u0168\u016a\u00036\u001b\u0000\u0169\u0168\u0001"+
		"\u0000\u0000\u0000\u016a\u016d\u0001\u0000\u0000\u0000\u016b\u0169\u0001"+
		"\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016f\u0001"+
		"\u0000\u0000\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016e\u0170\u0003"+
		"8\u001c\u0000\u016f\u016e\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000"+
		"\u0000\u0000\u0170\u0171\u0001\u0000\u0000\u0000\u0171\u0172\u0005\u0006"+
		"\u0000\u0000\u01725\u0001\u0000\u0000\u0000\u0173\u0174\u0005!\u0000\u0000"+
		"\u0174\u0175\u0005(\u0000\u0000\u0175\u0177\u0005\f\u0000\u0000\u0176"+
		"\u0178\u0003\u0010\b\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178\u0179"+
		"\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u0179\u017a"+
		"\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000\u017b\u017c"+
		"\u0005\"\u0000\u0000\u017c\u017d\u0005\u000e\u0000\u0000\u017d7\u0001"+
		"\u0000\u0000\u0000\u017e\u017f\u0005#\u0000\u0000\u017f\u0181\u0005\f"+
		"\u0000\u0000\u0180\u0182\u0003\u0010\b\u0000\u0181\u0180\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0181\u0001\u0000\u0000"+
		"\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000"+
		"\u0000\u0185\u0186\u0005\"\u0000\u0000\u0186\u0187\u0005\u000e\u0000\u0000"+
		"\u01879\u0001\u0000\u0000\u0000\u0188\u0189\u0006\u001d\uffff\uffff\u0000"+
		"\u0189\u018d\u0003<\u001e\u0000\u018a\u018b\u00051\u0000\u0000\u018b\u018d"+
		"\u0003:\u001d\u0001\u018c\u0188\u0001\u0000\u0000\u0000\u018c\u018a\u0001"+
		"\u0000\u0000\u0000\u018d\u0199\u0001\u0000\u0000\u0000\u018e\u018f\n\u0005"+
		"\u0000\u0000\u018f\u0190\u00052\u0000\u0000\u0190\u0198\u0003:\u001d\u0006"+
		"\u0191\u0192\n\u0003\u0000\u0000\u0192\u0193\u0005/\u0000\u0000\u0193"+
		"\u0198\u0003:\u001d\u0004\u0194\u0195\n\u0002\u0000\u0000\u0195\u0196"+
		"\u00050\u0000\u0000\u0196\u0198\u0003:\u001d\u0003\u0197\u018e\u0001\u0000"+
		"\u0000\u0000\u0197\u0191\u0001\u0000\u0000\u0000\u0197\u0194\u0001\u0000"+
		"\u0000\u0000\u0198\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000"+
		"\u0000\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019a;\u0001\u0000\u0000"+
		"\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019c\u01a0\u0003@ \u0000\u019d"+
		"\u019f\u0003>\u001f\u0000\u019e\u019d\u0001\u0000\u0000\u0000\u019f\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a0\u01a1"+
		"\u0001\u0000\u0000\u0000\u01a1=\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a5\u0007\u0000\u0000\u0000\u01a4\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a5\u01a8\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a9\u0001"+
		"\u0000\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a9\u01aa\u0003"+
		"@ \u0000\u01aa?\u0001\u0000\u0000\u0000\u01ab\u01af\u0003D\"\u0000\u01ac"+
		"\u01ae\u0003B!\u0000\u01ad\u01ac\u0001\u0000\u0000\u0000\u01ae\u01b1\u0001"+
		"\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01af\u01b0\u0001"+
		"\u0000\u0000\u0000\u01b0A\u0001\u0000\u0000\u0000\u01b1\u01af\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b4\u0007\u0001\u0000\u0000\u01b3\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5\u01b3\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01b8\u0001\u0000"+
		"\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8\u01b9\u0003D\""+
		"\u0000\u01b9C\u0001\u0000\u0000\u0000\u01ba\u01bb\u0005\u0003\u0000\u0000"+
		"\u01bb\u01bc\u0003<\u001e\u0000\u01bc\u01bd\u0005\u0004\u0000\u0000\u01bd"+
		"\u01cf\u0001\u0000\u0000\u0000\u01be\u01cf\u0003T*\u0000\u01bf\u01c0\u0005"+
		"\'\u0000\u0000\u01c0\u01c1\u0005\u0001\u0000\u0000\u01c1\u01c2\u0003<"+
		"\u001e\u0000\u01c2\u01c3\u0005\u0002\u0000\u0000\u01c3\u01cf\u0001\u0000"+
		"\u0000\u0000\u01c4\u01c5\u0005\u000b\u0000\u0000\u01c5\u01cf\u0005\'\u0000"+
		"\u0000\u01c6\u01c7\u0005,\u0000\u0000\u01c7\u01cf\u0005\'\u0000\u0000"+
		"\u01c8\u01cf\u00056\u0000\u0000\u01c9\u01cf\u0005\'\u0000\u0000\u01ca"+
		"\u01cf\u0003\"\u0011\u0000\u01cb\u01cf\u0003&\u0013\u0000\u01cc\u01cf"+
		"\u0005(\u0000\u0000\u01cd\u01cf\u0005)\u0000\u0000\u01ce\u01ba\u0001\u0000"+
		"\u0000\u0000\u01ce\u01be\u0001\u0000\u0000\u0000\u01ce\u01bf\u0001\u0000"+
		"\u0000\u0000\u01ce\u01c4\u0001\u0000\u0000\u0000\u01ce\u01c6\u0001\u0000"+
		"\u0000\u0000\u01ce\u01c8\u0001\u0000\u0000\u0000\u01ce\u01c9\u0001\u0000"+
		"\u0000\u0000\u01ce\u01ca\u0001\u0000\u0000\u0000\u01ce\u01cb\u0001\u0000"+
		"\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000\u0000\u01ce\u01cd\u0001\u0000"+
		"\u0000\u0000\u01cfE\u0001\u0000\u0000\u0000\u01d0\u01d1\u0005\u001c\u0000"+
		"\u0000\u01d1\u01d2\u0005\'\u0000\u0000\u01d2\u01d4\u0005\u0005\u0000\u0000"+
		"\u01d3\u01d5\u0003H$\u0000\u01d4\u01d3\u0001\u0000\u0000\u0000\u01d4\u01d5"+
		"\u0001\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d7"+
		"\u0005\u0006\u0000\u0000\u01d7\u01d8\u0005\u000e\u0000\u0000\u01d8G\u0001"+
		"\u0000\u0000\u0000\u01d9\u01db\u0003J%\u0000\u01da\u01d9\u0001\u0000\u0000"+
		"\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc\u01da\u0001\u0000\u0000"+
		"\u0000\u01dc\u01dd\u0001\u0000\u0000\u0000\u01ddI\u0001\u0000\u0000\u0000"+
		"\u01de\u01df\u0003R)\u0000\u01df\u01e0\u0005\'\u0000\u0000\u01e0\u01e1"+
		"\u0005\u000e\u0000\u0000\u01e1K\u0001\u0000\u0000\u0000\u01e2\u01e3\u0005"+
		"\u001d\u0000\u0000\u01e3\u01e4\u0005\'\u0000\u0000\u01e4\u01e6\u0005\u0005"+
		"\u0000\u0000\u01e5\u01e7\u0003N\'\u0000\u01e6\u01e5\u0001\u0000\u0000"+
		"\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e8\u0001\u0000\u0000"+
		"\u0000\u01e8\u01e9\u0005\u0006\u0000\u0000\u01e9\u01ea\u0005\u000e\u0000"+
		"\u0000\u01eaM\u0001\u0000\u0000\u0000\u01eb\u01ed\u0003P(\u0000\u01ec"+
		"\u01eb\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ec\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000\u01ef"+
		"O\u0001\u0000\u0000\u0000\u01f0\u01f1\u0003R)\u0000\u01f1\u01f2\u0005"+
		"\'\u0000\u0000\u01f2\u01f3\u0005\u000e\u0000\u0000\u01f3Q\u0001\u0000"+
		"\u0000\u0000\u01f4\u01f5\u0007\u0002\u0000\u0000\u01f5S\u0001\u0000\u0000"+
		"\u0000\u01f6\u01f7\u0005\'\u0000\u0000\u01f7\u01f9\u0005\u0003\u0000\u0000"+
		"\u01f8\u01fa\u0003V+\u0000\u01f9\u01f8\u0001\u0000\u0000\u0000\u01f9\u01fa"+
		"\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb\u01fc"+
		"\u0005\u0004\u0000\u0000\u01fcU\u0001\u0000\u0000\u0000\u01fd\u0202\u0003"+
		"<\u001e\u0000\u01fe\u01ff\u00054\u0000\u0000\u01ff\u0201\u0003<\u001e"+
		"\u0000\u0200\u01fe\u0001\u0000\u0000\u0000\u0201\u0204\u0001\u0000\u0000"+
		"\u0000\u0202\u0200\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000"+
		"\u0000\u0203W\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000\u0000\u0000"+
		".[bilow\u0082\u0086\u008d\u0092\u0095\u0099\u009f\u00a5\u00aa\u00b3\u00c1"+
		"\u00c7\u00e6\u00f2\u00f9\u0113\u011e\u0128\u012f\u0138\u0140\u0149\u016b"+
		"\u016f\u0179\u0183\u018c\u0197\u0199\u01a0\u01a6\u01af\u01b5\u01ce\u01d4"+
		"\u01dc\u01e6\u01ee\u01f9\u0202";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}