// Generated from C:/Users/Dell/IdeaProjects/Task/grammars/Task10.g4 by ANTLR 4.13.1
package csen1002.main.task10;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Task10Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Number=2;
	public static final int
		RULE_s = 0, RULE_f = 1, RULE_a = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"s", "f", "a"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Number"
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
	public String getGrammarFileName() { return "Task10.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Task10Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SContext extends ParserRuleContext {
		public int val;
		public FContext f;
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Task10Parser.EOF, 0); }
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Task10Listener ) ((Task10Listener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Task10Listener ) ((Task10Listener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Task10Visitor ) return ((Task10Visitor<? extends T>)visitor).visitS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_s);
		try {
			setState(12);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(6);
				((SContext)_localctx).f = f(-1 , 0 , 0);
				setState(7);
				match(EOF);
				((SContext)_localctx).val =  ((SContext)_localctx).f.val;
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(10);
				match(EOF);
				((SContext)_localctx).val = 0;
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
	public static class FContext extends ParserRuleContext {
		public int prev;
		public int set;
		public int count;
		public int val;
		public AContext a;
		public FContext f;
		public AContext a() {
			return getRuleContext(AContext.class,0);
		}
		public FContext f() {
			return getRuleContext(FContext.class,0);
		}
		public FContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public FContext(ParserRuleContext parent, int invokingState, int prev, int set, int count) {
			super(parent, invokingState);
			this.prev = prev;
			this.set = set;
			this.count = count;
		}
		@Override public int getRuleIndex() { return RULE_f; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Task10Listener ) ((Task10Listener)listener).enterF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Task10Listener ) ((Task10Listener)listener).exitF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Task10Visitor ) return ((Task10Visitor<? extends T>)visitor).visitF(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FContext f(int prev,int set,int count) throws RecognitionException {
		FContext _localctx = new FContext(_ctx, getState(), prev, set, count);
		enterRule(_localctx, 2, RULE_f);
		try {
			setState(22);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(14);
				((FContext)_localctx).a = a(_localctx.prev , _localctx.set , _localctx.count);
				setState(15);
				match(T__0);
				setState(16);
				((FContext)_localctx).f = f(((FContext)_localctx).a.text , ((FContext)_localctx).a.set1,((FContext)_localctx).a.count1);
				((FContext)_localctx).val = ((FContext)_localctx).f.val;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				((FContext)_localctx).a = a(_localctx.prev , _localctx.set , _localctx.count);
				((FContext)_localctx).val = ((FContext)_localctx).a.count1; 
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
	public static class AContext extends ParserRuleContext {
		public int prev;
		public int set;
		public int count;
		public int set1;
		public int count1;
		public int text;
		public Token Number;
		public TerminalNode Number() { return getToken(Task10Parser.Number, 0); }
		public AContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public AContext(ParserRuleContext parent, int invokingState, int prev, int set, int count) {
			super(parent, invokingState);
			this.prev = prev;
			this.set = set;
			this.count = count;
		}
		@Override public int getRuleIndex() { return RULE_a; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Task10Listener ) ((Task10Listener)listener).enterA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Task10Listener ) ((Task10Listener)listener).exitA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Task10Visitor ) return ((Task10Visitor<? extends T>)visitor).visitA(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AContext a(int prev,int set,int count) throws RecognitionException {
		AContext _localctx = new AContext(_ctx, getState(), prev, set, count);
		enterRule(_localctx, 4, RULE_a);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			((AContext)_localctx).Number = match(Number);
			 ((AContext)_localctx).text = Integer.parseInt((((AContext)_localctx).Number!=null?((AContext)_localctx).Number.getText():null));int generated= Integer.parseInt((((AContext)_localctx).Number!=null?((AContext)_localctx).Number.getText():null));  if (_localctx.prev==generated && set==0) { ((AContext)_localctx).count1 = _localctx.count+1 ; ((AContext)_localctx).set1 = 1; } else {((AContext)_localctx).count1 = _localctx.count ; ((AContext)_localctx).set1 = _localctx.set;};  if (_localctx.prev!=generated) {((AContext)_localctx).set1 = 0;}  
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

	public static final String _serializedATN =
		"\u0004\u0001\u0002\u001c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0003\u0000\r\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u0017\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0000\u0000\u0003\u0000\u0002\u0004\u0000\u0000\u001a\u0000\f\u0001\u0000"+
		"\u0000\u0000\u0002\u0016\u0001\u0000\u0000\u0000\u0004\u0018\u0001\u0000"+
		"\u0000\u0000\u0006\u0007\u0003\u0002\u0001\u0000\u0007\b\u0005\u0000\u0000"+
		"\u0001\b\t\u0006\u0000\uffff\uffff\u0000\t\r\u0001\u0000\u0000\u0000\n"+
		"\u000b\u0005\u0000\u0000\u0001\u000b\r\u0006\u0000\uffff\uffff\u0000\f"+
		"\u0006\u0001\u0000\u0000\u0000\f\n\u0001\u0000\u0000\u0000\r\u0001\u0001"+
		"\u0000\u0000\u0000\u000e\u000f\u0003\u0004\u0002\u0000\u000f\u0010\u0005"+
		"\u0001\u0000\u0000\u0010\u0011\u0003\u0002\u0001\u0000\u0011\u0012\u0006"+
		"\u0001\uffff\uffff\u0000\u0012\u0017\u0001\u0000\u0000\u0000\u0013\u0014"+
		"\u0003\u0004\u0002\u0000\u0014\u0015\u0006\u0001\uffff\uffff\u0000\u0015"+
		"\u0017\u0001\u0000\u0000\u0000\u0016\u000e\u0001\u0000\u0000\u0000\u0016"+
		"\u0013\u0001\u0000\u0000\u0000\u0017\u0003\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0005\u0002\u0000\u0000\u0019\u001a\u0006\u0002\uffff\uffff\u0000"+
		"\u001a\u0005\u0001\u0000\u0000\u0000\u0002\f\u0016";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}