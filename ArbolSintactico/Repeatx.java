package ArbolSintactico;

public class Repeatx extends Statx {
    private Expx condition;
    private Statx body;
    
    public Repeatx(Statx body, Expx condition) {
        this.condition = condition;
        this.body = body;
    }

    public Object[] getVariables() {
        return new Object[] { body, condition };
    }
    public Expx getCondition() {
        return condition;
    }

    public Statx getBody() {
        return body;
    }

}
