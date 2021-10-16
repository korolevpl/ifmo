package com.ifmo.lesson2;

public class LuckyTickets {
    /*
    В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую
    неделю трамвайное депо заказывает в местной типографии рулон билетов с номерами от
    000001 до 999999. «Счастливым» считается билетик у которого сумма первых трёх цифр
    номера равна сумме последних трёх цифр, как, например, в билетах с номерами 003102 или
    567576. Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета
    и теперь раздумывает, как много сувениров потребуется. С помощью программы подсчитайте
    сколько счастливых билетов в одном рулоне?
     */
    public static void main(String[] args) {

        System.out.println(luckyTickets());
    }

    public static int luckyTickets() {
        // Можно также разделить число попалам (number / 1000 и number % 1000 ), и,
        // сравнить сумму разрядов этих 2 числел.
        int number = 999999;
        int count = 0;
        while (number != 0) {
            int left = number / 1000;
            int right = number % 1000;
            int amount1 = DigitsSum.digitSum(left);
            int amount2 = DigitsSum.digitSum(right);
            if (amount1 == amount2) {
                count++;
            }
            number--;
        }
        /*
        while (number != 0) {
            int position0 = number % 10;
            int position1 = (number / 10) % 10;
            int position2 = (number / 100) % 10;
            int position3 = (number / 1000) % 10;
            int position4 = (number / 10000) % 10;
            int position5 = (number / 100000) % 10;
            if (position0 + position1 + position2 == position3 + position4 + position5) {
                count++;
            }
            number--;
        }
        */
        return count;
    }
}
