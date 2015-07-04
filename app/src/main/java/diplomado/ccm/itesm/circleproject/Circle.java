package diplomado.ccm.itesm.circleproject;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;


public class Circle extends Activity {



    private Button      btnShow;
    private SeekBar     sbCircle;
    private ImageView   imgvCircle;
    private Paint       pen;
    private Canvas      canvas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        this.initializeVariables();
    }


    /**
     * Inicializamos las variables que utilizaremos en el proyecto.
     */
    private void initializeVariables(){

        this.btnShow    = (Button)      findViewById(R.id.buttonShow);
        this.sbCircle   = (SeekBar)     findViewById(R.id.seekBarCircle);
        this.imgvCircle = (ImageView)   findViewById(R.id.imageViewCircle);

    }








    /**************** LISTENERS *************/







    /************** FIN DE LISTENERS **************/










    /**
     * Pintamos los circulos necesarios
     * @param numCircles numero de circulos que se quieren pintar.
     */
    private void drawCircle(int numCircles){



    }









    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_circle, menu);
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
