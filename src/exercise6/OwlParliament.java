package exercise6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class OwlParliament
 * @author yasiro01
 */
public class OwlParliament {
    private ArrayList<Owl> parliament = new ArrayList();
    
    public OwlParliament (String filename) throws FileNotFoundException, IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(filename));
        String name = "";
        int age = 0;
        String line;
        while ((line = inputFile.readLine()) != null) {
            String[] animal = line.split(",");
            if("Owl".equals(animal[2])) {
                name = animal[0];
                age = Integer.parseInt(animal[1]);
                Owl tempOwl = new Owl(name, age);
                parliament.add(tempOwl);
            }
        }
        
    }
    public int size() {
        return parliament.size();
    }
    
    public Owl getChief() {
        Owl chief = new Owl("", 0);
        Owl tempOwl = null;
        for (int i = 0; i < parliament.size(); i++) {
            if (chief.getAge() <= parliament.get(i).getAge()) {
                chief = parliament.get(i);
            }
        } return chief;
    }
}
