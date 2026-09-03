package school.sptech;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Alerta {

    void alertar(Double leitura, String nome, Double limite, String unidade){
        LocalDateTime dataHora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataHora.format(formatter);
        Double porcentagem  = ((leitura - limite) * 100.0) / limite;
        System.out.println("""
                Seu %s está %.2f%% fora do limite de %.2f
                Leitura atual: %.2f%s
                Horário da Leitura: %s
                """.formatted(nome, porcentagem, limite, leitura, unidade, dataFormatada));
    }

    void validar(ArrayList<Integer> componentes, ArrayList<String> unidades, ArrayList<Double> limites, ArrayList<Double> leituras, ArrayList<String> nomesComp){
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < componentes.size(); i++) {
            if(componentes.get(i) == 1){
                indices.add(i);
            }
        }
        for (int i = 0; i < indices.size(); i++) {
            if (indices.get(i) == 6 || indices.get(i) == 7 || indices.get(i) == 9 || indices.get(i) == 10){
                if(leituras.get(i) < limites.get(indices.get(i))){
                    alertar(leituras.get(i), nomesComp.get(indices.get(i)), limites.get(indices.get(i)), unidades.get(indices.get(i)));
                }
            } else {
                if(leituras.get(i) >= limites.get(indices.get(i))){
                    alertar(leituras.get(i), nomesComp.get(indices.get(i)), limites.get(indices.get(i)), unidades.get(indices.get(i)));
                }
            }
        }
    }
}
