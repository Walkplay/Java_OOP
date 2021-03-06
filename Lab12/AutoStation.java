import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AutoStation {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        Data information = new Data();

        boolean flag = true, secondFlag = false;
        String numberInput, numInput;

        System.out.println(" <>-----------------<> WELCOME TO THE 'LVIV HEART' AUTO STATION! <>----------------<> \n");

        //Terminal "Home Screen"
        while(true) {

            flag = true;

            System.out.println("Please, input the city to see more information: 'Kyiv', 'Rivne', 'Lublin', 'Paris' \n" +
                    "    [tickets] - Your tickets \n    [time] - When your transport will dispatch \n    [exit] - Exit program");

            Data.direction = scanner.nextLine();

            Data.cityMatcher(Data.direction);

            System.out.println("<>---------------<> " + Data.direction + " <>---------------<>");

            if(Data.direction.equals("tickets")){
                information.iterator();
                continue;

            } else if(Data.direction.equals("exit")){
                break;
            } else if(Data.direction.equals("No city chosen")){
                continue;
            }

            switch (Data.direction) {
                case "time":
                    System.out.println("Input city: ");
                    String city = scanner.next();
                    System.out.println("Dispatching to " + city + " in " + information.timeToGo(city)
                            + " minutes.");
                    break;
            }

            while (flag) {

                System.out.println("\n    [0] - Seats left \n    [1] - What's the price \n    " +
                        "[2] - Confirm the city and buy tickets \n    [3] - Back \n");

                numberInput = scanner.next();


                switch (numberInput) {

                    case "0":
                        System.out.println("There are/is " + information.freeSpace(Data.direction) + " seat/seats left.");
                        break;

                    case "1":
                        System.out.println("The price is " + information.seePrice(Data.direction) + "$.");
                        break;

                    case "2":
                        System.out.println("You are heading to " + information.whereToGo(Data.direction) + ".");
                        secondFlag = true;
                        break;

                    case "3":
                        flag = false;
                        break;

                    default:
                        System.out.println("Wrong input, retry:");
                        break;
                }

                //Buying process:

                while (secondFlag) {
                    int money;

                    System.out.println("How many tickets do you want? (" + information.freeSpace(Data.direction) + " left) \n");

                    while (information.seats > information.freeSpace(Data.direction)) {

                        information.seats = scanner.nextInt();

                        if (information.seats > information.freeSpace(Data.direction)) {
                            System.out.println("There are not so many seats left, sorry.");
                        } else if (information.seats == -1) {
                            secondFlag = false;
                            break;
                        }
                    } if(!secondFlag){
                        break;
                    }

                    int localPrice = information.priceCounter(information.price, information.seats);

                    System.out.println("Pay " + localPrice + "$ for the ticket: ");

                    money = scanner.nextInt();

                    if (money == -10) {
                        secondFlag = false;
                        break;
                    }

                    if (information.buyTicket(money) >= 0) {

                        if(information.buyTicket(money) == 0) {
                            System.out.println("Thank you and good luck!");
                        } else {
                            System.out.println("Payback of " + information.buyTicket(money) + "$. Thank you and good luck!");
                        }

                        secondFlag = false;
                        flag = false;

                        switch (Data.direction){
                            case "Kyiv":
                                information.kyivSeats = information.kyivSeats - information.seats;
                                break;

                            case "Rivne":
                                information.rivneSeats = information.rivneSeats - information.seats;
                                break;

                            case "Lublin":
                                information.lublinSeats = information.lublinSeats - information.seats;
                                break;

                            case "Paris":
                                information.parisSeats = information.parisSeats - information.seats;
                                break;
                        }

                        Papers ticket = new Papers(Data.direction, information.seats);
                        information.ticketDataBase.add(ticket);
                        break;

                    } else {
                        System.out.println("Not enough money. input -10 to Exit");
                    }

                }
            }

        }

    }
}