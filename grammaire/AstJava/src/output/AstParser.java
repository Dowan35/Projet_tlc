// $ANTLR 3.5.1 C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g 2025-01-11 13:54:20

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class AstParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGN", "CALL", "COMMANDS", 
		"CONS", "DEFINITION", "ELSE", "EXPRESSION", "EXPRESSIONS", "EXPRS", "FOR", 
		"FUNCTION", "HD", "IF", "INPUT", "INPUTSUB", "LEXPR", "LIST", "NIL", "NOP", 
		"OUTPUT", "OUTPUTS", "PROGRAM", "SYM", "Symbol", "TL", "TLLIST", "VAR", 
		"VARS", "Variable", "WHILE", "WS", "'%'", "'('", "')'", "','", "':'", 
		"':='", "';'", "'=?'", "'cons'", "'do'", "'else'", "'fi'", "'for'", "'function'", 
		"'hd'", "'if'", "'list'", "'nil'", "'nop'", "'od'", "'read'", "'then'", 
		"'tl'", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__35=35;
	public static final int T__36=36;
	public static final int T__37=37;
	public static final int T__38=38;
	public static final int T__39=39;
	public static final int T__40=40;
	public static final int T__41=41;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int T__46=46;
	public static final int T__47=47;
	public static final int T__48=48;
	public static final int T__49=49;
	public static final int T__50=50;
	public static final int T__51=51;
	public static final int T__52=52;
	public static final int T__53=53;
	public static final int T__54=54;
	public static final int T__55=55;
	public static final int T__56=56;
	public static final int T__57=57;
	public static final int T__58=58;
	public static final int T__59=59;
	public static final int ASSIGN=4;
	public static final int CALL=5;
	public static final int COMMANDS=6;
	public static final int CONS=7;
	public static final int DEFINITION=8;
	public static final int ELSE=9;
	public static final int EXPRESSION=10;
	public static final int EXPRESSIONS=11;
	public static final int EXPRS=12;
	public static final int FOR=13;
	public static final int FUNCTION=14;
	public static final int HD=15;
	public static final int IF=16;
	public static final int INPUT=17;
	public static final int INPUTSUB=18;
	public static final int LEXPR=19;
	public static final int LIST=20;
	public static final int NIL=21;
	public static final int NOP=22;
	public static final int OUTPUT=23;
	public static final int OUTPUTS=24;
	public static final int PROGRAM=25;
	public static final int SYM=26;
	public static final int Symbol=27;
	public static final int TL=28;
	public static final int TLLIST=29;
	public static final int VAR=30;
	public static final int VARS=31;
	public static final int Variable=32;
	public static final int WHILE=33;
	public static final int WS=34;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "exprs", "command", "inputSub", "function", "output", "input", 
		"vars", "expression", "program", "definition", "commands", "exprBase", 
		"lExpr"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false, false, false, 
		    false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public AstParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public AstParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public AstParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return AstParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:37:1: program : ( function )+ EOF -> ^( PROGRAM ( function )+ ) ;
	public final AstParser.program_return program() throws RecognitionException {
		AstParser.program_return retval = new AstParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2=null;
		ParserRuleReturnScope function1 =null;

		Object EOF2_tree=null;
		RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");

		try { dbg.enterRule(getGrammarFileName(), "program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(37, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:37:9: ( ( function )+ EOF -> ^( PROGRAM ( function )+ ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:37:11: ( function )+ EOF
			{
			dbg.location(37,11);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:37:11: ( function )+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==48) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:37:11: function
					{
					dbg.location(37,11);
					pushFollow(FOLLOW_function_in_program139);
					function1=function();
					state._fsp--;

					stream_function.add(function1.getTree());
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt1++;
			}
			} finally {dbg.exitSubRule(1);}
			dbg.location(37,21);
			EOF2=(Token)match(input,EOF,FOLLOW_EOF_in_program142);  
			stream_EOF.add(EOF2);

			// AST REWRITE
			// elements: function
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 37:25: -> ^( PROGRAM ( function )+ )
			{
				dbg.location(37,28);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:37:28: ^( PROGRAM ( function )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(37,30);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);
				dbg.location(37,38);
				if ( !(stream_function.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_function.hasNext() ) {
					dbg.location(37,38);
					adaptor.addChild(root_1, stream_function.nextTree());
				}
				stream_function.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(37, 47);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "program"


	public static class function_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:39:1: function : 'function' Symbol ':' definition -> ^( FUNCTION Symbol definition ) ;
	public final AstParser.function_return function() throws RecognitionException {
		AstParser.function_return retval = new AstParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal3=null;
		Token Symbol4=null;
		Token char_literal5=null;
		ParserRuleReturnScope definition6 =null;

		Object string_literal3_tree=null;
		Object Symbol4_tree=null;
		Object char_literal5_tree=null;
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try { dbg.enterRule(getGrammarFileName(), "function");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(39, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:39:10: ( 'function' Symbol ':' definition -> ^( FUNCTION Symbol definition ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:39:12: 'function' Symbol ':' definition
			{
			dbg.location(39,12);
			string_literal3=(Token)match(input,48,FOLLOW_48_in_function159);  
			stream_48.add(string_literal3);
			dbg.location(39,23);
			Symbol4=(Token)match(input,Symbol,FOLLOW_Symbol_in_function161);  
			stream_Symbol.add(Symbol4);
			dbg.location(39,30);
			char_literal5=(Token)match(input,39,FOLLOW_39_in_function163);  
			stream_39.add(char_literal5);
			dbg.location(39,34);
			pushFollow(FOLLOW_definition_in_function165);
			definition6=definition();
			state._fsp--;

			stream_definition.add(definition6.getTree());
			// AST REWRITE
			// elements: Symbol, definition
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 39:45: -> ^( FUNCTION Symbol definition )
			{
				dbg.location(39,48);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:39:48: ^( FUNCTION Symbol definition )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(39,50);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
				dbg.location(39,59);
				adaptor.addChild(root_1, stream_Symbol.nextNode());dbg.location(39,66);
				adaptor.addChild(root_1, stream_definition.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(39, 76);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "function"


	public static class definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "definition"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:41:1: definition : 'read' input '%' commands '%' 'write' output -> ^( DEFINITION input commands output ) ;
	public final AstParser.definition_return definition() throws RecognitionException {
		AstParser.definition_return retval = new AstParser.definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal7=null;
		Token char_literal9=null;
		Token char_literal11=null;
		Token string_literal12=null;
		ParserRuleReturnScope input8 =null;
		ParserRuleReturnScope commands10 =null;
		ParserRuleReturnScope output13 =null;

		Object string_literal7_tree=null;
		Object char_literal9_tree=null;
		Object char_literal11_tree=null;
		Object string_literal12_tree=null;
		RewriteRuleTokenStream stream_55=new RewriteRuleTokenStream(adaptor,"token 55");
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_59=new RewriteRuleTokenStream(adaptor,"token 59");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try { dbg.enterRule(getGrammarFileName(), "definition");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(41, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:41:12: ( 'read' input '%' commands '%' 'write' output -> ^( DEFINITION input commands output ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:41:14: 'read' input '%' commands '%' 'write' output
			{
			dbg.location(41,14);
			string_literal7=(Token)match(input,55,FOLLOW_55_in_definition183);  
			stream_55.add(string_literal7);
			dbg.location(41,21);
			pushFollow(FOLLOW_input_in_definition185);
			input8=input();
			state._fsp--;

			stream_input.add(input8.getTree());dbg.location(41,27);
			char_literal9=(Token)match(input,35,FOLLOW_35_in_definition187);  
			stream_35.add(char_literal9);
			dbg.location(41,31);
			pushFollow(FOLLOW_commands_in_definition189);
			commands10=commands();
			state._fsp--;

			stream_commands.add(commands10.getTree());dbg.location(41,40);
			char_literal11=(Token)match(input,35,FOLLOW_35_in_definition191);  
			stream_35.add(char_literal11);
			dbg.location(41,44);
			string_literal12=(Token)match(input,59,FOLLOW_59_in_definition193);  
			stream_59.add(string_literal12);
			dbg.location(41,52);
			pushFollow(FOLLOW_output_in_definition195);
			output13=output();
			state._fsp--;

			stream_output.add(output13.getTree());
			// AST REWRITE
			// elements: output, input, commands
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 42:12: -> ^( DEFINITION input commands output )
			{
				dbg.location(42,15);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:42:15: ^( DEFINITION input commands output )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(42,17);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(DEFINITION, "DEFINITION"), root_1);
				dbg.location(42,28);
				adaptor.addChild(root_1, stream_input.nextTree());dbg.location(42,34);
				adaptor.addChild(root_1, stream_commands.nextTree());dbg.location(42,43);
				adaptor.addChild(root_1, stream_output.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(42, 49);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "definition");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "definition"


	public static class input_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "input"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:45:1: input : ( inputSub )? -> ^( INPUT ( inputSub )? ) ;
	public final AstParser.input_return input() throws RecognitionException {
		AstParser.input_return retval = new AstParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputSub14 =null;

		RewriteRuleSubtreeStream stream_inputSub=new RewriteRuleSubtreeStream(adaptor,"rule inputSub");

		try { dbg.enterRule(getGrammarFileName(), "input");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(45, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:45:8: ( ( inputSub )? -> ^( INPUT ( inputSub )? ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:45:10: ( inputSub )?
			{
			dbg.location(45,10);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:45:10: ( inputSub )?
			int alt2=2;
			try { dbg.enterSubRule(2);
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			int LA2_0 = input.LA(1);
			if ( (LA2_0==Variable) ) {
				alt2=1;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:45:10: inputSub
					{
					dbg.location(45,10);
					pushFollow(FOLLOW_inputSub_in_input229);
					inputSub14=inputSub();
					state._fsp--;

					stream_inputSub.add(inputSub14.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(2);}

			// AST REWRITE
			// elements: inputSub
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 45:20: -> ^( INPUT ( inputSub )? )
			{
				dbg.location(45,23);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:45:23: ^( INPUT ( inputSub )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(45,25);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUT, "INPUT"), root_1);
				dbg.location(45,31);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:45:31: ( inputSub )?
				if ( stream_inputSub.hasNext() ) {
					dbg.location(45,31);
					adaptor.addChild(root_1, stream_inputSub.nextTree());
				}
				stream_inputSub.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(45, 40);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "input");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "input"


	public static class inputSub_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inputSub"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:46:1: inputSub : Variable ( ',' Variable )* -> ^( INPUTSUB ( Variable )* ) ;
	public final AstParser.inputSub_return inputSub() throws RecognitionException {
		AstParser.inputSub_return retval = new AstParser.inputSub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable15=null;
		Token char_literal16=null;
		Token Variable17=null;

		Object Variable15_tree=null;
		Object char_literal16_tree=null;
		Object Variable17_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");

		try { dbg.enterRule(getGrammarFileName(), "inputSub");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(46, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:46:10: ( Variable ( ',' Variable )* -> ^( INPUTSUB ( Variable )* ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:46:12: Variable ( ',' Variable )*
			{
			dbg.location(46,12);
			Variable15=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub246);  
			stream_Variable.add(Variable15);
			dbg.location(46,21);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:46:21: ( ',' Variable )*
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=2;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==38) ) {
					alt3=1;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:46:22: ',' Variable
					{
					dbg.location(46,22);
					char_literal16=(Token)match(input,38,FOLLOW_38_in_inputSub249);  
					stream_38.add(char_literal16);
					dbg.location(46,26);
					Variable17=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub251);  
					stream_Variable.add(Variable17);

					}
					break;

				default :
					break loop3;
				}
			}
			} finally {dbg.exitSubRule(3);}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 46:37: -> ^( INPUTSUB ( Variable )* )
			{
				dbg.location(46,40);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:46:40: ^( INPUTSUB ( Variable )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(46,42);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUTSUB, "INPUTSUB"), root_1);
				dbg.location(46,51);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:46:51: ( Variable )*
				while ( stream_Variable.hasNext() ) {
					dbg.location(46,51);
					adaptor.addChild(root_1, stream_Variable.nextNode());
				}
				stream_Variable.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(46, 60);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "inputSub");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "inputSub"


	public static class output_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "output"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:49:1: output : Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )* ) ;
	public final AstParser.output_return output() throws RecognitionException {
		AstParser.output_return retval = new AstParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable18=null;
		Token char_literal19=null;
		Token Variable20=null;

		Object Variable18_tree=null;
		Object char_literal19_tree=null;
		Object Variable20_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");

		try { dbg.enterRule(getGrammarFileName(), "output");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(49, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:49:8: ( Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )* ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:49:10: Variable ( ',' Variable )*
			{
			dbg.location(49,10);
			Variable18=(Token)match(input,Variable,FOLLOW_Variable_in_output271);  
			stream_Variable.add(Variable18);
			dbg.location(49,19);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:49:19: ( ',' Variable )*
			try { dbg.enterSubRule(4);

			loop4:
			while (true) {
				int alt4=2;
				try { dbg.enterDecision(4, decisionCanBacktrack[4]);

				int LA4_0 = input.LA(1);
				if ( (LA4_0==38) ) {
					alt4=1;
				}

				} finally {dbg.exitDecision(4);}

				switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:49:20: ',' Variable
					{
					dbg.location(49,20);
					char_literal19=(Token)match(input,38,FOLLOW_38_in_output274);  
					stream_38.add(char_literal19);
					dbg.location(49,24);
					Variable20=(Token)match(input,Variable,FOLLOW_Variable_in_output276);  
					stream_Variable.add(Variable20);

					}
					break;

				default :
					break loop4;
				}
			}
			} finally {dbg.exitSubRule(4);}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 49:35: -> ^( OUTPUT ( Variable )* )
			{
				dbg.location(49,38);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:49:38: ^( OUTPUT ( Variable )* )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(49,40);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUT, "OUTPUT"), root_1);
				dbg.location(49,47);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:49:47: ( Variable )*
				while ( stream_Variable.hasNext() ) {
					dbg.location(49,47);
					adaptor.addChild(root_1, stream_Variable.nextNode());
				}
				stream_Variable.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(49, 56);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "output");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "output"


	public static class commands_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "commands"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:52:1: commands : command ( ';' commands )? -> ^( COMMANDS ( command )+ ) ;
	public final AstParser.commands_return commands() throws RecognitionException {
		AstParser.commands_return retval = new AstParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal22=null;
		ParserRuleReturnScope command21 =null;
		ParserRuleReturnScope commands23 =null;

		Object char_literal22_tree=null;
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try { dbg.enterRule(getGrammarFileName(), "commands");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(52, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:52:10: ( command ( ';' commands )? -> ^( COMMANDS ( command )+ ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:52:12: command ( ';' commands )?
			{
			dbg.location(52,12);
			pushFollow(FOLLOW_command_in_commands296);
			command21=command();
			state._fsp--;

			stream_command.add(command21.getTree());dbg.location(52,20);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:52:20: ( ';' commands )?
			int alt5=2;
			try { dbg.enterSubRule(5);
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==41) ) {
				alt5=1;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:52:21: ';' commands
					{
					dbg.location(52,21);
					char_literal22=(Token)match(input,41,FOLLOW_41_in_commands299);  
					stream_41.add(char_literal22);
					dbg.location(52,25);
					pushFollow(FOLLOW_commands_in_commands301);
					commands23=commands();
					state._fsp--;

					stream_commands.add(commands23.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(5);}

			// AST REWRITE
			// elements: command
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 52:36: -> ^( COMMANDS ( command )+ )
			{
				dbg.location(52,39);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:52:39: ^( COMMANDS ( command )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(52,41);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_1);
				dbg.location(52,50);
				if ( !(stream_command.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_command.hasNext() ) {
					dbg.location(52,50);
					adaptor.addChild(root_1, stream_command.nextTree());
				}
				stream_command.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(52, 58);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "commands");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "commands"


	public static class command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:54:1: command : ( 'if' expression 'then' commands ( 'else' commands )? 'fi' -> ^( IF expression commands ( ^( ELSE commands ) )? ) | 'while' expression 'do' commands 'od' -> ^( WHILE expression commands ) | 'for' expression 'do' commands 'od' -> ^( FOR expression commands ) | 'nop' -> ^( NOP ) | vars ':=' expression -> ^( ASSIGN vars expression ) );
	public final AstParser.command_return command() throws RecognitionException {
		AstParser.command_return retval = new AstParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal24=null;
		Token string_literal26=null;
		Token string_literal28=null;
		Token string_literal30=null;
		Token string_literal31=null;
		Token string_literal33=null;
		Token string_literal35=null;
		Token string_literal36=null;
		Token string_literal38=null;
		Token string_literal40=null;
		Token string_literal41=null;
		Token string_literal43=null;
		ParserRuleReturnScope expression25 =null;
		ParserRuleReturnScope commands27 =null;
		ParserRuleReturnScope commands29 =null;
		ParserRuleReturnScope expression32 =null;
		ParserRuleReturnScope commands34 =null;
		ParserRuleReturnScope expression37 =null;
		ParserRuleReturnScope commands39 =null;
		ParserRuleReturnScope vars42 =null;
		ParserRuleReturnScope expression44 =null;

		Object string_literal24_tree=null;
		Object string_literal26_tree=null;
		Object string_literal28_tree=null;
		Object string_literal30_tree=null;
		Object string_literal31_tree=null;
		Object string_literal33_tree=null;
		Object string_literal35_tree=null;
		Object string_literal36_tree=null;
		Object string_literal38_tree=null;
		Object string_literal40_tree=null;
		Object string_literal41_tree=null;
		Object string_literal43_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_56=new RewriteRuleTokenStream(adaptor,"token 56");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_58=new RewriteRuleTokenStream(adaptor,"token 58");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleTokenStream stream_53=new RewriteRuleTokenStream(adaptor,"token 53");
		RewriteRuleTokenStream stream_54=new RewriteRuleTokenStream(adaptor,"token 54");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try { dbg.enterRule(getGrammarFileName(), "command");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(54, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:55:5: ( 'if' expression 'then' commands ( 'else' commands )? 'fi' -> ^( IF expression commands ( ^( ELSE commands ) )? ) | 'while' expression 'do' commands 'od' -> ^( WHILE expression commands ) | 'for' expression 'do' commands 'od' -> ^( FOR expression commands ) | 'nop' -> ^( NOP ) | vars ':=' expression -> ^( ASSIGN vars expression ) )
			int alt7=5;
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			switch ( input.LA(1) ) {
			case 50:
				{
				alt7=1;
				}
				break;
			case 58:
				{
				alt7=2;
				}
				break;
			case 47:
				{
				alt7=3;
				}
				break;
			case 53:
				{
				alt7=4;
				}
				break;
			case Variable:
				{
				alt7=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:55:7: 'if' expression 'then' commands ( 'else' commands )? 'fi'
					{
					dbg.location(55,7);
					string_literal24=(Token)match(input,50,FOLLOW_50_in_command324);  
					stream_50.add(string_literal24);
					dbg.location(55,12);
					pushFollow(FOLLOW_expression_in_command326);
					expression25=expression();
					state._fsp--;

					stream_expression.add(expression25.getTree());dbg.location(55,23);
					string_literal26=(Token)match(input,56,FOLLOW_56_in_command328);  
					stream_56.add(string_literal26);
					dbg.location(55,30);
					pushFollow(FOLLOW_commands_in_command330);
					commands27=commands();
					state._fsp--;

					stream_commands.add(commands27.getTree());dbg.location(55,39);
					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:55:39: ( 'else' commands )?
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==45) ) {
						alt6=1;
					}
					} finally {dbg.exitDecision(6);}

					switch (alt6) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:55:40: 'else' commands
							{
							dbg.location(55,40);
							string_literal28=(Token)match(input,45,FOLLOW_45_in_command333);  
							stream_45.add(string_literal28);
							dbg.location(55,47);
							pushFollow(FOLLOW_commands_in_command335);
							commands29=commands();
							state._fsp--;

							stream_commands.add(commands29.getTree());
							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(55,58);
					string_literal30=(Token)match(input,46,FOLLOW_46_in_command339);  
					stream_46.add(string_literal30);

					// AST REWRITE
					// elements: commands, commands, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 56:7: -> ^( IF expression commands ( ^( ELSE commands ) )? )
					{
						dbg.location(56,10);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:56:10: ^( IF expression commands ( ^( ELSE commands ) )? )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(56,12);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						dbg.location(56,15);
						adaptor.addChild(root_1, stream_expression.nextTree());dbg.location(56,26);
						adaptor.addChild(root_1, stream_commands.nextTree());dbg.location(56,35);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:56:35: ( ^( ELSE commands ) )?
						if ( stream_commands.hasNext() ) {
							dbg.location(56,35);
							// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:56:35: ^( ELSE commands )
							{
							Object root_2 = (Object)adaptor.nil();
							dbg.location(56,37);
							root_2 = (Object)adaptor.becomeRoot((Object)adaptor.create(ELSE, "ELSE"), root_2);
							dbg.location(56,42);
							adaptor.addChild(root_2, stream_commands.nextTree());
							adaptor.addChild(root_1, root_2);
							}

						}
						stream_commands.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:57:7: 'while' expression 'do' commands 'od'
					{
					dbg.location(57,7);
					string_literal31=(Token)match(input,58,FOLLOW_58_in_command370);  
					stream_58.add(string_literal31);
					dbg.location(57,15);
					pushFollow(FOLLOW_expression_in_command372);
					expression32=expression();
					state._fsp--;

					stream_expression.add(expression32.getTree());dbg.location(57,26);
					string_literal33=(Token)match(input,44,FOLLOW_44_in_command374);  
					stream_44.add(string_literal33);
					dbg.location(57,31);
					pushFollow(FOLLOW_commands_in_command376);
					commands34=commands();
					state._fsp--;

					stream_commands.add(commands34.getTree());dbg.location(57,40);
					string_literal35=(Token)match(input,54,FOLLOW_54_in_command378);  
					stream_54.add(string_literal35);

					// AST REWRITE
					// elements: commands, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 58:7: -> ^( WHILE expression commands )
					{
						dbg.location(58,10);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:58:10: ^( WHILE expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(58,12);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
						dbg.location(58,18);
						adaptor.addChild(root_1, stream_expression.nextTree());dbg.location(58,29);
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:59:7: 'for' expression 'do' commands 'od'
					{
					dbg.location(59,7);
					string_literal36=(Token)match(input,47,FOLLOW_47_in_command402);  
					stream_47.add(string_literal36);
					dbg.location(59,13);
					pushFollow(FOLLOW_expression_in_command404);
					expression37=expression();
					state._fsp--;

					stream_expression.add(expression37.getTree());dbg.location(59,24);
					string_literal38=(Token)match(input,44,FOLLOW_44_in_command406);  
					stream_44.add(string_literal38);
					dbg.location(59,29);
					pushFollow(FOLLOW_commands_in_command408);
					commands39=commands();
					state._fsp--;

					stream_commands.add(commands39.getTree());dbg.location(59,38);
					string_literal40=(Token)match(input,54,FOLLOW_54_in_command410);  
					stream_54.add(string_literal40);

					// AST REWRITE
					// elements: expression, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 60:7: -> ^( FOR expression commands )
					{
						dbg.location(60,10);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:60:10: ^( FOR expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(60,12);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
						dbg.location(60,16);
						adaptor.addChild(root_1, stream_expression.nextTree());dbg.location(60,27);
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:61:7: 'nop'
					{
					dbg.location(61,7);
					string_literal41=(Token)match(input,53,FOLLOW_53_in_command434);  
					stream_53.add(string_literal41);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 62:7: -> ^( NOP )
					{
						dbg.location(62,10);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:62:10: ^( NOP )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(62,12);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NOP, "NOP"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:63:7: vars ':=' expression
					{
					dbg.location(63,7);
					pushFollow(FOLLOW_vars_in_command454);
					vars42=vars();
					state._fsp--;

					stream_vars.add(vars42.getTree());dbg.location(63,12);
					string_literal43=(Token)match(input,40,FOLLOW_40_in_command456);  
					stream_40.add(string_literal43);
					dbg.location(63,17);
					pushFollow(FOLLOW_expression_in_command458);
					expression44=expression();
					state._fsp--;

					stream_expression.add(expression44.getTree());
					// AST REWRITE
					// elements: vars, expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 64:7: -> ^( ASSIGN vars expression )
					{
						dbg.location(64,10);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:64:10: ^( ASSIGN vars expression )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(64,12);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ASSIGN, "ASSIGN"), root_1);
						dbg.location(64,19);
						adaptor.addChild(root_1, stream_vars.nextTree());dbg.location(64,24);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(65, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "command");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "command"


	public static class vars_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vars"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:68:1: vars : Variable ( ',' Variable )* -> ^( VARS ( Variable )+ ) ;
	public final AstParser.vars_return vars() throws RecognitionException {
		AstParser.vars_return retval = new AstParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable45=null;
		Token char_literal46=null;
		Token Variable47=null;

		Object Variable45_tree=null;
		Object char_literal46_tree=null;
		Object Variable47_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");

		try { dbg.enterRule(getGrammarFileName(), "vars");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(68, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:68:6: ( Variable ( ',' Variable )* -> ^( VARS ( Variable )+ ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:68:8: Variable ( ',' Variable )*
			{
			dbg.location(68,8);
			Variable45=(Token)match(input,Variable,FOLLOW_Variable_in_vars488);  
			stream_Variable.add(Variable45);
			dbg.location(68,17);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:68:17: ( ',' Variable )*
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==38) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:68:18: ',' Variable
					{
					dbg.location(68,18);
					char_literal46=(Token)match(input,38,FOLLOW_38_in_vars491);  
					stream_38.add(char_literal46);
					dbg.location(68,22);
					Variable47=(Token)match(input,Variable,FOLLOW_Variable_in_vars493);  
					stream_Variable.add(Variable47);

					}
					break;

				default :
					break loop8;
				}
			}
			} finally {dbg.exitSubRule(8);}

			// AST REWRITE
			// elements: Variable
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 68:33: -> ^( VARS ( Variable )+ )
			{
				dbg.location(68,36);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:68:36: ^( VARS ( Variable )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(68,38);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARS, "VARS"), root_1);
				dbg.location(68,43);
				if ( !(stream_Variable.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Variable.hasNext() ) {
					dbg.location(68,43);
					adaptor.addChild(root_1, stream_Variable.nextNode());
				}
				stream_Variable.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(68, 52);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "vars");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "vars"


	public static class exprs_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprs"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:71:1: exprs : expression ( ',' expression )* -> ^( EXPRS ( expression )+ ) ;
	public final AstParser.exprs_return exprs() throws RecognitionException {
		AstParser.exprs_return retval = new AstParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal49=null;
		ParserRuleReturnScope expression48 =null;
		ParserRuleReturnScope expression50 =null;

		Object char_literal49_tree=null;
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try { dbg.enterRule(getGrammarFileName(), "exprs");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(71, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:71:7: ( expression ( ',' expression )* -> ^( EXPRS ( expression )+ ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:71:9: expression ( ',' expression )*
			{
			dbg.location(71,9);
			pushFollow(FOLLOW_expression_in_exprs513);
			expression48=expression();
			state._fsp--;

			stream_expression.add(expression48.getTree());dbg.location(71,20);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:71:20: ( ',' expression )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( (LA9_0==38) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:71:21: ',' expression
					{
					dbg.location(71,21);
					char_literal49=(Token)match(input,38,FOLLOW_38_in_exprs516);  
					stream_38.add(char_literal49);
					dbg.location(71,25);
					pushFollow(FOLLOW_expression_in_exprs518);
					expression50=expression();
					state._fsp--;

					stream_expression.add(expression50.getTree());
					}
					break;

				default :
					break loop9;
				}
			}
			} finally {dbg.exitSubRule(9);}

			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 71:38: -> ^( EXPRS ( expression )+ )
			{
				dbg.location(71,41);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:71:41: ^( EXPRS ( expression )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(71,43);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRS, "EXPRS"), root_1);
				dbg.location(71,49);
				if ( !(stream_expression.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expression.hasNext() ) {
					dbg.location(71,49);
					adaptor.addChild(root_1, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(71, 60);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exprs");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "exprs"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:74:1: expression : exprBase ( '=?' exprBase )? -> ^( EXPRESSION exprBase ( '=?' exprBase )? ) ;
	public final AstParser.expression_return expression() throws RecognitionException {
		AstParser.expression_return retval = new AstParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal52=null;
		ParserRuleReturnScope exprBase51 =null;
		ParserRuleReturnScope exprBase53 =null;

		Object string_literal52_tree=null;
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try { dbg.enterRule(getGrammarFileName(), "expression");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(74, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:74:12: ( exprBase ( '=?' exprBase )? -> ^( EXPRESSION exprBase ( '=?' exprBase )? ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:74:14: exprBase ( '=?' exprBase )?
			{
			dbg.location(74,14);
			pushFollow(FOLLOW_exprBase_in_expression538);
			exprBase51=exprBase();
			state._fsp--;

			stream_exprBase.add(exprBase51.getTree());dbg.location(74,23);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:74:23: ( '=?' exprBase )?
			int alt10=2;
			try { dbg.enterSubRule(10);
			try { dbg.enterDecision(10, decisionCanBacktrack[10]);

			int LA10_0 = input.LA(1);
			if ( (LA10_0==42) ) {
				alt10=1;
			}
			} finally {dbg.exitDecision(10);}

			switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:74:24: '=?' exprBase
					{
					dbg.location(74,24);
					string_literal52=(Token)match(input,42,FOLLOW_42_in_expression541);  
					stream_42.add(string_literal52);
					dbg.location(74,29);
					pushFollow(FOLLOW_exprBase_in_expression543);
					exprBase53=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase53.getTree());
					}
					break;

			}
			} finally {dbg.exitSubRule(10);}

			// AST REWRITE
			// elements: exprBase, exprBase, 42
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 75:12: -> ^( EXPRESSION exprBase ( '=?' exprBase )? )
			{
				dbg.location(75,15);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:75:15: ^( EXPRESSION exprBase ( '=?' exprBase )? )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(75,17);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRESSION, "EXPRESSION"), root_1);
				dbg.location(75,28);
				adaptor.addChild(root_1, stream_exprBase.nextTree());dbg.location(75,37);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:75:37: ( '=?' exprBase )?
				if ( stream_exprBase.hasNext()||stream_42.hasNext() ) {
					dbg.location(75,38);
					adaptor.addChild(root_1, stream_42.nextNode());dbg.location(75,43);
					adaptor.addChild(root_1, stream_exprBase.nextTree());
				}
				stream_exprBase.reset();
				stream_42.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(75, 53);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expression");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "expression"


	public static class exprBase_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprBase"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:78:1: exprBase : ( '(' 'cons' lExpr ')' -> ^( CONS lExpr ) | '(' 'list' lExpr ')' -> ^( LIST lExpr ) | '(' 'hd' exprBase ')' -> ^( HD exprBase ) | '(' 'tl' exprBase ')' -> ^( TL exprBase ) | '(' Symbol lExpr ')' -> ^( CALL Symbol lExpr ) | 'nil' -> ^( NIL ) | Variable -> ^( VAR Variable ) | Symbol -> ^( SYM Symbol ) );
	public final AstParser.exprBase_return exprBase() throws RecognitionException {
		AstParser.exprBase_return retval = new AstParser.exprBase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal54=null;
		Token string_literal55=null;
		Token char_literal57=null;
		Token char_literal58=null;
		Token string_literal59=null;
		Token char_literal61=null;
		Token char_literal62=null;
		Token string_literal63=null;
		Token char_literal65=null;
		Token char_literal66=null;
		Token string_literal67=null;
		Token char_literal69=null;
		Token char_literal70=null;
		Token Symbol71=null;
		Token char_literal73=null;
		Token string_literal74=null;
		Token Variable75=null;
		Token Symbol76=null;
		ParserRuleReturnScope lExpr56 =null;
		ParserRuleReturnScope lExpr60 =null;
		ParserRuleReturnScope exprBase64 =null;
		ParserRuleReturnScope exprBase68 =null;
		ParserRuleReturnScope lExpr72 =null;

		Object char_literal54_tree=null;
		Object string_literal55_tree=null;
		Object char_literal57_tree=null;
		Object char_literal58_tree=null;
		Object string_literal59_tree=null;
		Object char_literal61_tree=null;
		Object char_literal62_tree=null;
		Object string_literal63_tree=null;
		Object char_literal65_tree=null;
		Object char_literal66_tree=null;
		Object string_literal67_tree=null;
		Object char_literal69_tree=null;
		Object char_literal70_tree=null;
		Object Symbol71_tree=null;
		Object char_literal73_tree=null;
		Object string_literal74_tree=null;
		Object Variable75_tree=null;
		Object Symbol76_tree=null;
		RewriteRuleTokenStream stream_57=new RewriteRuleTokenStream(adaptor,"token 57");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");
		RewriteRuleSubtreeStream stream_lExpr=new RewriteRuleSubtreeStream(adaptor,"rule lExpr");

		try { dbg.enterRule(getGrammarFileName(), "exprBase");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(78, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:79:5: ( '(' 'cons' lExpr ')' -> ^( CONS lExpr ) | '(' 'list' lExpr ')' -> ^( LIST lExpr ) | '(' 'hd' exprBase ')' -> ^( HD exprBase ) | '(' 'tl' exprBase ')' -> ^( TL exprBase ) | '(' Symbol lExpr ')' -> ^( CALL Symbol lExpr ) | 'nil' -> ^( NIL ) | Variable -> ^( VAR Variable ) | Symbol -> ^( SYM Symbol ) )
			int alt11=8;
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			switch ( input.LA(1) ) {
			case 36:
				{
				switch ( input.LA(2) ) {
				case 43:
					{
					alt11=1;
					}
					break;
				case 51:
					{
					alt11=2;
					}
					break;
				case 49:
					{
					alt11=3;
					}
					break;
				case 57:
					{
					alt11=4;
					}
					break;
				case Symbol:
					{
					alt11=5;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 1, input);
						dbg.recognitionException(nvae);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case 52:
				{
				alt11=6;
				}
				break;
			case Variable:
				{
				alt11=7;
				}
				break;
			case Symbol:
				{
				alt11=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(11);}

			switch (alt11) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:79:7: '(' 'cons' lExpr ')'
					{
					dbg.location(79,7);
					char_literal54=(Token)match(input,36,FOLLOW_36_in_exprBase585);  
					stream_36.add(char_literal54);
					dbg.location(79,11);
					string_literal55=(Token)match(input,43,FOLLOW_43_in_exprBase587);  
					stream_43.add(string_literal55);
					dbg.location(79,18);
					pushFollow(FOLLOW_lExpr_in_exprBase589);
					lExpr56=lExpr();
					state._fsp--;

					stream_lExpr.add(lExpr56.getTree());dbg.location(79,24);
					char_literal57=(Token)match(input,37,FOLLOW_37_in_exprBase591);  
					stream_37.add(char_literal57);

					// AST REWRITE
					// elements: lExpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 79:28: -> ^( CONS lExpr )
					{
						dbg.location(79,31);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:79:31: ^( CONS lExpr )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(79,33);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONS, "CONS"), root_1);
						dbg.location(79,38);
						adaptor.addChild(root_1, stream_lExpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:80:7: '(' 'list' lExpr ')'
					{
					dbg.location(80,7);
					char_literal58=(Token)match(input,36,FOLLOW_36_in_exprBase607);  
					stream_36.add(char_literal58);
					dbg.location(80,11);
					string_literal59=(Token)match(input,51,FOLLOW_51_in_exprBase609);  
					stream_51.add(string_literal59);
					dbg.location(80,18);
					pushFollow(FOLLOW_lExpr_in_exprBase611);
					lExpr60=lExpr();
					state._fsp--;

					stream_lExpr.add(lExpr60.getTree());dbg.location(80,24);
					char_literal61=(Token)match(input,37,FOLLOW_37_in_exprBase613);  
					stream_37.add(char_literal61);

					// AST REWRITE
					// elements: lExpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 80:28: -> ^( LIST lExpr )
					{
						dbg.location(80,31);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:80:31: ^( LIST lExpr )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(80,33);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST, "LIST"), root_1);
						dbg.location(80,38);
						adaptor.addChild(root_1, stream_lExpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:81:7: '(' 'hd' exprBase ')'
					{
					dbg.location(81,7);
					char_literal62=(Token)match(input,36,FOLLOW_36_in_exprBase629);  
					stream_36.add(char_literal62);
					dbg.location(81,11);
					string_literal63=(Token)match(input,49,FOLLOW_49_in_exprBase631);  
					stream_49.add(string_literal63);
					dbg.location(81,16);
					pushFollow(FOLLOW_exprBase_in_exprBase633);
					exprBase64=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase64.getTree());dbg.location(81,25);
					char_literal65=(Token)match(input,37,FOLLOW_37_in_exprBase635);  
					stream_37.add(char_literal65);

					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 81:29: -> ^( HD exprBase )
					{
						dbg.location(81,32);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:81:32: ^( HD exprBase )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(81,34);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HD, "HD"), root_1);
						dbg.location(81,37);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:82:7: '(' 'tl' exprBase ')'
					{
					dbg.location(82,7);
					char_literal66=(Token)match(input,36,FOLLOW_36_in_exprBase651);  
					stream_36.add(char_literal66);
					dbg.location(82,11);
					string_literal67=(Token)match(input,57,FOLLOW_57_in_exprBase653);  
					stream_57.add(string_literal67);
					dbg.location(82,16);
					pushFollow(FOLLOW_exprBase_in_exprBase655);
					exprBase68=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase68.getTree());dbg.location(82,25);
					char_literal69=(Token)match(input,37,FOLLOW_37_in_exprBase657);  
					stream_37.add(char_literal69);

					// AST REWRITE
					// elements: exprBase
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 82:29: -> ^( TL exprBase )
					{
						dbg.location(82,32);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:82:32: ^( TL exprBase )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(82,34);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TL, "TL"), root_1);
						dbg.location(82,37);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:83:7: '(' Symbol lExpr ')'
					{
					dbg.location(83,7);
					char_literal70=(Token)match(input,36,FOLLOW_36_in_exprBase673);  
					stream_36.add(char_literal70);
					dbg.location(83,11);
					Symbol71=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprBase675);  
					stream_Symbol.add(Symbol71);
					dbg.location(83,18);
					pushFollow(FOLLOW_lExpr_in_exprBase677);
					lExpr72=lExpr();
					state._fsp--;

					stream_lExpr.add(lExpr72.getTree());dbg.location(83,24);
					char_literal73=(Token)match(input,37,FOLLOW_37_in_exprBase679);  
					stream_37.add(char_literal73);

					// AST REWRITE
					// elements: lExpr, Symbol
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 83:28: -> ^( CALL Symbol lExpr )
					{
						dbg.location(83,31);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:83:31: ^( CALL Symbol lExpr )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(83,33);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CALL, "CALL"), root_1);
						dbg.location(83,38);
						adaptor.addChild(root_1, stream_Symbol.nextNode());dbg.location(83,45);
						adaptor.addChild(root_1, stream_lExpr.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:84:7: 'nil'
					{
					dbg.location(84,7);
					string_literal74=(Token)match(input,52,FOLLOW_52_in_exprBase697);  
					stream_52.add(string_literal74);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 84:13: -> ^( NIL )
					{
						dbg.location(84,16);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:84:16: ^( NIL )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(84,18);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(NIL, "NIL"), root_1);
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:85:7: Variable
					{
					dbg.location(85,7);
					Variable75=(Token)match(input,Variable,FOLLOW_Variable_in_exprBase711);  
					stream_Variable.add(Variable75);

					// AST REWRITE
					// elements: Variable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 85:16: -> ^( VAR Variable )
					{
						dbg.location(85,19);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:85:19: ^( VAR Variable )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(85,21);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VAR, "VAR"), root_1);
						dbg.location(85,25);
						adaptor.addChild(root_1, stream_Variable.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:86:7: Symbol
					{
					dbg.location(86,7);
					Symbol76=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprBase727);  
					stream_Symbol.add(Symbol76);

					// AST REWRITE
					// elements: Symbol
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 86:14: -> ^( SYM Symbol )
					{
						dbg.location(86,17);
						// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:86:17: ^( SYM Symbol )
						{
						Object root_1 = (Object)adaptor.nil();
						dbg.location(86,19);
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SYM, "SYM"), root_1);
						dbg.location(86,23);
						adaptor.addChild(root_1, stream_Symbol.nextNode());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(87, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exprBase");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "exprBase"


	public static class lExpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lExpr"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:90:1: lExpr : ( exprBase )+ -> ^( LEXPR ( exprBase )+ ) ;
	public final AstParser.lExpr_return lExpr() throws RecognitionException {
		AstParser.lExpr_return retval = new AstParser.lExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprBase77 =null;

		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try { dbg.enterRule(getGrammarFileName(), "lExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(90, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:90:7: ( ( exprBase )+ -> ^( LEXPR ( exprBase )+ ) )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:90:9: ( exprBase )+
			{
			dbg.location(90,9);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:90:9: ( exprBase )+
			int cnt12=0;
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( (LA12_0==Symbol||LA12_0==Variable||LA12_0==36||LA12_0==52) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:90:9: exprBase
					{
					dbg.location(90,9);
					pushFollow(FOLLOW_exprBase_in_lExpr749);
					exprBase77=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase77.getTree());
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt12++;
			}
			} finally {dbg.exitSubRule(12);}

			// AST REWRITE
			// elements: exprBase
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 90:19: -> ^( LEXPR ( exprBase )+ )
			{
				dbg.location(90,22);
				// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\AstJava\\src\\Ast.g:90:22: ^( LEXPR ( exprBase )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				dbg.location(90,24);
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LEXPR, "LEXPR"), root_1);
				dbg.location(90,30);
				if ( !(stream_exprBase.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_exprBase.hasNext() ) {
					dbg.location(90,30);
					adaptor.addChild(root_1, stream_exprBase.nextTree());
				}
				stream_exprBase.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(90, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "lExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "lExpr"

	// Delegated rules



	public static final BitSet FOLLOW_function_in_program139 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_EOF_in_program142 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_function159 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Symbol_in_function161 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_39_in_function163 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_definition_in_function165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_55_in_definition183 = new BitSet(new long[]{0x0000000900000000L});
	public static final BitSet FOLLOW_input_in_definition185 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_definition187 = new BitSet(new long[]{0x0424800100000000L});
	public static final BitSet FOLLOW_commands_in_definition189 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_definition191 = new BitSet(new long[]{0x0800000000000000L});
	public static final BitSet FOLLOW_59_in_definition193 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_output_in_definition195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub246 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_38_in_inputSub249 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_Variable_in_inputSub251 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_Variable_in_output271 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_38_in_output274 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_Variable_in_output276 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_command_in_commands296 = new BitSet(new long[]{0x0000020000000002L});
	public static final BitSet FOLLOW_41_in_commands299 = new BitSet(new long[]{0x0424800100000000L});
	public static final BitSet FOLLOW_commands_in_commands301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_50_in_command324 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_expression_in_command326 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_56_in_command328 = new BitSet(new long[]{0x0424800100000000L});
	public static final BitSet FOLLOW_commands_in_command330 = new BitSet(new long[]{0x0000600000000000L});
	public static final BitSet FOLLOW_45_in_command333 = new BitSet(new long[]{0x0424800100000000L});
	public static final BitSet FOLLOW_commands_in_command335 = new BitSet(new long[]{0x0000400000000000L});
	public static final BitSet FOLLOW_46_in_command339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_58_in_command370 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_expression_in_command372 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_command374 = new BitSet(new long[]{0x0424800100000000L});
	public static final BitSet FOLLOW_commands_in_command376 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command378 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_47_in_command402 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_expression_in_command404 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_command406 = new BitSet(new long[]{0x0424800100000000L});
	public static final BitSet FOLLOW_commands_in_command408 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_54_in_command410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_53_in_command434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command454 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_40_in_command456 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_expression_in_command458 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars488 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_38_in_vars491 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_Variable_in_vars493 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_expression_in_exprs513 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_38_in_exprs516 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_expression_in_exprs518 = new BitSet(new long[]{0x0000004000000002L});
	public static final BitSet FOLLOW_exprBase_in_expression538 = new BitSet(new long[]{0x0000040000000002L});
	public static final BitSet FOLLOW_42_in_expression541 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_exprBase_in_expression543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_exprBase585 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_exprBase587 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_lExpr_in_exprBase589 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprBase591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_exprBase607 = new BitSet(new long[]{0x0008000000000000L});
	public static final BitSet FOLLOW_51_in_exprBase609 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_lExpr_in_exprBase611 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprBase613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_exprBase629 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_exprBase631 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase633 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprBase635 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_exprBase651 = new BitSet(new long[]{0x0200000000000000L});
	public static final BitSet FOLLOW_57_in_exprBase653 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase655 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprBase657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_36_in_exprBase673 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Symbol_in_exprBase675 = new BitSet(new long[]{0x0010001108000000L});
	public static final BitSet FOLLOW_lExpr_in_exprBase677 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_exprBase679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_52_in_exprBase697 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_exprBase711 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Symbol_in_exprBase727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprBase_in_lExpr749 = new BitSet(new long[]{0x0010001108000002L});
}
