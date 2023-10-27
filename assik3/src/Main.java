import java.util.Scanner;

// Интерфейс для сервиса температуры в градусах Фаренгейта
interface TemperatureService {
    double getTemperatureInFahrenheit();
}

// Сервис температуры в градусах Фаренгейта
class FahrenheitTemperatureService implements TemperatureService {
    private double temperatureInFahrenheit;

    public FahrenheitTemperatureService(double temperatureInFahrenheit) {
        this.temperatureInFahrenheit = temperatureInFahrenheit;
    }

    @Override
    public double getTemperatureInFahrenheit() {
        return temperatureInFahrenheit;
    }
}

// Адаптер для конвертации температуры из градусов Цельсия в градусы Фаренгейта
class TemperatureAdapter implements TemperatureService {
    private TemperatureInCelsius temperatureInCelsius;

    public TemperatureAdapter(TemperatureInCelsius temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    @Override
    public double getTemperatureInFahrenheit() {
        // Формула для конвертации
        return (temperatureInCelsius.getTemperatureInCelsius() * 9 / 5) + 32;
    }
}

// Сервис температуры в градусах Цельсия
class TemperatureInCelsius {
    private double temperatureInCelsius;

    public TemperatureInCelsius(double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите температуру в градусах Цельсия: ");
        double celsiusTemperature = scanner.nextDouble();

        TemperatureInCelsius temperatureInCelsius = new TemperatureInCelsius(celsiusTemperature);

        TemperatureService adapter = new TemperatureAdapter(temperatureInCelsius);

        double temperatureInFahrenheit = adapter.getTemperatureInFahrenheit();
        System.out.println("Температура в градусах Фаренгейта: " + temperatureInFahrenheit);
    }
}
