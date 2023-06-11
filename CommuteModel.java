package commuteTime;

import commuteTime.view.input.InputLocationPanel;

import java.io.IOException;

public class CommuteModel {
    private double hourlyWage;
    private String departureLocation;
    private String destinationLocation;
    private double commuteTime;
    String duration;
    TransitAPI transitAPI;
    String departureName, destinationName;
    int fare;

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String calculateCommuteTime() throws IOException, InterruptedException {
        System.out.println("hourlyWage: " + hourlyWage);
        System.out.println("departureLocation: " + departureLocation);
        System.out.println("destinationLocation: " + destinationLocation);
        // 이동 시간 계산 로직
        // API를 사용하여 출발지에서 도착지까지의 이동 시간을 가져온다.
        // 가져온 이동 시간을 commuteTime 변수에 저장한다.

        transitAPI = new TransitAPI(departureLocation, destinationLocation);
        commuteTime = transitAPI.time/3600;
        duration = transitAPI.commuteTime;
        departureName = transitAPI.departureName;
        destinationName = transitAPI.destinationName;
        fare = transitAPI.fare;
        return duration;
    }
    public String getDepartureName() {
        return this.departureName;
    }
    public String getDestinationName() {
        return this.destinationName;
    }

    public int getFare() {
        return this.fare;
    }

    public int calculateCommuteCost() {
        int commuteCost = (int) (commuteTime * hourlyWage);
        return commuteCost;
    }
}