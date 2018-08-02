public class Main {

    public static void main(String[] args) {

        String[] words;
        words = new String[]{"груша", "радуга", "единорог", "коллайдер", "богомол", "груша", "гном", "единорог", "радуга", "планета"};


        System.out.println("----Task 2---");

        Phonebook phonebook = new Phonebook();

        phonebook.add("Iron Man", "888");
        phonebook.add("Star-Lord", "787");
        phonebook.add("Rocket Raccoon", "777");
        phonebook.add("Groot", "111");
        phonebook.add("Thor", "333");
        phonebook.add("Hulk", "000");
        phonebook.add("Hulk", "000");

        phonebook.display();
        System.out.println("----------");
        phonebook.get("Groot");


    }
}
