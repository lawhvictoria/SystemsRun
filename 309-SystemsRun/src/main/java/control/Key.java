package Control;
public enum Key {

    LEFT('a'), 
    RIGHT('d'), 
    UP('w'), 
    DOWN('s');

    public char key;

    Key(char key) {
        this.key = key;
    }
}
