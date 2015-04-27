package tw.hybridglucose.test02;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
//import tw.hybridglucose.test02.Calculate;

import org.w3c.dom.Text;


public class MainActivity extends ActionBarActivity {
    public double s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button conventButton;
        final Spinner sourceSpinner, targetSpinner;
        final EditText sourceEdt;
        final TextView resultTev;

        conventButton = (Button) findViewById(R.id.convertButton);
        sourceEdt = (EditText) findViewById(R.id.sourceEdt);
        targetSpinner = (Spinner) findViewById(R.id.targetSpinner);
        sourceSpinner = (Spinner) findViewById(R.id.sourceSpinner);
        resultTev = (TextView) findViewById(R.id.resultTev);

        conventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                //Get Spinner Unit.
                String sourceUnit = sourceSpinner.getSelectedItem().toString();
                String targetUnit = targetSpinner.getSelectedItem().toString();
                //CoventEditText to Double.
                try {
                    s = Double.parseDouble(sourceEdt.getText().toString());
                    //Convet S to coomon unit.
                    switch (sourceUnit) {
                        case "公釐":
                            s /= 10000;
                            break;
                        case "公分":
                            s /= 100;
                            break;
                        case "公尺":
                            s *= 1;
                            break;
                        case "公里":
                            s *= 1000;
                            break;
                    }
                    //Convent S to target unit.
                    switch (targetUnit) {
                        case "公釐":
                            s *= 10000;
                            break;
                        case "公分":
                            s *= 100;
                            break;
                        case "公尺":
                            s *= 1;
                            break;
                        case "公里":
                            s /= 1000;
                            break;
                    }
                    resultTev.setText(result.valueOf(s));
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"請輸入數字",Toast.LENGTH_SHORT).show();
                }
            }});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
