package designmode.creation.builder;

/**
 * @author hsc
 * @date 2019-11-04 22:04:06
 */
public class Client {
    public static void main(String[] args) {
        AirShipDirector airShipDirector=new SxtAirShipDirector(new SxtAirShipBuilder());
        AirShip airShip=airShipDirector.directAirShip();
        System.out.println(airShip.toString());
        System.out.println(airShip.getEngine().getName());
    }
}
