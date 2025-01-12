// $ANTLR 3.3 Nov 30, 2010 12:45:30 C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g 2024-12-02 08:42:12

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class WhileLexer extends Lexer {
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

    public WhileLexer() {;} 
    public WhileLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public WhileLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g"; }

    // $ANTLR start "T__8"
    public final void mT__8() throws RecognitionException {
        try {
            int _type = T__8;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:3:6: ( 'function' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:3:8: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__8"

    // $ANTLR start "T__9"
    public final void mT__9() throws RecognitionException {
        try {
            int _type = T__9;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:4:6: ( ':' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:4:8: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__9"

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:5:7: ( 'read' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:5:9: 'read'
            {
            match("read"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:6:7: ( 'write' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:6:9: 'write'
            {
            match("write"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:7:7: ( ',' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:7:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:8:7: ( ';' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:8:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:9:7: ( 'if' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:9:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:10:7: ( 'then' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:10:9: 'then'
            {
            match("then"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:11:7: ( 'else' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:11:9: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:12:7: ( 'fi' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:12:9: 'fi'
            {
            match("fi"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:7: ( 'while' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:13:9: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:14:7: ( 'do' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:14:9: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:15:7: ( 'od' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:15:9: 'od'
            {
            match("od"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:16:7: ( 'for' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:16:9: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:17:7: ( 'nop' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:17:9: 'nop'
            {
            match("nop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:18:7: ( ':=' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:18:9: ':='
            {
            match(":="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:19:7: ( '=?' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:19:9: '=?'
            {
            match("=?"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:20:7: ( '(' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:20:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:21:7: ( 'cons' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:21:9: 'cons'
            {
            match("cons"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:22:7: ( ')' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:22:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:23:7: ( 'list' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:23:9: 'list'
            {
            match("list"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:24:7: ( 'hd' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:24:9: 'hd'
            {
            match("hd"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:25:7: ( 'tl' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:25:9: 'tl'
            {
            match("tl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:26:7: ( 'nil' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:26:9: 'nil'
            {
            match("nil"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "PERCENT"
    public final void mPERCENT() throws RecognitionException {
        try {
            int _type = PERCENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:8:9: ( '%' )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:8:11: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PERCENT"

    // $ANTLR start "Variable"
    public final void mVariable() throws RecognitionException {
        try {
            int _type = Variable;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:54:10: ( 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )* ( '!' | '?' )? )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:54:12: 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )* ( '!' | '?' )?
            {
            matchRange('A','Z'); 
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:54:21: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')||(LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:54:55: ( '!' | '?' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='!'||LA2_0=='?') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:
                    {
                    if ( input.LA(1)=='!'||input.LA(1)=='?' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Variable"

    // $ANTLR start "Symbol"
    public final void mSymbol() throws RecognitionException {
        try {
            int _type = Symbol;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:55:8: ( 'a' .. 'z' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )* ( '!' | '?' )? )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:55:10: 'a' .. 'z' ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )* ( '!' | '?' )?
            {
            matchRange('a','z'); 
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:55:19: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:55:53: ( '!' | '?' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='!'||LA4_0=='?') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:
                    {
                    if ( input.LA(1)=='!'||input.LA(1)=='?' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Symbol"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:57:5: ( ( ' ' | '\\t' | '\\r' ) )
            // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:57:9: ( ' ' | '\\t' | '\\r' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:8: ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | PERCENT | Variable | Symbol | WS )
        int alt5=28;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:10: T__8
                {
                mT__8(); 

                }
                break;
            case 2 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:15: T__9
                {
                mT__9(); 

                }
                break;
            case 3 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:20: T__10
                {
                mT__10(); 

                }
                break;
            case 4 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:26: T__11
                {
                mT__11(); 

                }
                break;
            case 5 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:32: T__12
                {
                mT__12(); 

                }
                break;
            case 6 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:38: T__13
                {
                mT__13(); 

                }
                break;
            case 7 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:44: T__14
                {
                mT__14(); 

                }
                break;
            case 8 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:50: T__15
                {
                mT__15(); 

                }
                break;
            case 9 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:56: T__16
                {
                mT__16(); 

                }
                break;
            case 10 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:62: T__17
                {
                mT__17(); 

                }
                break;
            case 11 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:68: T__18
                {
                mT__18(); 

                }
                break;
            case 12 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:74: T__19
                {
                mT__19(); 

                }
                break;
            case 13 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:80: T__20
                {
                mT__20(); 

                }
                break;
            case 14 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:86: T__21
                {
                mT__21(); 

                }
                break;
            case 15 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:92: T__22
                {
                mT__22(); 

                }
                break;
            case 16 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:98: T__23
                {
                mT__23(); 

                }
                break;
            case 17 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:104: T__24
                {
                mT__24(); 

                }
                break;
            case 18 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:110: T__25
                {
                mT__25(); 

                }
                break;
            case 19 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:116: T__26
                {
                mT__26(); 

                }
                break;
            case 20 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:122: T__27
                {
                mT__27(); 

                }
                break;
            case 21 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:128: T__28
                {
                mT__28(); 

                }
                break;
            case 22 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:134: T__29
                {
                mT__29(); 

                }
                break;
            case 23 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:140: T__30
                {
                mT__30(); 

                }
                break;
            case 24 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:146: T__31
                {
                mT__31(); 

                }
                break;
            case 25 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:152: PERCENT
                {
                mPERCENT(); 

                }
                break;
            case 26 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:160: Variable
                {
                mVariable(); 

                }
                break;
            case 27 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:169: Symbol
                {
                mSymbol(); 

                }
                break;
            case 28 :
                // C:\\Users\\nolan\\github-classroom\\Projet_tlc\\grammaire\\While.g:1:176: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\1\uffff\1\25\1\33\2\25\2\uffff\6\25\2\uffff\1\25\1\uffff\2\25"+
        "\4\uffff\1\25\1\53\1\25\2\uffff\3\25\1\60\1\25\1\62\1\25\1\64\1"+
        "\65\4\25\1\72\1\25\1\uffff\1\74\3\25\1\uffff\1\25\1\uffff\1\25\2"+
        "\uffff\1\102\1\103\2\25\1\uffff\1\25\1\uffff\1\107\2\25\1\112\1"+
        "\113\2\uffff\1\114\1\115\1\25\1\uffff\1\117\1\120\4\uffff\1\25\2"+
        "\uffff\1\25\1\123\1\uffff";
    static final String DFA5_eofS =
        "\124\uffff";
    static final String DFA5_minS =
        "\1\11\1\151\1\75\1\145\1\150\2\uffff\1\146\1\150\1\154\1\157\1"+
        "\144\1\151\2\uffff\1\157\1\uffff\1\151\1\144\4\uffff\1\156\1\41"+
        "\1\162\2\uffff\1\141\2\151\1\41\1\145\1\41\1\163\2\41\1\160\1\154"+
        "\1\156\1\163\1\41\1\143\1\uffff\1\41\1\144\1\164\1\154\1\uffff\1"+
        "\156\1\uffff\1\145\2\uffff\2\41\1\163\1\164\1\uffff\1\164\1\uffff"+
        "\1\41\2\145\2\41\2\uffff\2\41\1\151\1\uffff\2\41\4\uffff\1\157\2"+
        "\uffff\1\156\1\41\1\uffff";
    static final String DFA5_maxS =
        "\1\172\1\165\1\75\1\145\1\162\2\uffff\1\146\2\154\1\157\1\144\1"+
        "\157\2\uffff\1\157\1\uffff\1\151\1\144\4\uffff\1\156\1\172\1\162"+
        "\2\uffff\1\141\2\151\1\172\1\145\1\172\1\163\2\172\1\160\1\154\1"+
        "\156\1\163\1\172\1\143\1\uffff\1\172\1\144\1\164\1\154\1\uffff\1"+
        "\156\1\uffff\1\145\2\uffff\2\172\1\163\1\164\1\uffff\1\164\1\uffff"+
        "\1\172\2\145\2\172\2\uffff\2\172\1\151\1\uffff\2\172\4\uffff\1\157"+
        "\2\uffff\1\156\1\172\1\uffff";
    static final String DFA5_acceptS =
        "\5\uffff\1\5\1\6\6\uffff\1\21\1\22\1\uffff\1\24\2\uffff\1\31\1"+
        "\32\1\33\1\34\3\uffff\1\20\1\2\17\uffff\1\12\4\uffff\1\7\1\uffff"+
        "\1\27\1\uffff\1\14\1\15\4\uffff\1\26\1\uffff\1\16\5\uffff\1\17\1"+
        "\30\3\uffff\1\3\2\uffff\1\10\1\11\1\23\1\25\1\uffff\1\4\1\13\2\uffff"+
        "\1\1";
    static final String DFA5_specialS =
        "\124\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\26\3\uffff\1\26\22\uffff\1\26\4\uffff\1\23\2\uffff\1\16"+
            "\1\20\2\uffff\1\5\15\uffff\1\2\1\6\1\uffff\1\15\3\uffff\32\24"+
            "\6\uffff\2\25\1\17\1\12\1\11\1\1\1\25\1\22\1\7\2\25\1\21\1\25"+
            "\1\14\1\13\2\25\1\3\1\25\1\10\2\25\1\4\3\25",
            "\1\30\5\uffff\1\31\5\uffff\1\27",
            "\1\32",
            "\1\34",
            "\1\36\11\uffff\1\35",
            "",
            "",
            "\1\37",
            "\1\40\3\uffff\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\46\5\uffff\1\45",
            "",
            "",
            "\1\47",
            "",
            "\1\50",
            "\1\51",
            "",
            "",
            "",
            "",
            "\1\52",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\54",
            "",
            "",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\61",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\63",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\73",
            "",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\75",
            "\1\76",
            "\1\77",
            "",
            "\1\100",
            "",
            "\1\101",
            "",
            "",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\104",
            "\1\105",
            "",
            "\1\106",
            "",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\110",
            "\1\111",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "",
            "",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\116",
            "",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            "",
            "",
            "",
            "",
            "\1\121",
            "",
            "",
            "\1\122",
            "\1\25\16\uffff\12\25\5\uffff\1\25\1\uffff\32\25\6\uffff\32"+
            "\25",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__8 | T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | PERCENT | Variable | Symbol | WS );";
        }
    }
 

}