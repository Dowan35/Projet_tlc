package antlr;
// $ANTLR 3.5.3 .\\src\\antlr\\While.g 2025-01-22 00:48:52

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class WhileParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMANDS", "CONS", "EXPRS", "FOR", 
		"FOREACH", "FUNCTION", "HD", "IF", "INPUTS", "LET", "LIST", "NIL", "NOP", 
		"OUTPUTS", "PROGRAM", "SYMB", "Symbol", "TL", "VARS", "Variable", "WHILE", 
		"WS", "'%'", "'('", "')'", "','", "':'", "':='", "';'", "'=?'", "'cons'", 
		"'do'", "'else'", "'fi'", "'for'", "'foreach'", "'function'", "'hd'", 
		"'if'", "'in'", "'list'", "'nil'", "'nop'", "'od'", "'read'", "'then'", 
		"'tl'", "'while'", "'write'"
	};
	public static final int EOF=-1;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int T__33=33;
	public static final int T__34=34;
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
	public static final int COMMANDS=4;
	public static final int CONS=5;
	public static final int EXPRS=6;
	public static final int FOR=7;
	public static final int FOREACH=8;
	public static final int FUNCTION=9;
	public static final int HD=10;
	public static final int IF=11;
	public static final int INPUTS=12;
	public static final int LET=13;
	public static final int LIST=14;
	public static final int NIL=15;
	public static final int NOP=16;
	public static final int OUTPUTS=17;
	public static final int PROGRAM=18;
	public static final int SYMB=19;
	public static final int Symbol=20;
	public static final int TL=21;
	public static final int VARS=22;
	public static final int Variable=23;
	public static final int WHILE=24;
	public static final int WS=25;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public WhileParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public WhileParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return WhileParser.tokenNames; }
	@Override public String getGrammarFileName() { return ".\\src\\antlr\\While.g"; }


	public static class program_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "program"
	// .\\src\\antlr\\While.g:25:1: program : ( function )+ -> ^( PROGRAM ( function )+ ) ;
	public final WhileParser.program_return program() throws RecognitionException {
		WhileParser.program_return retval = new WhileParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope function1 =null;

		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");

		try {
			// .\\src\\antlr\\While.g:25:9: ( ( function )+ -> ^( PROGRAM ( function )+ ) )
			// .\\src\\antlr\\While.g:25:11: ( function )+
			{
			// .\\src\\antlr\\While.g:25:11: ( function )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==40) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// .\\src\\antlr\\While.g:25:11: function
					{
					pushFollow(FOLLOW_function_in_program99);
					function1=function();
					state._fsp--;

					stream_function.add(function1.getTree());
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}


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
			// 25:21: -> ^( PROGRAM ( function )+ )
			{
				// .\\src\\antlr\\While.g:25:24: ^( PROGRAM ( function )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(PROGRAM, "PROGRAM"), root_1);
				if ( !(stream_function.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_function.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "program"


	public static class function_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "function"
	// .\\src\\antlr\\While.g:27:1: function : 'function' Symbol ':' definition -> ^( FUNCTION Symbol definition ) ;
	public final WhileParser.function_return function() throws RecognitionException {
		WhileParser.function_return retval = new WhileParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal2=null;
		Token Symbol3=null;
		Token char_literal4=null;
		ParserRuleReturnScope definition5 =null;

		Object string_literal2_tree=null;
		Object Symbol3_tree=null;
		Object char_literal4_tree=null;
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_40=new RewriteRuleTokenStream(adaptor,"token 40");
		RewriteRuleTokenStream stream_30=new RewriteRuleTokenStream(adaptor,"token 30");
		RewriteRuleSubtreeStream stream_definition=new RewriteRuleSubtreeStream(adaptor,"rule definition");

		try {
			// .\\src\\antlr\\While.g:27:10: ( 'function' Symbol ':' definition -> ^( FUNCTION Symbol definition ) )
			// .\\src\\antlr\\While.g:27:12: 'function' Symbol ':' definition
			{
			string_literal2=(Token)match(input,40,FOLLOW_40_in_function117);  
			stream_40.add(string_literal2);

			Symbol3=(Token)match(input,Symbol,FOLLOW_Symbol_in_function119);  
			stream_Symbol.add(Symbol3);

			char_literal4=(Token)match(input,30,FOLLOW_30_in_function121);  
			stream_30.add(char_literal4);

			pushFollow(FOLLOW_definition_in_function123);
			definition5=definition();
			state._fsp--;

			stream_definition.add(definition5.getTree());

			// AST REWRITE
			// elements: definition, Symbol
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 27:45: -> ^( FUNCTION Symbol definition )
			{
				// .\\src\\antlr\\While.g:27:48: ^( FUNCTION Symbol definition )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FUNCTION, "FUNCTION"), root_1);
				adaptor.addChild(root_1, stream_Symbol.nextNode());
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
		return retval;
	}
	// $ANTLR end "function"


	public static class definition_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "definition"
	// .\\src\\antlr\\While.g:29:1: definition : 'read' input '%' commands '%' 'write' output -> input commands output ;
	public final WhileParser.definition_return definition() throws RecognitionException {
		WhileParser.definition_return retval = new WhileParser.definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal6=null;
		Token char_literal8=null;
		Token char_literal10=null;
		Token string_literal11=null;
		ParserRuleReturnScope input7 =null;
		ParserRuleReturnScope commands9 =null;
		ParserRuleReturnScope output12 =null;

		Object string_literal6_tree=null;
		Object char_literal8_tree=null;
		Object char_literal10_tree=null;
		Object string_literal11_tree=null;
		RewriteRuleTokenStream stream_48=new RewriteRuleTokenStream(adaptor,"token 48");
		RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
		RewriteRuleTokenStream stream_52=new RewriteRuleTokenStream(adaptor,"token 52");
		RewriteRuleSubtreeStream stream_output=new RewriteRuleSubtreeStream(adaptor,"rule output");
		RewriteRuleSubtreeStream stream_input=new RewriteRuleSubtreeStream(adaptor,"rule input");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// .\\src\\antlr\\While.g:29:12: ( 'read' input '%' commands '%' 'write' output -> input commands output )
			// .\\src\\antlr\\While.g:29:14: 'read' input '%' commands '%' 'write' output
			{
			string_literal6=(Token)match(input,48,FOLLOW_48_in_definition141);  
			stream_48.add(string_literal6);

			pushFollow(FOLLOW_input_in_definition143);
			input7=input();
			state._fsp--;

			stream_input.add(input7.getTree());
			char_literal8=(Token)match(input,26,FOLLOW_26_in_definition145);  
			stream_26.add(char_literal8);

			pushFollow(FOLLOW_commands_in_definition147);
			commands9=commands();
			state._fsp--;

			stream_commands.add(commands9.getTree());
			char_literal10=(Token)match(input,26,FOLLOW_26_in_definition149);  
			stream_26.add(char_literal10);

			string_literal11=(Token)match(input,52,FOLLOW_52_in_definition151);  
			stream_52.add(string_literal11);

			pushFollow(FOLLOW_output_in_definition153);
			output12=output();
			state._fsp--;

			stream_output.add(output12.getTree());

			// AST REWRITE
			// elements: input, commands, output
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (Object)adaptor.nil();
			// 29:58: -> input commands output
			{
				adaptor.addChild(root_0, stream_input.nextTree());
				adaptor.addChild(root_0, stream_commands.nextTree());
				adaptor.addChild(root_0, stream_output.nextTree());
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
		return retval;
	}
	// $ANTLR end "definition"


	public static class input_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "input"
	// .\\src\\antlr\\While.g:32:1: input : inputSub -> inputSub ;
	public final WhileParser.input_return input() throws RecognitionException {
		WhileParser.input_return retval = new WhileParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputSub13 =null;

		RewriteRuleSubtreeStream stream_inputSub=new RewriteRuleSubtreeStream(adaptor,"rule inputSub");

		try {
			// .\\src\\antlr\\While.g:32:8: ( inputSub -> inputSub )
			// .\\src\\antlr\\While.g:32:10: inputSub
			{
			pushFollow(FOLLOW_inputSub_in_input170);
			inputSub13=inputSub();
			state._fsp--;

			stream_inputSub.add(inputSub13.getTree());

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
			// 32:18: -> inputSub
			{
				adaptor.addChild(root_0, stream_inputSub.nextTree());
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
		return retval;
	}
	// $ANTLR end "input"


	public static class inputSub_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "inputSub"
	// .\\src\\antlr\\While.g:33:1: inputSub : ( Variable )? ( ',' Variable )* -> ^( INPUTS ( Variable )* ) ;
	public final WhileParser.inputSub_return inputSub() throws RecognitionException {
		WhileParser.inputSub_return retval = new WhileParser.inputSub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable14=null;
		Token char_literal15=null;
		Token Variable16=null;

		Object Variable14_tree=null;
		Object char_literal15_tree=null;
		Object Variable16_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

		try {
			// .\\src\\antlr\\While.g:33:10: ( ( Variable )? ( ',' Variable )* -> ^( INPUTS ( Variable )* ) )
			// .\\src\\antlr\\While.g:33:12: ( Variable )? ( ',' Variable )*
			{
			// .\\src\\antlr\\While.g:33:12: ( Variable )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Variable) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// .\\src\\antlr\\While.g:33:12: Variable
					{
					Variable14=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub180);  
					stream_Variable.add(Variable14);

					}
					break;

			}

			// .\\src\\antlr\\While.g:33:22: ( ',' Variable )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==29) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// .\\src\\antlr\\While.g:33:23: ',' Variable
					{
					char_literal15=(Token)match(input,29,FOLLOW_29_in_inputSub184);  
					stream_29.add(char_literal15);

					Variable16=(Token)match(input,Variable,FOLLOW_Variable_in_inputSub186);  
					stream_Variable.add(Variable16);

					}
					break;

				default :
					break loop3;
				}
			}


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
			// 33:37: -> ^( INPUTS ( Variable )* )
			{
				// .\\src\\antlr\\While.g:33:40: ^( INPUTS ( Variable )* )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(INPUTS, "INPUTS"), root_1);
				// .\\src\\antlr\\While.g:33:49: ( Variable )*
				while ( stream_Variable.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "inputSub"


	public static class output_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "output"
	// .\\src\\antlr\\While.g:36:1: output : Variable ( ',' Variable )* -> ^( OUTPUTS ( Variable )+ ) ;
	public final WhileParser.output_return output() throws RecognitionException {
		WhileParser.output_return retval = new WhileParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable17=null;
		Token char_literal18=null;
		Token Variable19=null;

		Object Variable17_tree=null;
		Object char_literal18_tree=null;
		Object Variable19_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

		try {
			// .\\src\\antlr\\While.g:36:8: ( Variable ( ',' Variable )* -> ^( OUTPUTS ( Variable )+ ) )
			// .\\src\\antlr\\While.g:36:9: Variable ( ',' Variable )*
			{
			Variable17=(Token)match(input,Variable,FOLLOW_Variable_in_output204);  
			stream_Variable.add(Variable17);

			// .\\src\\antlr\\While.g:36:18: ( ',' Variable )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==29) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// .\\src\\antlr\\While.g:36:19: ',' Variable
					{
					char_literal18=(Token)match(input,29,FOLLOW_29_in_output207);  
					stream_29.add(char_literal18);

					Variable19=(Token)match(input,Variable,FOLLOW_Variable_in_output209);  
					stream_Variable.add(Variable19);

					}
					break;

				default :
					break loop4;
				}
			}


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
			// 36:34: -> ^( OUTPUTS ( Variable )+ )
			{
				// .\\src\\antlr\\While.g:36:37: ^( OUTPUTS ( Variable )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(OUTPUTS, "OUTPUTS"), root_1);
				if ( !(stream_Variable.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Variable.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "output"


	public static class commands_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "commands"
	// .\\src\\antlr\\While.g:39:1: commands : command ( ';' command )* -> ^( COMMANDS ( command )+ ) ;
	public final WhileParser.commands_return commands() throws RecognitionException {
		WhileParser.commands_return retval = new WhileParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal21=null;
		ParserRuleReturnScope command20 =null;
		ParserRuleReturnScope command22 =null;

		Object char_literal21_tree=null;
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleSubtreeStream stream_command=new RewriteRuleSubtreeStream(adaptor,"rule command");

		try {
			// .\\src\\antlr\\While.g:39:10: ( command ( ';' command )* -> ^( COMMANDS ( command )+ ) )
			// .\\src\\antlr\\While.g:39:12: command ( ';' command )*
			{
			pushFollow(FOLLOW_command_in_commands229);
			command20=command();
			state._fsp--;

			stream_command.add(command20.getTree());
			// .\\src\\antlr\\While.g:39:20: ( ';' command )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==32) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// .\\src\\antlr\\While.g:39:21: ';' command
					{
					char_literal21=(Token)match(input,32,FOLLOW_32_in_commands232);  
					stream_32.add(char_literal21);

					pushFollow(FOLLOW_command_in_commands234);
					command22=command();
					state._fsp--;

					stream_command.add(command22.getTree());
					}
					break;

				default :
					break loop5;
				}
			}


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
			// 39:36: -> ^( COMMANDS ( command )+ )
			{
				// .\\src\\antlr\\While.g:39:39: ^( COMMANDS ( command )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(COMMANDS, "COMMANDS"), root_1);
				if ( !(stream_command.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_command.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "commands"


	public static class exprs_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprs"
	// .\\src\\antlr\\While.g:42:1: exprs : expression ( ',' expression )* -> ^( EXPRS ( expression )+ ) ;
	public final WhileParser.exprs_return exprs() throws RecognitionException {
		WhileParser.exprs_return retval = new WhileParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal24=null;
		ParserRuleReturnScope expression23 =null;
		ParserRuleReturnScope expression25 =null;

		Object char_literal24_tree=null;
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// .\\src\\antlr\\While.g:42:7: ( expression ( ',' expression )* -> ^( EXPRS ( expression )+ ) )
			// .\\src\\antlr\\While.g:42:9: expression ( ',' expression )*
			{
			pushFollow(FOLLOW_expression_in_exprs255);
			expression23=expression();
			state._fsp--;

			stream_expression.add(expression23.getTree());
			// .\\src\\antlr\\While.g:42:20: ( ',' expression )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==29) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// .\\src\\antlr\\While.g:42:21: ',' expression
					{
					char_literal24=(Token)match(input,29,FOLLOW_29_in_exprs258);  
					stream_29.add(char_literal24);

					pushFollow(FOLLOW_expression_in_exprs260);
					expression25=expression();
					state._fsp--;

					stream_expression.add(expression25.getTree());
					}
					break;

				default :
					break loop6;
				}
			}


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
			// 42:37: -> ^( EXPRS ( expression )+ )
			{
				// .\\src\\antlr\\While.g:42:40: ^( EXPRS ( expression )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPRS, "EXPRS"), root_1);
				if ( !(stream_expression.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_expression.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "exprs"


	public static class vars_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "vars"
	// .\\src\\antlr\\While.g:44:1: vars : Variable ( ',' Variable )* -> ^( VARS ( Variable )+ ) ;
	public final WhileParser.vars_return vars() throws RecognitionException {
		WhileParser.vars_return retval = new WhileParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable26=null;
		Token char_literal27=null;
		Token Variable28=null;

		Object Variable26_tree=null;
		Object char_literal27_tree=null;
		Object Variable28_tree=null;
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_29=new RewriteRuleTokenStream(adaptor,"token 29");

		try {
			// .\\src\\antlr\\While.g:44:6: ( Variable ( ',' Variable )* -> ^( VARS ( Variable )+ ) )
			// .\\src\\antlr\\While.g:44:8: Variable ( ',' Variable )*
			{
			Variable26=(Token)match(input,Variable,FOLLOW_Variable_in_vars278);  
			stream_Variable.add(Variable26);

			// .\\src\\antlr\\While.g:44:17: ( ',' Variable )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==29) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// .\\src\\antlr\\While.g:44:18: ',' Variable
					{
					char_literal27=(Token)match(input,29,FOLLOW_29_in_vars281);  
					stream_29.add(char_literal27);

					Variable28=(Token)match(input,Variable,FOLLOW_Variable_in_vars283);  
					stream_Variable.add(Variable28);

					}
					break;

				default :
					break loop7;
				}
			}


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
			// 44:33: -> ^( VARS ( Variable )+ )
			{
				// .\\src\\antlr\\While.g:44:36: ^( VARS ( Variable )+ )
				{
				Object root_1 = (Object)adaptor.nil();
				root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(VARS, "VARS"), root_1);
				if ( !(stream_Variable.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_Variable.hasNext() ) {
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
		return retval;
	}
	// $ANTLR end "vars"


	public static class command_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "command"
	// .\\src\\antlr\\While.g:46:1: command : ( 'nop' -> NOP | vars ':=' exprs -> ^( LET vars exprs ) | 'if' expression 'then' commands ( 'else' commands )? 'fi' -> ^( IF expression commands ( commands )? ) | 'while' expression 'do' commands 'od' -> ^( WHILE expression commands ) | 'for' expression 'do' commands 'od' -> ^( FOR expression commands ) | 'foreach' Variable 'in' expression 'do' commands 'od' -> ^( FOREACH Variable expression commands ) );
	public final WhileParser.command_return command() throws RecognitionException {
		WhileParser.command_return retval = new WhileParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal29=null;
		Token string_literal31=null;
		Token string_literal33=null;
		Token string_literal35=null;
		Token string_literal37=null;
		Token string_literal39=null;
		Token string_literal40=null;
		Token string_literal42=null;
		Token string_literal44=null;
		Token string_literal45=null;
		Token string_literal47=null;
		Token string_literal49=null;
		Token string_literal50=null;
		Token Variable51=null;
		Token string_literal52=null;
		Token string_literal54=null;
		Token string_literal56=null;
		ParserRuleReturnScope vars30 =null;
		ParserRuleReturnScope exprs32 =null;
		ParserRuleReturnScope expression34 =null;
		ParserRuleReturnScope commands36 =null;
		ParserRuleReturnScope commands38 =null;
		ParserRuleReturnScope expression41 =null;
		ParserRuleReturnScope commands43 =null;
		ParserRuleReturnScope expression46 =null;
		ParserRuleReturnScope commands48 =null;
		ParserRuleReturnScope expression53 =null;
		ParserRuleReturnScope commands55 =null;

		Object string_literal29_tree=null;
		Object string_literal31_tree=null;
		Object string_literal33_tree=null;
		Object string_literal35_tree=null;
		Object string_literal37_tree=null;
		Object string_literal39_tree=null;
		Object string_literal40_tree=null;
		Object string_literal42_tree=null;
		Object string_literal44_tree=null;
		Object string_literal45_tree=null;
		Object string_literal47_tree=null;
		Object string_literal49_tree=null;
		Object string_literal50_tree=null;
		Object Variable51_tree=null;
		Object string_literal52_tree=null;
		Object string_literal54_tree=null;
		Object string_literal56_tree=null;
		RewriteRuleTokenStream stream_46=new RewriteRuleTokenStream(adaptor,"token 46");
		RewriteRuleTokenStream stream_35=new RewriteRuleTokenStream(adaptor,"token 35");
		RewriteRuleTokenStream stream_36=new RewriteRuleTokenStream(adaptor,"token 36");
		RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_37=new RewriteRuleTokenStream(adaptor,"token 37");
		RewriteRuleTokenStream stream_49=new RewriteRuleTokenStream(adaptor,"token 49");
		RewriteRuleTokenStream stream_38=new RewriteRuleTokenStream(adaptor,"token 38");
		RewriteRuleTokenStream stream_39=new RewriteRuleTokenStream(adaptor,"token 39");
		RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_42=new RewriteRuleTokenStream(adaptor,"token 42");
		RewriteRuleTokenStream stream_43=new RewriteRuleTokenStream(adaptor,"token 43");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_exprs=new RewriteRuleSubtreeStream(adaptor,"rule exprs");
		RewriteRuleSubtreeStream stream_vars=new RewriteRuleSubtreeStream(adaptor,"rule vars");
		RewriteRuleSubtreeStream stream_commands=new RewriteRuleSubtreeStream(adaptor,"rule commands");

		try {
			// .\\src\\antlr\\While.g:46:9: ( 'nop' -> NOP | vars ':=' exprs -> ^( LET vars exprs ) | 'if' expression 'then' commands ( 'else' commands )? 'fi' -> ^( IF expression commands ( commands )? ) | 'while' expression 'do' commands 'od' -> ^( WHILE expression commands ) | 'for' expression 'do' commands 'od' -> ^( FOR expression commands ) | 'foreach' Variable 'in' expression 'do' commands 'od' -> ^( FOREACH Variable expression commands ) )
			int alt9=6;
			switch ( input.LA(1) ) {
			case 46:
				{
				alt9=1;
				}
				break;
			case Variable:
				{
				alt9=2;
				}
				break;
			case 42:
				{
				alt9=3;
				}
				break;
			case 51:
				{
				alt9=4;
				}
				break;
			case 38:
				{
				alt9=5;
				}
				break;
			case 39:
				{
				alt9=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// .\\src\\antlr\\While.g:46:11: 'nop'
					{
					string_literal29=(Token)match(input,46,FOLLOW_46_in_command302);  
					stream_46.add(string_literal29);


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
					// 46:17: -> NOP
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NOP, "NOP"));
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// .\\src\\antlr\\While.g:47:9: vars ':=' exprs
					{
					pushFollow(FOLLOW_vars_in_command316);
					vars30=vars();
					state._fsp--;

					stream_vars.add(vars30.getTree());
					string_literal31=(Token)match(input,31,FOLLOW_31_in_command318);  
					stream_31.add(string_literal31);

					pushFollow(FOLLOW_exprs_in_command320);
					exprs32=exprs();
					state._fsp--;

					stream_exprs.add(exprs32.getTree());

					// AST REWRITE
					// elements: vars, exprs
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 47:25: -> ^( LET vars exprs )
					{
						// .\\src\\antlr\\While.g:47:28: ^( LET vars exprs )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LET, "LET"), root_1);
						adaptor.addChild(root_1, stream_vars.nextTree());
						adaptor.addChild(root_1, stream_exprs.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// .\\src\\antlr\\While.g:48:4: 'if' expression 'then' commands ( 'else' commands )? 'fi'
					{
					string_literal33=(Token)match(input,42,FOLLOW_42_in_command335);  
					stream_42.add(string_literal33);

					pushFollow(FOLLOW_expression_in_command337);
					expression34=expression();
					state._fsp--;

					stream_expression.add(expression34.getTree());
					string_literal35=(Token)match(input,49,FOLLOW_49_in_command339);  
					stream_49.add(string_literal35);

					pushFollow(FOLLOW_commands_in_command341);
					commands36=commands();
					state._fsp--;

					stream_commands.add(commands36.getTree());
					// .\\src\\antlr\\While.g:48:36: ( 'else' commands )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==36) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// .\\src\\antlr\\While.g:48:37: 'else' commands
							{
							string_literal37=(Token)match(input,36,FOLLOW_36_in_command344);  
							stream_36.add(string_literal37);

							pushFollow(FOLLOW_commands_in_command346);
							commands38=commands();
							state._fsp--;

							stream_commands.add(commands38.getTree());
							}
							break;

					}

					string_literal39=(Token)match(input,37,FOLLOW_37_in_command350);  
					stream_37.add(string_literal39);


					// AST REWRITE
					// elements: expression, commands, commands
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 48:60: -> ^( IF expression commands ( commands )? )
					{
						// .\\src\\antlr\\While.g:48:63: ^( IF expression commands ( commands )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(IF, "IF"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						// .\\src\\antlr\\While.g:48:88: ( commands )?
						if ( stream_commands.hasNext() ) {
							adaptor.addChild(root_1, stream_commands.nextTree());
						}
						stream_commands.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// .\\src\\antlr\\While.g:49:4: 'while' expression 'do' commands 'od'
					{
					string_literal40=(Token)match(input,51,FOLLOW_51_in_command368);  
					stream_51.add(string_literal40);

					pushFollow(FOLLOW_expression_in_command370);
					expression41=expression();
					state._fsp--;

					stream_expression.add(expression41.getTree());
					string_literal42=(Token)match(input,35,FOLLOW_35_in_command372);  
					stream_35.add(string_literal42);

					pushFollow(FOLLOW_commands_in_command374);
					commands43=commands();
					state._fsp--;

					stream_commands.add(commands43.getTree());
					string_literal44=(Token)match(input,47,FOLLOW_47_in_command376);  
					stream_47.add(string_literal44);


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
					// 49:42: -> ^( WHILE expression commands )
					{
						// .\\src\\antlr\\While.g:49:45: ^( WHILE expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(WHILE, "WHILE"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// .\\src\\antlr\\While.g:50:4: 'for' expression 'do' commands 'od'
					{
					string_literal45=(Token)match(input,38,FOLLOW_38_in_command391);  
					stream_38.add(string_literal45);

					pushFollow(FOLLOW_expression_in_command393);
					expression46=expression();
					state._fsp--;

					stream_expression.add(expression46.getTree());
					string_literal47=(Token)match(input,35,FOLLOW_35_in_command395);  
					stream_35.add(string_literal47);

					pushFollow(FOLLOW_commands_in_command397);
					commands48=commands();
					state._fsp--;

					stream_commands.add(commands48.getTree());
					string_literal49=(Token)match(input,47,FOLLOW_47_in_command399);  
					stream_47.add(string_literal49);


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
					// 50:40: -> ^( FOR expression commands )
					{
						// .\\src\\antlr\\While.g:50:43: ^( FOR expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOR, "FOR"), root_1);
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// .\\src\\antlr\\While.g:51:4: 'foreach' Variable 'in' expression 'do' commands 'od'
					{
					string_literal50=(Token)match(input,39,FOLLOW_39_in_command414);  
					stream_39.add(string_literal50);

					Variable51=(Token)match(input,Variable,FOLLOW_Variable_in_command416);  
					stream_Variable.add(Variable51);

					string_literal52=(Token)match(input,43,FOLLOW_43_in_command418);  
					stream_43.add(string_literal52);

					pushFollow(FOLLOW_expression_in_command420);
					expression53=expression();
					state._fsp--;

					stream_expression.add(expression53.getTree());
					string_literal54=(Token)match(input,35,FOLLOW_35_in_command422);  
					stream_35.add(string_literal54);

					pushFollow(FOLLOW_commands_in_command424);
					commands55=commands();
					state._fsp--;

					stream_commands.add(commands55.getTree());
					string_literal56=(Token)match(input,47,FOLLOW_47_in_command426);  
					stream_47.add(string_literal56);


					// AST REWRITE
					// elements: expression, commands, Variable
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 51:58: -> ^( FOREACH Variable expression commands )
					{
						// .\\src\\antlr\\While.g:51:61: ^( FOREACH Variable expression commands )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(FOREACH, "FOREACH"), root_1);
						adaptor.addChild(root_1, stream_Variable.nextNode());
						adaptor.addChild(root_1, stream_expression.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
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
		return retval;
	}
	// $ANTLR end "command"


	public static class exprBase_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "exprBase"
	// .\\src\\antlr\\While.g:54:1: exprBase : ( '(' 'cons' lexpr ')' -> ^( CONS ( lexpr )? ) | '(' 'list' lexpr ')' -> ^( LIST ( lexpr )? ) | '(' 'hd' exprBase ')' -> ^( HD exprBase ) | '(' 'tl' exprBase ')' -> ^( TL exprBase ) | '(' Symbol lexpr ')' -> ^( SYMB Symbol ( lexpr )? ) | 'nil' -> NIL | Variable -> Variable | Symbol -> Symbol );
	public final WhileParser.exprBase_return exprBase() throws RecognitionException {
		WhileParser.exprBase_return retval = new WhileParser.exprBase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal57=null;
		Token string_literal58=null;
		Token char_literal60=null;
		Token char_literal61=null;
		Token string_literal62=null;
		Token char_literal64=null;
		Token char_literal65=null;
		Token string_literal66=null;
		Token char_literal68=null;
		Token char_literal69=null;
		Token string_literal70=null;
		Token char_literal72=null;
		Token char_literal73=null;
		Token Symbol74=null;
		Token char_literal76=null;
		Token string_literal77=null;
		Token Variable78=null;
		Token Symbol79=null;
		ParserRuleReturnScope lexpr59 =null;
		ParserRuleReturnScope lexpr63 =null;
		ParserRuleReturnScope exprBase67 =null;
		ParserRuleReturnScope exprBase71 =null;
		ParserRuleReturnScope lexpr75 =null;

		Object char_literal57_tree=null;
		Object string_literal58_tree=null;
		Object char_literal60_tree=null;
		Object char_literal61_tree=null;
		Object string_literal62_tree=null;
		Object char_literal64_tree=null;
		Object char_literal65_tree=null;
		Object string_literal66_tree=null;
		Object char_literal68_tree=null;
		Object char_literal69_tree=null;
		Object string_literal70_tree=null;
		Object char_literal72_tree=null;
		Object char_literal73_tree=null;
		Object Symbol74_tree=null;
		Object char_literal76_tree=null;
		Object string_literal77_tree=null;
		Object Variable78_tree=null;
		Object Symbol79_tree=null;
		RewriteRuleTokenStream stream_44=new RewriteRuleTokenStream(adaptor,"token 44");
		RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");
		RewriteRuleTokenStream stream_45=new RewriteRuleTokenStream(adaptor,"token 45");
		RewriteRuleTokenStream stream_Variable=new RewriteRuleTokenStream(adaptor,"token Variable");
		RewriteRuleTokenStream stream_27=new RewriteRuleTokenStream(adaptor,"token 27");
		RewriteRuleTokenStream stream_28=new RewriteRuleTokenStream(adaptor,"token 28");
		RewriteRuleTokenStream stream_Symbol=new RewriteRuleTokenStream(adaptor,"token Symbol");
		RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");
		RewriteRuleTokenStream stream_41=new RewriteRuleTokenStream(adaptor,"token 41");
		RewriteRuleSubtreeStream stream_lexpr=new RewriteRuleSubtreeStream(adaptor,"rule lexpr");
		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try {
			// .\\src\\antlr\\While.g:55:5: ( '(' 'cons' lexpr ')' -> ^( CONS ( lexpr )? ) | '(' 'list' lexpr ')' -> ^( LIST ( lexpr )? ) | '(' 'hd' exprBase ')' -> ^( HD exprBase ) | '(' 'tl' exprBase ')' -> ^( TL exprBase ) | '(' Symbol lexpr ')' -> ^( SYMB Symbol ( lexpr )? ) | 'nil' -> NIL | Variable -> Variable | Symbol -> Symbol )
			int alt10=8;
			switch ( input.LA(1) ) {
			case 27:
				{
				switch ( input.LA(2) ) {
				case 34:
					{
					alt10=1;
					}
					break;
				case 44:
					{
					alt10=2;
					}
					break;
				case 41:
					{
					alt10=3;
					}
					break;
				case 50:
					{
					alt10=4;
					}
					break;
				case Symbol:
					{
					alt10=5;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case 45:
				{
				alt10=6;
				}
				break;
			case Variable:
				{
				alt10=7;
				}
				break;
			case Symbol:
				{
				alt10=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// .\\src\\antlr\\While.g:55:7: '(' 'cons' lexpr ')'
					{
					char_literal57=(Token)match(input,27,FOLLOW_27_in_exprBase451);  
					stream_27.add(char_literal57);

					string_literal58=(Token)match(input,34,FOLLOW_34_in_exprBase453);  
					stream_34.add(string_literal58);

					pushFollow(FOLLOW_lexpr_in_exprBase455);
					lexpr59=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr59.getTree());
					char_literal60=(Token)match(input,28,FOLLOW_28_in_exprBase457);  
					stream_28.add(char_literal60);


					// AST REWRITE
					// elements: lexpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 55:27: -> ^( CONS ( lexpr )? )
					{
						// .\\src\\antlr\\While.g:55:30: ^( CONS ( lexpr )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONS, "CONS"), root_1);
						// .\\src\\antlr\\While.g:55:37: ( lexpr )?
						if ( stream_lexpr.hasNext() ) {
							adaptor.addChild(root_1, stream_lexpr.nextTree());
						}
						stream_lexpr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// .\\src\\antlr\\While.g:55:47: '(' 'list' lexpr ')'
					{
					char_literal61=(Token)match(input,27,FOLLOW_27_in_exprBase469);  
					stream_27.add(char_literal61);

					string_literal62=(Token)match(input,44,FOLLOW_44_in_exprBase471);  
					stream_44.add(string_literal62);

					pushFollow(FOLLOW_lexpr_in_exprBase473);
					lexpr63=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr63.getTree());
					char_literal64=(Token)match(input,28,FOLLOW_28_in_exprBase475);  
					stream_28.add(char_literal64);


					// AST REWRITE
					// elements: lexpr
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 55:67: -> ^( LIST ( lexpr )? )
					{
						// .\\src\\antlr\\While.g:55:70: ^( LIST ( lexpr )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(LIST, "LIST"), root_1);
						// .\\src\\antlr\\While.g:55:77: ( lexpr )?
						if ( stream_lexpr.hasNext() ) {
							adaptor.addChild(root_1, stream_lexpr.nextTree());
						}
						stream_lexpr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// .\\src\\antlr\\While.g:56:7: '(' 'hd' exprBase ')'
					{
					char_literal65=(Token)match(input,27,FOLLOW_27_in_exprBase491);  
					stream_27.add(char_literal65);

					string_literal66=(Token)match(input,41,FOLLOW_41_in_exprBase493);  
					stream_41.add(string_literal66);

					pushFollow(FOLLOW_exprBase_in_exprBase495);
					exprBase67=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase67.getTree());
					char_literal68=(Token)match(input,28,FOLLOW_28_in_exprBase497);  
					stream_28.add(char_literal68);


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
					// 56:28: -> ^( HD exprBase )
					{
						// .\\src\\antlr\\While.g:56:31: ^( HD exprBase )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(HD, "HD"), root_1);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 4 :
					// .\\src\\antlr\\While.g:56:48: '(' 'tl' exprBase ')'
					{
					char_literal69=(Token)match(input,27,FOLLOW_27_in_exprBase508);  
					stream_27.add(char_literal69);

					string_literal70=(Token)match(input,50,FOLLOW_50_in_exprBase510);  
					stream_50.add(string_literal70);

					pushFollow(FOLLOW_exprBase_in_exprBase512);
					exprBase71=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase71.getTree());
					char_literal72=(Token)match(input,28,FOLLOW_28_in_exprBase514);  
					stream_28.add(char_literal72);


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
					// 56:69: -> ^( TL exprBase )
					{
						// .\\src\\antlr\\While.g:56:72: ^( TL exprBase )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TL, "TL"), root_1);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 5 :
					// .\\src\\antlr\\While.g:57:7: '(' Symbol lexpr ')'
					{
					char_literal73=(Token)match(input,27,FOLLOW_27_in_exprBase529);  
					stream_27.add(char_literal73);

					Symbol74=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprBase531);  
					stream_Symbol.add(Symbol74);

					pushFollow(FOLLOW_lexpr_in_exprBase533);
					lexpr75=lexpr();
					state._fsp--;

					stream_lexpr.add(lexpr75.getTree());
					char_literal76=(Token)match(input,28,FOLLOW_28_in_exprBase535);  
					stream_28.add(char_literal76);


					// AST REWRITE
					// elements: lexpr, Symbol
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (Object)adaptor.nil();
					// 57:27: -> ^( SYMB Symbol ( lexpr )? )
					{
						// .\\src\\antlr\\While.g:57:30: ^( SYMB Symbol ( lexpr )? )
						{
						Object root_1 = (Object)adaptor.nil();
						root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SYMB, "SYMB"), root_1);
						adaptor.addChild(root_1, stream_Symbol.nextNode());
						// .\\src\\antlr\\While.g:57:44: ( lexpr )?
						if ( stream_lexpr.hasNext() ) {
							adaptor.addChild(root_1, stream_lexpr.nextTree());
						}
						stream_lexpr.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 6 :
					// .\\src\\antlr\\While.g:58:7: 'nil'
					{
					string_literal77=(Token)match(input,45,FOLLOW_45_in_exprBase553);  
					stream_45.add(string_literal77);


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
					// 58:13: -> NIL
					{
						adaptor.addChild(root_0, (Object)adaptor.create(NIL, "NIL"));
					}


					retval.tree = root_0;

					}
					break;
				case 7 :
					// .\\src\\antlr\\While.g:58:22: Variable
					{
					Variable78=(Token)match(input,Variable,FOLLOW_Variable_in_exprBase561);  
					stream_Variable.add(Variable78);


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
					// 58:30: -> Variable
					{
						adaptor.addChild(root_0, stream_Variable.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 8 :
					// .\\src\\antlr\\While.g:58:44: Symbol
					{
					Symbol79=(Token)match(input,Symbol,FOLLOW_Symbol_in_exprBase568);  
					stream_Symbol.add(Symbol79);


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
					// 58:51: -> Symbol
					{
						adaptor.addChild(root_0, stream_Symbol.nextNode());
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
		return retval;
	}
	// $ANTLR end "exprBase"


	public static class expression_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// .\\src\\antlr\\While.g:62:1: expression : exprBase ( '=?' exprBase )? -> ( exprBase )+ ;
	public final WhileParser.expression_return expression() throws RecognitionException {
		WhileParser.expression_return retval = new WhileParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal81=null;
		ParserRuleReturnScope exprBase80 =null;
		ParserRuleReturnScope exprBase82 =null;

		Object string_literal81_tree=null;
		RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");
		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try {
			// .\\src\\antlr\\While.g:62:12: ( exprBase ( '=?' exprBase )? -> ( exprBase )+ )
			// .\\src\\antlr\\While.g:62:14: exprBase ( '=?' exprBase )?
			{
			pushFollow(FOLLOW_exprBase_in_expression607);
			exprBase80=exprBase();
			state._fsp--;

			stream_exprBase.add(exprBase80.getTree());
			// .\\src\\antlr\\While.g:62:23: ( '=?' exprBase )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==33) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// .\\src\\antlr\\While.g:62:24: '=?' exprBase
					{
					string_literal81=(Token)match(input,33,FOLLOW_33_in_expression610);  
					stream_33.add(string_literal81);

					pushFollow(FOLLOW_exprBase_in_expression612);
					exprBase82=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase82.getTree());
					}
					break;

			}


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
			// 62:39: -> ( exprBase )+
			{
				if ( !(stream_exprBase.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_exprBase.hasNext() ) {
					adaptor.addChild(root_0, stream_exprBase.nextTree());
				}
				stream_exprBase.reset();

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
		return retval;
	}
	// $ANTLR end "expression"


	public static class lexpr_return extends ParserRuleReturnScope {
		Object tree;
		@Override
		public Object getTree() { return tree; }
	};


	// $ANTLR start "lexpr"
	// .\\src\\antlr\\While.g:65:1: lexpr : ( exprBase )* -> ( exprBase )* ;
	public final WhileParser.lexpr_return lexpr() throws RecognitionException {
		WhileParser.lexpr_return retval = new WhileParser.lexpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprBase83 =null;

		RewriteRuleSubtreeStream stream_exprBase=new RewriteRuleSubtreeStream(adaptor,"rule exprBase");

		try {
			// .\\src\\antlr\\While.g:65:7: ( ( exprBase )* -> ( exprBase )* )
			// .\\src\\antlr\\While.g:65:9: ( exprBase )*
			{
			// .\\src\\antlr\\While.g:65:9: ( exprBase )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==Symbol||LA12_0==Variable||LA12_0==27||LA12_0==45) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// .\\src\\antlr\\While.g:65:9: exprBase
					{
					pushFollow(FOLLOW_exprBase_in_lexpr629);
					exprBase83=exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase83.getTree());
					}
					break;

				default :
					break loop12;
				}
			}


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
			// 65:20: -> ( exprBase )*
			{
				// .\\src\\antlr\\While.g:65:23: ( exprBase )*
				while ( stream_exprBase.hasNext() ) {
					adaptor.addChild(root_0, stream_exprBase.nextTree());
				}
				stream_exprBase.reset();

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
		return retval;
	}
	// $ANTLR end "lexpr"

	// Delegated rules



	public static final BitSet FOLLOW_function_in_program99 = new BitSet(new long[]{0x0000010000000002L});
	public static final BitSet FOLLOW_40_in_function117 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Symbol_in_function119 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_30_in_function121 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_definition_in_function123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_48_in_definition141 = new BitSet(new long[]{0x0000000020800000L});
	public static final BitSet FOLLOW_input_in_definition143 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_definition145 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_definition147 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_definition149 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_52_in_definition151 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_output_in_definition153 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inputSub_in_input170 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_inputSub180 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_inputSub184 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Variable_in_inputSub186 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_Variable_in_output204 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_output207 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Variable_in_output209 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_command_in_commands229 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_32_in_commands232 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_command_in_commands234 = new BitSet(new long[]{0x0000000100000002L});
	public static final BitSet FOLLOW_expression_in_exprs255 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_exprs258 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_expression_in_exprs260 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_Variable_in_vars278 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_29_in_vars281 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Variable_in_vars283 = new BitSet(new long[]{0x0000000020000002L});
	public static final BitSet FOLLOW_46_in_command302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_vars_in_command316 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_31_in_command318 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_exprs_in_command320 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_42_in_command335 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_expression_in_command337 = new BitSet(new long[]{0x0002000000000000L});
	public static final BitSet FOLLOW_49_in_command339 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_command341 = new BitSet(new long[]{0x0000003000000000L});
	public static final BitSet FOLLOW_36_in_command344 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_command346 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_37_in_command350 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_51_in_command368 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_expression_in_command370 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_command372 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_command374 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_command376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_38_in_command391 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_expression_in_command393 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_command395 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_command397 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_command399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_39_in_command414 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_Variable_in_command416 = new BitSet(new long[]{0x0000080000000000L});
	public static final BitSet FOLLOW_43_in_command418 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_expression_in_command420 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_35_in_command422 = new BitSet(new long[]{0x000844C000800000L});
	public static final BitSet FOLLOW_commands_in_command424 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_47_in_command426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprBase451 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_34_in_exprBase453 = new BitSet(new long[]{0x0000200018900000L});
	public static final BitSet FOLLOW_lexpr_in_exprBase455 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprBase457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprBase469 = new BitSet(new long[]{0x0000100000000000L});
	public static final BitSet FOLLOW_44_in_exprBase471 = new BitSet(new long[]{0x0000200018900000L});
	public static final BitSet FOLLOW_lexpr_in_exprBase473 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprBase475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprBase491 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_41_in_exprBase493 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase495 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprBase497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprBase508 = new BitSet(new long[]{0x0004000000000000L});
	public static final BitSet FOLLOW_50_in_exprBase510 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_exprBase_in_exprBase512 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprBase514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_27_in_exprBase529 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Symbol_in_exprBase531 = new BitSet(new long[]{0x0000200018900000L});
	public static final BitSet FOLLOW_lexpr_in_exprBase533 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_28_in_exprBase535 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_45_in_exprBase553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Variable_in_exprBase561 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Symbol_in_exprBase568 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprBase_in_expression607 = new BitSet(new long[]{0x0000000200000002L});
	public static final BitSet FOLLOW_33_in_expression610 = new BitSet(new long[]{0x0000200008900000L});
	public static final BitSet FOLLOW_exprBase_in_expression612 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exprBase_in_lexpr629 = new BitSet(new long[]{0x0000200008900002L});
}
