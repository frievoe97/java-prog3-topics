package abstractFactoryPatternCompanies;

public class Main {
    //Siehe: https://www.youtube.com/watch?v=QNpwWkdFvgQ
    public static void main(String[] args) {
        Company msi = new MsiManufacturer();
        Gpu msiGpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();

        Company asus = new AsusManufacturer();
        Gpu asusGpu = asus.createGpu();
        Monitor asusMonitor = asus.createMonitor();
    }
}
