import java.util.ArrayList;
import java.util.Scanner;

public class FindPrimes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        System.out.println("Find an amount of primes (1)");
        System.out.println("Find up to a limit of primes (2)");
        System.out.println("Check if a number is prime (3)");
        System.out.println("Check the differance between primes (4)");
        System.out.println("Mode choice: ");
        int userInput = scan.nextInt();
        if (userInput == 1) {
            findAnAmountOfPrimes(scan, primeNumbers);
        }
        else if (userInput == 2) {
            checkForPrimesUpToNumber(scan, primeNumbers);
        }
        else if (userInput == 3) {
            checkIfNumberIsPrime(scan);
        }
        else if (userInput == 4) {
            checkTheDifferanceBetweenPrimes(scan, primeNumbers);
        }
        else {
            System.out.println("Invalid input");
        }
    }

    private static void checkTheDifferanceBetweenPrimes(Scanner scan, ArrayList<Integer> primeNumbers) {
        System.out.println("Enter number to check up to: ");
        int userNumToCheckUpTo = scan.nextInt();
        for (int numberToCheck = 2; numberToCheck <= userNumToCheckUpTo; numberToCheck++) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(numberToCheck);
            }
        }
        for (int i = 0; i < primeNumbers.size() - 1; i++){
            int num1 = primeNumbers.get(i);
            int num2 = primeNumbers.get(i + 1);
            int diff = num2 - num1;
            System.out.println(diff);
        }
    }

    private static void findAnAmountOfPrimes(Scanner scan, ArrayList<Integer> primeNumbers) {
        System.out.println("How many primes do you want to find: ");
        int limit = scan.nextInt();
        int numberToCheck = 2;
        int count = 0;
        while (true) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(numberToCheck);
                count++;
                if (count >= limit) {
                    break;
                }
            }
            numberToCheck++;
        }
        System.out.println("The first " + limit + " prime numbers are: ");
        printPrimesFound(primeNumbers);
    }

    private static void checkForPrimesUpToNumber(Scanner scan, ArrayList<Integer> primeNumbers) {
        System.out.println("Enter number to check up to: ");
        int userNumToCheckUpTo = scan.nextInt();
        for (int numberToCheck = 2; numberToCheck <= userNumToCheckUpTo; numberToCheck++) {
            boolean isPrime = true;
            for (int factor = 2; factor <= numberToCheck / 2; factor++) {
                if (numberToCheck % factor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(numberToCheck);
            }
        }
        System.out.println("Prime numbers from 1 to " + userNumToCheckUpTo + " are: ");
        printPrimesFound(primeNumbers);
    }

    private static void checkIfNumberIsPrime (Scanner scan) {
        System.out.println("What number do you want to check: ");
        int numberToCheck = scan.nextInt();
        for (int factor = 2; factor <= numberToCheck / 2; factor++) {
            if (numberToCheck % factor == 0) {
                System.out.println(numberToCheck + " is not prime");
                return;
            }
        }
        System.out.println(numberToCheck + " is prime");
    }

    private static void printPrimesFound(ArrayList<Integer> primeNumbers) {
        for (int number : primeNumbers) {
            System.out.println(number);
        }
    }
}
