package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ArrayList<String> dataMap = new ArrayList<>();
        Scanner scan = null;
        try {
            scan = new Scanner(Paths.get("partiesdata.tsv"));
        } catch (Exception ex) {
            System.out.println("Error reading file");
        }

        while (scan.hasNextLine()) {
            dataMap.add(scan.nextLine());
        }

        NumberAxis years = new NumberAxis(1968, 2008, 1);
        NumberAxis score = new NumberAxis(0, 40, 1);
        LineChart<Number, Number> lineChart = new LineChart<>(years, score);
        lineChart.setTitle("Finnish party support through the years");

        makeXYChartSeries(dataMap, lineChart);
        
        Scene scene = new Scene(lineChart,640,400);
        stage.setScene(scene);
        stage.show();
        
        
    }

    public static void makeXYChartSeries(ArrayList<String> list, LineChart<Number, Number> lineChart) {

            for(int i = 1; i < list.size(); i++){
                XYChart.Series data = new XYChart.Series();
                String[] years = list.get(0).split("\t");
                String[] scores = list.get(i).split("\t");
                data.setName(scores[0]);
                
                for(int x = 1; x<scores.length; x++){
                    if(scores[x].equals("-")){
                        continue;
                    }
                    data.getData().add(new XYChart.Data(Integer.valueOf(years[x]), Double.valueOf(scores[x])));
                }                                
                lineChart.getData().add(data);
            }            
    }

}
