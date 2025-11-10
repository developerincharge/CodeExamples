package singleton;

class Country {
    private String name;
    private String code;
    private String capital;

    public Country(String name, String code, String capital) {
        this.name = name;
        this.code = code;
        this.capital = capital;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getCapital() {
        return capital;
    }

    @Override
    public String toString() {
        return name + " (" + code + ") - Capital: " + capital;
    }
}
