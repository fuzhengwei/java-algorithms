package math.primality;

public class Primality {

    /**
     * 判断是否为素数
     */
    public boolean isPrime(long number) {
        boolean isPrime = number > 0;
        // 计算number的平方根为k，可以减少一半的计算量
        int k = (int) Math.sqrt(number);
        for (int i = 2; i <= k; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
