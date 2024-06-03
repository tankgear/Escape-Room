public class Paper extends KeyItem{
    private int code;

    public Paper(){
        super(" ");
        this.code = 0;
    }
    
    public Paper(int code, String name){
        super(name);
        this.code = code;
        
    }

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public String toString(){
        return getName() + " with code: " + code;
    }

    
}
