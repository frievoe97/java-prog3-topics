package control;

public class SwitchExample {
    public static void main(String[] args) {
        int day = 4;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Montag";
                break;
            case 2:
                dayName = "Dienstag";
                break;
            case 3:
                dayName = "Mittwoch";
                break;
            case 4:
                dayName = "Donnerstag";
                break;
            case 5:
                dayName = "Freitag";
                break;
            case 6:
                dayName = "Samstag";
                break;
            case 7:
                dayName = "Sonntag";
                break;
            default:
                dayName = "Ungültiger Tag";
                break;
        }

        System.out.println("Der Tag mit dem Wert " + day + " ist " + dayName + ".");
    }
}

