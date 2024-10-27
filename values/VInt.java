public class VInt implements IValue{
    int v;

    public VInt(int v){
        this.v = v;
    }


    @Override
    public String toString() {
        return  Integer.toString(v);
    }

    public int getValue(){
        return v;
    }
}
