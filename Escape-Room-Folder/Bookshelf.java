public class Bookshelf{
    private Paper p; //allows me to use the functions from the paper class
    private String shelf1;
    private String shelf2;
    private String shelf3;

    public Bookshelf(){ //allows me to get what I set the variable to in my driver class
        this.p = new Paper();
        p.setCode(4978);
        p.setName("Parchment Paper");
        this.shelf1 = "On the topmost shelf you notice a bunch of coding books. While they seem interesting, you're here to have fun not learn. So you continue looking elsewhere.";
        this.shelf2 = "In the middlemost shelf you notice it has a bunch of manga based on one piece. Knowing that you'll waste time reading you quickly pull yourself back.";
        this.shelf3 = "On the bottommost shelf you notice something sticking out." + " Reading it you find a piece of " + p.toString();
    }

    public Paper getPaper(){ //allows me ti get what I set the paper variable to in my driver class
        return this.p;
    }
    
    public String getShelf1(){
        return this.shelf1;
    }

    public String getShelf2(){
        return this.shelf2;
    }

    public String getShelf3(){
        return this.shelf3;
    }
}
