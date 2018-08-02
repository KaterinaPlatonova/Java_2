import java.util.ArrayList;
import java.util.Objects;

public class Phonebook implements IPhonebook {
    private ArrayList<Item> arrayPhonebook;
    private int size;
    private Item currentItem;

    public Phonebook() {
        this.arrayPhonebook = new ArrayList<>();
        this.size = 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return arrayPhonebook.contains(item);
//        Phonebook phonebook = (Phonebook) o;
//        return Objects.equals(arrayPhonebook, phonebook.arrayPhonebook) && //переделать
//                Objects.equals(currentItem, phonebook.currentItem);
    }

    @Override
    public void add(String lastName, String number) {
        currentItem = new Item(lastName, number);

        if ( arrayPhonebook.equals(currentItem) ) {
            System.out.println("This contact already exist.");
        }else {
            arrayPhonebook.add(currentItem);
            size++;
        }

    }

    @Override
    public Item get(String lastName) {
        for (int i = 0; i < arrayPhonebook.size(); i++) {
            arrayPhonebook.contains(lastName); //???есть ли в массиве объект стаким свойством

        }
        return null;
    }


    @Override
    public void display() {
        for (int i = 0; i < arrayPhonebook.size(); i++) {
            System.out.println("Name: " + arrayPhonebook.get(i).getLastName() + "\n" + " phone number: " + arrayPhonebook.get(i).getPhoneNumber());

        }
    }
}
