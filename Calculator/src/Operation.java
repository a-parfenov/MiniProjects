public class Operation implements Argument {
    private final String operation;

    public Operation(String arg) throws ModelException {
        if (arg.equals("+") || arg.equals("-") || arg.equals("*") || arg.equals("/")) {
            operation = arg;
        } else throw new ModelException(ModelException.ERROR_ARGUMENT);
    }

    @Override
    public String getArgument() {
        return this.operation;
    }
}
