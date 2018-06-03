
import java.util.Scanner;

public class AutoStation {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        Data information = new Data();

        boolean flag, secondFlag = false;
        String numberInput;

        System.out.println(" <>-----------------<> WELCOME TO THE 'LVIV HEART' AUTO STATION! <>----------------<> \n");

        //Terminal "Home Screen"
        while(true) {

            System.out.println("Please, input the city to see more information: 'Kyiv', 'Rivne', 'Lublin', 'Paris' \n" +
                    "    [tickets] - Your tickets \n    [time] - When your transport will dispatch \n  " +
                    "  [sell] - sell all tickets and leave \n    [exit] - Exit program");

            Data.direction = scanner.next();

            Data.cityMatcher(Data.direction);

            System.out.println("<>---------------<> " + Data.direction + " <>---------------<>");

            if(Data.direction.equals("tickets")){
                information.iterator();
                continue;

            } else if(Data.direction.equals("time")) {

                double minutesLeft = 10 - (information.counter / 60);

                if(minutesLeft <= 1){
                    System.out.println("hurry up, there's only " + minutesLeft * 60 + " seconds left! \n");
                } else if(minutesLeft < 10){
                    System.out.println("Dispatching in " + minutesLeft
                            + " minutes. \n");
                }
                continue;

            } else if(Data.direction.equals("exit")){
                break;

            } else if(Data.direction.equals("No city chosen")){
                continue;

            } else if(Data.direction.equals("sell")) {

                //cancel after sometime
                information.sell();
                information.cancelTimer();
                System.out.println("TimerTask cancelled");
                continue;
            }

            flag = true;

            while (flag) {

                System.out.println("    [0] - Seats left \n    [1] - What's the price \n    " +
                        "[2] - Confirm the city and buy tickets \n    [3] - Back \n");

                numberInput = scanner.next();


                switch (numberInput) {

                    case "0":
                        System.out.println("There are/is " + information.freeSpace(Data.direction) + " seat/seats left.");
                        break;

                    case "1":
                        System.out.println("The price is " + information.seePrice(Data.direction) + " UAH.");
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

                    do{
                        information.seats = scanner.nextInt();

                        if (information.seats > information.freeSpace(Data.direction)) {
                            System.out.println("There are not so many seats left, sorry.");
                        } else if (information.seats == -1) {
                            secondFlag = false;
                            break;
                        }
                    } while (information.seats > information.freeSpace(Data.direction));

                    if(!secondFlag){
                        break;
                    }

                    int localPrice = information.priceCounter(information.price, information.seats);

                    System.out.println("Pay " + localPrice + " UAH for the ticket: ");

                    money = scanner.nextInt();

                    if (money == -10) {
                        secondFlag = false;
                        break;
                    }

                    if (information.buyTicket(money) >= 0) {

                        if(information.buyTicket(money) == 0) {
                            System.out.println("Thank you and good luck!");
                        } else {
                            System.out.println("Payback of " + information.buyTicket(money) + " UAH. Thank you and good luck!");
                        }

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
                        information.seats = 0;

                        //Starting timer
                        if(information.timerLaunched) {
                            information.cancelTimer();
                            information.timerLaunched = false;
                        }

                        information.cancelTimer();
                        information.startTimer();
                        System.out.println("Hurry up, 10 minutes left before Your departure! \n");

                        secondFlag = false;
                        flag = false;
                        break;

                    } else {
                        System.out.println("Not enough money. input -10 to Exit");
                    }

                }
            }

        }

    }
}