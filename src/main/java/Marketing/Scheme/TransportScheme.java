package Marketing.Scheme;

import Storage.TransportationCan;

/**
 * 委派模式
 * 运输计划
 *
 * @author 吴英豪
 */

public class TransportScheme extends Scheme {

    //运输信息
    private TransportationCan transportationCan;

    //运输种类
    private TransportType transportType;

    //运输种类
    public enum TransportType{
            Land,Ship
    }

    /* setters and getters*/
    public TransportationCan getTransportationCan() {
        return transportationCan;
    }

    public TransportType getTransportType(){
            return transportType;
    }

    public void setTransportationCan(TransportationCan can) {
        this.transportationCan = can;
    }

    public void setTransportType(TransportType type){
            transportType = type;
    }
}
