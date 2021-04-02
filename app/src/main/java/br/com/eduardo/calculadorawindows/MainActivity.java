package br.com.eduardo.calculadorawindows;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button BZero, BUm, BDois, BTres, BQuatro, BCinco, BSeis, BSete, BOito, BNove, Bponto, BSoma, BSub, BMult, BDiv, BClean, BIgual, BDel;
    private TextView Historico, Resultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Iniciar();
        getSupportActionBar();
        setOnClick();


    }
    private void setOnClick(){
        BZero.setOnClickListener(this);
        BUm.setOnClickListener(this);
        BDois.setOnClickListener(this);
        BTres.setOnClickListener(this);
        BQuatro.setOnClickListener(this);
        BCinco.setOnClickListener(this);
        BSeis.setOnClickListener(this);
        BSete.setOnClickListener(this);
        BOito.setOnClickListener(this);
        BNove.setOnClickListener(this);
        Bponto.setOnClickListener(this);
        BSoma.setOnClickListener(this);
        BSub.setOnClickListener(this);
        BMult.setOnClickListener(this);
        BDiv.setOnClickListener(this);

        BDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView exp = findViewById(R.id.txtHistory);
                String string= Historico.getText().toString();
                if(!string.isEmpty()){
                    byte x1= 0;
                    int x2=string.length()-1;
                    String txtHistorico= string.substring(x1,x2);
                    Historico.setText(txtHistorico);
                }
                Resultado.setText(" ");
            }
        });
        BClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resultado.setText(" ");
                Historico.setText(" ");
            }
        });

        BIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expression expression= new ExpressionBuilder(Historico.getText().toString()).build();
                double result = expression.evaluate();
                long longresult = (long) result;
                if(result == (double) longresult){
                    Resultado.setText((CharSequence) String.valueOf(longresult));
                }else{
                    Resultado.setText((CharSequence) String.valueOf(Resultado));
                }

            }
        });
    }
    private void Iniciar(){
        BZero = findViewById(R.id.B_Zero);
        BUm = findViewById(R.id.B_Um);
        BDois = findViewById(R.id.B_Dois);
        BTres = findViewById(R.id.B_Tres);
        BQuatro = findViewById(R.id.B_Quatro);
        BCinco = findViewById(R.id.B_Cinco);
        BSeis = findViewById(R.id.B_Seis);
        BSete = findViewById(R.id.B_Sete);
        BOito = findViewById(R.id.B_Oito);
        BNove = findViewById(R.id.B_Nove);
        Bponto = findViewById(R.id.B_dot);
        BSoma = findViewById(R.id.B_Soma);
        BSub = findViewById(R.id.B_Sub);
        BMult = findViewById(R.id.B_Multi);
        BDiv = findViewById(R.id.B_Divi);
        BClean = findViewById(R.id.B_Clean);
        BIgual = findViewById(R.id.B_Equal);
        BDel = findViewById(R.id.B_Del);
        Historico = findViewById(R.id.txtHistory);
        Resultado= findViewById(R.id.txtResult);
    }

    public void expression (String string, boolean limpar_dados)
    {
        if(Resultado.getText().equals(""))
        {
            Historico.setText(" ");
        }

        if(limpar_dados){
            Resultado.setText(" ");
            Historico.append(string);
        }else{
            Historico.append(Resultado.getText());
            Historico.append(string);
            Resultado.setText(" ");
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.B_Zero:
                expression("0", true);
                break;
            case R.id.B_Um:
                expression("1", true);
                break;
            case R.id.B_Dois:
                expression("2", true);
                break;
            case R.id.B_Tres:
                expression("3", true);
                break;
            case R.id.B_Quatro:
                expression("4", true);
                break;
            case R.id.B_Cinco:
                expression("5", true);
                break;
            case R.id.B_Seis:
                expression("6", true);
                break;
            case R.id.B_Sete:
                expression("7", true);
                break;
            case R.id.B_Oito:
                expression("8", true);
                break;
            case R.id.B_Nove:
                expression("9", true);
                break;
            case R.id.B_dot:
                expression(".", true);
                break;
            case R.id.B_Soma:
                expression("+", false);
                break;
            case R.id.B_Sub:
                expression("-", false);
                break;
            case R.id.B_Divi:
                expression("/", false);
                break;
            case R.id.B_Multi:
                expression("*", false);
                break;
            case R.id.B_Equal:
                expression("=", false);
                break;
        }

    }
}