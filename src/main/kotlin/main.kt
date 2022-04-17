fun main() {
    var totalTransfer = 0
    while (true) {
        print(
            "_________________________________________\n" +
                    "Как вы хотите перевести деньги?\n" +
                    "1) С карты Mastercard или Maestro\n" +
                    "2) С карты Visa или Мир\n" +
                    "3) На счёт VK Pay\n" +
                    "Введите номер соответствующего пункта или \"0\" для выхода: "
        )
        val paragraph = readLine()?.toInt() ?: return
        if (paragraph == 0) break
        else if (paragraph < 0 || paragraph > 3) error("Нет такого пункта")
        print("Введите сумму перевода в рублях: ")
        val transfer = (readLine()?.toInt() ?: return) * 100
        val commission = commissionCalculation(paragraph, transfer, totalTransfer)
        if (commission == -1) {
            println("Невозможно выполнить перевод")
            continue
        }
        val finalTransfer = transfer + commission
        println(
            "Сумма перевода с комиссией составила ${finalTransfer / 100} рублей ${finalTransfer % 100} копеек\n" +
                    "Комиссия за перевод составила ${(finalTransfer - transfer) / 100} рублей ${(finalTransfer - transfer) % 100} копеек\n"
        )
        totalTransfer += transfer
        println("Сумма переводов за месяц составила ${totalTransfer / 100} рублей ${totalTransfer % 100} копеек")
    }

}

fun commissionCalculation(paragraph: Int, transfer: Int, totalTransfer: Int): Int {
    if ((totalTransfer + transfer) > 600_000_00 || transfer > 150_000_00) {
        println(
            "Превышен месячный или разовый лимит платежей\n" +
                    "В этом месяце вы уже перевели ${totalTransfer / 100} рублей ${totalTransfer % 100} копеек"
        )
        return -1
    } else
        when (paragraph) {
            1 -> {
                if (totalTransfer < 75_000_00) return 0
                else return transfer / 1000 * 6 + 20_00 //комиссия 0,6% + 20 руб
            }
            2 -> {
                if (transfer / 10000 * 75 < 35_00) return 35_00 //комиссия 35 руб
                return transfer / 10000 * 75 //комиссия 0,75%
            }
            3 -> {
                if ((totalTransfer + transfer) > 40_000_00 || transfer > 15_000_00) {
                    println(
                        "Превышен месячный или разовый лимит платежей\n" +
                                "В этом месяце вы уже перевели ${totalTransfer / 100} рублей ${totalTransfer % 100} копеек"
                    )
                    return -1
                } else return 0
            }
            else -> return -1
        }
}



