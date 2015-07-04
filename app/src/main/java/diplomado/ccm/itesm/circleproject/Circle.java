package diplomado.ccm.itesm.circleproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;


public class Circle extends Activity {



    private Button      btnShow;
    private SeekBar     sbCircle;
    private ImageView   container;
    private Paint       pen;
    private Canvas      canvas;
    private TextView    txtCount;


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
        this.container  = (ImageView)   findViewById(R.id.imageViewCircle);
        this.txtCount   = (TextView)    findViewById(R.id.textViewCount);
        this.pen        = new Paint();


        //Asignacion de listener a componentes
        this.btnShow.setOnClickListener(btnListener);
        this.sbCircle.setOnSeekBarChangeListener(sbListener);

    }








    /**************** LISTENERS *************/



    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            drawCircle(10); //Pintamos circulos en la grafica :D
            sbCircle.setProgress(10);
        }
    };


    SeekBar.OnSeekBarChangeListener sbListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            progress = (progress < 3)?3:progress;
            drawCircle(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };




    /************** FIN DE LISTENERS **************/










    /**
     * Pintamos los circulos necesarios
     * @param numCircles numero de circulos que se quieren pintar.
     */
    private void drawCircle(int numCircles){


        this.defineCanvasContainer();

        //Inicializamos

        int x           = this.container.getWidth()  /2;
        int y           = this.container.getHeight() /2;
        int lowSide     = this.container.getWidth() > this.container.getHeight()?this.container.getHeight():this.container.getWidth();
        lowSide        /= 2;
        int lnInterval  = lowSide / numCircles;
        this.txtCount.setText(String.valueOf(numCircles));


        //Ponemos ejes X Y

        //this.canvas.drawLine(x, 0, x, this.container.getHeight(), this.pen);
        //this.canvas.drawLine(0, y, this.container.getWidth(), y, this.pen);



        //Pintamos circulos
        for (int i = 1; i <= numCircles; i++){

            this.canvas.drawCircle(x,y,lnInterval * i,this.pen);

        }




    }





    /**
     * Asignamos un bitmap a un canvas y asociamos ese canvas a un imageview :)
     */
    private void defineCanvasContainer(){
        Bitmap bm       =  Bitmap.createBitmap(this.container.getWidth(), this.container.getHeight(), Bitmap.Config.ARGB_8888);
        this.canvas     = new Canvas(bm);
        this.container.setImageBitmap(bm);


        //Colores
        Random ran     = new Random();
        this.pen.setColor(Color.rgb(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256)));
        this.pen.setStrokeCap(Paint.Cap.ROUND);
        this.pen.setStyle(Paint.Style.STROKE);


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
