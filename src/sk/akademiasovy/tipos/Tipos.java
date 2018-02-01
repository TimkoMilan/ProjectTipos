package sk.akademiasovy.tipos;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tipos {
    private int [] arr;

    public int[] getArr() {
        return arr;
    }

    public Tipos() {
        this.arr = new int[5];
    }

    public void generate(){
       /* gen. 5 nahodnych cisel 1 do 35
        Random random = new Random();

        int i;
        int j;
        int k;
        for (i=0; i<=5 ; i++){
            int  n = random.nextInt(35) + 1;
            arr[k] = n ;
            for (j=0 ; j<= 5 ; j++){

                nedokoncene
                }


        }
        */

            Random random=new Random();
            arr[0]=random.nextInt(35)+1;
            int k, i=1;
            boolean unique=true;
            while (i<5)
            {
                arr[i]=random.nextInt(35)+1;
                unique=true;

                for (k=0; k<i; k++)
                {
                    if (arr[i]==arr[k])
                        unique=false;
                }

                if (unique==true)
                    i++;
            }

            Arrays.sort(arr);
            for (i=0 ; i<5 ; i++)
                System.out.println(arr[i]);

    }
    public void printNewBets(List<Bet> list){
        if (list == null || list.size() == 0){
            System.out.println("No Bets in the database ! ");
        }
        else {
            for (Bet temp:list){
                System.out.println("Bet: "+temp.getId()+" "+temp.getDate()+" "+temp.getIduser());
                System.out.println(" > "+temp.getBet1()+ " "+temp.getBet2()+" "+temp.getBet3()+" "+temp.getBet4()+ " "+temp.getBet5()+" < ");
            }
        }

    }
}
