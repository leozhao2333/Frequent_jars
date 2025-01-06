package com.ziggeo.androidsdk.widgets.soundgraph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.FrameLayout;

import com.ziggeo.androidsdk.R;

import java.util.List;

import com.ziggeo.androidsdk.log.ZLog;

public class GraphView extends FrameLayout {

    private final int MAX_AMPLITUDE = 22000;//Maximum possible amplitude
    private GraphSurfaceView graphSurfaceView;
    private List<WaveSample> pointList;
    private Paint paint;
    private int canvasColor = Color.TRANSPARENT;
    private boolean pausePlotting = false;

    public GraphView(Context context) {
        super(context);
        init(context);
    }

    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public GraphView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        graphSurfaceView = new GraphSurfaceView(context);
        this.setBackgroundColor(canvasColor);
        this.addView(graphSurfaceView);
        this.requestLayout();
    }

    /**
     * Pause the wave graph plotting, use {@link #resume()} for resume
     */
    public void pause() {
        this.pausePlotting = true;
    }

    /**
     * Resume the wave graph plotting, use {@link #pause()} for pause
     */
    public void resume() {
        this.pausePlotting = false;
    }

    /**
     * Assign list that holds samples
     *
     * @param list
     */
    public void setMasterList(List<WaveSample> list) {
        graphSurfaceView.setMasterList(list);
    }

    public void startPlotting() {
        graphSurfaceView.startPlotting();
    }

    /**
     * reset the graph before each start plotting and show full graph
     */
    public void reset() {
        graphSurfaceView.reset();
        graphSurfaceView.resetDimensions();
    }

    /**
     * Stop plotting the wave graph
     */
    public void stopPlotting() {
        graphSurfaceView.stopPlotting();
    }

    public class GraphSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
        int listMasterSize = 0;
        int redrawCount = 0;
        int freezCount = 0;
        int sleepTime = 5;
        private SurfaceHolder holder;
        private Thread _plottingThread;
        //Current rendered surface view dimensions
        private int height;
        private int halfHeight;
        private int width;
        private volatile int waveLength;
        private volatile boolean isRunning = false;
        private volatile boolean stop = false;

        public GraphSurfaceView(Context context) {
            super(context);
            init(context);
        }

        public GraphSurfaceView(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public GraphSurfaceView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            init(context);
        }

        public void init(Context context) {
            //Setting up surface view with default dimensions
            this.setLayoutParams(new LayoutParams(
                    context.getResources().getDimensionPixelSize(R.dimen.audio_chart_height),
                    context.getResources().getDimensionPixelSize(R.dimen.audio_chart_height)
            ));

            //Set wave length in mm
            waveLength = context.getResources().getDimensionPixelSize(R.dimen.audio_chart_wave_length);

            holder = getHolder();
            holder.addCallback(this);

            //Paint config for waves
            paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            int graphColor = Color.GRAY;
            paint.setColor(graphColor);
            paint.setStrokeWidth(1);
            paint.setStyle(Paint.Style.STROKE);

            setZOrderOnTop(true);

            SurfaceHolder holder = getHolder();
            holder.setFormat(PixelFormat.TRANSLUCENT);
        }

        /**
         * Function to calculate time to x and amplitude to y mapping of each sample for current frame
         */
        private void processAmplitude() {
            //calculate sleep time and redraw count for smooth wave movement
            if (pointList.size() != listMasterSize) {//new sample found since last frame
                listMasterSize = pointList.size();
                freezCount = -1;
                redrawCount = 0;
            }
            //Path variable for wave
            Path graphPath = new Path();

            //Initialize start position for wave path
            int x = width;
            int listSize = pointList.size() - 1;

            /*
            Draw sine waves for last 'n' no of samples.
            'n' is calculated from no x - direction pixels available in surface view from width * 3/4 to 0 - wavelength.
            Each sample will be drawn as a sine wave with waveLength as width
            */
            for (int i = listSize - 1; x >= 0 - waveLength; x = x - waveLength) {
                if (i >= 0) {
                    int amplitude = (int) pointList.get(i).getAmplitude();
                    drawAmplitude(amplitude, x, graphPath);
                }
                i--;
            }
            renderAmplitude(graphPath);
        }

        /**
         * Draw sine wave path for current sample at x position with amplitude and needle path to show current amplitude
         */
        private Path drawAmplitude(int amplitude, int x, Path graphPath) {
            /* Calculate no y pixels for sine wave magnitude from amplitude */
            amplitude = halfHeight * amplitude / MAX_AMPLITUDE;
            /*  If current sample is the latest then move needle to show current amplitude    */
            if (amplitude > 0) {
                /*  Below code can be customized to support more graph types
                 *  Draw a sine wave from x-redrawCount to x - redrawCount + waveLength with positive magnitude at halfHeight - amplitude and negative at halfHeight + amplitude    */
                RectF oval = new RectF();
                oval.set(x - redrawCount, halfHeight - amplitude, x - redrawCount + (waveLength / 2), halfHeight + amplitude);
                graphPath.addArc(oval, 180, 180);
                oval.set(x - redrawCount + (waveLength / 2), halfHeight - amplitude, x - redrawCount + (waveLength), halfHeight + amplitude);
                graphPath.addArc(oval, 0, 180);
            } else {
                /*  Draw simple line to represent 0 */
                graphPath.moveTo(x - redrawCount, halfHeight);
                graphPath.lineTo(x - redrawCount + waveLength, halfHeight);
            }
            return graphPath;
        }

        /**
         * Draw all the path on SurfaceView canvas
         */
        private void renderAmplitude(Path tempPath) {
            Canvas tempCanvas = null;
            if (holder.getSurface().isValid()) {//SurfaceView available
                try {
                    tempCanvas = holder.lockCanvas();
                    synchronized (holder) {
                        if (tempCanvas != null) {
                            /*  Clean SurfaceView with plain canvas color   */
                            tempCanvas.drawColor(canvasColor, PorterDuff.Mode.CLEAR);

                            /*  Draw sine waves and needle  */
                            tempCanvas.drawPath(tempPath, paint);
                        }
                    }
                } finally {
                    if (tempCanvas != null) {
                        holder.unlockCanvasAndPost(tempCanvas);
                    }
                }
            }
            try {
                /*  Sleep the thread to reduce CPU usage and avoid same wave redrawn    */
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ZLog.d("Created");

            /*  Configure width for current mode  */
            this.setLayoutParams(new LayoutParams(GraphView.this.getWidth(), GraphView.this.getHeight()));
            /*  Continue plotting on app switches between foreground and background  */
            if (isRunning && !_plottingThread.isAlive()) {
                startPlotting();
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
            ZLog.d("Changed");
            //Reset will get current rendered dimensions
            reset();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ZLog.d("Destroyed");
            //Stop the plotting if app goes to background
            this.stop = true;
            if (_plottingThread != null) {
                _plottingThread.interrupt();
            }
        }

        /**
         * Reset the surface view with plain canvas color and get current rendered dimensions
         */
        public void reset() {
            height = getHeight();
            halfHeight = height / (2);
            width = getWidth();
            Canvas tempCanvas = null;
            if (holder.getSurface().isValid()) {
                try {
                    tempCanvas = holder.lockCanvas();
                    synchronized (holder) {
                        if (tempCanvas != null) {
                            tempCanvas.drawColor(canvasColor, PorterDuff.Mode.CLEAR);
                        }
                    }
                } finally {
                    if (tempCanvas != null) {
                        holder.unlockCanvasAndPost(tempCanvas);
                    }
                }
            }
        }

        /**
         * set master list that holds the samples
         *
         * @param list
         */
        public void setMasterList(List<WaveSample> list) {
            pointList = list;
        }

        /**
         * Reset the flags and start drawing thread
         */
        public void startPlotting() {
            reset();
            this.stop = false;
            isRunning = true;
            _plottingThread = new Thread(this);
            _plottingThread.start();
        }

        /**
         * Reset the flags and stop drawing thread
         */
        public void stopPlotting() {
            this.stop = true;
            isRunning = false;
            if (_plottingThread != null) {
                _plottingThread.interrupt();
            }
        }

        @Override
        public void run() {
            while (!this.stop) {
                if (!pausePlotting) {
                    processAmplitude();
                }
            }
        }

        /**
         * Make surface view to fit it's width and height to the rendered horizontal scroll view
         */
        public void resetDimensions() {
            this.setLayoutParams(new LayoutParams(GraphView.this.getWidth(), GraphView.this.getHeight()));
        }
    }
}