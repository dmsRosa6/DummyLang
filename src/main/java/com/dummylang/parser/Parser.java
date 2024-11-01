package com.dummylang.parser;
/* Parser.java */
/* Generated By:JavaCC: Do not edit this line. Parser.java */
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import com.dummylang.values.*;
import com.monke.ast.*;

public class Parser implements ParserConstants {
    public Parser() {}

  static final public ASTNode Start() throws ParseException {ASTNode t;
    t = S();
    jj_consume_token(FINAL);
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode S() throws ParseException {ASTNode t1, t2;
    t1 = SS();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case SEMCOL:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      jj_consume_token(SEMCOL);
      t2 = SS();
t1 = new ASTSemCol(t1, t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode SS() throws ParseException {ASTNode t1;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LBRA:{
      jj_consume_token(LBRA);
      t1 = S();
      jj_consume_token(RBRA);
t1 = new ASTEnv(t1);
      break;
      }
    case FUN:
    case WHILE:
    case IF:
    case BOOLEAN:
    case VAR:
    case CONST:
    case REF:
    case PRINTLN:
    case ID:
    case INT:
    case FLOAT:
    case NOT:
    case MINUS:
    case LPAR:
    case STRING:{
      t1 = SE();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode SE() throws ParseException {Token op, n;
  ASTNode t1, t2;
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ID:{
      n = jj_consume_token(ID);
      jj_consume_token(ASSIGN);
      t2 = BA();
t1 = new ASTAssign(new ASTId(n.image), t2);
      break;
      }
    case VAR:
    case CONST:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case VAR:{
        op = jj_consume_token(VAR);
        break;
        }
      case CONST:{
        op = jj_consume_token(CONST);
        break;
        }
      default:
        jj_la1[2] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      n = jj_consume_token(ID);
      jj_consume_token(ASSIGN);
      t2 = BA();
t1 = new ASTCreate(op.image, new ASTId(n.image), t2);
      break;
      }
    case FUN:
    case WHILE:
    case IF:
    case BOOLEAN:
    case REF:
    case PRINTLN:
    case INT:
    case FLOAT:
    case NOT:
    case MINUS:
    case LPAR:
    case STRING:{
      t1 = BA();
      break;
      }
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode BA() throws ParseException {Token op;
    ASTNode t1, t2;
    t1 = BM();
    label_2:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_2;
      }
      op = jj_consume_token(OR);
      t2 = BM();
t1 = new ASTOr(t1,t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode BM() throws ParseException {Token op;
    ASTNode t1, t2;
    t1 = Relop();
    label_3:
    while (true) {
      if (jj_2_2(2)) {
        ;
      } else {
        break label_3;
      }
      op = jj_consume_token(AND);
      t2 = Relop();
t1 = new ASTAnd(t1,t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode Relop() throws ParseException {Token op;
    ASTNode t1, t2;
    t1 = Exp();
    if (jj_2_3(2)) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case GREATER:{
        op = jj_consume_token(GREATER);
        break;
        }
      case LOWER:{
        op = jj_consume_token(LOWER);
        break;
        }
      case LOWEROREQUAL:{
        op = jj_consume_token(LOWEROREQUAL);
        break;
        }
      case GREATEROREQUAL:{
        op = jj_consume_token(GREATEROREQUAL);
        break;
        }
      case LOGICALEQUAL:{
        op = jj_consume_token(LOGICALEQUAL);
        break;
        }
      default:
        jj_la1[4] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = Exp();
switch (op.kind){
                    case GREATER:
                        t1 = new ASTGreater(t1,t2);
                    break;
                    case LOWER:
                        t1 = new ASTLower(t1,t2);
                    break;
                    case LOWEROREQUAL:
                        t1 = new ASTLowerOrEqual(t1,t2);
                    break;
                    case GREATEROREQUAL:
                        t1 = new ASTGreaterOrEqual(t1,t2);
                    break;
                     case LOGICALEQUAL:
                        t1 = new ASTLogicalEqual(t1,t2);
                    break;
                    default:
                        }
    } else {
      ;
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode Exp() throws ParseException {Token op;
  ASTNode t1, t2;
    t1 = Term();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:
      case MINUS:{
        ;
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        break label_4;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        op = jj_consume_token(PLUS);
        break;
        }
      case MINUS:{
        op = jj_consume_token(MINUS);
        break;
        }
      default:
        jj_la1[6] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = Term();
if (op.kind == PLUS)
               t1 = new ASTPlus(t1, t2);
           else
               t1 = new ASTSub(t1, t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode Term() throws ParseException {Token op;
  ASTNode t1, t2;
    t1 = Fact();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:
      case DIV:{
        ;
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        break label_5;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case TIMES:{
        op = jj_consume_token(TIMES);
        break;
        }
      case DIV:{
        op = jj_consume_token(DIV);
        break;
        }
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      t2 = Term();
if (op.kind == TIMES)
                                t1 = new ASTTimes(t1,t2);
                else
                        t1 = new ASTDiv(t1,t2);
    }
{if ("" != null) return t1;}
    throw new Error("Missing return statement in function");
}

  static final public ASTNode Fact() throws ParseException {Token n,n2;
  ASTNode t, t1,t2;
  Map<String, ASTNode> l = new HashMap<>();
  List<String> params = new ArrayList<>();
  List<ASTNode> values = new ArrayList<>();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case INT:{
      n = jj_consume_token(INT);
t = new ASTNum("INT",n.image);
      break;
      }
    case FLOAT:{
      n = jj_consume_token(FLOAT);
t = new ASTNum("FLOAT",n.image);
      break;
      }
    case LPAR:{
      jj_consume_token(LPAR);
      t = S();
      jj_consume_token(RPAR);
      break;
      }
    case BOOLEAN:{
      n = jj_consume_token(BOOLEAN);
t = new ASTBoolean(Boolean.parseBoolean(n.image));
      break;
      }
    case PRINTLN:{
      jj_consume_token(PRINTLN);
      jj_consume_token(LPAR);
      t1 = S();
      jj_consume_token(RPAR);
t = new ASTPrintln(t1);
      break;
      }
    case FUN:{
      jj_consume_token(FUN);
params.clear();
      n = jj_consume_token(ID);
      jj_consume_token(LPAR);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case ID:{
        n2 = jj_consume_token(ID);
params.add(n2.image);
        break;
        }
      default:
        jj_la1[9] = jj_gen;
        ;
      }
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case COMMA:{
          ;
          break;
          }
        default:
          jj_la1[10] = jj_gen;
          break label_6;
        }
        jj_consume_token(COMMA);
        n2 = jj_consume_token(ID);
params.add(n2.image);
      }
      jj_consume_token(RPAR);
      t1 = S();
t=new ASTFunctionEnv(n.image,new VFun(t1,params,n.image));
      break;
      }
    default:
      jj_la1[14] = jj_gen;
      if (jj_2_4(2)) {
        n = jj_consume_token(ID);
        jj_consume_token(LPAR);
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case FUN:
        case WHILE:
        case IF:
        case BOOLEAN:
        case REF:
        case PRINTLN:
        case ID:
        case INT:
        case FLOAT:
        case NOT:
        case MINUS:
        case LPAR:
        case STRING:{
          t1 = BA();
values.clear(); values.add(t1);
          break;
          }
        default:
          jj_la1[11] = jj_gen;
          ;
        }
        label_7:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
          case COMMA:{
            ;
            break;
            }
          default:
            jj_la1[12] = jj_gen;
            break label_7;
          }
          jj_consume_token(COMMA);
          t1 = BA();
values.add(t1);
        }
        jj_consume_token(RPAR);
t = new ASTFunction(values, n.image);
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case ID:{
          n = jj_consume_token(ID);
t = new ASTId(n.image);
          break;
          }
        case STRING:{
          n = jj_consume_token(STRING);
t = new ASTString(n.image.replaceAll("\\p{P}",""));
          break;
          }
        case REF:{
          label_8:
          while (true) {
            jj_consume_token(REF);
            t1 = Fact();
t = new ASTDeref(t1);
            switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
            case REF:{
              ;
              break;
              }
            default:
              jj_la1[13] = jj_gen;
              break label_8;
            }
          }
          break;
          }
        case IF:{
          jj_consume_token(IF);
          t = SE();
          jj_consume_token(LBRA);
          t1 = S();
          jj_consume_token(RBRA);
          jj_consume_token(LBRA);
          t2 = S();
          jj_consume_token(RBRA);
t = new ASTIf(t,t1,t2);
          break;
          }
        case WHILE:{
          jj_consume_token(WHILE);
          t1 = SE();
          jj_consume_token(LBRA);
          t2 = S();
          jj_consume_token(RBRA);
t = new ASTWhile(t1, t2);
          break;
          }
        case MINUS:{
          jj_consume_token(MINUS);
          t1 = Fact();
t = new ASTNeg(t1);
          break;
          }
        case NOT:{
          jj_consume_token(NOT);
          t1 = Fact();
t = new ASTNot(t1);
          break;
          }
        default:
          jj_la1[15] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
{if ("" != null) return t;}
    throw new Error("Missing return statement in function");
}

  static private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_2()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_3()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  static private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_4()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  static private boolean jj_3R_Fact_228_6_21()
 {
    if (jj_scan_token(STRING)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_227_6_20()
 {
    if (jj_scan_token(ID)) return true;
    return false;
  }

  static private boolean jj_3_4()
 {
    if (jj_scan_token(ID)) return true;
    if (jj_scan_token(LPAR)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_225_6_19()
 {
    if (jj_scan_token(FUN)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_224_6_18()
 {
    if (jj_scan_token(PRINTLN)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_223_6_17()
 {
    if (jj_scan_token(BOOLEAN)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_222_6_16()
 {
    if (jj_scan_token(LPAR)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_221_6_15()
 {
    if (jj_scan_token(FLOAT)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_220_6_14()
 {
    if (jj_scan_token(INT)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_220_4_13()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_Fact_220_6_14()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_221_6_15()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_222_6_16()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_223_6_17()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_224_6_18()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_225_6_19()) {
    jj_scanpos = xsp;
    if (jj_3_4()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_227_6_20()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_228_6_21()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_229_6_22()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_230_6_23()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_231_6_24()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_232_6_25()) {
    jj_scanpos = xsp;
    if (jj_3R_Fact_233_6_26()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  static private boolean jj_3_3()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(46)) {
    jj_scanpos = xsp;
    if (jj_scan_token(41)) {
    jj_scanpos = xsp;
    if (jj_scan_token(42)) {
    jj_scanpos = xsp;
    if (jj_scan_token(47)) {
    jj_scanpos = xsp;
    if (jj_scan_token(40)) return true;
    }
    }
    }
    }
    if (jj_3R_Exp_186_4_11()) return true;
    return false;
  }

  static private boolean jj_3_2()
 {
    if (jj_scan_token(AND)) return true;
    if (jj_3R_Relop_159_1_10()) return true;
    return false;
  }

  static private boolean jj_3R_Relop_159_1_10()
 {
    if (jj_3R_Exp_186_4_11()) return true;
    return false;
  }

  static private boolean jj_3R_Term_202_4_12()
 {
    if (jj_3R_Fact_220_4_13()) return true;
    return false;
  }

  static private boolean jj_3R_BM_147_1_9()
 {
    if (jj_3R_Relop_159_1_10()) return true;
    return false;
  }

  static private boolean jj_3_1()
 {
    if (jj_scan_token(OR)) return true;
    if (jj_3R_BM_147_1_9()) return true;
    return false;
  }

  static private boolean jj_3R_Fact_233_6_26()
 {
    if (jj_scan_token(NOT)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_232_6_25()
 {
    if (jj_scan_token(MINUS)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_231_6_24()
 {
    if (jj_scan_token(WHILE)) return true;
    return false;
  }

  static private boolean jj_3R_Exp_186_4_11()
 {
    if (jj_3R_Term_202_4_12()) return true;
    return false;
  }

  static private boolean jj_3R_Fact_229_7_27()
 {
    if (jj_scan_token(REF)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_230_6_23()
 {
    if (jj_scan_token(IF)) return true;
    return false;
  }

  static private boolean jj_3R_Fact_229_6_22()
 {
    Token xsp;
    if (jj_3R_Fact_229_7_27()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_Fact_229_7_27()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[16];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {0x0,0xf4000000,0x80000000,0xf4000000,0x0,0x0,0x0,0x0,0x0,0x0,0x8000000,0x74000000,0x8000000,0x0,0x44000000,0x30000000,};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {0x8000000,0x214420f9,0x1,0x204420f9,0xc700,0x50000,0x50000,0x300000,0x300000,0x20,0x0,0x204420f8,0x0,0x8,0x4000d0,0x20042028,};
	}
  static final private JJCalls[] jj_2_rtns = new JJCalls[4];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser.  ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new ParserTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new ParserTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
	 if (jj_initialized_once) {
	   System.out.println("ERROR: Second call to constructor of static parser. ");
	   System.out.println("	   You must either use ReInit() or set the JavaCC option STATIC to false");
	   System.out.println("	   during parser generation.");
	   throw new Error();
	 }
	 jj_initialized_once = true;
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 16; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   if (++jj_gc > 100) {
		 jj_gc = 0;
		 for (int i = 0; i < jj_2_rtns.length; i++) {
		   JJCalls c = jj_2_rtns[i];
		   while (c != null) {
			 if (c.gen < jj_gen) c.first = null;
			 c = c.next;
		   }
		 }
	   }
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error {
    @Override
    public Throwable fillInStackTrace() {
      return this;
    }
  }
  static private final LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		 jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		 jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  static private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
	 if (pos >= 100) {
		return;
	 }

	 if (pos == jj_endpos + 1) {
	   jj_lasttokens[jj_endpos++] = kind;
	 } else if (jj_endpos != 0) {
	   jj_expentry = new int[jj_endpos];

	   for (int i = 0; i < jj_endpos; i++) {
		 jj_expentry[i] = jj_lasttokens[i];
	   }

	   for (int[] oldentry : jj_expentries) {
		 if (oldentry.length == jj_expentry.length) {
		   boolean isMatched = true;

		   for (int i = 0; i < jj_expentry.length; i++) {
			 if (oldentry[i] != jj_expentry[i]) {
			   isMatched = false;
			   break;
			 }

		   }
		   if (isMatched) {
			 jj_expentries.add(jj_expentry);
			 break;
		   }
		 }
	   }

	   if (pos != 0) {
		 jj_lasttokens[(jj_endpos = pos) - 1] = kind;
	   }
	 }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[62];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 16; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 62; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 jj_endpos = 0;
	 jj_rescan_token();
	 jj_add_error_token(0, 0);
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  static private boolean trace_enabled;

/** Trace enabled. */
  static final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
	 jj_rescan = true;
	 for (int i = 0; i < 4; i++) {
	   try {
		 JJCalls p = jj_2_rtns[i];

		 do {
		   if (p.gen > jj_gen) {
			 jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
			 switch (i) {
			   case 0: jj_3_1(); break;
			   case 1: jj_3_2(); break;
			   case 2: jj_3_3(); break;
			   case 3: jj_3_4(); break;
			 }
		   }
		   p = p.next;
		 } while (p != null);

		 } catch(LookaheadSuccess ls) { }
	 }
	 jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
	 JJCalls p = jj_2_rtns[index];
	 while (p.gen > jj_gen) {
	   if (p.next == null) { p = p.next = new JJCalls(); break; }
	   p = p.next;
	 }

	 p.gen = jj_gen + xla - jj_la; 
	 p.first = token;
	 p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}
