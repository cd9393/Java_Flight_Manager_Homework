public enum PlaneType {

    AIRBUSA220(116, 6000),
    AIRBUSA330(247, 24200),
    AIRBUSA350(325, 28000),
    BOEING747(4,448),
    BOEING787(250, 23000)
    ;


    private int capacity;
    private int weight;

    private PlaneType(int capacity, int weight){
        this.capacity = capacity;
        this.weight = weight;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWeight() {
        return weight;
    }
}
