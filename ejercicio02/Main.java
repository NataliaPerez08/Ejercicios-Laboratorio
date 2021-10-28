import java.util.Scanner;


public class Main{

    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);

        int n = scaner.nextInt();
        int m = scaner.nextInt();
        int[] unorganized = new int[n];

        for(int i=0; i< n; i++){
            int k = scaner.nextInt();
            unorganized[i] = k;
        }
        scaner.close();

        int temp=0;
        for(int j=1; j < n; j++){
            for(int l = 0; l<n-1; l++){
                int mod1 = unorganized[l] % m;
                int mod2 = unorganized[l+1] % m;
                
                if(mod1 == mod2){
                    if(unorganized[l] % 2 == 0 && unorganized[l+1] % 2 != 0){ // Es impar (Odd)
                        temp = unorganized[l];
                        unorganized[l] = unorganized[l+1];
                        unorganized[l+1] = temp;
                    }
                    
                    if(unorganized[l] % 2 != 0 && unorganized[l+1] % 2 != 0){
                        if(unorganized[l+1] > unorganized[l]){
                            temp = unorganized[l];
                            unorganized[l] = unorganized[l+1];
                            unorganized[l+1] = temp;
                        }
                    }

                    if(unorganized[l] % 2 == 0 && unorganized[l] % 2==0){
                        if(unorganized[l] > unorganized[l+1]){
                            temp = unorganized[l];
                            unorganized[l] = unorganized[l+1];
                            unorganized[l+1] = temp;
                        }
                    }
                }
                
                if(mod1 > mod2){
                    temp = unorganized[l];
                    unorganized[l] = unorganized[l+1];
                    unorganized[l+1] = temp;
                }
            }
        }
        System.out.print(n+" "+m);
        for (int num : unorganized) {
            System.out.println(num);
        }
    }
}