package homeworklesson5;

public class HomeWorkApp {

    public static void main(String[] args) {

        Person[] personArray = new Person[5];

        personArray[0] = new Person("Исаков Архип Николаевич", "инженер", "isaak@gmail.com", "8(911)7202010", 50000, 27);
        personArray[1] = new Person("Хохлов Осип Геласьевич", "инженер 2 категории", "hohlov_o@gmail.com", "8(921)2002005", 55000, 26);
        personArray[2] = new Person("Хохлов Арнольд Федорович", "Ведущий инженер", "hohlov_a@gmail.com", "8(928)4354768", 60000, 29);
        personArray[3] = new Person("Авдеев Аполлон Иосифович", "Главный специалист", "avdeev@gmail.com", "8(931)2813808", 70000, 35);
        personArray[4] = new Person("Богданов Митрофан Владленович", "Ген. директор", "bogdan@gmail.com","8(904)6579263", 200000, 50 );

        for(Person person : personArray) {
            if(person.getAge() > 40) {
                person.printPerson();
            }
        }
    }

}
