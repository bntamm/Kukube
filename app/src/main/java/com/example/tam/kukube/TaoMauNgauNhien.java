package com.example.tam.kukube;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Tam on 2/28/2018.
 */

public class TaoMauNgauNhien {
    static int dapAn;
    Random random = new Random();

    String string[] = new String[] {"#800080","#8d3280" ,"#ff93ff", "#0000b1" , "#ff0000","#fefe00" , "#d82020"  , "#00fefe"};
    public ArrayList<String> taoBangMau(int n){
    int x , y;

        ArrayList<String> array = new ArrayList<>();
        x = random.nextInt(n);
        dapAn = x;
        y = random.nextInt(string.length/2);


        for(int i = 0 ; i< n ; i++){
            if(i == x){
                array.add(string[y]);
            }else{
                array.add(string[y*2+1]);
            }
        }
        return array;

    }

}
