package fr.diginamic.hello;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.hello.entities.City;
import fr.diginamic.hello.entities.Department;
import fr.diginamic.hello.services.CityService;
import fr.diginamic.hello.services.DepartmentService;

@SpringBootApplication
public class TraitementFichiersApplication implements CommandLineRunner {
	
	@Value("${initialized.base}")
	private boolean initializedBase;
	@Autowired
	private CityService cityService;
	@Autowired
	private DepartmentService departmentService;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(TraitementFichiersApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

	@Override
	public void run(String... args) throws Exception {

		if(initializedBase) {
			System.out.println("Base deja initialiser !");
			return;
		}
		Path pathOri = Paths
				.get("C:\\Users\\MiL\\Developpement\\Formation_Diginamic\\12-JavaApprocheObjet\\TP\\recensement.csv");
		List<String> lines = Files.readAllLines(pathOri);
		String lineColumn = lines.remove(0);
		System.out.println(lineColumn);
		List<City> cities = new ArrayList<>();
		List<Department> departments = new ArrayList<>();

		for (String line : lines) {
			String[] elements = line.split(";");
			int nbHabs = Integer.parseInt(elements[9].replaceAll(" ", ""));
			if (nbHabs == 0) {
				nbHabs = 1;
			}
			Department department = new Department(elements[0]);

			if (!departments.contains(department)) {
				departments.add(department);
				departmentService.insertDepartment(department);
			} else {
				for (Department dep : departments) {
					if (dep.getCode().equals(department.getCode())) {
						department = dep;
					}
				}
			}
			City city = new City(elements[6], nbHabs, department);
			if (!cities.contains(city)) {
				cities.add(city);
				cityService.addVille(city);
			}
		}
	}
}