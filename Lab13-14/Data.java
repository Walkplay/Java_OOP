import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Data{

    public double counter;
    public boolean timerLaunched = false;

    private Timer dispatchTimer = new Timer();

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
                counter++;
        }
    };

    public int price = 100000000, seats = 100000000;
    public static String direction;

    public int kyivSeats = 3, rivneSeats = 50, lublinSeats = 30, parisSeats = 5;

    //creating ArrayList for storing Tickets.
    public ArrayList <Papers> ticketDataBase = new ArrayList <>();

    //iterator method
    public void iterator(){
        Iterator itr = ticketDataBase.iterator();

        //traverse elements of ArrayList object
        while(itr.hasNext()){
        	Papers t = (Papers) itr.next();
            System.out.println(t.destination + ": " + t.seatsNumber + " tickets");
        }
    }

    public void startTimer(){
        dispatchTimer.scheduleAtFixedRate(timerTask, 0, 1000);
        timerLaunched = true;
    }

    public void cancelTimer(){
        dispatchTimer.cancel();
        dispatchTimer = new Timer();
        counter = 0;

        timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
            }
        };

    }

    public int priceCounter(int money, int seats){
        price = seats * money;
        return price;
    }

    public String whereToGo(String direction){
        switch(direction){

            case "Kyiv":
                price = 250;
                return direction;

            case "Rivne":
                price = 150;
                return direction;

            case "Lublin":
                price = 1000;
                return direction;

            case "Paris":
                price = 2000;
                return direction;

            default:
                break;
        }

        return "Unknown";
    }

    public int seePrice(String direction){

        int price;

        switch (direction){

            case "Kyiv":
                price = 250;
                return price;

            case "Rivne":
                price = 150;
                return price;

            case "Lublin":
                price = 1000;
                return price;

            case "Paris":
                price = 2000;
                return price;

            default:
                break;
        }

        return 0;
    }

    public int buyTicket(int money){

        int payback;

        if (money >= price) {
            payback = money - price;
            return payback;

        } else {
            return -1;
        }
    }

    public void sell(){
        ticketDataBase.clear();
    }
    
    public int timeToGo(String direction){

        int time;

        switch(direction){

            case "Kyiv":
                time = 20;
                return time;
            case "Rivne":
                time = 10;
                return time;
            case "Lublin":
                time = 120;
                return time;
            case "Paris":
                time = 60;
                return time;

            default:
                return 0;
        }

    }

    public int freeSpace(String direction){
        switch(direction){

            case "Kyiv":
                return kyivSeats;

            case "Rivne":
                return rivneSeats;

            case "Lublin":
                return lublinSeats;

            case "Paris":
                return parisSeats;

            default:
                return 0;
        }
    }

    //to locate mistakes in spelling and recognize the city
    public static void cityMatcher(String input){
        String kyiv = "\\b(?:Kyiv|kyiv|kuiv|Kuiv|kiev|Kiev)\\b";
        String rivne = "\\b(?:Rivne|rivne|Rovno|rovno)\\b";
        String lublin = "\\b(?:Lublin|lublin|lyblin|Lyblin|Liblin|liblin|lablin|Lablin)\\b";
        String paris = "\\bParis|paris|parizh|Parizh\\b";

        Pattern patternKyiv = Pattern.compile(kyiv);
        Pattern patternRivne = Pattern.compile(rivne);
        Pattern patternLublin = Pattern.compile(lublin);
        Pattern patternParis = Pattern.compile(paris);

        Matcher matcherKyiv = patternKyiv.matcher(input);
        Matcher matcherRivne = patternRivne.matcher(input);
        Matcher matcherLublin = patternLublin.matcher(input);
        Matcher matcherParis = patternParis.matcher(input);

        if(matcherKyiv.find()){
            direction = "Kyiv";
        } else if(matcherLublin.find()){
            direction = "Lublin";
        } else if(matcherParis.find()) {
            direction = "Paris";
        } else if(matcherRivne.find()) {
            direction = "Rivne";
        }

    }

}