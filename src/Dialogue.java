import java.util.Scanner;

public class Dialogue {
    String name;
    String message;
    Object[] options;


    Scanner scan = new Scanner(System.in);

    public Dialogue(String name, String message, Object[] opt){
        this.message = message;
        options = opt;
    }


    public void start(Player player){
        System.out.println(message);
        int value = Utility.tryInput(scan.nextLine(),options.length) - 1;
        if (options[value] instanceof String){System.out.println((String) options[value]);}
        if (options[value] instanceof Dialogue){((Dialogue) options[value]).start(player);}
        if (options[value] instanceof Shop){((Shop) options[value]).menu(player);}
        if (options[value] instanceof Battle){((Battle) options[value]).start();}
        //Fishing




        //AND EVEN MORE SHIT





    }







}
