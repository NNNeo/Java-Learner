package ast;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CAstTest{

    private static Pattern numPattern = Pattern.compile("[0-9]+");
    private static Pattern varPattern = Pattern.compile("^[_a-zA-Z][1-9a-zA-Z_]+");

    private static Matcher matcher;
    public static void main(String [] args) throws IOException {
//        HIRPack ir = new HIRPack();
        CAstTest testcase=new CAstTest();
//        ir.setIR(testcase.createSampleAST());
//        ir.showIR();


        String src = Objects.requireNonNull(testcase.getClass().getClassLoader().getResource("getopt.c")).getPath();
//        System.out.println(testcase.getClass().getClassLoader().getResources());
        System.out.println(src);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(src));
        String stat;
        // map 存储 文件 : 行数， 内容，
        HashMap<String, HashMap<Integer, String>> map = new HashMap<>();
        HashMap<Integer, String> lineMap = new HashMap<>();
        // 逐行遍历
        HashMap<Integer, StatementContent> content = new HashMap<>();
        boolean noteLinesFlag = false;
        int line = 0;
        while ((stat = bufferedReader.readLine()) != null) {
            line ++; // 当前行数
            stat = stat.trim();
            if (stat.startsWith("//")) {
                continue;
            } else if (stat.startsWith("/*")) {
                noteLinesFlag = true;
            } else if (stat.endsWith("*/")) {
                noteLinesFlag = false;
            }
            if (noteLinesFlag) {
                continue;
            }
            StatementContent sc = new StatementContent();
            genStatContent(stat, sc);
            sc.setLineNum(line);

        }
    }

    private static void genStatContent(String stat, StatementContent sc) {
        stat = stat.trim();
        int idx = stat.indexOf(";");
        if (idx != -1) {
            stat = stat.substring(0,idx);
        }
        String[] stats = stat.split(" ");
        String normal = "";
        // 以关键字开头，
        // 函数定义，变量声明
        if (CKeyWord.isDataTypeKeyWord(stats[0])) {

            // 函数声明语句开头
            if (stat.contains("(") || stat.contains(")")) {
                sc.setContent(stat);

                for (String states : stats) {
                    if (CKeyWord.isCKeyWord(states)) {
                        normal += states;
                    } else {
                        normal += " $";
                        break;
                    }
                }


            } else {
                // 声明变量
                for (String states : stats) {
                    if (CKeyWord.isCKeyWord(states)) {
                        normal += states;
                    } else if (isNum(states)) {
                        normal += " num ";
                    } else if (isVar(states)) {
                        normal += " $ ";
                    } else {

                    }
                }

            }

        } else if (CKeyWord.controlTypeWordSet.contains(stats[0])) {
            // for (
            normal += stats[0];

            if (stats[0].equals("for")) {
                int bridx = stat.indexOf("(");
                int brbidx = stat.indexOf(")");
                normal += "(";
                String inner = stat.substring(bridx, brbidx);
                String[] inners = inner.split(";");
                // int i = 1;
                // i = 1
                // i= 1;
                // i=1;
                // i =1;
                // ;
                if (inners[0].length() > 0) {
                    String[] inns = inners[0].split(" ");
                    if (CKeyWord.isCKeyWord(inns[0])) {
                        normal += inns[0] + " ";
                    }
                    normal += "$ = num;";


                } else {

                }
             }


        }

        if (idx != -1) {
            normal += ";";
        }
        sc.setNormalizeContent(normal);
    }

    private static boolean isVar(String stat) {
        matcher = varPattern.matcher(stat);
        if (matcher.find()) {
            return true;
        }
        return false;
    }

    private static boolean isNum(String stat) {
        matcher = numPattern.matcher(stat);
        return matcher.find();
    }

    private static boolean isFunc(String stat) {
        return false;
    }

    private static boolean isKeyWordInC(String st) {
        return CKeyWord.isCKeyWord(st);
    }
}

