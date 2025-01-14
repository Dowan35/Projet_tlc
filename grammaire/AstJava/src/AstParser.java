// $ANTLR 3.5.3 src/Ast.g 2025-01-11 14:04:15

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;

@SuppressWarnings("all")
public class AstParser extends Parser {
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
	// ajout manuel
	private SymbolTable symbolTable;

	public void setSymbolTable(SymbolTable symbolTable) {
		this.symbolTable = symbolTable;
	}

	public static final int EOF = -1;
	public static final int T__35 = 35;
	public static final int T__36 = 36;
	public static final int T__37 = 37;
	public static final int T__38 = 38;
	public static final int T__39 = 39;
	public static final int T__40 = 40;
	public static final int T__41 = 41;
	public static final int T__42 = 42;
	public static final int T__43 = 43;
	public static final int T__44 = 44;
	public static final int T__45 = 45;
	public static final int T__46 = 46;
	public static final int T__47 = 47;
	public static final int T__48 = 48;
	public static final int T__49 = 49;
	public static final int T__50 = 50;
	public static final int T__51 = 51;
	public static final int T__52 = 52;
	public static final int T__53 = 53;
	public static final int T__54 = 54;
	public static final int T__55 = 55;
	public static final int T__56 = 56;
	public static final int T__57 = 57;
	public static final int T__58 = 58;
	public static final int T__59 = 59;
	public static final int ASSIGN = 4;
	public static final int CALL = 5;
	public static final int COMMANDS = 6;
	public static final int CONS = 7;
	public static final int DEFINITION = 8;
	public static final int ELSE = 9;
	public static final int EXPRESSION = 10;
	public static final int EXPRESSIONS = 11;
	public static final int EXPRS = 12;
	public static final int FOR = 13;
	public static final int FUNCTION = 14;
	public static final int HD = 15;
	public static final int IF = 16;
	public static final int INPUT = 17;
	public static final int INPUTSUB = 18;
	public static final int LEXPR = 19;
	public static final int LIST = 20;
	public static final int NIL = 21;
	public static final int NOP = 22;
	public static final int OUTPUT = 23;
	public static final int OUTPUTS = 24;
	public static final int PROGRAM = 25;
	public static final int SYM = 26;
	public static final int Symbol = 27;
	public static final int TL = 28;
	public static final int TLLIST = 29;
	public static final int VAR = 30;
	public static final int VARS = 31;
	public static final int Variable = 32;
	public static final int WHILE = 33;
	public static final int WS = 34;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators

