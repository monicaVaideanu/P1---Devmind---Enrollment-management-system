import java.util.ArrayList;

public class GuestsList {
    private final int numberOfParticipants;
    private final ArrayList<Guest> guestsList;
    private final ArrayList<Guest> guestsWaitingList = new ArrayList<Guest>();
    private static int counterGuests = 0;

    public GuestsList(int nrOfParticipants) {
        this.numberOfParticipants = nrOfParticipants;
        guestsList = new ArrayList<Guest>(numberOfParticipants);
    }

    public int addNewPersonToList(Guest newGuest) {
        if (counterGuests < numberOfParticipants) {
            if (isInGuestList(newGuest.getFirstName(), newGuest.getLastName())) {
                System.out.println("Esti deja inscris la eveniment.");
                return -1;
            } else {
                guestsList.add(newGuest);
                counterGuests++;
                System.out.println("[" + newGuest.getLastName() + " " + newGuest.getFirstName() + "]" +
                        " Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
                return 0;
            }
        } else {
            if (isInWaitingList(newGuest.getFirstName(), newGuest.getLastName())
                    || isInGuestList(newGuest.getLastName(), newGuest.getFirstName())) {
                System.out.println("Esti deja inscris la eveniment.");
                return -1;
            } else {
                guestsWaitingList.add(newGuest);
                int index = guestsWaitingList.indexOf(newGuest) + 1;
                System.out.println("[" + newGuest.getLastName() + " " + newGuest.getFirstName() + "]" +
                        "Te-ai inscris cu succes in lista de asteptare " +
                        "si ai primit numarul de ordine " +
                        index +
                        " .Te vom notifica daca un loc devine disponibil.");
                return index;
            }
        }
    }

    private boolean isInGuestList(String lastName, String firstName) {
        for (Guest guest : guestsList) {
            if (lastName.equalsIgnoreCase(guest.getLastName()) &&
                    firstName.equalsIgnoreCase(guest.getFirstName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isInWaitingList(String lastName, String firstName) {
        for (Guest guest : guestsWaitingList) {
            if (lastName.equalsIgnoreCase(guest.getLastName()) &&
                    firstName.equalsIgnoreCase(guest.getFirstName())) {
                return true;
            }
        }
        return false;
    }

    private boolean isInGuestList(String emailOrPhone, int option) {
        for (Guest guest : guestsList) {
            if (option == 2 && emailOrPhone.equalsIgnoreCase(guest.getEmail())) {
                return true;
            }
            if (option == 3 && emailOrPhone.equalsIgnoreCase(guest.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    private boolean isInWaitingList(String emailOrPhone, int option) {
        for (Guest guest : guestsWaitingList) {
            if (option == 2 && emailOrPhone.equalsIgnoreCase(guest.getEmail())) {
                return true;
            }
            if (option == 3 && emailOrPhone.equalsIgnoreCase(guest.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public boolean isRegisterd(String firstName, String lastName) {
        if (isInGuestList(lastName, firstName) || isInWaitingList(lastName, firstName)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRegisterd(String emailOrPhone, int option) {
        if (isInGuestList(emailOrPhone, option) || isInWaitingList(emailOrPhone, option)) {
            return true;
        } else {
            return false;
        }
    }

    public void guests() {
        if (guestsList.isEmpty()) {
            System.out.println("Niciun participant inscris…");
        }
        for (int i = 0; i < guestsList.size(); i++) {
            System.out.println(i + 1 + ". Nume: " + guestsList.get(i).getLastName() + " " +
                    guestsList.get(i).getFirstName() + ", Email: " + guestsList.get(i).getEmail() +
                    ", Telefon: " + guestsList.get(i).getPhoneNumber());
        }
    }

    public void guestsWaitingList() {
        if (guestsWaitingList.isEmpty()) {
            System.out.println("Lista de asteptare este goala...");
        }
        for (int i = 0; i < guestsWaitingList.size(); i++) {
            System.out.println(i + 1 + ". Nume: " + guestsWaitingList.get(i).getLastName() + " " +
                    guestsWaitingList.get(i).getFirstName() + ", Email: " + guestsWaitingList.get(i).getEmail() +
                    ", Telefon: " + guestsWaitingList.get(i).getPhoneNumber());
        }
    }

    public void available() {
        System.out.println("Numarul de locuri ramase: " + (numberOfParticipants - counterGuests));
    }

    public void numberOfParticipants() {
        if (counterGuests == 0) {
            System.out.println("Niciun participant inscris ...");
        } else {
            System.out.println("Numarul de participanti: " + counterGuests);
        }
    }

    public void numberOfPersonsInWaitingList() {
        System.out.println("Dimensiunea listei de asteptare: " + guestsWaitingList.size());
    }

    public void totalNumber() {
        System.out.println("Numarul total de persoane: " + (guestsWaitingList.size() + guestsList.size()));
    }

    public void containsString(String toCompare) {
        toCompare(toCompare, guestsList);
        toCompare(toCompare, guestsWaitingList);
    }

    private void toCompare(String toCompare, ArrayList<Guest> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirstName().toLowerCase().contains(toCompare)) {
                System.out.println("Contactul " + (i + 1) + " contine: firstName = " +
                        list.get(i).getFirstName());
            }
            if (list.get(i).getLastName().toLowerCase().contains(toCompare)) {
                System.out.println("Contactul " + (i + 1) + " contine: lastName = " +
                        list.get(i).getLastName());
            }
            if (list.get(i).getEmail().toLowerCase().contains(toCompare)) {
                System.out.println("Contactul " + (i + 1) + " contine: email = " +
                        list.get(i).getEmail());
            }
            if (list.get(i).getPhoneNumber().toLowerCase().contains(toCompare)) {
                System.out.println("Contactul " + (i + 1) + " contine: telefon = " +
                        list.get(i).getPhoneNumber());
            }
        }
    }

    public Guest searchByFullName(String firstName, String lastName) {
        Guest guestBurner = new Guest("ERROR", "ERROR", "ERROR", "ERROR");
        for (int i = 0; i < guestsList.size(); i++) {
            if (guestsList.get(i).getFirstName().equalsIgnoreCase(firstName) &&
                    guestsList.get(i).getLastName().equalsIgnoreCase(lastName)) {
                return guestsList.get(i);
            }
        }
        for (Guest guest : guestsWaitingList) {
            if (guest.getFirstName().equalsIgnoreCase(firstName) &&
                    guest.getLastName().equalsIgnoreCase(lastName)) {
                return guest;
            }
        }
        return guestBurner;
    }

    public void update(Guest guestToUpdate, int numberForCriteria, String newValue) {
        switch (numberForCriteria) {
            case 1:
                guestToUpdate.setLastName(newValue);
                break;
            case 2:
                guestToUpdate.setFirstName(newValue);
                break;
            case 3:
                guestToUpdate.setEmail(newValue);
                break;
            case 4:
                guestToUpdate.setPhoneNumber(newValue);
                break;
        }

    }

    public Guest searchByPhoneNumberOrEmailInList(String phoneNumberOrEmail) {
        Guest guestBurner = new Guest("ERROR", "ERROR", "ERROR", "ERROR");
        for (Guest guest : guestsList) {
            if (guest.getPhoneNumber().equalsIgnoreCase(phoneNumberOrEmail) ||
                    guest.getEmail().equalsIgnoreCase(phoneNumberOrEmail)) {
                return guest;
            }
        }
        for (Guest guest : guestsWaitingList) {
            if (guest.getPhoneNumber().equalsIgnoreCase(phoneNumberOrEmail) ||
                    guest.getEmail().equalsIgnoreCase(phoneNumberOrEmail)) {
                return guest;
            }
        }
        return guestBurner;
    }

    public boolean remove(Guest guest) {
        boolean answ = false;
        if (guestsList.remove(guest)) {
            counterGuests--;
            try {
                addNewPersonToList(guestsWaitingList.get(0));
                guestsWaitingList.remove(guestsWaitingList.get(0));
            } catch (IndexOutOfBoundsException e) {
            }
            System.out.println("Stergerea persoanei s-a realizat cu succes.");
            answ = true;
        } else {
            guestsWaitingList.remove(guest);
            System.out.println("Stergerea persoanei s-a realizat cu succes.");
            answ = true;
        }
        return answ;
    }

    public void help() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi\n" +
                "add          - Adauga o noua persoana (inscriere)\n" +
                "check        - Verifica daca o persoana este inscrisa la eveniment\n" +
                "remove       - Sterge o persoana existenta din lista\n" +
                "update       - Actualizeaza detaliile unei persoane\n" +
                "guests       - Lista de persoane care participa la eveniment\n" +
                "waitlist     - Persoanele din lista de asteptare\n" +
                "available    - Numarul de locuri libere\n" +
                "guests_no    - Numarul de persoane care participa la eveniment\n" +
                "waitlist_no  - Numarul de persoane din lista de asteptare\n" +
                "subscribe_no - Numarul total de persoane inscrise\n" +
                "search       - Cauta toti invitatii conform sirului de caractere introdus\n" +
                "quit         - Inchide aplicatia");
    }

    public void searchOptions() {
        System.out.println("Alege modul de autentificare, tastand:\n" +
                "\t\"1\" - Nume si prenume\n" +
                "\t\"2\" - Email\n" +
                "\t\"3\" - Numar de telefon (format \"+40733386463\")");
    }
}