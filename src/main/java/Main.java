import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Car> cars = getCars();

        //Imperative Approach
  /*      List<Car> sedans = new ArrayList<>();

        for (Car car : cars) {
            if (car.getBodyType().equals(BodyType.SEDAN)) {
                sedans.add(car);
            }
        }
        sedans.forEach(System.out::println);
*/


        //Declarative Approach

        //Filter
        List<Car> sedans = cars.stream()
                .filter(car -> car.getBodyType().equals(BodyType.SEDAN))
                .collect(Collectors.toList());
//        sedans.forEach(System.out::println);

        //Sort
        List<Car> sortedSedansByModelYear = cars.stream()
                .sorted(Comparator.comparing(Car::getModelYear)/*.reversed()*/)
                .collect(Collectors.toList());
        sortedSedansByModelYear.forEach(System.out::println);

        //All Match
        boolean allMatch = cars.stream()
                .allMatch(car -> car.getModelYear() > 2012);
        System.out.println(allMatch);

        //None Match
        boolean noneMatch = cars.stream()
                .noneMatch(car -> car.getBrandName().equals("Aston Martin"));
        System.out.println(noneMatch);

        //Max
        cars.stream()
                .max(Comparator.comparing(Car::getModelYear))
                .ifPresent(System.out::println);

        //Min
        cars.stream()
                .min(Comparator.comparing(Car::getModelYear))
                .ifPresent(System.out::println);

        //Group By Body Type
        Map<BodyType, List<Car>> groupByBodyType = cars.stream()
                .collect(Collectors.groupingBy(Car::getBodyType));

        groupByBodyType.forEach((bodyType, car) -> {
            System.out.println(bodyType);
            car.forEach(System.out::println);
        });

        // Group By Body Type and Max
        cars.stream()
                .filter(car -> car.getBodyType().equals(BodyType.SEDAN))
                .max(Comparator.comparing(Car::getModelYear))
                .map(car -> car.getBrandName() + " " + car.getModelName())
                .ifPresent(System.out::println);
    }


    private static List<Car> getCars() {
        return List.of(
                new Car("Audi", "A8 Long", 2018, BodyType.SEDAN),
                new Car("BMW", "320i", 2020, BodyType.SEDAN),
                new Car("Mercedes", "C180", 2021, BodyType.SEDAN),
                new Car("Audi", "Q7", 2021, BodyType.SUV),
                new Car("Mercedes", "A180", 2017, BodyType.HATCHBACK),
                new Car("BMW", "X5", 2015, BodyType.SUV),
                new Car("Volkswagen", "Passat", 2019, BodyType.SEDAN)
        );
    }


}
