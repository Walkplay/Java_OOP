import java.util.Objects;
import java.util.Scanner;

public class AutoStation {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        Data information = new Data();

        boolean flag = true, secondFlag = false;
        String direction;
        int number;

        System.out.println("Welcome to the Lviv Auto Station. How can we help You?");

        while(true) {

            System.out.println("Please, input the city to see more information: 'Kyiv', 'Rivne', 'Lublin', 'Paris' \n" +
                    "   [E] to Exit ");

            direction = scanner.next();

            if(direction.equals("E")){
                break;
            }

            while (flag) {

                System.out.println("\n    [0] - Seats left \n    [1] - What's the price \n    " +
                        "[2] - Confirm the city and buy tickets \n    [3] - Back \n");

                number = scanner.nextInt();

                switch (number) {

                    case 0:
                        System.out.println("There are/is " + information.freeSpace(direction) + " seat/seats left.");
                        break;

                    case 1:
                        System.out.println("The price is " + information.seePrice(direction) + "$.");
                        break;

                    case 2:
                        System.out.println("You are heading to " + information.whereToGo(direction) + ".");
                        secondFlag = true;
                        break;

                    case 3:
                        flag = false;
                        break;

                    default:
                        System.out.println("Wrong input, retry:");
                        break;
                }

                //Buying process:

                while (secondFlag) {
                    int money;
                    int seats = 9999999;

                    System.out.println("How many tickets do you want? (" + information.freeSpace(direction) + " left) \n" +
                            "Enter [-1] to Exit.");
                    while (seats > information.freeSpace(direction)) {
                        seats = scanner.nextInt();

                        if (seats > information.freeSpace(direction)) {
                            System.out.println("There are not so many seats left, sorry.");
                        } else if (seats == -1) {
                            secondFlag = false;
                            break;
                        }
                    }

                    System.out.println("Pay " + information.price + "$ for the ticket: ");
                    money = scanner.nextInt();

                    if (money == -10) {
                        secondFlag = false;
                        break;
                    }

                    if (information.buyTicket(money) == 0) {
                        System.out.println("Thank you and good luck!");
                    } else if (information.buyTicket(money) != -1) {

                        System.out.println("Payback of " + information.buyTicket(money) + "$. Thank you and good luck!");
                        secondFlag = false;
                        flag = false;
                        break;

                    } else {
                        System.out.println("Not enough money. input -10 to Exit");
                    }

                }
            }

            if(information.bought){

                while(!flag) {
                    System.out.println("\n [1] to see time to go \n [2] to Exit Terminal");

                    int num;
                    num = scanner.nextInt();
                    switch (num) {
                        case 1:
                            System.out.println("Time for departure to " + direction + " is " + information.timeToGo(direction)
                                    + " minutes.");
                            break;
                        case 2:
                            flag = true;
                            break;

                    }
                }
            }

        }

    }
}