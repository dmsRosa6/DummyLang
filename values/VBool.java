public class VBool implements IValue{

    boolean v;

    public VBool(boolean v){
        this.v = v;
    }

    @Override
    public String toString() {
        return Boolean.toString(v);
    }

    public boolean getValue(){
        return  v;
    }
}
