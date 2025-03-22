import java.math.BigInteger;

public class FibonacciSum {
    private BigInteger[] evenFibNumbers;
    private int maxCount;
    
    public FibonacciSum(int maxCount) {
        this.maxCount = maxCount;
        this.evenFibNumbers = new BigInteger[maxCount];
    }
    
    public BigInteger calculateEvenFibSum() {
        BigInteger a = BigInteger.valueOf(1);
        BigInteger b = BigInteger.valueOf(2);
        int count = 0;
        
        // First even Fibonacci number is 2
        evenFibNumbers[count++] = b;
        
        while (count < maxCount) {
            BigInteger c = a.add(b);
            
            if (c.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
                evenFibNumbers[count++] = c;
            }
            
            a = b;
            b = c;
        }
        
        BigInteger sum = BigInteger.valueOf(0);
        for (int index = 0; index < maxCount; index++) {
            sum = sum.add(evenFibNumbers[index]);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        FibonacciSum calculator = new FibonacciSum(100);
        BigInteger result = calculator.calculateEvenFibSum();
        System.out.println(result);
    }
}