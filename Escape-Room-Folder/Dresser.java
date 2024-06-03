public class Dresser{
    private Key k; //allows me to use the functions from the key class
    private String drawer1;
    private String drawer2;
    private String drawer3;

    public Dresser(){ //hard set what the variables should be which is why there are only getters
        this.k = new Key();
        k.setColor("Green");
        k.setName("Dragon Key");
        this.drawer1 = "You open the first drawer and inside is a bunch of pokemon cards. They have no use, so you close the drawer.";
        this.drawer2 = "You open the second drawer and inside you find a " + k.toString() + ".";
        this.drawer3 = "You open the third drawer and find nothing inside, so you close the drawer.";
    }
    
    public Key getKey(){ //allows me to get what I set the key variable to in my driver class
        return this.k;
    }

    public String getDrawer1(){
        return this.drawer1;
    }

    public String getDrawer2(){
        return this.drawer2;
    } 

    public String getDrawer3(){
        return this.drawer3;
    }
}
