import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class TronProtocol {
    private ArrayList<User> users;

    public TronProtocol() {
        users = new ArrayList<User>();
    }

    public String processInput(String input, User u) {
        System.out.println(input);
        if(input != null) {
            if(input.equals("b")) {
                users.remove(u);
                return "b";
            } else {
                int comma1 = input.indexOf("a");
                int comma2 = input.indexOf("a", comma1 + 1);
                u.setX(Integer.parseInt(input.substring(0, comma1)));
                u.setZ(Integer.parseInt(input.substring(comma1 + 1, comma2)));
                u.setAngle(Integer.parseInt(input.substring(comma2 + 1)));
            }
        }
        String output = users.size() + "a" + u.getColorID();
        for(User user : users) {
            if(user != u)
                output += user.getColorID() + "" + user.getX() + "a" + user.getZ() + "a" + (user.getAngle()) + "a";
        }
        System.out.println(output);
        return output; 
    }

    public void addUser(User u) {
        users.add(u);
    }

    public void removeUser(User u) {
        users.remove(u);
    }
}