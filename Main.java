import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File text = new File("/Users/monicavaideanu/Desktop/inputs/FirstTestCommands");
        Scanner sc = new Scanner(text);
        boolean running = true;
        System.out.println("Bun venit! Introduceti numarul de locuri disponibile:");
        //int numberOfParticipants = sc.nextInt();
        int numberOfParticipants = 0;
        try {
            numberOfParticipants = Integer.parseInt(readLine(sc));
        } catch (InputMismatchException e) {
            System.out.println("Nu este un numar valid");
        }
        //int numberOfParticipants = Integer.parseInt(readLine(sc));
        GuestsList guestsList = new GuestsList(numberOfParticipants);
        while (running) {
            System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
            //String command = sc.next();
            String command = readLine(sc);
            switch (command) {
                case "quit": {
                    System.out.println("Aplicatia se inchide…");
                    running = false;
                    break;
                }
                case "help": {
                    guestsList.help();
                    break;
                }
                case "add": {
                    System.out.println("Se adauga o noua persoana…");
                    System.out.println("Introduceti numele de familie:");
                    //String lastName = sc.next();
                    String lastName = readLine(sc);
                    System.out.println("Introduceti prenumele:");
                    //String firstName = sc.next();
                    String firstName = readLine(sc);
                    System.out.println("Introduceti email:");
                    //String email = sc.next();
                    String email = readLine(sc);
                    System.out.println("Introduceti numar de telefon (format „+40733386463“):");
                    //String phoneNumber = sc.next();
                    String phoneNumber = readLine(sc);
                    Guest newGuest = new Guest(firstName, lastName, email, phoneNumber);
                    guestsList.addNewPersonToList(newGuest);
                    break;
                }
                case "check": {
                    guestsList.searchOptions();
                    //int searchOption = sc.nextInt();
                    int searchOption = Integer.parseInt(readLine(sc));
                    boolean check = true;
                    if (searchOption == 1) {
                        System.out.println("Introduceti numele de familie:");
                        //String lastName = sc.next();
                        String lastName = readLine(sc);
                        System.out.println("Introduceti prenumele: ");
                        //String firstName = sc.next();
                        String firstName = readLine(sc);
                        check = guestsList.isRegisterd(firstName, lastName);
                    } else if (searchOption == 2) {
                        System.out.println("Introduceti email-ul: ");
                        //String email = sc.next();
                        String email = readLine(sc);
                        check = guestsList.isRegisterd(email, searchOption);
                    } else if (searchOption == 3) {
                        System.out.println("Introduceti numarul de telefon: ");
                        //String phoneNumber = sc.next();
                        String phoneNumber = readLine(sc);
                        check = guestsList.isRegisterd(phoneNumber, searchOption);
                    } else {
                        System.out.println("Comanda invalida.");
                    }
                    if (check) {
                        System.out.println("Persoana este deja inscrisa la eveniment");
                    } else {
                        System.out.println("Persoana nu este inscrisa la eveniment");
                    }
                    break;
                }
                case "guests": {
                    guestsList.guests();
                    break;
                }
                case "waitlist": {
                    guestsList.guestsWaitingList();
                    break;
                }
                case "available": {
                    guestsList.available();
                    break;
                }
                case "guests_no": {
                    guestsList.numberOfParticipants();
                    break;
                }
                case "waitlist_no": {
                    guestsList.numberOfPersonsInWaitingList();
                    break;
                }
                case "subscribe_no": {
                    guestsList.totalNumber();
                    break;
                }
                case "search": {
                    System.out.println("Introduceti secventa de cautat: ");
                    //guestsList.containsString(sc.next());
                    guestsList.containsString(readLine(sc));
                    break;
                }
                case "update": {
                    System.out.println("Se actualizeaza detaliile unei persoane…");
                    guestsList.searchOptions();
                    //int option = sc.nextInt();
                    int option = Integer.parseInt(readLine(sc));
                    switch (option) {
                        case 1:
                            System.out.println("Introduceti numele de familie:");
                            //String lastName = sc.next();
                            String lastName = readLine(sc);
                            System.out.println("Introduceti prenumele: ");
                            //String firstName = sc.next();
                            String firstName = readLine(sc);
                            if (guestsList.isRegisterd(firstName, lastName)) {
                                int toSearchByOption = optionsToUpdate(sc);
                                Guest guestToUpdate = guestsList.searchByFullName(firstName, lastName);
                                printOption(toSearchByOption);
                                //String newValue = sc.next();
                                String newValue = readLine(sc);
                                guestsList.update(guestToUpdate, toSearchByOption, newValue);
                            }
                            break;
                        case 2:
                            System.out.println("Introduceti email-ul: ");
                            //String email = sc.next();
                            String email = readLine(sc);
                            if (guestsList.isRegisterd(email, 2)) {
                                int toSearchByOption = optionsToUpdate(sc);
                                Guest guestToUpdate = guestsList.searchByPhoneNumberOrEmailInList(email);
                                printOption(toSearchByOption);
                                //String newValue = sc.next();
                                String newValue = readLine(sc);
                                guestsList.update(guestToUpdate, toSearchByOption, newValue);
                            }
                            break;
                        case 3:
                            System.out.println("Introduceti numar de telefon (format „+40733386463“):");
                            //String phoneNumber = sc.next();
                            String phoneNumber = readLine(sc);
                            if (guestsList.isRegisterd(phoneNumber, 3)) {
                                int toSearchByOption = optionsToUpdate(sc);
                                Guest guestToUpdate = guestsList.searchByPhoneNumberOrEmailInList(phoneNumber);
                                printOption(toSearchByOption);
                                //String newValue = sc.next();
                                String newValue = readLine(sc);
                                guestsList.update(guestToUpdate, toSearchByOption, newValue);
                            }
                            break;
                        default:
                            System.out.println("Optiune invalida!");
                            break;
                    }
                    break;
                }
                case "remove": {
                    System.out.println("Se sterge o persoana existenta din lista…");
                    guestsList.searchOptions();
                    //int option = sc.nextInt();
                    int option = Integer.parseInt(readLine(sc));
                    switch (option) {
                        case 1:
                            System.out.println("Introduceti numele de familie:");
                            //String lastName = sc.next();
                            String lastName = readLine(sc);
                            System.out.println("Introduceti prenumele: ");
                            //String firstName = sc.next();
                            String firstName = readLine(sc);
                            if (guestsList.isRegisterd(firstName, lastName)) {
                                Guest guestToRemove = guestsList.searchByFullName(firstName, lastName);
                                guestsList.remove(guestToRemove);
                            } else {
                                System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                            }
                            //System.out.println();
                            break;
                        case 2:
                            System.out.println("Introduceti email-ul: ");
                            //String email = sc.next();
                            String email = readLine(sc);
                            if (guestsList.isRegisterd(email, 2)) {
                                Guest guestToRemove = guestsList.searchByPhoneNumberOrEmailInList(email);
                                guestsList.remove(guestToRemove);
                            } else {
                                System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                            }
                            break;
                        case 3:
                            System.out.println("Introduceti numar de telefon (format „+40733386463“):");
                            //String phoneNumber = sc.next();
                            String phoneNumber = readLine(sc);
                            if (guestsList.isRegisterd(phoneNumber, 3)) {
                                Guest guestToRemove = guestsList.searchByPhoneNumberOrEmailInList(phoneNumber);
                                guestsList.remove(guestToRemove);
                            } else {
                                System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
                            }
                            break;
                        default:
                            System.out.println("Optiune invalida!");
                            break;
                    }
                    break;
                }
                default:
                    System.out.println("Comanda invalida.");
                    break;
            }
        }
    }

    private static String readLine(Scanner sc) {
        String line = sc.nextLine();
        System.out.println(line);
        return line;
    }

    private static int optionsToUpdate(Scanner sc) {
        // Scanner sc = new Scanner(System.in);
        System.out.println("Alege campul de actualizat, tastand:\n" +
                "\"1\" - Nume\n" +
                "\"2\" - Prenume\n" +
                "\"3\" - Email\n" +
                "\"4\" - Numar de telefon (format \"+40733386463\")");
        return Integer.parseInt(readLine(sc));
    }

    private static void printOption(int number) {
        switch (number) {
            case 1:
                System.out.println("Introduceti numele de familie: ");
                break;
            case 2:
                System.out.println("Introduceti prenumele: ");
                break;
            case 3:
                System.out.println("Introducti email-ul: ");
                break;
            case 4:
                System.out.println("Introduceti numarul de telefon: ");
                break;
            default:
                System.out.println("Optiune invalida!");
                break;
        }
    }
}
