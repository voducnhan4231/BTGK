package BTGK;

import java.util.List;public class PrimeCheckerThread extends Thread {
    private int number;
    private boolean isPrime;

    public PrimeCheckerThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        isPrime = isPrimeNumber(number);
    }

    public boolean isPrime() {
        return isPrime;
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        int number = 17; // Số cần kiểm tra
        PrimeCheckerThread primeThread = new PrimeCheckerThread(number);

        // Bắt đầu chạy luồng kiểm tra số nguyên tố
        primeThread.start();

        // Đợi cho luồng kết thúc
        primeThread.join();

        // Lấy kết quả từ luồng
        boolean isPrime = primeThread.isPrime();

        if (isPrime) {
            System.out.println(number + " là số nguyên tố.");
        } else {
            System.out.println(number + " không là số nguyên tố.");
        }
    }
}
