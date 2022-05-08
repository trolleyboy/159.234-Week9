package tutorial9.task1;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class DataOutput {
    public static void main(String[] args) {
        try(var dataOut = new DataOutputStream(new FileOutputStream(".\\tutorial9\\task1\\data.dat"))) {

            LocalDate date1 = LocalDate.of(2020, 12, 3);
            dataOut.writeInt(1009876);
            dataOut.writeDouble(145.50);
            dataOut.writeUTF("DR");
            dataOut.writeUTF(date1.toString());

            LocalDate date2 = LocalDate.of(2020, 11, 30);
            dataOut.writeInt(1876253);
            dataOut.writeDouble(1267.00);
            dataOut.writeUTF("CR");
            dataOut.writeUTF(date2.toString());

            LocalDate date3 = LocalDate.of(2021, 02, 15);
            dataOut.writeInt(1192873);
            dataOut.writeDouble(45.30);
            dataOut.writeUTF("CR");
            dataOut.writeUTF(date3.toString());
            System.out.println("Data written to file");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
