public class Safe{
    private Key k; //allows me to use the functions from the key class
    private Paper p;
    private int code;
    private String keypad;

    public Safe(){ //hard set what the variables should be which is why there are only getters
        this.k = new Key();
        this.p = new Paper();
        k.setColor("Red");
        k.setName("Demon Key");
        p.setCode(4978); //allows the p.getcode function below to work properly and not return 0
        code = 4978;
        this.keypad = "You enter the code " + p.getCode() + " and the safe opens." + " Inside you find a " + k.toString() +"."; 
    }

    public Key getKey(){ //allows me to get what I set the key variable to in my driver class
        return this.k;
    }

    public int getCode(){
        return code;
    }
    
    public String getKeypad(){
        return this.keypad;
    }
}
