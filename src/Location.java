import java.util.ArrayList;

public class Location {

    Dialogue interactables;
    String name;

    public Location(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }
    public void addInteract(Dialogue dialogue){}
    public void listActions(){
       interactables.start();

        }


    }



}
