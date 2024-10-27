import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class ASTDef implements ASTNode {

    ASTNode body;
    Map<String, ASTNode> initVars; // initialized vars, with id and node (ex: x = ASTNum(1))

    public ASTDef(Map<String, ASTNode> initVars, ASTNode body) {
        this.initVars = initVars;
        this.body = body;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        IValue value;
        Environment<IValue> env = e.beginScope();
        for (Map.Entry<String, ASTNode> entry : initVars.entrySet()) {
            env.assoc(entry.getKey(), entry.getValue().eval(env));
        }
        value = body.eval(env);
        env.endScope();
        return value;
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) throws FileNotFoundException {
        Environment<IValue> newEnv = e.beginScope();
        Map<String, String> coords = new HashMap<String, String>();
        // set frame variables v0,v1,etc..
        for (Map.Entry<String, ASTNode> var : initVars.entrySet()) {
            coords.put(var.getKey(), "v" + coords.size());
        }
        Frame newFrame = c.createFrame(coords, initVars);
        String newFrameName = newFrame.getId();
        Frame previousFrame = newFrame.getPreviousFrame();

        c.setCurrentFrame(newFrame);
        frameInit(c, newFrameName);

        if (previousFrame != null)
            c.emit("putfield " + newFrameName + "/sl L" + previousFrame.getId() + ";");
        else
            c.emit("putfield " + newFrameName + "/sl Ljava/lang/Object;");

        c.emit("astore 3");
        c.emit("\n");

        int order = 0;
        for (Map.Entry<String, ASTNode> entry : initVars.entrySet()) {
            String type = " I";
            if (entry.getValue() instanceof ASTAssign || entry.getValue() instanceof ASTNew) {
                if (!e.hasRef())
                    e.createCompilerRefClass();
                type = " Lref_I;";
            }
            c.emit("aload 3");
            entry.getValue().compile(c, newEnv);
            c.emit("putfield " + newFrameName + "/v" + order + type);
            c.emit("\n");
            order++;
        }
        body.compile(c, newEnv);
        frameEnd(c);
    }

    private void frameInit(CodeBlock c, String frameName) {
        c.emit("\n");
        c.emit("new " + frameName);
        c.emit("dup");
        c.emit("invokespecial " + frameName + "/<init>()V");
        c.emit("dup");
        c.emit("aload 3");
    }

    private void frameEnd(CodeBlock c) {
        c.emit("aload 3");
        Frame currentFrame = c.getCurrentFrame();
        Frame previousFrame = currentFrame.getPreviousFrame();
        c.setCurrentFrame(currentFrame.getPreviousFrame());
        if (previousFrame != null)
            c.emit("getfield " + currentFrame.getId() + "/sl L" +
                    previousFrame.getId() + ";");
        else
            c.emit("getfield " + currentFrame.getId() + "/sl Ljava/lang/Object;");
        c.emit("astore 3");
    }

}
