package ast;

import java.io.*;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Objects;


public class CAstTest{

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
        // 逐行遍历
        HashMap<Integer, StatementContent> content = new HashMap<>();
        boolean noteLines = false;
        while ((stat = bufferedReader.readLine()) != null) {
            if (stat.startsWith("//")) {
                StatementContent statement = new StatementContent();
            }
        }
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
    SIMSTATDECLARED,

}


class StatementBlock {
    // 后续单行合并
    private int startLine;
    private int endLine;

    private StatementBlock[] subStatBlocks;



}