class CKeyWord {
    public static final String AUTO = "auto";
    public static final String INT = "int";
    public static final String DOUBLE = "double";
    public static final String LONG = "long";
    public static final String CHAR = "char";
    public static final String FLOAT = "float";
    public static final String SHORT = "short";
    public static final String SIGNED = "signed";
    public static final String UNSIGNED = "unsigned";
    public static final String STRUCT = "struct";
    public static final String UNION = "union";
    public static final String ENUM = "enum";
    public static final String STATIC = "static";
    public static final String SWITCH = "switch";
    public static final String CASE = "case";
    public static final String DEFAULT = "default";
    public static final String BREAK = "break";
    public static final String CONTINUE = "continue";
    public static final String REGISTER = "register";
    public static final String CONST = "const";
    public static final String VOLATILE = "volatile";
    public static final String TYPEDEF = "typedef";
    public static final String EXTERN = "extern";
    public static final String RETURN = "return";
    public static final String VOID = "void";
    public static final String DO = "do";
    public static final String WHILE = "while";
    public static final String FOR = "for";
    public static final String IF = "if";
    public static final String ELSE = "else";
    public static final String GOTO = "goto";
    public static final String SIZEOF = "sizeof";

    static HashSet<String> dataTypeWordSet = new HashSet<>();
    static HashSet<String> controlTypeWordSet = new HashSet<>();
    static {
        dataTypeWordSet.add(AUTO);
        dataTypeWordSet.add(INT);
        dataTypeWordSet.add(LONG);
        dataTypeWordSet.add(DOUBLE);
        dataTypeWordSet.add(CHAR);
        dataTypeWordSet.add(FLOAT);
        dataTypeWordSet.add(SHORT);
        dataTypeWordSet.add(SIGNED);
        dataTypeWordSet.add(UNSIGNED);
        dataTypeWordSet.add(STRUCT);
        dataTypeWordSet.add(UNION);
        dataTypeWordSet.add(ENUM);
        dataTypeWordSet.add(STATIC);
        dataTypeWordSet.add(CONST);
        dataTypeWordSet.add(VOLATILE);
        dataTypeWordSet.add(TYPEDEF);
        dataTypeWordSet.add(EXTERN);
        dataTypeWordSet.add(VOID);
        controlTypeWordSet.add(RETURN);
        controlTypeWordSet.add(SWITCH);
        controlTypeWordSet.add(CASE);
        controlTypeWordSet.add(DEFAULT);
        controlTypeWordSet.add(BREAK);
        controlTypeWordSet.add(CONTINUE);
        controlTypeWordSet.add(REGISTER);
        controlTypeWordSet.add(DO);
        controlTypeWordSet.add(WHILE);
        controlTypeWordSet.add(IF);
        controlTypeWordSet.add(ELSE);
        controlTypeWordSet.add(FOR);
        controlTypeWordSet.add(GOTO);
        controlTypeWordSet.add(SIZEOF);
    }

    public static boolean isCKeyWord(String st) {
        return dataTypeWordSet.contains(st);
    }
    public static boolean isDataTypeKeyWord(String st) {
        return dataTypeWordSet.contains(st);
    }

    public static boolean isControlTypeKeyWord(String st) {
        return controlTypeWordSet.contains(st);
    }
}

class StatementContent {
    private int LineNum; // 行数
    private String content; // 内容
    private String normalizeContent; // 规格化内容
    private int[] features; // 特征向量

    public int getLineNum() {
        return LineNum;
    }

    public void setLineNum(int lineNum) {
        LineNum = lineNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNormalizeContent() {
        return normalizeContent;
    }

    public void setNormalizeContent(String normalizeContent) {
        this.normalizeContent = normalizeContent;
    }

    public int[] getFeatures() {
        return features;
    }

    public void setFeatures(int[] features) {
        this.features = features;
    }
}

enum Features {
    IFDECLARED,
    LOOPDECLARED,
    NOTESDECLARED,
    TYPEDEFINE,
    NORMALASSIGN
}


class StatementBlock {
    // 后续单行合并
    private int startLine;
    private int endLine;

    private StatementBlock[] subStatBlocks;



}