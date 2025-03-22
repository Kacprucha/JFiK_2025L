// Generated from c:/Users/User/Desktop/Sem 8/Kompilatory/JFiK_2025L/karas/Cmash.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class CmashParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, ID=31, INT=32, 
		FLOAT=33, DOUBLE=34, CHAR_LITERAL=35, PLAIN_TEXT=36, BOOL_LITERAL=37, 
		ASSIGNMENTOPERATOR=38, IF=39, ELSE=40, FOR=41, WHILE=42, RETURN=43, ENDOFLINE=44, 
		WS=45;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_variableList = 2, RULE_variable = 3, 
		RULE_functionDefinition = 4, RULE_type = 5, RULE_parameters = 6, RULE_parameter = 7, 
		RULE_compoundStatement = 8, RULE_statement = 9, RULE_expressionStatement = 10, 
		RULE_expression = 11, RULE_assignment = 12, RULE_equality = 13, RULE_relational = 14, 
		RULE_additive = 15, RULE_multiplicative = 16, RULE_primary = 17, RULE_selectionStatement = 18, 
		RULE_iterationStatement = 19, RULE_loopStatement = 20, RULE_jumpStatement = 21, 
		RULE_ioStatement = 22, RULE_printArgs = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "variableList", "variable", "functionDefinition", 
			"type", "parameters", "parameter", "compoundStatement", "statement", 
			"expressionStatement", "expression", "assignment", "equality", "relational", 
			"additive", "multiplicative", "primary", "selectionStatement", "iterationStatement", 
			"loopStatement", "jumpStatement", "ioStatement", "printArgs"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'='", "'('", "')'", "'int'", "'float'", "'void'", "'char'", 
			"'{'", "'}'", "'&&'", "'||'", "'^'", "'!'", "'++'", "'--'", "'=='", "'!='", 
			"'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "';'", 
			"'print'", "'read'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "ID", "INT", "FLOAT", "DOUBLE", 
			"CHAR_LITERAL", "PLAIN_TEXT", "BOOL_LITERAL", "ASSIGNMENTOPERATOR", "IF", 
			"ELSE", "FOR", "WHILE", "RETURN", "ENDOFLINE", "WS"
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
	public String getGrammarFileName() { return "Cmash.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmashParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CmashParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2147484128L) != 0)) {
				{
				setState(50);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(48);
					declaration();
					}
					break;
				case 2:
					{
					setState(49);
					functionDefinition();
					}
					break;
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(EOF);
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
		public VariableListContext variableList() {
			return getRuleContext(VariableListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ENDOFLINE() { return getToken(CmashParser.ENDOFLINE, 0); }
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) {
				{
				setState(57);
				type();
				}
			}

			setState(60);
			variableList();
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ENDOFLINE) {
				{
				setState(61);
				match(ENDOFLINE);
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
	public static class VariableListContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public VariableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableList; }
	}

	public final VariableListContext variableList() throws RecognitionException {
		VariableListContext _localctx = new VariableListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_variableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			variable();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(65);
				match(T__0);
				setState(66);
				variable();
				}
				}
				setState(71);
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
	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(ID);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(73);
				match(T__1);
				setState(74);
				expression(0);
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
	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			type();
			setState(78);
			match(ID);
			setState(79);
			match(T__2);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) {
				{
				setState(80);
				parameters();
				}
			}

			setState(83);
			match(T__3);
			setState(84);
			compoundStatement();
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
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
	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			parameter();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(89);
				match(T__0);
				setState(90);
				parameter();
				}
				}
				setState(95);
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
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			type();
			setState(97);
			match(ID);
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
	public static class CompoundStatementContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CompoundStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStatement; }
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__8);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16148540179432L) != 0)) {
				{
				setState(102);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(100);
					declaration();
					}
					break;
				case 2:
					{
					setState(101);
					statement();
					}
					break;
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(T__9);
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
	public static class StatementContext extends ParserRuleContext {
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public SelectionStatementContext selectionStatement() {
			return getRuleContext(SelectionStatementContext.class,0);
		}
		public IterationStatementContext iterationStatement() {
			return getRuleContext(IterationStatementContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public IoStatementContext ioStatement() {
			return getRuleContext(IoStatementContext.class,0);
		}
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__13:
			case ID:
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR_LITERAL:
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				expressionStatement();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				compoundStatement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				selectionStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(112);
				iterationStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(113);
				loopStatement();
				}
				break;
			case T__28:
			case T__29:
				enterOuterAlt(_localctx, 6);
				{
				setState(114);
				ioStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 7);
				{
				setState(115);
				jumpStatement();
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
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDOFLINE() { return getToken(CmashParser.ENDOFLINE, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			expression(0);
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ENDOFLINE) {
				{
				setState(119);
				match(ENDOFLINE);
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
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode BOOL_LITERAL() { return getToken(CmashParser.BOOL_LITERAL, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode CHAR_LITERAL() { return getToken(CmashParser.CHAR_LITERAL, 0); }
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(CmashParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(CmashParser.DOUBLE, 0); }
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(123);
				match(BOOL_LITERAL);
				}
				break;
			case 2:
				{
				setState(124);
				match(T__13);
				setState(125);
				expression(9);
				}
				break;
			case 3:
				{
				setState(126);
				match(CHAR_LITERAL);
				}
				break;
			case 4:
				{
				setState(127);
				match(INT);
				}
				break;
			case 5:
				{
				setState(128);
				match(FLOAT);
				}
				break;
			case 6:
				{
				setState(129);
				match(DOUBLE);
				}
				break;
			case 7:
				{
				setState(130);
				match(ID);
				}
				break;
			case 8:
				{
				setState(131);
				match(ID);
				setState(132);
				match(T__14);
				}
				break;
			case 9:
				{
				setState(133);
				match(ID);
				setState(134);
				match(T__15);
				}
				break;
			case 10:
				{
				setState(135);
				assignment();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(149);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(147);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(139);
						match(T__10);
						setState(140);
						expression(13);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(142);
						match(T__11);
						setState(143);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(145);
						match(T__12);
						setState(146);
						expression(11);
						}
						break;
					}
					} 
				}
				setState(151);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public TerminalNode ASSIGNMENTOPERATOR() { return getToken(CmashParser.ASSIGNMENTOPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignment);
		try {
			setState(156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(ID);
				setState(153);
				match(ASSIGNMENTOPERATOR);
				setState(154);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				equality();
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
	public static class EqualityContext extends ParserRuleContext {
		public List<RelationalContext> relational() {
			return getRuleContexts(RelationalContext.class);
		}
		public RelationalContext relational(int i) {
			return getRuleContext(RelationalContext.class,i);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_equality);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			relational();
			setState(163);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(159);
					_la = _input.LA(1);
					if ( !(_la==T__16 || _la==T__17) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(160);
					relational();
					}
					} 
				}
				setState(165);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class RelationalContext extends ParserRuleContext {
		public List<AdditiveContext> additive() {
			return getRuleContexts(AdditiveContext.class);
		}
		public AdditiveContext additive(int i) {
			return getRuleContext(AdditiveContext.class,i);
		}
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_relational);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			additive();
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(167);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7864320L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(168);
					additive();
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
	public static class AdditiveContext extends ParserRuleContext {
		public List<MultiplicativeContext> multiplicative() {
			return getRuleContexts(MultiplicativeContext.class);
		}
		public MultiplicativeContext multiplicative(int i) {
			return getRuleContext(MultiplicativeContext.class,i);
		}
		public AdditiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive; }
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_additive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			multiplicative();
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(175);
					_la = _input.LA(1);
					if ( !(_la==T__22 || _la==T__23) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(176);
					multiplicative();
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class MultiplicativeContext extends ParserRuleContext {
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public MultiplicativeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicative; }
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_multiplicative);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			primary();
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(183);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881024L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(184);
					primary();
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_primary);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				match(ID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				match(INT);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(T__2);
				setState(193);
				expression(0);
				setState(194);
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
	public static class SelectionStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(CmashParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(CmashParser.ELSE, 0); }
		public SelectionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectionStatement; }
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(IF);
			setState(199);
			match(T__2);
			setState(200);
			expression(0);
			setState(201);
			match(T__3);
			setState(202);
			statement();
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(203);
				match(ELSE);
				setState(204);
				statement();
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
	public static class IterationStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(CmashParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IterationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iterationStatement; }
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_iterationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(WHILE);
			setState(208);
			match(T__2);
			setState(209);
			expression(0);
			setState(210);
			match(T__3);
			setState(211);
			statement();
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
	public static class LoopStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(CmashParser.FOR, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_loopStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(FOR);
			setState(214);
			match(T__2);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2147484128L) != 0)) {
				{
				setState(215);
				declaration();
				}
			}

			setState(218);
			match(T__27);
			setState(219);
			assignment();
			setState(220);
			match(T__27);
			setState(221);
			expression(0);
			setState(222);
			match(T__3);
			setState(223);
			statement();
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
	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CmashParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ENDOFLINE() { return getToken(CmashParser.ENDOFLINE, 0); }
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(RETURN);
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(226);
				expression(0);
				}
				break;
			}
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ENDOFLINE) {
				{
				setState(229);
				match(ENDOFLINE);
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
	public static class IoStatementContext extends ParserRuleContext {
		public PrintArgsContext printArgs() {
			return getRuleContext(PrintArgsContext.class,0);
		}
		public TerminalNode ENDOFLINE() { return getToken(CmashParser.ENDOFLINE, 0); }
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public IoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ioStatement; }
	}

	public final IoStatementContext ioStatement() throws RecognitionException {
		IoStatementContext _localctx = new IoStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ioStatement);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				match(T__28);
				setState(233);
				match(T__2);
				setState(234);
				printArgs();
				setState(235);
				match(T__3);
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ENDOFLINE) {
					{
					setState(236);
					match(ENDOFLINE);
					}
				}

				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				match(T__29);
				setState(240);
				match(T__2);
				setState(241);
				match(ID);
				setState(242);
				match(T__3);
				setState(244);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ENDOFLINE) {
					{
					setState(243);
					match(ENDOFLINE);
					}
				}

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
	public static class PrintArgsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLAIN_TEXT() { return getToken(CmashParser.PLAIN_TEXT, 0); }
		public PrintArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printArgs; }
	}

	public final PrintArgsContext printArgs() throws RecognitionException {
		PrintArgsContext _localctx = new PrintArgsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_printArgs);
		int _la;
		try {
			setState(257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case T__13:
			case ID:
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR_LITERAL:
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				expression(0);
				setState(253);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(249);
					match(T__0);
					setState(250);
					expression(0);
					}
					}
					setState(255);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case PLAIN_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(PLAIN_TEXT);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 12);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001-\u0104\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001\u0000"+
		"\u0005\u00003\b\u0000\n\u0000\f\u00006\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"?\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002D\b\u0002\n\u0002"+
		"\f\u0002G\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003L\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004R\b\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0005\u0006\\\b\u0006\n\u0006\f\u0006_\t\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\bg"+
		"\b\b\n\b\f\bj\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tu\b\t\u0001\n\u0001\n\u0003\ny\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0089\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u0094\b\u000b\n\u000b\f\u000b\u0097\t\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u009d\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00a2"+
		"\b\r\n\r\f\r\u00a5\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u00aa\b\u000e\n\u000e\f\u000e\u00ad\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u00b2\b\u000f\n\u000f\f\u000f\u00b5\t\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u00ba\b\u0010\n\u0010\f\u0010\u00bd"+
		"\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u00c5\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00ce\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00d9\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u00e4\b\u0015\u0001\u0015\u0003\u0015\u00e7"+
		"\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003"+
		"\u0016\u00ee\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u00f5\b\u0016\u0003\u0016\u00f7\b\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u00fc\b\u0017\n\u0017\f\u0017\u00ff"+
		"\t\u0017\u0001\u0017\u0003\u0017\u0102\b\u0017\u0001\u0017\u0000\u0001"+
		"\u0016\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0005\u0001\u0000\u0005\b\u0001"+
		"\u0000\u0011\u0012\u0001\u0000\u0013\u0016\u0001\u0000\u0017\u0018\u0001"+
		"\u0000\u0019\u001b\u0118\u00004\u0001\u0000\u0000\u0000\u0002:\u0001\u0000"+
		"\u0000\u0000\u0004@\u0001\u0000\u0000\u0000\u0006H\u0001\u0000\u0000\u0000"+
		"\bM\u0001\u0000\u0000\u0000\nV\u0001\u0000\u0000\u0000\fX\u0001\u0000"+
		"\u0000\u0000\u000e`\u0001\u0000\u0000\u0000\u0010c\u0001\u0000\u0000\u0000"+
		"\u0012t\u0001\u0000\u0000\u0000\u0014v\u0001\u0000\u0000\u0000\u0016\u0088"+
		"\u0001\u0000\u0000\u0000\u0018\u009c\u0001\u0000\u0000\u0000\u001a\u009e"+
		"\u0001\u0000\u0000\u0000\u001c\u00a6\u0001\u0000\u0000\u0000\u001e\u00ae"+
		"\u0001\u0000\u0000\u0000 \u00b6\u0001\u0000\u0000\u0000\"\u00c4\u0001"+
		"\u0000\u0000\u0000$\u00c6\u0001\u0000\u0000\u0000&\u00cf\u0001\u0000\u0000"+
		"\u0000(\u00d5\u0001\u0000\u0000\u0000*\u00e1\u0001\u0000\u0000\u0000,"+
		"\u00f6\u0001\u0000\u0000\u0000.\u0101\u0001\u0000\u0000\u000003\u0003"+
		"\u0002\u0001\u000013\u0003\b\u0004\u000020\u0001\u0000\u0000\u000021\u0001"+
		"\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u0000"+
		"45\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u000078\u0005\u0000\u0000\u00018\u0001\u0001\u0000\u0000\u00009;\u0003"+
		"\n\u0005\u0000:9\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0001"+
		"\u0000\u0000\u0000<>\u0003\u0004\u0002\u0000=?\u0005,\u0000\u0000>=\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?\u0003\u0001\u0000\u0000"+
		"\u0000@E\u0003\u0006\u0003\u0000AB\u0005\u0001\u0000\u0000BD\u0003\u0006"+
		"\u0003\u0000CA\u0001\u0000\u0000\u0000DG\u0001\u0000\u0000\u0000EC\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000F\u0005\u0001\u0000\u0000"+
		"\u0000GE\u0001\u0000\u0000\u0000HK\u0005\u001f\u0000\u0000IJ\u0005\u0002"+
		"\u0000\u0000JL\u0003\u0016\u000b\u0000KI\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000L\u0007\u0001\u0000\u0000\u0000MN\u0003\n\u0005\u0000"+
		"NO\u0005\u001f\u0000\u0000OQ\u0005\u0003\u0000\u0000PR\u0003\f\u0006\u0000"+
		"QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000ST\u0005\u0004\u0000\u0000TU\u0003\u0010\b\u0000U\t\u0001\u0000"+
		"\u0000\u0000VW\u0007\u0000\u0000\u0000W\u000b\u0001\u0000\u0000\u0000"+
		"X]\u0003\u000e\u0007\u0000YZ\u0005\u0001\u0000\u0000Z\\\u0003\u000e\u0007"+
		"\u0000[Y\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^\r\u0001\u0000\u0000\u0000_]\u0001"+
		"\u0000\u0000\u0000`a\u0003\n\u0005\u0000ab\u0005\u001f\u0000\u0000b\u000f"+
		"\u0001\u0000\u0000\u0000ch\u0005\t\u0000\u0000dg\u0003\u0002\u0001\u0000"+
		"eg\u0003\u0012\t\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000"+
		"gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000ik\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005\n\u0000"+
		"\u0000l\u0011\u0001\u0000\u0000\u0000mu\u0003\u0014\n\u0000nu\u0003\u0010"+
		"\b\u0000ou\u0003$\u0012\u0000pu\u0003&\u0013\u0000qu\u0003(\u0014\u0000"+
		"ru\u0003,\u0016\u0000su\u0003*\u0015\u0000tm\u0001\u0000\u0000\u0000t"+
		"n\u0001\u0000\u0000\u0000to\u0001\u0000\u0000\u0000tp\u0001\u0000\u0000"+
		"\u0000tq\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000ts\u0001\u0000"+
		"\u0000\u0000u\u0013\u0001\u0000\u0000\u0000vx\u0003\u0016\u000b\u0000"+
		"wy\u0005,\u0000\u0000xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y\u0015\u0001\u0000\u0000\u0000z{\u0006\u000b\uffff\uffff\u0000{\u0089"+
		"\u0005%\u0000\u0000|}\u0005\u000e\u0000\u0000}\u0089\u0003\u0016\u000b"+
		"\t~\u0089\u0005#\u0000\u0000\u007f\u0089\u0005 \u0000\u0000\u0080\u0089"+
		"\u0005!\u0000\u0000\u0081\u0089\u0005\"\u0000\u0000\u0082\u0089\u0005"+
		"\u001f\u0000\u0000\u0083\u0084\u0005\u001f\u0000\u0000\u0084\u0089\u0005"+
		"\u000f\u0000\u0000\u0085\u0086\u0005\u001f\u0000\u0000\u0086\u0089\u0005"+
		"\u0010\u0000\u0000\u0087\u0089\u0003\u0018\f\u0000\u0088z\u0001\u0000"+
		"\u0000\u0000\u0088|\u0001\u0000\u0000\u0000\u0088~\u0001\u0000\u0000\u0000"+
		"\u0088\u007f\u0001\u0000\u0000\u0000\u0088\u0080\u0001\u0000\u0000\u0000"+
		"\u0088\u0081\u0001\u0000\u0000\u0000\u0088\u0082\u0001\u0000\u0000\u0000"+
		"\u0088\u0083\u0001\u0000\u0000\u0000\u0088\u0085\u0001\u0000\u0000\u0000"+
		"\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u0095\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\n\f\u0000\u0000\u008b\u008c\u0005\u000b\u0000\u0000\u008c"+
		"\u0094\u0003\u0016\u000b\r\u008d\u008e\n\u000b\u0000\u0000\u008e\u008f"+
		"\u0005\f\u0000\u0000\u008f\u0094\u0003\u0016\u000b\f\u0090\u0091\n\n\u0000"+
		"\u0000\u0091\u0092\u0005\r\u0000\u0000\u0092\u0094\u0003\u0016\u000b\u000b"+
		"\u0093\u008a\u0001\u0000\u0000\u0000\u0093\u008d\u0001\u0000\u0000\u0000"+
		"\u0093\u0090\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000"+
		"\u0095\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0017\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0005\u001f\u0000\u0000\u0099\u009a\u0005&\u0000\u0000\u009a"+
		"\u009d\u0003\u0016\u000b\u0000\u009b\u009d\u0003\u001a\r\u0000\u009c\u0098"+
		"\u0001\u0000\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u0019"+
		"\u0001\u0000\u0000\u0000\u009e\u00a3\u0003\u001c\u000e\u0000\u009f\u00a0"+
		"\u0007\u0001\u0000\u0000\u00a0\u00a2\u0003\u001c\u000e\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u001b"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00ab"+
		"\u0003\u001e\u000f\u0000\u00a7\u00a8\u0007\u0002\u0000\u0000\u00a8\u00aa"+
		"\u0003\u001e\u000f\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u00ad"+
		"\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac\u001d\u0001\u0000\u0000\u0000\u00ad\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b3\u0003 \u0010\u0000\u00af\u00b0\u0007"+
		"\u0003\u0000\u0000\u00b0\u00b2\u0003 \u0010\u0000\u00b1\u00af\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u001f\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00bb\u0003\"\u0011"+
		"\u0000\u00b7\u00b8\u0007\u0004\u0000\u0000\u00b8\u00ba\u0003\"\u0011\u0000"+
		"\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bc!\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000\u00be"+
		"\u00c5\u0005\u001f\u0000\u0000\u00bf\u00c5\u0005 \u0000\u0000\u00c0\u00c1"+
		"\u0005\u0003\u0000\u0000\u00c1\u00c2\u0003\u0016\u000b\u0000\u00c2\u00c3"+
		"\u0005\u0004\u0000\u0000\u00c3\u00c5\u0001\u0000\u0000\u0000\u00c4\u00be"+
		"\u0001\u0000\u0000\u0000\u00c4\u00bf\u0001\u0000\u0000\u0000\u00c4\u00c0"+
		"\u0001\u0000\u0000\u0000\u00c5#\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005"+
		"\'\u0000\u0000\u00c7\u00c8\u0005\u0003\u0000\u0000\u00c8\u00c9\u0003\u0016"+
		"\u000b\u0000\u00c9\u00ca\u0005\u0004\u0000\u0000\u00ca\u00cd\u0003\u0012"+
		"\t\u0000\u00cb\u00cc\u0005(\u0000\u0000\u00cc\u00ce\u0003\u0012\t\u0000"+
		"\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000"+
		"\u00ce%\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005*\u0000\u0000\u00d0\u00d1"+
		"\u0005\u0003\u0000\u0000\u00d1\u00d2\u0003\u0016\u000b\u0000\u00d2\u00d3"+
		"\u0005\u0004\u0000\u0000\u00d3\u00d4\u0003\u0012\t\u0000\u00d4\'\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0005)\u0000\u0000\u00d6\u00d8\u0005\u0003"+
		"\u0000\u0000\u00d7\u00d9\u0003\u0002\u0001\u0000\u00d8\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u00db\u0005\u001c\u0000\u0000\u00db\u00dc\u0003\u0018"+
		"\f\u0000\u00dc\u00dd\u0005\u001c\u0000\u0000\u00dd\u00de\u0003\u0016\u000b"+
		"\u0000\u00de\u00df\u0005\u0004\u0000\u0000\u00df\u00e0\u0003\u0012\t\u0000"+
		"\u00e0)\u0001\u0000\u0000\u0000\u00e1\u00e3\u0005+\u0000\u0000\u00e2\u00e4"+
		"\u0003\u0016\u000b\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5\u00e7"+
		"\u0005,\u0000\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001"+
		"\u0000\u0000\u0000\u00e7+\u0001\u0000\u0000\u0000\u00e8\u00e9\u0005\u001d"+
		"\u0000\u0000\u00e9\u00ea\u0005\u0003\u0000\u0000\u00ea\u00eb\u0003.\u0017"+
		"\u0000\u00eb\u00ed\u0005\u0004\u0000\u0000\u00ec\u00ee\u0005,\u0000\u0000"+
		"\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ee\u00f7\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005\u001e\u0000\u0000"+
		"\u00f0\u00f1\u0005\u0003\u0000\u0000\u00f1\u00f2\u0005\u001f\u0000\u0000"+
		"\u00f2\u00f4\u0005\u0004\u0000\u0000\u00f3\u00f5\u0005,\u0000\u0000\u00f4"+
		"\u00f3\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000\u0000\u0000\u00f5"+
		"\u00f7\u0001\u0000\u0000\u0000\u00f6\u00e8\u0001\u0000\u0000\u0000\u00f6"+
		"\u00ef\u0001\u0000\u0000\u0000\u00f7-\u0001\u0000\u0000\u0000\u00f8\u00fd"+
		"\u0003\u0016\u000b\u0000\u00f9\u00fa\u0005\u0001\u0000\u0000\u00fa\u00fc"+
		"\u0003\u0016\u000b\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00ff"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fe"+
		"\u0001\u0000\u0000\u0000\u00fe\u0102\u0001\u0000\u0000\u0000\u00ff\u00fd"+
		"\u0001\u0000\u0000\u0000\u0100\u0102\u0005$\u0000\u0000\u0101\u00f8\u0001"+
		"\u0000\u0000\u0000\u0101\u0100\u0001\u0000\u0000\u0000\u0102/\u0001\u0000"+
		"\u0000\u0000\u001e24:>EKQ]fhtx\u0088\u0093\u0095\u009c\u00a3\u00ab\u00b3"+
		"\u00bb\u00c4\u00cd\u00d8\u00e3\u00e6\u00ed\u00f4\u00f6\u00fd\u0101";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}