public class KeyItem {
    public String name;

    public KeyItem(){
        this.name = "";
    }
    
    public KeyItem(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
