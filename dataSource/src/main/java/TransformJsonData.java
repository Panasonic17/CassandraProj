import org.json.simple.parser.ParseException;

import java.io.*;

/**
 * Created by Oleksandr_Shainoga on 11/6/2017.
 */
public class TransformJsonData {
    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = null;
        FileReader fr = null;
        fr = new FileReader("testDataFrame.txt");
        br = new BufferedReader(fr);
        String sCurrentLine;
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter("testDataFrameCSV.txt");
        bw = new BufferedWriter(fw);
        while ((sCurrentLine = br.readLine()) != null) {
            bw.write(JsonConventorToCsv.convert(sCurrentLine)+'\n');
        }
        br.close();
        fr.close();
        bw.flush();
        bw.close();
        fw.close();
    }
}

