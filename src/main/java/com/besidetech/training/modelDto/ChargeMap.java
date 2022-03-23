package com.besidetech.training.modelDto;

import org.javatuples.Pair;

import java.util.List;
import java.util.Map;


public class ChargeMap {
    private Map<Integer , List<Pair<Integer , ChargeDto>>> mappa ;

    public ChargeMap () {

    }

    public Map<Integer, List<Pair<Integer, ChargeDto>>> getMappa() {
        return mappa;
    }

    public void setMappa(Map<Integer, List<Pair<Integer, ChargeDto>>> mappa) {
        this.mappa = mappa;
    }


    public static void main(String[] args) {

    }

}
