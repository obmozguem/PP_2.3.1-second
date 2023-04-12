package web.dao;


import org.springframework.stereotype.Repository;
import web.models.Car;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Lada Priora", 2020, "silver metallic"));
        cars.add(new Car("Lada Vesta", 2019, "yellow"));
        cars.add(new Car("BMW X6", 2022, "black"));
        cars.add(new Car("Opel Astra", 2018, "grey"));
        cars.add(new Car("Toyota Camry", 2021, "white"));
    }

    @Override
    public List<Car> getCars(int count) {
        List<Car> returnList = new ArrayList<>();
        if (count > 0 && count < 5) {
            for (int i = 0; i < count; i++) {
                returnList.add(cars.get(i));
            }
            return returnList;
        } else {
            return cars;
        }
    }
}
