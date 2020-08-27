package fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moyoapp.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;


public class StatisticsFragment extends Fragment {

    LineChartView lineChartView;

    String[] axisData = {"Mon","Tue","Wed","Thur","Fri","Sat","Sun" };
    int[] yAxisData = {50, 60, 70, 80, 90, 100, 110, 120};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view;
        view = inflater.inflate(R.layout.fragment_statistics, container, false);

        lineChartView = view.findViewById(R.id.bpreadingsline);

        List yAxisValues = new ArrayList();
        List axisValues = new ArrayList();

        Line line = new Line(yAxisValues);
        line = new Line(yAxisValues).setColor(Color.parseColor("#7147e8"));

        line = new Line(yAxisValues);

        for (int i = 0; i < axisData.length; i++) {
            axisValues.add(i, new AxisValue(i).setLabel(axisData[i]));
        }

        for (int i = 0; i < yAxisData.length; i++) {
            yAxisValues.add(new PointValue(i, yAxisData[i]));
        }

        List lines = new ArrayList();
        lines.add(line);


        lines = new ArrayList();
        lines.add(line);

        LineChartData data = new LineChartData();
        data.setLines(lines);

         data = new LineChartData();
        data.setLines(lines);

        Axis axis = new Axis();
        axis.setValues(axisValues);
        axis.setName("Days");
        axis.setTextSize(20);
        axis.setTextColor(Color.parseColor("#000000"));
        data.setAxisXBottom(axis);

        Axis yAxis = new Axis();
        yAxis.setName("Blood Pressure Readings");
        yAxis.setTextColor(Color.parseColor("#000000"));
        yAxis.setTextSize(20);
        data.setAxisYLeft(yAxis);

        lineChartView.setLineChartData(data);
        Viewport viewport = new Viewport(lineChartView.getMaximumViewport());
        viewport.top = 110;
        lineChartView.setMaximumViewport(viewport);
        lineChartView.setCurrentViewport(viewport);





        return view;


    }
}