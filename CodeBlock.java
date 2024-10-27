import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CodeBlock {
    private String code[];
    private int pc;
    private Frame currentFrame;
    private List<Frame> all_frames;
    private int label_num;

    public CodeBlock() {
        code = new String[100];
        int pc = 0;
        currentFrame = null;
        all_frames = new LinkedList<>();
        label_num = 0;
    }

    void emit(String opcode) {
        code[pc++] = opcode;
    }

    void dump(PrintStream f) throws IOException {
        File headerStart = new File("HeaderStartFormat.txt");
        File headerEnd = new File("HeaderEndFormat.txt");
        BufferedReader br1 = new BufferedReader(new FileReader(headerStart));
        BufferedReader br2 = new BufferedReader(new FileReader(headerEnd));
        String st;
        while ((st = br1.readLine()) != null)
            f.println(st);

        for (int i = 0; i < pc; i++) {
            f.println(code[i]);
        }

        while ((st = br2.readLine()) != null)
            f.println(st);
    }

    public void setCurrentFrame(Frame f) {
        currentFrame = f;
    }

    public Frame createFrame(Map<String, String> coords, Map<String, ASTNode> initVars) throws FileNotFoundException {
        Frame f = new Frame(currentFrame, all_frames.size(), coords, initVars);
        all_frames.add(f);
        f.writeFrame();
        return f;
    }

    public Frame getCurrentFrame() {
        return currentFrame;
    }

    public int getNewLabel() {
        return ++label_num;
    }
}
