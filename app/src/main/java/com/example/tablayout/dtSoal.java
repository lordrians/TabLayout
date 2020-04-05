package com.example.tablayout;

import java.util.ArrayList;

public class dtSoal {
    private static String[] soal = {
            "Kaki ayam ada berapa?",
            "3 - 1 = ",
            "2 + 3 = ",
            "3 - 1 = ",
            "2 + 3 = "
    };

    private static String[] pgA = {
            "A. 1",
            "A. 1",
            "A. 1",
            "A. 1",
            "A. 1"
    };

    private static String[] pgB = {
            "B. 2",
            "B. 2",
            "A. 1",
            "A. 1",
            "B. 3"
    };

    private static String[] pgC = {
            "C. 3",
            "C. 3",
            "A. 1",
            "A. 1",
            "C. 4"
    };

    private static String[] pgD = {
            "D. 4",
            "D. 4",
            "A. 1",
            "A. 1",
            "D. 5",
    };

    private static String[] correctAns = {
            "B. 2",
            "B. 2",
            "A. 1",
            "A. 1",
            "D. 5",
    };

    public static ArrayList<Soal> getData(){
        ArrayList<Soal> list = new ArrayList<>();
        for (int i = 0; i < soal.length; i++){
            Soal question = new Soal();
            question.setSoal(soal[i]);
            question.setPgA(pgA[i]);
            question.setPgB(pgB[i]);
            question.setPgC(pgC[i]);
            question.setPgD(pgD[i]);
            question.setCorrectAns(correctAns[i]);
            list.add(question);

        }
        return list;
    }


}
