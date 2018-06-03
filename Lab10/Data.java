public class Data {

    public int price = 100000000;
    public boolean bought = false;

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
            bought = true;
            return payback;

        } else {
            return -1;
        }
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
                return 3;

            case "Rivne":
                return 100;

            case "Lublin":
                return 10;

            case "Paris":
                return 1;

            default:
                return 0;
        }
    }

    }
