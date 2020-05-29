package src;

public class Practical {

//    Enter the name of the country. Print the name of the continent. (Declare enum with names of continents)

    public enum Countries {
        GERMANY("Europa"), FRANCE("Europa"), ITALY("Europa"), POLAND("Europa"), USA("South America"),
        CANADA("South America"), BRAZIL("North America"), CHILI("North America"), NIGERIA("Africa"), SIRIA("Africa"), CHINA("Asia"), IRAN("Asia"), IRAK("Asia");
        private final String cont;

        Countries(String cont) {
            this.cont = cont;
        }

        public String getCont() {

            return cont;
        }

    }

    public static void nameContinent(String count) {
        Countries countries = Countries.valueOf(count.toUpperCase());
        System.out.println(countries.getCont());

    }

    //Enter the number of the day of the week. Display the name in three languages.
    public static void dayOfWeek(int day) {

        switch (day) {

            case 1:
                System.out.println("EN: Monday, UA: Понеділок, RU: Понедельник");
                break;
            case 2:
                System.out.println("EN: Tuesday, UA: Вівторок, RU: Вторник");
                break;
            case 3:
                System.out.println("EN: Wednesday, UA: Середа, RU: Среда");
                break;
            case 4:
                System.out.println("EN: Thursday, UA: Четверг, RU: Четверг");
                break;
            case 5:
                System.out.println("EN: Friday, UA: Пятниця, RU: Пятница");
                break;
            case 6:
                System.out.println("EN: Saturday, UA: Субота, RU: Суббота");
                break;
            case 7:
                System.out.println("EN: Sunday, UA: Неділя, RU: Воскресение");
                break;
            default:
                System.out.println(" You input invalid day");


        }


    }


}
