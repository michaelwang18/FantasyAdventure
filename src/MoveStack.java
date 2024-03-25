import java.util.ArrayList;


public class MoveStack {
    private ArrayList<String> internalList;


    public MoveStack() {
        internalList = new ArrayList<String>();
    }


    //isEmpty() returns true if nothing is on the top of the stack.
    //Otherwise, returns false.
    public boolean isEmpty() {
        if (internalList.size() == 0){
            return true;
        }
        return false;
    }


    //push() adds an element to the top of the stack.
    public void push(String item) {
        internalList.add(item);
    }


    //pop() removes and returns the top element of the stack.
    //If pop() is called when the stack is empty, returns null instead.
    public String pop() {
        return internalList.remove(internalList.size()-1);
    }


    //peek() returns the top element of the stack but does not remove it.
    //If pop() is called when the stack is empty, returns null instead.
    public String peek() {
        return internalList.get(internalList.size()-1);
    }


    //size() returns the number of elements in the stack.
    public int size() {
        return internalList.size();
    }


    //clear() removes all elements from the stack.
    public void clear() {
        internalList = new ArrayList<String>();
    }


    //toString() should return a String containing the name of each Webpage in the stack.
    //Each Webpage name should be on a new line and arranged such that
    //The top of the stack is the first line and the bottom of the stack is the last line.
    @Override
    public String toString() {
        String resp = "\n Current: ";
        for (int i = 0; i < size(); i++){
            String action = internalList.get(i);
            if (internalList.get(i).contains(",")){
                String target = "Yourself";
                String[] data = internalList.get(i).split(",");
                if (data[7].equals("2") ){ target = "Enemy";}
                action = "Use " + data[1] + "On " + target;
            } // Clearify what you do with potion
            resp += "\n " + (i + 1) + ") " + action;
        }
        return resp;
    }
}
