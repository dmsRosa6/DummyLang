public class VString implements IValue{
    String value;

    public VString(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return this.value;
    }

}
