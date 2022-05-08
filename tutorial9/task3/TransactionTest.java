package tutorial9.task3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TransactionTest implements Serializable {
    private ArrayList<Transaction> importedTransactions = new ArrayList<Transaction>(3);
    private File outFile = new File("transactions.dat");
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>(3);
    
    @BeforeAll
    static void setup() {
        
        Transaction t1 = new Transaction(1009876, 145.50, "DR", LocalDate.of(2020, 12, 3));
        Transaction t2 = new Transaction(1876253, 1267.00, "CR", LocalDate.of(2020, 11, 30));
        Transaction t3 = new Transaction(1192873, 45.30, "CR", LocalDate.of(2021, 2, 15));
        transactions.add(t1);
        transactions.add(t2);
        transactions.add(t3);
    }

    @Test
    void testWriteFile() {
        try (var objectOut = new ObjectOutputStream(new FileOutputStream(outFile))) {
            for (Transaction t : transactions) {
                objectOut.writeObject(t);
                assertNotNull(t);
                objectOut.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Test
    void testReadFile() {
        try (var objectOut = new ObjectOutputStream(new FileOutputStream(outFile))) {
            for (Transaction t : transactions) {
                objectOut.writeObject(t);
                assertNotNull(t);
                objectOut.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        try (var fileStream = new FileInputStream(outFile)) {
            var objectIn = new ObjectInputStream(fileStream);
            while (fileStream.available() > 0) {
                importedTransactions.add((Transaction)objectIn.readObject());
            }
            assertEquals(145.50, importedTransactions.get(0).getAmount());
            objectIn.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } 
    }

    @Test
    void testToString() {
        try (var objectOut = new ObjectOutputStream(new FileOutputStream(outFile))) {
            for (Transaction t : transactions) {
                objectOut.writeObject(t);
                assertNotNull(t);
                objectOut.close();
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        try (var fileStream = new FileInputStream(outFile)) {
            var objectIn = new ObjectInputStream(fileStream);
            while (fileStream.available() > 0) {
                importedTransactions.add((Transaction)objectIn.readObject());
            }
            assertEquals(145.50, importedTransactions.get(0).getAmount());
            objectIn.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } 
        assertEquals("Transaction [accountNumber=1009876, amount=145.5, date=2020-12-03, transactionType=DR]", importedTransactions.get(0).toString());
    }
}
