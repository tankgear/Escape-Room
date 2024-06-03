public class Key extends KeyItem{
    private String color;

    public Key(){
        super("");
        this.color = "";
    }
    
    public Key(String color, String name){
        super(name);
        this.color = color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String toString(){
        return color + " " + getName();
    }
   
}
