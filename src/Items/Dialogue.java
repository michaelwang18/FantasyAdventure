import java.util.Scanner;

public class Dialogue {
    String message;
    Object[] options;

    Scanner scan = new Scanner(System.in);

    public Dialogue(String message, Object[] opt){
        this.message = message;
        options = opt;
    }


    public void start(){
        System.out.println(message);
        int value = Utility.tryInput(scan.nextLine(),options.length) - 1;
        if (options[value] instanceof String){System.out.println((String) options[value]);}
        if (options[value] instanceof Dialogue){((Dialogue) options[value]).start();}
        if (options[value] instanceof Shop){((Shop) options[value]).menu();}



        //AND EVEN MORE SHIT





    }







}
