package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListOperator {

    public int maximumValue(List<Integer> lista){
        return Collections.max(lista);

    }

    public int minimumValue(List<Integer> lista){
        return Collections.min(lista);

    }

    public int summatory(List<Integer> lista){
        int sum = 0;
        for(int i : lista)
            sum += i;
        return sum;

    }

    public int multiplication(List<Integer> lista){
        int mult = 1;
        for(int i : lista)
            mult *= i;
        return mult;

    }



    public List<Integer> stringToList(String numeros ){
        List<String> lista = Arrays.asList(numeros.split("\\s*,\\s*"));

        ArrayList<Integer> result = new ArrayList<Integer>();

        for(String stringValue : lista) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
                System.out.println("Could not parse " + nfe);

            }
        }

        return result;

    }
}
