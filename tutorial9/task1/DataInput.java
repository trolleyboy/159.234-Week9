package tutorial9.task1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataInput {
    public static void main(String[] args) {

        System.out.println("Account Number\tAmount\tTransactionType\tDate");
        try(var dataIn = new DataInputStream(new FileInputStream(".\\tutorial9\\task1\\data.dat"))) {
            while (dataIn.available() > 0) {
                int accountNumber = dataIn.readInt();
            double amount = dataIn.readDouble();
            String transactionType = dataIn.readUTF();
            String dateIn = dataIn.readUTF();
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("y-M-d");
            LocalDate date = LocalDate.parse(dateIn, dateFormat);
            System.out.println(accountNumber + "\t\t" + amount + "\t" + transactionType + "\t\t" + date);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
