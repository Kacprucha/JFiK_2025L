package com.cmash;
// Generated from Cmash.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

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
			null, "','", "'['", "']'", "'<'", "'>'", "'string'", "'='", "';'", "'void'", 
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
	}

	public final ValuesContext values() throws RecognitionException {
		ValuesContext _localctx = new ValuesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			value();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(105);
				match(T__0);
				setState(106);
				value();
				}
				}
				setState(111);
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
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(ID);
				}
				break;
			case INT:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				numbers();
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(114);
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
	}

	public final ArraySizeContext arraySize() throws RecognitionException {
		ArraySizeContext _localctx = new ArraySizeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_arraySize);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(T__1);
			setState(118);
			match(INT);
			setState(119);
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
	}

	public final MatrixSizeContext matrixSize() throws RecognitionException {
		MatrixSizeContext _localctx = new MatrixSizeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_matrixSize);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(T__3);
			setState(122);
			match(INT);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(123);
				match(T__0);
				setState(124);
				match(INT);
				}
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
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
	}

	public final MatrixRowContext matrixRow() throws RecognitionException {
		MatrixRowContext _localctx = new MatrixRowContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_matrixRow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			numbers();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(133);
				match(T__0);
				setState(134);
				numbers();
				}
				}
				setState(139);
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
		public ArraySizeContext arraySize() {
			return getRuleContext(ArraySizeContext.class,0);
		}
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
	}

	public final StringDeclarationContext stringDeclaration() throws RecognitionException {
		StringDeclarationContext _localctx = new StringDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stringDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__5);
			setState(141);
			arraySize();
			setState(142);
			match(ID);
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(143);
				match(T__6);
				setState(144);
				match(PLAIN_TEXT);
				}
			}

			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(147);
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
		public ValuesContext values() {
			return getRuleContext(ValuesContext.class,0);
		}
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
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
	}

	public final ArrayDeclarationContext arrayDeclaration() throws RecognitionException {
		ArrayDeclarationContext _localctx = new ArrayDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			type();
			setState(151);
			match(ID);
			setState(152);
			arraySize();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(153);
				arraySize();
				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(159);
				match(T__6);
				setState(160);
				match(T__1);
				setState(161);
				values();
				setState(162);
				match(T__2);
				}
			}

			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(166);
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
	}

	public final MatrixDeclarationContext matrixDeclaration() throws RecognitionException {
		MatrixDeclarationContext _localctx = new MatrixDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_matrixDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			numericalType();
			setState(170);
			match(ID);
			setState(171);
			matrixSize();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(172);
				match(T__6);
				setState(173);
				match(T__3);
				setState(174);
				matrixRow();
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(175);
					match(T__7);
					setState(176);
					matrixRow();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(182);
				match(T__4);
				}
			}

			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(186);
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
	}

	public final VariableListContext variableList() throws RecognitionException {
		VariableListContext _localctx = new VariableListContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			variable();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(190);
				match(T__0);
				setState(191);
				variable();
				}
				}
				setState(196);
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
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_variable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(ID);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(198);
				match(T__6);
				setState(199);
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
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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
				setState(202);
				type();
				}
				break;
			case ID:
				{
				}
				break;
			case T__8:
				{
				setState(204);
				match(T__8);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(207);
			match(ID);
			setState(208);
			match(T__9);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977730624L) != 0)) {
				{
				setState(209);
				parameters();
				}
			}

			setState(212);
			match(T__10);
			setState(213);
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
	}

	public final StructDefinitionContext structDefinition() throws RecognitionException {
		StructDefinitionContext _localctx = new StructDefinitionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_structDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__11);
			setState(216);
			match(ID);
			setState(217);
			compoundStruct();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(218);
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
	}

	public final CompoundStructContext compoundStruct() throws RecognitionException {
		CompoundStructContext _localctx = new CompoundStructContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_compoundStruct);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__12);
			setState(225);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(222);
					structMember();
					}
					} 
				}
				setState(227);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977731136L) != 0)) {
				{
				{
				setState(228);
				functionDefinition();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
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
	}

	public final StructMemberContext structMember() throws RecognitionException {
		StructMemberContext _localctx = new StructMemberContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_structMember);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			type();
			setState(237);
			match(ID);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(238);
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
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
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
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				match(T__15);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
				match(T__16);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(245);
				match(T__18);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 6);
				{
				setState(246);
				match(T__11);
				setState(247);
				match(ID);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 7);
				{
				setState(248);
				match(T__5);
				setState(249);
				match(T__1);
				setState(250);
				match(INT);
				setState(251);
				match(T__2);
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
	}

	public final NumericalTypeContext numericalType() throws RecognitionException {
		NumericalTypeContext _localctx = new NumericalTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_numericalType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
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
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_parameters);
		int _la;
		try {
			setState(272);
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
				setState(256);
				parameter();
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(257);
					match(T__0);
					setState(258);
					parameter();
					}
					}
					setState(263);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				match(ID);
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(265);
					match(T__0);
					setState(266);
					match(ID);
					}
					}
					setState(271);
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
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			type();
			setState(275);
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
	}

	public final CompoundStatementContext compoundStatement() throws RecognitionException {
		CompoundStatementContext _localctx = new CompoundStatementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_compoundStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(T__12);
			setState(282);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2116621456129373248L) != 0)) {
				{
				setState(280);
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
					setState(278);
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
					setState(279);
					statement();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(285);
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
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statement);
		try {
			setState(294);
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
				setState(287);
				expressionStatement();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(288);
				compoundStatement();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(289);
				selectionStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(290);
				iterationStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(291);
				loopStatement();
				}
				break;
			case T__45:
			case T__46:
				enterOuterAlt(_localctx, 6);
				{
				setState(292);
				ioStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 7);
				{
				setState(293);
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
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_expressionStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			expression(0);
			setState(298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(297);
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
		public TerminalNode CHAR_LITERAL() { return getToken(CmashParser.CHAR_LITERAL, 0); }
		public TerminalNode FLOAT() { return getToken(CmashParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(CmashParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(CmashParser.BOOL_LITERAL, 0); }
		public NumbersContext numbers() {
			return getRuleContext(NumbersContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
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
			setState(320);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(301);
				match(T__22);
				setState(302);
				expression(14);
				}
				break;
			case 2:
				{
				setState(303);
				match(CHAR_LITERAL);
				}
				break;
			case 3:
				{
				setState(304);
				match(FLOAT);
				}
				break;
			case 4:
				{
				setState(305);
				match(DOUBLE);
				}
				break;
			case 5:
				{
				setState(306);
				match(INT);
				}
				break;
			case 6:
				{
				setState(307);
				match(ID);
				}
				break;
			case 7:
				{
				setState(308);
				match(BOOL_LITERAL);
				}
				break;
			case 8:
				{
				setState(309);
				numbers();
				setState(310);
				match(T__23);
				}
				break;
			case 9:
				{
				setState(312);
				numbers();
				setState(313);
				match(T__24);
				}
				break;
			case 10:
				{
				setState(315);
				assignment();
				}
				break;
			case 11:
				{
				setState(316);
				functionCall();
				}
				break;
			case 12:
				{
				setState(317);
				fieldAccess();
				}
				break;
			case 13:
				{
				setState(318);
				arrayAccess();
				}
				break;
			case 14:
				{
				setState(319);
				matrixAccess();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(333);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(331);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(322);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(323);
						match(T__19);
						setState(324);
						expression(18);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(325);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(326);
						match(T__20);
						setState(327);
						expression(17);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(329);
						match(T__21);
						setState(330);
						expression(16);
						}
						break;
					}
					} 
				}
				setState(335);
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmashParser.ID, 0); }
		public TerminalNode ASSIGNMENT_OPERATOR() { return getToken(CmashParser.ASSIGNMENT_OPERATOR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
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
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_assignment);
		int _la;
		try {
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				match(ID);
				setState(337);
				match(ASSIGNMENT_OPERATOR);
				setState(338);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				fieldAccess();
				setState(340);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 68652368000L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(341);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(343);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitEquality(this);
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
			setState(346);
			relational();
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(347);
					_la = _input.LA(1);
					if ( !(_la==T__35 || _la==T__36) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(348);
					relational();
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_relational);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			additive();
			setState(359);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(355);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 824633720880L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(356);
					additive();
					}
					} 
				}
				setState(361);
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
	}

	public final AdditiveContext additive() throws RecognitionException {
		AdditiveContext _localctx = new AdditiveContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_additive);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			multiplicative();
			setState(367);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(363);
					_la = _input.LA(1);
					if ( !(_la==T__39 || _la==T__40) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(364);
					multiplicative();
					}
					} 
				}
				setState(369);
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
	}

	public final MultiplicativeContext multiplicative() throws RecognitionException {
		MultiplicativeContext _localctx = new MultiplicativeContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_multiplicative);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			primary();
			setState(375);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(371);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 30786325577728L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(372);
					primary();
					}
					} 
				}
				setState(377);
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
	public static class FieldAccessContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
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
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_fieldAccess);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			primary();
			setState(379);
			match(T__44);
			setState(380);
			match(ID);
			setState(385);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(381);
					match(T__44);
					setState(382);
					match(ID);
					}
					} 
				}
				setState(387);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(389);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(388);
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
		public TerminalNode END_OF_LINE() { return getToken(CmashParser.END_OF_LINE, 0); }
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
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_functionCall);
		int _la;
		try {
			setState(409);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(391);
				match(ID);
				setState(392);
				match(T__9);
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977730624L) != 0)) {
					{
					setState(393);
					parameters();
					}
				}

				setState(396);
				match(T__10);
				setState(398);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(397);
					match(END_OF_LINE);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				fieldAccess();
				setState(401);
				match(T__9);
				setState(403);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281474977730624L) != 0)) {
					{
					setState(402);
					parameters();
					}
				}

				setState(405);
				match(T__10);
				setState(407);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
				case 1:
					{
					setState(406);
					match(END_OF_LINE);
					}
					break;
				}
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
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_primary);
		try {
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(ID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				match(INT);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(413);
				match(FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 4);
				{
				setState(414);
				match(DOUBLE);
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(415);
				match(CHAR_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(416);
				match(BOOL_LITERAL);
				}
				break;
			case T__9:
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
	}

	public final NumbersContext numbers() throws RecognitionException {
		NumbersContext _localctx = new NumbersContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_numbers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
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
		public TerminalNode INT() { return getToken(CmashParser.INT, 0); }
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
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_arrayAccess);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			match(ID);
			setState(426);
			match(T__1);
			setState(427);
			match(INT);
			setState(431);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(428);
					match(T__2);
					}
					} 
				}
				setState(433);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(435);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
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
			setState(443);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
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
				}
				setState(445);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			}
			setState(447);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
			case 1:
				{
				setState(446);
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
	}

	public final SelectionStatementContext selectionStatement() throws RecognitionException {
		SelectionStatementContext _localctx = new SelectionStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_selectionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(IF);
			setState(450);
			match(T__9);
			setState(451);
			expression(0);
			setState(452);
			match(T__10);
			setState(453);
			statement();
			setState(456);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(454);
				match(ELSE);
				setState(455);
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
	}

	public final IterationStatementContext iterationStatement() throws RecognitionException {
		IterationStatementContext _localctx = new IterationStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_iterationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(WHILE);
			setState(459);
			match(T__9);
			setState(460);
			expression(0);
			setState(461);
			match(T__10);
			setState(462);
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).enterLoopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CmashListener ) ((CmashListener)listener).exitLoopStatement(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_loopStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
			match(FOR);
			setState(465);
			match(T__9);
			setState(467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1019968L) != 0)) {
				{
				setState(466);
				declaration();
				}
			}

			setState(469);
			match(T__7);
			setState(470);
			assignment();
			setState(471);
			match(T__7);
			setState(472);
			expression(0);
			setState(473);
			match(T__10);
			setState(474);
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
	}

	public final IoStatementContext ioStatement() throws RecognitionException {
		IoStatementContext _localctx = new IoStatementContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_ioStatement);
		int _la;
		try {
			setState(490);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__45:
				enterOuterAlt(_localctx, 1);
				{
				setState(476);
				match(T__45);
				setState(477);
				match(T__9);
				setState(478);
				printArgs();
				setState(479);
				match(T__10);
				setState(481);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END_OF_LINE) {
					{
					setState(480);
					match(END_OF_LINE);
					}
				}

				}
				break;
			case T__46:
				enterOuterAlt(_localctx, 2);
				{
				setState(483);
				match(T__46);
				setState(484);
				match(T__9);
				setState(485);
				match(ID);
				setState(486);
				match(T__10);
				setState(488);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==END_OF_LINE) {
					{
					setState(487);
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
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_jumpStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(492);
			match(RETURN);
			setState(494);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				{
				setState(493);
				expression(0);
				}
				break;
			}
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==END_OF_LINE) {
				{
				setState(496);
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
	}

	public final PrintArgsContext printArgs() throws RecognitionException {
		PrintArgsContext _localctx = new PrintArgsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_printArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			printArg();
			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(500);
				match(T__0);
				setState(501);
				printArg();
				}
				}
				setState(506);
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
	}

	public final PrintArgContext printArg() throws RecognitionException {
		PrintArgContext _localctx = new PrintArgContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_printArg);
		try {
			setState(509);
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
				setState(507);
				expression(0);
				}
				break;
			case PLAIN_TEXT:
				enterOuterAlt(_localctx, 2);
				{
				setState(508);
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
		"\u0004\u0001>\u0200\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0005\u0002l\b\u0002\n\u0002\f\u0002o\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003t\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"~\b\u0005\n\u0005\f\u0005\u0081\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0088\b\u0006\n\u0006\f\u0006"+
		"\u008b\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u0092\b\u0007\u0001\u0007\u0003\u0007\u0095\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b\u009b\b\b\n\b\f\b\u009e\t\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a5\b\b\u0001\b\u0003\b\u00a8"+
		"\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005"+
		"\t\u00b2\b\t\n\t\f\t\u00b5\t\t\u0001\t\u0001\t\u0003\t\u00b9\b\t\u0001"+
		"\t\u0003\t\u00bc\b\t\u0001\n\u0001\n\u0001\n\u0005\n\u00c1\b\n\n\n\f\n"+
		"\u00c4\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c9\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0003\f\u00ce\b\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u00d3\b\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00dc\b\r\u0001\u000e\u0001\u000e\u0005\u000e\u00e0\b\u000e\n\u000e"+
		"\f\u000e\u00e3\t\u000e\u0001\u000e\u0005\u000e\u00e6\b\u000e\n\u000e\f"+
		"\u000e\u00e9\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00f0\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00fd\b\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0104\b\u0012\n\u0012\f\u0012"+
		"\u0107\t\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u010c\b"+
		"\u0012\n\u0012\f\u0012\u010f\t\u0012\u0003\u0012\u0111\b\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014"+
		"\u0119\b\u0014\n\u0014\f\u0014\u011c\t\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u0127\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u012b"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0141\b\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u014c\b\u0017\n\u0017\f\u0017\u014f\t\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0003\u0018\u0159\b\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0005\u0019\u015e\b\u0019\n\u0019\f\u0019\u0161\t\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0166\b\u001a\n\u001a\f\u001a"+
		"\u0169\t\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u016e\b"+
		"\u001b\n\u001b\f\u001b\u0171\t\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0005\u001c\u0176\b\u001c\n\u001c\f\u001c\u0179\t\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0180\b\u001d\n"+
		"\u001d\f\u001d\u0183\t\u001d\u0001\u001d\u0003\u001d\u0186\b\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u018b\b\u001e\u0001\u001e\u0001"+
		"\u001e\u0003\u001e\u018f\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u0194\b\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0198\b\u001e"+
		"\u0003\u001e\u019a\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0003\u001f\u01a6\b\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0005"+
		"!\u01ae\b!\n!\f!\u01b1\t!\u0001!\u0003!\u01b4\b!\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0005\"\u01ba\b\"\n\"\f\"\u01bd\t\"\u0001\"\u0003\"\u01c0\b"+
		"\"\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u01c9\b#\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0003%\u01d4"+
		"\b%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001&\u0001&\u0001"+
		"&\u0001&\u0001&\u0003&\u01e2\b&\u0001&\u0001&\u0001&\u0001&\u0001&\u0003"+
		"&\u01e9\b&\u0003&\u01eb\b&\u0001\'\u0001\'\u0003\'\u01ef\b\'\u0001\'\u0003"+
		"\'\u01f2\b\'\u0001(\u0001(\u0001(\u0005(\u01f7\b(\n(\f(\u01fa\t(\u0001"+
		")\u0001)\u0003)\u01fe\b)\u0001)\u0000\u0001.*\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPR\u0000\u0007\u0002\u0000\u000f\u0010\u0012\u0012\u0002"+
		"\u0000\u0007\u0007\u001a#\u0001\u0000$%\u0002\u0000\u0004\u0005&\'\u0001"+
		"\u0000()\u0001\u0000*,\u0001\u000013\u0234\u0000Y\u0001\u0000\u0000\u0000"+
		"\u0002f\u0001\u0000\u0000\u0000\u0004h\u0001\u0000\u0000\u0000\u0006s"+
		"\u0001\u0000\u0000\u0000\bu\u0001\u0000\u0000\u0000\ny\u0001\u0000\u0000"+
		"\u0000\f\u0084\u0001\u0000\u0000\u0000\u000e\u008c\u0001\u0000\u0000\u0000"+
		"\u0010\u0096\u0001\u0000\u0000\u0000\u0012\u00a9\u0001\u0000\u0000\u0000"+
		"\u0014\u00bd\u0001\u0000\u0000\u0000\u0016\u00c5\u0001\u0000\u0000\u0000"+
		"\u0018\u00cd\u0001\u0000\u0000\u0000\u001a\u00d7\u0001\u0000\u0000\u0000"+
		"\u001c\u00dd\u0001\u0000\u0000\u0000\u001e\u00ec\u0001\u0000\u0000\u0000"+
		" \u00fc\u0001\u0000\u0000\u0000\"\u00fe\u0001\u0000\u0000\u0000$\u0110"+
		"\u0001\u0000\u0000\u0000&\u0112\u0001\u0000\u0000\u0000(\u0115\u0001\u0000"+
		"\u0000\u0000*\u0126\u0001\u0000\u0000\u0000,\u0128\u0001\u0000\u0000\u0000"+
		".\u0140\u0001\u0000\u0000\u00000\u0158\u0001\u0000\u0000\u00002\u015a"+
		"\u0001\u0000\u0000\u00004\u0162\u0001\u0000\u0000\u00006\u016a\u0001\u0000"+
		"\u0000\u00008\u0172\u0001\u0000\u0000\u0000:\u017a\u0001\u0000\u0000\u0000"+
		"<\u0199\u0001\u0000\u0000\u0000>\u01a5\u0001\u0000\u0000\u0000@\u01a7"+
		"\u0001\u0000\u0000\u0000B\u01a9\u0001\u0000\u0000\u0000D\u01b5\u0001\u0000"+
		"\u0000\u0000F\u01c1\u0001\u0000\u0000\u0000H\u01ca\u0001\u0000\u0000\u0000"+
		"J\u01d0\u0001\u0000\u0000\u0000L\u01ea\u0001\u0000\u0000\u0000N\u01ec"+
		"\u0001\u0000\u0000\u0000P\u01f3\u0001\u0000\u0000\u0000R\u01fd\u0001\u0000"+
		"\u0000\u0000TX\u0003\u001a\r\u0000UX\u0003\u0002\u0001\u0000VX\u0003\u0018"+
		"\f\u0000WT\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000"+
		"\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\]\u0005\u0000\u0000\u0001]\u0001\u0001\u0000\u0000\u0000^_\u0003 \u0010"+
		"\u0000_a\u0003\u0014\n\u0000`b\u0005=\u0000\u0000a`\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000bg\u0001\u0000\u0000\u0000cg\u0003\u000e"+
		"\u0007\u0000dg\u0003\u0012\t\u0000eg\u0003\u0010\b\u0000f^\u0001\u0000"+
		"\u0000\u0000fc\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000fe\u0001"+
		"\u0000\u0000\u0000g\u0003\u0001\u0000\u0000\u0000hm\u0003\u0006\u0003"+
		"\u0000ij\u0005\u0001\u0000\u0000jl\u0003\u0006\u0003\u0000ki\u0001\u0000"+
		"\u0000\u0000lo\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000n\u0005\u0001\u0000\u0000\u0000om\u0001\u0000\u0000"+
		"\u0000pt\u00050\u0000\u0000qt\u0003@ \u0000rt\u00054\u0000\u0000sp\u0001"+
		"\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000"+
		"t\u0007\u0001\u0000\u0000\u0000uv\u0005\u0002\u0000\u0000vw\u00051\u0000"+
		"\u0000wx\u0005\u0003\u0000\u0000x\t\u0001\u0000\u0000\u0000yz\u0005\u0004"+
		"\u0000\u0000z\u007f\u00051\u0000\u0000{|\u0005\u0001\u0000\u0000|~\u0005"+
		"1\u0000\u0000}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0082\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0005\u0005\u0000\u0000\u0083\u000b\u0001\u0000\u0000\u0000\u0084"+
		"\u0089\u0003@ \u0000\u0085\u0086\u0005\u0001\u0000\u0000\u0086\u0088\u0003"+
		"@ \u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000"+
		"\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000"+
		"\u0000\u008a\r\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0005\u0006\u0000\u0000\u008d\u008e\u0003\b\u0004\u0000\u008e"+
		"\u0091\u00050\u0000\u0000\u008f\u0090\u0005\u0007\u0000\u0000\u0090\u0092"+
		"\u00055\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001"+
		"\u0000\u0000\u0000\u0092\u0094\u0001\u0000\u0000\u0000\u0093\u0095\u0005"+
		"=\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u000f\u0001\u0000\u0000\u0000\u0096\u0097\u0003 \u0010"+
		"\u0000\u0097\u0098\u00050\u0000\u0000\u0098\u009c\u0003\b\u0004\u0000"+
		"\u0099\u009b\u0003\b\u0004\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b"+
		"\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c"+
		"\u009d\u0001\u0000\u0000\u0000\u009d\u00a4\u0001\u0000\u0000\u0000\u009e"+
		"\u009c\u0001\u0000\u0000\u0000\u009f\u00a0\u0005\u0007\u0000\u0000\u00a0"+
		"\u00a1\u0005\u0002\u0000\u0000\u00a1\u00a2\u0003\u0004\u0002\u0000\u00a2"+
		"\u00a3\u0005\u0003\u0000\u0000\u00a3\u00a5\u0001\u0000\u0000\u0000\u00a4"+
		"\u009f\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a6\u00a8\u0005=\u0000\u0000\u00a7\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u0011"+
		"\u0001\u0000\u0000\u0000\u00a9\u00aa\u0003\"\u0011\u0000\u00aa\u00ab\u0005"+
		"0\u0000\u0000\u00ab\u00b8\u0003\n\u0005\u0000\u00ac\u00ad\u0005\u0007"+
		"\u0000\u0000\u00ad\u00ae\u0005\u0004\u0000\u0000\u00ae\u00b3\u0003\f\u0006"+
		"\u0000\u00af\u00b0\u0005\b\u0000\u0000\u00b0\u00b2\u0003\f\u0006\u0000"+
		"\u00b1\u00af\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b7\u0005\u0005\u0000\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b8\u00ac\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00bc\u0005=\u0000\u0000\u00bb"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc"+
		"\u0013\u0001\u0000\u0000\u0000\u00bd\u00c2\u0003\u0016\u000b\u0000\u00be"+
		"\u00bf\u0005\u0001\u0000\u0000\u00bf\u00c1\u0003\u0016\u000b\u0000\u00c0"+
		"\u00be\u0001\u0000\u0000\u0000\u00c1\u00c4\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3"+
		"\u0015\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c8\u00050\u0000\u0000\u00c6\u00c7\u0005\u0007\u0000\u0000\u00c7\u00c9"+
		"\u0003.\u0017\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c9\u0017\u0001\u0000\u0000\u0000\u00ca\u00ce\u0003"+
		" \u0010\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ce\u0005\t"+
		"\u0000\u0000\u00cd\u00ca\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d0\u00050\u0000\u0000\u00d0\u00d2\u0005\n\u0000"+
		"\u0000\u00d1\u00d3\u0003$\u0012\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u0005\u000b\u0000\u0000\u00d5\u00d6\u0003(\u0014\u0000\u00d6"+
		"\u0019\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005\f\u0000\u0000\u00d8\u00d9"+
		"\u00050\u0000\u0000\u00d9\u00db\u0003\u001c\u000e\u0000\u00da\u00dc\u0005"+
		"=\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000"+
		"\u0000\u0000\u00dc\u001b\u0001\u0000\u0000\u0000\u00dd\u00e1\u0005\r\u0000"+
		"\u0000\u00de\u00e0\u0003\u001e\u000f\u0000\u00df\u00de\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e7\u0001\u0000\u0000"+
		"\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e6\u0003\u0018\f\u0000"+
		"\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e8\u00ea\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0005\u000e\u0000\u0000\u00eb\u001d\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ed\u0003 \u0010\u0000\u00ed\u00ef\u00050\u0000\u0000\u00ee\u00f0"+
		"\u0005=\u0000\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f0\u001f\u0001\u0000\u0000\u0000\u00f1\u00fd\u0005"+
		"\u000f\u0000\u0000\u00f2\u00fd\u0005\u0010\u0000\u0000\u00f3\u00fd\u0005"+
		"\u0011\u0000\u0000\u00f4\u00fd\u0005\u0012\u0000\u0000\u00f5\u00fd\u0005"+
		"\u0013\u0000\u0000\u00f6\u00f7\u0005\f\u0000\u0000\u00f7\u00fd\u00050"+
		"\u0000\u0000\u00f8\u00f9\u0005\u0006\u0000\u0000\u00f9\u00fa\u0005\u0002"+
		"\u0000\u0000\u00fa\u00fb\u00051\u0000\u0000\u00fb\u00fd\u0005\u0003\u0000"+
		"\u0000\u00fc\u00f1\u0001\u0000\u0000\u0000\u00fc\u00f2\u0001\u0000\u0000"+
		"\u0000\u00fc\u00f3\u0001\u0000\u0000\u0000\u00fc\u00f4\u0001\u0000\u0000"+
		"\u0000\u00fc\u00f5\u0001\u0000\u0000\u0000\u00fc\u00f6\u0001\u0000\u0000"+
		"\u0000\u00fc\u00f8\u0001\u0000\u0000\u0000\u00fd!\u0001\u0000\u0000\u0000"+
		"\u00fe\u00ff\u0007\u0000\u0000\u0000\u00ff#\u0001\u0000\u0000\u0000\u0100"+
		"\u0105\u0003&\u0013\u0000\u0101\u0102\u0005\u0001\u0000\u0000\u0102\u0104"+
		"\u0003&\u0013\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u0107\u0001"+
		"\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001"+
		"\u0000\u0000\u0000\u0106\u0111\u0001\u0000\u0000\u0000\u0107\u0105\u0001"+
		"\u0000\u0000\u0000\u0108\u010d\u00050\u0000\u0000\u0109\u010a\u0005\u0001"+
		"\u0000\u0000\u010a\u010c\u00050\u0000\u0000\u010b\u0109\u0001\u0000\u0000"+
		"\u0000\u010c\u010f\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u0111\u0001\u0000\u0000"+
		"\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u0110\u0100\u0001\u0000\u0000"+
		"\u0000\u0110\u0108\u0001\u0000\u0000\u0000\u0111%\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u0003 \u0010\u0000\u0113\u0114\u00050\u0000\u0000\u0114\'"+
		"\u0001\u0000\u0000\u0000\u0115\u011a\u0005\r\u0000\u0000\u0116\u0119\u0003"+
		"\u0002\u0001\u0000\u0117\u0119\u0003*\u0015\u0000\u0118\u0116\u0001\u0000"+
		"\u0000\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0119\u011c\u0001\u0000"+
		"\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000"+
		"\u0000\u0000\u011b\u011d\u0001\u0000\u0000\u0000\u011c\u011a\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0005\u000e\u0000\u0000\u011e)\u0001\u0000\u0000"+
		"\u0000\u011f\u0127\u0003,\u0016\u0000\u0120\u0127\u0003(\u0014\u0000\u0121"+
		"\u0127\u0003F#\u0000\u0122\u0127\u0003H$\u0000\u0123\u0127\u0003J%\u0000"+
		"\u0124\u0127\u0003L&\u0000\u0125\u0127\u0003N\'\u0000\u0126\u011f\u0001"+
		"\u0000\u0000\u0000\u0126\u0120\u0001\u0000\u0000\u0000\u0126\u0121\u0001"+
		"\u0000\u0000\u0000\u0126\u0122\u0001\u0000\u0000\u0000\u0126\u0123\u0001"+
		"\u0000\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0126\u0125\u0001"+
		"\u0000\u0000\u0000\u0127+\u0001\u0000\u0000\u0000\u0128\u012a\u0003.\u0017"+
		"\u0000\u0129\u012b\u0005=\u0000\u0000\u012a\u0129\u0001\u0000\u0000\u0000"+
		"\u012a\u012b\u0001\u0000\u0000\u0000\u012b-\u0001\u0000\u0000\u0000\u012c"+
		"\u012d\u0006\u0017\uffff\uffff\u0000\u012d\u012e\u0005\u0017\u0000\u0000"+
		"\u012e\u0141\u0003.\u0017\u000e\u012f\u0141\u00054\u0000\u0000\u0130\u0141"+
		"\u00052\u0000\u0000\u0131\u0141\u00053\u0000\u0000\u0132\u0141\u00051"+
		"\u0000\u0000\u0133\u0141\u00050\u0000\u0000\u0134\u0141\u00056\u0000\u0000"+
		"\u0135\u0136\u0003@ \u0000\u0136\u0137\u0005\u0018\u0000\u0000\u0137\u0141"+
		"\u0001\u0000\u0000\u0000\u0138\u0139\u0003@ \u0000\u0139\u013a\u0005\u0019"+
		"\u0000\u0000\u013a\u0141\u0001\u0000\u0000\u0000\u013b\u0141\u00030\u0018"+
		"\u0000\u013c\u0141\u0003<\u001e\u0000\u013d\u0141\u0003:\u001d\u0000\u013e"+
		"\u0141\u0003B!\u0000\u013f\u0141\u0003D\"\u0000\u0140\u012c\u0001\u0000"+
		"\u0000\u0000\u0140\u012f\u0001\u0000\u0000\u0000\u0140\u0130\u0001\u0000"+
		"\u0000\u0000\u0140\u0131\u0001\u0000\u0000\u0000\u0140\u0132\u0001\u0000"+
		"\u0000\u0000\u0140\u0133\u0001\u0000\u0000\u0000\u0140\u0134\u0001\u0000"+
		"\u0000\u0000\u0140\u0135\u0001\u0000\u0000\u0000\u0140\u0138\u0001\u0000"+
		"\u0000\u0000\u0140\u013b\u0001\u0000\u0000\u0000\u0140\u013c\u0001\u0000"+
		"\u0000\u0000\u0140\u013d\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000"+
		"\u0000\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0141\u014d\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\n\u0011\u0000\u0000\u0143\u0144\u0005\u0014\u0000"+
		"\u0000\u0144\u014c\u0003.\u0017\u0012\u0145\u0146\n\u0010\u0000\u0000"+
		"\u0146\u0147\u0005\u0015\u0000\u0000\u0147\u014c\u0003.\u0017\u0011\u0148"+
		"\u0149\n\u000f\u0000\u0000\u0149\u014a\u0005\u0016\u0000\u0000\u014a\u014c"+
		"\u0003.\u0017\u0010\u014b\u0142\u0001\u0000\u0000\u0000\u014b\u0145\u0001"+
		"\u0000\u0000\u0000\u014b\u0148\u0001\u0000\u0000\u0000\u014c\u014f\u0001"+
		"\u0000\u0000\u0000\u014d\u014b\u0001\u0000\u0000\u0000\u014d\u014e\u0001"+
		"\u0000\u0000\u0000\u014e/\u0001\u0000\u0000\u0000\u014f\u014d\u0001\u0000"+
		"\u0000\u0000\u0150\u0151\u00050\u0000\u0000\u0151\u0152\u00057\u0000\u0000"+
		"\u0152\u0159\u0003.\u0017\u0000\u0153\u0154\u0003:\u001d\u0000\u0154\u0155"+
		"\u0007\u0001\u0000\u0000\u0155\u0156\u0003.\u0017\u0000\u0156\u0159\u0001"+
		"\u0000\u0000\u0000\u0157\u0159\u00032\u0019\u0000\u0158\u0150\u0001\u0000"+
		"\u0000\u0000\u0158\u0153\u0001\u0000\u0000\u0000\u0158\u0157\u0001\u0000"+
		"\u0000\u0000\u01591\u0001\u0000\u0000\u0000\u015a\u015f\u00034\u001a\u0000"+
		"\u015b\u015c\u0007\u0002\u0000\u0000\u015c\u015e\u00034\u001a\u0000\u015d"+
		"\u015b\u0001\u0000\u0000\u0000\u015e\u0161\u0001\u0000\u0000\u0000\u015f"+
		"\u015d\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000\u0000\u0160"+
		"3\u0001\u0000\u0000\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0167"+
		"\u00036\u001b\u0000\u0163\u0164\u0007\u0003\u0000\u0000\u0164\u0166\u0003"+
		"6\u001b\u0000\u0165\u0163\u0001\u0000\u0000\u0000\u0166\u0169\u0001\u0000"+
		"\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000"+
		"\u0000\u0000\u01685\u0001\u0000\u0000\u0000\u0169\u0167\u0001\u0000\u0000"+
		"\u0000\u016a\u016f\u00038\u001c\u0000\u016b\u016c\u0007\u0004\u0000\u0000"+
		"\u016c\u016e\u00038\u001c\u0000\u016d\u016b\u0001\u0000\u0000\u0000\u016e"+
		"\u0171\u0001\u0000\u0000\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f"+
		"\u0170\u0001\u0000\u0000\u0000\u01707\u0001\u0000\u0000\u0000\u0171\u016f"+
		"\u0001\u0000\u0000\u0000\u0172\u0177\u0003>\u001f\u0000\u0173\u0174\u0007"+
		"\u0005\u0000\u0000\u0174\u0176\u0003>\u001f\u0000\u0175\u0173\u0001\u0000"+
		"\u0000\u0000\u0176\u0179\u0001\u0000\u0000\u0000\u0177\u0175\u0001\u0000"+
		"\u0000\u0000\u0177\u0178\u0001\u0000\u0000\u0000\u01789\u0001\u0000\u0000"+
		"\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u017a\u017b\u0003>\u001f\u0000"+
		"\u017b\u017c\u0005-\u0000\u0000\u017c\u0181\u00050\u0000\u0000\u017d\u017e"+
		"\u0005-\u0000\u0000\u017e\u0180\u00050\u0000\u0000\u017f\u017d\u0001\u0000"+
		"\u0000\u0000\u0180\u0183\u0001\u0000\u0000\u0000\u0181\u017f\u0001\u0000"+
		"\u0000\u0000\u0181\u0182\u0001\u0000\u0000\u0000\u0182\u0185\u0001\u0000"+
		"\u0000\u0000\u0183\u0181\u0001\u0000\u0000\u0000\u0184\u0186\u0005=\u0000"+
		"\u0000\u0185\u0184\u0001\u0000\u0000\u0000\u0185\u0186\u0001\u0000\u0000"+
		"\u0000\u0186;\u0001\u0000\u0000\u0000\u0187\u0188\u00050\u0000\u0000\u0188"+
		"\u018a\u0005\n\u0000\u0000\u0189\u018b\u0003$\u0012\u0000\u018a\u0189"+
		"\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018c"+
		"\u0001\u0000\u0000\u0000\u018c\u018e\u0005\u000b\u0000\u0000\u018d\u018f"+
		"\u0005=\u0000\u0000\u018e\u018d\u0001\u0000\u0000\u0000\u018e\u018f\u0001"+
		"\u0000\u0000\u0000\u018f\u019a\u0001\u0000\u0000\u0000\u0190\u0191\u0003"+
		":\u001d\u0000\u0191\u0193\u0005\n\u0000\u0000\u0192\u0194\u0003$\u0012"+
		"\u0000\u0193\u0192\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000"+
		"\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195\u0197\u0005\u000b\u0000"+
		"\u0000\u0196\u0198\u0005=\u0000\u0000\u0197\u0196\u0001\u0000\u0000\u0000"+
		"\u0197\u0198\u0001\u0000\u0000\u0000\u0198\u019a\u0001\u0000\u0000\u0000"+
		"\u0199\u0187\u0001\u0000\u0000\u0000\u0199\u0190\u0001\u0000\u0000\u0000"+
		"\u019a=\u0001\u0000\u0000\u0000\u019b\u01a6\u00050\u0000\u0000\u019c\u01a6"+
		"\u00051\u0000\u0000\u019d\u01a6\u00052\u0000\u0000\u019e\u01a6\u00053"+
		"\u0000\u0000\u019f\u01a6\u00054\u0000\u0000\u01a0\u01a6\u00056\u0000\u0000"+
		"\u01a1\u01a2\u0005\n\u0000\u0000\u01a2\u01a3\u0003.\u0017\u0000\u01a3"+
		"\u01a4\u0005\u000b\u0000\u0000\u01a4\u01a6\u0001\u0000\u0000\u0000\u01a5"+
		"\u019b\u0001\u0000\u0000\u0000\u01a5\u019c\u0001\u0000\u0000\u0000\u01a5"+
		"\u019d\u0001\u0000\u0000\u0000\u01a5\u019e\u0001\u0000\u0000\u0000\u01a5"+
		"\u019f\u0001\u0000\u0000\u0000\u01a5\u01a0\u0001\u0000\u0000\u0000\u01a5"+
		"\u01a1\u0001\u0000\u0000\u0000\u01a6?\u0001\u0000\u0000\u0000\u01a7\u01a8"+
		"\u0007\u0006\u0000\u0000\u01a8A\u0001\u0000\u0000\u0000\u01a9\u01aa\u0005"+
		"0\u0000\u0000\u01aa\u01ab\u0005\u0002\u0000\u0000\u01ab\u01af\u00051\u0000"+
		"\u0000\u01ac\u01ae\u0005\u0003\u0000\u0000\u01ad\u01ac\u0001\u0000\u0000"+
		"\u0000\u01ae\u01b1\u0001\u0000\u0000\u0000\u01af\u01ad\u0001\u0000\u0000"+
		"\u0000\u01af\u01b0\u0001\u0000\u0000\u0000\u01b0\u01b3\u0001\u0000\u0000"+
		"\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b2\u01b4\u0005=\u0000\u0000"+
		"\u01b3\u01b2\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001\u0000\u0000\u0000"+
		"\u01b4C\u0001\u0000\u0000\u0000\u01b5\u01bb\u00050\u0000\u0000\u01b6\u01b7"+
		"\u0005\u0004\u0000\u0000\u01b7\u01b8\u00051\u0000\u0000\u01b8\u01ba\u0005"+
		"\u0005\u0000\u0000\u01b9\u01b6\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001"+
		"\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001"+
		"\u0000\u0000\u0000\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001"+
		"\u0000\u0000\u0000\u01be\u01c0\u0005=\u0000\u0000\u01bf\u01be\u0001\u0000"+
		"\u0000\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0E\u0001\u0000\u0000"+
		"\u0000\u01c1\u01c2\u00058\u0000\u0000\u01c2\u01c3\u0005\n\u0000\u0000"+
		"\u01c3\u01c4\u0003.\u0017\u0000\u01c4\u01c5\u0005\u000b\u0000\u0000\u01c5"+
		"\u01c8\u0003*\u0015\u0000\u01c6\u01c7\u00059\u0000\u0000\u01c7\u01c9\u0003"+
		"*\u0015\u0000\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000"+
		"\u0000\u0000\u01c9G\u0001\u0000\u0000\u0000\u01ca\u01cb\u0005;\u0000\u0000"+
		"\u01cb\u01cc\u0005\n\u0000\u0000\u01cc\u01cd\u0003.\u0017\u0000\u01cd"+
		"\u01ce\u0005\u000b\u0000\u0000\u01ce\u01cf\u0003*\u0015\u0000\u01cfI\u0001"+
		"\u0000\u0000\u0000\u01d0\u01d1\u0005:\u0000\u0000\u01d1\u01d3\u0005\n"+
		"\u0000\u0000\u01d2\u01d4\u0003\u0002\u0001\u0000\u01d3\u01d2\u0001\u0000"+
		"\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d5\u0001\u0000"+
		"\u0000\u0000\u01d5\u01d6\u0005\b\u0000\u0000\u01d6\u01d7\u00030\u0018"+
		"\u0000\u01d7\u01d8\u0005\b\u0000\u0000\u01d8\u01d9\u0003.\u0017\u0000"+
		"\u01d9\u01da\u0005\u000b\u0000\u0000\u01da\u01db\u0003*\u0015\u0000\u01db"+
		"K\u0001\u0000\u0000\u0000\u01dc\u01dd\u0005.\u0000\u0000\u01dd\u01de\u0005"+
		"\n\u0000\u0000\u01de\u01df\u0003P(\u0000\u01df\u01e1\u0005\u000b\u0000"+
		"\u0000\u01e0\u01e2\u0005=\u0000\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000"+
		"\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2\u01eb\u0001\u0000\u0000\u0000"+
		"\u01e3\u01e4\u0005/\u0000\u0000\u01e4\u01e5\u0005\n\u0000\u0000\u01e5"+
		"\u01e6\u00050\u0000\u0000\u01e6\u01e8\u0005\u000b\u0000\u0000\u01e7\u01e9"+
		"\u0005=\u0000\u0000\u01e8\u01e7\u0001\u0000\u0000\u0000\u01e8\u01e9\u0001"+
		"\u0000\u0000\u0000\u01e9\u01eb\u0001\u0000\u0000\u0000\u01ea\u01dc\u0001"+
		"\u0000\u0000\u0000\u01ea\u01e3\u0001\u0000\u0000\u0000\u01ebM\u0001\u0000"+
		"\u0000\u0000\u01ec\u01ee\u0005<\u0000\u0000\u01ed\u01ef\u0003.\u0017\u0000"+
		"\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001\u0000\u0000\u0000"+
		"\u01ef\u01f1\u0001\u0000\u0000\u0000\u01f0\u01f2\u0005=\u0000\u0000\u01f1"+
		"\u01f0\u0001\u0000\u0000\u0000\u01f1\u01f2\u0001\u0000\u0000\u0000\u01f2"+
		"O\u0001\u0000\u0000\u0000\u01f3\u01f8\u0003R)\u0000\u01f4\u01f5\u0005"+
		"\u0001\u0000\u0000\u01f5\u01f7\u0003R)\u0000\u01f6\u01f4\u0001\u0000\u0000"+
		"\u0000\u01f7\u01fa\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000"+
		"\u0000\u01f8\u01f9\u0001\u0000\u0000\u0000\u01f9Q\u0001\u0000\u0000\u0000"+
		"\u01fa\u01f8\u0001\u0000\u0000\u0000\u01fb\u01fe\u0003.\u0017\u0000\u01fc"+
		"\u01fe\u00055\u0000\u0000\u01fd\u01fb\u0001\u0000\u0000\u0000\u01fd\u01fc"+
		"\u0001\u0000\u0000\u0000\u01feS\u0001\u0000\u0000\u0000=WYafms\u007f\u0089"+
		"\u0091\u0094\u009c\u00a4\u00a7\u00b3\u00b8\u00bb\u00c2\u00c8\u00cd\u00d2"+
		"\u00db\u00e1\u00e7\u00ef\u00fc\u0105\u010d\u0110\u0118\u011a\u0126\u012a"+
		"\u0140\u014b\u014d\u0158\u015f\u0167\u016f\u0177\u0181\u0185\u018a\u018e"+
		"\u0193\u0197\u0199\u01a5\u01af\u01b3\u01bb\u01bf\u01c8\u01d3\u01e1\u01e8"+
		"\u01ea\u01ee\u01f1\u01f8\u01fd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}