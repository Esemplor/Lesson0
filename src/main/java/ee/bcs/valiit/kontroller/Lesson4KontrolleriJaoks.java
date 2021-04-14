package ee.bcs.valiit.kontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson4KontrolleriJaoks {

        // Store account nr as a key and account balance as value
        // HashMap<String, Account> accountBalanceMap = new HashMap<>();

        private static Map<String, Double> accountBalanceMap = new HashMap<>();
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Insert command");
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;

                    // TODO 1
                    // Add command: "createAccount ${accountNr}"
                    // this has to store accountNr with 0 balance

                } else if (line.equalsIgnoreCase("createAccount")) {
                    System.out.println("Please enter account nr");
                    String accountNr = scanner.nextLine();
                    System.out.println("Please enter inital balance");
                    Double balance = scanner.nextDouble();
                    scanner.nextLine();
                    accountBalanceMap.put(accountNr, balance);
                    System.out.println("Account created! Account balance: "+accountBalanceMap.get(accountNr));

                    // TODO 2
                    // Add command: "getBalance ${accountNr}"
                    // this has to display account balance of specific acount

                } else if (line.equalsIgnoreCase("getBalance")) {
                    System.out.println("Please enter account nr");
                    String accountNr = scanner.nextLine();
                    if (accountBalanceMap.get(accountNr) == null) {
                        System.out.println("Invalid account");
                    } else {
                        System.out.println("Konto balanss on: " + accountBalanceMap.get(accountNr));
                    }

                    // TODO 3
                    // Add command: "depositMoney ${accountNr} ${amount}
                    // this has to add specified amount of money to account
                    // You have to check that amount is positive number

                } else if (line.equalsIgnoreCase("depositMoney")) {
                    System.out.println("To which account do you wish to deposit?");
                    String accountNr = scanner.nextLine();
                    if (accountBalanceMap.get(accountNr) == null) {
                        System.out.println("Invalid account");
                    } else {
                        System.out.println("How much do you want to deposit?");
                        Double deposit = scanner.nextDouble();
                        scanner.nextLine();
                        if (deposit > 0) {
                            accountBalanceMap.put(accountNr, accountBalanceMap.get(accountNr) + deposit);
                            System.out.println("New account balance: " + accountBalanceMap.get(accountNr));
                        } else {
                            System.out.println("Invalid deposit ammount");
                        }
                    }

                    // TODO 4
                    // Add command: "withdrawMoney ${accountNr} ${amount}
                    // This has to remove specified amount of money from account
                    // You have to check that amount is positive number
                    // You may not allow this transaction if account balance would become negative

                } else if (line.equalsIgnoreCase("withdrawMoney")) {
                    System.out.println("From what account do you wish to withdraw?");
                    String accountNr = scanner.nextLine();
                    if (accountBalanceMap.get(accountNr) == null) {
                        System.out.println("Invalid account");
                    } else {
                        System.out.println("How much do you want to withdraw?");
                        Double withdraw = scanner.nextDouble();
                        scanner.nextLine();
                        if (withdraw < 0) {
                            System.out.println("Invalid withdraw amount");
                        } else if (accountBalanceMap.get(accountNr) < withdraw) {
                            System.out.println("Insufficient funds");
                        } else {
                            accountBalanceMap.put(accountNr, accountBalanceMap.get(accountNr) - withdraw);
                            System.out.println("New account balance: " + accountBalanceMap.get(accountNr));
                        }
                    }

                    // TODO 5
                    // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
                    // This has to remove specified amount from fromAccount and add it to toAccount
                    // Your application needs to check that toAccount is positive
                    // And from account has enough money to do that transaction

                } else if (line.equalsIgnoreCase("transfer")) {
                    System.out.println("From what account do you wish to transfer from?");
                    String transfer1 = scanner.nextLine();
                    if (accountBalanceMap.get(transfer1) == null) {
                        System.out.println("Invalid account");
                    } else {
                        System.out.println("To what account to you wish to transfer to?");
                        String transfer2 = scanner.nextLine();
                        if (accountBalanceMap.get(transfer2) == null) {
                            System.out.println("Invalid account");
                        } else {
                            System.out.println("How much do you wish to transfer?");
                            Double transaction = scanner.nextDouble();
                            scanner.nextLine();
                            if (transaction < 0) {
                                System.out.println("Invalid withdraw amount");
                            } else if (accountBalanceMap.get(transfer1) < transaction) {
                                System.out.println("Insufficient funds");
                            } else if (accountBalanceMap.get(transfer2) < 0) {
                                System.out.println("Can't transfer to a negative account");
                            } else {
                                accountBalanceMap.put(transfer1, accountBalanceMap.get(transfer1) - transaction);
                                accountBalanceMap.put(transfer2, accountBalanceMap.get(transfer2) + transaction);
                                System.out.println("New account balance: " + accountBalanceMap.get(transfer1));

                            }
                        }
                    }

                } else {
                    System.out.println("Unknown command");
                }
            }
        }
    }

