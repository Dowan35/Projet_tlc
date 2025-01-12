// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g 2024-12-02 08:42:12

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
public class WhileParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "Symbol", "PERCENT", "Variable", "WS", "'function'", "':'", "'read'", "'write'", "','", "';'", "'if'", "'then'", "'else'", "'fi'", "'while'", "'do'", "'od'", "'for'", "'nop'", "':='", "'=?'", "'('", "'cons'", "')'", "'list'", "'hd'", "'tl'", "'nil'"
    };
    public static final int EOF=-1;
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
    public static final int PERCENT=5;
    public static final int Variable=6;
    public static final int WS=7;

    // delegates
    // delegators

    public static final String[] ruleNames = new String[] {
        "invalidRule", "exprs", "function", "command", "expression", "lExpr", 
        "inputSub", "definition", "output", "vars", "commands", "input", 
        "program", "exprBase"
    };
    public static final boolean[] decisionCanBacktrack = new boolean[] {
        false, // invalid decision
        false, false, false, false, false, false, false, false, false, 
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


    public String[] getTokenNames() { return WhileParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g"; }



    // $ANTLR start "program"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:4:1: program : function ;
    public final void program() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "program");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(4, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:4:9: ( function )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:4:11: function
            {
            dbg.location(4,11);
            pushFollow(FOLLOW_function_in_program11);
            function();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(4, 20);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "program");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "program"


    // $ANTLR start "function"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:6:1: function : 'function' Symbol ':' definition ;
    public final void function() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "function");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(6, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:6:10: ( 'function' Symbol ':' definition )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:6:12: 'function' Symbol ':' definition
            {
            dbg.location(6,12);
            match(input,8,FOLLOW_8_in_function20); 
            dbg.location(6,23);
            match(input,Symbol,FOLLOW_Symbol_in_function22); 
            dbg.location(6,30);
            match(input,9,FOLLOW_9_in_function24); 
            dbg.location(6,34);
            pushFollow(FOLLOW_definition_in_function26);
            definition();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(6, 44);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "function");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "function"


    // $ANTLR start "definition"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:9:1: definition : 'read' input PERCENT commands PERCENT 'write' output ;
    public final void definition() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "definition");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(9, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:9:12: ( 'read' input PERCENT commands PERCENT 'write' output )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:9:14: 'read' input PERCENT commands PERCENT 'write' output
            {
            dbg.location(9,14);
            match(input,10,FOLLOW_10_in_definition44); 
            dbg.location(9,21);
            pushFollow(FOLLOW_input_in_definition46);
            input();

            state._fsp--;

            dbg.location(9,27);
            match(input,PERCENT,FOLLOW_PERCENT_in_definition48); 
            dbg.location(9,35);
            pushFollow(FOLLOW_commands_in_definition50);
            commands();

            state._fsp--;

            dbg.location(9,44);
            match(input,PERCENT,FOLLOW_PERCENT_in_definition52); 
            dbg.location(9,52);
            match(input,11,FOLLOW_11_in_definition54); 
            dbg.location(9,60);
            pushFollow(FOLLOW_output_in_definition56);
            output();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(9, 67);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "definition");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "definition"


    // $ANTLR start "input"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:12:1: input : inputSub ;
    public final void input() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "input");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(12, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:12:8: ( inputSub )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:12:10: inputSub
            {
            dbg.location(12,10);
            pushFollow(FOLLOW_inputSub_in_input67);
            inputSub();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(12, 18);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "input");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "input"


    // $ANTLR start "inputSub"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:1: inputSub : ( Variable )? ( ',' Variable )* ;
    public final void inputSub() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "inputSub");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(13, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:10: ( ( Variable )? ( ',' Variable )* )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:12: ( Variable )? ( ',' Variable )*
            {
            dbg.location(13,12);
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:12: ( Variable )?
            int alt1=2;
            try { dbg.enterSubRule(1);
            try { dbg.enterDecision(1, decisionCanBacktrack[1]);

            int LA1_0 = input.LA(1);

            if ( (LA1_0==Variable) ) {
                alt1=1;
            }
            } finally {dbg.exitDecision(1);}

            switch (alt1) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:12: Variable
                    {
                    dbg.location(13,12);
                    match(input,Variable,FOLLOW_Variable_in_inputSub74); 

                    }
                    break;

            }
            } finally {dbg.exitSubRule(1);}

            dbg.location(13,22);
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:22: ( ',' Variable )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=2;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

                int LA2_0 = input.LA(1);

                if ( (LA2_0==12) ) {
                    alt2=1;
                }


                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:23: ',' Variable
            	    {
            	    dbg.location(13,23);
            	    match(input,12,FOLLOW_12_in_inputSub78); 
            	    dbg.location(13,27);
            	    match(input,Variable,FOLLOW_Variable_in_inputSub80); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(13, 37);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "inputSub");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "inputSub"


    // $ANTLR start "output"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:16:1: output : Variable ( ',' Variable )* ;
    public final void output() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "output");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(16, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:16:9: ( Variable ( ',' Variable )* )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:16:11: Variable ( ',' Variable )*
            {
            dbg.location(16,11);
            match(input,Variable,FOLLOW_Variable_in_output92); 
            dbg.location(16,20);
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:16:20: ( ',' Variable )*
            try { dbg.enterSubRule(3);

            loop3:
            do {
                int alt3=2;
                try { dbg.enterDecision(3, decisionCanBacktrack[3]);

                int LA3_0 = input.LA(1);

                if ( (LA3_0==12) ) {
                    alt3=1;
                }


                } finally {dbg.exitDecision(3);}

                switch (alt3) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:16:21: ',' Variable
            	    {
            	    dbg.location(16,21);
            	    match(input,12,FOLLOW_12_in_output95); 
            	    dbg.location(16,25);
            	    match(input,Variable,FOLLOW_Variable_in_output97); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);
            } finally {dbg.exitSubRule(3);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(16, 35);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "output");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "output"


    // $ANTLR start "commands"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:19:1: commands : command ( ';' commands )? ;
    public final void commands() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "commands");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(19, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:19:10: ( command ( ';' commands )? )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:19:12: command ( ';' commands )?
            {
            dbg.location(19,12);
            pushFollow(FOLLOW_command_in_commands108);
            command();

            state._fsp--;

            dbg.location(19,20);
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:19:20: ( ';' commands )?
            int alt4=2;
            try { dbg.enterSubRule(4);
            try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            } finally {dbg.exitDecision(4);}

            switch (alt4) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:19:21: ';' commands
                    {
                    dbg.location(19,21);
                    match(input,13,FOLLOW_13_in_commands111); 
                    dbg.location(19,25);
                    pushFollow(FOLLOW_commands_in_commands113);
                    commands();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(4);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(19, 36);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "commands");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "commands"


    // $ANTLR start "command"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:21:1: command : ( 'if' expression 'then' commands ( 'else' commands )? 'fi' | 'while' expression 'do' commands 'od' | 'for' expression 'do' commands 'od' | 'nop' | vars ':=' expression );
    public final void command() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "command");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(21, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:22:5: ( 'if' expression 'then' commands ( 'else' commands )? 'fi' | 'while' expression 'do' commands 'od' | 'for' expression 'do' commands 'od' | 'nop' | vars ':=' expression )
            int alt6=5;
            try { dbg.enterDecision(6, decisionCanBacktrack[6]);

            switch ( input.LA(1) ) {
            case 14:
                {
                alt6=1;
                }
                break;
            case 18:
                {
                alt6=2;
                }
                break;
            case 21:
                {
                alt6=3;
                }
                break;
            case 22:
                {
                alt6=4;
                }
                break;
            case Variable:
                {
                alt6=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;
            }

            } finally {dbg.exitDecision(6);}

            switch (alt6) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:22:7: 'if' expression 'then' commands ( 'else' commands )? 'fi'
                    {
                    dbg.location(22,7);
                    match(input,14,FOLLOW_14_in_command128); 
                    dbg.location(22,12);
                    pushFollow(FOLLOW_expression_in_command130);
                    expression();

                    state._fsp--;

                    dbg.location(22,23);
                    match(input,15,FOLLOW_15_in_command132); 
                    dbg.location(22,30);
                    pushFollow(FOLLOW_commands_in_command134);
                    commands();

                    state._fsp--;

                    dbg.location(22,39);
                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:22:39: ( 'else' commands )?
                    int alt5=2;
                    try { dbg.enterSubRule(5);
                    try { dbg.enterDecision(5, decisionCanBacktrack[5]);

                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==16) ) {
                        alt5=1;
                    }
                    } finally {dbg.exitDecision(5);}

                    switch (alt5) {
                        case 1 :
                            dbg.enterAlt(1);

                            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:22:40: 'else' commands
                            {
                            dbg.location(22,40);
                            match(input,16,FOLLOW_16_in_command137); 
                            dbg.location(22,47);
                            pushFollow(FOLLOW_commands_in_command139);
                            commands();

                            state._fsp--;


                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(5);}

                    dbg.location(22,58);
                    match(input,17,FOLLOW_17_in_command143); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:23:7: 'while' expression 'do' commands 'od'
                    {
                    dbg.location(23,7);
                    match(input,18,FOLLOW_18_in_command156); 
                    dbg.location(23,15);
                    pushFollow(FOLLOW_expression_in_command158);
                    expression();

                    state._fsp--;

                    dbg.location(23,26);
                    match(input,19,FOLLOW_19_in_command160); 
                    dbg.location(23,31);
                    pushFollow(FOLLOW_commands_in_command162);
                    commands();

                    state._fsp--;

                    dbg.location(23,40);
                    match(input,20,FOLLOW_20_in_command164); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:24:7: 'for' expression 'do' commands 'od'
                    {
                    dbg.location(24,7);
                    match(input,21,FOLLOW_21_in_command196); 
                    dbg.location(24,13);
                    pushFollow(FOLLOW_expression_in_command198);
                    expression();

                    state._fsp--;

                    dbg.location(24,24);
                    match(input,19,FOLLOW_19_in_command200); 
                    dbg.location(24,29);
                    pushFollow(FOLLOW_commands_in_command202);
                    commands();

                    state._fsp--;

                    dbg.location(24,38);
                    match(input,20,FOLLOW_20_in_command204); 

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:25:7: 'nop'
                    {
                    dbg.location(25,7);
                    match(input,22,FOLLOW_22_in_command239); 

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:26:7: vars ':=' expression
                    {
                    dbg.location(26,7);
                    pushFollow(FOLLOW_vars_in_command305);
                    vars();

                    state._fsp--;

                    dbg.location(26,12);
                    match(input,23,FOLLOW_23_in_command307); 
                    dbg.location(26,17);
                    pushFollow(FOLLOW_expression_in_command309);
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
        }
        dbg.location(27, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "command");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "command"


    // $ANTLR start "vars"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:30:1: vars : Variable ( ',' Variable )* ;
    public final void vars() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "vars");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(30, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:30:6: ( Variable ( ',' Variable )* )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:30:8: Variable ( ',' Variable )*
            {
            dbg.location(30,8);
            match(input,Variable,FOLLOW_Variable_in_vars366); 
            dbg.location(30,17);
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:30:17: ( ',' Variable )*
            try { dbg.enterSubRule(7);

            loop7:
            do {
                int alt7=2;
                try { dbg.enterDecision(7, decisionCanBacktrack[7]);

                int LA7_0 = input.LA(1);

                if ( (LA7_0==12) ) {
                    alt7=1;
                }


                } finally {dbg.exitDecision(7);}

                switch (alt7) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:30:18: ',' Variable
            	    {
            	    dbg.location(30,18);
            	    match(input,12,FOLLOW_12_in_vars369); 
            	    dbg.location(30,22);
            	    match(input,Variable,FOLLOW_Variable_in_vars371); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);
            } finally {dbg.exitSubRule(7);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(30, 32);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "vars");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "vars"


    // $ANTLR start "exprs"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:33:1: exprs : expression ( ',' expression )* ;
    public final void exprs() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "exprs");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(33, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:33:7: ( expression ( ',' expression )* )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:33:9: expression ( ',' expression )*
            {
            dbg.location(33,9);
            pushFollow(FOLLOW_expression_in_exprs382);
            expression();

            state._fsp--;

            dbg.location(33,20);
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:33:20: ( ',' expression )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=2;
                try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==12) ) {
                    alt8=1;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:33:21: ',' expression
            	    {
            	    dbg.location(33,21);
            	    match(input,12,FOLLOW_12_in_exprs385); 
            	    dbg.location(33,25);
            	    pushFollow(FOLLOW_expression_in_exprs387);
            	    expression();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(33, 37);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "exprs");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "exprs"


    // $ANTLR start "expression"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:36:1: expression : exprBase ( '=?' exprBase )? ;
    public final void expression() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "expression");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(36, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:36:12: ( exprBase ( '=?' exprBase )? )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:36:14: exprBase ( '=?' exprBase )?
            {
            dbg.location(36,14);
            pushFollow(FOLLOW_exprBase_in_expression398);
            exprBase();

            state._fsp--;

            dbg.location(36,23);
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:36:23: ( '=?' exprBase )?
            int alt9=2;
            try { dbg.enterSubRule(9);
            try { dbg.enterDecision(9, decisionCanBacktrack[9]);

            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            } finally {dbg.exitDecision(9);}

            switch (alt9) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:36:24: '=?' exprBase
                    {
                    dbg.location(36,24);
                    match(input,24,FOLLOW_24_in_expression401); 
                    dbg.location(36,29);
                    pushFollow(FOLLOW_exprBase_in_expression403);
                    exprBase();

                    state._fsp--;


                    }
                    break;

            }
            } finally {dbg.exitSubRule(9);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(36, 40);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "expression");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "expression"


    // $ANTLR start "exprBase"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:39:1: exprBase : ( '(' 'cons' lExpr ')' | '(' 'list' lExpr ')' | '(' 'hd' exprBase ')' | '(' 'tl' exprBase ')' | '(' Symbol lExpr ')' | 'nil' | Variable | Symbol );
    public final void exprBase() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "exprBase");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(39, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:40:5: ( '(' 'cons' lExpr ')' | '(' 'list' lExpr ')' | '(' 'hd' exprBase ')' | '(' 'tl' exprBase ')' | '(' Symbol lExpr ')' | 'nil' | Variable | Symbol )
            int alt10=8;
            try { dbg.enterDecision(10, decisionCanBacktrack[10]);

            try {
                isCyclicDecision = true;
                alt10 = dfa10.predict(input);
            }
            catch (NoViableAltException nvae) {
                dbg.recognitionException(nvae);
                throw nvae;
            }
            } finally {dbg.exitDecision(10);}

            switch (alt10) {
                case 1 :
                    dbg.enterAlt(1);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:40:7: '(' 'cons' lExpr ')'
                    {
                    dbg.location(40,7);
                    match(input,25,FOLLOW_25_in_exprBase421); 
                    dbg.location(40,11);
                    match(input,26,FOLLOW_26_in_exprBase423); 
                    dbg.location(40,18);
                    pushFollow(FOLLOW_lExpr_in_exprBase425);
                    lExpr();

                    state._fsp--;

                    dbg.location(40,24);
                    match(input,27,FOLLOW_27_in_exprBase427); 

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:41:7: '(' 'list' lExpr ')'
                    {
                    dbg.location(41,7);
                    match(input,25,FOLLOW_25_in_exprBase435); 
                    dbg.location(41,11);
                    match(input,28,FOLLOW_28_in_exprBase437); 
                    dbg.location(41,18);
                    pushFollow(FOLLOW_lExpr_in_exprBase439);
                    lExpr();

                    state._fsp--;

                    dbg.location(41,24);
                    match(input,27,FOLLOW_27_in_exprBase441); 

                    }
                    break;
                case 3 :
                    dbg.enterAlt(3);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:42:7: '(' 'hd' exprBase ')'
                    {
                    dbg.location(42,7);
                    match(input,25,FOLLOW_25_in_exprBase449); 
                    dbg.location(42,11);
                    match(input,29,FOLLOW_29_in_exprBase451); 
                    dbg.location(42,16);
                    pushFollow(FOLLOW_exprBase_in_exprBase453);
                    exprBase();

                    state._fsp--;

                    dbg.location(42,25);
                    match(input,27,FOLLOW_27_in_exprBase455); 

                    }
                    break;
                case 4 :
                    dbg.enterAlt(4);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:43:7: '(' 'tl' exprBase ')'
                    {
                    dbg.location(43,7);
                    match(input,25,FOLLOW_25_in_exprBase463); 
                    dbg.location(43,11);
                    match(input,30,FOLLOW_30_in_exprBase465); 
                    dbg.location(43,16);
                    pushFollow(FOLLOW_exprBase_in_exprBase467);
                    exprBase();

                    state._fsp--;

                    dbg.location(43,25);
                    match(input,27,FOLLOW_27_in_exprBase469); 

                    }
                    break;
                case 5 :
                    dbg.enterAlt(5);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:44:7: '(' Symbol lExpr ')'
                    {
                    dbg.location(44,7);
                    match(input,25,FOLLOW_25_in_exprBase477); 
                    dbg.location(44,11);
                    match(input,Symbol,FOLLOW_Symbol_in_exprBase479); 
                    dbg.location(44,18);
                    pushFollow(FOLLOW_lExpr_in_exprBase481);
                    lExpr();

                    state._fsp--;

                    dbg.location(44,24);
                    match(input,27,FOLLOW_27_in_exprBase483); 

                    }
                    break;
                case 6 :
                    dbg.enterAlt(6);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:45:7: 'nil'
                    {
                    dbg.location(45,7);
                    match(input,31,FOLLOW_31_in_exprBase491); 

                    }
                    break;
                case 7 :
                    dbg.enterAlt(7);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:46:7: Variable
                    {
                    dbg.location(46,7);
                    match(input,Variable,FOLLOW_Variable_in_exprBase499); 

                    }
                    break;
                case 8 :
                    dbg.enterAlt(8);

                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:47:7: Symbol
                    {
                    dbg.location(47,7);
                    match(input,Symbol,FOLLOW_Symbol_in_exprBase507); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(48, 5);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "exprBase");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "exprBase"


    // $ANTLR start "lExpr"
    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:51:1: lExpr : ( exprBase )+ ;
    public final void lExpr() throws RecognitionException {
        try { dbg.enterRule(getGrammarFileName(), "lExpr");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(51, 1);

        try {
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:51:7: ( ( exprBase )+ )
            dbg.enterAlt(1);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:51:9: ( exprBase )+
            {
            dbg.location(51,9);
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:51:9: ( exprBase )+
            int cnt11=0;
            try { dbg.enterSubRule(11);

            loop11:
            do {
                int alt11=2;
                try { dbg.enterDecision(11, decisionCanBacktrack[11]);

                int LA11_0 = input.LA(1);

                if ( (LA11_0==Symbol||LA11_0==Variable||LA11_0==25||LA11_0==31) ) {
                    alt11=1;
                }


                } finally {dbg.exitDecision(11);}

                switch (alt11) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:51:9: exprBase
            	    {
            	    dbg.location(51,9);
            	    pushFollow(FOLLOW_exprBase_in_lExpr542);
            	    exprBase();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt11++;
            } while (true);
            } finally {dbg.exitSubRule(11);}


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        dbg.location(51, 19);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "lExpr");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return ;
    }
    // $ANTLR end "lExpr"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\12\uffff";
    static final String DFA10_eofS =
        "\12\uffff";
    static final String DFA10_minS =
        "\2\4\10\uffff";
    static final String DFA10_maxS =
        "\1\37\1\36\10\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\6\1\7\1\10\1\1\1\2\1\3\1\4\1\5";
    static final String DFA10_specialS =
        "\12\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\4\1\uffff\1\3\22\uffff\1\1\5\uffff\1\2",
            "\1\11\25\uffff\1\5\1\uffff\1\6\1\7\1\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "39:1: exprBase : ( '(' 'cons' lExpr ')' | '(' 'list' lExpr ')' | '(' 'hd' exprBase ')' | '(' 'tl' exprBase ')' | '(' Symbol lExpr ')' | 'nil' | Variable | Symbol );";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_function_in_program11 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_8_in_function20 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Symbol_in_function22 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_function24 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_definition_in_function26 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_definition44 = new BitSet(new long[]{0x0000000000001040L});
    public static final BitSet FOLLOW_input_in_definition46 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PERCENT_in_definition48 = new BitSet(new long[]{0x0000000000644040L});
    public static final BitSet FOLLOW_commands_in_definition50 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_PERCENT_in_definition52 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_definition54 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_output_in_definition56 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_inputSub_in_input67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Variable_in_inputSub74 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_inputSub78 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Variable_in_inputSub80 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_Variable_in_output92 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_output95 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Variable_in_output97 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_command_in_commands108 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_13_in_commands111 = new BitSet(new long[]{0x0000000000644040L});
    public static final BitSet FOLLOW_commands_in_commands113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_command128 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_expression_in_command130 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_command132 = new BitSet(new long[]{0x0000000000644040L});
    public static final BitSet FOLLOW_commands_in_command134 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_16_in_command137 = new BitSet(new long[]{0x0000000000644040L});
    public static final BitSet FOLLOW_commands_in_command139 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_command143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_command156 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_expression_in_command158 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_command160 = new BitSet(new long[]{0x0000000000644040L});
    public static final BitSet FOLLOW_commands_in_command162 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_command164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_command196 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_expression_in_command198 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_command200 = new BitSet(new long[]{0x0000000000644040L});
    public static final BitSet FOLLOW_commands_in_command202 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_command204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_command239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_vars_in_command305 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_command307 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_expression_in_command309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Variable_in_vars366 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_vars369 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_Variable_in_vars371 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_expression_in_exprs382 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_exprs385 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_expression_in_exprs387 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_exprBase_in_expression398 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_expression401 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_exprBase_in_expression403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_exprBase421 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_exprBase423 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_lExpr_in_exprBase425 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_exprBase427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_exprBase435 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_exprBase437 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_lExpr_in_exprBase439 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_exprBase441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_exprBase449 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_exprBase451 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_exprBase_in_exprBase453 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_exprBase455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_exprBase463 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_exprBase465 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_exprBase_in_exprBase467 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_exprBase469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_exprBase477 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_Symbol_in_exprBase479 = new BitSet(new long[]{0x0000000082000050L});
    public static final BitSet FOLLOW_lExpr_in_exprBase481 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_exprBase483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_exprBase491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Variable_in_exprBase499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Symbol_in_exprBase507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exprBase_in_lExpr542 = new BitSet(new long[]{0x0000000082000052L});

}