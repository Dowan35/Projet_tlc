// $ANTLR 3.5.1 C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g 2024-12-02 08:36:09

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class WhileParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Symbol", "Variable", "WS", "'%'", 
		"'('", "')'", "','", "':'", "':='", "';'", "'=?'", "'cons'", "'do'", "'else'", 
		"'fi'", "'for'", "'function'", "'hd'", "'if'", "'list'", "'nil'", "'nop'", 
		"'od'", "'read'", "'then'", "'tl'", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int Symbol=4;
	public static final int Variable=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "program", "command", "inputSub", "function", "lExpr", 
		"definition", "exprBase", "exprs", "vars", "commands", "input", "output", 
		"expression"
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
	public WhileParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public WhileParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this, port, null);

		setDebugListener(proxy);
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
	}

	public WhileParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return WhileParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g"; }



	// $ANTLR start "program"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:4:1: program : ( function )+ EOF ;
	public final void program() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "program");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(4, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:4:9: ( ( function )+ EOF )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:4:11: ( function )+ EOF
			{
			dbg.location(4,11);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:4:11: ( function )+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( (LA1_0==20) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:4:11: function
					{
					dbg.location(4,11);
					pushFollow(FOLLOW_function_in_program11);
					function();
					state._fsp--;

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
			dbg.location(4,21);
			match(input,EOF,FOLLOW_EOF_in_program14); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(4, 24);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "program");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "program"



	// $ANTLR start "function"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:6:1: function : 'function' Symbol ':' definition ;
	public final void function() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "function");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(6, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:6:10: ( 'function' Symbol ':' definition )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:6:12: 'function' Symbol ':' definition
			{
			dbg.location(6,12);
			match(input,20,FOLLOW_20_in_function23); dbg.location(6,23);
			match(input,Symbol,FOLLOW_Symbol_in_function25); dbg.location(6,30);
			match(input,11,FOLLOW_11_in_function27); dbg.location(6,34);
			pushFollow(FOLLOW_definition_in_function29);
			definition();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(6, 43);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "function");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "function"



	// $ANTLR start "definition"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:8:1: definition : 'read' input '%' commands '%' 'write' output ;
	public final void definition() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "definition");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(8, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:8:12: ( 'read' input '%' commands '%' 'write' output )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:8:14: 'read' input '%' commands '%' 'write' output
			{
			dbg.location(8,14);
			match(input,27,FOLLOW_27_in_definition37); dbg.location(8,21);
			pushFollow(FOLLOW_input_in_definition39);
			input();
			state._fsp--;
			dbg.location(8,27);
			match(input,7,FOLLOW_7_in_definition41); dbg.location(8,31);
			pushFollow(FOLLOW_commands_in_definition43);
			commands();
			state._fsp--;
			dbg.location(8,40);
			match(input,7,FOLLOW_7_in_definition45); dbg.location(8,44);
			match(input,31,FOLLOW_31_in_definition47); dbg.location(8,52);
			pushFollow(FOLLOW_output_in_definition49);
			output();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(8, 57);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "definition");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "definition"



	// $ANTLR start "input"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:11:1: input : inputSub ;
	public final void input() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "input");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(11, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:11:8: ( inputSub )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:11:10: inputSub
			{
			dbg.location(11,10);
			pushFollow(FOLLOW_inputSub_in_input59);
			inputSub();
			state._fsp--;

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(11, 17);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "input");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "input"



	// $ANTLR start "inputSub"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:12:1: inputSub : ( Variable )? ( ',' Variable )* ;
	public final void inputSub() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "inputSub");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(12, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:12:10: ( ( Variable )? ( ',' Variable )* )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:12:12: ( Variable )? ( ',' Variable )*
			{
			dbg.location(12,12);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:12:12: ( Variable )?
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

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:12:12: Variable
					{
					dbg.location(12,12);
					match(input,Variable,FOLLOW_Variable_in_inputSub66); 
					}
					break;

			}
			} finally {dbg.exitSubRule(2);}
			dbg.location(12,22);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:12:22: ( ',' Variable )*
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=2;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==10) ) {
					alt3=1;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:12:23: ',' Variable
					{
					dbg.location(12,23);
					match(input,10,FOLLOW_10_in_inputSub70); dbg.location(12,27);
					match(input,Variable,FOLLOW_Variable_in_inputSub72); 
					}
					break;

				default :
					break loop3;
				}
			}
			} finally {dbg.exitSubRule(3);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(12, 36);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "inputSub");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "inputSub"



	// $ANTLR start "output"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:15:1: output : Variable ( ',' Variable )* ;
	public final void output() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "output");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(15, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:15:9: ( Variable ( ',' Variable )* )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:15:11: Variable ( ',' Variable )*
			{
			dbg.location(15,11);
			match(input,Variable,FOLLOW_Variable_in_output84); dbg.location(15,20);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:15:20: ( ',' Variable )*
			try { dbg.enterSubRule(4);

			loop4:
			while (true) {
				int alt4=2;
				try { dbg.enterDecision(4, decisionCanBacktrack[4]);

				int LA4_0 = input.LA(1);
				if ( (LA4_0==10) ) {
					alt4=1;
				}

				} finally {dbg.exitDecision(4);}

				switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:15:21: ',' Variable
					{
					dbg.location(15,21);
					match(input,10,FOLLOW_10_in_output87); dbg.location(15,25);
					match(input,Variable,FOLLOW_Variable_in_output89); 
					}
					break;

				default :
					break loop4;
				}
			}
			} finally {dbg.exitSubRule(4);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(15, 34);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "output");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "output"



	// $ANTLR start "commands"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:18:1: commands : command ( ';' commands )? ;
	public final void commands() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "commands");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(18, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:18:10: ( command ( ';' commands )? )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:18:12: command ( ';' commands )?
			{
			dbg.location(18,12);
			pushFollow(FOLLOW_command_in_commands100);
			command();
			state._fsp--;
			dbg.location(18,20);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:18:20: ( ';' commands )?
			int alt5=2;
			try { dbg.enterSubRule(5);
			try { dbg.enterDecision(5, decisionCanBacktrack[5]);

			int LA5_0 = input.LA(1);
			if ( (LA5_0==13) ) {
				alt5=1;
			}
			} finally {dbg.exitDecision(5);}

			switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:18:21: ';' commands
					{
					dbg.location(18,21);
					match(input,13,FOLLOW_13_in_commands103); dbg.location(18,25);
					pushFollow(FOLLOW_commands_in_commands105);
					commands();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(5);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(18, 35);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "commands");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "commands"



	// $ANTLR start "command"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:20:1: command : ( 'if' expression 'then' commands ( 'else' commands )? 'fi' | 'while' expression 'do' commands 'od' | 'for' expression 'do' commands 'od' | 'nop' | vars ':=' expression );
	public final void command() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "command");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(20, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:21:5: ( 'if' expression 'then' commands ( 'else' commands )? 'fi' | 'while' expression 'do' commands 'od' | 'for' expression 'do' commands 'od' | 'nop' | vars ':=' expression )
			int alt7=5;
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			switch ( input.LA(1) ) {
			case 22:
				{
				alt7=1;
				}
				break;
			case 30:
				{
				alt7=2;
				}
				break;
			case 19:
				{
				alt7=3;
				}
				break;
			case 25:
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

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:21:7: 'if' expression 'then' commands ( 'else' commands )? 'fi'
					{
					dbg.location(21,7);
					match(input,22,FOLLOW_22_in_command120); dbg.location(21,12);
					pushFollow(FOLLOW_expression_in_command122);
					expression();
					state._fsp--;
					dbg.location(21,23);
					match(input,28,FOLLOW_28_in_command124); dbg.location(21,30);
					pushFollow(FOLLOW_commands_in_command126);
					commands();
					state._fsp--;
					dbg.location(21,39);
					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:21:39: ( 'else' commands )?
					int alt6=2;
					try { dbg.enterSubRule(6);
					try { dbg.enterDecision(6, decisionCanBacktrack[6]);

					int LA6_0 = input.LA(1);
					if ( (LA6_0==17) ) {
						alt6=1;
					}
					} finally {dbg.exitDecision(6);}

					switch (alt6) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:21:40: 'else' commands
							{
							dbg.location(21,40);
							match(input,17,FOLLOW_17_in_command129); dbg.location(21,47);
							pushFollow(FOLLOW_commands_in_command131);
							commands();
							state._fsp--;

							}
							break;

					}
					} finally {dbg.exitSubRule(6);}
					dbg.location(21,58);
					match(input,18,FOLLOW_18_in_command135); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:22:7: 'while' expression 'do' commands 'od'
					{
					dbg.location(22,7);
					match(input,30,FOLLOW_30_in_command148); dbg.location(22,15);
					pushFollow(FOLLOW_expression_in_command150);
					expression();
					state._fsp--;
					dbg.location(22,26);
					match(input,16,FOLLOW_16_in_command152); dbg.location(22,31);
					pushFollow(FOLLOW_commands_in_command154);
					commands();
					state._fsp--;
					dbg.location(22,40);
					match(input,26,FOLLOW_26_in_command156); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:23:7: 'for' expression 'do' commands 'od'
					{
					dbg.location(23,7);
					match(input,19,FOLLOW_19_in_command188); dbg.location(23,13);
					pushFollow(FOLLOW_expression_in_command190);
					expression();
					state._fsp--;
					dbg.location(23,24);
					match(input,16,FOLLOW_16_in_command192); dbg.location(23,29);
					pushFollow(FOLLOW_commands_in_command194);
					commands();
					state._fsp--;
					dbg.location(23,38);
					match(input,26,FOLLOW_26_in_command196); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:24:7: 'nop'
					{
					dbg.location(24,7);
					match(input,25,FOLLOW_25_in_command231); 
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:25:7: vars ':=' expression
					{
					dbg.location(25,7);
					pushFollow(FOLLOW_vars_in_command297);
					vars();
					state._fsp--;
					dbg.location(25,12);
					match(input,12,FOLLOW_12_in_command299); dbg.location(25,17);
					pushFollow(FOLLOW_expression_in_command301);
					expression();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(26, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "command");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "command"



	// $ANTLR start "vars"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:29:1: vars : Variable ( ',' Variable )* ;
	public final void vars() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "vars");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(29, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:29:6: ( Variable ( ',' Variable )* )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:29:8: Variable ( ',' Variable )*
			{
			dbg.location(29,8);
			match(input,Variable,FOLLOW_Variable_in_vars358); dbg.location(29,17);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:29:17: ( ',' Variable )*
			try { dbg.enterSubRule(8);

			loop8:
			while (true) {
				int alt8=2;
				try { dbg.enterDecision(8, decisionCanBacktrack[8]);

				int LA8_0 = input.LA(1);
				if ( (LA8_0==10) ) {
					alt8=1;
				}

				} finally {dbg.exitDecision(8);}

				switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:29:18: ',' Variable
					{
					dbg.location(29,18);
					match(input,10,FOLLOW_10_in_vars361); dbg.location(29,22);
					match(input,Variable,FOLLOW_Variable_in_vars363); 
					}
					break;

				default :
					break loop8;
				}
			}
			} finally {dbg.exitSubRule(8);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(29, 31);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "vars");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "vars"



	// $ANTLR start "exprs"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:32:1: exprs : expression ( ',' expression )* ;
	public final void exprs() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "exprs");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(32, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:32:7: ( expression ( ',' expression )* )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:32:9: expression ( ',' expression )*
			{
			dbg.location(32,9);
			pushFollow(FOLLOW_expression_in_exprs374);
			expression();
			state._fsp--;
			dbg.location(32,20);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:32:20: ( ',' expression )*
			try { dbg.enterSubRule(9);

			loop9:
			while (true) {
				int alt9=2;
				try { dbg.enterDecision(9, decisionCanBacktrack[9]);

				int LA9_0 = input.LA(1);
				if ( (LA9_0==10) ) {
					alt9=1;
				}

				} finally {dbg.exitDecision(9);}

				switch (alt9) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:32:21: ',' expression
					{
					dbg.location(32,21);
					match(input,10,FOLLOW_10_in_exprs377); dbg.location(32,25);
					pushFollow(FOLLOW_expression_in_exprs379);
					expression();
					state._fsp--;

					}
					break;

				default :
					break loop9;
				}
			}
			} finally {dbg.exitSubRule(9);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(32, 36);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exprs");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "exprs"



	// $ANTLR start "expression"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:35:1: expression : exprBase ( '=?' exprBase )? ;
	public final void expression() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "expression");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(35, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:35:12: ( exprBase ( '=?' exprBase )? )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:35:14: exprBase ( '=?' exprBase )?
			{
			dbg.location(35,14);
			pushFollow(FOLLOW_exprBase_in_expression390);
			exprBase();
			state._fsp--;
			dbg.location(35,23);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:35:23: ( '=?' exprBase )?
			int alt10=2;
			try { dbg.enterSubRule(10);
			try { dbg.enterDecision(10, decisionCanBacktrack[10]);

			int LA10_0 = input.LA(1);
			if ( (LA10_0==14) ) {
				alt10=1;
			}
			} finally {dbg.exitDecision(10);}

			switch (alt10) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:35:24: '=?' exprBase
					{
					dbg.location(35,24);
					match(input,14,FOLLOW_14_in_expression393); dbg.location(35,29);
					pushFollow(FOLLOW_exprBase_in_expression395);
					exprBase();
					state._fsp--;

					}
					break;

			}
			} finally {dbg.exitSubRule(10);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(35, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expression");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "expression"



	// $ANTLR start "exprBase"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:38:1: exprBase : ( '(' 'cons' lExpr ')' | '(' 'list' lExpr ')' | '(' 'hd' exprBase ')' | '(' 'tl' exprBase ')' | '(' Symbol lExpr ')' | 'nil' | Variable | Symbol );
	public final void exprBase() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "exprBase");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(38, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:39:5: ( '(' 'cons' lExpr ')' | '(' 'list' lExpr ')' | '(' 'hd' exprBase ')' | '(' 'tl' exprBase ')' | '(' Symbol lExpr ')' | 'nil' | Variable | Symbol )
			int alt11=8;
			try { dbg.enterDecision(11, decisionCanBacktrack[11]);

			switch ( input.LA(1) ) {
			case 8:
				{
				switch ( input.LA(2) ) {
				case 15:
					{
					alt11=1;
					}
					break;
				case 23:
					{
					alt11=2;
					}
					break;
				case 21:
					{
					alt11=3;
					}
					break;
				case 29:
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
			case 24:
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

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:39:7: '(' 'cons' lExpr ')'
					{
					dbg.location(39,7);
					match(input,8,FOLLOW_8_in_exprBase413); dbg.location(39,11);
					match(input,15,FOLLOW_15_in_exprBase415); dbg.location(39,18);
					pushFollow(FOLLOW_lExpr_in_exprBase417);
					lExpr();
					state._fsp--;
					dbg.location(39,24);
					match(input,9,FOLLOW_9_in_exprBase419); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:40:7: '(' 'list' lExpr ')'
					{
					dbg.location(40,7);
					match(input,8,FOLLOW_8_in_exprBase427); dbg.location(40,11);
					match(input,23,FOLLOW_23_in_exprBase429); dbg.location(40,18);
					pushFollow(FOLLOW_lExpr_in_exprBase431);
					lExpr();
					state._fsp--;
					dbg.location(40,24);
					match(input,9,FOLLOW_9_in_exprBase433); 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:41:7: '(' 'hd' exprBase ')'
					{
					dbg.location(41,7);
					match(input,8,FOLLOW_8_in_exprBase441); dbg.location(41,11);
					match(input,21,FOLLOW_21_in_exprBase443); dbg.location(41,16);
					pushFollow(FOLLOW_exprBase_in_exprBase445);
					exprBase();
					state._fsp--;
					dbg.location(41,25);
					match(input,9,FOLLOW_9_in_exprBase447); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:42:7: '(' 'tl' exprBase ')'
					{
					dbg.location(42,7);
					match(input,8,FOLLOW_8_in_exprBase455); dbg.location(42,11);
					match(input,29,FOLLOW_29_in_exprBase457); dbg.location(42,16);
					pushFollow(FOLLOW_exprBase_in_exprBase459);
					exprBase();
					state._fsp--;
					dbg.location(42,25);
					match(input,9,FOLLOW_9_in_exprBase461); 
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:43:7: '(' Symbol lExpr ')'
					{
					dbg.location(43,7);
					match(input,8,FOLLOW_8_in_exprBase469); dbg.location(43,11);
					match(input,Symbol,FOLLOW_Symbol_in_exprBase471); dbg.location(43,18);
					pushFollow(FOLLOW_lExpr_in_exprBase473);
					lExpr();
					state._fsp--;
					dbg.location(43,24);
					match(input,9,FOLLOW_9_in_exprBase475); 
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:44:7: 'nil'
					{
					dbg.location(44,7);
					match(input,24,FOLLOW_24_in_exprBase483); 
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:45:7: Variable
					{
					dbg.location(45,7);
					match(input,Variable,FOLLOW_Variable_in_exprBase491); 
					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:46:7: Symbol
					{
					dbg.location(46,7);
					match(input,Symbol,FOLLOW_Symbol_in_exprBase499); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(47, 4);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "exprBase");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "exprBase"



	// $ANTLR start "lExpr"
	// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:50:1: lExpr : ( exprBase )+ ;
	public final void lExpr() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "lExpr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(50, 0);

		try {
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:50:7: ( ( exprBase )+ )
			dbg.enterAlt(1);

			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:50:9: ( exprBase )+
			{
			dbg.location(50,9);
			// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:50:9: ( exprBase )+
			int cnt12=0;
			try { dbg.enterSubRule(12);

			loop12:
			while (true) {
				int alt12=2;
				try { dbg.enterDecision(12, decisionCanBacktrack[12]);

				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= Symbol && LA12_0 <= Variable)||LA12_0==8||LA12_0==24) ) {
					alt12=1;
				}

				} finally {dbg.exitDecision(12);}

				switch (alt12) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\gulli\\Desktop\\mon pc\\a COURS ESIR\\tlc\\projet\\Projet_tlc\\grammaire\\While.g:50:9: exprBase
					{
					dbg.location(50,9);
					pushFollow(FOLLOW_exprBase_in_lExpr534);
					exprBase();
					state._fsp--;

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

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(50, 18);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "lExpr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "lExpr"

	// Delegated rules



	public static final BitSet FOLLOW_function_in_program11 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_EOF_in_program14 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_function23 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Symbol_in_function25 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_function27 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_definition_in_function29 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_definition37 = new BitSet(new long[]{0x0000000000000420L});
	public static final BitSet FOLLOW_input_in_definition39 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_definition41 = new BitSet(new long[]{0x0000000042480020L});
	public static final BitSet FOLLOW_commands_in_definition43 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_7_in_definition45 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_definition47 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_output_in_definition49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input59 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub66 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_inputSub70 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Variable_in_inputSub72 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_Variable_in_output84 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_output87 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Variable_in_output89 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_command_in_commands100 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_13_in_commands103 = new BitSet(new long[]{0x0000000042480020L});
	public static final BitSet FOLLOW_commands_in_commands105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_22_in_command120 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_expression_in_command122 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_command124 = new BitSet(new long[]{0x0000000042480020L});
	public static final BitSet FOLLOW_commands_in_command126 = new BitSet(new long[]{0x0000000000060000L});
	public static final BitSet FOLLOW_17_in_command129 = new BitSet(new long[]{0x0000000042480020L});
	public static final BitSet FOLLOW_commands_in_command131 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_18_in_command135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_30_in_command148 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_expression_in_command150 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_command152 = new BitSet(new long[]{0x0000000042480020L});
	public static final BitSet FOLLOW_commands_in_command154 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_command156 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_command188 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_expression_in_command190 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_command192 = new BitSet(new long[]{0x0000000042480020L});
	public static final BitSet FOLLOW_commands_in_command194 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_command196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_25_in_command231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command297 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_command299 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_expression_in_command301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_vars358 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_vars361 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_Variable_in_vars363 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_expression_in_exprs374 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_exprs377 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_expression_in_exprs379 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_exprBase_in_expression390 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_expression393 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_exprBase_in_expression395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_exprBase413 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_exprBase415 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_lExpr_in_exprBase417 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_exprBase419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_exprBase427 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_exprBase429 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_lExpr_in_exprBase431 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_exprBase433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_exprBase441 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_exprBase443 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_exprBase_in_exprBase445 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_exprBase447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_exprBase455 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_exprBase457 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_exprBase_in_exprBase459 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_exprBase461 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_exprBase469 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_Symbol_in_exprBase471 = new BitSet(new long[]{0x0000000001000130L});
	public static final BitSet FOLLOW_lExpr_in_exprBase473 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_exprBase475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_24_in_exprBase483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_exprBase491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Symbol_in_exprBase499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprBase_in_lExpr534 = new BitSet(new long[]{0x0000000001000132L});
}
