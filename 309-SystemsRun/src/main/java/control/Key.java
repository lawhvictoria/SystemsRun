package control;
public enum Key {

    LEFT('a'), 
    RIGHT('d'), 
    UP('w'), 
    DOWN('s');

    private char k;

    Key(char key) {
        this.k = key;
    }
    
    public char getKey() {
        return k;
    }
}
