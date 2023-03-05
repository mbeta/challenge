package ar.com.challenge.enums;

public enum EnumMoneda {
    USD("USD"),
    ARP("ARP"),
    JPY("JPY"),
    BRL("BRL"),
    EUR("EUR"),
    VIR("VIR"),
    CNH("CNH"),
    CHF("CHF"),
    XDR("XDR"),
    GBP("GBP");

    private final String tipoMoneda;

    EnumMoneda(final String tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public String toString() {
        return this.tipoMoneda;
    }
}
