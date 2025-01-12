import java.util.Scanner;

class LazyNumberDetails {
    // TODO
    private int number;

    private Boolean primCache = null;
    private Boolean perfectCache = null;
    private Boolean magicCache = null;

    public LazyNumberDetails(int number) {
        this.number = number;
    }

    public void updateNumber(int number) {
        if (this.number != number) {
            this.number = number;
            this.primCache = null;
            this.perfectCache = null;
            this.magicCache = null;
        }
    }

    public boolean isPrime() {
        if (primCache == null) {
            System.out.println("Evaluating isPrime(" + number + ")");
            primCache = verificarePrim(number);
        } else {
            System.out.println("Using cached value for isPrime(" + number + ")");
        }
        return primCache;
    }

    public boolean isPerfect() {
        if (perfectCache == null) {
            System.out.println("Evaluating isPerfect(" + number + ")");
            perfectCache = verificarePerfect(number);
        } else {
            System.out.println("Using cached value for isPerfect(" + number + ")");
        }
        return perfectCache;
    }

    public boolean isMagic() {
        if (magicCache == null) {
            System.out.println("Evaluating isMagic(" + number + ")");
            magicCache = verificareMagic(number);
        } else {
            System.out.println("Using cached value for isMagic(" + number + ")");
        }
        return magicCache;
    }

    private boolean verificarePrim(int numar) {
        if (numar < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numar); i++) {
            if (numar % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarePerfect(int numar) {
        if (numar < 1) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= numar / 2; i++) {
            if (numar % i == 0) {
                sum += i;
            }
        }
        return sum == numar;
    }

    private boolean verificareMagic(int numar) {
        while (numar >= 10) {
            numar = sumaCifrelor(numar);
        }
        return numar == 3 || numar == 7 || numar == 9;
    }

    private int sumaCifrelor(int numar) {
        int sum = 0;
        while (numar > 0) {
            sum += numar % 10;
            numar /= 10;
        }
        return sum;
    }
}

public class Main {
    private static final String UPDATE_CMD = "UPDATE";
    private static final String IS_PRIME_CMD = "PRIME?";
    private static final String IS_PERFECT_CMD = "PERFECT?";
    private static final String IS_MAGIC_CMD = "MAGIC?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initial_number = scanner.nextInt();
        scanner.nextLine();
        LazyNumberDetails lnd = new LazyNumberDetails(initial_number);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals(IS_PRIME_CMD)) {
                System.out.println(lnd.isPrime());
            } else if (line.equals(IS_PERFECT_CMD)) {
                System.out.println(lnd.isPerfect());
            } else if (line.equals(IS_MAGIC_CMD)) {
                System.out.println(lnd.isMagic());
            } else if (line.startsWith(UPDATE_CMD)) {
                int new_number = Integer.parseInt(line.substring(UPDATE_CMD.length() + 1));
                lnd.updateNumber(new_number);
            } else {
                System.out.println("INVALID OPERATION!");
            }
        }
    }
}