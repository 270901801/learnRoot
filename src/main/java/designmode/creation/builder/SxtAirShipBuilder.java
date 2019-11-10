package designmode.creation.builder;

/**
 * @author hsc
 * @date 2019-11-04 21:53:40
 */
public class SxtAirShipBuilder implements AirShipBuilder {
    //用到建造者 StringBuilder DomBuilder SaxBuilder
    @Override
    public OrbitalModule buildOrbitalModule() {
        System.out.println("构建发动机");
        return new OrbitalModule("轨道舱");
    }

    @Override
    public Engine buildEngine() {
        System.out.println("构建发动机");
        return new Engine("发动机");
    }

    @Override
    public EscapeTower buildEscapeTower() {
        System.out.println("构建逃逸塔");
        return new EscapeTower("逃逸塔");
    }
}
