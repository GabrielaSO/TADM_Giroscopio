package com.example.giso.tadm_giroscopio;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Sensor miSensor;
    private SensorManager sensorManager;
    TextView ejex, ejey, ejez;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager =(SensorManager)getSystemService(SENSOR_SERVICE);
        miSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE); //cambiar giroscopio

        ejex= findViewById(R.id.ejex);
        ejey=findViewById(R.id.ejey);
        ejez= findViewById(R.id.ejez);

        sensorManager.registerListener(this, miSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void  onSensorChanged(SensorEvent event){
        ejex.setText("eje x: "+event.values[0]);
        ejey.setText("eje y: "+event.values[1]);
        ejez.setText("eje z: "+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
