package Scanner;

import java_cup.runtime.*;
import Parser.sym;
import Throwables.*;



public final class scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\7\1\5\1\2\2\0\1\1\16\7\4\0\1\5\1\54\2\0"+
    "\1\6\1\0\1\55\1\0\1\42\1\43\1\4\1\56\1\51\1\57"+
    "\1\41\1\3\1\10\11\11\1\0\1\50\1\53\1\52\3\0\22\6"+
    "\1\30\7\6\1\46\1\0\1\47\1\0\1\6\1\0\1\14\1\20"+
    "\1\12\1\25\1\33\1\35\1\32\1\37\1\21\2\6\1\13\1\26"+
    "\1\27\1\24\1\16\1\6\1\31\1\15\1\22\1\17\1\23\1\36"+
    "\1\34\1\40\1\6\1\44\1\0\1\45\1\0\41\7\2\0\4\6"+
    "\4\0\1\6\2\0\1\7\7\0\1\6\4\0\1\6\5\0\27\6"+
    "\1\0\37\6\1\0\u01ca\6\4\0\14\6\16\0\5\6\7\0\1\6"+
    "\1\0\1\6\21\0\160\7\5\6\1\0\2\6\2\0\4\6\10\0"+
    "\1\6\1\0\3\6\1\0\1\6\1\0\24\6\1\0\123\6\1\0"+
    "\213\6\1\0\5\7\2\0\236\6\11\0\46\6\2\0\1\6\7\0"+
    "\47\6\11\0\55\7\1\0\1\7\1\0\2\7\1\0\2\7\1\0"+
    "\1\7\10\0\33\6\5\0\3\6\15\0\4\7\7\0\1\6\4\0"+
    "\13\7\5\0\53\6\37\7\4\0\2\6\1\7\143\6\1\0\1\6"+
    "\10\7\1\0\6\7\2\6\2\7\1\0\4\7\2\6\12\7\3\6"+
    "\2\0\1\6\17\0\1\7\1\6\1\7\36\6\33\7\2\0\131\6"+
    "\13\7\1\6\16\0\12\7\41\6\11\7\2\6\4\0\1\6\5\0"+
    "\26\6\4\7\1\6\11\7\1\6\3\7\1\6\5\7\22\0\31\6"+
    "\3\7\244\0\4\7\66\6\3\7\1\6\22\7\1\6\7\7\12\6"+
    "\2\7\2\0\12\7\1\0\7\6\1\0\7\6\1\0\3\7\1\0"+
    "\10\6\2\0\2\6\2\0\26\6\1\0\7\6\1\0\1\6\3\0"+
    "\4\6\2\0\1\7\1\6\7\7\2\0\2\7\2\0\3\7\1\6"+
    "\10\0\1\7\4\0\2\6\1\0\3\6\2\7\2\0\12\7\4\6"+
    "\7\0\1\6\5\0\3\7\1\0\6\6\4\0\2\6\2\0\26\6"+
    "\1\0\7\6\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\7"+
    "\1\0\5\7\4\0\2\7\2\0\3\7\3\0\1\7\7\0\4\6"+
    "\1\0\1\6\7\0\14\7\3\6\1\7\13\0\3\7\1\0\11\6"+
    "\1\0\3\6\1\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6"+
    "\2\0\1\7\1\6\10\7\1\0\3\7\1\0\3\7\2\0\1\6"+
    "\17\0\2\6\2\7\2\0\12\7\1\0\1\6\17\0\3\7\1\0"+
    "\10\6\2\0\2\6\2\0\26\6\1\0\7\6\1\0\2\6\1\0"+
    "\5\6\2\0\1\7\1\6\7\7\2\0\2\7\2\0\3\7\10\0"+
    "\2\7\4\0\2\6\1\0\3\6\2\7\2\0\12\7\1\0\1\6"+
    "\20\0\1\7\1\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0"+
    "\2\6\1\0\1\6\1\0\2\6\3\0\2\6\3\0\3\6\3\0"+
    "\14\6\4\0\5\7\3\0\3\7\1\0\4\7\2\0\1\6\6\0"+
    "\1\7\16\0\12\7\11\0\1\6\7\0\3\7\1\0\10\6\1\0"+
    "\3\6\1\0\27\6\1\0\12\6\1\0\5\6\3\0\1\6\7\7"+
    "\1\0\3\7\1\0\4\7\7\0\2\7\1\0\2\6\6\0\2\6"+
    "\2\7\2\0\12\7\22\0\2\7\1\0\10\6\1\0\3\6\1\0"+
    "\27\6\1\0\12\6\1\0\5\6\2\0\1\7\1\6\7\7\1\0"+
    "\3\7\1\0\4\7\7\0\2\7\7\0\1\6\1\0\2\6\2\7"+
    "\2\0\12\7\1\0\2\6\17\0\2\7\1\0\10\6\1\0\3\6"+
    "\1\0\51\6\2\0\1\6\7\7\1\0\3\7\1\0\4\7\1\6"+
    "\10\0\1\7\10\0\2\6\2\7\2\0\12\7\12\0\6\6\2\0"+
    "\2\7\1\0\22\6\3\0\30\6\1\0\11\6\1\0\1\6\2\0"+
    "\7\6\3\0\1\7\4\0\6\7\1\0\1\7\1\0\10\7\22\0"+
    "\2\7\15\0\60\6\1\7\2\6\7\7\4\0\10\6\10\7\1\0"+
    "\12\7\47\0\2\6\1\0\1\6\2\0\2\6\1\0\1\6\2\0"+
    "\1\6\6\0\4\6\1\0\7\6\1\0\3\6\1\0\1\6\1\0"+
    "\1\6\2\0\2\6\1\0\4\6\1\7\2\6\6\7\1\0\2\7"+
    "\1\6\2\0\5\6\1\0\1\6\1\0\6\7\2\0\12\7\2\0"+
    "\2\6\42\0\1\6\27\0\2\7\6\0\12\7\13\0\1\7\1\0"+
    "\1\7\1\0\1\7\4\0\2\7\10\6\1\0\44\6\4\0\24\7"+
    "\1\0\2\7\5\6\13\7\1\0\44\7\11\0\1\7\71\0\53\6"+
    "\24\7\1\6\12\7\6\0\6\6\4\7\4\6\3\7\1\6\3\7"+
    "\2\6\7\7\3\6\4\7\15\6\14\7\1\6\17\7\2\0\46\6"+
    "\12\0\53\6\1\0\1\6\3\0\u0149\6\1\0\4\6\2\0\7\6"+
    "\1\0\1\6\1\0\4\6\2\0\51\6\1\0\4\6\2\0\41\6"+
    "\1\0\4\6\2\0\7\6\1\0\1\6\1\0\4\6\2\0\17\6"+
    "\1\0\71\6\1\0\4\6\2\0\103\6\2\0\3\7\40\0\20\6"+
    "\20\0\125\6\14\0\u026c\6\2\0\21\6\1\0\32\6\5\0\113\6"+
    "\3\0\3\6\17\0\15\6\1\0\4\6\3\7\13\0\22\6\3\7"+
    "\13\0\22\6\2\7\14\0\15\6\1\0\3\6\1\0\2\7\14\0"+
    "\64\6\40\7\3\0\1\6\3\0\2\6\1\7\2\0\12\7\41\0"+
    "\3\7\2\0\12\7\6\0\130\6\10\0\51\6\1\7\1\6\5\0"+
    "\106\6\12\0\35\6\3\0\14\7\4\0\14\7\12\0\12\7\36\6"+
    "\2\0\5\6\13\0\54\6\4\0\21\7\7\6\2\7\6\0\12\7"+
    "\46\0\27\6\5\7\4\0\65\6\12\7\1\0\35\7\2\0\13\7"+
    "\6\0\12\7\15\0\1\6\130\0\5\7\57\6\21\7\7\6\4\0"+
    "\12\7\21\0\11\7\14\0\3\7\36\6\12\7\3\0\2\6\12\7"+
    "\6\0\46\6\16\7\14\0\44\6\24\7\10\0\12\7\3\0\3\6"+
    "\12\7\44\6\122\0\3\7\1\0\25\7\4\6\1\7\4\6\1\7"+
    "\15\0\300\6\47\7\25\0\4\7\u0116\6\2\0\6\6\2\0\46\6"+
    "\2\0\6\6\2\0\10\6\1\0\1\6\1\0\1\6\1\0\1\6"+
    "\1\0\37\6\2\0\65\6\1\0\7\6\1\0\1\6\3\0\3\6"+
    "\1\0\7\6\3\0\4\6\2\0\6\6\4\0\15\6\5\0\3\6"+
    "\1\0\7\6\16\0\5\7\32\0\5\7\20\0\2\6\23\0\1\6"+
    "\13\0\5\7\5\0\6\7\1\0\1\6\15\0\1\6\20\0\15\6"+
    "\3\0\32\6\26\0\15\7\4\0\1\7\3\0\14\7\21\0\1\6"+
    "\4\0\1\6\2\0\12\6\1\0\1\6\3\0\5\6\6\0\1\6"+
    "\1\0\1\6\1\0\1\6\1\0\4\6\1\0\13\6\2\0\4\6"+
    "\5\0\5\6\4\0\1\6\21\0\51\6\u0a77\0\57\6\1\0\57\6"+
    "\1\0\205\6\6\0\4\6\3\7\16\0\46\6\12\0\66\6\11\0"+
    "\1\6\17\0\1\7\27\6\11\0\7\6\1\0\7\6\1\0\7\6"+
    "\1\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6"+
    "\1\0\40\7\57\0\1\6\u01d5\0\3\6\31\0\11\6\6\7\1\0"+
    "\5\6\2\0\5\6\4\0\126\6\2\0\2\7\2\0\3\6\1\0"+
    "\132\6\1\0\4\6\5\0\51\6\3\0\136\6\21\0\33\6\65\0"+
    "\20\6\u0200\0\u19b6\6\112\0\u51cc\6\64\0\u048d\6\103\0\56\6\2\0"+
    "\u010d\6\3\0\20\6\12\7\2\6\24\0\57\6\1\7\14\0\2\7"+
    "\1\0\31\6\10\0\120\6\2\7\45\0\11\6\2\0\147\6\2\0"+
    "\4\6\1\0\2\6\16\0\12\6\120\0\10\6\1\7\3\6\1\7"+
    "\4\6\1\7\27\6\5\7\20\0\1\6\7\0\64\6\14\0\2\7"+
    "\62\6\21\7\13\0\12\7\6\0\22\7\6\6\3\0\1\6\4\0"+
    "\12\7\34\6\10\7\2\0\27\6\15\7\14\0\35\6\3\0\4\7"+
    "\57\6\16\7\16\0\1\6\12\7\46\0\51\6\16\7\11\0\3\6"+
    "\1\7\10\6\2\7\2\0\12\7\6\0\27\6\3\0\1\6\1\7"+
    "\4\0\60\6\1\7\1\6\3\7\2\6\2\7\5\6\2\7\1\6"+
    "\1\7\1\6\30\0\3\6\43\0\6\6\2\0\6\6\2\0\6\6"+
    "\11\0\7\6\1\0\7\6\221\0\43\6\10\7\1\0\2\7\2\0"+
    "\12\7\6\0\u2ba4\6\14\0\27\6\4\0\61\6\u2104\0\u012e\6\2\0"+
    "\76\6\2\0\152\6\46\0\7\6\14\0\5\6\5\0\1\6\1\7"+
    "\12\6\1\0\15\6\1\0\5\6\1\0\1\6\1\0\2\6\1\0"+
    "\2\6\1\0\154\6\41\0\u016b\6\22\0\100\6\2\0\66\6\50\0"+
    "\15\6\3\0\20\7\20\0\7\7\14\0\2\6\30\0\3\6\31\0"+
    "\1\6\6\0\5\6\1\0\207\6\2\0\1\7\4\0\1\6\13\0"+
    "\12\7\7\0\32\6\4\0\1\6\1\0\32\6\13\0\131\6\3\0"+
    "\6\6\2\0\6\6\2\0\6\6\2\0\3\6\3\0\2\6\3\0"+
    "\2\6\22\0\3\7\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\4\2\5\17\4"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\1\1\22\1\23\1\24"+
    "\1\0\6\4\1\25\14\4\1\26\2\24\1\0\5\4"+
    "\1\27\4\4\1\30\14\4\1\31\1\32\1\33\1\34"+
    "\3\4\1\35\3\4\1\36\10\4\1\37\1\40\1\41"+
    "\1\42\1\43\1\4\1\44\1\4\1\45\1\4\1\46"+
    "\1\0\1\47\12\0\1\50";

  private static int [] zzUnpackAction() {
    int [] result = new int[130];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\220\0\60\0\300\0\60\0\360"+
    "\0\u0120\0\u0150\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270"+
    "\0\u02a0\0\u02d0\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\60"+
    "\0\60\0\60\0\60\0\60\0\60\0\60\0\60\0\60"+
    "\0\60\0\60\0\60\0\u03f0\0\60\0\60\0\u0420\0\u0450"+
    "\0\u0480\0\u04b0\0\u04e0\0\u0510\0\u0540\0\u0570\0\300\0\u05a0"+
    "\0\u05d0\0\u0600\0\u0630\0\u0660\0\u0690\0\u06c0\0\u06f0\0\u0720"+
    "\0\u0750\0\u0780\0\u07b0\0\60\0\u07e0\0\60\0\u0810\0\u0840"+
    "\0\u0870\0\u08a0\0\u08d0\0\u0900\0\300\0\u0930\0\u0960\0\u0990"+
    "\0\u09c0\0\300\0\u09f0\0\u0a20\0\u0a50\0\u0a80\0\u0ab0\0\u0ae0"+
    "\0\u0b10\0\u0b40\0\u0b70\0\u0ba0\0\u0bd0\0\u0c00\0\300\0\300"+
    "\0\300\0\300\0\u0c30\0\u0c60\0\u0c90\0\300\0\u0cc0\0\u0cf0"+
    "\0\u0d20\0\300\0\u0d50\0\u0d80\0\u0db0\0\u0de0\0\u0e10\0\u0e40"+
    "\0\u0e70\0\u0ea0\0\300\0\300\0\300\0\300\0\300\0\u0ed0"+
    "\0\300\0\u0f00\0\300\0\u0f30\0\300\0\u0f60\0\300\0\u0f90"+
    "\0\u0fc0\0\u0ff0\0\u1020\0\u1050\0\u1080\0\u10b0\0\u10e0\0\u1110"+
    "\0\u1140\0\60";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[130];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\4\1\5\1\3\1\6\1\2\1\7"+
    "\1\10\1\11\1\12\1\6\1\13\1\14\1\6\1\15"+
    "\1\16\1\17\1\20\2\6\1\21\1\22\1\23\1\24"+
    "\1\6\1\25\1\6\1\26\1\27\2\6\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\61\0\2\3\2\0"+
    "\1\3\55\0\1\47\1\50\61\0\33\6\27\0\2\10"+
    "\54\0\5\6\1\51\25\6\25\0\25\6\1\52\5\6"+
    "\25\0\14\6\1\53\16\6\25\0\11\6\1\54\21\6"+
    "\25\0\16\6\1\55\14\6\25\0\21\6\1\56\5\6"+
    "\1\57\3\6\25\0\23\6\1\60\5\6\1\61\1\6"+
    "\25\0\16\6\1\62\14\6\25\0\6\6\1\63\24\6"+
    "\25\0\25\6\1\64\5\6\25\0\14\6\1\65\15\6"+
    "\1\66\25\0\25\6\1\67\5\6\25\0\5\6\1\70"+
    "\20\6\1\71\4\6\25\0\6\6\1\72\24\6\25\0"+
    "\31\6\1\73\1\6\74\0\1\74\2\0\1\47\1\75"+
    "\1\76\55\47\4\50\1\77\53\50\6\0\6\6\1\100"+
    "\24\6\25\0\21\6\1\101\11\6\25\0\6\6\1\102"+
    "\24\6\25\0\12\6\1\103\20\6\25\0\16\6\1\104"+
    "\14\6\25\0\14\6\1\105\16\6\25\0\11\6\1\106"+
    "\21\6\25\0\13\6\1\107\17\6\25\0\13\6\1\110"+
    "\17\6\25\0\13\6\1\111\17\6\25\0\30\6\1\112"+
    "\2\6\25\0\23\6\1\113\7\6\25\0\7\6\1\114"+
    "\23\6\25\0\14\6\1\115\16\6\25\0\7\6\1\116"+
    "\23\6\25\0\14\6\1\117\16\6\25\0\5\6\1\120"+
    "\25\6\25\0\13\6\1\121\17\6\21\0\1\76\55\0"+
    "\3\50\1\76\1\77\53\50\6\0\7\6\1\122\23\6"+
    "\25\0\24\6\1\123\6\6\25\0\14\6\1\124\16\6"+
    "\25\0\5\6\1\125\25\6\25\0\5\6\1\126\25\6"+
    "\25\0\25\6\1\127\5\6\25\0\7\6\1\130\23\6"+
    "\25\0\17\6\1\131\13\6\25\0\21\6\1\132\11\6"+
    "\25\0\13\6\1\133\17\6\25\0\14\6\1\134\16\6"+
    "\25\0\11\6\1\135\21\6\25\0\25\6\1\136\5\6"+
    "\25\0\25\6\1\137\5\6\25\0\7\6\1\140\23\6"+
    "\25\0\5\6\1\141\25\6\25\0\7\6\1\142\23\6"+
    "\25\0\14\6\1\143\16\6\25\0\13\6\1\144\17\6"+
    "\25\0\13\6\1\145\17\6\25\0\25\6\1\146\5\6"+
    "\25\0\21\6\1\147\11\6\25\0\25\6\1\150\5\6"+
    "\25\0\23\6\1\151\7\6\25\0\21\6\1\152\11\6"+
    "\25\0\25\6\1\153\5\6\25\0\25\6\1\154\5\6"+
    "\25\0\31\6\1\155\1\6\25\0\4\6\1\156\26\6"+
    "\25\0\4\6\1\157\26\6\25\0\6\6\1\160\24\6"+
    "\25\0\24\6\1\161\6\6\25\0\20\6\1\162\12\6"+
    "\25\0\21\6\1\163\11\6\25\0\17\6\1\164\13\6"+
    "\25\0\21\6\1\165\11\6\25\0\33\6\1\166\24\0"+
    "\7\6\1\167\23\6\43\0\1\170\52\0\1\171\62\0"+
    "\1\172\76\0\1\173\34\0\1\174\72\0\1\175\47\0"+
    "\1\176\65\0\1\177\52\0\1\200\50\0\1\201\73\0"+
    "\1\202\30\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4464];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\1\1\1\11\20\1\14\11"+
    "\1\1\2\11\1\1\1\0\23\1\1\11\1\1\1\11"+
    "\1\0\66\1\1\0\1\1\12\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[130];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  // note that these Symbol constructors are abusing the Symbol
  // interface to use Symbol's left and right fields as line and column
  // fields instead
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }
  
  // print out a symbol (aka token) nicely
  public String symbolToString(Symbol s) {
    switch (s.sym) {
		case sym.CLASS: return "CLASS";
		case sym.PUBLIC: return "PUBLIC";
		case sym.STATIC: return "STATIC";
		case sym.VOID: return "VOID";
		case sym.MAIN: return "MAIN";
		case sym.STRING: return "STRING";
		case sym.EXTENDS: return "EXTENDS";
		case sym.RETURN: return "RETURN";
		case sym.INT: return "INT";
		case sym.BOOLEAN: return "BOOLEAN";
		case sym.IF: return "IF";
		case sym.ELSE: return "ELSE";
		case sym.WHILE: return "WHILE"; 
		case sym.SYSTEMOUTPRINTLN: return "SYSTEMOUTPRINTLN";
		case sym.LENGTH: return "LENGTH";
		case sym.THIS: return "THIS";
		case sym.NEW: return "NEW";
		case sym.LPAREN: return "LPAREN";
		case sym.RPAREN: return "RPAREN";
		case sym.LBRACE: return "LBRACE";
		case sym.RBRACE: return "RBRACE";
		case sym.LBRACK: return "LBRACK";
		case sym.RBRACK: return "RBRACK";
		case sym.SEMICOLON: return "SEMICOLON";
		case sym.COMMA: return "COMMA";
		case sym.DOT: return "DOT";
		case sym.EQ: return "EQ";
		case sym.LT: return "LT";
		case sym.NOT: return "NOT";
		case sym.ANDAND: return "ANDAND";
		case sym.PLUS: return "PLUS";
		case sym.MINUS: return "MINUS";
		case sym.MULT: return "MULT";
		case sym.BOOLEAN_LITERAL: return "BOOLEAN("+ s.value.toString() + ")";
		case sym.IDENTIFIER: return "ID(" + (String)s.value + ")";
		case sym.INTEGER_LITERAL: return "INTEGER(" + String.valueOf(s.value) +")";
		case sym.EOF: return "<EOF>";
		case sym.error: return "<ERROR>";
		default: return "<UNEXPECTED TOKEN " + s.toString() + ">";

    }
  }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public scanner(java.io.FileReader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public scanner(java.io.InputStream in) {
    //this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2208) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, CompilerException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 2: 
          { /* ignore whitespace */
          }
        case 41: break;
        case 20: 
          { /* ignore */
          }
        case 42: break;
        case 30: 
          { return symbol(sym.CLASS);
          }
        case 43: break;
        case 8: 
          { return symbol(sym.RPAREN);
          }
        case 44: break;
        case 33: 
          { return symbol(sym.LENGTH);
          }
        case 45: break;
        case 16: 
          { return symbol(sym.LT);
          }
        case 46: break;
        case 9: 
          { return symbol(sym.LBRACE);
          }
        case 47: break;
        case 23: 
          { return symbol(sym.INT);
          }
        case 48: break;
        case 17: 
          { return symbol(sym.NOT);
          }
        case 49: break;
        case 1: 
          { throw new LexicalCompilerException(
	"unexpected character in input: '" + yytext() + "'", 
	yyline+1, yycolumn+1);
          }
        case 50: break;
        case 37: 
          { return symbol(sym.RETURN);
          }
        case 51: break;
        case 18: 
          { return symbol(sym.PLUS);
          }
        case 52: break;
        case 5: 
          { return symbol(sym.INTEGER_LITERAL, new Integer(yytext()));
          }
        case 53: break;
        case 39: 
          { return symbol(sym.EXTENDS);
          }
        case 54: break;
        case 27: 
          { return symbol(sym.VOID);
          }
        case 55: break;
        case 4: 
          { return symbol(sym.IDENTIFIER, yytext());
          }
        case 56: break;
        case 28: 
          { return symbol(sym.MAIN);
          }
        case 57: break;
        case 11: 
          { return symbol(sym.LBRACK);
          }
        case 58: break;
        case 29: 
          { return symbol(sym.ELSE);
          }
        case 59: break;
        case 34: 
          { return symbol(sym.STATIC);
          }
        case 60: break;
        case 3: 
          { return symbol(sym.MULT);
          }
        case 61: break;
        case 32: 
          { return symbol(sym.WHILE);
          }
        case 62: break;
        case 21: 
          { return symbol(sym.IF);
          }
        case 63: break;
        case 7: 
          { return symbol(sym.LPAREN);
          }
        case 64: break;
        case 26: 
          { return symbol(sym.THIS);
          }
        case 65: break;
        case 15: 
          { return symbol(sym.EQ);
          }
        case 66: break;
        case 10: 
          { return symbol(sym.RBRACE);
          }
        case 67: break;
        case 13: 
          { return symbol(sym.SEMICOLON);
          }
        case 68: break;
        case 25: 
          { return symbol(sym.BOOLEAN_LITERAL, new Boolean(true));
          }
        case 69: break;
        case 19: 
          { return symbol(sym.MINUS);
          }
        case 70: break;
        case 22: 
          { return symbol(sym.ANDAND);
          }
        case 71: break;
        case 31: 
          { return symbol(sym.BOOLEAN_LITERAL, new Boolean(false));
          }
        case 72: break;
        case 24: 
          { return symbol(sym.NEW);
          }
        case 73: break;
        case 38: 
          { return symbol(sym.BOOLEAN);
          }
        case 74: break;
        case 36: 
          { return symbol(sym.STRING);
          }
        case 75: break;
        case 14: 
          { return symbol(sym.COMMA);
          }
        case 76: break;
        case 12: 
          { return symbol(sym.RBRACK);
          }
        case 77: break;
        case 40: 
          { return symbol(sym.SYSTEMOUTPRINTLN);
          }
        case 78: break;
        case 35: 
          { return symbol(sym.PUBLIC);
          }
        case 79: break;
        case 6: 
          { return symbol(sym.DOT);
          }
        case 80: break;
        default:
        	if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
