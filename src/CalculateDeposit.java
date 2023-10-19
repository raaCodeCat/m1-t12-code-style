import java.util.Scanner;

public class CalculateDeposit {

    double calculateComplexPercent(double amount, double yearRate, int period) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * period);

        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int period) {
        return round(amount + amount * yearRate * period, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);

        return Math.round(value * scale) / scale;
    }

    void calculateIncomeOnDeposit() {
        int amount;
        int period;
        int action;
        double income = 0;
        double yearRate = 0.06;
        boolean hasActionError = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            income = calculateSimplePercent(amount, yearRate, period);
        } else if (action == 2) {
            income = calculateComplexPercent(amount, yearRate, period);
        } else {
            hasActionError = true;
        }

        if (hasActionError) {
            System.out.println("Выбранного типа вклада не существует!\nРасчет не выполнен!\n" +
                    "Будьте внимательны в следующий раз!");
            return;
        }

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        new CalculateDeposit().calculateIncomeOnDeposit();
    }


}
