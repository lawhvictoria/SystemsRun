package control;
public enum Key {

    LEFT('a'), 
    RIGHT('d'), 
    UP('w'), 
    DOWN('s');

    public char k;

    Key(char key) {
        this.k = key;
    }
}
