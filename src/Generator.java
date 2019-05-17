import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Set;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Generator implements Runnable {
    public void run(){

    }
    public static void main(String[] args) {

        ArrayList<String> allPlaces = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hur många platser på fil vill du skapa?");
        int numberOfPlaces = scanner.nextInt();




        Random random = new Random();
        String place;

        long starttid = System.currentTimeMillis();
        Set<Double> xCoordinates = new HashSet<>();
        while (xCoordinates.size() < numberOfPlaces) {
            double x = (1 + ( 950 - 1) * random.nextDouble());
            x = (double)Math.round(x * 1000000d) / 1000000d;
            xCoordinates.add(x);
        }

        List<Double> xCoordinatesList = new ArrayList<Double>(xCoordinates);


        Set<Double> yCoordinates = new HashSet<>();
        while (yCoordinates.size()< numberOfPlaces) {
            double y = 1 + (800 - 1) * random.nextDouble();
            y = (double) Math.round(y * 1000000d) / 1000000d;
            yCoordinates.add(y);
        }

        List<Double> yCoordinateList = new ArrayList<Double>(yCoordinates);
        long sluttid = System.currentTimeMillis();

        for (int i = 0; i < numberOfPlaces; i++){
            int r = random.nextInt(2);
            if (r == 0)
                place = "Named,";
            else
                place = "Described,";

            int r2 = random.nextInt(4);

            switch (r2){
                case 0: place += "None,";
                    break;
                case 1: place += "Bus,";
                    break;
                case 2: place += "Underground,";
                    break;
                case 3: place += "Train,";
            }

            int randomNum = ThreadLocalRandom.current().nextInt(1, 777 + 1);

            place += xCoordinatesList.get(i) + "," + yCoordinateList.get(i) + "," + "Linje " + randomNum + ",";

            String randomPoetry;
            if (r!=0){
                int r3 = random.nextInt(10);
                switch (r3){
                    case 0: place += "Visst gör det ont när knoppar brister";
                        break;
                    case 1: place += "Varken varken eller eller";
                        break;
                    case 2: place += "Du sökte en blomma...";
                        break;
                    case 3: place += "April is the cruelest of months";
                        break;
                    case 4: place += "Upp gå till jobbet, jobba jobba äta lunch";
                        break;
                    case 5: place += "Ooops I did it again.";
                        break;
                    case 6: place += "Ra ra ooh la la";
                        break;
                    case 7: place += "Femton gastar";
                        break;
                    case 8: place += "Välkommen hem";
                        break;
                    case 9: place += "Gag aga zum tung tang.";
                        break;


                }
            }

            allPlaces.add(place);


        }


        try{
            FileWriter saveFile = new FileWriter("TestSpar.txt");
            PrintWriter out = new PrintWriter(saveFile);
            for (String string: allPlaces) {
                out.println(string);
                System.out.println(string);

            }

            out.close();


            long totalTid = (sluttid - starttid);
            System.out.println(totalTid);

        }
        catch (IOException e){
            System.out.println(e.getMessage());

        }

    }

}










