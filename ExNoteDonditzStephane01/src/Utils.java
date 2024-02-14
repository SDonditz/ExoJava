import java.util.List;
import java.util.Objects;

public class Utils {

    public static int reste;

    public static int divideDate(int secondes, int divideBy) {
        Time time = new Time();

        if(secondes > divideBy){
            int result = secondes / divideBy;
            reste = secondes % divideBy;
            return result;
        } else {
            reste = secondes;
            return 0;
        }
    }

    public static String concatValue(String who, int howMany, boolean exception) {
        String result = "";
        if(exception) {
            if(howMany > 0) {
                result += howMany + " " + who;
            }
        } else {
            if(howMany > 0) {
                result += howMany + " " + who + addS(howMany);
            }
        }
        return result;
    }

    public static String addS(int number) {
        String result = "";
        if(number > 1) {
            result += "s";
        }
        return result;
    }

    public static String addPunctuation(List<String> chainToPunctuate) {
        String result = "";
        for(int i = 0; i < chainToPunctuate.size(); i++) {
            if(!Objects.equals(chainToPunctuate.get(i), "")) {
                if (i == chainToPunctuate.size() - 1) {
                    result += chainToPunctuate.get(i) + ".";
                } else if (i == chainToPunctuate.size() - 2) {
                    if(Objects.equals(chainToPunctuate.get(chainToPunctuate.size() - 1), "")) {
                        result += chainToPunctuate.get(i) + ".";
                    } else {
                        result += chainToPunctuate.get(i) + " et ";
                    }
                } else {
                    result += chainToPunctuate.get(i) + ", ";
                }
            }
        }
        return result;
    }
}
