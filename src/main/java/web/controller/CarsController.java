package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDaoImpl;

@Controller
@RequestMapping("/cars")

public class CarsController {
    private final CarDaoImpl carDao;

    public CarsController(CarDaoImpl carDao) {
        this.carDao = carDao;
    }

    @GetMapping()
    public String gatAllCars(@RequestParam(value = "count", defaultValue = "5") int count, Model model) {
        model.addAttribute("ourCars", carDao.getCars(count));
        return "cars";
    }


}
