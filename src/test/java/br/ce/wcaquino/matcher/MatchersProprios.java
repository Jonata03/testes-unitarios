package br.ce.wcaquino.matcher;

import java.util.Calendar;

public class MatchersProprios {
    public static DiaSemanaMatcher caiEm(Integer diaSemana){
        return new DiaSemanaMatcher(diaSemana);
    }

    public static DiaSemanaMatcher caiNumaSegunda(){
        return new DiaSemanaMatcher(Calendar.MONDAY);
    }
    
//    public static DiaAtualMatcher ehHoje(Integer diaAtual){
//        return new Date();
//    }

    public static DataDiferencaDiasMatcher ehHojeComDiferencaDias(Integer qtdDias){
        return new DataDiferencaDiasMatcher(qtdDias);
    }
    public static DataDiferencaDiasMatcher ehHoje(){
        return new DataDiferencaDiasMatcher(0);
    }
}
