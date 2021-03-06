package lu.snt.serval.pla.sensor;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Date;

/**
 * User: assaad.moawad
 * Date: 15/01/14
 * Time: 11:19
 * University of Luxembourg - Snt
 * assaad.mouawad@gmail.com
 */
public class SensorValue {
    private double value;
    private String type;
    private String sensorID;

    private long time;

    public void setTime(long time) {
        this.time = time;
    }

    public void setValue( double value){
        this.value=value;
    }
    public void setType(String type){
        this.type=type;
    }
    public void  setSensorID(String sensorID)         {
        this.sensorID=sensorID;
    }

    public double getValue() {
        return value;
    }

    public long getTime() {
        return time;
    }

    public String getSensorID() {
        return sensorID;
    }

    public String getType() {
        return type;
    }

    public String toJSON()
    {
        JSONObject json = new JSONObject(this);
        return json.toString();
    }

    public static SensorValue fromJSON(String value)
    {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return (SensorValue) mapper.readValue(value, SensorValue.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public String toString() {
        String s="Sensor ID: "+sensorID+" , Type: "+ type+" , Time: "+ (new Date(time)).toString()+", Value: "+ value;
        return s;
    }
}
