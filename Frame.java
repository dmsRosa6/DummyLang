import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;

/**
 * Class used to initialize frames and store its variables
 */
public class Frame {
    private static final String FRAME = "frame_";

    private String id;
    private Frame previousFrame;
    private Map<String, String> coords;
    private Map<String, ASTNode> initVars;

    public Frame(Frame previousFrame, int nFrame, Map<String, String> coords, Map<String, ASTNode> initVars) {
        this.id = FRAME + nFrame;
        this.previousFrame = previousFrame;
        this.coords = coords;
        this.initVars = initVars;
    }

    public String getId() {
        return id;
    }

    public Frame getPreviousFrame() {
        return previousFrame;
    }

    public String getFrameVariable(String id) {
        if (coords.containsKey(id))
            return coords.get(id);
        return null;
    }

    public boolean hasId(String id) {
        return coords.containsKey(id);
    }

    public ASTNode getFrameNode(String id) {
        if (initVars.containsKey(id))
            return initVars.get(id);
        return null;
    }

    public void writeFrame() throws FileNotFoundException {
        PrintStream f = new PrintStream(new FileOutputStream(id + ".j"));
        f.println(".class public " + id);
        f.println(".super java/lang/Object");
        if (previousFrame != null)
            f.println(".field public sl L" + previousFrame.getId() + ";");
        else
            f.println(".field public sl Ljava/lang/Object;");

        int i = 0;
        for (Map.Entry<String, ASTNode> var : initVars.entrySet()) {
            String type = " I";
            if (var.getValue() instanceof ASTNew)
                type = " Lref_I;";
            f.println(".field public v" + i + type);
            i++;
        }

        f.println("\n");
        f.println(".method public <init>()V");
        f.println("aload_0");
        f.println("invokespecial java/lang/Object/<init>()V");
        f.println("return");
        f.println(".end method");
        f.close();
    }
}