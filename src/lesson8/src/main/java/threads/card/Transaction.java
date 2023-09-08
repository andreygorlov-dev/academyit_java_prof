package threads.card;

public class Transaction extends Thread {

    private Card card;
    private double money;

    public Transaction(Card card, double money) {
        this.card = card;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (card) {
            double balance = card.getBalance();
            System.out.println("Баланс карты до транзакции " + balance);
            balance += money;
            card.setBalance(balance);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Card clientCard = new Card(10000);

        Transaction transaction = new Transaction(clientCard, 2000);
        Transaction serviceTransaction = new Transaction(clientCard, -5000);
        transaction.start();
        serviceTransaction.start();
        transaction.join();
        serviceTransaction.join();
        System.out.println("Баланс карты: " + clientCard.getBalance());
    }
}
