package tee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class KNN {
    
	
	public static String[][] run(String train, String test) {
        int k = 3;
        // read the train file
        //String inputtrainf="IrisTrain.csv";
        //String inputtestf="IrisTest.csv";
        String inputtrainf=train;
        String inputtestf=test;
        ArrayList<String> trainList = getFile(inputtrainf);
        int trainSize = trainList.size() - 6;
        String trainData[][] = new String[trainSize][6];
        String trainDatares[][] = new String[trainSize][6];

        // trainData[i][j] is the whole array to store the file
        for (int i = 0; i < trainSize; i++) {
            trainData[i] = trainList.get(i + 6).split(",");
        }

        // read the test file
        ArrayList<String> testList = getFile(inputtestf);
        int testSize = testList.size() - 6;
        String testData[][] = new String[testSize][4];
        for (int i = 0; i < testSize; i++) {
            testData[i] = testList.get(i + 6).split(",");
        }

        // transfer String to double and put to array myIris[][]
        double myIris[][] = new double[testData.length][4];
        for (int i = 0; i < testData.length; i++) {
            for (int j = 0; j < 4; j++) {
                myIris[i][j] = Double.parseDouble(testData[i][j]);
            }
        }
        

        // put the classification result into array result
        String result[] = new String[testData.length];
        
        for (int i = 0; i < testData.length; i++) {
            // sum[] is the sqrt list of each Iris' distance
            double sum[] = getDistance(myIris[i], trainData,trainDatares);
            int[] theFirstK = getFirstK(sum, k);

            // vote record the number of votes
            int[] vote = new int[k];
            vote = vote(trainData, theFirstK, k, vote);

            String winner = max(vote[0], vote[1], vote[2]);
            result[i] = winner;
        }

        try {
            writeToFile(testData, result);
        } catch (IOException e) {
            System.out.println("File write error");
            e.printStackTrace();
        }
        return trainDatares;

    }

    // write the result to a file
    private static void writeToFile(String[][] testData, String[] result)
            throws IOException {
        // TODO Auto-generated method stub
        FileWriter fw = null;
        fw = new FileWriter("IrisResult.csv");
        fw.write("Fisher's?Iris?Data\n");
        fw.write("Sepal length");
        fw.write(",");
        fw.write("Sepal width");
        fw.write(",");
        fw.write("Petal length");
        fw.write(",");
        fw.write("Petal width");
        fw.write(",");
        fw.write("Species\n");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 4; j++) {
                fw.write(testData[i][j]);
                fw.write(",");
            }
            fw.write(result[i]);
            fw.write("\n");
            fw.flush();
        }
        fw.close();
    }

    // see the first k element and return the number of each species into an
    // array
    private static int[] vote(String[][] trainData, int[] theFirstK, int k, int[] vote) {
        for (int j = 0; j < k; j++) {
            if (trainData[theFirstK[j]][4].equals("I.?setosa")) {
                vote[0]++;
            } else if (trainData[theFirstK[j]][4].equals("I.?versicolor")) {
                vote[1]++;
            } else if (trainData[theFirstK[j]][4].equals("I.?virginica")) {
                vote[2]++;
            }
        }
        return vote;
    }

    // get the file and put its content to an arraylist
    private static ArrayList<String> getFile(String string) {
        Scanner s = null;
        try {
            s = new Scanner(new File(string));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()) {
            list.add(s.next());
        }
        s.close();
        return list;
    }

    // find the species with max votes
    private static String max(int setosa, int versicolor, int virginica) {
        if (setosa >= versicolor && setosa >= virginica) {
            return "I.?setosa";
        } else if (versicolor >= setosa && versicolor >= virginica) {
            return "I.?versicolor";
        } else {
            return "I.?virginica";
        }
    }

    // get the nearest K's neighbors and put them into a array
    private static int[] getFirstK(double[] sum, int k) {
        Map<Integer, Double> m = new TreeMap<Integer, Double>();
        for (int i = 0; i < sum.length; i++) {
            m.put(i, sum[i]);
        }
        List<Map.Entry<Integer, Double>> mappingList = null;
        mappingList = new ArrayList<Map.Entry<Integer, Double>>(m.entrySet());
        Collections.sort(mappingList,
                new Comparator<Map.Entry<Integer, Double>>() {
                    public int compare(Map.Entry<Integer, Double> mapping1,
                            Map.Entry<Integer, Double> mapping2) {
                        return mapping1.getValue().compareTo(
                                mapping2.getValue());
                    }
                });

        Map<Integer, Double> newMap = new HashMap<Integer, Double>();
        int count = 0;
        for (Map.Entry<Integer, Double> mapping : mappingList) {
            newMap.put(mapping.getKey(), mapping.getValue());
            count++;
            if (count == k) {
                break;
            }
        }
        int array[] = new int[k];
        Iterator<Integer> iterator = newMap.keySet().iterator();
        while (iterator.hasNext() && k > 0) {
            array[k - 1] = (int) iterator.next();
            k--;
        }

        return array;
    }

    // get the distance between the new Iris and the others
    private static double[] getDistance(double[] myIris, String[][] trainData, String[][] trainDatares) {
        double sum[] = new double[trainData.length];
        for (int i = 0; i < trainData.length; i++) {
            for (int j = 0; j < 4; j++) {
                sum[i] += Math
                        .pow(myIris[j] - Double.parseDouble(trainData[i][j]), 2);
            }
            sum[i] = Math.sqrt(sum[i]);
            trainDatares[i][0]=trainData[i][0];
            trainDatares[i][1]=trainData[i][1];
            trainDatares[i][2]=trainData[i][2];
            trainDatares[i][3]=trainData[i][3];
            trainDatares[i][4]=trainData[i][4];
            trainDatares[i][5]=""+sum[i];
        }
        return sum;
    }
}