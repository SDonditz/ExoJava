import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Time {
    private final HashMap<EDate, Integer> smthInSecond = new HashMap<>();
    private final HashMap<EDate, String> secondToStr = new HashMap<>();

    public Time() {
        this.smthInSecond.put(EDate.YEAR, 31536000);
        this.smthInSecond.put(EDate.MONTH, 2629800);
        this.smthInSecond.put(EDate.DAY, 86400);
        this.smthInSecond.put(EDate.HOUR, 3600);
        this.smthInSecond.put(EDate.MINUTE, 60);
        this.secondToStr.put(EDate.YEAR, "année");
        this.secondToStr.put(EDate.MONTH, "mois");
        this.secondToStr.put(EDate.DAY, "jour");
        this.secondToStr.put(EDate.HOUR, "heure");
        this.secondToStr.put(EDate.MINUTE, "minute");
        this.secondToStr.put(EDate.SECOND, "seconde");
    }

    public void secToDate (int timeInSecond) {
        if(timeInSecond < 0) {
            System.out.println("Saisissez un entier positif s'il vous-plaît.");
        } else if (timeInSecond == 0) {
            System.out.println("Now.");
        } else {
            int years = Utils.divideDate(timeInSecond, this.smthInSecond.get(EDate.YEAR));
            int months = Utils.divideDate(Utils.reste, this.smthInSecond.get(EDate.MONTH));
            int days = Utils.divideDate(Utils.reste, this.smthInSecond.get(EDate.DAY));
            int hours = Utils.divideDate(Utils.reste, this.smthInSecond.get(EDate.HOUR));
            int minutes = Utils.divideDate(Utils.reste, this.smthInSecond.get(EDate.MINUTE));
            int secondes = Utils.reste;

            String strYear = Utils.concatValue(this.secondToStr.get(EDate.YEAR), years, false);
            String strMonth = Utils.concatValue(this.secondToStr.get(EDate.MONTH), months, true);
            String strDay = Utils.concatValue(this.secondToStr.get(EDate.DAY), days, false);
            String strHour = Utils.concatValue(this.secondToStr.get(EDate.HOUR), hours, false);
            String strMinute = Utils.concatValue(this.secondToStr.get(EDate.MINUTE), minutes, false);
            String strsecond = Utils.concatValue(this.secondToStr.get(EDate.SECOND), secondes, false);

            List<String> chainToPunctuate = new ArrayList<>();
            chainToPunctuate.add(strYear);
            chainToPunctuate.add(strMonth);
            chainToPunctuate.add(strDay);
            chainToPunctuate.add(strHour);
            chainToPunctuate.add(strMinute);
            chainToPunctuate.add(strsecond);

            System.out.println(Utils.addPunctuation(chainToPunctuate));
        }
    }

    public HashMap<EDate, Integer> getSmthInSecond() {
        return smthInSecond;
    }

    public HashMap<EDate, String> getSecondToStr() {
        return secondToStr;
    }
}
