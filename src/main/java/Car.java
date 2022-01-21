public class Car {

    private final String brandName;
    private final String modelName;
    private final int modelYear;
    private final BodyType bodyType;

    public Car(String brandName, String modelName, int modelYear, BodyType bodyType) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.bodyType = bodyType;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    @Override
    public String toString() {
        return "Car: {"+
                "Brand = '"+ brandName + '\''+
                ", Model = '"+ modelName + '\''+
                ", Model Year = '" + modelYear+ '\''+
                ", Body Type = '" + bodyType+ '\''+
                '}';
    }
}
