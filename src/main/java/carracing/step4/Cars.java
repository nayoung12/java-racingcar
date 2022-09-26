package carracing.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;
    private final Supplier<Integer> numberGenerator;

    public Cars(List<String> carNames, Supplier<Integer> numberGenerator) {
        this.cars = new ArrayList<>(carNames.size());
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        this.numberGenerator = numberGenerator;
    }

    public void moveAllCars() {
        for (int i = 0; i < cars.size(); i++) {
            moveCar(i);
        }
    }

    private void moveCar(int carNum) {
        cars.get(carNum).move(numberGenerator.get());
    }

    public List<CarVo> getAllCarsTrace() {
        return cars.stream().map(car -> new CarVo(car.getName(), car.getMoveCnt())).collect(toList());
    }

    public List<String> getWinner() {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            winnerCars = getWinnerCars(winnerCars, car);
        }
        return winnerCars.stream().map(Car::getName).collect(toList());
    }

    private List<Car> getWinnerCars(List<Car> winnerCars, Car car) {
        if (winnerCars.isEmpty()) {
            winnerCars.add(car);
        } else if (winnerCars.get(0).getMoveCnt() < car.getMoveCnt()) {
            winnerCars.clear();
            winnerCars.add(car);
        } else if (winnerCars.get(0).getMoveCnt() == car.getMoveCnt()) {
            winnerCars.add(car);
        }
        return winnerCars;
    }

}