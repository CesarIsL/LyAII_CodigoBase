package ArbolSintactico;

public class Whilex extends Statx {
    private Expx condition;
    private Statx body;

    public Whilex(Expx condition, Statx body) {
        this.condition = condition;
        this.body = body;
    }

    public Object[] getVariables() {
        return new Object[] { condition, body };
    }

    public Expx getCondition() {
        return condition;
    }
    public Statx getBody() {
        return body;
    }
}
