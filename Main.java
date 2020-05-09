import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    
    public Main(String path) {
        String data = this.readFile(path);
        // System.out.println(data);
        this.extract(data);
    }

    private String readFile(String path) {
        String data = "";
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
            e.printStackTrace();
        }
        return data;
    }

    private void extract(String data) {
        // 1st Split
        String[] lines = data.split("\n");
        
        for(String line : lines){
            String[] info = line.split(" ");
            String name = info[0];

            String[] shapeInfo = info[1].split("_");

            if(shapeInfo[0].compareTo("C") == 0) {
                if(shapeInfo[1].indexOf("x") < 0) {
                    System.out.println("Circle");

                }
                else {
                    String[] str_size = shapeInfo[1].split("x");
                    if(str_size.length == 1) {
                        System.out.println("Sphere");

                    }
                    else {
                        System.out.println("Cylinder");

                    }
                }
            }
            else if(shapeInfo[0].compareTo("R") == 0) {
                String[] str_size = shapeInfo[1].split("x");
                if(str_size.length == 2) {
                    System.out.println("Rectangle");

                }
                else {
                    System.out.println("Cuboid");

                }
            }
        }
    }

    public static void main(String[] args) {
        Main m = new Main(args[0]);
    }
}