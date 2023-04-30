
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, String> contacts = new HashMap<>();

    public void load(String filename) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                String[] contactData = line.split(",");
                if (contactData.length == 2) {
                    contacts.put(contactData[0], contactData[1]);
                } else {
                    System.out.println("Error en el formato de la línea: " + line);
                }
            }

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Map.Entry<String, String> contact : contacts.entrySet()) {
                bw.write(contact.getKey() + "," + contact.getValue() + "\n");
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void list() {
        System.out.println("Contactos:");
        for (Map.Entry<String, String> contact : contacts.entrySet()) {
            System.out.println(contact.getKey() + " : " + contact.getValue());
        }
    }

    public void create(String phoneNumber, String name) {
        contacts.put(phoneNumber, name);
    }

    public void delete(String phoneNumber) {
        contacts.remove(phoneNumber);
    }
}
