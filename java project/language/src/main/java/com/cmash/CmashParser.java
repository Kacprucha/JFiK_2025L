package com.cmash;
// Generated from Cmash.g4 by ANTLR 4.13.2
import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class CmashParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, ID=48, INT=49, FLOAT=50, DOUBLE=51, CHAR_LITERAL=52, 
		PLAIN_TEXT=53, BOOL_LITERAL=54, ASSIGNMENT_OPERATOR=55, IF=56, ELSE=57, 
		FOR=58, WHILE=59, RETURN=60, END_OF_LINE=61, WS=62;
	public static final int
		RULE_program = 0, RULE_declaration = 1, RULE_values = 2, RULE_value = 3, 
		RULE_arraySize = 4, RULE_matrixSize = 5, RULE_matrixRow = 6, RULE_stringDeclaration = 7, 
		RULE_arrayDeclaration = 8, RULE_matrixDeclaration = 9, RULE_variableList = 10, 
		RULE_variable = 11, RULE_functionDefinition = 12, RULE_structDefinition = 13, 
		RULE_compoundStruct = 14, RULE_structMember = 15, RULE_type = 16, RULE_numericalType = 17, 
		RULE_parameters = 18, RULE_parameter = 19, RULE_compoundStatement = 20, 
		RULE_statement = 21, RULE_expressionStatement = 22, RULE_expression = 23, 
		RULE_assignment = 24, RULE_equality = 25, RULE_relational = 26, RULE_additive = 27, 
		RULE_multiplicative = 28, RULE_fieldAccess = 29, RULE_functionCall = 30, 
		RULE_primary = 31, RULE_numbers = 32, RULE_arrayAccess = 33, RULE_matrixAccess = 34, 
		RULE_selectionStatement = 35, RULE_iterationStatement = 36, RULE_loopStatement = 37, 
		RULE_ioStatement = 38, RULE_jumpStatement = 39, RULE_printArgs = 40, RULE_printArg = 41;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "declaration", "values", "value", "arraySize", "matrixSize", 
			"matrixRow", "stringDeclaration", "arrayDeclaration", "matrixDeclaration", 
			"variableList", "variable", "functionDefinition", "structDefinition", 
			"compoundStruct", "structMember", "type", "numericalType", "parameters", 
			"parameter", "compoundStatement", "statement", "expressionStatement", 
			"expression", "assignment", "equality", "relational", "additive", "multiplicative", 
			"fieldAccess", "functionCall", "primary", "numbers", "arrayAccess", "matrixAccess", 
			"selectionStatement", "iterationStatement", "loopStatement", "ioStatement", 
			"jumpStatement", "printArgs", "printArg"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "','", "']'", "'<'", "'>'", "'string'", "'='", "';'", "'void'", 
			"'('", "')'", "'struct'", "'{'", "'}'", "'int'", "'float'", "'char'", 
			"'double'", "'bool'", "'&&'", "'||'", "'^'", "'!'", "'++'", "'--'", "'*='", 
			"'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", 
			"'=='", "'!='", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'.'", 
			"'print'", "'read'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"ID", "INT", "FLOAT", "DOUBLE", "CHAR_LITERAL", "PLAIN_TEXT", "BOOL_LITERAL", 
			"ASSIGNMENT_OPERATOR", "IF", "ELSE", "FOR", "WHILE", "RETURN", "END_OF_LINE", 
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
		public List<StructDefinitionContext> structDefinition() {
			return getRuleContexts(StructDefinitionContext.class);
		}
		public StructDefinitionContext structDefinition(int i) {
			return getRuleContext(StructDefinitionContext.class,i);
		}
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977731136L) != 0)) {
				{
				setState(87);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(84);
					structDefinition();
					}
					break;
				case 2:
					{
					setState(85);
					declaration();
					}
					break;
				case 3:
					{
					setState(86);
					functionDefinition();
					}
					break;
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableListContext variableList() {
			return getRuleContext(VariableListContext.class,0);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public StringDeclarationContext stringDeclaration() {
			return getRuleContext(StringDeclarationContext.class,0);
		}
		public MatrixDeclarationContext matrixDeclaration() {
			return getRuleContext(MatrixDeclarationContext.class,0);
		}
		public ArrayDeclarationContext arrayDeclaration() {
			return getRuleContext(ArrayDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				type();
				setState(95);
				variableList();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END_OF_LINE) {
					{
					setState(96);
					match(END_OF_LINE);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				stringDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				matrixDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				arrayDeclaration();
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
	public static class ValuesContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ValuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterValues(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitValues(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitValues(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__0);
			setState(105);
			value();
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(106);
				match(T__1);
				setState(107);
				value();
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(113);
			match(T__2);
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public TerminalNode CHAR_LITERAL() { return getToken(CmashParser.CHAR_LITERAL, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(ID);
				}
				break;
			case INT:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				numbers();
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(CHAR_LITERAL);
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
	public static class ArraySizeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
		public ArraySizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraySize; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterArraySize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitArraySize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitArraySize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArraySizeContext arraySize() throws RecognitionException {
		ArraySizeContext _localctx = new ArraySizeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arraySize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__0);
			setState(121);
			match(INT);
			setState(122);
			match(T__2);
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
	public static class MatrixSizeContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(CmashParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmashParser.INT, i);
		}
		public MatrixSizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixSize; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterMatrixSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitMatrixSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitMatrixSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixSizeContext matrixSize() throws RecognitionException {
		MatrixSizeContext _localctx = new MatrixSizeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_matrixSize);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__3);
			setState(125);
			match(INT);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(126);
				match(T__1);
				setState(127);
				match(INT);
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__4);
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
	public static class MatrixRowContext extends ParserRuleContext {
		public List<NumbersContext> numbers() {
			return getRuleContexts(NumbersContext.class);
		}
		public NumbersContext numbers(int i) {
			return getRuleContext(NumbersContext.class,i);
		}
		public MatrixRowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixRow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterMatrixRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitMatrixRow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitMatrixRow(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixRowContext matrixRow() throws RecognitionException {
		MatrixRowContext _localctx = new MatrixRowContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_matrixRow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			numbers();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(136);
				match(T__1);
				setState(137);
				numbers();
				}
				}
				setState(142);
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
	public static class StringDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public TerminalNode PLAIN_TEXT() { return getToken(CmashParser.PLAIN_TEXT, 0); }
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public StringDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterStringDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitStringDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitStringDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringDeclarationContext stringDeclaration() throws RecognitionException {
		StringDeclarationContext _localctx = new StringDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stringDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__5);
			setState(144);
			match(ID);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(145);
				match(T__6);
				setState(146);
				match(PLAIN_TEXT);
				}
			}

			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(149);
				match(END_OF_LINE);
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
	public static class ArrayDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public List<ArraySizeContext> arraySize() {
			return getRuleContexts(ArraySizeContext.class);
		}
		public ArraySizeContext arraySize(int i) {
			return getRuleContext(ArraySizeContext.class,i);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public List<ValuesContext> values() {
			return getRuleContexts(ValuesContext.class);
		}
		public ValuesContext values(int i) {
			return getRuleContext(ValuesContext.class,i);
		}
		public ArrayDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterArrayDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitArrayDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitArrayDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			type();
			setState(153);
			match(ID);
			setState(154);
			arraySize();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(155);
				arraySize();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(161);
				match(T__6);
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(162);
					values();
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(171);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(170);
				match(END_OF_LINE);
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
	public static class MatrixDeclarationContext extends ParserRuleContext {
		public NumericalTypeContext numericalType() {
			return getRuleContext(NumericalTypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public MatrixSizeContext matrixSize() {
			return getRuleContext(MatrixSizeContext.class,0);
		}
		public List<MatrixRowContext> matrixRow() {
			return getRuleContexts(MatrixRowContext.class);
		}
		public MatrixRowContext matrixRow(int i) {
			return getRuleContext(MatrixRowContext.class,i);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public MatrixDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterMatrixDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitMatrixDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitMatrixDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixDeclarationContext matrixDeclaration() throws RecognitionException {
		MatrixDeclarationContext _localctx = new MatrixDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_matrixDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			numericalType();
			setState(174);
			match(ID);
			setState(175);
			matrixSize();
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(176);
				match(T__6);
				setState(177);
				match(T__3);
				setState(178);
				matrixRow();
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(179);
					match(T__7);
					setState(180);
					matrixRow();
					}
					}
					setState(185);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(186);
				match(T__4);
				}
			}

			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(190);
				match(END_OF_LINE);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitVariableList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitVariableList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableListContext variableList() throws RecognitionException {
		VariableListContext _localctx = new VariableListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			variable();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(194);
				match(T__1);
				setState(195);
				variable();
				}
				}
				setState(200);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(ID);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(202);
				match(T__6);
				setState(203);
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
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public CompoundStatementContext compoundStatement() {
			return getRuleContext(CompoundStatementContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__11:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
				{
				setState(206);
				type();
				}
				break;
			case ID:
				{
				}
				break;
			case T__8:
				{
				setState(208);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(211);
			match(ID);
			setState(212);
			match(T__9);
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977730624L) != 0)) {
				{
				setState(213);
				parameters();
				}
			}

			setState(216);
			match(T__10);
			setState(217);
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
	public static class StructDefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public CompoundStructContext compoundStruct() {
			return getRuleContext(CompoundStructContext.class,0);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public StructDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterStructDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitStructDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitStructDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__11);
			setState(220);
			match(ID);
			setState(221);
			compoundStruct();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(222);
				match(END_OF_LINE);
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
	public static class CompoundStructContext extends ParserRuleContext {
		public List<StructMemberContext> structMember() {
			return getRuleContexts(StructMemberContext.class);
		}
		public StructMemberContext structMember(int i) {
			return getRuleContext(StructMemberContext.class,i);
		}
		public List<FunctionDefinitionContext> functionDefinition() {
			return getRuleContexts(FunctionDefinitionContext.class);
		}
		public FunctionDefinitionContext functionDefinition(int i) {
			return getRuleContext(FunctionDefinitionContext.class,i);
		}
		public CompoundStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compoundStruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterCompoundStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitCompoundStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitCompoundStruct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStructContext compoundStruct() throws RecognitionException {
		CompoundStructContext _localctx = new CompoundStructContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_compoundStruct);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(T__12);
			setState(229);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(226);
					structMember();
					}
					} 
				}
				setState(231);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977731136L) != 0)) {
				{
				{
				setState(232);
				functionDefinition();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
			match(T__13);
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
	public static class StructMemberContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public StructMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterStructMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitStructMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitStructMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			type();
			setState(241);
			match(ID);
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(242);
				match(END_OF_LINE);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(249);
				match(T__18);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(250);
				match(T__11);
				setState(251);
				match(ID);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 7);
				{
				setState(252);
				match(T__5);
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
	public static class NumericalTypeContext extends ParserRuleContext {
		public NumericalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericalType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterNumericalType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitNumericalType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitNumericalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumericalTypeContext numericalType() throws RecognitionException {
		NumericalTypeContext _localctx = new NumericalTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_numericalType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 360448L) != 0)) ) {
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
		public List<TerminalNode> ID() { return getTokens(CmashParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmashParser.ID, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_parameters);
		int _la;
		try {
			setState(273);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__11:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
				enterOuterAlt(_localctx, 1);
				{
				setState(257);
				parameter();
				setState(262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(258);
					match(T__1);
					setState(259);
					parameter();
					}
					}
					setState(264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				match(ID);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(266);
					match(T__1);
					setState(267);
					match(ID);
					}
					}
					setState(272);
					_errHandler.sync(this);
					_la = _input.LA(1);
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
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			type();
			setState(276);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterCompoundStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitCompoundStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitCompoundStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(T__12);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2116621456129373248L) != 0)) {
				{
				setState(281);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
				case T__11:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
					{
					setState(279);
					declaration();
					}
					break;
				case T__9:
				case T__12:
				case T__22:
				case T__45:
				case T__46:
				case ID:
				case INT:
				case FLOAT:
				case DOUBLE:
				case CHAR_LITERAL:
				case BOOL_LITERAL:
				case IF:
				case FOR:
				case WHILE:
				case RETURN:
					{
					setState(280);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(286);
			match(T__13);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statement);
		try {
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__22:
			case ID:
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR_LITERAL:
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(288);
				expressionStatement();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				compoundStatement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(290);
				selectionStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(291);
				iterationStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(292);
				loopStatement();
				}
				break;
			case T__45:
			case T__46:
				enterOuterAlt(_localctx, 6);
				{
				setState(293);
				ioStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 7);
				{
				setState(294);
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
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitExpressionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitExpressionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			expression(0);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(298);
				match(END_OF_LINE);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public MatrixAccessContext matrixAccess() {
			return getRuleContext(MatrixAccessContext.class,0);
		}
		public TerminalNode CHAR_LITERAL() { return getToken(CmashParser.CHAR_LITERAL, 0); }
		public TerminalNode FLOAT() { return getToken(CmashParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(CmashParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(CmashParser.BOOL_LITERAL, 0); }
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(302);
				match(T__22);
				setState(303);
				expression(14);
				}
				break;
			case 2:
				{
				setState(304);
				functionCall();
				}
				break;
			case 3:
				{
				setState(305);
				fieldAccess();
				}
				break;
			case 4:
				{
				setState(306);
				arrayAccess();
				}
				break;
			case 5:
				{
				setState(307);
				matrixAccess();
				}
				break;
			case 6:
				{
				setState(308);
				match(CHAR_LITERAL);
				}
				break;
			case 7:
				{
				setState(309);
				match(FLOAT);
				}
				break;
			case 8:
				{
				setState(310);
				match(DOUBLE);
				}
				break;
			case 9:
				{
				setState(311);
				match(INT);
				}
				break;
			case 10:
				{
				setState(312);
				match(BOOL_LITERAL);
				}
				break;
			case 11:
				{
				setState(313);
				numbers();
				setState(314);
				match(T__23);
				}
				break;
			case 12:
				{
				setState(316);
				numbers();
				setState(317);
				match(T__24);
				}
				break;
			case 13:
				{
				setState(319);
				assignment();
				}
				break;
			case 14:
				{
				setState(320);
				match(ID);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(332);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(323);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(324);
						match(T__19);
						setState(325);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(326);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(327);
						match(T__20);
						setState(328);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(330);
						match(T__21);
						setState(331);
						expression(16);
						}
						break;
					}
					} 
				}
				setState(336);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignment);
		int _la;
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(337);
				match(ID);
				setState(338);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68652368000L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(339);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				fieldAccess();
				setState(341);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68652368000L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(342);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				equality();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(345);
				arrayAccess();
				setState(346);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68652368000L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(347);
				expression(0);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitEquality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_equality);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			relational();
			setState(356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(352);
					_la = _input.LA(1);
					if ( !(_la==T__35 || _la==T__36) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(353);
					relational();
					}
					} 
				}
				setState(358);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_relational);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			additive();
			setState(364);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(360);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 824633720880L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(361);
					additive();
					}
					} 
				}
				setState(366);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterAdditive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitAdditive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitAdditive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_additive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			multiplicative();
			setState(372);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(368);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(369);
					multiplicative();
					}
					} 
				}
				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterMultiplicative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitMultiplicative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitMultiplicative(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_multiplicative);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			primary();
			setState(380);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(376);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30786325577728L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(377);
					primary();
					}
					} 
				}
				setState(382);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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
	public static class FieldAccessContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(CmashParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmashParser.ID, i);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public FieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitFieldAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitFieldAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_fieldAccess);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			match(ID);
			setState(384);
			match(T__44);
			setState(385);
			match(ID);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(386);
					match(T__44);
					setState(387);
					match(ID);
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			}
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				{
				setState(393);
				match(END_OF_LINE);
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
	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functionCall);
		int _la;
		try {
			setState(409);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				match(ID);
				setState(397);
				match(T__9);
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977730624L) != 0)) {
					{
					setState(398);
					parameters();
					}
				}

				setState(401);
				match(T__10);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(402);
				fieldAccess();
				setState(403);
				match(T__9);
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977730624L) != 0)) {
					{
					setState(404);
					parameters();
					}
				}

				setState(407);
				match(T__10);
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
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(CmashParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(CmashParser.DOUBLE, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(CmashParser.CHAR_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(CmashParser.BOOL_LITERAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_primary);
		try {
			setState(422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(INT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				match(FLOAT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(414);
				match(DOUBLE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(415);
				match(CHAR_LITERAL);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(416);
				match(BOOL_LITERAL);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(417);
				match(T__9);
				setState(418);
				expression(0);
				setState(419);
				match(T__10);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(421);
				functionCall();
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
	public static class NumbersContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(CmashParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(CmashParser.DOUBLE, 0); }
		public NumbersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numbers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterNumbers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitNumbers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitNumbers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumbersContext numbers() throws RecognitionException {
		NumbersContext _localctx = new NumbersContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_numbers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3940649673949184L) != 0)) ) {
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
	public static class ArrayAccessContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public List<TerminalNode> INT() { return getTokens(CmashParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmashParser.INT, i);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arrayAccess);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(ID);
			setState(430); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(427);
					match(T__0);
					setState(428);
					match(INT);
					setState(429);
					match(T__2);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(432); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(434);
				match(END_OF_LINE);
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
	public static class MatrixAccessContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public List<TerminalNode> INT() { return getTokens(CmashParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CmashParser.INT, i);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public MatrixAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterMatrixAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitMatrixAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitMatrixAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixAccessContext matrixAccess() throws RecognitionException {
		MatrixAccessContext _localctx = new MatrixAccessContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_matrixAccess);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(ID);
			setState(441); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(438);
					match(T__3);
					setState(439);
					match(INT);
					setState(440);
					match(T__4);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(443); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(446);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				{
				setState(445);
				match(END_OF_LINE);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterSelectionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitSelectionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitSelectionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(IF);
			setState(449);
			match(T__9);
			setState(450);
			expression(0);
			setState(451);
			match(T__10);
			setState(452);
			statement();
			setState(455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(453);
				match(ELSE);
				setState(454);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterIterationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitIterationStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitIterationStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_iterationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			match(WHILE);
			setState(458);
			match(T__9);
			setState(459);
			expression(0);
			setState(460);
			match(T__10);
			setState(461);
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
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitLoopStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_loopStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(FOR);
			setState(464);
			match(T__9);
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1019968L) != 0)) {
				{
				setState(465);
				declaration();
				}
			}

			setState(468);
			match(T__7);
			setState(469);
			equality();
			setState(470);
			match(T__7);
			setState(471);
			expression(0);
			setState(472);
			match(T__10);
			setState(473);
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
	public static class IoStatementContext extends ParserRuleContext {
		public PrintArgsContext printArgs() {
			return getRuleContext(PrintArgsContext.class,0);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public IoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ioStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterIoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitIoStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitIoStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IoStatementContext ioStatement() throws RecognitionException {
		IoStatementContext _localctx = new IoStatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_ioStatement);
		int _la;
		try {
			setState(489);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				match(T__45);
				setState(476);
				match(T__9);
				setState(477);
				printArgs();
				setState(478);
				match(T__10);
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END_OF_LINE) {
					{
					setState(479);
					match(END_OF_LINE);
					}
				}

				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(482);
				match(T__46);
				setState(483);
				match(T__9);
				setState(484);
				match(ID);
				setState(485);
				match(T__10);
				setState(487);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END_OF_LINE) {
					{
					setState(486);
					match(END_OF_LINE);
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
	public static class JumpStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CmashParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterJumpStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitJumpStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitJumpStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			match(RETURN);
			setState(493);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				setState(492);
				expression(0);
				}
				break;
			}
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(495);
				match(END_OF_LINE);
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
	public static class PrintArgsContext extends ParserRuleContext {
		public List<PrintArgContext> printArg() {
			return getRuleContexts(PrintArgContext.class);
		}
		public PrintArgContext printArg(int i) {
			return getRuleContext(PrintArgContext.class,i);
		}
		public PrintArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterPrintArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitPrintArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitPrintArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintArgsContext printArgs() throws RecognitionException {
		PrintArgsContext _localctx = new PrintArgsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_printArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			printArg();
			setState(503);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(499);
				match(T__1);
				setState(500);
				printArg();
				}
				}
				setState(505);
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
	public static class PrintArgContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PLAIN_TEXT() { return getToken(CmashParser.PLAIN_TEXT, 0); }
		public PrintArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterPrintArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitPrintArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmashVisitor ) return ((CmashVisitor<? extends T>)visitor).visitPrintArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintArgContext printArg() throws RecognitionException {
		PrintArgContext _localctx = new PrintArgContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_printArg);
		try {
			setState(508);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__22:
			case ID:
			case INT:
			case FLOAT:
			case DOUBLE:
			case CHAR_LITERAL:
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(506);
				expression(0);
				}
				break;
			case PLAIN_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(507);
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
		case 23:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001>\u01ff\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"(\u0007(\u0002)\u0007)\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000"+
		"X\b\u0000\n\u0000\f\u0000[\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001b\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001g\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002m\b\u0002\n\u0002\f\u0002p\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003w\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005\u0081\b\u0005\n\u0005\f\u0005\u0084"+
		"\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u008b\b\u0006\n\u0006\f\u0006\u008e\t\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u0094\b\u0007\u0001\u0007\u0003\u0007"+
		"\u0097\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u009d\b\b\n\b\f"+
		"\b\u00a0\t\b\u0001\b\u0001\b\u0005\b\u00a4\b\b\n\b\f\b\u00a7\t\b\u0003"+
		"\b\u00a9\b\b\u0001\b\u0003\b\u00ac\b\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00b6\b\t\n\t\f\t\u00b9\t\t\u0001"+
		"\t\u0001\t\u0003\t\u00bd\b\t\u0001\t\u0003\t\u00c0\b\t\u0001\n\u0001\n"+
		"\u0001\n\u0005\n\u00c5\b\n\n\n\f\n\u00c8\t\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00cd\b\u000b\u0001\f\u0001\f\u0001\f\u0003\f\u00d2"+
		"\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u00d7\b\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00e0\b\r\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00e4\b\u000e\n\u000e\f\u000e\u00e7\t\u000e\u0001\u000e\u0005"+
		"\u000e\u00ea\b\u000e\n\u000e\f\u000e\u00ed\t\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00f4\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00fe\b\u0010\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0005\u0012\u0105\b\u0012\n\u0012\f\u0012\u0108"+
		"\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u010d\b\u0012"+
		"\n\u0012\f\u0012\u0110\t\u0012\u0003\u0012\u0112\b\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u011a"+
		"\b\u0014\n\u0014\f\u0014\u011d\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u0128\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u012c\b"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0142\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u014d\b\u0017\n\u0017\f\u0017\u0150\t\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u015e\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019"+
		"\u0163\b\u0019\n\u0019\f\u0019\u0166\t\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0005\u001a\u016b\b\u001a\n\u001a\f\u001a\u016e\t\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0005\u001b\u0173\b\u001b\n\u001b\f\u001b\u0176"+
		"\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u017b\b\u001c"+
		"\n\u001c\f\u001c\u017e\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0005\u001d\u0185\b\u001d\n\u001d\f\u001d\u0188\t\u001d"+
		"\u0001\u001d\u0003\u001d\u018b\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u0190\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0003\u001e\u0196\b\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u019a\b"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003"+
		"\u001f\u01a7\b\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0004!"+
		"\u01af\b!\u000b!\f!\u01b0\u0001!\u0003!\u01b4\b!\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0004\"\u01ba\b\"\u000b\"\f\"\u01bb\u0001\"\u0003\"\u01bf\b"+
		"\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u01c8\b#\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0003%\u01d3"+
		"\b%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0003&\u01e1\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003"+
		"&\u01e8\b&\u0003&\u01ea\b&\u0001\'\u0001\'\u0003\'\u01ee\b\'\u0001\'\u0003"+
		"\'\u01f1\b\'\u0001(\u0001(\u0001(\u0005(\u01f6\b(\n(\f(\u01f9\t(\u0001"+
		")\u0001)\u0003)\u01fd\b)\u0001)\u0000\u0001.*\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPR\u0000\u0007\u0002\u0000\u000f\u0010\u0012\u0012\u0002"+
		"\u0000\u0007\u0007\u001a#\u0001\u0000$%\u0002\u0000\u0004\u0005&\'\u0001"+
		"\u0000()\u0001\u0000*,\u0001\u000013\u0234\u0000Y\u0001\u0000\u0000\u0000"+
		"\u0002f\u0001\u0000\u0000\u0000\u0004h\u0001\u0000\u0000\u0000\u0006v"+
		"\u0001\u0000\u0000\u0000\bx\u0001\u0000\u0000\u0000\n|\u0001\u0000\u0000"+
		"\u0000\f\u0087\u0001\u0000\u0000\u0000\u000e\u008f\u0001\u0000\u0000\u0000"+
		"\u0010\u0098\u0001\u0000\u0000\u0000\u0012\u00ad\u0001\u0000\u0000\u0000"+
		"\u0014\u00c1\u0001\u0000\u0000\u0000\u0016\u00c9\u0001\u0000\u0000\u0000"+
		"\u0018\u00d1\u0001\u0000\u0000\u0000\u001a\u00db\u0001\u0000\u0000\u0000"+
		"\u001c\u00e1\u0001\u0000\u0000\u0000\u001e\u00f0\u0001\u0000\u0000\u0000"+
		" \u00fd\u0001\u0000\u0000\u0000\"\u00ff\u0001\u0000\u0000\u0000$\u0111"+
		"\u0001\u0000\u0000\u0000&\u0113\u0001\u0000\u0000\u0000(\u0116\u0001\u0000"+
		"\u0000\u0000*\u0127\u0001\u0000\u0000\u0000,\u0129\u0001\u0000\u0000\u0000"+
		".\u0141\u0001\u0000\u0000\u00000\u015d\u0001\u0000\u0000\u00002\u015f"+
		"\u0001\u0000\u0000\u00004\u0167\u0001\u0000\u0000\u00006\u016f\u0001\u0000"+
		"\u0000\u00008\u0177\u0001\u0000\u0000\u0000:\u017f\u0001\u0000\u0000\u0000"+
		"<\u0199\u0001\u0000\u0000\u0000>\u01a6\u0001\u0000\u0000\u0000@\u01a8"+
		"\u0001\u0000\u0000\u0000B\u01aa\u0001\u0000\u0000\u0000D\u01b5\u0001\u0000"+
		"\u0000\u0000F\u01c0\u0001\u0000\u0000\u0000H\u01c9\u0001\u0000\u0000\u0000"+
		"J\u01cf\u0001\u0000\u0000\u0000L\u01e9\u0001\u0000\u0000\u0000N\u01eb"+
		"\u0001\u0000\u0000\u0000P\u01f2\u0001\u0000\u0000\u0000R\u01fc\u0001\u0000"+
		"\u0000\u0000TX\u0003\u001a\r\u0000UX\u0003\u0002\u0001\u0000VX\u0003\u0018"+
		"\f\u0000WT\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000"+
		"\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\]\u0005\u0000\u0000\u0001]\u0001\u0001\u0000\u0000\u0000^_\u0003 \u0010"+
		"\u0000_a\u0003\u0014\n\u0000`b\u0005=\u0000\u0000a`\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000bg\u0001\u0000\u0000\u0000cg\u0003\u000e"+
		"\u0007\u0000dg\u0003\u0012\t\u0000eg\u0003\u0010\b\u0000f^\u0001\u0000"+
		"\u0000\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001"+
		"\u0000\u0000\u0000g\u0003\u0001\u0000\u0000\u0000hi\u0005\u0001\u0000"+
		"\u0000in\u0003\u0006\u0003\u0000jk\u0005\u0002\u0000\u0000km\u0003\u0006"+
		"\u0003\u0000lj\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000\u0000nl\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000oq\u0001\u0000\u0000\u0000"+
		"pn\u0001\u0000\u0000\u0000qr\u0005\u0003\u0000\u0000r\u0005\u0001\u0000"+
		"\u0000\u0000sw\u00050\u0000\u0000tw\u0003@ \u0000uw\u00054\u0000\u0000"+
		"vs\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vu\u0001\u0000\u0000"+
		"\u0000w\u0007\u0001\u0000\u0000\u0000xy\u0005\u0001\u0000\u0000yz\u0005"+
		"1\u0000\u0000z{\u0005\u0003\u0000\u0000{\t\u0001\u0000\u0000\u0000|}\u0005"+
		"\u0004\u0000\u0000}\u0082\u00051\u0000\u0000~\u007f\u0005\u0002\u0000"+
		"\u0000\u007f\u0081\u00051\u0000\u0000\u0080~\u0001\u0000\u0000\u0000\u0081"+
		"\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084"+
		"\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0005\u0000\u0000\u0086"+
		"\u000b\u0001\u0000\u0000\u0000\u0087\u008c\u0003@ \u0000\u0088\u0089\u0005"+
		"\u0002\u0000\u0000\u0089\u008b\u0003@ \u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\r\u0001\u0000\u0000\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0005\u0006\u0000\u0000"+
		"\u0090\u0093\u00050\u0000\u0000\u0091\u0092\u0005\u0007\u0000\u0000\u0092"+
		"\u0094\u00055\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094"+
		"\u0001\u0000\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0097"+
		"\u0005=\u0000\u0000\u0096\u0095\u0001\u0000\u0000\u0000\u0096\u0097\u0001"+
		"\u0000\u0000\u0000\u0097\u000f\u0001\u0000\u0000\u0000\u0098\u0099\u0003"+
		" \u0010\u0000\u0099\u009a\u00050\u0000\u0000\u009a\u009e\u0003\b\u0004"+
		"\u0000\u009b\u009d\u0003\b\u0004\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a5\u0005\u0007\u0000\u0000"+
		"\u00a2\u00a4\u0003\u0004\u0002\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a7\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a8\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ac\u0005=\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ac\u0011\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0003\"\u0011\u0000\u00ae\u00af\u00050\u0000\u0000\u00af\u00bc"+
		"\u0003\n\u0005\u0000\u00b0\u00b1\u0005\u0007\u0000\u0000\u00b1\u00b2\u0005"+
		"\u0004\u0000\u0000\u00b2\u00b7\u0003\f\u0006\u0000\u00b3\u00b4\u0005\b"+
		"\u0000\u0000\u00b4\u00b6\u0003\f\u0006\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0005\u0000"+
		"\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00b0\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000"+
		"\u0000\u00be\u00c0\u0005=\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u0013\u0001\u0000\u0000\u0000"+
		"\u00c1\u00c6\u0003\u0016\u000b\u0000\u00c2\u00c3\u0005\u0002\u0000\u0000"+
		"\u00c3\u00c5\u0003\u0016\u000b\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u0015\u0001\u0000\u0000\u0000"+
		"\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cc\u00050\u0000\u0000\u00ca"+
		"\u00cb\u0005\u0007\u0000\u0000\u00cb\u00cd\u0003.\u0017\u0000\u00cc\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u0017"+
		"\u0001\u0000\u0000\u0000\u00ce\u00d2\u0003 \u0010\u0000\u00cf\u00d2\u0001"+
		"\u0000\u0000\u0000\u00d0\u00d2\u0005\t\u0000\u0000\u00d1\u00ce\u0001\u0000"+
		"\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u00050\u0000"+
		"\u0000\u00d4\u00d6\u0005\n\u0000\u0000\u00d5\u00d7\u0003$\u0012\u0000"+
		"\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d7\u00d8\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u000b\u0000\u0000"+
		"\u00d9\u00da\u0003(\u0014\u0000\u00da\u0019\u0001\u0000\u0000\u0000\u00db"+
		"\u00dc\u0005\f\u0000\u0000\u00dc\u00dd\u00050\u0000\u0000\u00dd\u00df"+
		"\u0003\u001c\u000e\u0000\u00de\u00e0\u0005=\u0000\u0000\u00df\u00de\u0001"+
		"\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u001b\u0001"+
		"\u0000\u0000\u0000\u00e1\u00e5\u0005\r\u0000\u0000\u00e2\u00e4\u0003\u001e"+
		"\u000f\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e6\u00eb\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e8\u00ea\u0003\u0018\f\u0000\u00e9\u00e8\u0001\u0000\u0000"+
		"\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000"+
		"\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005\u000e\u0000"+
		"\u0000\u00ef\u001d\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003 \u0010\u0000"+
		"\u00f1\u00f3\u00050\u0000\u0000\u00f2\u00f4\u0005=\u0000\u0000\u00f3\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u001f"+
		"\u0001\u0000\u0000\u0000\u00f5\u00fe\u0005\u000f\u0000\u0000\u00f6\u00fe"+
		"\u0005\u0010\u0000\u0000\u00f7\u00fe\u0005\u0011\u0000\u0000\u00f8\u00fe"+
		"\u0005\u0012\u0000\u0000\u00f9\u00fe\u0005\u0013\u0000\u0000\u00fa\u00fb"+
		"\u0005\f\u0000\u0000\u00fb\u00fe\u00050\u0000\u0000\u00fc\u00fe\u0005"+
		"\u0006\u0000\u0000\u00fd\u00f5\u0001\u0000\u0000\u0000\u00fd\u00f6\u0001"+
		"\u0000\u0000\u0000\u00fd\u00f7\u0001\u0000\u0000\u0000\u00fd\u00f8\u0001"+
		"\u0000\u0000\u0000\u00fd\u00f9\u0001\u0000\u0000\u0000\u00fd\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fe!\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u0007\u0000\u0000\u0000\u0100#\u0001\u0000\u0000"+
		"\u0000\u0101\u0106\u0003&\u0013\u0000\u0102\u0103\u0005\u0002\u0000\u0000"+
		"\u0103\u0105\u0003&\u0013\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105"+
		"\u0108\u0001\u0000\u0000\u0000\u0106\u0104\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0001\u0000\u0000\u0000\u0107\u0112\u0001\u0000\u0000\u0000\u0108"+
		"\u0106\u0001\u0000\u0000\u0000\u0109\u010e\u00050\u0000\u0000\u010a\u010b"+
		"\u0005\u0002\u0000\u0000\u010b\u010d\u00050\u0000\u0000\u010c\u010a\u0001"+
		"\u0000\u0000\u0000\u010d\u0110\u0001\u0000\u0000\u0000\u010e\u010c\u0001"+
		"\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0112\u0001"+
		"\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0111\u0101\u0001"+
		"\u0000\u0000\u0000\u0111\u0109\u0001\u0000\u0000\u0000\u0112%\u0001\u0000"+
		"\u0000\u0000\u0113\u0114\u0003 \u0010\u0000\u0114\u0115\u00050\u0000\u0000"+
		"\u0115\'\u0001\u0000\u0000\u0000\u0116\u011b\u0005\r\u0000\u0000\u0117"+
		"\u011a\u0003\u0002\u0001\u0000\u0118\u011a\u0003*\u0015\u0000\u0119\u0117"+
		"\u0001\u0000\u0000\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011d"+
		"\u0001\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c"+
		"\u0001\u0000\u0000\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u011b"+
		"\u0001\u0000\u0000\u0000\u011e\u011f\u0005\u000e\u0000\u0000\u011f)\u0001"+
		"\u0000\u0000\u0000\u0120\u0128\u0003,\u0016\u0000\u0121\u0128\u0003(\u0014"+
		"\u0000\u0122\u0128\u0003F#\u0000\u0123\u0128\u0003H$\u0000\u0124\u0128"+
		"\u0003J%\u0000\u0125\u0128\u0003L&\u0000\u0126\u0128\u0003N\'\u0000\u0127"+
		"\u0120\u0001\u0000\u0000\u0000\u0127\u0121\u0001\u0000\u0000\u0000\u0127"+
		"\u0122\u0001\u0000\u0000\u0000\u0127\u0123\u0001\u0000\u0000\u0000\u0127"+
		"\u0124\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0127"+
		"\u0126\u0001\u0000\u0000\u0000\u0128+\u0001\u0000\u0000\u0000\u0129\u012b"+
		"\u0003.\u0017\u0000\u012a\u012c\u0005=\u0000\u0000\u012b\u012a\u0001\u0000"+
		"\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000\u012c-\u0001\u0000\u0000"+
		"\u0000\u012d\u012e\u0006\u0017\uffff\uffff\u0000\u012e\u012f\u0005\u0017"+
		"\u0000\u0000\u012f\u0142\u0003.\u0017\u000e\u0130\u0142\u0003<\u001e\u0000"+
		"\u0131\u0142\u0003:\u001d\u0000\u0132\u0142\u0003B!\u0000\u0133\u0142"+
		"\u0003D\"\u0000\u0134\u0142\u00054\u0000\u0000\u0135\u0142\u00052\u0000"+
		"\u0000\u0136\u0142\u00053\u0000\u0000\u0137\u0142\u00051\u0000\u0000\u0138"+
		"\u0142\u00056\u0000\u0000\u0139\u013a\u0003@ \u0000\u013a\u013b\u0005"+
		"\u0018\u0000\u0000\u013b\u0142\u0001\u0000\u0000\u0000\u013c\u013d\u0003"+
		"@ \u0000\u013d\u013e\u0005\u0019\u0000\u0000\u013e\u0142\u0001\u0000\u0000"+
		"\u0000\u013f\u0142\u00030\u0018\u0000\u0140\u0142\u00050\u0000\u0000\u0141"+
		"\u012d\u0001\u0000\u0000\u0000\u0141\u0130\u0001\u0000\u0000\u0000\u0141"+
		"\u0131\u0001\u0000\u0000\u0000\u0141\u0132\u0001\u0000\u0000\u0000\u0141"+
		"\u0133\u0001\u0000\u0000\u0000\u0141\u0134\u0001\u0000\u0000\u0000\u0141"+
		"\u0135\u0001\u0000\u0000\u0000\u0141\u0136\u0001\u0000\u0000\u0000\u0141"+
		"\u0137\u0001\u0000\u0000\u0000\u0141\u0138\u0001\u0000\u0000\u0000\u0141"+
		"\u0139\u0001\u0000\u0000\u0000\u0141\u013c\u0001\u0000\u0000\u0000\u0141"+
		"\u013f\u0001\u0000\u0000\u0000\u0141\u0140\u0001\u0000\u0000\u0000\u0142"+
		"\u014e\u0001\u0000\u0000\u0000\u0143\u0144\n\u0011\u0000\u0000\u0144\u0145"+
		"\u0005\u0014\u0000\u0000\u0145\u014d\u0003.\u0017\u0012\u0146\u0147\n"+
		"\u0010\u0000\u0000\u0147\u0148\u0005\u0015\u0000\u0000\u0148\u014d\u0003"+
		".\u0017\u0011\u0149\u014a\n\u000f\u0000\u0000\u014a\u014b\u0005\u0016"+
		"\u0000\u0000\u014b\u014d\u0003.\u0017\u0010\u014c\u0143\u0001\u0000\u0000"+
		"\u0000\u014c\u0146\u0001\u0000\u0000\u0000\u014c\u0149\u0001\u0000\u0000"+
		"\u0000\u014d\u0150\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000"+
		"\u0000\u014e\u014f\u0001\u0000\u0000\u0000\u014f/\u0001\u0000\u0000\u0000"+
		"\u0150\u014e\u0001\u0000\u0000\u0000\u0151\u0152\u00050\u0000\u0000\u0152"+
		"\u0153\u0007\u0001\u0000\u0000\u0153\u015e\u0003.\u0017\u0000\u0154\u0155"+
		"\u0003:\u001d\u0000\u0155\u0156\u0007\u0001\u0000\u0000\u0156\u0157\u0003"+
		".\u0017\u0000\u0157\u015e\u0001\u0000\u0000\u0000\u0158\u015e\u00032\u0019"+
		"\u0000\u0159\u015a\u0003B!\u0000\u015a\u015b\u0007\u0001\u0000\u0000\u015b"+
		"\u015c\u0003.\u0017\u0000\u015c\u015e\u0001\u0000\u0000\u0000\u015d\u0151"+
		"\u0001\u0000\u0000\u0000\u015d\u0154\u0001\u0000\u0000\u0000\u015d\u0158"+
		"\u0001\u0000\u0000\u0000\u015d\u0159\u0001\u0000\u0000\u0000\u015e1\u0001"+
		"\u0000\u0000\u0000\u015f\u0164\u00034\u001a\u0000\u0160\u0161\u0007\u0002"+
		"\u0000\u0000\u0161\u0163\u00034\u001a\u0000\u0162\u0160\u0001\u0000\u0000"+
		"\u0000\u0163\u0166\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u01653\u0001\u0000\u0000\u0000"+
		"\u0166\u0164\u0001\u0000\u0000\u0000\u0167\u016c\u00036\u001b\u0000\u0168"+
		"\u0169\u0007\u0003\u0000\u0000\u0169\u016b\u00036\u001b\u0000\u016a\u0168"+
		"\u0001\u0000\u0000\u0000\u016b\u016e\u0001\u0000\u0000\u0000\u016c\u016a"+
		"\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d5\u0001"+
		"\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016f\u0174\u0003"+
		"8\u001c\u0000\u0170\u0171\u0007\u0004\u0000\u0000\u0171\u0173\u00038\u001c"+
		"\u0000\u0172\u0170\u0001\u0000\u0000\u0000\u0173\u0176\u0001\u0000\u0000"+
		"\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000"+
		"\u0000\u01757\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000"+
		"\u0177\u017c\u0003>\u001f\u0000\u0178\u0179\u0007\u0005\u0000\u0000\u0179"+
		"\u017b\u0003>\u001f\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u017e"+
		"\u0001\u0000\u0000\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017c\u017d"+
		"\u0001\u0000\u0000\u0000\u017d9\u0001\u0000\u0000\u0000\u017e\u017c\u0001"+
		"\u0000\u0000\u0000\u017f\u0180\u00050\u0000\u0000\u0180\u0181\u0005-\u0000"+
		"\u0000\u0181\u0186\u00050\u0000\u0000\u0182\u0183\u0005-\u0000\u0000\u0183"+
		"\u0185\u00050\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0185\u0188"+
		"\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0186\u0187"+
		"\u0001\u0000\u0000\u0000\u0187\u018a\u0001\u0000\u0000\u0000\u0188\u0186"+
		"\u0001\u0000\u0000\u0000\u0189\u018b\u0005=\u0000\u0000\u018a\u0189\u0001"+
		"\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b;\u0001\u0000"+
		"\u0000\u0000\u018c\u018d\u00050\u0000\u0000\u018d\u018f\u0005\n\u0000"+
		"\u0000\u018e\u0190\u0003$\u0012\u0000\u018f\u018e\u0001\u0000\u0000\u0000"+
		"\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000"+
		"\u0191\u019a\u0005\u000b\u0000\u0000\u0192\u0193\u0003:\u001d\u0000\u0193"+
		"\u0195\u0005\n\u0000\u0000\u0194\u0196\u0003$\u0012\u0000\u0195\u0194"+
		"\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0197"+
		"\u0001\u0000\u0000\u0000\u0197\u0198\u0005\u000b\u0000\u0000\u0198\u019a"+
		"\u0001\u0000\u0000\u0000\u0199\u018c\u0001\u0000\u0000\u0000\u0199\u0192"+
		"\u0001\u0000\u0000\u0000\u019a=\u0001\u0000\u0000\u0000\u019b\u01a7\u0005"+
		"0\u0000\u0000\u019c\u01a7\u00051\u0000\u0000\u019d\u01a7\u00052\u0000"+
		"\u0000\u019e\u01a7\u00053\u0000\u0000\u019f\u01a7\u00054\u0000\u0000\u01a0"+
		"\u01a7\u00056\u0000\u0000\u01a1\u01a2\u0005\n\u0000\u0000\u01a2\u01a3"+
		"\u0003.\u0017\u0000\u01a3\u01a4\u0005\u000b\u0000\u0000\u01a4\u01a7\u0001"+
		"\u0000\u0000\u0000\u01a5\u01a7\u0003<\u001e\u0000\u01a6\u019b\u0001\u0000"+
		"\u0000\u0000\u01a6\u019c\u0001\u0000\u0000\u0000\u01a6\u019d\u0001\u0000"+
		"\u0000\u0000\u01a6\u019e\u0001\u0000\u0000\u0000\u01a6\u019f\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a0\u0001\u0000\u0000\u0000\u01a6\u01a1\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a5\u0001\u0000\u0000\u0000\u01a7?\u0001\u0000\u0000"+
		"\u0000\u01a8\u01a9\u0007\u0006\u0000\u0000\u01a9A\u0001\u0000\u0000\u0000"+
		"\u01aa\u01ae\u00050\u0000\u0000\u01ab\u01ac\u0005\u0001\u0000\u0000\u01ac"+
		"\u01ad\u00051\u0000\u0000\u01ad\u01af\u0005\u0003\u0000\u0000\u01ae\u01ab"+
		"\u0001\u0000\u0000\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01ae"+
		"\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000\u0000\u01b1\u01b3"+
		"\u0001\u0000\u0000\u0000\u01b2\u01b4\u0005=\u0000\u0000\u01b3\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4C\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b9\u00050\u0000\u0000\u01b6\u01b7\u0005\u0004\u0000"+
		"\u0000\u01b7\u01b8\u00051\u0000\u0000\u01b8\u01ba\u0005\u0005\u0000\u0000"+
		"\u01b9\u01b6\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000"+
		"\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000"+
		"\u01bc\u01be\u0001\u0000\u0000\u0000\u01bd\u01bf\u0005=\u0000\u0000\u01be"+
		"\u01bd\u0001\u0000\u0000\u0000\u01be\u01bf\u0001\u0000\u0000\u0000\u01bf"+
		"E\u0001\u0000\u0000\u0000\u01c0\u01c1\u00058\u0000\u0000\u01c1\u01c2\u0005"+
		"\n\u0000\u0000\u01c2\u01c3\u0003.\u0017\u0000\u01c3\u01c4\u0005\u000b"+
		"\u0000\u0000\u01c4\u01c7\u0003*\u0015\u0000\u01c5\u01c6\u00059\u0000\u0000"+
		"\u01c6\u01c8\u0003*\u0015\u0000\u01c7\u01c5\u0001\u0000\u0000\u0000\u01c7"+
		"\u01c8\u0001\u0000\u0000\u0000\u01c8G\u0001\u0000\u0000\u0000\u01c9\u01ca"+
		"\u0005;\u0000\u0000\u01ca\u01cb\u0005\n\u0000\u0000\u01cb\u01cc\u0003"+
		".\u0017\u0000\u01cc\u01cd\u0005\u000b\u0000\u0000\u01cd\u01ce\u0003*\u0015"+
		"\u0000\u01ceI\u0001\u0000\u0000\u0000\u01cf\u01d0\u0005:\u0000\u0000\u01d0"+
		"\u01d2\u0005\n\u0000\u0000\u01d1\u01d3\u0003\u0002\u0001\u0000\u01d2\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d4"+
		"\u0001\u0000\u0000\u0000\u01d4\u01d5\u0005\b\u0000\u0000\u01d5\u01d6\u0003"+
		"2\u0019\u0000\u01d6\u01d7\u0005\b\u0000\u0000\u01d7\u01d8\u0003.\u0017"+
		"\u0000\u01d8\u01d9\u0005\u000b\u0000\u0000\u01d9\u01da\u0003*\u0015\u0000"+
		"\u01daK\u0001\u0000\u0000\u0000\u01db\u01dc\u0005.\u0000\u0000\u01dc\u01dd"+
		"\u0005\n\u0000\u0000\u01dd\u01de\u0003P(\u0000\u01de\u01e0\u0005\u000b"+
		"\u0000\u0000\u01df\u01e1\u0005=\u0000\u0000\u01e0\u01df\u0001\u0000\u0000"+
		"\u0000\u01e0\u01e1\u0001\u0000\u0000\u0000\u01e1\u01ea\u0001\u0000\u0000"+
		"\u0000\u01e2\u01e3\u0005/\u0000\u0000\u01e3\u01e4\u0005\n\u0000\u0000"+
		"\u01e4\u01e5\u00050\u0000\u0000\u01e5\u01e7\u0005\u000b\u0000\u0000\u01e6"+
		"\u01e8\u0005=\u0000\u0000\u01e7\u01e6\u0001\u0000\u0000\u0000\u01e7\u01e8"+
		"\u0001\u0000\u0000\u0000\u01e8\u01ea\u0001\u0000\u0000\u0000\u01e9\u01db"+
		"\u0001\u0000\u0000\u0000\u01e9\u01e2\u0001\u0000\u0000\u0000\u01eaM\u0001"+
		"\u0000\u0000\u0000\u01eb\u01ed\u0005<\u0000\u0000\u01ec\u01ee\u0003.\u0017"+
		"\u0000\u01ed\u01ec\u0001\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000"+
		"\u0000\u01ee\u01f0\u0001\u0000\u0000\u0000\u01ef\u01f1\u0005=\u0000\u0000"+
		"\u01f0\u01ef\u0001\u0000\u0000\u0000\u01f0\u01f1\u0001\u0000\u0000\u0000"+
		"\u01f1O\u0001\u0000\u0000\u0000\u01f2\u01f7\u0003R)\u0000\u01f3\u01f4"+
		"\u0005\u0002\u0000\u0000\u01f4\u01f6\u0003R)\u0000\u01f5\u01f3\u0001\u0000"+
		"\u0000\u0000\u01f6\u01f9\u0001\u0000\u0000\u0000\u01f7\u01f5\u0001\u0000"+
		"\u0000\u0000\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8Q\u0001\u0000\u0000"+
		"\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01fa\u01fd\u0003.\u0017\u0000"+
		"\u01fb\u01fd\u00055\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fc"+
		"\u01fb\u0001\u0000\u0000\u0000\u01fdS\u0001\u0000\u0000\u0000<WYafnv\u0082"+
		"\u008c\u0093\u0096\u009e\u00a5\u00a8\u00ab\u00b7\u00bc\u00bf\u00c6\u00cc"+
		"\u00d1\u00d6\u00df\u00e5\u00eb\u00f3\u00fd\u0106\u010e\u0111\u0119\u011b"+
		"\u0127\u012b\u0141\u014c\u014e\u015d\u0164\u016c\u0174\u017c\u0186\u018a"+
		"\u018f\u0195\u0199\u01a6\u01b0\u01b3\u01bb\u01be\u01c7\u01d2\u01e0\u01e7"+
		"\u01e9\u01ed\u01f0\u01f7\u01fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}