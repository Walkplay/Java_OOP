
import java.util.*;

public class Program {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        Holder<String> collector = new Holder<>();
        Holder<String> revertedCollector = new Holder<>();
        
            String text;
            String reverted;
            System.out.println("Input some text:");
            text = scanner.nextLine();

            StringBuilder sb = new StringBuilder(text);
            reverted = sb.reverse().toString();

            for (String splitted: text.split(" ")) {
                collector.add(splitted);
            }

            //Iterator for normal
            /*
            for(int i = 0; i < collector.size; i++){
                System.out.println(collector.get(i));
            }
            */

            for (String splitted: reverted.split(" ")) {
                revertedCollector.add(splitted);
            }

            // Iterator for reverted:
            /*
            for(int i = 0; i < collector.size; i++){
                System.out.println(revertedCollector.get(i));
            }
            */
            if(collector.contains("app")){
                System.out.println(collector.indexOf("app"));
                System.out.println(collector.get(collector.indexOf("app")));
            }

            System.out.println(new Program().intersection(collector, revertedCollector));

            //getting Collector as array, and outputting its length
            System.out.println(collector.toArray().length);

           // collector.removeAt(1);

        }

        private<T> String intersection(Holder<T> collector1, Holder<T> collector2) {

            T t;
            String inters = "";
            int count = 0;

            for (int i = 0; i < collector1.size(); i++) {

                t = collector1.get(i);
                if (collector2.contains(t)) {
                    inters = inters + "|" + t.toString() + "| ";

                    count++;
                    if(count %3 == 0){
                        inters = inters + "\n";
                    }
                }
            }

            return inters;
        }
    }