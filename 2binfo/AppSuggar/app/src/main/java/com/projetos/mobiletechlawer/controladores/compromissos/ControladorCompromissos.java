package com.projetos.mobiletechlawer.controladores.compromissos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.projetos.mobiletechlawer.R;
import com.projetos.mobiletechlawer.dominios.Compromisso;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class ControladorCompromissos extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, DialogInterface.OnCancelListener {

    private EditText edt_titulo;
    private EditText edt_data;
    private EditText edt_local;
    private EditText edt_descricao;

    private Switch switch_dia_todo;

    private Button btnDatePicker;
    private Button btn_local;
    private Button btn_salvar_compromisso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_controlador_compromissos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_titulo = (EditText) findViewById(R.id.edt_titulo);
        edt_data = (EditText) findViewById(R.id.edt_data);
        edt_local = (EditText) findViewById(R.id.edt_local);
        edt_descricao = (EditText) findViewById(R.id.edt_descricao);

        switch_dia_todo = (Switch) findViewById(R.id.switch_dia_todo);

        btnDatePicker = (Button) findViewById(R.id.btnDatePicker);
        btnDatePicker.setOnClickListener(this);
        btn_local = (Button) findViewById(R.id.btn_local);
        btn_local.setOnClickListener(this);
        btn_salvar_compromisso = (Button) findViewById(R.id.btn_salvar_compromisso);
        btn_salvar_compromisso.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDatePicker:
                scheduleTestDrive(v);
                break;
            case R.id.btn_local:
                Toast.makeText(this, "Não Implementado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_salvar_compromisso:
                try{
                    if (verificarCampos()){
                        String titulo = edt_titulo.getText().toString();
                        String data = edt_data.getText().toString();
                        Boolean diaTodo = switch_dia_todo.isChecked();
                        String local = edt_local.getText().toString();
                        String descricao = edt_descricao.getText().toString();

                        Compromisso compromisso = new Compromisso(titulo, data, diaTodo, local, descricao);
                        try {
                            compromisso.save();
                            Toast.makeText(this, "Funfo Porra", Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            Toast.makeText(this, "Deu Ruim no .save()!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }catch (Exception e){
                    Toast.makeText(this, "Deu Ruim ao pegar dados!", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
    public Boolean verificarCampos(){
        Boolean sucesso;

        if (edt_titulo.getText().toString().isEmpty()){
            Toast.makeText(this, "Prencha todos os Campos!", Toast.LENGTH_SHORT).show();
            sucesso = false;
        }else if (edt_data.getText().toString().isEmpty()){
            Toast.makeText(this, "Prencha todos os Campos!", Toast.LENGTH_SHORT).show();
            sucesso = false;
        }else if (edt_local.getText().toString().isEmpty()){
            Toast.makeText(this, "Prencha todos os Campos!", Toast.LENGTH_SHORT).show();
            sucesso = false;
        }else if (edt_descricao.getText().toString().isEmpty()){
            Toast.makeText(this, "Prencha todos os Campos!", Toast.LENGTH_SHORT).show();
            sucesso = false;
        }else{
            sucesso = true;
        }
        return sucesso;
    }
    private int ano, mes, dia, hora, minuto;

    public void scheduleTestDrive(View view){
        initDateTimeData();
        Calendar cDefault = Calendar.getInstance();
        cDefault.set(ano, mes, dia);

        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                this,
                cDefault.get(Calendar.YEAR),
                cDefault.get(Calendar.MONTH),
                cDefault.get(Calendar.DAY_OF_MONTH)
        );

        Calendar cMim = Calendar.getInstance();
        Calendar cMax = Calendar.getInstance();

        cMax.set(cMax.get(Calendar.YEAR), 11, 31);
        datePickerDialog.setMinDate(cMim);
        datePickerDialog.setMaxDate(cMax);

        List<Calendar> daysList  = new LinkedList<>();
        Calendar[] daysArray;
        Calendar cAux = Calendar.getInstance();

        while (cAux.getTimeInMillis() <= cMax.getTimeInMillis()){
            if (cAux.get( Calendar.DAY_OF_WEEK) != Calendar.SUNDAY){

                Calendar c  = Calendar.getInstance();
                c.setTimeInMillis(cAux.getTimeInMillis());

                daysList.add(c);
            }
            cAux.setTimeInMillis(cAux.getTimeInMillis() + (24*60*60*1000));
        }
        daysArray = new Calendar[daysList.size()];
        for (int i = 0; i  <daysArray.length; i++){
            daysArray[i] = daysList.get(i);
        }
        datePickerDialog.setSelectableDays(daysArray);
        datePickerDialog.setOnCancelListener(this);
        datePickerDialog.show(getFragmentManager(), "DatePickerDialog");
    }
    private void initDateTimeData(){
        if (ano ==0){
            Calendar c = Calendar.getInstance();
            ano = c.get(Calendar.YEAR);
            mes = c.get(Calendar.MONTH);
            dia = c.get(Calendar.DAY_OF_MONTH);
            hora = c.get(Calendar.HOUR_OF_DAY);
            minuto = c.get(Calendar.MINUTE);


        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        ano = mes = dia = hora = minuto = 0;
        edt_data.setText("");
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Calendar tDefault = Calendar.getInstance();
        tDefault.set( ano, mes, dia, hora, minuto);

        ano = year;
        mes = monthOfYear;
        dia = dayOfMonth;

        TimePickerDialog timePickerDialog = TimePickerDialog.newInstance(
                this,
                tDefault.get(Calendar.HOUR_OF_DAY),
                tDefault.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.setOnCancelListener(this);
        timePickerDialog.show(getFragmentManager(), "timerPickerDialog");
    }
    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        if (hourOfDay < 9 || hourOfDay > 18 ){
            onDateSet(null, ano, mes, dia);
            Toast.makeText(this, "Somente entro 9h e 18h", Toast.LENGTH_SHORT).show();
            return;
        }
        hora = hourOfDay;
        minuto = minute;

        edt_data.setText( (dia < 10 ? "0"+dia : dia)+"/"+
                (mes < 10 ? "0"+mes : mes)+"/"+
                ano+" ás "+
                (hora < 10 ? "0"+hora : hora)+"h"+
                (minuto < 10 ?"0"+minuto : minuto));
    }
}
