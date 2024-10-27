public class ASTId implements ASTNode {
    private String id;

    ASTId(String id) {
        this.id = id;
    }

    @Override
    public IValue eval(Environment<IValue> e) {
        return e.find(id);
    }

    @Override
    public void compile(CodeBlock c, Environment<IValue> e) {
        c.emit("aload 3");

        Frame currentFrame = c.getCurrentFrame();
        Frame previousFrame = null;

        if (currentFrame != null)
            previousFrame = currentFrame.getPreviousFrame();

        while (previousFrame != null && !currentFrame.hasId(id)) {
            c.emit("getfield " + currentFrame.getId() + "/sl L" +
                    previousFrame.getId() + ";");
            currentFrame = previousFrame;
            previousFrame = currentFrame.getPreviousFrame();
        }

        if (currentFrame != null) {
            String type = " I";
            if (currentFrame.getFrameNode(id) != null) {
                if (currentFrame.getFrameNode(id) instanceof ASTNew)
                    type = " Lref_I;";
            }
            c.emit("getfield " + currentFrame.getId() + "/" + currentFrame.getFrameVariable(id) + type);
        }

        c.emit("\n");
    }
}
