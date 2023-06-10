package commuteTime;

public class CommuteModel {
    private double hourlyWage;
    private String departureLocation;
    private String destinationLocation;
    private double commuteTime;

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public void calculateCommuteTime() {
        System.out.println("hourlyWage: " + hourlyWage);
        System.out.println("departureLocation: " + departureLocation);
        System.out.println("destinationLocation: " + destinationLocation);
        // 이동 시간 계산 로직
        // API를 사용하여 출발지에서 도착지까지의 이동 시간을 가져온다.
        // 가져온 이동 시간을 commuteTime 변수에 저장한다.
    }

    public double calculateCommuteCost() {
        double commuteCost = commuteTime * hourlyWage;
        return commuteCost;
    }
}