	public AstParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}

	public AstParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}

	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}

	@Override
	public String[] getTokenNames() {
		return AstParser.tokenNames;
	}

	@Override
	public String getGrammarFileName() {
		return "src/Ast.g";
	}

	public static class program_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "program"
	// src/Ast.g:37:1: program : ( function )+ EOF -> ^( PROGRAM ( function )+ ) ;
	public final AstParser.program_return program() throws RecognitionException {
		AstParser.program_return retval = new AstParser.program_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token EOF2 = null;
		ParserRuleReturnScope function1 = null;

		Object EOF2_tree = null;
		RewriteRuleTokenStream stream_EOF = new RewriteRuleTokenStream(adaptor, "token EOF");
		RewriteRuleSubtreeStream stream_function = new RewriteRuleSubtreeStream(adaptor, "rule function");

		try {
			// src/Ast.g:37:9: ( ( function )+ EOF -> ^( PROGRAM ( function )+ ) )
			// src/Ast.g:37:11: ( function )+ EOF
			{
				// src/Ast.g:37:11: ( function )+
				int cnt1 = 0;
				loop1: while (true) {
					int alt1 = 2;
					int LA1_0 = input.LA(1);
					if ((LA1_0 == 48)) {
						alt1 = 1;
					}

					switch (alt1) {
						case 1:
						// src/Ast.g:37:11: function
						{
							pushFollow(FOLLOW_function_in_program139);
							function1 = function();
							state._fsp--;

							stream_function.add(function1.getTree());
						}
							break;

						default:
							if (cnt1 >= 1)
								break loop1;
							EarlyExitException eee = new EarlyExitException(1, input);
							throw eee;
					}
					cnt1++;
				}

				EOF2 = (Token) match(input, EOF, FOLLOW_EOF_in_program142);
				stream_EOF.add(EOF2);

				// AST REWRITE
				// elements: function
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 37:25: -> ^( PROGRAM ( function )+ )
				{
					// src/Ast.g:37:28: ^( PROGRAM ( function )+ )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(PROGRAM, "PROGRAM"), root_1);
						if (!(stream_function.hasNext())) {
							throw new RewriteEarlyExitException();
						}
						while (stream_function.hasNext()) {
							adaptor.addChild(root_1, stream_function.nextTree());
						}
						stream_function.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "program"

	public static class function_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "function"
	// src/Ast.g:39:1: function : 'function' Symbol ':' definition -> ^( FUNCTION
	// Symbol definition ) ;
	public final AstParser.function_return function() throws RecognitionException {
		AstParser.function_return retval = new AstParser.function_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal3 = null;
		Token Symbol4 = null;
		Token char_literal5 = null;
		ParserRuleReturnScope definition6 = null;

		Object string_literal3_tree = null;
		Object Symbol4_tree = null;
		Object char_literal5_tree = null;
		RewriteRuleTokenStream stream_48 = new RewriteRuleTokenStream(adaptor, "token 48");
		RewriteRuleTokenStream stream_39 = new RewriteRuleTokenStream(adaptor, "token 39");
		RewriteRuleTokenStream stream_Symbol = new RewriteRuleTokenStream(adaptor, "token Symbol");
		RewriteRuleSubtreeStream stream_definition = new RewriteRuleSubtreeStream(adaptor, "rule definition");

		try {
			// src/Ast.g:39:10: ( 'function' Symbol ':' definition -> ^( FUNCTION Symbol
			// definition ) )
			// src/Ast.g:39:12: 'function' Symbol ':' definition
			{
				string_literal3 = (Token) match(input, 48, FOLLOW_48_in_function159);
				stream_48.add(string_literal3);

				Symbol4 = (Token) match(input, Symbol, FOLLOW_Symbol_in_function161);
				stream_Symbol.add(Symbol4);

				char_literal5 = (Token) match(input, 39, FOLLOW_39_in_function163);
				stream_39.add(char_literal5);

				pushFollow(FOLLOW_definition_in_function165);
				definition6 = definition();
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
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 39:45: -> ^( FUNCTION Symbol definition )
				{
					// src/Ast.g:39:48: ^( FUNCTION Symbol definition )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(FUNCTION, "FUNCTION"), root_1);
						adaptor.addChild(root_1, stream_Symbol.nextNode());
						adaptor.addChild(root_1, stream_definition.nextTree());
						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function"

	public static class definition_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "definition"
	// src/Ast.g:41:1: definition : 'read' input '%' commands '%' 'write' output ->
	// ^( DEFINITION input commands output ) ;
	public final AstParser.definition_return definition() throws RecognitionException {
		AstParser.definition_return retval = new AstParser.definition_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal7 = null;
		Token char_literal9 = null;
		Token char_literal11 = null;
		Token string_literal12 = null;
		ParserRuleReturnScope input8 = null;
		ParserRuleReturnScope commands10 = null;
		ParserRuleReturnScope output13 = null;

		Object string_literal7_tree = null;
		Object char_literal9_tree = null;
		Object char_literal11_tree = null;
		Object string_literal12_tree = null;
		RewriteRuleTokenStream stream_55 = new RewriteRuleTokenStream(adaptor, "token 55");
		RewriteRuleTokenStream stream_35 = new RewriteRuleTokenStream(adaptor, "token 35");
		RewriteRuleTokenStream stream_59 = new RewriteRuleTokenStream(adaptor, "token 59");
		RewriteRuleSubtreeStream stream_output = new RewriteRuleSubtreeStream(adaptor, "rule output");
		RewriteRuleSubtreeStream stream_input = new RewriteRuleSubtreeStream(adaptor, "rule input");
		RewriteRuleSubtreeStream stream_commands = new RewriteRuleSubtreeStream(adaptor, "rule commands");

		try {
			// src/Ast.g:41:12: ( 'read' input '%' commands '%' 'write' output -> ^(
			// DEFINITION input commands output ) )
			// src/Ast.g:41:14: 'read' input '%' commands '%' 'write' output
			{
				string_literal7 = (Token) match(input, 55, FOLLOW_55_in_definition183);
				stream_55.add(string_literal7);

				pushFollow(FOLLOW_input_in_definition185);
				input8 = input();
				state._fsp--;

				stream_input.add(input8.getTree());
				char_literal9 = (Token) match(input, 35, FOLLOW_35_in_definition187);
				stream_35.add(char_literal9);

				pushFollow(FOLLOW_commands_in_definition189);
				commands10 = commands();
				state._fsp--;

				stream_commands.add(commands10.getTree());
				char_literal11 = (Token) match(input, 35, FOLLOW_35_in_definition191);
				stream_35.add(char_literal11);

				string_literal12 = (Token) match(input, 59, FOLLOW_59_in_definition193);
				stream_59.add(string_literal12);

				pushFollow(FOLLOW_output_in_definition195);
				output13 = output();
				state._fsp--;

				stream_output.add(output13.getTree());

				// AST REWRITE
				// elements: commands, output, input
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 42:12: -> ^( DEFINITION input commands output )
				{
					// src/Ast.g:42:15: ^( DEFINITION input commands output )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(DEFINITION, "DEFINITION"), root_1);
						adaptor.addChild(root_1, stream_input.nextTree());
						adaptor.addChild(root_1, stream_commands.nextTree());
						adaptor.addChild(root_1, stream_output.nextTree());
						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "definition"

	public static class input_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "input"
	// src/Ast.g:45:1: input : ( inputSub )? -> ^( INPUT ( inputSub )? ) ;
	public final AstParser.input_return input() throws RecognitionException {
		AstParser.input_return retval = new AstParser.input_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope inputSub14 = null;

		RewriteRuleSubtreeStream stream_inputSub = new RewriteRuleSubtreeStream(adaptor, "rule inputSub");

		try {
			// src/Ast.g:45:8: ( ( inputSub )? -> ^( INPUT ( inputSub )? ) )
			// src/Ast.g:45:10: ( inputSub )?
			{
				// src/Ast.g:45:10: ( inputSub )?
				int alt2 = 2;
				int LA2_0 = input.LA(1);
				if ((LA2_0 == Variable)) {
					alt2 = 1;
				}
				switch (alt2) {
					case 1:
					// src/Ast.g:45:10: inputSub
					{
						pushFollow(FOLLOW_inputSub_in_input229);
						inputSub14 = inputSub();
						state._fsp--;

						stream_inputSub.add(inputSub14.getTree());
					}
						break;

				}

				// AST REWRITE
				// elements: inputSub
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 45:20: -> ^( INPUT ( inputSub )? )
				{
					// src/Ast.g:45:23: ^( INPUT ( inputSub )? )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(INPUT, "INPUT"), root_1);
						// src/Ast.g:45:31: ( inputSub )?
						if (stream_inputSub.hasNext()) {
							adaptor.addChild(root_1, stream_inputSub.nextTree());
						}
						stream_inputSub.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "input"

	public static class inputSub_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "inputSub"
	// src/Ast.g:46:1: inputSub : Variable ( ',' Variable )* -> ^( INPUTSUB (
	// Variable )* ) ;
	public final AstParser.inputSub_return inputSub() throws RecognitionException {
		AstParser.inputSub_return retval = new AstParser.inputSub_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable15 = null;
		Token char_literal16 = null;
		Token Variable17 = null;

		Object Variable15_tree = null;
		Object char_literal16_tree = null;
		Object Variable17_tree = null;
		RewriteRuleTokenStream stream_Variable = new RewriteRuleTokenStream(adaptor, "token Variable");
		RewriteRuleTokenStream stream_38 = new RewriteRuleTokenStream(adaptor, "token 38");

		try {
			// src/Ast.g:46:10: ( Variable ( ',' Variable )* -> ^( INPUTSUB ( Variable )* )
			// )
			// src/Ast.g:46:12: Variable ( ',' Variable )*
			{
				Variable15 = (Token) match(input, Variable, FOLLOW_Variable_in_inputSub246);
				stream_Variable.add(Variable15);

				// src/Ast.g:46:21: ( ',' Variable )*
				loop3: while (true) {
					int alt3 = 2;
					int LA3_0 = input.LA(1);
					if ((LA3_0 == 38)) {
						alt3 = 1;
					}

					switch (alt3) {
						case 1:
						// src/Ast.g:46:22: ',' Variable
						{
							char_literal16 = (Token) match(input, 38, FOLLOW_38_in_inputSub249);
							stream_38.add(char_literal16);

							Variable17 = (Token) match(input, Variable, FOLLOW_Variable_in_inputSub251);
							stream_Variable.add(Variable17);

						}
							break;

						default:
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
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 46:37: -> ^( INPUTSUB ( Variable )* )
				{
					// src/Ast.g:46:40: ^( INPUTSUB ( Variable )* )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(INPUTSUB, "INPUTSUB"), root_1);
						// src/Ast.g:46:51: ( Variable )*
						while (stream_Variable.hasNext()) {
							adaptor.addChild(root_1, stream_Variable.nextNode());
						}
						stream_Variable.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "inputSub"

	public static class output_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "output"
	// src/Ast.g:49:1: output : Variable ( ',' Variable )* -> ^( OUTPUT ( Variable
	// )* ) ;
	public final AstParser.output_return output() throws RecognitionException {
		AstParser.output_return retval = new AstParser.output_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable18 = null;
		Token char_literal19 = null;
		Token Variable20 = null;

		Object Variable18_tree = null;
		Object char_literal19_tree = null;
		Object Variable20_tree = null;
		RewriteRuleTokenStream stream_Variable = new RewriteRuleTokenStream(adaptor, "token Variable");
		RewriteRuleTokenStream stream_38 = new RewriteRuleTokenStream(adaptor, "token 38");

		try {
			// src/Ast.g:49:8: ( Variable ( ',' Variable )* -> ^( OUTPUT ( Variable )* ) )
			// src/Ast.g:49:10: Variable ( ',' Variable )*
			{
				Variable18 = (Token) match(input, Variable, FOLLOW_Variable_in_output271);
				stream_Variable.add(Variable18);

				// src/Ast.g:49:19: ( ',' Variable )*
				loop4: while (true) {
					int alt4 = 2;
					int LA4_0 = input.LA(1);
					if ((LA4_0 == 38)) {
						alt4 = 1;
					}

					switch (alt4) {
						case 1:
						// src/Ast.g:49:20: ',' Variable
						{
							char_literal19 = (Token) match(input, 38, FOLLOW_38_in_output274);
							stream_38.add(char_literal19);

							Variable20 = (Token) match(input, Variable, FOLLOW_Variable_in_output276);
							stream_Variable.add(Variable20);

						}
							break;

						default:
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
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 49:35: -> ^( OUTPUT ( Variable )* )
				{
					// src/Ast.g:49:38: ^( OUTPUT ( Variable )* )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(OUTPUT, "OUTPUT"), root_1);
						// src/Ast.g:49:47: ( Variable )*
						while (stream_Variable.hasNext()) {
							adaptor.addChild(root_1, stream_Variable.nextNode());
						}
						stream_Variable.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "output"

	public static class commands_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "commands"
	// src/Ast.g:52:1: commands : command ( ';' commands )? -> ^( COMMANDS ( command
	// )+ ) ;
	public final AstParser.commands_return commands() throws RecognitionException {
		AstParser.commands_return retval = new AstParser.commands_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal22 = null;
		ParserRuleReturnScope command21 = null;
		ParserRuleReturnScope commands23 = null;

		Object char_literal22_tree = null;
		RewriteRuleTokenStream stream_41 = new RewriteRuleTokenStream(adaptor, "token 41");
		RewriteRuleSubtreeStream stream_command = new RewriteRuleSubtreeStream(adaptor, "rule command");
		RewriteRuleSubtreeStream stream_commands = new RewriteRuleSubtreeStream(adaptor, "rule commands");

		try {
			// src/Ast.g:52:10: ( command ( ';' commands )? -> ^( COMMANDS ( command )+ ) )
			// src/Ast.g:52:12: command ( ';' commands )?
			{
				pushFollow(FOLLOW_command_in_commands296);
				command21 = command();
				state._fsp--;

				stream_command.add(command21.getTree());
				// src/Ast.g:52:20: ( ';' commands )?
				int alt5 = 2;
				int LA5_0 = input.LA(1);
				if ((LA5_0 == 41)) {
					alt5 = 1;
				}
				switch (alt5) {
					case 1:
					// src/Ast.g:52:21: ';' commands
					{
						char_literal22 = (Token) match(input, 41, FOLLOW_41_in_commands299);
						stream_41.add(char_literal22);

						pushFollow(FOLLOW_commands_in_commands301);
						commands23 = commands();
						state._fsp--;

						stream_commands.add(commands23.getTree());
					}
						break;

				}

				// AST REWRITE
				// elements: command
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 52:36: -> ^( COMMANDS ( command )+ )
				{
					// src/Ast.g:52:39: ^( COMMANDS ( command )+ )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(COMMANDS, "COMMANDS"), root_1);
						if (!(stream_command.hasNext())) {
							throw new RewriteEarlyExitException();
						}
						while (stream_command.hasNext()) {
							adaptor.addChild(root_1, stream_command.nextTree());
						}
						stream_command.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "commands"

	public static class command_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "command"
	// src/Ast.g:54:1: command : ( 'if' expression 'then' commands ( 'else' commands
	// )? 'fi' -> ^( IF expression commands ( ^( ELSE commands ) )? ) | 'while'
	// expression 'do' commands 'od' -> ^( WHILE expression commands ) | 'for'
	// expression 'do' commands 'od' -> ^( FOR expression commands ) | 'nop' -> ^(
	// NOP ) | vars ':=' expression -> ^( ASSIGN vars expression ) );
	public final AstParser.command_return command() throws RecognitionException {
		AstParser.command_return retval = new AstParser.command_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal24 = null;
		Token string_literal26 = null;
		Token string_literal28 = null;
		Token string_literal30 = null;
		Token string_literal31 = null;
		Token string_literal33 = null;
		Token string_literal35 = null;
		Token string_literal36 = null;
		Token string_literal38 = null;
		Token string_literal40 = null;
		Token string_literal41 = null;
		Token string_literal43 = null;
		ParserRuleReturnScope expression25 = null;
		ParserRuleReturnScope commands27 = null;
		ParserRuleReturnScope commands29 = null;
		ParserRuleReturnScope expression32 = null;
		ParserRuleReturnScope commands34 = null;
		ParserRuleReturnScope expression37 = null;
		ParserRuleReturnScope commands39 = null;
		ParserRuleReturnScope vars42 = null;
		ParserRuleReturnScope expression44 = null;

		Object string_literal24_tree = null;
		Object string_literal26_tree = null;
		Object string_literal28_tree = null;
		Object string_literal30_tree = null;
		Object string_literal31_tree = null;
		Object string_literal33_tree = null;
		Object string_literal35_tree = null;
		Object string_literal36_tree = null;
		Object string_literal38_tree = null;
		Object string_literal40_tree = null;
		Object string_literal41_tree = null;
		Object string_literal43_tree = null;
		RewriteRuleTokenStream stream_44 = new RewriteRuleTokenStream(adaptor, "token 44");
		RewriteRuleTokenStream stream_56 = new RewriteRuleTokenStream(adaptor, "token 56");
		RewriteRuleTokenStream stream_45 = new RewriteRuleTokenStream(adaptor, "token 45");
		RewriteRuleTokenStream stream_46 = new RewriteRuleTokenStream(adaptor, "token 46");
		RewriteRuleTokenStream stream_58 = new RewriteRuleTokenStream(adaptor, "token 58");
		RewriteRuleTokenStream stream_47 = new RewriteRuleTokenStream(adaptor, "token 47");
		RewriteRuleTokenStream stream_50 = new RewriteRuleTokenStream(adaptor, "token 50");
		RewriteRuleTokenStream stream_40 = new RewriteRuleTokenStream(adaptor, "token 40");
		RewriteRuleTokenStream stream_53 = new RewriteRuleTokenStream(adaptor, "token 53");
		RewriteRuleTokenStream stream_54 = new RewriteRuleTokenStream(adaptor, "token 54");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(adaptor, "rule expression");
		RewriteRuleSubtreeStream stream_vars = new RewriteRuleSubtreeStream(adaptor, "rule vars");
		RewriteRuleSubtreeStream stream_commands = new RewriteRuleSubtreeStream(adaptor, "rule commands");

		try {
			// src/Ast.g:55:5: ( 'if' expression 'then' commands ( 'else' commands )? 'fi'
			// -> ^( IF expression commands ( ^( ELSE commands ) )? ) | 'while' expression
			// 'do' commands 'od' -> ^( WHILE expression commands ) | 'for' expression 'do'
			// commands 'od' -> ^( FOR expression commands ) | 'nop' -> ^( NOP ) | vars ':='
			// expression -> ^( ASSIGN vars expression ) )
			int alt7 = 5;
			switch (input.LA(1)) {
				case 50: {
					alt7 = 1;
				}
					break;
				case 58: {
					alt7 = 2;
				}
					break;
				case 47: {
					alt7 = 3;
				}
					break;
				case 53: {
					alt7 = 4;
				}
					break;
				case Variable: {
					alt7 = 5;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 7, 0, input);
					throw nvae;
			}
			switch (alt7) {
				case 1:
				// src/Ast.g:55:7: 'if' expression 'then' commands ( 'else' commands )? 'fi'
				{
					string_literal24 = (Token) match(input, 50, FOLLOW_50_in_command324);
					stream_50.add(string_literal24);

					pushFollow(FOLLOW_expression_in_command326);
					expression25 = expression();
					state._fsp--;

					stream_expression.add(expression25.getTree());
					string_literal26 = (Token) match(input, 56, FOLLOW_56_in_command328);
					stream_56.add(string_literal26);

					pushFollow(FOLLOW_commands_in_command330);
					commands27 = commands();
					state._fsp--;

					stream_commands.add(commands27.getTree());
					// src/Ast.g:55:39: ( 'else' commands )?
					int alt6 = 2;
					int LA6_0 = input.LA(1);
					if ((LA6_0 == 45)) {
						alt6 = 1;
					}
					switch (alt6) {
						case 1:
						// src/Ast.g:55:40: 'else' commands
						{
							string_literal28 = (Token) match(input, 45, FOLLOW_45_in_command333);
							stream_45.add(string_literal28);

							pushFollow(FOLLOW_commands_in_command335);
							commands29 = commands();
							state._fsp--;

							stream_commands.add(commands29.getTree());
						}
							break;

					}

					string_literal30 = (Token) match(input, 46, FOLLOW_46_in_command339);
					stream_46.add(string_literal30);

					// AST REWRITE
					// elements: commands, expression, commands
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 56:7: -> ^( IF expression commands ( ^( ELSE commands ) )? )
					{
						// src/Ast.g:56:10: ^( IF expression commands ( ^( ELSE commands ) )? )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(IF, "IF"), root_1);
							adaptor.addChild(root_1, stream_expression.nextTree());
							adaptor.addChild(root_1, stream_commands.nextTree());
							// src/Ast.g:56:35: ( ^( ELSE commands ) )?
							if (stream_commands.hasNext()) {
								// src/Ast.g:56:35: ^( ELSE commands )
								{
									Object root_2 = (Object) adaptor.nil();
									root_2 = (Object) adaptor.becomeRoot((Object) adaptor.create(ELSE, "ELSE"), root_2);
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
				case 2:
				// src/Ast.g:57:7: 'while' expression 'do' commands 'od'
				{
					string_literal31 = (Token) match(input, 58, FOLLOW_58_in_command370);
					stream_58.add(string_literal31);

					pushFollow(FOLLOW_expression_in_command372);
					expression32 = expression();
					state._fsp--;

					stream_expression.add(expression32.getTree());
					string_literal33 = (Token) match(input, 44, FOLLOW_44_in_command374);
					stream_44.add(string_literal33);

					pushFollow(FOLLOW_commands_in_command376);
					commands34 = commands();
					state._fsp--;

					stream_commands.add(commands34.getTree());
					string_literal35 = (Token) match(input, 54, FOLLOW_54_in_command378);
					stream_54.add(string_literal35);

					// AST REWRITE
					// elements: commands, expression
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 58:7: -> ^( WHILE expression commands )
					{
						// src/Ast.g:58:10: ^( WHILE expression commands )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(WHILE, "WHILE"), root_1);
							adaptor.addChild(root_1, stream_expression.nextTree());
							adaptor.addChild(root_1, stream_commands.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 3:
				// src/Ast.g:59:7: 'for' expression 'do' commands 'od'
				{
					string_literal36 = (Token) match(input, 47, FOLLOW_47_in_command402);
					stream_47.add(string_literal36);

					pushFollow(FOLLOW_expression_in_command404);
					expression37 = expression();
					state._fsp--;

					stream_expression.add(expression37.getTree());
					string_literal38 = (Token) match(input, 44, FOLLOW_44_in_command406);
					stream_44.add(string_literal38);

					pushFollow(FOLLOW_commands_in_command408);
					commands39 = commands();
					state._fsp--;

					stream_commands.add(commands39.getTree());
					string_literal40 = (Token) match(input, 54, FOLLOW_54_in_command410);
					stream_54.add(string_literal40);

					// AST REWRITE
					// elements: commands, expression
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 60:7: -> ^( FOR expression commands )
					{
						// src/Ast.g:60:10: ^( FOR expression commands )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(FOR, "FOR"), root_1);
							adaptor.addChild(root_1, stream_expression.nextTree());
							adaptor.addChild(root_1, stream_commands.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 4:
				// src/Ast.g:61:7: 'nop'
				{
					string_literal41 = (Token) match(input, 53, FOLLOW_53_in_command434);
					stream_53.add(string_literal41);

					// AST REWRITE
					// elements:
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 62:7: -> ^( NOP )
					{
						// src/Ast.g:62:10: ^( NOP )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(NOP, "NOP"), root_1);
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 5:
				// src/Ast.g:63:7: vars ':=' expression
				{
					pushFollow(FOLLOW_vars_in_command454);
					vars42 = vars();
					state._fsp--;

					stream_vars.add(vars42.getTree());
					string_literal43 = (Token) match(input, 40, FOLLOW_40_in_command456);
					stream_40.add(string_literal43);

					pushFollow(FOLLOW_expression_in_command458);
					expression44 = expression();
					state._fsp--;

					stream_expression.add(expression44.getTree());

					// AST REWRITE
					// elements: expression, vars
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 64:7: -> ^( ASSIGN vars expression )
					{
						// src/Ast.g:64:10: ^( ASSIGN vars expression )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(ASSIGN, "ASSIGN"), root_1);
							adaptor.addChild(root_1, stream_vars.nextTree());
							adaptor.addChild(root_1, stream_expression.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "command"

	public static class vars_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "vars"
	// src/Ast.g:68:1: vars : Variable ( ',' Variable )* -> ^( VARS ( Variable )+ )
	// ;
	public final AstParser.vars_return vars() throws RecognitionException {
		AstParser.vars_return retval = new AstParser.vars_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token Variable45 = null;
		Token char_literal46 = null;
		Token Variable47 = null;

		Object Variable45_tree = null;
		Object char_literal46_tree = null;
		Object Variable47_tree = null;
		RewriteRuleTokenStream stream_Variable = new RewriteRuleTokenStream(adaptor, "token Variable");
		RewriteRuleTokenStream stream_38 = new RewriteRuleTokenStream(adaptor, "token 38");

		try {
			// src/Ast.g:68:6: ( Variable ( ',' Variable )* -> ^( VARS ( Variable )+ ) )
			// src/Ast.g:68:8: Variable ( ',' Variable )*
			{
				Variable45 = (Token) match(input, Variable, FOLLOW_Variable_in_vars488);
				stream_Variable.add(Variable45);

				// src/Ast.g:68:17: ( ',' Variable )*
				loop8: while (true) {
					int alt8 = 2;
					int LA8_0 = input.LA(1);
					if ((LA8_0 == 38)) {
						alt8 = 1;
					}

					switch (alt8) {
						case 1:
						// src/Ast.g:68:18: ',' Variable
						{
							char_literal46 = (Token) match(input, 38, FOLLOW_38_in_vars491);
							stream_38.add(char_literal46);

							Variable47 = (Token) match(input, Variable, FOLLOW_Variable_in_vars493);
							stream_Variable.add(Variable47);

						}
							break;

						default:
							break loop8;
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
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 68:33: -> ^( VARS ( Variable )+ )
				{
					// src/Ast.g:68:36: ^( VARS ( Variable )+ )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(VARS, "VARS"), root_1);
						if (!(stream_Variable.hasNext())) {
							throw new RewriteEarlyExitException();
						}
						while (stream_Variable.hasNext()) {
							adaptor.addChild(root_1, stream_Variable.nextNode());
						}
						stream_Variable.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "vars"

	public static class exprs_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "exprs"
	// src/Ast.g:71:1: exprs : expression ( ',' expression )* -> ^( EXPRS (
	// expression )+ ) ;
	public final AstParser.exprs_return exprs() throws RecognitionException {
		AstParser.exprs_return retval = new AstParser.exprs_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal49 = null;
		ParserRuleReturnScope expression48 = null;
		ParserRuleReturnScope expression50 = null;

		Object char_literal49_tree = null;
		RewriteRuleTokenStream stream_38 = new RewriteRuleTokenStream(adaptor, "token 38");
		RewriteRuleSubtreeStream stream_expression = new RewriteRuleSubtreeStream(adaptor, "rule expression");

		try {
			// src/Ast.g:71:7: ( expression ( ',' expression )* -> ^( EXPRS ( expression )+
			// ) )
			// src/Ast.g:71:9: expression ( ',' expression )*
			{
				pushFollow(FOLLOW_expression_in_exprs513);
				expression48 = expression();
				state._fsp--;

				stream_expression.add(expression48.getTree());
				// src/Ast.g:71:20: ( ',' expression )*
				loop9: while (true) {
					int alt9 = 2;
					int LA9_0 = input.LA(1);
					if ((LA9_0 == 38)) {
						alt9 = 1;
					}

					switch (alt9) {
						case 1:
						// src/Ast.g:71:21: ',' expression
						{
							char_literal49 = (Token) match(input, 38, FOLLOW_38_in_exprs516);
							stream_38.add(char_literal49);

							pushFollow(FOLLOW_expression_in_exprs518);
							expression50 = expression();
							state._fsp--;

							stream_expression.add(expression50.getTree());
						}
							break;

						default:
							break loop9;
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
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 71:38: -> ^( EXPRS ( expression )+ )
				{
					// src/Ast.g:71:41: ^( EXPRS ( expression )+ )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(EXPRS, "EXPRS"), root_1);
						if (!(stream_expression.hasNext())) {
							throw new RewriteEarlyExitException();
						}
						while (stream_expression.hasNext()) {
							adaptor.addChild(root_1, stream_expression.nextTree());
						}
						stream_expression.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprs"

	public static class expression_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "expression"
	// src/Ast.g:74:1: expression : exprBase ( '=?' exprBase )? -> ^( EXPRESSION
	// exprBase ( '=?' exprBase )? ) ;
	public final AstParser.expression_return expression() throws RecognitionException {
		AstParser.expression_return retval = new AstParser.expression_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token string_literal52 = null;
		ParserRuleReturnScope exprBase51 = null;
		ParserRuleReturnScope exprBase53 = null;

		Object string_literal52_tree = null;
		RewriteRuleTokenStream stream_42 = new RewriteRuleTokenStream(adaptor, "token 42");
		RewriteRuleSubtreeStream stream_exprBase = new RewriteRuleSubtreeStream(adaptor, "rule exprBase");

		try {
			// src/Ast.g:74:12: ( exprBase ( '=?' exprBase )? -> ^( EXPRESSION exprBase (
			// '=?' exprBase )? ) )
			// src/Ast.g:74:14: exprBase ( '=?' exprBase )?
			{
				pushFollow(FOLLOW_exprBase_in_expression538);
				exprBase51 = exprBase();
				state._fsp--;

				stream_exprBase.add(exprBase51.getTree());
				// src/Ast.g:74:23: ( '=?' exprBase )?
				int alt10 = 2;
				int LA10_0 = input.LA(1);
				if ((LA10_0 == 42)) {
					alt10 = 1;
				}
				switch (alt10) {
					case 1:
					// src/Ast.g:74:24: '=?' exprBase
					{
						string_literal52 = (Token) match(input, 42, FOLLOW_42_in_expression541);
						stream_42.add(string_literal52);

						pushFollow(FOLLOW_exprBase_in_expression543);
						exprBase53 = exprBase();
						state._fsp--;

						stream_exprBase.add(exprBase53.getTree());
					}
						break;

				}

				// AST REWRITE
				// elements: 42, exprBase, exprBase
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 75:12: -> ^( EXPRESSION exprBase ( '=?' exprBase )? )
				{
					// src/Ast.g:75:15: ^( EXPRESSION exprBase ( '=?' exprBase )? )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(EXPRESSION, "EXPRESSION"), root_1);
						adaptor.addChild(root_1, stream_exprBase.nextTree());
						// src/Ast.g:75:37: ( '=?' exprBase )?
						if (stream_42.hasNext() || stream_exprBase.hasNext()) {
							adaptor.addChild(root_1, stream_42.nextNode());
							adaptor.addChild(root_1, stream_exprBase.nextTree());
						}
						stream_42.reset();
						stream_exprBase.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"

	public static class exprBase_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "exprBase"
	// src/Ast.g:78:1: exprBase : ( '(' 'cons' lExpr ')' -> ^( CONS lExpr ) | '('
	// 'list' lExpr ')' -> ^( LIST lExpr ) | '(' 'hd' exprBase ')' -> ^( HD exprBase
	// ) | '(' 'tl' exprBase ')' -> ^( TL exprBase ) | '(' Symbol lExpr ')' -> ^(
	// CALL Symbol lExpr ) | 'nil' -> ^( NIL ) | Variable -> ^( VAR Variable ) |
	// Symbol -> ^( SYM Symbol ) );
	public final AstParser.exprBase_return exprBase() throws RecognitionException {
		AstParser.exprBase_return retval = new AstParser.exprBase_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		Token char_literal54 = null;
		Token string_literal55 = null;
		Token char_literal57 = null;
		Token char_literal58 = null;
		Token string_literal59 = null;
		Token char_literal61 = null;
		Token char_literal62 = null;
		Token string_literal63 = null;
		Token char_literal65 = null;
		Token char_literal66 = null;
		Token string_literal67 = null;
		Token char_literal69 = null;
		Token char_literal70 = null;
		Token Symbol71 = null;
		Token char_literal73 = null;
		Token string_literal74 = null;
		Token Variable75 = null;
		Token Symbol76 = null;
		ParserRuleReturnScope lExpr56 = null;
		ParserRuleReturnScope lExpr60 = null;
		ParserRuleReturnScope exprBase64 = null;
		ParserRuleReturnScope exprBase68 = null;
		ParserRuleReturnScope lExpr72 = null;

		Object char_literal54_tree = null;
		Object string_literal55_tree = null;
		Object char_literal57_tree = null;
		Object char_literal58_tree = null;
		Object string_literal59_tree = null;
		Object char_literal61_tree = null;
		Object char_literal62_tree = null;
		Object string_literal63_tree = null;
		Object char_literal65_tree = null;
		Object char_literal66_tree = null;
		Object string_literal67_tree = null;
		Object char_literal69_tree = null;
		Object char_literal70_tree = null;
		Object Symbol71_tree = null;
		Object char_literal73_tree = null;
		Object string_literal74_tree = null;
		Object Variable75_tree = null;
		Object Symbol76_tree = null;
		RewriteRuleTokenStream stream_57 = new RewriteRuleTokenStream(adaptor, "token 57");
		RewriteRuleTokenStream stream_36 = new RewriteRuleTokenStream(adaptor, "token 36");
		RewriteRuleTokenStream stream_Variable = new RewriteRuleTokenStream(adaptor, "token Variable");
		RewriteRuleTokenStream stream_37 = new RewriteRuleTokenStream(adaptor, "token 37");
		RewriteRuleTokenStream stream_49 = new RewriteRuleTokenStream(adaptor, "token 49");
		RewriteRuleTokenStream stream_Symbol = new RewriteRuleTokenStream(adaptor, "token Symbol");
		RewriteRuleTokenStream stream_51 = new RewriteRuleTokenStream(adaptor, "token 51");
		RewriteRuleTokenStream stream_52 = new RewriteRuleTokenStream(adaptor, "token 52");
		RewriteRuleTokenStream stream_43 = new RewriteRuleTokenStream(adaptor, "token 43");
		RewriteRuleSubtreeStream stream_exprBase = new RewriteRuleSubtreeStream(adaptor, "rule exprBase");
		RewriteRuleSubtreeStream stream_lExpr = new RewriteRuleSubtreeStream(adaptor, "rule lExpr");

		try {
			// src/Ast.g:79:5: ( '(' 'cons' lExpr ')' -> ^( CONS lExpr ) | '(' 'list' lExpr
			// ')' -> ^( LIST lExpr ) | '(' 'hd' exprBase ')' -> ^( HD exprBase ) | '(' 'tl'
			// exprBase ')' -> ^( TL exprBase ) | '(' Symbol lExpr ')' -> ^( CALL Symbol
			// lExpr ) | 'nil' -> ^( NIL ) | Variable -> ^( VAR Variable ) | Symbol -> ^(
			// SYM Symbol ) )
			int alt11 = 8;
			switch (input.LA(1)) {
				case 36: {
					switch (input.LA(2)) {
						case 43: {
							alt11 = 1;
						}
							break;
						case 51: {
							alt11 = 2;
						}
							break;
						case 49: {
							alt11 = 3;
						}
							break;
						case 57: {
							alt11 = 4;
						}
							break;
						case Symbol: {
							alt11 = 5;
						}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae = new NoViableAltException("", 11, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
					}
				}
					break;
				case 52: {
					alt11 = 6;
				}
					break;
				case Variable: {
					alt11 = 7;
				}
					break;
				case Symbol: {
					alt11 = 8;
				}
					break;
				default:
					NoViableAltException nvae = new NoViableAltException("", 11, 0, input);
					throw nvae;
			}
			switch (alt11) {
				case 1:
				// src/Ast.g:79:7: '(' 'cons' lExpr ')'
				{
					char_literal54 = (Token) match(input, 36, FOLLOW_36_in_exprBase585);
					stream_36.add(char_literal54);

					string_literal55 = (Token) match(input, 43, FOLLOW_43_in_exprBase587);
					stream_43.add(string_literal55);

					pushFollow(FOLLOW_lExpr_in_exprBase589);
					lExpr56 = lExpr();
					state._fsp--;

					stream_lExpr.add(lExpr56.getTree());
					char_literal57 = (Token) match(input, 37, FOLLOW_37_in_exprBase591);
					stream_37.add(char_literal57);

					// AST REWRITE
					// elements: lExpr
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 79:28: -> ^( CONS lExpr )
					{
						// src/Ast.g:79:31: ^( CONS lExpr )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(CONS, "CONS"), root_1);
							adaptor.addChild(root_1, stream_lExpr.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 2:
				// src/Ast.g:80:7: '(' 'list' lExpr ')'
				{
					char_literal58 = (Token) match(input, 36, FOLLOW_36_in_exprBase607);
					stream_36.add(char_literal58);

					string_literal59 = (Token) match(input, 51, FOLLOW_51_in_exprBase609);
					stream_51.add(string_literal59);

					pushFollow(FOLLOW_lExpr_in_exprBase611);
					lExpr60 = lExpr();
					state._fsp--;

					stream_lExpr.add(lExpr60.getTree());
					char_literal61 = (Token) match(input, 37, FOLLOW_37_in_exprBase613);
					stream_37.add(char_literal61);

					// AST REWRITE
					// elements: lExpr
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 80:28: -> ^( LIST lExpr )
					{
						// src/Ast.g:80:31: ^( LIST lExpr )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(LIST, "LIST"), root_1);
							adaptor.addChild(root_1, stream_lExpr.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 3:
				// src/Ast.g:81:7: '(' 'hd' exprBase ')'
				{
					char_literal62 = (Token) match(input, 36, FOLLOW_36_in_exprBase629);
					stream_36.add(char_literal62);

					string_literal63 = (Token) match(input, 49, FOLLOW_49_in_exprBase631);
					stream_49.add(string_literal63);

					pushFollow(FOLLOW_exprBase_in_exprBase633);
					exprBase64 = exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase64.getTree());
					char_literal65 = (Token) match(input, 37, FOLLOW_37_in_exprBase635);
					stream_37.add(char_literal65);

					// AST REWRITE
					// elements: exprBase
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 81:29: -> ^( HD exprBase )
					{
						// src/Ast.g:81:32: ^( HD exprBase )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(HD, "HD"), root_1);
							adaptor.addChild(root_1, stream_exprBase.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 4:
				// src/Ast.g:82:7: '(' 'tl' exprBase ')'
				{
					char_literal66 = (Token) match(input, 36, FOLLOW_36_in_exprBase651);
					stream_36.add(char_literal66);

					string_literal67 = (Token) match(input, 57, FOLLOW_57_in_exprBase653);
					stream_57.add(string_literal67);

					pushFollow(FOLLOW_exprBase_in_exprBase655);
					exprBase68 = exprBase();
					state._fsp--;

					stream_exprBase.add(exprBase68.getTree());
					char_literal69 = (Token) match(input, 37, FOLLOW_37_in_exprBase657);
					stream_37.add(char_literal69);

					// AST REWRITE
					// elements: exprBase
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 82:29: -> ^( TL exprBase )
					{
						// src/Ast.g:82:32: ^( TL exprBase )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(TL, "TL"), root_1);
							adaptor.addChild(root_1, stream_exprBase.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 5:
				// src/Ast.g:83:7: '(' Symbol lExpr ')'
				{
					char_literal70 = (Token) match(input, 36, FOLLOW_36_in_exprBase673);
					stream_36.add(char_literal70);

					Symbol71 = (Token) match(input, Symbol, FOLLOW_Symbol_in_exprBase675);
					stream_Symbol.add(Symbol71);

					pushFollow(FOLLOW_lExpr_in_exprBase677);
					lExpr72 = lExpr();
					state._fsp--;

					stream_lExpr.add(lExpr72.getTree());
					char_literal73 = (Token) match(input, 37, FOLLOW_37_in_exprBase679);
					stream_37.add(char_literal73);

					// AST REWRITE
					// elements: lExpr, Symbol
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 83:28: -> ^( CALL Symbol lExpr )
					{
						// src/Ast.g:83:31: ^( CALL Symbol lExpr )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(CALL, "CALL"), root_1);
							adaptor.addChild(root_1, stream_Symbol.nextNode());
							adaptor.addChild(root_1, stream_lExpr.nextTree());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 6:
				// src/Ast.g:84:7: 'nil'
				{
					string_literal74 = (Token) match(input, 52, FOLLOW_52_in_exprBase697);
					stream_52.add(string_literal74);

					// AST REWRITE
					// elements:
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 84:13: -> ^( NIL )
					{
						// src/Ast.g:84:16: ^( NIL )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(NIL, "NIL"), root_1);
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 7:
				// src/Ast.g:85:7: Variable
				{
					Variable75 = (Token) match(input, Variable, FOLLOW_Variable_in_exprBase711);
					stream_Variable.add(Variable75);

					// AST REWRITE
					// elements: Variable
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 85:16: -> ^( VAR Variable )
					{
						// src/Ast.g:85:19: ^( VAR Variable )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(VAR, "VAR"), root_1);
							adaptor.addChild(root_1, stream_Variable.nextNode());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;
				case 8:
				// src/Ast.g:86:7: Symbol
				{
					Symbol76 = (Token) match(input, Symbol, FOLLOW_Symbol_in_exprBase727);
					stream_Symbol.add(Symbol76);

					// AST REWRITE
					// elements: Symbol
					// token labels:
					// rule labels: retval
					// token list labels:
					// rule list labels:
					// wildcard labels:
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
							retval != null ? retval.getTree() : null);

					root_0 = (Object) adaptor.nil();
					// 86:14: -> ^( SYM Symbol )
					{
						// src/Ast.g:86:17: ^( SYM Symbol )
						{
							Object root_1 = (Object) adaptor.nil();
							root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(SYM, "SYM"), root_1);
							adaptor.addChild(root_1, stream_Symbol.nextNode());
							adaptor.addChild(root_0, root_1);
						}

					}

					retval.tree = root_0;

				}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exprBase"

	public static class lExpr_return extends ParserRuleReturnScope {
		Object tree;

		@Override
		public Object getTree() {
			return tree;
		}
	};

	// $ANTLR start "lExpr"
	// src/Ast.g:90:1: lExpr : ( exprBase )+ -> ^( LEXPR ( exprBase )+ ) ;
	public final AstParser.lExpr_return lExpr() throws RecognitionException {
		AstParser.lExpr_return retval = new AstParser.lExpr_return();
		retval.start = input.LT(1);

		Object root_0 = null;

		ParserRuleReturnScope exprBase77 = null;

		RewriteRuleSubtreeStream stream_exprBase = new RewriteRuleSubtreeStream(adaptor, "rule exprBase");

		try {
			// src/Ast.g:90:7: ( ( exprBase )+ -> ^( LEXPR ( exprBase )+ ) )
			// src/Ast.g:90:9: ( exprBase )+
			{
				// src/Ast.g:90:9: ( exprBase )+
				int cnt12 = 0;
				loop12: while (true) {
					int alt12 = 2;
					int LA12_0 = input.LA(1);
					if ((LA12_0 == Symbol || LA12_0 == Variable || LA12_0 == 36 || LA12_0 == 52)) {
						alt12 = 1;
					}

					switch (alt12) {
						case 1:
						// src/Ast.g:90:9: exprBase
						{
							pushFollow(FOLLOW_exprBase_in_lExpr749);
							exprBase77 = exprBase();
							state._fsp--;

							stream_exprBase.add(exprBase77.getTree());
						}
							break;

						default:
							if (cnt12 >= 1)
								break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
					}
					cnt12++;
				}

				// AST REWRITE
				// elements: exprBase
				// token labels:
				// rule labels: retval
				// token list labels:
				// rule list labels:
				// wildcard labels:
				retval.tree = root_0;
				RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
						retval != null ? retval.getTree() : null);

				root_0 = (Object) adaptor.nil();
				// 90:19: -> ^( LEXPR ( exprBase )+ )
				{
					// src/Ast.g:90:22: ^( LEXPR ( exprBase )+ )
					{
						Object root_1 = (Object) adaptor.nil();
						root_1 = (Object) adaptor.becomeRoot((Object) adaptor.create(LEXPR, "LEXPR"), root_1);
						if (!(stream_exprBase.hasNext())) {
							throw new RewriteEarlyExitException();
						}
						while (stream_exprBase.hasNext()) {
							adaptor.addChild(root_1, stream_exprBase.nextTree());
						}
						stream_exprBase.reset();

						adaptor.addChild(root_0, root_1);
					}

				}

				retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (Object) adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		} catch (RecognitionException re) {
			reportError(re);
			recover(input, re);
			retval.tree = (Object) adaptor.errorNode(input, retval.start, input.LT(-1), re);
		} finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lExpr"

	// Delegated rules

	public static final BitSet FOLLOW_function_in_program139 = new BitSet(new long[] { 0x0001000000000000L });
	public static final BitSet FOLLOW_EOF_in_program142 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_48_in_function159 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_Symbol_in_function161 = new BitSet(new long[] { 0x0000008000000000L });
	public static final BitSet FOLLOW_39_in_function163 = new BitSet(new long[] { 0x0080000000000000L });
	public static final BitSet FOLLOW_definition_in_function165 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_55_in_definition183 = new BitSet(new long[] { 0x0000000900000000L });
	public static final BitSet FOLLOW_input_in_definition185 = new BitSet(new long[] { 0x0000000800000000L });
	public static final BitSet FOLLOW_35_in_definition187 = new BitSet(new long[] { 0x0424800100000000L });
	public static final BitSet FOLLOW_commands_in_definition189 = new BitSet(new long[] { 0x0000000800000000L });
	public static final BitSet FOLLOW_35_in_definition191 = new BitSet(new long[] { 0x0800000000000000L });
	public static final BitSet FOLLOW_59_in_definition193 = new BitSet(new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_output_in_definition195 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_inputSub_in_input229 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_Variable_in_inputSub246 = new BitSet(new long[] { 0x0000004000000002L });
	public static final BitSet FOLLOW_38_in_inputSub249 = new BitSet(new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_Variable_in_inputSub251 = new BitSet(new long[] { 0x0000004000000002L });
	public static final BitSet FOLLOW_Variable_in_output271 = new BitSet(new long[] { 0x0000004000000002L });
	public static final BitSet FOLLOW_38_in_output274 = new BitSet(new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_Variable_in_output276 = new BitSet(new long[] { 0x0000004000000002L });
	public static final BitSet FOLLOW_command_in_commands296 = new BitSet(new long[] { 0x0000020000000002L });
	public static final BitSet FOLLOW_41_in_commands299 = new BitSet(new long[] { 0x0424800100000000L });
	public static final BitSet FOLLOW_commands_in_commands301 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_50_in_command324 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_expression_in_command326 = new BitSet(new long[] { 0x0100000000000000L });
	public static final BitSet FOLLOW_56_in_command328 = new BitSet(new long[] { 0x0424800100000000L });
	public static final BitSet FOLLOW_commands_in_command330 = new BitSet(new long[] { 0x0000600000000000L });
	public static final BitSet FOLLOW_45_in_command333 = new BitSet(new long[] { 0x0424800100000000L });
	public static final BitSet FOLLOW_commands_in_command335 = new BitSet(new long[] { 0x0000400000000000L });
	public static final BitSet FOLLOW_46_in_command339 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_58_in_command370 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_expression_in_command372 = new BitSet(new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_44_in_command374 = new BitSet(new long[] { 0x0424800100000000L });
	public static final BitSet FOLLOW_commands_in_command376 = new BitSet(new long[] { 0x0040000000000000L });
	public static final BitSet FOLLOW_54_in_command378 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_47_in_command402 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_expression_in_command404 = new BitSet(new long[] { 0x0000100000000000L });
	public static final BitSet FOLLOW_44_in_command406 = new BitSet(new long[] { 0x0424800100000000L });
	public static final BitSet FOLLOW_commands_in_command408 = new BitSet(new long[] { 0x0040000000000000L });
	public static final BitSet FOLLOW_54_in_command410 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_53_in_command434 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_vars_in_command454 = new BitSet(new long[] { 0x0000010000000000L });
	public static final BitSet FOLLOW_40_in_command456 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_expression_in_command458 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_Variable_in_vars488 = new BitSet(new long[] { 0x0000004000000002L });
	public static final BitSet FOLLOW_38_in_vars491 = new BitSet(new long[] { 0x0000000100000000L });
	public static final BitSet FOLLOW_Variable_in_vars493 = new BitSet(new long[] { 0x0000004000000002L });
	public static final BitSet FOLLOW_expression_in_exprs513 = new BitSet(new long[] { 0x0000004000000002L });
	public static final BitSet FOLLOW_38_in_exprs516 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_expression_in_exprs518 = new BitSet(new long[] { 0x0000004000000002L });
	public static final BitSet FOLLOW_exprBase_in_expression538 = new BitSet(new long[] { 0x0000040000000002L });
	public static final BitSet FOLLOW_42_in_expression541 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_exprBase_in_expression543 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_36_in_exprBase585 = new BitSet(new long[] { 0x0000080000000000L });
	public static final BitSet FOLLOW_43_in_exprBase587 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_lExpr_in_exprBase589 = new BitSet(new long[] { 0x0000002000000000L });
	public static final BitSet FOLLOW_37_in_exprBase591 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_36_in_exprBase607 = new BitSet(new long[] { 0x0008000000000000L });
	public static final BitSet FOLLOW_51_in_exprBase609 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_lExpr_in_exprBase611 = new BitSet(new long[] { 0x0000002000000000L });
	public static final BitSet FOLLOW_37_in_exprBase613 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_36_in_exprBase629 = new BitSet(new long[] { 0x0002000000000000L });
	public static final BitSet FOLLOW_49_in_exprBase631 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_exprBase_in_exprBase633 = new BitSet(new long[] { 0x0000002000000000L });
	public static final BitSet FOLLOW_37_in_exprBase635 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_36_in_exprBase651 = new BitSet(new long[] { 0x0200000000000000L });
	public static final BitSet FOLLOW_57_in_exprBase653 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_exprBase_in_exprBase655 = new BitSet(new long[] { 0x0000002000000000L });
	public static final BitSet FOLLOW_37_in_exprBase657 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_36_in_exprBase673 = new BitSet(new long[] { 0x0000000008000000L });
	public static final BitSet FOLLOW_Symbol_in_exprBase675 = new BitSet(new long[] { 0x0010001108000000L });
	public static final BitSet FOLLOW_lExpr_in_exprBase677 = new BitSet(new long[] { 0x0000002000000000L });
	public static final BitSet FOLLOW_37_in_exprBase679 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_52_in_exprBase697 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_Variable_in_exprBase711 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_Symbol_in_exprBase727 = new BitSet(new long[] { 0x0000000000000002L });
	public static final BitSet FOLLOW_exprBase_in_lExpr749 = new BitSet(new long[] { 0x0010001108000002L });
}
