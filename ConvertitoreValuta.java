import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

public class ConvertitoreValuta extends JFrame{
    JLabel amount, fromValue, toValue;
    JTextField tfAmout, tfFrom, tfTo;

    JComboBox BoxFrom = new JComboBox(); //lista dropdown
    JComboBox BoxTo = new JComboBox();
    
    //Serve per mappare un chiave ad un valore, quindi una Stringa a Double in questo caso
    private HashMap<String, Double> HMap = new HashMap<String, Double>();
    private ArrayList<String> List = new ArrayList<String>(); //Lista di tutte le valute prese da un URL
    private ArrayList<String> currencies = new ArrayList<String>();

    DecimalFormat df = new DecimalFormat("####.00");

    public void Convertitore() throws Exception {
        try {
            URL ECB = new URL("https://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml");
            BufferedReader in = new BufferedReader(new InputStreamReader(ECB.openStream()));
            FileWriter fw = new FileWriter("Valute.xml");
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
                fw.write(inputLine);
                String buff = inputLine;
            }

            in.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        String[] patternExamples = { "EUR", "USD" };
        
        currencies.addAll(HMap.keySet());
    }
    
}
