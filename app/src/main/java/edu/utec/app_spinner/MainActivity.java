package edu.utec.app_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private Spinner spinner1;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.txt_valor1);
        et2 = (EditText) findViewById(R.id.txt_valor2);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        tv1 = (TextView) findViewById(R.id.tv_resultado);

        // Creo el arreglo para cargar el spinner
        String [] opciones = {"sumar","restar","multiplicar","dividir"};

        ArrayAdapter <String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item__rodrigo, opciones);
        spinner1.setAdapter(adapter);
    }

    // Método del botón
    public void Calcular(View view) {
        // tomo los valres recibidos
        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        // Convierto los valores a entero para realizas las operaciones
        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);

        // Creo variable para asignarle el valor del spinner
        String seleccion = spinner1.getSelectedItem().toString();

        // Realizo las operaciones segun corresponda

        if (seleccion.equals("sumar")) {
            int suma = valor1_int + valor2_int;
            String resultado = String.valueOf(suma);
            tv1.setText(resultado);
        } else if (seleccion.equals("restar")) {
            int resta = valor1_int - valor2_int;
            String resultado = String.valueOf(resta);
            tv1.setText(resultado);
        } else if (seleccion.equals("multiplicar")) {
            int multiplicar = valor1_int * valor2_int;
            String resultado = String.valueOf(multiplicar);
            tv1.setText(resultado);
        } else if (seleccion.equals("dividir")) {
            if (valor2_int != 0) {
                int dividir = valor1_int / valor2_int;
                String resultado = String.valueOf(dividir);
                tv1.setText(resultado);
            } else {
                Toast.makeText(this, "El segundo valor ingresado debe ser distinto a 0 ", Toast.LENGTH_LONG).show();
                tv1.setText("");
            }

        }
    }
        // Creo el metod limpiar los valores

        public void limpiar (View view){
            et1.setText("");
            et2.setText("");
            tv1.setText("El Resultado es:");
        }

}