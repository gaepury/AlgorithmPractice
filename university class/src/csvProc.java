

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class csvProc {
    public Double[][] proc(Double[] inList_speed, Double[] inList_clearance) {
        List<Double> input = Arrays.asList(inList_speed);
        List<Double> record = new ArrayList<>();
        List<List<Double>> result = new ArrayList<>();
        Double[][] output;
        try {
            Double preSpd = 0.0;
            System.out.println("asd");
            System.out.println(input.size());
            for(int z = 0; z < input.size(); z++){
                Double spd = input.get(z);
                int maxIndex=0;
                if(spd < preSpd) {
                    record.add(spd);
                    System.out.println(record.toString());
                }

                if((spd >= preSpd && record.size() > 0) || z == input.size() - 1) {
                    Double Sum = 0.0, SumDe = 0.0, MaxDe = 0.0;
                    for(int i = 0; i < record.size() - 1; i++) {
                        Sum += record.get(i);
                        SumDe += record.get(i + 1) - record.get(i);
                        if(MaxDe > record.get(i + 1) - record.get(i)){
                            MaxDe = record.get(i + 1) - record.get(i);
                            maxIndex=i;
                        }
                    }
                    Sum += record.get(record.size() - 1);

                    Double[] calc = new Double[7];
                    calc[0] = record.get(0);
                    calc[1] = record.get(record.size() - 1);
                    calc[2] = SumDe / record.size();
                    calc[3] = MaxDe;
                    calc[4] = Sum / 3.6;
                    calc[5] = (double)record.size();
                    calc[6] = inList_clearance[maxIndex];
                    result.add(Arrays.asList(calc));
                    record.clear();
                }
                System.out.println("1");

                preSpd = spd;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result.size());
        output = new Double[result.size()][7];
        int i = 0;
        for (List<Double> nestedList : result){
        	System.out.println("check");
        	output[i++] = nestedList.toArray(new Double[nestedList.size()]);
        	
        }

        return output;
    }
}
