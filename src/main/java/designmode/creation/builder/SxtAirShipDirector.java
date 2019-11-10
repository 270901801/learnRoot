package designmode.creation.builder;

/**
 * @author hsc
 * @date 2019-11-04 21:58:16
 */
public class SxtAirShipDirector implements AirShipDirector {
    private SxtAirShipBuilder builder;

    public SxtAirShipDirector(SxtAirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine engine=builder.buildEngine();
        EscapeTower escapeTower=builder.buildEscapeTower();
        OrbitalModule orbitalModule=builder.buildOrbitalModule();
        AirShip airShip=new AirShip();
        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModule(orbitalModule);
        return airShip  ;
    }
}
